<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
 <head>
 <script type="text/javascript" src="js/autocompleteCombobox.js"></script>
 <script>
	$(function() {
		for(i=1;i<=2;i++){
		$( "#datepicker"+i ).datepicker({
			changeMonth: true,
			changeYear: true
		});
		}
	});
	$(function(){
		for(i=1;i<=2;i++){
			$("#mulSelCombo"+i).multiselect();
		}	
	});
	$(function() {
		for(i=1;i<=3;i++)
			$( "#combobox"+i ).combobox();
		$( "#toggle" ).click(function() {
			$( "#combobox" ).toggle();
		});
	});
	</script>
 </head>
	<center>
	<table >
		<tr>
			<td id="createTD">
					<form action="courseCreateAction" method="post">
						<s:if test="isUpdate">
							<tr><td>&nbsp;</td></tr>
							<tr><td><input type="hidden" name="courseInfo.courseId" value='<s:property value="courseInfo.courseId"/>'/></td></tr>
							<tr>
								<td><label>*Course Name :</label></td>
								<td><input id="normalTxtReq1" type="text" name="courseInfo.courseName" class="normalTextBox" value='<s:property value="courseInfo.courseName"/>'/></td>
								<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							
							<tr><td><label>Course Type</label></td>
								<td>
									<div class="ui-widget">
										<select id="combobox1" name="courseInfo.courseType">
											<option value="Degree">Degree</option>
											<option value="Diploma">Diploma</option>
											<option value="Certificate">Certificate</option>
											<option value="School Standard">School Standard</option>
										</select>
									</div>
								</td>
								<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select course type from the dropdown</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Is Professional</label></td>
								<td>
									<label><input type="radio" name="courseInfo.isProfessional" value="true" <s:if test="courseInfo.isProfessional">checked="checked"</s:if>/>Yes</label>&nbsp;
									<label><input type="radio" name="courseInfo.isProfessional" value="false" <s:if test="courseInfo.isProfessional==false">checked="checked"</s:if>/>No</label>
								</td>
								<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the course is professional</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Total No. of seats</label></td>
								<td><input id="normalTxtReq2" type="text" name="courseInfo.totalNoOfSeat" value='<s:property value="courseInfo.totalNoOfSeat"/>' class="normalTextBox"/></td>
								<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type Total No. of seats</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Introduced Year</label></td>
								<td><input type="text" name="courseInfo.introducedYear" value='<s:property value="courseInfo.introducedYear"/>' id="datepicker1"/></td>
								<td><span id="datepickerDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Choose a date</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Modified Year</label></td>
								<td><input type="text" name="courseInfo.modifiedYear" value='<s:property value="courseInfo.modifiedYear"/>' id="datepicker2"/></td>
								<td><span id="datepickerDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Choose a date</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Is History</label></td>
								<td>
									<label><input type="radio" name="courseInfo.isHistory" value="true" <s:if test="courseInfo.isHistory">checked="checked"</s:if>/>Yes</label>&nbsp;
									<label><input type="radio" name="courseInfo.isHistory" value="false" <s:if test="courseInfo.isHistory==false">checked="checked"</s:if>/>No</label>
								</td>
								<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the course is professional</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>Subjects</td>
								<td>
									<div class="ui-widget">
										<select id="mulSelCombo1" name="subjectList" multiple="multiple">
											
											<s:iterator value="fetchedAllSubjects" id="sub">
												<s:set var="isSel" value="true"/>
												<s:iterator value="selectedFetchedSubs" id="selSub">
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
								<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select Subjects from the list</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>Exam Types</td>
								<td>
									<div class="ui-widget">
										<select id="mulSelCombo2" name="examTypeList" multiple="multiple">
											<s:iterator value="fetchedAllExamType" id="exmType">
												<s:set var="isSel" value="true"/>
												<s:iterator value="selectedExmTypes" id="selExmType">
													<s:if test="%{#exmType.examTypeId==#selExmType.examTypeId}">
														<s:set var="isSel" value="false"/>
														<option value="<s:property value="examTypeId"/>" selected="selected"><s:property value="examTypeName"/></option>
													</s:if>

												</s:iterator>
													<s:if test="%{#isSel}">
														<option value="<s:property value="examTypeId"/>"><s:property value="examTypeName"/></option>
													</s:if>												
											</s:iterator>
										</select>
									</div>
								</td>
								<td><span id="mulSelComboDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select Exam Type from the list</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>Next Course</td>
								<td>
									<div class="ui-widget">
										<select id="combobox2" name="nextCourse">
											<s:iterator value="fetchedAllCourse" id="crs">
												<s:if test="%{#crs.courseId==courseInfo.nextCourse.courseId}">
													<option value="<s:property value="courseId"/>" selected="selected"><s:property value="courseName"/></option>
												</s:if>
												<s:else>
													<s:iterator value="fetchedAllCourse" >
														<option value="<s:property value="courseId"/>"><s:property value="courseName"/></option>
													</s:iterator>
												</s:else>
											</s:iterator>
										</select>
									</div>
								</td>
								<td><span id='comboErr2' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select the next course from the dropdown</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>Previous Course</td>
								<td>
									<div class="ui-widget">
										<select id="combobox3" name="previousCourse">
											<s:iterator value="fetchedAllCourse" id="crs">
												<s:if test="%{#crs.courseId==courseInfo.previousCourse.courseId}">
													<option value="<s:property value="courseId"/>" selected="selected"><s:property value="courseName"/></option>
												</s:if>
												<s:else>
													<s:iterator value="fetchedAllCourse" >
														<option value="<s:property value="courseId"/>"><s:property value="courseName"/></option>
													</s:iterator>
												</s:else>
											</s:iterator>
										</select>
									</div>
								</td>
								<td><span id='comboErr3' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select the previous course from the dropdown</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td>
									<div align="right">
										<input type="submit" name="btnPressed" value="Update"  onclick="javascript:createUpdateBasicMod('courseCreateAction.action',true,false,'courseCreate')"  />
									</div>
								</td>
								<td>
									<div align="center">
										<input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/>
									</div>
								</td>
							</tr>
						</s:if>
						<s:else>
						<table>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Course Name</label></td>
								<td><input id="normalTxtReq1" type="text" name="courseInfo.courseName" class="normalTextBox"/></td>
								<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Course Name</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td><label>Course Type</label></td>
								<td>
									<div class="ui-widget">
										<select id="combobox1" name="courseInfo.courseType">
											<option value="Degree">Degree</option>
											<option value="Diploma">Diploma</option>
											<option value="Certificate">Certificate</option>
											<option value="School Standard">School Standard</option>
										</select>
									</div>
								</td>
								<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select course type from the dropdown</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Is Professional</label></td>
								<td>
									<label><input type="radio" name="courseInfo.isProfessional" value="true"/>Yes</label>&nbsp;
									<label><input type="radio" name="courseInfo.isProfessional" value="false"/>No</label>
								</td>
								<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the course is professional</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Total No. of seats</label></td>
								<td><input id="normalTxtReq2" type="text" name="courseInfo.totalNoOfSeat" class="normalTextBox"/></td>
								<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type Total No. of seats</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Introduced Year</label></td>
								<td><input type="text" name="courseInfo.introducedYear" id="datepicker1"/></td>
								<td><span id="datepickerDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Choose a date</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td><label>Modified Year</label></td>
								<td><input type="text" name="courseInfo.modifiedYear" id="datepicker2"/></td>
								<td><span id="datepickerDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Choose a date</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>					
							<tr><td><label>Subjects</label></td>
								<td>
									<select id="mulSelCombo1" name="subjectList" multiple="multiple">
										<s:iterator value="fetchedAllSubjects" >
											<option value="<s:property value="subjectId"/>"><s:property value="subName"/></option>
										</s:iterator>
									</select>
								</td>
								<td><span id="mulSelComboDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select subjects from the list</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td><label>Exam Types</label></td>
								<td>
									<select id="mulSelCombo2" name="examTypeList" multiple="multiple">
										<s:iterator value="fetchedAllExamType" >
											<option value="<s:property value="examTypeId"/>"><s:property value="examTypeName"/></option>
										</s:iterator>
									</select>
								</td>
								<td><span id="mulSelComboDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select Exam Types from the list</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>Next Course</td>
								<td>
									<div class="ui-widget">
										
										<select id="combobox2" name="nextCourse">
											<option value=-1>Select One</option>
											<s:iterator value="fetchedAllCourse">
												<option value=<s:property value="courseId"/>><s:property value="courseName"/></option>
											</s:iterator>
										</select>
									</div>
								</td>
								<td><span id='comboErr2' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select the next course from the dropdown</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>Previous Course</td>
								<td>
									<div class="ui-widget">
										<select id="combobox3" name="previousCourse">
											<option value=-1>Select One</option>
											<s:iterator value="fetchedAllCourse">
												<option value=<s:property value="courseId"/>><s:property value="courseName"/></option>
											</s:iterator>
										</select>
									</div>
								</td>
								<td><span id='comboErr3' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select the previous course from the dropdown</span></td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>&nbsp;</td><td><input type="submit" name="btnPressed" value="Create" onclick="javascript:createUpdateBasicMod('courseCreateAction.action',false,false,'courseCreate')" /></td></tr>
						</table>
						</s:else>
					</form>
			</td>
			
		</tr>

	</table>
	</center>
						
						&nbsp;<br>
						&nbsp;<br>