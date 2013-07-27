package com.technobright.entities;

import java.util.List;

public class UserInfo {
	 private int  userUID;
	 private String userName;
	 private String password;
	 private String userType;
	 private String firstName;
	 private String lastName;
	 private String initials;
	 private String userTypeKey;
	 private UserRole usrRole;
	 private boolean isAdmin;
	 
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
	public int getUserUID() {
		return userUID;
	}
	public void setUserUID(int userUID) {
		this.userUID = userUID;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public String getUserTypeKey() {
		return userTypeKey;
	}
	public void setUserTypeKey(String userTypeKey) {
		this.userTypeKey = userTypeKey;
	}
	public UserRole getUsrRole() {
		return usrRole;
	}
	public void setUsrRole(UserRole usrRole) {
		this.usrRole = usrRole;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
