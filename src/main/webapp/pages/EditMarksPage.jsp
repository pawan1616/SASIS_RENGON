<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
	<script>
	$(function() {
		for(i=1;i<=2;i++){
			$("#crsBtch"+i).combobox();
			$("#subexam"+i).combobox();
		}
			$("#btchStd").combobox();
			$("#mrkEditSess").combobox();
			$("#sessBatch").combobox();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
		});
	});
	</script>
</head>
<div class="leftsearcpanel">
<table>
<tr><td>&nbsp;</td></tr>
<tr><td><b><i>Search Student:</i></b></td></tr>
<tr><td><input type="text" name="" class="normalTextBox"/></td><td><img src="images/search-icon.png"></td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td><b><i>Course:</i></b></td></tr>
<tr><td>
	<div class="ui-widget">
								<input type="hidden" name="sessFetchTyp" value="all"/>
								<select id="crsBtch1" name="courseInfoId">
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
							<input type="hidden" name="sessFetchTyp" value="all"/>
								<select id="sessBatch" name="instSessId">
									<option value="-1">Select</option>
								</select>
							</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
<tr><td><b><i>Select Batch:</i></b></td></tr>
<tr><td>
	<div class="ui-widget">
								<input type="hidden" name="viewType" value="json">
								<select id="crsBtch2" name="btchInfoId">
									<option value="-1">Select</option>
								</select>
							</div>
</td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td><b><i>Students:</i></b></td></tr>
<tr><td>
	<div class="ui-widget">
								<select id="btchStd" name="stdId">
									<option value="-1">Select</option>
								</select>
							</div>
</td></tr>
<tr><td>&nbsp;</td></tr>
</table>
</div>
<div class="resultviewpanel">

</div>
<div class="footerspace">

</div>