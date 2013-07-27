package com.technobright.actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.ProfilePic;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.UserInfo;

import freemarker.template.SimpleDate;

public class UserProfileAction extends ActionSupport implements ServletRequestAware{
	private DAOInterface dao;
	private InstAdmin instAdmin;
	private UserInfo usrInfo;
	private StudentInfo stdInfo;
	private File imgProfilePicFile;
	private HttpServletRequest request;
	private String profilePicPath;
	private String userUID;

	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}


	public InstAdmin getInstAdmin() {
		return instAdmin;
	}


	public void setInstAdmin(InstAdmin instAdmin) {
		this.instAdmin = instAdmin;
	}


	public UserInfo getUsrInfo() {
		return usrInfo;
	}


	public void setUsrInfo(UserInfo usrInfo) {
		this.usrInfo = usrInfo;
	}


	public StudentInfo getStdInfo() {
		return stdInfo;
	}


	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}


	public File getImgProfilePicFile() {
		return imgProfilePicFile;
	}


	public void setImgProfilePicFile(File imgProfilePicFile) {
		this.imgProfilePicFile = imgProfilePicFile;
	}


	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}


	public String getProfilePicPath() {
		return profilePicPath;
	}


	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}


	public String getUserUID() {
		return userUID;
	}

	public void setUserUID(String userUID) {
		this.userUID = userUID;
	}

	public String userProfileNavigation(){
		Map session = ActionContext.getContext().getSession();
		usrInfo=(UserInfo) session.get("logged-in");
		if(usrInfo.getUserType().equals("Student")){
			stdInfo=(StudentInfo)dao.getStdInfoByUsr(usrInfo);
			instAdmin=new InstAdmin();
			ProfilePic profPic=dao.getStdProfilePic(stdInfo);
			if(profPic==null)
				profPic=dao.getDefaultPic();
			profilePicPath=profPic.getPicPath()+profPic.getPicName();
		}
		else if(usrInfo.getUserType().equals("InstAdmin")){
			ProfilePic profPic=dao.getDefaultPic();
			profilePicPath=profPic.getPicPath()+profPic.getPicName();
			instAdmin=(InstAdmin)dao.getInstAdminByUsrId(usrInfo.getUserUID());
			stdInfo=new StudentInfo();
		}
		return SUCCESS;
	}
	
	public String externalUserProfileNavigation(){
		usrInfo=(UserInfo) dao.getUserInfo(userUID);
		if(usrInfo.getUserType().equals("Student")){
			stdInfo=(StudentInfo)dao.getStdInfoByUsr(usrInfo);
			instAdmin=new InstAdmin();
			ProfilePic profPic=dao.getStdProfilePic(stdInfo);
			if(profPic==null)
				profPic=dao.getDefaultPic();
			profilePicPath=profPic.getPicPath()+profPic.getPicName();
		}
		return SUCCESS;
	}
	
	public String stdHomeNavigation(){

		return SUCCESS;
	}
	public String profilePicEditNavigation(){

		return SUCCESS;
	}
	public String uploadProfilePic(){
		Map session = ActionContext.getContext().getSession();
		stdInfo=(StudentInfo) session.get("StudentInfo");
		ServletContext context = request.getSession(false).getServletContext();
		String filePath = context.getRealPath("/");
		String picName=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		File picFolder=new File(filePath+"/images/"+stdInfo.getUserInfo().getUserName());
		if(!picFolder.exists())
			picFolder.mkdirs();
		File fileToCreate=new File(filePath+"/images/"+stdInfo.getUserInfo().getUserName(), picName+".jpg");
		try {
			FileUtils.copyFile(imgProfilePicFile, fileToCreate);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProfilePic profilePic=new ProfilePic();
		profilePic.setPicName(picName+".jpg");
		profilePic.setIsCurrent(true);
		profilePic.setPicPath("images/"+stdInfo.getUserInfo().getUserName()+"/");
		profilePic.setStdInfo(stdInfo);
		profilePic.setCaption(picName);
		dao.insertProfilePic(profilePic);
		
		return SUCCESS;
	}
}
