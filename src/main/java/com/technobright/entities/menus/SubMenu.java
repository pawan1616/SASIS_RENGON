package com.technobright.entities.menus;

import java.io.Serializable;
import java.util.Set;

public class SubMenu implements Serializable {

	private int subMenuId;
	private String name;
	private Set<Content> contentMenu;
	
	public Set<Content> getContentMenu() {
		return contentMenu;
	}
	public void setContentMenu(Set<Content> contentMenu) {
		this.contentMenu = contentMenu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSubMenuId() {
		return subMenuId;
	}
	public void setSubMenuId(int subMenuId) {
		this.subMenuId = subMenuId;
	}
	
	
}
