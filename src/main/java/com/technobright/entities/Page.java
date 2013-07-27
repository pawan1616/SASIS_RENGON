package com.technobright.entities;

import java.util.List;

public class Page {
	private int pageId;
	private String pageName;
	private String actPageName;
	private String description;
	private List<UserPreference> usrPrefs;
	
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getActPageName() {
		return actPageName;
	}
	public void setActPageName(String actPageName) {
		this.actPageName = actPageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UserPreference> getUsrPrefs() {
		return usrPrefs;
	}
	public void setUsrPrefs(List<UserPreference> usrPrefs) {
		this.usrPrefs = usrPrefs;
	}
}
