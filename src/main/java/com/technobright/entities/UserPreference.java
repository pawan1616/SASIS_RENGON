package com.technobright.entities;

public class UserPreference {
	private int usrPrefId;
	private String userPreferenceName;
	private String usrPrefGroup;
	private String actionName;
	private String description;
	private String type;
	
	public int getUsrPrefId() {
		return usrPrefId;
	}
	public void setUsrPrefId(int usrPrefId) {
		this.usrPrefId = usrPrefId;
	}
	public String getUserPreferenceName() {
		return userPreferenceName;
	}
	public void setUserPreferenceName(String userPreferenceName) {
		this.userPreferenceName = userPreferenceName;
	}
	public String getUsrPrefGroup() {
		return usrPrefGroup;
	}
	public void setUsrPrefGroup(String usrPrefGroup) {
		this.usrPrefGroup = usrPrefGroup;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
