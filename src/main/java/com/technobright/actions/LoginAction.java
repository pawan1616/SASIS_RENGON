package com.technobright.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.ErrorMsgTransporter;
import com.technobright.entities.UserInfo;
import com.technobright.entities.UserPreference;


public class LoginAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private String usrName;
	private String password;
	private DAOInterface dao;
	private ErrorMsgTransporter errorMsgTransporter;
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;

	}
	
	public ErrorMsgTransporter getErrorMsgTransporter() {
		return errorMsgTransporter;
	}
	public void setErrorMsgTransporter(ErrorMsgTransporter errorMsgTransporter) {
		this.errorMsgTransporter = errorMsgTransporter;
	}
	public String execute(){
		try{
			UserInfo usrInfo=dao.getUserInfo(usrName);
			if(usrInfo.getPassword()!=null&&password.equals(usrInfo.getPassword())){
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
				if(usrInfo.getUserType().equals("Student"))
					return "STDTEMPLATE";
				else
					return SUCCESS;

			}else{
				errorMsgTransporter.setIsErrorIn(true);
				errorMsgTransporter.getErrMsg().put("authMsg", "Invalid username or password");
				return ERROR;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}
	public String errorCreation(){
		return SUCCESS;
	}
	public String loginPageNavigation(){
		
		return SUCCESS;
	}
}
