package com.technobright.interceptors;

import java.util.Map;

import com.technobright.actions.AvailabilityCheck;
import com.technobright.actions.InstCreation;
import com.technobright.actions.LoginAction;
import com.technobright.entities.UserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticaitonInterceptor implements Interceptor {

	public void destroy() {
		System.out.println("Custom interceptor destroyed.....");
		
	}

	public void init() {
		System.out.println("Custom interceptor initialized.....");
		
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserInfo usrInfo = (UserInfo) session.get("logged-in");
		Object action = actionInvocation.getAction();
		if (usrInfo != null) {
	       return actionInvocation.invoke();
		}/*else if(action instanceof CreateAccountAction){
			if(actionInvocation.getInvocationContext().getName().equalsIgnoreCase("nav2CreateAccPage"))
				return actionInvocation.invokeActionOnly();
			else
				return actionInvocation.invoke();
		}*/else if(!(action instanceof LoginAction||action instanceof InstCreation||action instanceof AvailabilityCheck)){
	       return "loginRedirect";
	    }else{
	    	if(actionInvocation.getInvocationContext().getName().equalsIgnoreCase("nav2Login"))
	    		return actionInvocation.invokeActionOnly();
	    	else
	    		return actionInvocation.invoke();
	    }
	}
}
