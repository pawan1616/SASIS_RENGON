package com.technobright.interceptors;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.technobright.actions.LoginAction;
import com.technobright.actions.MsgTransferHelper;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.UserInfo;
import com.technobright.entities.UserPreference;

public class ActionFilterInterceptor implements Interceptor{

	private MsgTransferHelper msgTransHelp;

	public MsgTransferHelper getMsgTransHelp() {
		return msgTransHelp;
	}

	public void setMsgTransHelp(MsgTransferHelper msgTransHelp) {
		this.msgTransHelp = msgTransHelp;
	}

	public void destroy() {
		System.out.println("Action Filter Interceptor Initialized.....");
	}

	public void init() {
		System.out.println("Action Filter Interceptor Initialized.....");
	}

	public String intercept(ActionInvocation actInvo) throws Exception {
		actInvo.invoke();
		/*
		Object obj=actInvo.getAction();
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(obj instanceof LoginAction){
			actInvo.invoke();
			return null;
		}
		List<String> prefList=(List<String>)session.get("pref-list");	
		String actionName=actInvo.getProxy().getActionName();
		System.out.println(actionName);
		if(prefList.contains(actionName.trim())){
			actInvo.invoke();
		}else{
			WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
			msgTransHelp =(MsgTransferHelper) applicationContext.getBean("msgTransHelper");
			msgTransHelp.setMsgCode("access101");
			msgTransHelp.setMsgDescription("Action cannot be performed. \n Invalid Access");
			System.out.println("Inside else.............");
			return "invalidAccess";
		}*/
		return null;
	}
}
