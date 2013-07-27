package com.technobright.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	public String logout(){
		Map session = ActionContext.getContext().getSession();
		  session.remove("logged-in");
		return SUCCESS;
	}
}
