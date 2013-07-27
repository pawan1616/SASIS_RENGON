<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
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
<table>
<tr>
	<td>
	<div id="nav2InstSessSummary.action">
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
	</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<td>
	<div id="done">
		<s:if test="isHistory==false">
			<input type="submit" value="End All Session" id="endAllSession" name="createResult.action"/>
		</s:if>
	</div>
	</td>
	</tr>
</table>
</div>
<div class="tableArea">
	<div class="tableContainerSummary">
				<table id="reportSummary" width="100%">
						        <tr>
						            <th>Session Id</th>
						            <th>Session Name</th>
						            <th>Course</th>
						            <th></th>
						        </tr>
						        <s:iterator value="instSessInfoList">
						        <tr>
						            <td class="editableId" id="instSessInfoId"><s:property  value="instSessInfoId"/></td>
						            <td><s:property value="name"/></td>
						            <td><s:property value="courseInfo.courseName"/></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
						           		<div class="rightDiv">
							               <input type="submit" value="Show Exams >>" class="viewTblRels" name="sessExams"/>
							               <input type="submit" value="End Session" class="endSession" name="createResult.action"/>
							            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">
						                	<ul>
						                		<li><label>Session Id:<s:property value="instSessInfoId"/></label></li>
						                		<li><label>Batch Name:<s:property value="name"/></label></li>
						                		<li><label>Course:<s:property value="courseInfo.courseName"/></label></li>
						                		<li><label>Is History:<s:property value='isHistory'/></label></li>
						                	</ul>
						                </div>
						                <span><h4><a href="nav2InstSessEdit.action" >Edit</a></h4></span>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					        </div>
					       </div>
					        <div class="summaryContainerPopup">
						        <div>&nbsp;</div>
						        <s:iterator value="instSessInfoList" id="instSess">
						         	<div class="sessExams">
						         		<s:iterator value="#instSess.examInfoList" id="exm">
						         		<div class="dividerLine"></div><div class="arrow"></div>
							         		<ul>
							         			<li>Exam Id:<s:property value="#exm.examId"/></li>
							         			<li>Exam Name:<s:property value="#exm.examName"/></li>
							         			<li>Exam Type:<s:property value="#exm.examType.examTypeName"/></li>
							         			<li>Subject:<s:property value="#exm.subjectInfo.subName"/></li>
							         			<li>&nbsp;</li>
							         		</ul>
						         		</s:iterator>
						         	</div>
						         </s:iterator>
					        </div>
					       