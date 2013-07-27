package com.technobright.entities;

import java.util.List;

public class BatchInfo {
	private long batchId;
	private String batchName;
	private int maxNoOfStd;
	private boolean isHistory;
	private CourseInfo courseInfo;
	private InstAdmin instAdmin;
	private InstSessionInfo instSess;
	private List<Batch_StdInfo> batch_stdInfoList;
	//facultyId
	public long getBatchId() {
		return batchId;
	}
	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getMaxNoOfStd() {
		return maxNoOfStd;
	}
	public void setMaxNoOfStd(int maxNoOfStd) {
		this.maxNoOfStd = maxNoOfStd;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
	public InstSessionInfo getInstSess() {
		return instSess;
	}
	public void setInstSess(InstSessionInfo instSess) {
		this.instSess = instSess;
	}
	public List<Batch_StdInfo> getBatch_stdInfoList() {
		return batch_stdInfoList;
	}
	public void setBatch_stdInfoList(List<Batch_StdInfo> batch_stdInfoList) {
		this.batch_stdInfoList = batch_stdInfoList;
	}
}
