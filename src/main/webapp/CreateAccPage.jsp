<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
   <%@ taglib uri="/struts-dojo-tags" prefix="sd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sd:head/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<script language="JavaScript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
<script language="JavaScript" src="${pageContext.request.contextPath}/struts/css_xhtml/validation.js" type="text/javascript"></script>
</head>
<body>
		<center>
			<s:form action="/createAcc.action" theme="xhtml" method="post" validate="true">
			<table>
				<tr><td><s:textfield name="usrInfo.firstName" label="First Name" required="true"/></td></tr>
				<tr><td><s:textfield name="usrInfo.lastName" label="Last Name" required="true"/></td></tr>
				<tr><td><s:textfield name="usrInfo.initials" label="Initials"/></td></tr>
				<tr><td><sd:autocompleter name="usrInfo.userType" label="User Type" required="true" list="{'Admin','Manager','Normal User'}"/></td></tr>
				<tr><td><s:textfield name="usrInfo.userName" label="User Name" required="true"/></td></tr>
				<tr><td><s:password name="usrInfo.password" label="Password" required="true"/></td></tr>
				<tr><td><s:password name="confirmPassword" label="Confirm Password" required="true" /></td></tr>
				<tr><td><sd:submit value="Create Account" align="center" validate="true" /></td></tr>
				<tr><td></td></tr>
			</table>
			</s:form>
			<a href="nav2Login.action">Back to Login Page</a>
		</center>
</body>
</html>