package com.technobright.entities.fee;

import java.util.Date;

import com.technobright.entities.CourseInfo;

public class Installments {
	private long installmentId;
	private double amnt;
	private Date startDate;
	private Date dueDate;
	private boolean isHistory;
	private long installmentGroupId;
	private CourseInfo courseInfo;
	private FeeType feeType;
	public long getInstallmentId() {
		return installmentId;
	}
	public void setInstallmentId(long installmentId) {
		this.installmentId = installmentId;
	}
	public double getAmnt() {
		return amnt;
	}
	public void setAmnt(double amnt) {
		this.amnt = amnt;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public long getInstallmentGroupId() {
		return installmentGroupId;
	}
	public void setInstallmentGroupId(long installmentGroupId) {
		this.installmentGroupId = installmentGroupId;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public FeeType getFeeType() {
		return feeType;
	}
	public void setFeeType(FeeType feeType) {
		this.feeType = feeType;
	}
}
