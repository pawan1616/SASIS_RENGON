package com.technobright.entities;

import java.util.List;

public class UserRole {
	private int usrRoleId;
	private String roleName;
	private String roleDescription;
	private List<Page> pagesList;
	private List<UserPreference> userPreferenceList;
	private List<UserInfo> usrInfoList;
	private String homePage;
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	public int getUsrRoleId() {
		return usrRoleId;
	}
	public void setUsrRoleId(int usrRoleId) {
		this.usrRoleId = usrRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public List<Page> getPagesList() {
		return pagesList;
	}
	public void setPagesList(List<Page> pagesList) {
		this.pagesList = pagesList;
	}
	public List<UserPreference> getUserPreferenceList() {
		return userPreferenceList;
	}
	public void setUserPreferenceList(List<UserPreference> userPreferenceList) {
		this.userPreferenceList = userPreferenceList;
	}
	public List<UserInfo> getUsrInfoList() {
		return usrInfoList;
	}
	public void setUsrInfoList(List<UserInfo> usrInfoList) {
		this.usrInfoList = usrInfoList;
	}
}
