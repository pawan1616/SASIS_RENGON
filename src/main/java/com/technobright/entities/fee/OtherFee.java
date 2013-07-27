package com.technobright.entities.fee;

import com.technobright.entities.CourseInfo;

public class OtherFee {
	private long otherFeeId;
	private boolean isParticularStd;
	private double amnt;
	private boolean isAdd;
	private String name;
	private boolean isDivideInstallment;
	private boolean isAll;
	private CourseInfo courseInfo;
	public long getOtherFeeId() {
		return otherFeeId;
	}
	public void setOtherFeeId(long otherFeeId) {
		this.otherFeeId = otherFeeId;
	}
	public boolean isParticularStd() {
		return isParticularStd;
	}
	public void setParticularStd(boolean isParticularStd) {
		this.isParticularStd = isParticularStd;
	}
	public double getAmnt() {
		return amnt;
	}
	public void setAmnt(double amnt) {
		this.amnt = amnt;
	}
	public boolean getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(boolean isAdd) {
		this.isAdd = isAdd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsDivideInstallment() {
		return isDivideInstallment;
	}
	public void setIsDivideInstallment(boolean isDivideInstallment) {
		this.isDivideInstallment = isDivideInstallment;
	}
	public boolean getIsAll() {
		return isAll;
	}
	public void setIsAll(boolean isAll) {
		this.isAll = isAll;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	
	
}
