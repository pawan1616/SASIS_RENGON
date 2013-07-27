<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sd:head />
<script>
$(function() {
		$( "#combobox1" ).combobox();
	$( "#toggle" ).click(function() {
		$( "#combobox" ).toggle();
	});
});
</script>
</head>
<body>
	<center>
		<table>
			<tr>
				<td><s:form action="stdCreationAction" method="post">
						<s:textfield label="First Name" name="stdInfo.firstName" />
						<s:textfield label="Last Name" name="stdInfo.lastName" />
						<s:textfield label="Initials" name="stdInfo.initials" />
						<s:radio label="Sex" labelposition="left"
							list="{'Male','Female','Others'}" name="stdInfo.sex" />
						<tr>
							<td>&nbsp;</td>
						</tr>
						<s:textfield label="Phone No" name="stdInfo.stdPhoneNo" />
						<s:textfield label="Mobile No" name="stdInfo.stdMobileNo" />
						<s:textfield label="E-Mail" name="stdInfo.stdEmail" />
						<s:textfield label="Address Line 1" name="stdInfo.addLine1" />
						<s:textfield label="Address Line 2" name="stdInfo.addLine2" />
						<s:textfield label="City" name="stdInfo.city" />
						<s:textfield label="State" name="stdInfo.state" />
						<s:textfield label="Country" name="stdInfo.country" />
		</table>
		</td>
		<td>&nbsp;</td>
		<td><table>
				<s:textfield label="Father's Name" name="stdInfo.fathersName" />
				<s:textfield label="Mother's Name" name="stdInfo.mothersName" />
				<s:textfield label="Father's Profession"
					name="stdInfo.fathersProfess" />
				<s:textfield label="Mother's Profession"
					name="stdInfo.mothersProfess" />
				<s:textfield label="Monthly Income" name="stdInfo.monthlyIncome" />
				<s:textfield label="Parent's Phone No" name="stdInfo.parentPhoneNo" />
				<s:textfield label="Parent's Mobile No"
					name="stdInfo.parentMobileNo" />
				<s:textfield label="Parent's Email" name="stdInfo.parentEmail" />
				<s:textfield label="Fax" name="stdInfo.fax" />
				<tr><td>Select Course *:</td><td>
						<div class="ui-widget">
							<select id="combobox1" name="courseInfoId">
								<s:iterator value="courseInfoList">
									<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
								</s:iterator>
							</select>
						</div>
				<td></tr>
			</table>
		</tr>
		<tr>
			<td></td>
			<td><table>
					<s:submit value="Create Student" align="center" />
				</table> </s:form></td>
			<td></td>
		</tr>
		</table>
	</center>
</body>
</html>