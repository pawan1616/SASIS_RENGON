package com.technobright.entities;

import java.util.List;

public class InstSessionInfo {
	
	private long instSessInfoId;
	private String name;//or year
	private boolean isHistory;
	private boolean isAllSessionHistory;
	private CourseInfo courseInfo;
	private InstAdmin instAdmin;
	private List<ExamInfo> examInfoList;
	public long getInstSessInfoId() {
		return instSessInfoId;
	}
	public void setInstSessInfoId(long instSessInfoId) {
		this.instSessInfoId = instSessInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public boolean getIsAllSessionHistory() {
		return isAllSessionHistory;
	}
	public void setIsAllSessionHistory(boolean isAllSessionHistory) {
		this.isAllSessionHistory = isAllSessionHistory;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
	public List<ExamInfo> getExamInfoList() {
		return examInfoList;
	}
	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}
}
