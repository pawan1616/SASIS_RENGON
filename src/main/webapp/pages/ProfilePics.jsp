<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<form action="uploadProfilepic.action" method="post" enctype="multipart/form-data">
		<s:file name="imgProfilePicFile" label="Upload Image"/>
		<input type="submit" value="Upload"/>
	</form>
		
</div>