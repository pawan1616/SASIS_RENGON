package com.technobright.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.ExamInfo;
import com.technobright.entities.ExamType;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.SubjectInfo;

public class ExamInfoAction extends ActionSupport{
	
	private DAOInterface dao;
	
	private ExamInfo examInfo;
	private long courseInfoId;
	private int examtypeId;
	private int subjectId;
	private boolean isUpdate;
	private long examId;
	private List<CourseInfo> courseInfoList;
	private List<ExamType> examtypeList;
	private List<SubjectInfo> subjectInfoList;
	private List<ExamInfo> fetchedExamInfos;
	private boolean isHistory;
	
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public ExamInfo getExamInfo() {
		return examInfo;
	}
	public void setExamInfo(ExamInfo examInfo) {
		this.examInfo = examInfo;
	}
	public long getCourseInfoId() {
		return courseInfoId;
	}
	public void setCourseInfoId(long courseInfoId) {
		this.courseInfoId = courseInfoId;
	}

	public int getExamtypeId() {
		return examtypeId;
	}
	public void setExamtypeId(int examtypeId) {
		this.examtypeId = examtypeId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}
	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}
	public List<ExamType> getExamtypeList() {
		return examtypeList;
	}
	public void setExamtypeList(List<ExamType> examtypeList) {
		this.examtypeList = examtypeList;
	}
	public List<SubjectInfo> getSubjectInfoList() {
		return subjectInfoList;
	}
	public void setSubjectInfoList(List<SubjectInfo> subjectInfoList) {
		this.subjectInfoList = subjectInfoList;
	}
	public List<ExamInfo> getFetchedExamInfos() {
		return fetchedExamInfos;
	}
	public void setFetchedExamInfos(List<ExamInfo> fetchedExamInfos) {
		this.fetchedExamInfos = fetchedExamInfos;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		for(CourseInfo crsInfo:courseInfoList){
			if(crsInfo.getCourseId()==courseInfoId){
				examInfo.setCourseInfo(crsInfo);
			}
		}
		for (ExamType exmType:examtypeList) {
			if(exmType.getExamTypeId()==examtypeId){
				examInfo.setExamType(exmType);
			}
		}
		for(SubjectInfo subInfo:subjectInfoList){
			if(subInfo.getSubjectId()==subjectId){
				examInfo.setSubjectInfo(subInfo);
			}
		}
		examInfo.setInstAdmin(instAdmin);
		if(isUpdate)
			dao.updateObject(examInfo);
		else
			dao.insertObject(examInfo);
		return SUCCESS;
	}
	
	public String examInfoNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		courseInfoList=dao.getCourses(instAdmin,false);
		examtypeList=courseInfoList.get(0).getExamTypeList();
		subjectInfoList=examtypeList.get(0).getSubjectList();
		return SUCCESS;
	}
	public String getExmTypeByCourse(){
		CourseInfo crsInfo=dao.getCourse(courseInfoId);
		examtypeList=crsInfo.getExamTypeList();
		for(ExamType exmTyp:examtypeList){
			exmTyp.setInstAdmin(null);
			exmTyp.setSubjectList(null);
		}
		return SUCCESS;
	}
	public String getSubFromExmType(){
		ExamType exmTyp=dao.getExamType(examtypeId);
		subjectInfoList=exmTyp.getSubjectList();
		return SUCCESS;
	}
	public String examInfoSummaryNavigation(){
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		fetchedExamInfos=dao.getExamInfos(instAdmin,isHistory);
		return SUCCESS;
	}
	public String examInfoUpdateNavigation(){
		isUpdate=true;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		courseInfoList=dao.getCourses(instAdmin,false);
		examtypeList=dao.getExamTypes(instAdmin,false);
		subjectInfoList=dao.getAllSubjects(instAdmin);
		examInfo=dao.getExamInfoById(examId);
		return SUCCESS;
	}
	public String updateExamInfo(){
		isUpdate=true;
		execute();
		return SUCCESS;
	}
}
