package com.technobright.entities.fee;

import java.util.Date;

import com.technobright.entities.CourseInfo;

public class TotalCourseFee {
	private long totalCourseFeeId;
	private Date startDate;
	private Date endDate;
	private Double amnt;
	private String sessionName;
	private FeeType feeType;
	private CourseInfo courseInfo;
	private int duePeriod;
	private boolean isDueMonth;
	private boolean isHistory;
	public long getTotalCourseFeeId() {
		return totalCourseFeeId;
	}
	public void setTotalCourseFeeId(long totalCourseFeeId) {
		this.totalCourseFeeId = totalCourseFeeId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getAmnt() {
		return amnt;
	}
	public void setAmnt(Double amnt) {
		this.amnt = amnt;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public FeeType getFeeType() {
		return feeType;
	}
	public void setFeeType(FeeType feeType) {
		this.feeType = feeType;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public int getDuePeriod() {
		return duePeriod;
	}
	public void setDuePeriod(int duePeriod) {
		this.duePeriod = duePeriod;
	}
	public boolean getIsDueMonth() {
		return isDueMonth;
	}
	public void setIsDueMonth(boolean isDueMonth) {
		this.isDueMonth = isDueMonth;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
}
