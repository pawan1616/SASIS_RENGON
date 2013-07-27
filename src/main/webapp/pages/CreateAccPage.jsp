<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <s:set name="editable" value="editable"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
</head>
		<center>
			<table>
			<s:if test="%{#editable==true}">
							<input type="text" name="usrInfo.userUID" value='<s:property value="usrInfo.userUID"/>' hidden="hidden"/>
						</s:if>
			<tr><td>&nbsp;</td></tr>
			<tr><td>
						<label>Role*</label>
				</td><td>
					<div class="ui-widget">
							<select id="combobox" name="roleId">
									<option value="">Select one...</option>
									
									<s:if test="%{#editable==true}">
										<s:iterator value="userRoles" id="usrRol">
											<s:if test="%{#usrRol.usrRoleId==usrInfo.usrRole.usrRoleId}">
												<option value="<s:property value="usrRoleId"/>" selected="selected"><s:property value="roleName"/></option>
											</s:if>
										</s:iterator>
									</s:if>
									<s:else>
										<s:iterator value="userRoles" id="usrRol">
											<option value="<s:property value="usrRoleId"/>"><s:property value="roleName"/></option>
										</s:iterator>
									</s:else>
							</select>
					</div>
				</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>First Name*</td><td>
					<s:if test="%{#editable==true}">
						<input type="text" name="usrInfo.firstName" class="normalTextBox" value='<s:property value="usrInfo.firstName"/>'/>
					</s:if>
					<s:else>
						<input type="text" name="usrInfo.firstName" class="normalTextBox"/>
					</s:else>
				</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>Last Name*</td><td>
					<s:if test="%{#editable==true}">
						<input type="text" name="usrInfo.lastName" class="normalTextBox" value='<s:property value="usrInfo.lastName"/>'/>
					</s:if>
					<s:else>
						<input type="text" name="usrInfo.lastName" class="normalTextBox"/>
					</s:else>
				</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>Initials</td><td>
					<s:if test="%{#editable==true}">
						<input type="text" name="usrInfo.initials" class="normalTextBox" value='<s:property value="usrInfo.initials"/>'/>
					</s:if>
					<s:else>
						<input type="text" name="usrInfo.initials" class="normalTextBox"/>
					</s:else>
				</td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>User Name*</td><td>
					<s:if test="%{#editable==true}">
						<input type="text" name="usrInfo.userName" class="normalTextBox" value='<s:property value="usrInfo.userName"/>' readonly="readonly"/>
					</s:if>
					<s:else>
						<input type="text" name="usrInfo.userName" class="normalTextBox"/>
					</s:else>
				</td></tr>
				<s:if test="%{#editable!=true}">
				<tr><td>&nbsp;</td></tr>
				<tr><td>Password*</td><td><input type="password" name="usrInfo.password" class="normalTextBox"/></td></tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>Confirm Password</td><td><input type="password" name="confirmPassword" class="normalTextBox"/></td></tr>
				</s:if>
				
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td><td>
				<s:if test="%{#editable==true}">
					<input type="submit"value="Update Account" onclick="javascript:submitUserCreate('usrInfoUpdateAction.action',true)"/>
					<input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/>
				</s:if>
				<s:else>
					<input type="submit"value="Create Account" onclick="javascript:submitUserCreate('createAcc.action',false)"/>
				</s:else>
				</td></tr>
				<tr><td>&nbsp;</td></tr>
			</table>
		</center>
