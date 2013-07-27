<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<div class="tableContainerSummary">
			<table id="reportSummary" width="100%">
						        <tr>
						            <th>Role Id</th>
						            <th>Page Name</th>
						            <th>Description</th>
						            <th></th>
						        </tr>
						        <s:iterator value="userRoles">
						        <tr>
						            <td class="editableId" id="usrRole.usrRoleId"><s:property  value="usrRoleId"/></td>
						            <td><s:property value="roleName"/></td>
						            <td class="description"><s:property value="roleDescription"/></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
						            <div class="rightDiv">
						                <input type="submit" class="viewTblRels" value="view Users >>" name="usrDetails"/>
						            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">
						                	<s:property value="roleDescription"/>
						                </div>
						                <h4><a href="nav2UsrRoleEdit.action" class=".navRoleEdit">Edit</a></h4>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					        </div>
					        <div class="summaryContainerPopup">
					        <div>&nbsp;</div>
					         <s:iterator value="userRoles" id="usrList">
					         	<div class="usrDetails">
					         		<s:iterator value="#usrList.usrInfoList" id="usrInfo">
					         		<div class="dividerLine"></div><div class="arrow"></div>
						         		<ul>
						         			<li>First Name:<s:property value="#usrInfo.firstName"/></li>
						         			<li>Last Name:<s:property value="#usrInfo.lasatName"/></li>
						         			<li>Middle Name:<s:property value="#usrInfo.initials"/></li>
						         			<li>User Name:<s:property value="#usrInfo.userName"/></li>
						         			<li>&nbsp;</li>
						         		</ul>
					         		</s:iterator>
					         	</div>
					         </s:iterator>
					        </div>