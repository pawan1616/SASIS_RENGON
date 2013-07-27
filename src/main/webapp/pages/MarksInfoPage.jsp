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
			$("#btchStd").combobox();
			$("#sessBatch").combobox();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
		});
	});
	</script>
</head>
<center>
	<s:if test="isUpdate">
		<form action="" method="post">
		<table>
			<tr><td>&nbsp;</td></tr>
			<tr><td><input type="hidden" value="marksInfo.markId"/></td></tr>
			<tr><td><label>Marks Obtain:</label></td><td><input type="text" name="marksInfo.marksObtained" value="<s:property value='marksInfo.marksObtained'/>" class="normalTextBox"/></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Remarks:</label></td><td><input type="text" name="marksInfo.remarks" value="<s:property value='marksInfo.remarks'/>" class="normalTextBox"/></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>Select Course:</td><td>
							<div class="ui-widget">
								<input type="hidden" name="sessFetchTyp" value="active"/>
								<select id="crsBtch1" name="courseInfoId">								
									<s:iterator value="courseInfoList" id="crs">
										<s:if test="%{#crs.courseId==marksInfo.examInfo.courseInfo}">
											<option value="<s:property value="courseId"/>" selected="selected"><s:property value="courseName"/></option>
										</s:if>
									<s:else>
											<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
									</s:else>
								</s:iterator>
								</select>
							</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>Select Session:</td><td>
							<div class="ui-widget">
							<input type="hidden" name="sessFetchTyp" value="active"/>
								<select id="sessBatch" name="instSessId">
									<option value="<s:property value='marksInfo.examInfo.instSess.instSessInfoId'/>"><s:property value='marksInfo.examInfo.instSess.name'/></option>
								</select>
							</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>Select Batch:</td><td>
							<div class="ui-widget">
								<select id="crsBtch2" name="btchInfoId">
									<option value="<s:property value='btchInfo.batchId'/>"><s:property value='btchInfo.batchName'/></option>
								</select>
							</div>
						</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Student:</label></td><td>
					<div class="ui-widget">
							<select id="btchStd" name="stdId">
								<option value="<s:property value='marksInfo.stdInfo.stdId'/>"><s:property value="marksInfo.stdInfo.stdId"/>&nbsp;<s:property value="marksInfo.stdInfo.firstName"/>&nbsp;<s:property value="marksInfo.stdInfo.lastName"/></option>
							</select>
					
						</div>
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Subject:</label></td><td>
						<div class="ui-widget">
										<input type="hidden" name="fetchReq" value="new">
										<select id="subexam1" name="subId">											
											<s:iterator value="subjectInfoList" id="sub">
												<s:if test="%{#sub.subjectId==marksInfo.examInfo.subjectInfo.subjectId}">
													<option value="<s:property value="subjectId"/>" selected="selected"><s:property value="subName"/></option>
												</s:if>
												<s:else>
														<option value='<s:property value="subjectId"/>'><s:property value="subName"/></option>
												</s:else>
											</s:iterator>											
										</select>
									</div>
			
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Exam:</label></td><td>
						<div class="ui-widget">
										<select id="subexam2" name="exmId">
												<option value=<s:property value="marksInfo.getExamInfo().getExamId()"/>><s:property value="marksInfo.getExamInfo().getExamName()"/></option>								
										</select>
									</div>
			
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label></label></td>
				<td><input type="submit" value="Update Marks" onclick="javascript:submitUserCreate('marksCreationAction.action',true)"></td>
				<td><input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/></td>
			</tr>
		</table>
	</form>
	</s:if>
	<s:else>
	<form action="" method="post">
		<table>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Marks Obtain:</label></td><td><input type="text" name="marksInfo.marksObtained" class="normalTextBox"/></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Remarks:</label></td><td><input type="text" name="marksInfo.remarks" class="normalTextBox"/></td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td>Select Course:</td><td>
							<div class="ui-widget">
								<input type="hidden" name="sessFetchTyp" value="active"/>
								<select id="crsBtch1" name="courseInfoId">
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
								<select id="sessBatch" name="instSessId">
									<option value="-1">Select</option>
								</select>
							</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>Select Batch:</td><td>
							<div class="ui-widget">
								<select id="crsBtch2" name="btchInfoId">
									<option value="-1">Select</option>
								</select>
							</div>
						</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Student:</label></td><td>
					<div class="ui-widget">
							<select id="btchStd" name="stdId">
								<option value="-1">Select</option>
							</select>
					
						</div>
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Subject:</label></td><td>
						<div class="ui-widget">
										<input type="hidden" name="fetchReq" value="new">
										<select id="subexam1" name="subId">
											<option value=-1>Select One</option>
											<s:iterator value="subjectInfoList">
												<option value=<s:property value="subjectId"/>><s:property value="subName"/></option>
											</s:iterator>
										</select>
									</div>
			
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label>Exam:</label></td><td>
						<div class="ui-widget">
										<select id="subexam2" name="exmId">
											<option value=-1>Select One</option>
												<s:iterator value="subjectInfoList">
												<option value=<s:property value="subjectId"/>><s:property value="subName"/></option>
											</s:iterator>								
										</select>
									</div>
			
			</td></tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td><label></label></td><td><input type="submit" value="Insert Marks" onclick="javascript:submitUserCreate('marksCreationAction.action',false)"></td></tr>
		</table>
	</form>
	</s:else>
	&nbsp;<br>
	&nbsp;<br>
</center>
</html>