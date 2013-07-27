package com.technobright.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.UserInfo;
import com.technobright.entities.UserRole;

public class CreateAccountAction extends ActionSupport{
	private UserInfo usrInfo;
	private String confirmPassword;
	private List<UserRole> userRoles;
	private int roleId;
	private List<UserInfo> usrInfos;
	private boolean editable;
	
	private DAOInterface dao;

	public UserInfo getUsrInfo() {
		return usrInfo;
	}
	public void setUsrInfo(UserInfo usrInfo) {
		this.usrInfo = usrInfo;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public List<UserInfo> getUsrInfos() {
		return usrInfos;
	}
	public void setUsrInfos(List<UserInfo> usrInfos) {
		this.usrInfos = usrInfos;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String execute(){
		try{
		for(UserRole usrRol:userRoles){
			if(usrRol.getUsrRoleId()==roleId)
				usrInfo.setUsrRole(usrRol);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		dao.insertObject(usrInfo);
		return SUCCESS;
	}
	public String createAccNavigation(){
		editable=false;
		try {
			userRoles=dao.getUserRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String userSummaryNavigation(){
		usrInfos=dao.getAllUsers();
		return SUCCESS;
	}
	public String editUserNavigation(){
		editable=true;
		usrInfo=dao.getUserInfo(usrInfo.getUserUID());
		return SUCCESS;
	}
	public String updateUserInfo(){
		try{
		for(UserRole usrRol:userRoles){
			if(usrRol.getUsrRoleId()==roleId)
				usrInfo.setUsrRole(usrRol);
		}
		dao.updateObject(usrInfo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
