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
		$('#selectCourseOnResult').combobox();
		$('#selectInstSessOnResult').combobox();
		$('#selectBatchOnResult').combobox();
		
	
	});
	</script>
</head>
	<div class="leftsearcpanel">
	<table>
	<tr><td>&nbsp;</td></tr>
	<tr><td>&nbsp;</td></tr>
	
	<tr><td><b><i>Course:</i></b></td></tr>
	<tr><td>
		<div class="ui-widget">
				<select class="pageChangeOnOption" id="selectCourseOnResult" name="courseInfoId">
					<s:iterator value="courseInfoList">
						<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
					</s:iterator>
				</select>
		</div>
	</td></tr>
	<tr>
		<td>
			<label><input type="radio" name="isCrsHistory" value="false" <s:if test="isCrsHistory==false">checked="checked"</s:if>/>New Course</label>&nbsp;
			<label><input type="radio" name="isCrsHistory" value="true" <s:if test="isCrsHistory">checked="checked"</s:if>/>Old Course</label>
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td><b><i>Session:</i></b></td></tr>
	<tr><td>
		<div class="ui-widget">
			<select class="pageChangeOnOption" id="selectInstSessOnResult" name="instSessInfoId">
				<s:iterator value="instSessInfoList">
					<option value=<s:property value="instSessInfoId"/>><s:property value="name"/></option>
				</s:iterator>
			</select>
		</div>
				
	</td></tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td><b><i>Batch:</i></b></td></tr>
	<tr><td>
		<div class="ui-widget">
			<select class="pageChangeOnOption" id="selectBatchOnResult" name="batchId">
				<option value=-1>All</option>
												
			</select>
		</div>
				
	</td></tr>
	<tr><td>&nbsp;</td></tr>
	</table>
	</div>
	<div class="resultviewpanel">
		<center>
			<jsp:include page="InstResultPanel.jsp"/>
		</center>
	</div>
	<div class="footerspace">
	</div>
