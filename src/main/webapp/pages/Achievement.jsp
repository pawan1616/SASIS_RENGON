<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="isEdit">
<div class="editDiv">
	<center>
				<form action="" method="post">
					<s:if test="isUpdate">
						<table>
							<tr><td>&nbsp;</td></tr>
							<tr><td><label>Achievement Name:</label></td><td><input type="text" name="achieve.achieveName" class="normalTextBox" value='<s:property value="achieve.achieveName"/>'/></td></tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td><label>Achievement Description:</label></td><td><textarea name="achieve.achieveDescription"><s:property value="achieve.achieveDescription"/></textarea></td></tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>&nbsp;</td><td><input type="submit" value="Update" onclick="javascript:submitUserCreate('achieveUpdate.action',true)"/></td><td><input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/></td></tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>&nbsp;</td></tr>
						</table>
					</s:if>
					<s:else>
						<table>
							<tr><td>&nbsp;</td></tr>
							<tr><td><label>Achievement Name:</label></td><td><input type="text" name="achieve.achieveName" class="normalTextBox"/></td></tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td><label>Achievement Description:</label></td><td><textarea name="achieve.achieveDescription"></textarea></td></tr>
							<tr><td>&nbsp;</td></tr>
							<tr><td>&nbsp;</td><td><input type="submit" value="Add" onclick="javascript:submitUserCreate('achieveCreation.action',false)"/></td></tr>
						</table>
					</s:else>
				</form>
	</center>
</div>
<s:if test="isUpdate"></s:if>
<s:else>
<center>
<div class="tableContainer">
		
						    <table id="report">
						        <tr>
						            <th>Select</th>
						            <th>Achievement Id</th>
									<th>Achievement Name</th>
									<th>Modified Date</th>
						            
						            <th></th>
						        </tr>
						        
						        <s:iterator value="achieveList">
						        <tr>
						            <td class="checkBtnPage"><input type="checkbox" name="" value='<s:property value="achieveId" />'/></td>
						            <td><s:property value="achieveId" /></td>
						            <td><s:property value="achieveName" /></td>
						            <td><s:property value="modifiedDate" /></td>
						        </tr>
						        <tr>
						            <td colspan="5">
							            <div class="rightDiv">
							               <a href="getUpdateableAchieve.action">Edit</a>
							            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">
						                	<table>
						                	<b>Achievement Id : </b><i> <s:property value="achieveId" /></i><br/>
						            		<b>Achievement Name : </b><i> <s:property value="achieveName" /></i><br/>
						            		<b>Date modified : </b><i> <s:property value="modifiedDate" /></i><br/>
						            		<b>Achievement Description : </b><i> <s:property value="achieveDescription" /></i>						            		
						            		</table>
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
					</div>
				</center>
	</s:else>				
	</s:if>
	<s:else>
		<table  width='100%'>
						<s:iterator value="achieveList">
							<tr>
								<td width="20%"><s:property value="achieveName"/></td>
								<td><s:property value="achieveDescription"/></td>
							</tr>			
							<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
							<tr><td>&nbsp;</td><td>&nbsp;</td></tr>				
						</s:iterator>
		</table>
	</s:else>