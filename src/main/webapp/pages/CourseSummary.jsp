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
	<div id="nav2CourseSummary.action">
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
						            <th>Select</th>
									<th>Course Id</th>
									<th>Course Name</th>
						            <th>Course Type</th>
						            <th></th>
						        </tr>
						        
						        <s:iterator value="fetchedAllCourse">
						        <tr>
						            <td class="checkBtnPage"><input type="checkbox" name="" value="<s:property value="courseId" />"/></td>
						            <td class="editableId" id="updateCourseId"><s:property value="courseId" /></td>
						            <td><s:property value="courseName" /></td>
						            <td><s:property value="courseType" /></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
							            <div class="rightDiv">
							               <input type="submit" value="Show Subjects >>" class="viewTblRels" name="crsSubs"/>
							            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">						                	
						                		<div class="leftDiv">
									                	<b>Course Id : </b><i> <s:property value="courseId" /></i> <br/>
									            		<b>Course Name : </b><i> <s:property value="courseName" /> </i><br/>
									            		<b>Course Type : </b><i> <s:property value="courseType" /> </i><br/>
									            		<b>Is Professional: </b><i><s:property value="isProfessional" /> </i><br/>
									            		<b>Total No. of Seat: </b><i><s:property value="totalNoOfSeat"/> </i><br>
									            		
									            </div>
									            <div class="middleDiv">
									            		<b>Introduce year : </b><i> <s:property value="introducedYear" /></i><br/>
									            		<b>Modified Year : </b><i> <s:property value="modifiedYear" /></i><br/>
									            		<b>Previous Course : </b><i> <s:property value="previousCourse.courseName" /></i><br/>
									            		<b>Next Course : </b><i> <s:property value="nextCourse.courseName" /></i><br/>
									            		
									            </div>
									            <s:url action="nav2CourseUpdate.action" var="urlTag">
														<s:param name="updateCourseId"><s:property value="courseId" /></s:param>
													</s:url>
												<h4><a href="nav2CourseUpdate.action"><b>Edit</b></a></h4>	            		
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					  
						</div>
						</div>
						 <div class="summaryContainerPopup">
					        <div>&nbsp;</div>
					         <s:iterator value="fetchedAllCourse" id="crs">
					         	<div class="crsSubs">
					         		<s:iterator value="#crs.subjectList" id="sub">
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