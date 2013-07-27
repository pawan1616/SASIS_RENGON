package com.technobright.entities;

import java.util.Date;
import java.util.List;

public class ExamType {
	private int examTypeId;
	private String examTypeName;
	private boolean isGrad;
	private float percentToBeContri; //Percentage to be contribute in the main exam from this exam. It will depricated in individual exams can be a null value.
	private Date introducedYear;//not in the input
	private Date modifiedYear;//not in the input
	private String extraInfo;
	private Date startTime;//start session when to be begin
	private Date endTime;//start session when to be end
	private boolean isNotify;
	private boolean isHistory; 
	private List<SubjectInfo> subjectList;
//	private List<ExamInfo> examInfoList;
	private InstAdmin instAdmin;
	public int getExamTypeId() {
		return examTypeId;
	}
	public void setExamTypeId(int examTypeId) {
		this.examTypeId = examTypeId;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public boolean getIsGrad() {
		return isGrad;
	}
	public void setIsGrad(boolean isGrad) {
		this.isGrad = isGrad;
	}
	public float getPercentToBeContri() {
		return percentToBeContri;
	}
	public void setPercentToBeContri(float percentToBeContri) {
		this.percentToBeContri = percentToBeContri;
	}
	public Date getIntroducedYear() {
		return introducedYear;
	}
	public void setIntroducedYear(Date introducedYear) {
		this.introducedYear = introducedYear;
	}
	public Date getModifiedYear() {
		return modifiedYear;
	}
	public void setModifiedYear(Date modifiedYear) {
		this.modifiedYear = modifiedYear;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public boolean getIsNotify() {
		return isNotify;
	}
	public void setIsNotify(boolean isNotify) {
		this.isNotify = isNotify;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public List<SubjectInfo> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<SubjectInfo> subjectList) {
		this.subjectList = subjectList;
	}
	/*public List<ExamInfo> getExamInfoList() {
		return examInfoList;
	}
	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}*/
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
}
