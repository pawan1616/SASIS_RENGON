package com.technobright.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.Batch_StdInfo;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.StudentInfo;

public class BatchInfoAction extends ActionSupport{
	private List<CourseInfo> crsInfoList;
	private int crsInfoId;
	private BatchInfo batchInfo;
	private int btchInfoId;
	private boolean isUpdate;
	private List<Integer> stdInfoIds;
	private List<StudentInfo> stdInfoList;
	private List<BatchInfo> batchInfoList;
	private DAOInterface dao;
	private boolean isHistory;

	public List<CourseInfo> getCrsInfoList() {
		return crsInfoList;
	}
	public void setCrsInfoList(List<CourseInfo> crsInfoList) {
		this.crsInfoList = crsInfoList;
	}
	public int getCrsInfoId() {
		return crsInfoId;
	}
	public void setCrsInfoId(int crsInfoId) {
		this.crsInfoId = crsInfoId;
	}
	public BatchInfo getBatchInfo() {
		return batchInfo;
	}
	public void setBatchInfo(BatchInfo batchInfo) {
		this.batchInfo = batchInfo;
	}
	public int getBtchInfoId() {
		return btchInfoId;
	}
	public void setBtchInfoId(int btchInfoId) {
		this.btchInfoId = btchInfoId;
	}
	public boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public List<Integer> getStdInfoIds() {
		return stdInfoIds;
	}
	public void setStdInfoIds(List<Integer> stdInfoIds) {
		this.stdInfoIds = stdInfoIds;
	}
	public List<StudentInfo> getStdInfoList() {
		return stdInfoList;
	}
	public void setStdInfoList(List<StudentInfo> stdInfoList) {
		this.stdInfoList = stdInfoList;
	}
	public List<BatchInfo> getBatchInfoList() {
		return batchInfoList;
	}
	public void setBatchInfoList(List<BatchInfo> batchInfoList) {
		this.batchInfoList = batchInfoList;
	}
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public String createBatch(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		Batch_StdInfo btch_std=new Batch_StdInfo();
		btch_std.setIsActive(true);
		try{
			for(CourseInfo crsInfo:crsInfoList){
				if(crsInfoId==crsInfo.getCourseId())
					batchInfo.setCourseInfo(crsInfo);
			}
			btch_std.setBatchInfo(batchInfo);
			batchInfo.setInstAdmin(instAdmin);
			dao.insertObject(batchInfo);
			if(!stdInfoIds.isEmpty()){
				for(Integer id:stdInfoIds){
					for(StudentInfo stdInfo:stdInfoList){
						if(stdInfo.getStdId()==id&&stdInfo.getBatch_StdInfoList().size()==0){
							btch_std.setStudentInfo(stdInfo);
							dao.insertObject(btch_std);
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String batchNavigation(){
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		crsInfoList=dao.getCourses(instAdmin,false);
		return SUCCESS;
	}
	public String fetchBtchFromCourse(){
		try {
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			CourseInfo crsInfo=dao.getCourse(crsInfoId);
			batchInfoList=dao.getBatchFromCourse(crsInfo, instAdmin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String fetchStdFromBtch(){

		try{
			if(batchInfoList!=null&&!batchInfoList.isEmpty()){
				for(BatchInfo btchInfo:batchInfoList){
					if(btchInfo.getBatchId()==btchInfoId){
						stdInfoList=dao.getActiveStdFrmBtch(btchInfo);
					}
				}
			}else{
				stdInfoList=dao.getActiveStdFrmBtch(dao.getBatchinfoById(btchInfoId));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String batchEditNavigation(){
		isUpdate=true;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		batchInfo=dao.getBatchinfoById(btchInfoId);
		crsInfoList=dao.getCourses(instAdmin,false);
		return SUCCESS;
	}
	public String batchUpdate(){
		for(CourseInfo crsInfo:crsInfoList){
			if(crsInfoId==crsInfo.getCourseId())
				batchInfo.setCourseInfo(crsInfo);
		}
		dao.updateObject(batchInfo);
		return SUCCESS;
	}
	public String batchSummmaryNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		batchInfoList=dao.getBatchList(instAdmin,isHistory);
		return SUCCESS;
	}
	public String deleteBatch(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		dao.deleteBatch(dao.getBatchinfoById(btchInfoId), instAdmin);
		return SUCCESS;
	}
}
