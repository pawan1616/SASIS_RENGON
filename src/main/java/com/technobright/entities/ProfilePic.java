package com.technobright.entities;

public class ProfilePic {
	private int picId;
	private String picPath;
	private String caption;
	private StudentInfo stdInfo;
	private boolean isCurrent;
	private String picName;
	
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public boolean getIsCurrent() {
		return isCurrent;
	}
	public void setIsCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
}
