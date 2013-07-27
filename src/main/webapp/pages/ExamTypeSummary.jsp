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
	<div id="nav2ExamTypeSummary.action">
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
							<div class="tableContainerSummary">
						    <table id="reportSummary" width="100%">
						        <tr>
						            <th>Examtype Id</th>
									<th>Examtype Name</th>
									<th>Is Grade</th>
						            <th>Is History</th>
						            <th></th>
						        </tr>
						        
						        <s:iterator value="fetchedAllExamTypes">
						        <tr>
						            <td class="editableId" id="updateExamTypeId"><s:property value="examTypeId"/></td>
						            <td><s:property value="examTypeName" /></td>
						            <td><s:property value="isGrad" /></td>
						            <td><s:property value="isHistory" /></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
							            <div class="rightDiv">
							               <input type="submit" value="Show Subjects >>" class="viewTblRels" name="exmTypSubs"/>
							            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">						                	
						                		<div class="leftDiv">
									                	<b>Examtype Id : </b><i> <s:property value="examTypeId" /></i><br/>
									            		<b>Examtype Name : </b><i> <s:property value="examTypeName" /></i><br/>
									            		<b>Is Grade : </b><i> <s:property value="isGrad" /></i><br/>
									            		<b>Introduce year : </b><i> <s:property value="introducedYear" /></i><br/>
									            		<b>Modified Year : </b><i> <s:property value="modifiedYear" /></i><br/>
									            </div>
									            <div class="middleDiv">
									            		<b>Extra Info : </b><i> <s:property value="extraInfo" /></i><br/>
									            		<b>Start time : </b><i> <s:property value="startTime" /></i><br/>
									            		<b>End time : </b><i> <s:property value="endTime" /></i><br/>
									            		<b>Is Notify : </b><i> <s:property value="isNotify" /></i><br/>
									            		<b>Is History : </b><i> <s:property value="isHistory" /></i><br/>
									            </div>
									            <h4><a href="nav2ExamTypeUpdate.action">Edit</a></h4>		            		
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					  
						</div>
						</div>
						<div class="summaryContainerPopup">
					        <div>&nbsp;</div>
					         <s:iterator value="fetchedAllExamTypes" id="exmTyp">
					         	<div class="exmTypSubs">
					         		<s:iterator value="#exmTyp.subjectList" id="sub">
					         		<div class="dividerLine"></div><div class="arrow"></div>
						         		<ul>
						         			<li>Subject Id:<s:property value="#sub.subjectId"/></li>
						         			<li>Subject Name:<s:property value="#sub.subName"/></li>
						         			<li>Subject Type:<s:property value="#sub.subtype"/></li>
						         			<li>&nbsp;</li>
						         		</ul>
					         		</s:iterator>
					         	</div>
					         </s:iterator>
					        </div>