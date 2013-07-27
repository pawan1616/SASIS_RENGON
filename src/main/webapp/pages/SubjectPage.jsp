<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
						<center>

				<table>
					<tr><td>
						<form action="subjectAction.action" method="post">
							<table>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>*Subject Name :</label> </td>
									<td><input id="normalTxtReq1" type="text" class="normalTextBox" name="subjectInfo.subName" /></td>
									<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the Subject Name</span></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr>
									<td><label>*Subject Type :</label></td>
									<td><input id="normalTxtReq2" type="text" class="normalTextBox" name="subjectInfo.subType" /></td>
									<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type if the subject is Compulsory or not, or other type</span></td>
								</tr>
								<tr><td>&nbsp;</td></tr>
								<tr><td>&nbsp;</td><td><input type="submit" value="Create Subject" onclick="javascript:createUpdateBasicMod('subjectAction.action',false,false,'subCreate')"/></td></tr>
							</table>
						</form>
					
					</td></tr>
					<tr><td>
									<div class="tableContainer">
						    <table id="report">
						        <tr>
						            <th>Select</th>
						            <th>Subject Id</th>
									<th>Subject Name</th>
									<th>Subject Type</th>
						            
						            <th></th>
						        </tr>
						        
						        <s:iterator value="allSubjects">
						        <tr>
						            <td class="checkBtnPage"><input type="checkbox" name="" value="<s:property value="subjectId" />"/></td>
						            <td class="editableId" id="subId"><s:property value="subjectId" /></td>
						            <td><s:property value="subName" /></td>
						            <td><s:property value="subType" /></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
							            <div class="rightDiv">
							              <h4 class="delete"><a href="nav2SubjectDelete.action">Delete</a></h4> 
							            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">
						                	<table>
						                	<b>Subject Id : </b><i> <s:property value="subjectId" /></i><br/>
						            		<b>Subject Name : </b><i> <s:property value="subName" /></i><br/>
						            		<b>Subject Type : </b><i> <s:property value="subType" /></i>
						            		</table>
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
					        </table>
						</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
					</table>	
					
					</center>