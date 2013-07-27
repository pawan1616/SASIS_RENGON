<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
	<script type="text/javascript">
	$(function() {
		$( "#crsexmInfo" ).combobox();
		$( "#mulSelCombo1" ).multiselect();
		$("#mulSelCombo2").multiselect();
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
			<tr><td><input type="hidden" name="instSessInfo.instSessInfoId" value='<s:property value="instSessInfo.instSessInfoId"/>'/></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Session Name or year:</label></td>
				<td><input id="normalTxtReq1" type="text" name="instSessInfo.name" value='<s:property value="instSessInfo.name"/>' class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Batch Name</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Course Info:</label></td>
				<td width="34%">
					<div class="ui-widget">
							<select id="crsexmInfo" name="courseId" >
								<s:iterator value="courseInfoList" id="crs">
								<s:if test="%{#crs.courseId==instSessInfo.courseInfo.courseId}">
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
				<td><label>Batch :</label></td><td>
						<div class="ui-widget">
							<select id="mulSelCombo2" name="batchIds" multiple="multiple">
								<s:iterator value="batchInfoList">
									<option value='<s:property value="batchId"/>' selected="selected"><s:property value="batchName"/></option>
								</s:iterator>
							</select>
						</div>
				</td>
				<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select exams from the list</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Exams :</label></td><td>
						<div class="ui-widget">
							<select id="mulSelCombo1" name="examIds" multiple="multiple">
								<s:iterator value="examInfoList" id="sess">
									<s:set var="isSel" value="true"/>
									<s:iterator value="instSessInfo.examInfoList" id="selSess">
										<s:if test="%{#sess.examId==#selSess.examId}">
											<s:set var="isSel" value="false"/>
											<option value="<s:property value="examId"/>" selected="selected"><s:property value="examName"/></option>
										</s:if>
									</s:iterator>
									<s:if test="%{#isSel}">
										<option value='<s:property value="examId"/>'><s:property value="examName"/></option>
									</s:if>	
								</s:iterator>
							</select>
						
						</div>
				</td>
				<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select exams from the list</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Is History</label></td>
				<td>
					<label><input type="radio" name="instSessInfo.isHistory" value="true" <s:if test="instSessInfo.isHistory">checked="checked"</s:if>/>Yes</label>&nbsp;
					<label><input type="radio" name="instSessInfo.isHistory" value="false" <s:if test="instSessInfo.isHistory==false">checked="checked"</s:if>/>No</label>
				</td>
				<td><span id="radioerr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the Session is no more required</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td>
				<td><input type="submit" value="Update" onclick="javascript:createUpdateBasicMod('instSessInfoCreate.action',true,false,'instSessCreate')"/></td>
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
				<td><label>Session Name or year:</label></td>
				<td><input id="normalTxtReq1" type="text" name="instSessInfo.name" class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Batch Name</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Course Info:</label></td>
				<td width="34%">
					<div class="ui-widget">
							<select id="crsexmInfo" name="courseId" >
								<s:iterator value="courseInfoList">
									<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
								</s:iterator>
							</select>
						</div>
				</td>
				<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select course for the batch from the dropdown</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Batch :</label></td><td>
						<div class="ui-widget">
							<select id="mulSelCombo2" name="batchIds" multiple="multiple">
								<s:iterator value="batchInfoList">
									<option value='<s:property value="batchId"/>'><s:property value="batchName"/></option>
								</s:iterator>
							</select>
						</div>
				</td>
				<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select exams from the list</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Exams :</label></td><td>
						<div class="ui-widget">
							<select id="mulSelCombo1" name="examIds" multiple="multiple">
								<s:iterator value="examInfoList">
									<option value='<s:property value="examId"/>'><s:property value="examName"/></option>
								</s:iterator>
							</select>
						</div>
				</td>
				<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select exams from the list</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td><td><input type="submit" value="Create Session" onclick="javascript:createUpdateBasicMod('instSessInfoCreate.action',false,false,'instSessCreate')"/></td></tr>
		</table>
	</form>
	</s:else>
</center>