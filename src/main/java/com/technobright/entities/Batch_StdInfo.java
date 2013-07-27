package com.technobright.entities;

public class Batch_StdInfo {
	private long pkId;
	private BatchInfo batchInfo;
	private StudentInfo studentInfo;
	private boolean isActive;
	public long getPkId() {
		return pkId;
	}
	public void setPkId(long pkId) {
		this.pkId = pkId;
	}
	public BatchInfo getBatchInfo() {
		return batchInfo;
	}
	public void setBatchInfo(BatchInfo batchInfo) {
		this.batchInfo = batchInfo;
	}
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
