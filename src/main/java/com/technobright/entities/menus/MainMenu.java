package com.technobright.entities.menus;

import java.util.Set;
import java.io.Serializable;

public class MainMenu implements Serializable {
   
	private int menuId;
	private String name;
    private Set<SubMenu> subMenu;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public Set<SubMenu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(Set<SubMenu> subMenu) {
		this.subMenu = subMenu;
	}
	
}
