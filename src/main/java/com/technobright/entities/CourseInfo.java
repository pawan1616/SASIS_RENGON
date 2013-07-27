package com.technobright.entities;

import java.util.Date;
import java.util.List;

public class CourseInfo {
	private long courseId;
	private String courseName;
	private String courseNameKey;
	private String courseType;
	private boolean isProfessional;
	private String courseTypeKey;
	private String totalNoOfSeat;
	private Date introducedYear;
	private Date modifiedYear;
	private CourseInfo previousCourse;
	private CourseInfo nextCourse;
	private boolean isHistory;
	private List<SubjectInfo> subjectList;
	private List<ExamType> examTypeList;
	private List<ExamInfo> examInfoList;
	private List<BatchInfo> batchInfoList;
	private InstAdmin instAdmin;
	
	//booksList
	//examTypeList
	//fkFeeTypeId
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseNameKey() {
		return courseNameKey;
	}
	public void setCourseNameKey(String courseNameKey) {
		this.courseNameKey = courseNameKey;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public boolean getIsProfessional() {
		return isProfessional;
	}
	public void setIsProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}
	public String getCourseTypeKey() {
		return courseTypeKey;
	}
	public void setCourseTypeKey(String courseTypeKey) {
		this.courseTypeKey = courseTypeKey;
	}
	public String getTotalNoOfSeat() {
		return totalNoOfSeat;
	}
	public void setTotalNoOfSeat(String totalNoOfSeat) {
		this.totalNoOfSeat = totalNoOfSeat;
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
	public CourseInfo getPreviousCourse() {
		return previousCourse;
	}
	public void setPreviousCourse(CourseInfo previousCourse) {
		this.previousCourse = previousCourse;
	}
	public CourseInfo getNextCourse() {
		return nextCourse;
	}
	public void setNextCourse(CourseInfo nextCourse) {
		this.nextCourse = nextCourse;
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
	public List<ExamType> getExamTypeList() {
		return examTypeList;
	}
	public void setExamTypeList(List<ExamType> examTypeList) {
		this.examTypeList = examTypeList;
	}
	public List<ExamInfo> getExamInfoList() {
		return examInfoList;
	}
	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}
	public List<BatchInfo> getBatchInfoList() {
		return batchInfoList;
	}
	public void setBatchInfoList(List<BatchInfo> batchInfoList) {
		this.batchInfoList = batchInfoList;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
}
