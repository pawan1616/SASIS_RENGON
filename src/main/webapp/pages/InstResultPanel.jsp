<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table border="2" class="marksheetview">
	<tr><th>Student Id</th><th>Student Name</th><th>Grade</th><th>%</th><th>Session</th></tr>
	<s:iterator value="resultInfoList">
		<tr>
			<td><s:property value="stdInfo.userInfo.userName"/></td>
			<td><s:property value="stdInfo.lastName"/>&nbsp;&nbsp;<s:property value="stdInfo.firstName"/></td>
			<td><s:property value="grade"/></td>
			<td><s:property value="percentage"/></td>
			<td><s:property value="instSessInfo.name"/></td>
		</tr>
	</s:iterator>
</table>