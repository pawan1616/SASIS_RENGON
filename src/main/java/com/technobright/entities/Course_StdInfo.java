package com.technobright.entities;

import java.io.Serializable;

public class Course_StdInfo implements Serializable{
	private long pkId;
	private CourseInfo courseInfo;
	private StudentInfo stdInfo;
	private boolean isActive;
	public long getPkId() {
		return pkId;
	}
	public void setPkId(long pkId) {
		this.pkId = pkId;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public boolean getisActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
