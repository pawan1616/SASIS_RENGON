<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<script>
$(function() {
	for(i=1;i<=2;i++)
	$( "#datepicker"+i).datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '-100:+0'
	});
});
</script>
<div class="editDiv">

		<s:if test="isUpdate">
			<s:if test="isEdit">
			
			<div class="overFlowPanel">
				
				<form action="" method="post">
					<table border="1">
						<tr>
							<th>Organisation Name</th>
							<th>Is Current Org.</th>
							<th>Org. Address</th>
							<th>My Designation</th>
							<th>Roles & Responsibility</th>
							<th>Projects</th><th>Start Date</th>
							<th>End Date</th>
						</tr>
						<tr>
							<td><input type="text" name="stdWorkExp.orgName" class="normalTextBox" value='<s:property value="stdWorkExp.orgName"/>'/></td>
							<td><input type="radio" name="stdWorkExp.isCurrentOrg" value="true" /></td>
							<td><input type="text" name="stdWorkExp.orgAddress" class="normalTextBox" value='<s:property value="stdWorkExp.orgAddress"/>'/></td>
							<td><input type="text" name="stdWorkExp.designation" class="normalTextBox" value='<s:property value="stdWorkExp.designation"/>'/></td>
							<td><textarea name="stdWorkExp.rolesNResponsibility"><s:property value="stdWorkExp.rolesNResponsibility"/></textarea></td>
							<td><textarea name="stdWorkExp.projects"><s:property value="stdWorkExp.projects"/></textarea></td>
							<td><input type="text" name="stdWorkExp.startDate" id="datepicker1" class="normalTextBox" value='<s:property value="stdWorkExp.startDate"/>'/></td>
							<td><input type="text" name="stdWorkExp.endDate" id="datepicker2" class="normalTextBox" value='<s:property value="stdWorkExp.endDate"/>'/></td>
						</tr>
						<tr><td align="center"><input type="submit" value="Update" onclick="javascript:submitUserCreate('updateWorkExp.action',true)"/></td><td><input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/></td><td></td><td></td><td></td><td></td><td></td><td align="center"><input type="submit" value="Add" onclick="javascript:submitUserCreate('addWorkExp.action',true)"/></td></tr>
					</table>
				</form>
			</div>
			
			</s:if>
			<s:else>
			<div class="overFlowPanel">
				
				<form action="" method="post">
					<table border="1">
						<tr>
							<th>Organisation Name</th>
							<th>Is Current Org.</th>
							<th>Org. Address</th>
							<th>My Designation</th>
							<th>Roles & Responsibility</th>
							<th>Projects</th><th>Start Date</th>
							<th>End Date</th>
						</tr>
						<tr>
							<td><input type="text" name="stdWorkExp.orgName" class="normalTextBox"/></td>
							<td><input type="radio" name="stdWorkExp.isCurrentOrg" value="true" /></td>
							<td><input type="text" name="stdWorkExp.orgAddress" class="normalTextBox"/></td>
							<td><input type="text" name="stdWorkExp.designation" class="normalTextBox"/></td>
							<td><textarea name="stdWorkExp.rolesNResponsibility"></textarea></td>
							<td><textarea name="stdWorkExp.projects"></textarea></td>
							<td><input type="text" name="stdWorkExp.startDate" id="datepicker1" class="normalTextBox"/></td>
							<td><input type="text" name="stdWorkExp.endDate" id="datepicker2" class="normalTextBox"/></td>
						</tr>
						<tr><td align="center"><input type="submit" value="Add" onclick="javascript:submitUserCreate('addWorkExp.action',false)"/></td><td></td><td></td><td></td><td></td><td></td><td></td><td align="center"><input type="submit" value="Add" onclick="javascript:submitUserCreate('addWorkExp.action',true)"/></td></tr>
					</table>
				</form>
			</div>
			</s:else>
</div>
			<s:if test="isEdit"></s:if>
			<s:else>
			<center>
			<div class="tableContainer">
		
						    <table id="report">
						        <tr>
						            <th>Select</th>
						            <th>Work Exp Id</th>
									<th>Organisation Name</th>
									<th>Is Current Org.</th>
						            <th>Designation</th>
						            <th></th>
						        </tr>
						        
						        <s:iterator value="stdWorkExpList">
						        <tr>
						            <td class="checkBtnPage"><input type="checkbox" name="" value="<s:property value="workExpId" />"/></td>
						            <td><s:property value="workExpId" /></td>
						            <td><s:property value="orgName" /></td>
						            <td><s:property value="isCurrentOrg" /></td>
						            <td><s:property value="designation" /></td>
						        </tr>
						        <tr>
						            <td colspan="5">
							            <div class="rightDiv">
							               <a href="getUpdateableWorkExp.action">Edit</a>
							            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">
						                	<table>
						            		<b>Organisation Name : </b><i><s:property value="orgName"/></i><br/>
											<b>Is Current Org : </b><i><s:property value="isCurrentOrg"/></i><br/>
											<b>Org. Address : </b><i><s:property value="orgAddress"/></td></i>	<br/>
											<b>My Designation : </b><i><s:property value="designation"/></i><br/>
											<b>Roles N Responsibility : </b><i><s:property value="rolesNResponsibility"/></i><br/>
											<b>Projects : </b><i><s:property value="projects"/></i>			<br/>
											<b>Start Date : </b><i><s:property value="startDate"/></i><br/>
											<b>End Date : </b><i><s:property value="endDate"/></i>	     		
						            		</table>
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					</div>
				</center>
				</s:else>
		</s:if>
		<s:else>
			<table border=".2" width="100%" bordercolor="#3d3d3d" cellspacing="0" class="altColorTab">
				<tr>
					<th>Organisation Name</th>
					<th>Is Current Org.</th>
					<th>Org. Address</th>
					<th>My Designation</th>
					<th>Roles & Responsibility</th>
					<th>Projects</th><th>Start Date</th>
					<th>End Date</th>
				</tr>
				<s:iterator value="stdWorkExpList">
					<tr>
						<td><s:property value="orgName"/></td>
						<td><s:property value="isCurrentOrg"/></td>
						<td><s:property value="orgAddress"/></td>	
						<td><s:property value="designation"/></td>
						<td><s:property value="rolesNResponsibility"/></td>
						<td><s:property value="projects"/></td>			
						<td><s:property value="startDate"/></td>
						<td><s:property value="endDate"/></td>				
					</tr>
				</s:iterator>
			</table>
		</s:else>