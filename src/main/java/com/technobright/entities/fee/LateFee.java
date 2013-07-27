package com.technobright.entities.fee;

import com.technobright.entities.CourseInfo;

public class LateFee {
	private long lateFeeId;
	private double amnt;
	private int appliedAfter;
	private boolean isAppliedAfterMonth;
	private float increaseAmnt;
	private int increaseAfter;
	private boolean isIncreaseMonth;
	private FeeType feeType;
	private CourseInfo courseInfo;
	public long getLateFeeId() {
		return lateFeeId;
	}
	public void setLateFeeId(long lateFeeId) {
		this.lateFeeId = lateFeeId;
	}
	public double getAmnt() {
		return amnt;
	}
	public void setAmnt(double amnt) {
		this.amnt = amnt;
	}
	public int getAppliedAfter() {
		return appliedAfter;
	}
	public void setAppliedAfter(int appliedAfter) {
		this.appliedAfter = appliedAfter;
	}
	public boolean getIsAppliedAfterMonth() {
		return isAppliedAfterMonth;
	}
	public void setIsAppliedAfterMonth(boolean isAppliedAfterMonth) {
		this.isAppliedAfterMonth = isAppliedAfterMonth;
	}
	public float getIncreaseAmnt() {
		return increaseAmnt;
	}
	public int getIncreaseAfter() {
		return increaseAfter;
	}
	public void setIncreaseAfter(int increaseAfter) {
		this.increaseAfter = increaseAfter;
	}
	public void setIsIncreaseAmnt(float increaseAmnt) {
		this.increaseAmnt = increaseAmnt;
	}
	public boolean getIsIncreaseMonth() {
		return isIncreaseMonth;
	}
	public void setIncreaseMonth(boolean isIncreaseMonth) {
		this.isIncreaseMonth = isIncreaseMonth;
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
}
