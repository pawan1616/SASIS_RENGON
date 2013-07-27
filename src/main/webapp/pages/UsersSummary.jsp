<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
				<div class="tableFullContainerSummary">
				<table id="reportSummary" width="100%">
						        <tr>
						            <th>User Id</th>
						            <th>User Name</th>
						            <th>User Role</th>
						            <th>Institute Admin</th>
						            <th></th>
						        </tr>
						        <s:iterator value="usrInfos">
						        <tr>
						            <td class="editableId" id="usrInfo.userUID"><s:property  value="userUID"/></td>
						            <td><s:property value="userName"/></td>
						            <td><s:property value="usrRole.roleName"/></td>
						            <td><s:property value="instAdmin.schoolName"/></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">
						                	<ul>
						                		<li><label>User Id:<s:property value="userUID"/></label></li>
						                		<li><label>Name:<s:property value="firstName"/>&nbsp;&nbsp;<s:property value="initials"/>&nbsp;&nbsp;<s:property value="lastName"/></label></li>
						                		<li><label>User Name:<s:property value="userName"/></label></li>
						                		<li><label>User type:<s:property value="userType"/></label></li>
						                		<li><label>Institute Name:<s:property value="instAdmin.schoolName"/></label></li>
						                	</ul>
						                </div>
						                <h4><a href="nav2UsrInfoEdit.action" class="navRoleEdit">Edit</a></h4>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					        </div>
					        