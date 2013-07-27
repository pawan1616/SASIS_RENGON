<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
	<center>
		<form action="" method="post">
			<table>
				<tr><td>&nbsp;</td><td></td><td></td></tr>
				<tr><td>Current Password:</td><td>&nbsp;&nbsp;&nbsp;</td><td><input type="password" name="currPassword" class="normalTextBox"/></td></tr>
				<tr><td>&nbsp;</td><td></td><td></td></tr>
				<tr><td>New Password:</td><td></td><td><input type="password"  class="normalTextBox" name="newPassword"/></td></tr>
				<tr><td>&nbsp;</td><td></td><td></td></tr>
				<tr><td>Confirm Password:</td><td></td><td><input type="password"  class="normalTextBox" name="confirmPassword"/></td></tr>
				<tr><td>&nbsp;</td><td></td><td></td></tr>
				<tr><td></td><td></td><td><input type="submit" value="Change Password" onclick="javascript:submitUserCreate('stdChangePassword.action',true)"/></td></tr>
				<tr><td>&nbsp;</td><td></td><td></td></tr>
			</table>
		</form>
	</center>
</div>