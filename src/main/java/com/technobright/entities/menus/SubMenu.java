package com.technobright.entities.menus;

import java.io.Serializable;

public class SubMenu implements Serializable {

	private int subMenuId;
	private String name;
	private MainMenu mainMenu;
	
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
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
