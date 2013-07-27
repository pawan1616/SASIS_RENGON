<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<script>
	$(function() {
		$("#crsInstallments").combobox();
		for(i=1;i<=2;i++){
			$("#crsBtch"+i).combobox();
			$("#subexam"+i).combobox();
		}
			$("#btchStd").multiselect();
			$("#sessBatch").combobox();
			$('#divideToInstall').multiselect();
			$('.divideInstall').click(function(){
				$('#divideTo').toggle();
			});
			$('.applyToStd').click(function(){
				$('.selStd').toggle();
			});
	});
	</script>
</head>
<center>
	<table>
		<tr><td>&nbsp;</td></tr>
		<tr><td>Select Course:</td><td>
							<div class="ui-widget">
								<input type="hidden" name="sessFetchTyp" value="active"/>
								<select id="crsInstallments" name="courseId">
								<option value="-1">Select</option>
									<s:iterator value="courseInfoList">
										<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
									</s:iterator>
								</select>
							</div>
						</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><label>Apply to particular Student:</label></td>
				<td>
				<label><input type="radio" value="true" name="otherFee.isParticularStd" class="applyToStd" checked="checked"/>Yes</label>&nbsp;
				<label><input type="radio" value="false" name="otherFee.isParticularStd" class="applyToStd" />No</label>&nbsp;
				</td>
			</tr>
		<tr class="selStd"><td>&nbsp;</td></tr>
		<tr class="selStd"><td>Select Session:</td><td>
							<div class="ui-widget">
							<input type="hidden" name="sessFetchTyp" value="active"/>
								<select id="sessBatch" name="sessId">
									<option value="-1">Select</option>
								</select>
							</div>
						</td></tr>
						<tr class="selStd"><td>&nbsp;</td></tr>
						<tr class="selStd"><td>Select Batch:</td><td>
							<div class="ui-widget">
								<select id="crsBtch2" name="batchId">
									<option value="-1">Select</option>
								</select>
							</div>
						</td></tr>
			<tr class="selStd"><td>&nbsp;</td></tr>
			<tr class="selStd"><td><label>Student:</label></td><td>
					<div class="ui-widget">
							<select id="btchStd" name="stdIdList">
								<option value="-1">Select</option>
							</select>
					
						</div>
			</td></tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td><label>Amount:</label></td><td><input type="text" name="otherFee.amnt" value="" class="normalTextBox"/></td>
			<td>
				<label><input type="radio" value="true" name="otherFee.isAdd" class="divideInstall" checked="checked"/>Add</label>&nbsp;
				<label><input type="radio" value="false" name="otherFee.isAdd" class="divideInstall" />Reduct</label>&nbsp;
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr><td><label>Divide into installment:</label></td>
				<td>
				<label><input type="radio" value="true" name="otherFee.isDivideInstallment" class="divideInstall" checked="checked"/>Yes</label>&nbsp;
				<label><input type="radio" value="false" name="otherFee.isDivideInstallment" class="divideInstall" />No</label>&nbsp;
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr id="divideTo"><td><label>Divide to:</label></td><td>
					<div class="ui-widget">
							<select id="divideToInstall" name="selectedInstallments">
								<option value="-1">Select</option>
							</select>
					
						</div>
			</td></tr>
			<tr><td>&nbsp;</td></tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Create Total Fee" onclick="javascript:createUpdateBasicMod('createOtherAccessories.action',false,false,'otherAccessories')""/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
	</table>
</center>