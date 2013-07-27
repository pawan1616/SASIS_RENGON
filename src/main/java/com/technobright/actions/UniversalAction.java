package com.technobright.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.StudentInfo;

public class UniversalAction extends ActionSupport{

	private int courseId;
	private List<BatchInfo> batchInfoList;
	private List<StudentInfo> studentInfoList;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public List<BatchInfo> getBatchInfoList() {
		return batchInfoList;
	}
	public void setBatchInfoList(List<BatchInfo> batchInfoList) {
		this.batchInfoList = batchInfoList;
	}
	public List<StudentInfo> getStudentInfoList() {
		return studentInfoList;
	}
	public void setStudentInfoList(List<StudentInfo> studentInfoList) {
		this.studentInfoList = studentInfoList;
	}
	public String getStdFromCourse(){
		
		return SUCCESS;
	}
}
