<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<script>
	$(function() {
			$("#combobox1").combobox();
	});
	</script>
</head>
<div class="feeSettingFilter">
	<div id="fee/nav2FeeSettingOption.action">
		<center>
		<table>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td style="color:#FFFFFF;">Fee Type : </td>
			<td>
			<select id="combobox1" name="feeTypeId" >
					<s:iterator value="feeTypeList">
						<option value='<s:property value="feeTypeId"/>'><s:property value="displayName"/></option>
					</s:iterator>
			</select>
			</td>
		</tr>
		</table>
		</center>
	</div>
</div>
<div class="filterContent">
	<script type="text/javascript">
				$(document).ready(function(){
					changePage("fee/nav2TotalCourseFee.action", ".filterContent", "");
					});
			</script>
</div>