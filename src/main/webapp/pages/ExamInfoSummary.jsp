<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<script>
	$(function() {
			$("#combobox1").combobox();
	});
	</script>
</head>
<div class="summaryFilter">
	<div id="nav2ExamSummary.action">
		<select id="combobox1" name="isHistory" >
			<s:if test="isHistory">
				<option value="false">New Records</option>
				<option value="true"  selected="selected">Old Records</option>
			</s:if>
			<s:else>
				<option value="false" selected="selected">New Records</option>
				<option value="true">Old Records</option>
			</s:else>
		</select>
	</div>
</div>
<div class="tableArea">
							<div class="tableFullContainerSummary">
						    <table id="reportSummary" width="100%">
						        <tr>
						            <th>Exam Id</th>
									<th>Exam Name</th>
									<th>Exam Date</th>
						            <th>Subject</th>
						            <th></th>
						        </tr>
						        
						        <s:iterator value="fetchedExamInfos">
						        <tr>
						            <td class="editableId" id="examId"><s:property value="examId"/></td>
						            <td><s:property value="examName" /></td>
						            <td><s:property value="examDate" /></td>
						            <td><s:property value="subjectInfo.subName" /></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">						                	
						                		<div class="leftDiv">
									                	<b>Exam Id : </b><i> <s:property value="examId" /></i><br/>
									                	<b>Course Name : </b><i> <s:property value="courseInfo.courseName" /></i><br/>
									            		<b>Exam Type : </b><i> <s:property value="examType.examTypeName" /></i><br/>
									            		<b>Is Combine Exam : </b><i> <s:property value="isCombineExam" /></i><br/>
									            		<b>Exam Place : </b><i> <s:property value="examPlace" /></i><br/>
									            		<b>Parent Exam : </b><i> <s:property value="parentExam.examName" /></i><br/>
									            		<b>Child Exam : </b><i> <s:property value="childExam.examName" /></i><br/>
									            </div>
									            <div class="middleDiv">
									            		<b>Exam Year : </b><i> <s:property value="examYear" /></i><br/>
									            		<b>Is Percentwise : </b><i> <s:property value="isPercentWise" /></i><br/>
									            		<b>Pass Percent Or Mark : </b><i> <s:property value="passPercentOrMark" /></i><br/>
									            		<b>Percentage To Be Contri : </b><i> <s:property value="percentToBeContri" /></i><br/>
									            		<b>Course : </b><i> <s:property value="courseInfo.courseName" /></i><br/>
									            		<b>Is History : </b><i> <s:property value="isHistory" /></i><br/>
									            </div>
									            <h4><a href="nav2ExamUpdate.action">Edit</a></h4>		            		
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					  
						</div>
						</div>