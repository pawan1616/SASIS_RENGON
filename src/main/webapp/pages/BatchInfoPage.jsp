<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
	<script type="text/javascript">
	$(function() {
		$( "#combobox1" ).combobox();
		$( "#mulSelCombo1" ).multiselect();
	$( "#toggle" ).click(function() {
		$( "#crsStd" ).toggle();
	});
});
	</script>
</head>
<center>
	<s:if test="isUpdate">
			<form action="" method="post" >
		<table>
			<tr><td>&nbsp;</td></tr>
			<tr><td><input type="hidden" name="batchInfo.batchId" class="normalTextBox" value='<s:property value="batchInfo.batchId"/>'/></td></tr>
			<tr>
				<td><label>Batch Name:</label></td>
				<td><input id="normalTxtReq1" type="text" name="batchInfo.batchName" class="normalTextBox" value='<s:property value="batchInfo.batchName"/>'/></td>
				<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Batch Name</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Max. no of Students:</label></td>
				<td><input id="normalTxtReq2" type="text" name="batchInfo.maxNoOfStd" class="normalTextBox" value='<s:property value="batchInfo.maxNoOfStd"/>'/></td>
				<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type estimate of maximum no of students to be in the class</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Course Info:</label></td>
				<td width="34%">
					<div class="ui-widget">
							<select id="combobox1" name="crsInfoId" >
								<s:iterator value="crsInfoList" id="crs">
									<s:if test="%{#crs.courseId==batchInfo.courseInfo.courseId}">
										<option value="<s:property value="courseId"/>" selected="selected"><s:property value="courseName"/></option>
									</s:if>
									<s:else>
											<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
									</s:else>
								</s:iterator>
							</select>
						</div>
				</td>
				<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select course for the batch from the dropdown</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Is History</label></td>
					<td>
						<label><input type="radio" name="batchInfo.isHistory" value="true" <s:if test="batchInfo.isHistory">checked="checked"</s:if>/>Yes</label>&nbsp;
						<label><input type="radio" name="batchInfo.isHistory" value="false" <s:if test="batchInfo.isHistory==false">checked="checked"</s:if>/>No</label>
					</td>
				<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the course is professional</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Student:</label></td><td>
						<div class="ui-widget">
								<select id="mulSelCombo1" name="stdInfoIds" multiple="multiple">

								</select>
						
							</div>
				</td>
				<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select students for the batch from the list</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td>
				<td><input type="submit" value="Update" onclick="javascript:createUpdateBasicMod('batchUpdateAction.action',true,false,'batchCreate')"/></td>
				<td><input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/></td>
			</tr>
		</table>
	</form>
	</s:if>
	<s:else>
	<form action="" method="post" >
		<table>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Batch Name:</label></td>
				<td><input id="normalTxtReq1" type="text" name="batchInfo.batchName" class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Batch Name</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Max. no of Students:</label></td>
				<td><input id="normalTxtReq2" type="text" name="batchInfo.maxNoOfStd" class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type estimate of maximum no of students to be in the class</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Course Info:</label></td>
				<td width="34%">
					<div class="ui-widget">
							<select id="combobox1" name="crsInfoId" >
								<s:iterator value="crsInfoList">
									<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
								</s:iterator>
							</select>
						</div>
				</td>
				<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select course for the batch from the dropdown</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Student:</label></td><td>
						<div class="ui-widget">
								<select id="mulSelCombo1" name="stdInfoIds" multiple="multiple">

								</select>
						
							</div>
				</td>
				<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select students for the batch from the list</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td><td><input type="submit" value="Create Batch" onclick="javascript:createUpdateBasicMod('batchCreateAction.action',false,false,'batchCreate')"/></td></tr>
		</table>
	</form>
	</s:else>
</center>