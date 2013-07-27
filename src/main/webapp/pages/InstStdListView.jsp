<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="2" >
			<tr><th>Student UID</th><th>Name</th><th>Sex</th><th>Mobile No.</th></tr>
			<s:iterator value="stdInfoList">
				<tr>
					<td><a  href="#" class="dropdownStdUID"><s:property value="userInfo.userName"/></a></td>
					<td><s:property value="lastName"/>&nbsp;<s:property value="firstName"/>&nbsp;<s:property value="initials"/></td>
					<td><s:property value="sex"/></td>
					<td><s:property value="stdMobileNo"/></td>
				</tr>
			</s:iterator>
			
		</table>
	</center>
	<div class="stdEditNavMenu">
	</div>
</body>
</html>