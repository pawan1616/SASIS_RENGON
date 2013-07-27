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
		<tr><td>Amount:</td>
			<td><input id="totalMarks" type="text" name="lateFee.amnt" class="normalTextBox"/> Rs. </td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>Applied After:</td>
			<td>
				<input type="text" name="lateFee.appliedAfter" class="shortTextBoxReq"/>
				<label><input type="radio" name="lateFee.isAppliedAfterMonth" value="false"/>Days</label>&nbsp;
				<label><input type="radio" name="lateFee.isAppliedAfterMonth" value="true"/>Month</label>
			</td>
			<td></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>Increase Amount:</td>
			<td><input type="text" name="lateFee.increaseAmnt" class="normalTextBox"/> Rs. </td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td>Increase After:</td>
			<td>
				<input type="text" name="lateFee.increaseAfter" class="shortTextBoxReq"/>
				<label><input type="radio" name="lateFee.isIncreaseMonth" value="false"/>Days</label>&nbsp;
				<label><input type="radio" name="lateFee.isIncreaseMonth" value="true"/>Month</label>
			</td>
			<td></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Create Late Fee" onclick="javascript:createUpdateBasicMod('createLateFee.action',false,false,'lateFee')""/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
	</table>
</center>