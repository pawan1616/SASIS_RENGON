package com.technobright.entities;

import java.util.Date;

public class StdWorkExp {
	private int workExpId;
	private boolean	isCurrentOrg;
	private String orgName;
	private String orgAddress;
	private String designation;
	private String rolesNResponsibility;
	private String projects;
	private Date startDate;
	private Date EndDate;
	private StudentInfo stdInfo;
	public int getWorkExpId() {
		return workExpId;
	}
	public void setWorkExpId(int workExpId) {
		this.workExpId = workExpId;
	}
	public boolean getIsCurrentOrg() {
		return isCurrentOrg;
	}
	public void setIsCurrentOrg(boolean isCurrentOrg) {
		this.isCurrentOrg = isCurrentOrg;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgAddress() {
		return orgAddress;
	}
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getRolesNResponsibility() {
		return rolesNResponsibility;
	}
	public void setRolesNResponsibility(String rolesNResponsibility) {
		this.rolesNResponsibility = rolesNResponsibility;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}

}
