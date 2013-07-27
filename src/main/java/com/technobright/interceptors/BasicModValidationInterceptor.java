package com.technobright.interceptors;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.technobright.Util.CommonValidation;
import com.technobright.actions.InstCreation;
import com.technobright.actions.SubjectAction;
import com.technobright.entities.ErrorMsgTransporter;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.SubjectInfo;
import com.technobright.entities.UserInfo;

public class BasicModValidationInterceptor implements Interceptor, ServletRequestAware{

	private HttpServletRequest request;	

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;

	}


	public String intercept(ActionInvocation action) throws Exception {
		System.out.println(action.getProxy().getActionName()+"................");
		boolean doInvoke=true;
		Object obj=action.getAction();
		if(action.getProxy().getActionName().equals("instCreation")){
			doInvoke=validateInstCreation((InstCreation)obj);			
		}else if(action.getProxy().getActionName().equals("subjectAction")){
			doInvoke=validateSubjectCreation((SubjectAction)obj);
		}else
			action.invoke();
		
		if(doInvoke){
			action.invoke();
		}
		else
			return "input";

		return "success";
	}
	private boolean validateSubjectCreation(SubjectAction subAction){
		SubjectInfo subInfo=subAction.getSubjectInfo();
		ErrorMsgTransporter errMsgTrans=new ErrorMsgTransporter();
		errMsgTrans.setErrMsg(new LinkedHashMap<String, String>());
		boolean isValidate=true;
			if(subInfo.getSubName()==null&&(subInfo.getSubName()!=null&&subInfo.getSubName().trim().equals("")))
				errMsgTrans.getErrMsg().put("subjectInfo.subName", "This field is Required");
			if(subInfo.getSubType()==null&&(subInfo.getSubType()!=null&&subInfo.getSubType().trim().equals("")))
				errMsgTrans.getErrMsg().put("subjectInfo.subType", "This field is Required");
			errMsgTrans.setIsErrorIn(!isValidate);
		subAction.setErrMsgTrans(errMsgTrans);
		return isValidate;
	}
	private boolean validateInstCreation(InstCreation instCreate){
		InstAdmin instAdmin=instCreate.getInstAdmin();
		ErrorMsgTransporter errMstTrans=new ErrorMsgTransporter();
		errMstTrans.setErrMsg(new LinkedHashMap<String, String>());
		boolean pinBool=true;
		boolean passBool=true;
		boolean isValidate=true;
		try{
			if(instAdmin.getSchoolName()==null||(instAdmin.getSchoolName()!=null&&instAdmin.getSchoolName().trim().equals(""))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.schoolName", "This field is required");
			}
			if(instAdmin.getDescription()==null||(instAdmin.getDescription()!=null&&instAdmin.getDescription().trim().equals(""))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.description", "This field is required");
			}
			if((instAdmin.getInstType()==null)||(instAdmin.getInstType()!=null&&instAdmin.getInstType().trim().equals(""))){
				errMstTrans.getErrMsg().put("instAdmin.instType", "This field is required");
				isValidate=false;
			}
			if(instAdmin.getAddress()==null||(instAdmin.getAddress()!=null&&instAdmin.getAddress().trim().equals(""))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.address", "This field is required");
			}
			if((instAdmin.getCountry()==null)||(instAdmin.getCountry()!=null&&instAdmin.getCountry().trim().equals("")||instAdmin.getCountry().trim().equals("null"))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.country", "This field is required");
			}
			if((instAdmin.getState()==null)||(instAdmin.getState()!=null&&(instAdmin.getState().trim().equals("")||instAdmin.getState().trim().equals("null")))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.state", "This field is required");
			}
			if((instAdmin.getCity()==null)||(instAdmin.getCity()!=null&&instAdmin.getCity().trim().equals("")||instAdmin.getCity().trim().equals("null"))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.city", "This field is required");
			}
			if((instAdmin.getPin()==null)||(instAdmin.getPin()!=null&&instAdmin.getPin().trim().equals(""))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.pin", "This field is required");
			}
			else
				pinBool=CommonValidation.digitLengthValidation(instAdmin.getPin(),errMstTrans, "instAdmin.pin",6);
			if(instAdmin.getUserName()==null||(instAdmin.getUserName()!=null&&instAdmin.getUserName().equals(""))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.userName", "This field is required");
			}
			if(instAdmin.getPassword()==null||(instAdmin.getPassword()!=null&&instAdmin.getPassword().equals(""))){
				isValidate=false;
				errMstTrans.getErrMsg().put("instAdmin.password", "This field is required");
			}else
				passBool=CommonValidation.passwordValidation(instAdmin.getPassword(),errMstTrans, "instAdmin.password");
			if(instCreate.getConfirmPassword()==null||(instCreate.getConfirmPassword()!=null&&instCreate.getConfirmPassword().equals(""))){
				isValidate=false;
				errMstTrans.getErrMsg().put("confirmPassword", "This field is required");
			}else if(!instCreate.getConfirmPassword().equals(instAdmin.getPassword()))
				errMstTrans.getErrMsg().put("confirmPassword", "Not matched");
			if(!pinBool||!passBool)
				isValidate=false;
			instCreate.setErrMsgTrans(errMstTrans);
			instCreate.getErrMsgTrans().setIsErrorIn(!isValidate);
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return isValidate;
	}
}
