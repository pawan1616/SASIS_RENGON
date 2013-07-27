<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<script>
	$(function() {
		$( "#datepickerReq1" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
	$(function() {
		$("#crsExm").combobox();
		$('#exmTypSub').combobox();
		$('#subExm').combobox();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
		});
	});
	</script>
</head>
	<center>
		<s:if test="isUpdate">			
			<form action="examCreateAction.action" method="post">
					<table>
						<tr><td>&nbsp;</td></tr>
						<tr><td><input type="hidden" name="examInfo.examId" value='<s:property value="examInfo.examId"/>'/></td></tr>
						<tr>
							<td><label>Is Combined Exam</label></td>
							<td>
								<label><input type="radio" name="examInfo.isCombineExam" value="true" <s:if test="examInfo.isCombineExam">checked="checked"</s:if>/>Yes</label>&nbsp;
								<label><input type="radio" name="examInfo.isCombineExam" value="false" <s:if test="examInfo.isCombineExam==false">checked="checked"</s:if>/>No</label>
							</td>
							<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the exam is combined</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td>
							<label>Exam Name</label></td>
							<td><input id="normalTxtReq1" type="text" name="examInfo.examName" class="normalTextBox" value='<s:property value="examInfo.examName"/>'/></td>
							<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Exam Date</label></td>
							<td><input type="text" name="examInfo.examDate" id="datepickerReq1" value='<s:property value="examInfo.examDate"/>'/></td>
							<td><span id="datepickerReqErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Choose exam date</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Exam place</label></td>
							<td><input id="normalTxtReq2" type="text" name="examInfo.examPlace" class="normalTextBox" value='<s:property value="examInfo.examPlace"/>'/></td>
							<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Is Percentage wise</label> </td>
							<td>
								<label><input type="radio" name="examInfo.isPercentWise" value="true" <s:if test="examInfo.isPercentWise">checked="checked"</s:if>/>Yes</label>&nbsp;
								<label><input type="radio" name="examInfo.isPercentWise" value="false" <s:if test="examInfo.isPercentWise==false">checked="checked"</s:if>/>No</label>
							</td>
							<td><span id='checkboxErr2' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the result will be calculate percentagewise</span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Pass Percentage Or Marks</label></td>
							<td><input id="percentReq1" type="text" name="examInfo.passPercentOrMark" class="normalTextBox" value='<s:property value="examInfo.passPercentOrMark"/>'/></td>
							<td><span id="percentReqErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type how much percentage or marks required for pass in the exam</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Total Marks</label></td>
							<td><input id="totalMarks" type="text" name="examInfo.totalMarks" class="normalTextBox" value='<s:property value="examInfo.totalMarks"/>'/></td>
							<td><span id="totalMarksErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type maximum marks of the exam</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Percentage to be contirbute</label></td>
							<td><input id="percentReq2" type="text" name="examInfo.percentToBeContri" class="normalTextBox" value='<s:property value="examInfo.percentToBeContri"/>'/></td>
							<td><span id="percentReqErr2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type percentage to be contribute while calculating the result</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Child Exam Name</label></td>
							<td><input id="childExam" type="text" name="examInfo.childExamName" class="normalTextBox" value='<s:property value="examInfo.childExamName"/>'/></td>
							<td><span id="childExamErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Course</label></td>
									<td width="27%">
										<div class="ui-widget">
											<select id="crsExm" name="courseInfoId" >
											<s:iterator value="courseInfoList" id="crs">
												<s:if test="%{#crs.courseId==examInfo.courseInfo.courseId}">
													<option value="<s:property value="courseId"/>" selected="selected"><s:property value="courseName"/></option>
												</s:if>
												<s:else>
													<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
												</s:else>
											</s:iterator>
											</select>
										</div>
							</td>
							<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select course for this exam from the dropdown</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Exam Type</label></td>
							<td>
								<div class="ui-widget">
											<select id="exmTypSub" name="examtypeId" >
											<s:iterator value="examtypeList" id="exmTyp">
												<s:if test="%{#exmTyp.examTypeId==examInfo.examType.examTypeId}">
													<option value="<s:property value="examTypeId"/>" selected="selected"><s:property value="examTypeName"/></option>
												</s:if>
												<s:else>
													<option value='<s:property value="examTypeId"/>'><s:property value="examTypeName"/></option>
												</s:else>
											</s:iterator>
											</select>
										</div>
							</td>
							<td><span id='comboErr2' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select type of the exam from the dropdown</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Subject</label></td>
							<td>
								<div class="ui-widget">
											<select id="subExm" name="subjectId">
										<s:iterator value="subjectInfoList"  id="sub">
											<s:if test="%{#sub.subjectId==examInfo.subjectInfo.subjectId}">
												<option value="<s:property value="subjectId"/>" selected="selected"><s:property value="subName"/></option>
											</s:if>
											<s:else>
												<option value='<s:property value="subjectId"/>'><s:property value="subName"/></option>
											</s:else>
										</s:iterator>
											</select>
										</div>	
							</td>
							<td><span id='comboErr3' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select subject of the exam from the dropdown</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Is History</label></td>
							<td>
								<label><input type="radio" name="examInfo.isHistory" value="true" <s:if test="examInfo.isHistory">checked="checked"</s:if>/>Yes</label>&nbsp;
								<label><input type="radio" name="examInfo.isHistory" value="false" <s:if test="examInfo.isHistory==false">checked="checked"</s:if>/>No</label>
							</td>
							<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the exam is combined</span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value="Update" onclick="javascript:createUpdateBasicMod('examUpdateAction.action',true,false,'examCreate')"/></td>
							<td><input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
					</table>
				</form>
			</s:if>
		<s:else>
			<form action="examCreateAction.action" method="post">
				<table>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Course</label></td>
								<td width="27%">
									<div class="ui-widget">
										<select id="crsExm" name="courseInfoId">
											<s:iterator value="courseInfoList">
												<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
											</s:iterator>
										</select>
									</div>
						</td>
						<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select course for this exam from the dropdown</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td><label>Exam Type</label></td>
						<td>
							<div class="ui-widget">
										<select id="exmTypSub" name="examtypeId">
											<s:iterator value="examtypeList">
												<option value='<s:property value="examTypeId"/>'><s:property value="examTypeName"/></option>
											</s:iterator>
										</select>
									</div>
						</td>
						<td><span id='comboErr2' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select type of the exam from the dropdown</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td><label>Subject</label></td>
						<td>
							<div class="ui-widget">
										<select id="subExm" name="subjectId">
											<s:iterator value="subjectInfoList">
												<option value='<s:property value="subjectId"/>'><s:property value="subName"/></option>
											</s:iterator>
										</select>
									</div>	
						</td>
						<td><span id='comboErr3' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select subject of the exam from the dropdown</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Is Combined Exam</label></td>
						<td>
							<label><input type="radio" name="examInfo.isCombineExam" value="true"/>Yes</label>&nbsp;
							<label><input type="radio" name="examInfo.isCombineExam" value="false"/>No</label>
						</td>
						<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the exam is combined</span></td>
					</tr> 
					<tr><td>&nbsp;</td></tr>
					<tr><td>
						<label>Exam Name</label></td>
						<td><input id="normalTxtReq1" type="text" name="examInfo.examName" class="normalTextBox"/></td>
						<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Exam Date</label></td>
						<td><input type="text" name="examInfo.examDate" id="datepickerReq1"/></td>
						<td><span id="datepickerReqErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Choose exam date</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Exam place</label></td>
						<td><input id="normalTxtReq2" type="text" name="examInfo.examPlace" class="normalTextBox"/></td>
						<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Is Percentage wise</label> </td>
						<td>
							<label><input type="radio" name="examInfo.isPercentWise" value="true"/>Yes</label>&nbsp;
							<label><input type="radio" name="examInfo.isPercentWise" value="false"/>No</label>
						</td>
						<td><span id='radioErr2' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the result will be calculate percentagewise</span></td>	
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>If Fail All Combine Fail</label> </td>
						<td>
							<label><input type="radio" name="examInfo.ifFailAllCombineFail" value="true"/>Yes</label>&nbsp;
							<label><input type="radio" name="examInfo.ifFailAllCombineFail" value="false"/>No</label>
						</td>
						<td><span id='radioErr3' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;If fail in this exam then fail in all combined exams or not</span></td>	
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>If Fail All Exams Fail</label> </td>
						<td>
							<label><input type="radio" name="examInfo.ifFailAllFail" value="true"/>Yes</label>&nbsp;
							<label><input type="radio" name="examInfo.ifFailAllFail" value="false"/>No</label>
						</td>
						<td><span id='radioErr4' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;If fail in this exam then the result will fail</span></td>	
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Pass Percentage Or Marks</label></td>
						<td><input id="percentReq1" type="text" name="examInfo.passPercentOrMark" class="normalTextBox"/></td>
						<td><span id="percentReqErr1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type how much percentage or marks required for pass in the exam</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Total Marks</label></td>
						<td><input id="totalMarks" type="text" name="examInfo.totalMarks" class="normalTextBox"/></td>
						<td><span id="totalMarksErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type maximum marks of the exam</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Percentage to be contirbute</label></td>
						<td><input id="percentReq2" type="text" name="examInfo.percentToBeContri" class="normalTextBox"/></td>
						<td><span id="percentReqErr2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type percentage to be contribute while calculating the result</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>Child Exam Name</label></td>
						<td><input id="childExam" type="text" name="examInfo.childExamName" class="normalTextBox"/></td>
						<td><span id="childExamErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					
					<tr><td>&nbsp;</td><td><input type="submit" value="Create Exam" onclick="javascript:createUpdateBasicMod('examCreateAction.action',false,false,'examCreate')""/></td></tr>
					<tr><td>&nbsp;</td></tr>
				</table>
			</form>
		</s:else>
	</center>
</body>
</html>