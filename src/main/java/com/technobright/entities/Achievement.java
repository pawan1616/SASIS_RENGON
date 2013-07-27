package com.technobright.entities;

import java.util.Date;

public class Achievement {
	private int achieveId;
	private String achieveName;
	private String achieveDescription;
	private Date modifiedDate;
	private StudentInfo stdInfo;
	public int getAchieveId() {
		return achieveId;
	}
	public void setAchieveId(int achieveId) {
		this.achieveId = achieveId;
	}
	public String getAchieveName() {
		return achieveName;
	}
	public void setAchieveName(String achieveName) {
		this.achieveName = achieveName;
	}
	public String getAchieveDescription() {
		return achieveDescription;
	}
	public void setAchieveDescription(String achieveDescription) {
		this.achieveDescription = achieveDescription;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
}
