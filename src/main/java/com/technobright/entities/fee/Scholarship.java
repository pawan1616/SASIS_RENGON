package com.technobright.entities.fee;

import com.technobright.entities.BatchInfo;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.InstSessionInfo;
import com.technobright.entities.StudentInfo;

public class Scholarship {
	private long scholarshipId;
	private double amnt;
	private boolean isDivide;
	private CourseInfo courseInfo;
	private InstSessionInfo instSession;
	private BatchInfo batchInfo;
	private StudentInfo stdInfo;
	public long getScholarshipId() {
		return scholarshipId;
	}
	public void setScholarshipId(long scholarshipId) {
		this.scholarshipId = scholarshipId;
	}
	public double getAmnt() {
		return amnt;
	}
	public void setAmnt(double amnt) {
		this.amnt = amnt;
	}
	public boolean getIsDivide() {
		return isDivide;
	}
	public void setIsDivide(boolean isDivide) {
		this.isDivide = isDivide;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public InstSessionInfo getInstSession() {
		return instSession;
	}
	public void setInstSession(InstSessionInfo instSession) {
		this.instSession = instSession;
	}
	public BatchInfo getBatchInfo() {
		return batchInfo;
	}
	public void setBatchInfo(BatchInfo batchInfo) {
		this.batchInfo = batchInfo;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	
}
