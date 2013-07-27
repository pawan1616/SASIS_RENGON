package com.technobright.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.Batch_InstSess;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.ExamInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.InstSessionInfo;

public class SessionInfoAction extends ActionSupport{
	private InstSessionInfo instSessInfo;
	private List<ExamInfo> examInfoList;
	private List<CourseInfo> courseInfoList;
	private List<InstSessionInfo> instSessInfoList;
	private List<BatchInfo> batchInfoList;
	private long courseId;
	private long instSessInfoId;
	private List<Integer> examIds;
	private List<Integer> batchIds;
	private DAOInterface dao;
	private boolean isUpdate;
	private boolean isHistory;
	
	public InstSessionInfo getInstSessInfo() {
		return instSessInfo;
	}

	public void setInstSessInfo(InstSessionInfo instSessInfo) {
		this.instSessInfo = instSessInfo;
	}

	public List<ExamInfo> getExamInfoList() {
		return examInfoList;
	}

	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}

	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}

	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}

	public List<InstSessionInfo> getInstSessInfoList() {
		return instSessInfoList;
	}

	public void setInstSessInfoList(List<InstSessionInfo> instSessInfoList) {
		this.instSessInfoList = instSessInfoList;
	}

	public List<BatchInfo> getBatchInfoList() {
		return batchInfoList;
	}

	public void setBatchInfoList(List<BatchInfo> batchInfoList) {
		this.batchInfoList = batchInfoList;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getInstSessInfoId() {
		return instSessInfoId;
	}

	public void setInstSessInfoId(long instSessInfoId) {
		this.instSessInfoId = instSessInfoId;
	}

	public List<Integer> getExamIds() {
		return examIds;
	}

	public void setExamIds(List<Integer> examIds) {
		this.examIds = examIds;
	}

	public List<Integer> getBatchIds() {
		return batchIds;
	}

	public void setBatchIds(List<Integer> batchIds) {
		this.batchIds = batchIds;
	}

	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
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
		instSessInfo.setInstAdmin(instAdmin);
		List<ExamInfo> exmInfos=instSessInfo.getExamInfoList();
		for(Integer exmId:examIds){
			exmInfos.add(dao.getExamInfoById(exmId));
		}
		List<BatchInfo> batchInfoList=new ArrayList<BatchInfo>();
		for(Integer batchId:batchIds){
			batchInfoList.add(dao.getBatchinfoById(batchId));
		}
		instSessInfo.setCourseInfo(dao.getCourse((int)courseId));
		if(isUpdate)
			dao.updateObject(instSessInfo);
		else
			dao.insertObject(instSessInfo);
		for(BatchInfo btchInfo:batchInfoList){
			Batch_InstSess btchInstSess=new Batch_InstSess();
			btchInstSess.setBatchInfo(btchInfo);
			btchInstSess.setInstSess(instSessInfo);
			btchInstSess.setIsHistory(false);
			if(isUpdate){
				dao.insertOrUpdateObject(btchInstSess);
			}else{
				dao.insertObject(btchInstSess);
			}			
		}
		
		return SUCCESS;
	}
	
	public String instSessionNavigation(){
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");		
		examInfoList=dao.getExamInfos(instAdmin, false);
		courseInfoList=dao.getCourses(instAdmin, false);		
		return SUCCESS;
	}
	public String getExmNSessFromCourse(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");		
		CourseInfo crsInfo=dao.getCourse(courseId);
		examInfoList=dao.getExamInfosFromCourse(crsInfo, false);
		for(ExamInfo exmInfo:examInfoList){
			exmInfo.setExamType(null);
			exmInfo.setInstAdmin(null);
			exmInfo.setSubjectInfo(null);
			exmInfo.setInstSess(null);
			exmInfo.setCourseInfo(null);
		}
		batchInfoList=dao.getBatchFromCourse(crsInfo, instAdmin);
		for(BatchInfo btchInfo:batchInfoList){
			btchInfo.setBatch_stdInfoList(null);
			btchInfo.setCourseInfo(null);
			btchInfo.setInstAdmin(null);
			btchInfo.setInstSess(null);
		}
		return SUCCESS;
	}
	public String instSessionSummaryNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");		
//		examInfoList=dao.getExamInfos(instAdmin, false);
//		courseInfoList=dao.getCourses(instAdmin, false);		
		instSessInfoList=dao.getInstSessions(instAdmin, isHistory);
		return SUCCESS;
	}
	public String instSessionEditNavigation(){
		isUpdate=true;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");		
		examInfoList=dao.getExamInfos(instAdmin, false);
		courseInfoList=dao.getCourses(instAdmin, false);		
		instSessInfo=dao.getInstSessionById(instSessInfoId);
		List<Batch_InstSess> btchSessList=dao.getBatchSessByInstSess(instSessInfo);
		batchInfoList=new ArrayList<BatchInfo>();
		for(Batch_InstSess btchInst:btchSessList){
			batchInfoList.add(btchInst.getBatchInfo());
		}
		return SUCCESS;
	}
}
