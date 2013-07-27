package com.technobright.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.ProfilePic;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.UserInfo;

public class NavigationAction extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private DAOInterface dao;
	private String username;
	private String id;
	private String profilePicPath;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProfilePicPath() {
		return profilePicPath;
	}
	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		  UserInfo usrInfo=(UserInfo)session.get("logged-in");
		  username=usrInfo.getFirstName()+" "+usrInfo.getLastName();
		return SUCCESS;
	}
	public String templateNavigation(){
		Map session = ActionContext.getContext().getSession();
		  UserInfo usrInfo=(UserInfo)session.get("logged-in");
		  username=usrInfo.getFirstName()+" "+usrInfo.getLastName();
		  if(usrInfo.getUserType().equalsIgnoreCase("Student"))
			  return "STDTEMPLATE";
		return SUCCESS;
	}
	public String userProfileNavigation(){
		
		return SUCCESS;
	}
	
}
