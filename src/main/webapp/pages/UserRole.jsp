<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <s:set name="editable" value="editable"/>
    <s:set name="pageIds" value="pageIds"/>
    <s:set name="rweHelpers" value="rweHelpers"/>
	<table width="100%">
		<tr><td>&nbsp;</td></tr>
		<tr>
			<td align="center">
						<table class="wwFormTable">
						<s:if test="%{#editable==true}">
							<input type="text" name="usrRole.usrRoleId" value='<s:property value="usrRole.usrRoleId"/>' hidden="hidden"/>
						</s:if>
							<tr >  
								<td class='tdLabel'>
									<label for="userRoleAction_usrRole_roleName" class='label'>Role Name:</label>
								</td>
								<td>
									<s:if test="%{#editable==true}">
									<input type="text" name="usrRole.roleName" id="readonlyTextBox" class="normalTextBox" readonly="readonly" value="<s:property value="usrRole.roleName"/>"/>
									</s:if>
									<s:else>
									<input type="text" name="usrRole.roleName" id="userRoleAction_usrRole_roleName" class="normalTextBox"/>
									</s:else>
								</td>
							</tr>
							<tr >
								<td>&nbsp;</td>
							</tr>
							<tr >
								<td class='tdLabel'>
									<label for="userRoleAction_usrRole_roleDescription" class='label'>Role Description:</label>
								</td>
								<td>
								<s:if test="%{#editable==true}">
										<textarea name="usrRole.roleDescription" cols="40" rows="5" ><s:property value="usrRole.roleDescription"/></textarea>
								</s:if>
								<s:else>
									<textarea name="usrRole.roleDescription" cols="40" rows="5" id="userRoleAction_usrRole_roleDescription"></textarea>
								</s:else>
								</td>
							</tr>
							<tr><td>&nbsp;</td></tr>
							<tr>
								<td>
									<label for="userRoleAction_usrRole_roleDescription" class='label'>Page Access:</label>
								</td>
								<td>
						<div class="tableContainer">
						    <table id="report">
						        <tr>
						            <th>Select</th>
						            <th>Page Name</th>
						            <th>Description</th>
						            <th></th>
						        </tr>
						        <s:if test="%{#editable==true}">
							         <s:iterator value="pages" id="page">
							        <tr>
							        	<s:if test="%{pageIds.contains(#page.pageId)}">
							        		<td class="checkBtnPage"><input type="checkbox" name="selUsrPrefs" value="<s:property value="pageId"/>" id="userRoleAction_usrRole_isPref" checked/></td>
							        	</s:if>
							        	<s:else>
							            	<td class="checkBtnPage"><input type="checkbox" name="selUsrPrefs" value="<s:property value="pageId"/>" id="userRoleAction_usrRole_isPref"/></td>
							            </s:else>
							            <td><s:property value="pageName"/></td>
							            <td class="description"><s:property value="description"/></td>
							            <td><div class="arrow"></div></td>
							        </tr>
							        <tr>
							            <td colspan="5">
							            <div class="rightDiv">
							            <s:if test="%{#rweHelpers[#page.pageId].read==true}">
							            	<label><input type="checkbox" name="rPref" value="R" class="rweCls" checked>Read</label><br/>
							            </s:if>
							            <s:else>
							                <label><input type="checkbox" name="rPref" value="R" class="rweCls">Read</label><br/>
							            </s:else>
							            <s:if test="%{#rweHelpers[#page.pageId].write==true}">
							            	<label><input type="checkbox" name="wPref" value="W" class="rweCls" checked>Write</label><br/>
							            </s:if>
							            <s:else>
							               	<label><input type="checkbox" name="wPref" value="W" class="rweCls">Write</label><br/>
							            </s:else>
							            <s:if test="%{#rweHelpers[#page.pageId].edit==true}">
							            	<label><input type="checkbox" name="ePref" value="E" class="rweCls" checked>Edit</label><br/>
							            </s:if>
							            <s:else>
							                <label><input type="checkbox" name="ePref" value="E" class="rweCls">Edit</label><br/>
							            </s:else>
							            </div>
							                <h4>Full Description</h4>
							                <div class="descriptionDiv">
							                	<s:property value="description"/>
							                </div>
							            </td>
							        </tr>
							        </s:iterator>
						        </s:if>
						        <s:else>
						        <s:iterator value="pages">
						        <tr>
						            <td class="checkBtnPage"><input type="checkbox" name="selUsrPrefs" value="<s:property value="pageId"/>" id="userRoleAction_usrRole_isPref"/></td>
						            <td><s:property value="pageName"/></td>
						            <td class="description"><s:property value="description"/></td>
						            <td><div class="arrow"></div></td>
						        </tr>
						        <tr>
						            <td colspan="5">
						            <div class="rightDiv">
						                <label><input type="checkbox" name="rPref" value="R" class="rweCls">Read</label><br/>
						               	<label><input type="checkbox" name="wPref" value="W" class="rweCls">Write</label><br/>
						                <label><input type="checkbox" name="ePref" value="E" class="rweCls">Edit</label><br/>
						            </div>
						                <h4>Full Description</h4>
						                <div class="descriptionDiv">
						                	<s:property value="description"/>
						                </div>
						            </td>
						        </tr>
						        </s:iterator>
						        </s:else>
					        </table>
						</div>
						</td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td></td><td align="center">
							<s:if test="%{#editable==true}">
								<input type="submit" value="Update" onclick="javascript:roleSubmit(2)"/>
								<input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/>
							</s:if>
							<s:else>
								<input type="submit" value="Submit" onclick="javascript:roleSubmit(1)"/>
							</s:else>
							
							</td></tr>
					</table>
			</td>
		</tr>
	</table>