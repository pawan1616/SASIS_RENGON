<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<script>
	$(function() {
		$('#courseCombo').combobox();
		for(i=1;i<=2;i++){
			$( "#datepickerReq"+i ).datepicker({
				changeMonth: true,
				changeYear: true
			});
		}
	});
	</script>
</head>
<center>
	<table>
		<tr><td>&nbsp;</td></tr>
		<tr><td>Course:</td>
			<td>
				<select id="courseCombo" name="courseId" >
					<s:iterator value="courseInfoList">
						<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
					</s:iterator>
					
				</select>
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>Total Fee:</td>
			<td><input id="totalMarks" type="text" name="totalCourseFee.amnt" class="normalTextBox"/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>Start Date:</td>
			<td><input type="text" name="totalCourseFee.startDate" id="datepickerReq1" value='<s:property value="totalCourseFee.startDate"/>'/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>End Date:</td>
			<td><input type="text" name="totalCourseFee.endDate" id="datepickerReq2" value='<s:property value="totalCourseFee.endDate"/>'/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Create Total Fee" onclick="javascript:createUpdateBasicMod('fee/createTotalCourseFee.action',false,false,'totalFee')"/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
	</table>
</center>