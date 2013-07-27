package com.technobright.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.ErrorMsgTransporter;
import com.technobright.entities.ExamInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.Inst_Subjects;
import com.technobright.entities.SubjectInfo;
import com.technobright.entities.UserInfo;

public class SubjectAction extends ActionSupport implements ServletRequestAware{
	
	private DAOInterface dao;
	private SubjectInfo subjectInfo;
	private HttpServletRequest request;
	private List<SubjectInfo> allSubjects;
	private List<ExamInfo> examInfoList;
	private long subId;
	private long courseId;
	private String fetchReq;
	private ErrorMsgTransporter errMsgTrans;
	private List<SubjectInfo> subInfoList;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}

	public SubjectInfo getSubjectInfo() {
		return subjectInfo;
	}

	public void setSubjectInfo(SubjectInfo subjectInfo) {
		this.subjectInfo = subjectInfo;
	}
	
	public List getAllSubjects() {
		return allSubjects;
	}

	public void setAllSubjects(List allSubjects) {
		this.allSubjects = allSubjects;
	}

	public List<ExamInfo> getExamInfoList() {
		return examInfoList;
	}

	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}

	public long getSubId() {
		return subId;
	}

	public void setSubId(long subId) {
		this.subId = subId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getFetchReq() {
		return fetchReq;
	}

	public void setFetchReq(String fetchReq) {
		this.fetchReq = fetchReq;
	}

	public ErrorMsgTransporter getErrMsgTrans() {
		return errMsgTrans;
	}

	public void setErrMsgTrans(ErrorMsgTransporter errMsgTrans) {
		this.errMsgTrans = errMsgTrans;
	}

	public List<SubjectInfo> getSubInfoList() {
		return subInfoList;
	}

	public void setSubInfoList(List<SubjectInfo> subInfoList) {
		this.subInfoList = subInfoList;
	}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		Inst_Subjects instSubs=new Inst_Subjects();
		instSubs.setInstAdmin(instAdmin);
		SubjectInfo checkSubjectInfo=dao.getSubjectExist(subjectInfo);
		if(checkSubjectInfo==null){
			dao.insertCompleteEntity(subjectInfo);
			instSubs.setSubInfo(subjectInfo);
		}else{
			if(dao.instSubjsExist(instAdmin, checkSubjectInfo)){
				errMsgTrans.setIsErrorIn(true);
				errMsgTrans.getErrMsg().put("subjectInfo.subName", "Duplicate Entry");
				errMsgTrans.getErrMsg().put("subjectInfo.subType", "Duplicate Entry");
				return INPUT;
			}else{				
				instSubs.setSubInfo(checkSubjectInfo);
			}
		}		
		instSubs.setIsActive(true);
		dao.insertObject(instSubs);
		allSubjects=dao.getAllSubjects(instAdmin);
		return SUCCESS;
	}
	public String subNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		allSubjects=dao.getAllSubjects(instAdmin);
		return SUCCESS;
	}
	public String subDelete(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		subjectInfo=dao.getSubjectById(subId);
		dao.deleteSubject(subjectInfo,instAdmin);		
		allSubjects=dao.getAllSubjects(instAdmin);
		return SUCCESS;
	}
	public String fetchSubFromCourse(){
		try {
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			CourseInfo crsInfo=dao.getCourse((int)courseId);
			subInfoList=crsInfo.getSubjectList();
			/*for(SubjectInfo subInfo:dao.getAllSubjects(instAdmin)){
				if(subInfo.getSubjectId()==subId)
					examInfoList=subInfo.getExamInfoList();
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String fetchExamFromSub(){
		try {
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			SubjectInfo subInfo=dao.getSubjectById(subId);
			if(fetchReq.equalsIgnoreCase("new"))
				examInfoList=dao.getExamInfoFromSubject(instAdmin, subInfo,false);
			else if(fetchReq.equalsIgnoreCase("all"))
				examInfoList=dao.getExamInfoFromSubject(instAdmin, subInfo);
			for(ExamInfo exmInfo:examInfoList){
				exmInfo.setCourseInfo(null);
				exmInfo.setInstAdmin(null);
				exmInfo.setSubjectInfo(null);
				exmInfo.setExamType(null);
				exmInfo.setInstSess(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
