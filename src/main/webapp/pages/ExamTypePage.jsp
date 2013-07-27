<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
  <head>
  <script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<script>
	$(function() {
		for(i=1;i<=4;i++){
		$( "#datepicker"+i ).datepicker({
			changeMonth: true,
			changeYear: true
		});
		}
	});
	$(function(){
		$("#mulSelCombo").multiselect();	
	});
	</script>
</head>
					<center class="formArea">
						<div>
						<form action="" method="post">
							<table>
							<tr><td>&nbsp;</td></tr>
							<s:if test="editable">
									<tr><td><input type="hidden" name="examType.examTypeId" value='<s:property value="examType.examTypeId"/>'/></td></tr>
									<tr>
										<td><label>Exam Type Name</label></td>
										<td><input id="normalTxtReq1" type="text" name="examType.examTypeName" class="normalTextBox" value='<s:property value="examType.examTypeName"/>'/></td>
										<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Exam Type</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Is Grade</label></td>
										<td>
											<label><input type="radio" name="examType.isGrad" value="true" <s:if test="examType.isGrad">checked="checked"</s:if>/>Yes</label>&nbsp;
											<label><input type="radio" name="examType.isGrad" value="false" <s:if test="examType.isGrad==false">checked="checked"</s:if>/>No</label>
										</td>
										<td><span id="radioErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the exam is for grade system</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Percentage To be Contribute</label></td>
										<td><input id="percentReq"  class="normalTextBox" type="text" name="examType.percentToBeContri" value='<s:property value="examType.percentToBeContri"/>' /></td>
										<td><span id="percentReqErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type percentage to be contribute</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Introduced Year</label></td>
										<td><input type="text" name="examType.introducedYear" id="datepicker1" value='<s:property value="examType.introducedYear"/>'/></td>
										<td><span id="datePickerErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select introduce year</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Modified Year</label></td>
										<td><input type="text" name="examType.modifiedYear" id="datepicker2" value='<s:property value="examType.modifiedYear"/>'/></td>
										<td><span id="datePickerErr2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select modified year</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Extra Info</label></td>
										<td><input type="text" name="examType.extraInfo" class="normalTextBox" value='<s:property value="examType.extraInfo"/>'/></td>
										<td><span id="extraInfoErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type if there is any extra info required</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Start Time</label></td>
										<td><input type="text" name="examType.startTime" id="datepicker3" value='<s:property value="examType.startTime"/>'/></td>
										<td><span id="datepickerErr3" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Mention start time</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>End time</label></td>
										<td><input type="text" name="examType.endTime" id="datepicker4" value='<s:property value="examType.endTime"/>'/></td>
										<td><span id="datepickerErr4" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Mention End time</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td>Subjects:</td>
										<td>
											<div class="ui-widget">													
													<select id="mulSelCombo" name="subjectList" multiple="multiple">
														<s:iterator value="fetchedAllSubjects" id="sub">
															<s:set var="isSel" value="true"/>
															<s:iterator value="selExmTypSubjects" id="selSub">
																<s:if test="%{#sub.subjectId==#selSub.subjectId}">
																	<s:set var="isSel" value="false"/>
																	<option value="<s:property value="subjectId"/>" selected="selected"><s:property value="subName"/></option>
																</s:if>
			
															</s:iterator>
																<s:if test="%{#isSel}">
																	<option value="<s:property value="subjectId"/>"><s:property value="subName"/></option>
																</s:if>												
														</s:iterator>
													</select>
											</div>
										</td>
										<td><span id="mulSelErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select subjects to be included</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Is Notify</label></td>
										<td>
											<label><input type="radio" name="examType.isNotify" value="true" <s:if test="examType.isNotify">checked="checked"</s:if>/>Yes</label>&nbsp;
											<label><input type="radio" name="examType.isNotify" value="false" <s:if test="examType.isNotify==false">checked="checked"</s:if>/>No</label>
										</td>
										<td><span id="checkBoxErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Mention if need to notify</span></td>
									</tr> 
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Is History</label></td>
										<td>
											<label><input type="radio" name="examType.isHistory" value="true" <s:if test="examType.isHistory">checked="checked"</s:if>/>Yes</label>&nbsp;
											<label><input type="radio" name="examType.isHistory" value="false" <s:if test="examType.isHistory==false">checked="checked"</s:if>/>No</label>
										</td>
										<td><span id="checkBoxErr2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the exam type is no more required</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr><td>&nbsp;</td><td><input type="submit" value="Update Exam Type" onclick="javascript:createUpdateBasicMod('examTypeUpdateAction.action',true,false,'exmTypeCreate')" /></td><td><div><input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/></div></td></tr>
							</s:if>
							<s:else>
									<tr>
										<td><label>Exam Type Name</label></td>
										<td><input id="normalTxtReq1" type="text" name="examType.examTypeName" class="normalTextBox"/></td>
										<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Exam Type</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Is Grade</label></td>
										<td>
											<label><input type="radio" name="examType.isGrad" value="true"/>Yes</label>&nbsp;
											<label><input type="radio" name="examType.isGrad" value="false"/>No</label>
										</td>
										<td><span id="radioErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the exam is for grade system</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Percentage To be Contribute</label></td>
										<td><input id="percentReq" type="text" name="examType.percentToBeContri" class="normalTextBox"/></td>
										<td><span id="percentReqErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type percentage to be contribute</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Introduced Year</label></td>
										<td><input type="text" name="examType.introducedYear" id="datepicker1"/></td>
										<td><span id="datePickerErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select introduce year</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Modified Year</label></td>
										<td><input type="text" name="examType.modifiedYear" id="datepicker2"/></td>
										<td><span id="datePickerErr2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select modified year</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Extra Info</label></td>
										<td><input type="text" name="examType.extraInfo" class="normalTextBox"/></td>
										<td><span id="extraInfoErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type if there is any extra info required</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Start Time</label></td>
										<td><input type="text" name="examType.startTime" id="datepicker3"/></td>
										<td><span id="datepickerErr3" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Mention start time</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>End time</label></td>
										<td><input type="text" name="examType.endTime" id="datepicker4"/></td>
										<td><span id="datepickerErr4" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Mention End time</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td>Subjects:</td>
										<td>
											<div class="ui-widget">
													<select id="mulSelCombo" name="subjectList" multiple="multiple">
																<s:iterator value="fetchedAllSubjects" >
																	<option value="<s:property value="subjectId"/>"><s:property value="subName"/></option>
																</s:iterator>
													</select>
											</div>
										</td>
										<td><span id="mulSelErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select subjects to be included</span></td>
									</tr>
									<tr><td>&nbsp;</td></tr>
									<tr>
										<td><label>Is Notify</label></td>
										<td>
											<label><input type="radio" name="examType.isNotify" value="true"/>Yes</label>&nbsp;
											<label><input type="radio" name="examType.isNotify" value="false"/>No</label>
										</td>
										<td><span id="radioErr2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Mention if need to notify</span></td>
									</tr> 
									<tr><td>&nbsp;</td></tr>
									<tr><td>&nbsp;</td><td><input type="submit" value="Create Exam Type" onclick="javascript:createUpdateBasicMod('examTypeAction.action',false,false,'exmTypeCreate')" /></td></tr>
							</s:else>
							<tr><td>&nbsp;</td></tr>
							</table>
						</form>
						</div>
						</center>
						
						&nbsp;
					
				