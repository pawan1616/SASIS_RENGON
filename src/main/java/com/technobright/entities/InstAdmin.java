package com.technobright.entities;

import java.util.List;

public class InstAdmin {
	private int adminId;
	private String schoolName;
	private String address;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String state;
	private String country;
	private String pin;
	private String email;
	private String contactNo;
	private String description;
	private String instType;
	private String userName;
	private String password;
	private List<UserInfo> userInfoList;
	private List<CourseInfo> courseInfoList;
	private List<InstAdmin_StdInfo> studentInfoList;
//	private List<SubjectInfo> subjectInfoList;
	private List<Inst_Subjects> inst_SubList;
	private int userId;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstType() {
		return instType;
	}
	public void setInstType(String instType) {
		this.instType = instType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}
	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}
	public List<InstAdmin_StdInfo> getStudentInfoList() {
		return studentInfoList;
	}
	public void setStudentInfoList(List<InstAdmin_StdInfo> studentInfoList) {
		this.studentInfoList = studentInfoList;
	}
	public List<Inst_Subjects> getInst_SubList() {
		return inst_SubList;
	}
	public void setInst_SubList(List<Inst_Subjects> inst_SubList) {
		this.inst_SubList = inst_SubList;
	}
	/*public List<SubjectInfo> getSubjectInfoList() {
		return subjectInfoList;
	}
	public void setSubjectInfoList(List<SubjectInfo> subjectInfoList) {
		this.subjectInfoList = subjectInfoList;
	}*/
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
