package com.technobright.entities;

public class ResultInfo {
	private long resultId;
	private boolean result;
	private String grade;
	private float marksGained;
	private float percentage;
	private InstSessionInfo instSessInfo;
	private StudentInfo stdInfo;
	private InstAdmin instAdmin;
	public long getResultId() {
		return resultId;
	}
	public void setResultId(long resultId) {
		this.resultId = resultId;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public float getMarksGained() {
		return marksGained;
	}
	public void setMarksGained(float marksGained) {
		this.marksGained = marksGained;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public InstSessionInfo getInstSessInfo() {
		return instSessInfo;
	}
	public void setInstSessInfo(InstSessionInfo instSessInfo) {
		this.instSessInfo = instSessInfo;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
}
