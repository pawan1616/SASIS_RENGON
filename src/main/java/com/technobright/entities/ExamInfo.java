package com.technobright.entities;

import java.util.Date;

public class ExamInfo {
	private long examId;
	private boolean isCombineExam;
	private String examName;
	private Date examDate;
	private String examPlace;
	private int examYear;
	private boolean isPercentWise; //if parent percentage wise child must percentage wise.. it is for the below pass mark or percentage only
	private float passPercentOrMark;
	private float totalMarks;
	private float percentToBeContri; //if percentage 100% both of them will be consider as separate exams
//	private float percentContriInMain; //Percentage to be contribute in the exam type or in the final according to the settings.
	private boolean isHistory;
	private boolean ifFailAllFail;
	private boolean ifFailAllCombineFail;
	private CourseInfo courseInfo;
	private ExamType examType;
	private SubjectInfo subjectInfo;
	private ExamInfo parentExam;
	private ExamInfo childExam;
	private String childExamName; //if the child exam name is empty and the exam is a child exam than the child will be appear like this Physics(child), else Physics(Practical)
	private InstAdmin instAdmin;
	private InstSessionInfo instSess;
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	public boolean getIsCombineExam() {
		return isCombineExam;
	}
	public void setIsCombineExam(boolean isCombineExam) {
		this.isCombineExam = isCombineExam;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public String getExamPlace() {
		return examPlace;
	}
	public void setExamPlace(String examPlace) {
		this.examPlace = examPlace;
	}
	public int getExamYear() {
		return examYear;
	}
	public void setExamYear(int examYear) {
		this.examYear = examYear;
	}
	public boolean getIsPercentWise() {
		return isPercentWise;
	}
	public void setIsPercentWise(boolean isPercentWise) {
		this.isPercentWise = isPercentWise;
	}
	public float getPassPercentOrMark() {
		return passPercentOrMark;
	}
	public void setPassPercentOrMark(float passPercentOrMark) {
		this.passPercentOrMark = passPercentOrMark;
	}
	public float getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(float totalMarks) {
		this.totalMarks = totalMarks;
	}
	public float getPercentToBeContri() {
		return percentToBeContri;
	}
	public void setPercentToBeContri(float percentToBeContri) {
		this.percentToBeContri = percentToBeContri;
	}
	/*public float getPercentContriInMain() {
		return percentContriInMain;
	}
	public void setPercentContriInMain(float percentContriInMain) {
		this.percentContriInMain = percentContriInMain;
	}*/
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public boolean getIfFailAllFail() {
		return ifFailAllFail;
	}
	public void setIfFailAllFail(boolean ifFailAllFail) {
		this.ifFailAllFail = ifFailAllFail;
	}
	public boolean getIfFailAllCombineFail() {
		return ifFailAllCombineFail;
	}
	public void setIfFailAllCombineFail(boolean ifFailAllCombineFail) {
		this.ifFailAllCombineFail = ifFailAllCombineFail;
	}
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}
	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public ExamType getExamType() {
		return examType;
	}
	public void setExamType(ExamType examType) {
		this.examType = examType;
	}
	public SubjectInfo getSubjectInfo() {
		return subjectInfo;
	}
	public void setSubjectInfo(SubjectInfo subjectInfo) {
		this.subjectInfo = subjectInfo;
	}
	public ExamInfo getParentExam() {
		return parentExam;
	}
	public void setParentExam(ExamInfo parentExam) {
		this.parentExam = parentExam;
	}
	public ExamInfo getChildExam() {
		return childExam;
	}
	public void setChildExam(ExamInfo childExam) {
		this.childExam = childExam;
	}
	public String getChildExamName() {
		return childExamName;
	}
	public void setChildExamName(String childExamName) {
		this.childExamName = childExamName;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
	public InstSessionInfo getInstSess() {
		return instSess;
	}
	public void setInstSess(InstSessionInfo instSess) {
		this.instSess = instSess;
	}
}
