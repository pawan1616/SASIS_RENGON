package com.technobright.entities;

public class MarksInfo {
	private long markId;
	private float marksObtained;
	private boolean result;
	private boolean combineResult;
	private String remarks;
	private StudentInfo stdInfo;
	private ExamInfo examInfo;
//	fkFacultyId
	public long getMarkId() {
		return markId;
	}
	public void setMarkId(long markId) {
		this.markId = markId;
	}
	public float getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(float marksObtained) {
		this.marksObtained = marksObtained;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public boolean getCombineResult() {
		return combineResult;
	}
	public void setCombineResult(boolean combineResult) {
		this.combineResult = combineResult;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public ExamInfo getExamInfo() {
		return examInfo;
	}
	public void setExamInfo(ExamInfo examInfo) {
		this.examInfo = examInfo;
	}
}
