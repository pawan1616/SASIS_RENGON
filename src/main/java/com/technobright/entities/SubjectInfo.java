package com.technobright.entities;

import java.util.List;

public class SubjectInfo {
	private long subjectId;
	private String subName;
	private String subType;
//	private InstAdmin instAdmin;
//	private List<ExamInfo> examInfoList;
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	/*public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}*/
	/*public List<ExamInfo> getExamInfoList() {
		return examInfoList;
	}
	public void setExamInfoList(List<ExamInfo> examInfoList) {
		this.examInfoList = examInfoList;
	}*/
}
