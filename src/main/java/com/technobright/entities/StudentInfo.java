package com.technobright.entities;

import java.util.Date;
import java.util.List;

public class StudentInfo {
	private long stdId;
	private String firstName;
	private String lastName;
	private String initials;
	private String fathersName;
	private String mothersName;
	private String sex;
	private Date dob;
	private String fathersProfess;
	private String mothersProfess;
	private Double monthlyIncome;
	private String addLine1;
	private String addLine2;
	private String city;
	private String state;
	private String country;
	private String stdPhoneNo;
	private String stdMobileNo;
	private String stdEmail;
	private String parentPhoneNo;
	private String parentMobileNo;
	private String parentEmail;
	private String fax;
	private String aboutMe;
	private List<InstAdmin_StdInfo> instAdminList;
	private List<Course_StdInfo> course_StdInfoList;
	private List<MarksInfo> marksInfoList;
	private List<Batch_StdInfo> batch_StdInfoList;
	private UserInfo userInfo;
	public long getStdId() {
		return stdId;
	}
	public void setStdId(long stdId) {
		this.stdId = stdId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getFathersProfess() {
		return fathersProfess;
	}
	public void setFathersProfess(String fathersProfess) {
		this.fathersProfess = fathersProfess;
	}
	public String getMothersProfess() {
		return mothersProfess;
	}
	public void setMothersProfess(String mothersProfess) {
		this.mothersProfess = mothersProfess;
	}
	public Double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getAddLine1() {
		return addLine1;
	}
	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}
	public String getAddLine2() {
		return addLine2;
	}
	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
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
	public String getStdPhoneNo() {
		return stdPhoneNo;
	}
	public void setStdPhoneNo(String stdPhoneNo) {
		this.stdPhoneNo = stdPhoneNo;
	}
	public String getStdMobileNo() {
		return stdMobileNo;
	}
	public void setStdMobileNo(String stdMobileNo) {
		this.stdMobileNo = stdMobileNo;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public String getParentPhoneNo() {
		return parentPhoneNo;
	}
	public void setParentPhoneNo(String parentPhoneNo) {
		this.parentPhoneNo = parentPhoneNo;
	}
	public String getParentMobileNo() {
		return parentMobileNo;
	}
	public void setParentMobileNo(String parentMobileNo) {
		this.parentMobileNo = parentMobileNo;
	}
	public String getParentEmail() {
		return parentEmail;
	}
	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}
	public String getFax() {
		return fax;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public List<InstAdmin_StdInfo> getInstAdminList() {
		return instAdminList;
	}
	public void setInstAdminList(List<InstAdmin_StdInfo> instAdminList) {
		this.instAdminList = instAdminList;
	}
	public List<Course_StdInfo> getCourse_StdInfoList() {
		return course_StdInfoList;
	}
	public void setCourse_StdInfoList(List<Course_StdInfo> course_StdInfoList) {
		this.course_StdInfoList = course_StdInfoList;
	}
	public List<MarksInfo> getMarksInfoList() {
		return marksInfoList;
	}
	public void setMarksInfoList(List<MarksInfo> marksInfoList) {
		this.marksInfoList = marksInfoList;
	}
	public List<Batch_StdInfo> getBatch_StdInfoList() {
		return batch_StdInfoList;
	}
	public void setBatch_StdInfoList(List<Batch_StdInfo> batch_StdInfoList) {
		this.batch_StdInfoList = batch_StdInfoList;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public String getMaleChecked() {
		if(sex.equalsIgnoreCase("Male"))
			return "Checked";
		else
			return "";
	}
	public String getFemaleChecked() {
		if(sex.equalsIgnoreCase("Female"))
			return "Checked";
		else
			return "";
	}
	public String getOtherChecked() {
		if(sex.equalsIgnoreCase("Others"))
			return "Checked";
		else
			return "";
	}

}
