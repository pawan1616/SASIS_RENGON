package com.technobright.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.Page;
import com.technobright.entities.UserPreference;
import com.technobright.entities.UserRole;

public class UserRoleAction extends ActionSupport{
	private DAOInterface dao;
	private UserRole usrRole;
	private List<UserPreference> usrPrefs;
	private List<Page> pages;
	private List<Page> selPages;
	private List<String> selUsrPrefs;
	private List<UserRole> userRoles;
	private List<Integer> pageIds;
	private Map<Integer,RWEHelper> rweHelpers;
	private boolean editable;
	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}

	public UserRole getUsrRole() {
		return usrRole;
	}

	public void setUsrRole(UserRole usrRole) {
		this.usrRole = usrRole;
	}

	public List<UserPreference> getUsrPrefs() {
		return usrPrefs;
	}

	public void setUsrPrefs(List<UserPreference> usrPrefs) {
		this.usrPrefs = usrPrefs;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public List<Page> getSelPages() {
		return selPages;
	}

	public void setSelPages(List<Page> selPages) {
		this.selPages = selPages;
	}

	public List<String> getSelUsrPrefs() {
		return selUsrPrefs;
	}

	public void setSelUsrPrefs(List<String> selUsrPrefs) {
		this.selUsrPrefs = selUsrPrefs;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public List<Integer> getPageIds() {
		return pageIds;
	}

	public void setPageIds(List<Integer> pageIds) {
		this.pageIds = pageIds;
	}

	public Map<Integer,RWEHelper> getRweHelpers() {
		return rweHelpers;
	}

	public void setRweHelpers(Map<Integer,RWEHelper> rweHelpers) {
		this.rweHelpers = rweHelpers;
	}

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String execute(){
		roleSubmission(1);
		return SUCCESS;
	}

	public String userRoleNavigation(){
		if(usrPrefs==null||usrPrefs.size()==0){
			usrPrefs=dao.getAllUsrPrefs();
			pages=dao.getAllPages();
		}
		editable=false;
		return SUCCESS;
	}
	public String usrRoleSumNavigation(){
		userRoles=dao.getUserRoles();
		return SUCCESS;
	}
	public String editRoleNavigation(){
		editable=true;
		if(userRoles.isEmpty())
			userRoles=dao.getUserRoles();
		for(UserRole rolId:userRoles){
			if(rolId.getUsrRoleId()==usrRole.getUsrRoleId()){
				usrRole=rolId;
				selPages=usrRole.getPagesList();
			}
		}
		pageIds=new ArrayList<Integer>();
		rweHelpers=new TreeMap<Integer,RWEHelper>();
		for(Page selPage:selPages){
			pageIds.add(selPage.getPageId());
			RWEHelper rweHelper=new RWEHelper();
			rweHelper.setPageId(selPage.getPageId());
			for(UserPreference usrPref: selPage.getUsrPrefs()){
				if(usrPref.getType().equals("R"))
					rweHelper.setRead(true);
				if(usrPref.getType().equals("W"))
					rweHelper.setWrite(true);
				if(usrPref.getType().equals("E"))
					rweHelper.setEdit(true);
			}
			rweHelpers.put(selPage.getPageId(),rweHelper);
		}
		return SUCCESS;
	}
	public String updateRole(){
		for(String str: selUsrPrefs)
				roleSubmission(2);
				return SUCCESS;
	}
	public boolean roleSubmission(int submissionFor){

		try{
			ServletContext servCtx=ServletActionContext.getServletContext();
			Map<Integer,Page> pageMap=(Map<Integer, Page>)servCtx.getAttribute("pageMap");
			List<UserPreference> selPrefList=new ArrayList<UserPreference>();
			UserRole secondRole=new UserRole();
			if(submissionFor==2){
				for(UserRole role:userRoles){
					if(role.getUsrRoleId()==usrRole.getUsrRoleId()){
						secondRole=role;
					}
				}
			}
			usrRole.setPagesList(new ArrayList<Page>());
			for(String usrPrefStr :selUsrPrefs){
				String [] toks=usrPrefStr.split("~");
				Page pageObj=pageMap.get(Integer.parseInt(toks[0]));
				usrRole.getPagesList().add(pageObj);
				if(toks.length>1){
					switch(toks.length){
					case 2:
						for(UserPreference usrPref:pageObj.getUsrPrefs()){
							if(usrPref.getType().equals(toks[1]))
								selPrefList.add(usrPref);
						}
						break;
					case 3:
						for(UserPreference usrPref:pageObj.getUsrPrefs()){
							if(usrPref.getType().equals(toks[1])||usrPref.getType().equals(toks[2]))
								selPrefList.add(usrPref);
						}
						break;
					case 4:
						for(UserPreference usrPref:pageObj.getUsrPrefs()){
							if(usrPref.getType().equals(toks[1].trim())||usrPref.getType().equals(toks[2].trim())||usrPref.getType().trim().equals(toks[3].trim()))
								selPrefList.add(usrPref);
						}
						break;
					}
				}
			}
			usrRole.setUserPreferenceList(selPrefList);
			if(submissionFor==1)
				dao.insertObject(usrRole);
			 if(submissionFor==2){
				secondRole.setPagesList(usrRole.getPagesList());
				secondRole.setUserPreferenceList(selPrefList);
				dao.updateObject(secondRole);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}
}
