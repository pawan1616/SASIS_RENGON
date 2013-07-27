<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
	<script>
	$(function() {
		for(i=1;i<=2;i++){
			$("#crsBtch"+i).combobox();
			$("#subexam"+i).combobox();
		}
			$("#btchStd").multiselect();
			$("#sessBatch").combobox();
			$('#divideToInstall').multiselect();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
		});
		$('.divideInstall').click(function(){
			$('#divideTo').toggle();
			});
	});
	</script>
</head>
<center>
	<form action="" method="post">
		<table>
			<tr><td>&nbsp;</td></tr>
			<tr><td>Select Course:</td><td>
							<div class="ui-widget">
								<input type="hidden" name="sessFetchTyp" value="active"/>
								<select id="crsBtch1" name="courseId">
								<option value="-1">Select</option>
									<s:iterator value="courseInfoList">
										<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
									</s:iterator>
								</select>
							</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>Select Session:</td><td>
							<div class="ui-widget">
							<input type="hidden" name="sessFetchTyp" value="active"/>
								<select id="sessBatch" name="sessId">
									<option value="-1">Select</option>
								</select>
							</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>Select Batch:</td><td>
							<div class="ui-widget">
								<select id="crsBtch2" name="batchId">
									<option value="-1">Select</option>
								</select>
							</div>
						</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Student:</label></td><td>
					<div class="ui-widget">
							<select id="btchStd" name="stdIdList">
								<option value="-1">Select</option>
							</select>
					
						</div>
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Amount:</label></td><td><input type="text" name="scholShip.amnt" value="" class="normalTextBox"/></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Divide into installment:</label></td>
				<td>
				<label><input type="radio" value="true" name="scholShip.isDivide" class="divideInstall" checked="checked"/>Yes</label>&nbsp;
				<label><input type="radio" value="false" name="scholShip.isDivide" class="divideInstall" />No</label>&nbsp;
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr id="divideTo"><td><label>Divide to:</label></td><td>
					<div class="ui-widget">
							<select id="divideToInstall" name="noOfInstallment">
								<option value="-1">Select</option>
							</select>
					
						</div>
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label></label></td><td><input type="submit" value="Create Scholarship" onclick="javascript:createUpdateBasicMod('fee/createScholarship.action',false,false,'scholarShip')"></td></tr>
		</table>
	</form>
	&nbsp;<br>
	&nbsp;<br>
</center>
</html>