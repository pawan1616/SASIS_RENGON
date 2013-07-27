package com.technobright.entities;

public class Inst_Subjects {
	private int pkId;
	private InstAdmin instAdmin;
	private SubjectInfo subInfo;
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
	public SubjectInfo getSubInfo() {
		return subInfo;
	}
	public void setSubInfo(SubjectInfo subInfo) {
		this.subInfo = subInfo;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
