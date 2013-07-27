package com.technobright.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.ErrorMsgTransporter;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.UserInfo;

public class InstCreation extends ActionSupport implements ServletRequestAware{

	private DAOInterface dao;
	private InstAdmin instAdmin;
	private List<String> instTypeList;
	private ErrorMsgTransporter errMsgTrans;
	private String confirmPassword;
	private HttpServletRequest request;
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public List<String> getInstTypeList() {
		return instTypeList;
	}
	public void setInstTypeList(List<String> instTypeList) {
		this.instTypeList = instTypeList;
	}
	public InstAdmin getInstAdmin() {
		return instAdmin;
	}
	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}
	public ErrorMsgTransporter getErrMsgTrans() {
		return errMsgTrans;
	}
	public void setErrMsgTrans(ErrorMsgTransporter errMsgTrans) {
		this.errMsgTrans = errMsgTrans;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public String execute(){
		try{
		System.out.println(instAdmin.getAddress()+" "+instAdmin.getSchoolName()+" "+instAdmin.getDescription());
		UserInfo usrInfo=new UserInfo();
		usrInfo.setFirstName(instAdmin.getSchoolName());
		usrInfo.setLastName(instAdmin.getCity());
		usrInfo.setUserName(instAdmin.getUserName());
		usrInfo.setPassword(instAdmin.getPassword());
		usrInfo.setIsAdmin(true);
		usrInfo.setUserType("InstAdmin");
		boolean isInserted=false;
		if(com.mysql.jdbc.StringUtils.isNullOrEmpty(dao.getUserInfo(instAdmin.getUserName()).getUserName()))
			isInserted=dao.insertUserInfo(usrInfo);
		if(isInserted){
			usrInfo=dao.getUserInfo(instAdmin.getUserName());
			instAdmin.setUserId(usrInfo.getUserUID());
			dao.insertObject(instAdmin);
		}else{
			errMsgTrans.setIsErrorIn(true);
			errMsgTrans.getErrMsg().put("instAdmin.userName", "Username alredy exist, type different one");
			return "input";
		}
	/*	usrInfo=dao.getUserInfo(instAdmin.getUserName());
		if(usrInfo.getPassword()!=null&&instAdmin.getPassword().equals(usrInfo.getPassword())){
			request.getSession(false).setAttribute("logged-in", usrInfo);
			if(usrInfo.getIsAdmin()){
				request.getSession(false).setAttribute("InstAdmin", dao.getInstAdminByUsrId(usrInfo.getUserUID()));
			}else if(usrInfo.getUserType().equalsIgnoreCase("Student"))
				request.getSession(false).setAttribute("StudentInfo", dao.getStdInfoByUsr(usrInfo));
			if(usrInfo.getUsrRole()!=null){
				List<UserPreference> prefList=usrInfo.getUsrRole().getUserPreferenceList();
				List<String> prefStrList=new ArrayList<String>();
				for(UserPreference usrPref:prefList){
					prefStrList.add(usrPref.getActionName().trim());
				}
				request.getSession(false).setAttribute("pref-list", prefStrList);
			}
		}*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String instCreationNavigation(){
		instTypeList=new ArrayList<String>();
		instTypeList.add("University");
		instTypeList.add("College");
		instTypeList.add("Board");
		instTypeList.add("School");
		instTypeList.add("Other Institute");
		return SUCCESS;
	}
}
