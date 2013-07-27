<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<div class="stdHome">
	<table class="stdHomeTab">
		<tr><td align="left" width="15%" valign="top"><i><b>About Me:</b></i></b></td><td width="35%"><div style="width:50%"><s:property value="stdInfo.aboutMe"/></div></td><td width="5%">&nbsp;&nbsp;&nbsp;&nbsp;</td><td width="15%"></td><td>&nbsp;&nbsp;&nbsp;</td></tr>
		<tr><td>&nbsp;</td><td></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Date of Birth:</b></i></td><td><s:property value="stdInfo.dob"/></td><td></td><td></td><td></td></tr>
		<tr><td>&nbsp;</td><td></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Sex:</b></i></td><td><s:property value="stdInfo.sex"/></td><td></td><td></td><td></td></tr>
		<tr><td>&nbsp;</td><td></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Address:</b></i></td><td><s:property value="stdInfo.addLine1"/></td><td></td><td></td><td></td></tr>
		<tr><td></td><td><s:property value="stdInfo.addLine2"/></td><td></td><td></td><td></td></tr>
		<tr><td></td><td><s:property value="stdInfo.city"/>, <s:property value="stdInfo.State"/></td><td></td><td></td><td></td></tr>
		<tr><td></td><td><s:property value="stdInfo.country"/></td><td></td><td></td><td></td></tr>
		<tr><td>&nbsp;</td><td></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Contact No:</b></i></td><td><s:property value="stdInfo.stdMobileNo"/>, <s:property value="stdInfo.stdPhoneNo"/></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Email Id:</b></i></td><td><s:property value="stdInfo.stdEmail"/></td><td></td><td></td><td></td></tr>
		<tr><td>&nbsp;</td><td></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Father's Name:</b></i></td><td><s:property value="stdInfo.fathersName"/></td><td></td><td><i><b>Profession:</b></i></td><td><s:property value="stdInfo.fathersProfess"/></td></tr>
		<tr><td><i><b>Mother's Name:</b></i></td><td><s:property value="stdInfo.mothersName"/></td><td></td><td><i><b>Profession:</b></i></td><td><s:property value="stdInfo.mothersProfess"/></td></tr>
		<tr><td><i><b>Monthly Income:</b></i></td><td><s:property value="stdInfo.monthlyIncome"/></td><td></td><td></td><td></td></tr>
		<tr><td>&nbsp;</td><td></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Parent's Contact No:</b></i></td><td><s:property value="stdInfo.parentPhoneNo"/>, <s:property value="stdInfo.parentMobileNo"/></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Parent's Email:</b></i></td><td><s:property value="stdInfo.parentEmail"/></td><td></td><td></td><td></td></tr>
		<tr><td><i><b>Fax:</b></i></td><td><s:property value="stdInfo.fax"/></td><td></td><td></td><td></td></tr>
	</table>
</div>