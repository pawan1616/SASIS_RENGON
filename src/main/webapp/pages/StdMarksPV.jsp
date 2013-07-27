<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
	<script>
	$(function() {
		$('#stdInst').combobox();
		$('#instCrs').combobox();
		$('#crsInstSess').combobox();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
		});
	});
	</script>
</head>
<s:if test="isProfessional">
	<div class="leftsearcpanel">
	<table>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td><b><i>Institute:</i></b></td></tr>
	<tr><td>
		<div class="ui-widget">
									<select id="stdInst" name="courseInfoId">
									<option value="-1">Select</option>
										<s:iterator value="instAdminList">
											<option value='<s:property value="adminId"/>'><s:property value="schoolName"/></option>
										</s:iterator>
									</select>
								</div>
	</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td><b><i>Course:</i></b></td></tr>
	<tr><td>
		<div class="ui-widget">
									<select id="instCrs" name="courseInfoId">
									<option value="-1">Select</option>
										<s:iterator value="courseInfoList">
											<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
										</s:iterator>
									</select>
								</div>
	</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td><b><i>Session:</i></b></td></tr>
		<tr><td>
			<div class="ui-widget">
										<select id="crsInstSess" name="instSessId">
										<option value="-1">Select</option>

										</select>
									</div>
		</td></tr>
		<tr><td>&nbsp;</td></tr>
	</table>
	</div>
	<div class="resultviewpanel">
		<center>
			<table class="marksheetview" border="2" bordercolor="#000000">
				<tr class="msViewTbHeader"></tr>
			</table>
		</center>
	</div>
	<div class="footerspace">
	</div>
</s:if>
<s:else>
	<div class="leftsearcpanel">
		<table>
		<tr><td>&nbsp;</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><b><i>Institute:</i></b></td></tr>
		<tr><td>
			<div class="ui-widget">
										<select id="stdInst" name="courseInfoId">
										<option value="-1">Select</option>
											<s:iterator value="instAdminList">
												<option value='<s:property value="adminId"/>'><s:property value="schoolName"/></option>
											</s:iterator>
										</select>
									</div>
		</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><b><i>Course:</i></b></td></tr>
		<tr><td>
			<div class="ui-widget">
										<select id="instCrs" name="courseId">
										<option value="-1">Select</option>
											<s:iterator value="courseInfoList">
												<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
											</s:iterator>
										</select>
									</div>
		</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><b><i>Session:</i></b></td></tr>
		<tr><td>
			<div class="ui-widget">
										<select id="crsInstSess" name="instSessId">
										<option value="-1">Select</option>

										</select>
									</div>
		</td></tr>
		<tr><td>&nbsp;</td></tr>
		</table>
	</div>
	<div class="resultviewpanel">
		<center>
			<table class="marksheetview" border="2" bordercolor="#000000">
				<tr class="msViewTbHeader"></tr>
			</table>
		</center>
	</div>
	<div class="footerspace">
	</div>
</s:else>