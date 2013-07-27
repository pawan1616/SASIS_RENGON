package com.technobright.entities;

public class InstAdmin_StdInfo {
	private int pkId;
	private InstAdmin instAdmin;
	private StudentInfo stdInfo;
	private boolean isActive;
	public int getPkId() {
		return pkId;
	}
	public void setPkId(int pkId) {
		this.pkId = pkId;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
