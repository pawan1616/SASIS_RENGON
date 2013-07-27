package com.technobright.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.StudentInfo;

public class AccountSettingAction extends ActionSupport implements ServletRequestAware{
	
	private DAOInterface dao;
	private StudentInfo stdInfo;
	private HttpServletRequest request;
	private String currPassword;
	private String newPassword;
	private String confirmPassword;
	
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	public String getCurrPassword() {
		return currPassword;
	}
	public void setCurrPassword(String currPassword) {
		this.currPassword = currPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String stdAccountSettingNavigation(){
		
		return SUCCESS;
	}
	public String stdChangePasswordNavigation(){
		System.out.println(".............");
		stdInfo=(StudentInfo)request.getSession(false).getAttribute("StudentInfo");
		return SUCCESS;
	}
	public String stdPasswordChange(){
		System.out.println(currPassword+" "+newPassword+" "+confirmPassword+" "+stdInfo.getUserInfo().getPassword());
		try {
			if(!currPassword.trim().equals(stdInfo.getUserInfo().getPassword())){
			System.out.println("error................er...");
				return ERROR;
			}
			else if(newPassword.equals(confirmPassword)){
				stdInfo.getUserInfo().setPassword(newPassword);
				dao.updateObject(stdInfo.getUserInfo());
			}else
				return "passwordNotMatched";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}
