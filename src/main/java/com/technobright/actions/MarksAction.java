package com.technobright.actions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.Batch_InstSess;
import com.technobright.entities.Batch_StdInfo;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.ExamInfo;
import com.technobright.entities.ExamType;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.InstSessionInfo;
import com.technobright.entities.MarksInfo;
import com.technobright.entities.ResultInfo;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.SubjectInfo;
import com.technobright.entities.UserInfo;

public class MarksAction extends ActionSupport{

	private DAOInterface dao;
	private MarksInfo marksInfo;
	private long stdId;
	private long exmId;
	private long btchInfoId;
	private long courseId;
	private long instSessId;
	private String sessFetchTyp;
	private ResultInfo resInfo;
	private BatchInfo btchInfo;
	private boolean isUpdate;
	private long markId;
	private boolean isProfessional;
	private String userUID;
	private List<ExamInfo> examInfoList;
	private List<ExamType> examTypeList;
	private List<CourseInfo> courseInfoList;
	private List<BatchInfo> batchInfoList;
	private List<SubjectInfo> subjectInfoList;
	private List<InstAdmin> instAdminList;
	private List<MarksInfo> marksInfoList;
	private List<ResultInfo> resultInfoList;
	private Map<Long, List<MarksInfo>> marksSubwise;
	private List<InstSessionInfo> instSessList;
	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}

	public MarksInfo getMarksInfo() {
		return marksInfo;
	}

	public void setMarksInfo(MarksInfo marksInfo) {
		this.marksInfo = marksInfo;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	public long getExmId() {
		return exmId;
	}

	public void setExmId(long exmId) {
		this.exmId = exmId;
	}

	public long getBtchInfoId() {
		return btchInfoId;
	}

	public void setBtchInfoId(long btchInfoId) {
		this.btchInfoId = btchInfoId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getInstSessId() {
		return instSessId;
	}

	public void setInstSessId(long instSessId) {
		this.instSessId = instSessId;
	}

	public String getSessFetchTyp() {
		return sessFetchTyp;
	}

	public void setSessFetchTyp(String sessFetchTyp) {
		this.sessFetchTyp = sessFetchTyp;
	}

	public ResultInfo getResInfo() {
		return resInfo;
	}

	public void setResInfo(ResultInfo resInfo) {
		this.resInfo = resInfo;
	}

	public BatchInfo getBtchInfo() {
		return btchInfo;
	}

	public void setBtchInfo(BatchInfo btchInfo) {
		this.btchInfo = btchInfo;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public long getMarkId() {
		return markId;
	}

	public void setMarkId(long markId) {
		this.markId = markId;
	}

	public boolean getIsProfessional() {
		return isProfessional;
	}

	public void setIsProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}

	public String getUserUID() {
		return userUID;
	}

	public void setUserUID(String userUID) {
		this.userUID = userUID;
	}

	public List<ExamInfo> getExamInfoList() {
		return examInfoList;
	}

	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}

	public List<ExamType> getExamTypeList() {
		return examTypeList;
	}

	public void setExamTypeList(List<ExamType> examTypeList) {
		this.examTypeList = examTypeList;
	}

	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}

	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}

	public List<BatchInfo> getBatchInfoList() {
		return batchInfoList;
	}

	public void setBatchInfoList(List<BatchInfo> batchInfoList) {
		this.batchInfoList = batchInfoList;
	}

	public List<SubjectInfo> getSubjectInfoList() {
		return subjectInfoList;
	}

	public void setSubjectInfoList(List<SubjectInfo> subjectInfoList) {
		this.subjectInfoList = subjectInfoList;
	}

	public List<InstAdmin> getInstAdminList() {
		return instAdminList;
	}

	public void setInstAdminList(List<InstAdmin> instAdminList) {
		this.instAdminList = instAdminList;
	}

	public List<MarksInfo> getMarksInfoList() {
		return marksInfoList;
	}

	public void setMarksInfoList(List<MarksInfo> marksInfoList) {
		this.marksInfoList = marksInfoList;
	}

	public List<ResultInfo> getResultInfoList() {
		return resultInfoList;
	}

	public void setResultInfoList(List<ResultInfo> resultInfoList) {
		this.resultInfoList = resultInfoList;
	}

	public Map<Long, List<MarksInfo>> getMarksSubwise() {
		return marksSubwise;
	}

	public void setMarksSubwise(Map<Long, List<MarksInfo>> marksSubwise) {
		this.marksSubwise = marksSubwise;
	}

	public List<InstSessionInfo> getInstSessList() {
		return instSessList;
	}

	public void setInstSessList(List<InstSessionInfo> instSessList) {
		this.instSessList = instSessList;
	}

	public String execute(){
		try{
			BatchInfo btchInfo=dao.getBatchinfoById(btchInfoId);
			for(StudentInfo stdInfo:dao.getActiveStdFrmBtch(btchInfo)){
				if(stdInfo.getStdId()==stdId)
					marksInfo.setStdInfo(stdInfo);
			}
			marksInfo.setExamInfo(dao.getExamInfoById(exmId));
			ExamInfo exmInfo=marksInfo.getExamInfo();
			if(exmInfo.getIsPercentWise()){
				float markPercentage=(marksInfo.getMarksObtained()*100)/exmInfo.getTotalMarks();
				if(markPercentage>=exmInfo.getPassPercentOrMark())
					marksInfo.setResult(true);
				else
					marksInfo.setResult(false);
			}else{
				if(marksInfo.getMarksObtained()>=exmInfo.getPassPercentOrMark())
					marksInfo.setResult(true);
				else
					marksInfo.setResult(false);
			}
			if(isUpdate)
				dao.updateObject(marksInfo);
			else
				dao.insertObject(marksInfo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String updateMarksNavigation(){
		isUpdate=true;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
//		examInfoList=dao.getExamInfos(instAdmin, false);
		courseInfoList=dao.getCourses(instAdmin,false);
		subjectInfoList=dao.getAllSubjects(instAdmin);
		marksInfo=dao.getMarksInfoById(markId);
		
		InstSessionInfo instSess=marksInfo.getExamInfo().getInstSess();
		btchInfo=dao.getBatchSessByInstSess(instSess).get(0).getBatchInfo();
		this.btchInfo.setBatch_stdInfoList(null);
		this.btchInfo.setCourseInfo(null);
		this.btchInfo.setInstAdmin(null);
		this.btchInfo.setInstSess(null);
//		List<Batch_StdInfo> btchStdList=marksInfo.getStdInfo().getBatch_StdInfoList();
		/*for(Batch_StdInfo btchInfo:btchStdList){
			if(btchInfo.getBatchInfo().getCourseInfo().getCourseId()==marksInfo.getExamInfo().getCourseInfo().getCourseId()){
				this.btchInfo=btchInfo.getBatchInfo();
				this.btchInfo.setBatch_stdInfoList(null);
				this.btchInfo.setCourseInfo(null);
				this.btchInfo.setInstAdmin(null);
				this.btchInfo.setInstSess(null);
			}
		}*/
		return SUCCESS;
	}
	public String updateMarks(){
		try{
			BatchInfo btchInfo=dao.getBatchinfoById(btchInfoId);
			for(StudentInfo stdInfo:dao.getActiveStdFrmBtch(btchInfo)){
				if(stdInfo.getStdId()==stdId)
					marksInfo.setStdInfo(stdInfo);
			}
			marksInfo.setExamInfo(dao.getExamInfoById(exmId));
			ExamInfo exmInfo=marksInfo.getExamInfo();
			if(exmInfo.getIsPercentWise()){
				float markPercentage=(marksInfo.getMarksObtained()*100)/exmInfo.getTotalMarks();
				if(markPercentage>=exmInfo.getPassPercentOrMark())
					marksInfo.setResult(true);
				else
					marksInfo.setResult(false);
			}else{
				if(marksInfo.getMarksObtained()>=exmInfo.getPassPercentOrMark())
					marksInfo.setResult(true);
				else
					marksInfo.setResult(false);
			}
			dao.updateObject(marksInfo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String marksCreationNavigation(){
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		examInfoList=dao.getExamInfos(instAdmin, false);
		courseInfoList=dao.getCourses(instAdmin,false);
		subjectInfoList=dao.getAllSubjects(instAdmin);
		return SUCCESS;
	}
	public String editMarksNavigation(){
		isUpdate=true;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		courseInfoList=dao.getCourses(instAdmin,false);
		subjectInfoList=dao.getAllSubjects(instAdmin);
		return SUCCESS;
	}
	public String stdMarksPVNavigation(){
		isProfessional=false;
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
		if(stdInfo==null){
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			List<InstAdmin> instList=new ArrayList<InstAdmin>();
			instList.add(instAdmin);
			instAdminList=instList;
		}else
			instAdminList=dao.getStdInstList(stdInfo);
		//		courseInfoList=dao.getStdCourseList(stdInfo);
		//		subjectInfoList=courseInfoList.get(0).getSubjectList();
		return SUCCESS;
	}
	public String subNExamFromCourse(){
		try{
			Map session = ActionContext.getContext().getSession();
			StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
			if(stdInfo==null){
				UserInfo usrInfo=dao.getUserInfo(userUID);
				stdInfo=dao.getStdInfoByUsr(usrInfo);
			}
			CourseInfo courseInfo=dao.getCourse(courseId);
			subjectInfoList=courseInfo.getSubjectList();
			examTypeList=courseInfo.getExamTypeList();
			instSessList=dao.getInstSessionsForStd(stdInfo, courseInfo);
			if(instSessList!=null&&!instSessList.isEmpty()){
				marksInfoList=dao.getMarksInfoByCourse(stdInfo, courseInfo,instSessList.get(0));
				resInfo=dao.getResultInfoBySessNStd(stdInfo, instSessList.get(0));
			}
			if(examTypeList!=null&&!examTypeList.isEmpty()){
				for(ExamType exmType:examTypeList){
					exmType.setInstAdmin(null);
					exmType.setSubjectList(null);
				}
			}			
			if(marksInfoList!=null&&!marksInfoList.isEmpty()){
				for(MarksInfo mrkInfo:marksInfoList){
					mrkInfo.setStdInfo(null);
					mrkInfo.getExamInfo().setCourseInfo(null);
					mrkInfo.getExamInfo().setInstAdmin(null);
					mrkInfo.getExamInfo().getExamType().setInstAdmin(null);
				}
			}
			if(resultInfoList!=null&&!resultInfoList.isEmpty()){
				for(ResultInfo resInfo:resultInfoList){
					resInfo.setInstAdmin(null);
					resInfo.getInstSessInfo().setCourseInfo(null);
					resInfo.getInstSessInfo().setExamInfoList(null);
					resInfo.getInstSessInfo().setInstAdmin(null);
				}
			}
			marksSubwise=new LinkedHashMap<Long, List<MarksInfo>>();
			for(SubjectInfo subInfo: subjectInfoList){
				List<MarksInfo> subMrkList=new ArrayList<MarksInfo>();
				for(MarksInfo mrkInfo:marksInfoList){
					if(mrkInfo.getExamInfo().getSubjectInfo().getSubjectId()==subInfo.getSubjectId()){
						subMrkList.add(mrkInfo);
					}
				}
				if(subMrkList!=null&&!subMrkList.isEmpty())
					marksSubwise.put(subInfo.getSubjectId(), subMrkList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String stdMarksFromSess(){
		isUpdate=false;
		try{
			Map session = ActionContext.getContext().getSession();
			StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
			if(stdInfo==null){
				UserInfo usrInfo=dao.getUserInfo(userUID);
				stdInfo=dao.getStdInfoByUsr(usrInfo);
			}
			CourseInfo courseInfo=dao.getCourse(courseId);
			subjectInfoList=courseInfo.getSubjectList();
			examTypeList=courseInfo.getExamTypeList();
			resInfo=dao.getResultInfoBySessNStd(stdInfo, dao.getInstSessionById(instSessId));
			marksInfoList=dao.getMarksInfoByCourse(stdInfo, courseInfo,dao.getInstSessionById(instSessId));
			marksSubwise=new LinkedHashMap<Long, List<MarksInfo>>();
			for(SubjectInfo subInfo: subjectInfoList){
				List<MarksInfo> subMrkList=new ArrayList<MarksInfo>();
				for(MarksInfo mrkInfo:marksInfoList){
					if(mrkInfo.getExamInfo().getSubjectInfo().getSubjectId()==subInfo.getSubjectId()){
						subMrkList.add(mrkInfo);
					}
				}
				if(subMrkList!=null&&!subMrkList.isEmpty())
					marksSubwise.put(subInfo.getSubjectId(), subMrkList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String fetchEditableMarks(){
		try{
			Map session = ActionContext.getContext().getSession();
			StudentInfo stdInfo=dao.getStdInfoById(stdId);
			CourseInfo courseInfo=dao.getCourse(courseId);
			subjectInfoList=courseInfo.getSubjectList();
			examTypeList=courseInfo.getExamTypeList();
			resInfo=dao.getResultInfoBySessNStd(stdInfo, dao.getInstSessionById(instSessId));
			marksInfoList=dao.getMarksInfoByCourse(stdInfo, courseInfo,dao.getInstSessionById(instSessId));
			marksSubwise=new LinkedHashMap<Long, List<MarksInfo>>();
			for(SubjectInfo subInfo: subjectInfoList){
				List<MarksInfo> subMrkList=new ArrayList<MarksInfo>();
				for(MarksInfo mrkInfo:marksInfoList){
					if(mrkInfo.getExamInfo().getSubjectInfo().getSubjectId()==subInfo.getSubjectId()){
						subMrkList.add(mrkInfo);
					}
				}
				if(subMrkList!=null&&!subMrkList.isEmpty())
					marksSubwise.put(subInfo.getSubjectId(), subMrkList);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String instSessFromCourse(){
		Map session = ActionContext.getContext().getSession();
		StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
		if(stdInfo==null||stdInfo.getStdId()<=0)
			stdInfo=dao.getStdInfoById(stdId);
		if(stdId<=0){
			stdInfo=dao.getStdInfoByUsr(dao.getUserInfo(userUID));
		}
		CourseInfo courseInfo=dao.getCourse(courseId);
		instSessList=dao.getInstSessionsByCourse(courseInfo);
		if(instSessList!=null&&!instSessList.isEmpty()){
			Set<InstSessionInfo> instSessSet=new LinkedHashSet<InstSessionInfo>();
			for(InstSessionInfo instSess:instSessList){
				if(instSess.getCourseInfo().getCourseId()==courseId){
					instSess.setCourseInfo(null);
					instSess.setExamInfoList(null);
					instSess.setInstAdmin(null);
					instSessSet.add(instSess);
				}
			}
			instSessList=new ArrayList<InstSessionInfo>();
			instSessList.addAll(instSessSet);
			stdId=0;
			userUID="";
		}
		return SUCCESS;

	}
	public String activeInstSessFromCourse(){		
		/*		Map session = ActionContext.getContext().getSession();
		StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
		if(stdInfo==null||stdInfo.getStdId()<=0)
			stdInfo=dao.getStdInfoById(stdId);1*/
		CourseInfo courseInfo=dao.getCourse(courseId);
		if(sessFetchTyp!=null&&sessFetchTyp.equalsIgnoreCase("active"))
			instSessList=dao.getInstSessionsByCourse(courseInfo,false);
		else if(sessFetchTyp!=null&&sessFetchTyp.equalsIgnoreCase("all"))
			instSessList=dao.getInstSessionsByCourse(courseInfo);
		if(instSessList!=null&&!instSessList.isEmpty()){
			for(InstSessionInfo instSess:instSessList){
				if(instSess.getCourseInfo().getCourseId()==courseId){
					instSess.setCourseInfo(null);
					instSess.setExamInfoList(null);
					instSess.setInstAdmin(null);
				}
			}
		}
		return SUCCESS;
	}
	public String batchFromSess(){
		InstSessionInfo instSess=dao.getInstSessionById(instSessId);
		List<Batch_InstSess> btchSessList=new ArrayList<Batch_InstSess>();
		if(sessFetchTyp.equalsIgnoreCase("active"))
			btchSessList=dao.getBatchSessByInstSess(instSess, false);
		else if(sessFetchTyp.equalsIgnoreCase("all"))
			btchSessList=dao.getBatchSessByInstSess(instSess);
		batchInfoList=new ArrayList<BatchInfo>();
		if(btchSessList!=null&&!btchSessList.isEmpty()){
			for(Batch_InstSess btchSess:btchSessList){
				BatchInfo btchInfo=btchSess.getBatchInfo();
				btchInfo.setBatch_stdInfoList(null);
				btchInfo.setCourseInfo(null);
				btchInfo.setInstAdmin(null);
				btchInfo.setInstSess(null);
				batchInfoList.add(btchInfo);
			}
		}
		return SUCCESS;
	}
	public String stdProfessionalQualNavigation(){
		Map session = ActionContext.getContext().getSession();
		StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
		isProfessional=true;
		courseInfoList=dao.getProfessionalCourseList(stdInfo);

		return SUCCESS;
	}
}
