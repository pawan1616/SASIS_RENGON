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
	<div id="nav2GradSummary.action">
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
						            <th>Select</th>
									<th>Grad Id</th>
									<th>Range</th>
						            <th>Name</th>
						            <th>Grad-point</th>
						            <th></th>
						        </tr>
						        
						        <s:iterator value="gradInfoList">
						        <tr>
						            <td class="checkBtnPage"><input type="checkbox" name="" value="<s:property value="gradId" />"/></td>
						            <td class="editableId" id="gradInfoId"><s:property value="gradId" /></td>
						            <td><s:property value="lowRange" />-<s:property value='highRange'/></td>
						            <td><s:property value="gradName" /></td>
						            <td><s:property value="gradPoint" /></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">						                	
						                		<div class="leftDiv">
									                	<b>Grad Id : </b><i> <s:property value="gradId" /></i> <br/>
									            		<b>Range : </b><i><s:property value="lowRange"/>-<s:property value="highRange"/></i><br/>
									            		<b>Grad Name : </b><i> <s:property value="gradName" /> </i><br/>
									            		<b>Grad Point: </b><i><s:property value="gradPoint" /> </i><br/>
									            		
									            </div>
												<h4><a href="nav2GradEdit.action"><b>Edit</b></a></h4>	            		
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					  
						</div>
						</div>