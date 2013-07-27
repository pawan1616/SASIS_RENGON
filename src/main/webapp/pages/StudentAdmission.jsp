<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<script>
$(function() {
		for(i=1;i<=2;i++)
		$( "#crsBtch"+i ).combobox();
	$( "#toggle" ).click(function() {
		$( "#combobox" ).toggle();
	});
});
$(function() {
	$( "#specialDatepicker1").datepicker({
		changeMonth: true,
		changeYear: true,
		yearRange: '-100:+0'
	});
});
</script>
</head>
<div class="summaryFilter">
	<table>
		<tr><td width="65%"></td><td><input type="text" id="stdSearchInput" name="searchInput"  class="normalTextBox"/></td><td><span id="stdSearch"><img src="images/search-icon.png"></span></td></tr>
	</table>
</div>
<br/><br/>
<center>
	<s:if test="isUpdate">
		<form action="" method="post">
	</s:if>
	<s:else>
		<form action="stdCreationAction" method="post" id="formSubmit">
	</s:else>
		<table>
			<tr>
				<td>
					<s:if test="isUpdate">
						<table>
						<tr><td>&nbsp;</td></tr>
						<s:if test="isSearched">
							<tr><td><input type="hidden" name="isSearched" value="true"/></td></tr>
						</s:if>
						<tr>
							<td><label>First Name:</label></td>
							<td><input type="text" name="stdInfo.firstName" class="normalTextBoxReq" value='<s:property value="stdInfo.firstName"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>
							</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Last Name:</label></td>
							<td><input type="text" name="stdInfo.lastName" class="normalTextBoxReq" value='<s:property value="stdInfo.lastName"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Initials:</label></td><td><input type="text" name="stdInfo.initials" class="normalTextBox" value='<s:property value="stdInfo.initials"/>'/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>About Me:</label></td><td><textarea name="stdInfo.aboutMe" class="normalTextBox" COLS=40 ROWS=6><s:property value="stdInfo.aboutMe" /></textarea></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
						 <td><label>Gender:</label></td>
						 <td><label><input type="radio" value="Male" name="stdInfo.sex" <s:property value="stdInfo.maleChecked"/>/> Male</label>&nbsp;
						 	<label><input type="radio" value="Female" name="stdInfo.sex"  <s:property value="stdInfo.femaleChecked"/> /> Female</label>&nbsp;
						 	<label><input type="radio" value="Others" name="stdInfo.sex"  <s:property value="stdInfo.othersChecked"/>/> Others</label></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Date of birth:</label></td>
							<td><input type="text" name="stdInfo.dob" id="specialDatepicker1" value='<s:property value="stdInfo.dob"/>'/></td>
							<td><span id="specialDatepickerErr1"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Phone No:</label></td><td><input type="text"  name="stdInfo.stdPhoneNo" class="normalTextBox" value='<s:property value="stdInfo.stdPhoneNo"/>'/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Mobile No:</label></td>
							<td><input id="mobileReq1" type="text" name="stdInfo.stdMobileNo" class="otherReq" value='<s:property value="stdInfo.stdMobileNo"/>'/></td>
							<td><span id="mobileReqErr1" class="mobNoErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>E-Mail:</label></td>
							<td><input id="emailReq1" type="text" name="stdInfo.stdEmail" class="otherReq" value='<s:property value="stdInfo.stdEmail"/>'/></td>
							<td><span id="emailReqErr1"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Address Line1:</label></td>
							<td><input type="text" name="stdInfo.addLine1" class="normalTextBoxReq" value='<s:property value="stdInfo.addLine1"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Address Line 2:</label></td><td><input type="text" name="stdInfo.addLine2" class="normalTextBox" value='<s:property value="stdInfo.addLine2"/>'/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>City:</label></td>
							<td><input type="text" name="stdInfo.city" class="normalTextBoxReq" value='<s:property value="stdInfo.city"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>State:</label></td>
							<td><input type="text" name="stdInfo.state" class="normalTextBoxReq" value='<s:property value="stdInfo.state"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Country</label></td>
							<td><input type="text" name="stdInfo.country" class="normalTextBoxReq" value='<s:property value="stdInfo.country"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
					</table>
					</s:if>
					<s:else>
					<table>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>First Name:</label></td>
							<td><input type="text" name="stdInfo.firstName" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Last Name:</label></td>
							<td><input type="text" name="stdInfo.lastName" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Initials:</label></td><td><input type="text" name="stdInfo.initials" class="normalTextBox" /></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Gender:</label></td>
							<td><label><input type="radio" value="Male" name="stdInfo.sex" checked="checked"/> Male</label>&nbsp;<input type="radio" value="Female" name="stdInfo.sex"/> Female</label>&nbsp;<input type="radio" value="Others" name="stdInfo.sex"/> Others</label></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Date of birth:</label></td>
							<td><input type="text" name="stdInfo.dob" id="specialDatepicker1"/></td>
							<td><span id='specialDatepickerErr1'></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Phone No:</label></td><td><input type="text"  name="stdInfo.stdPhoneNo" class="normalTextBox" /></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Mobile No:</label></td>
							<td><input id="mobileReq1" type="text" name="stdInfo.stdMobileNo" class="otherReq" /></td>
							<td><span id="mobileReqErr1" class="mobNoErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>E-Mail:</label></td>
							<td><input id="emailReq1" type="text" name="stdInfo.stdEmail" class="otherReq" /></td>
							<td><span id="emailReqErr1" ></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Address Line1:</label></td>
							<td><input type="text" name="stdInfo.addLine1" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Address Line 2:</label></td><td><input type="text" name="stdInfo.addLine2" class="normalTextBox" /></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>City:</label></td>
							<td><input type="text" name="stdInfo.city" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>State:</label></td>
							<td><input type="text" name="stdInfo.state" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Country</label></td>
							<td><input type="text" name="stdInfo.country" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
					</table>
					</s:else>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width="55%">
					<s:if test="isUpdate">
						<table>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Father's Name:</label></td>
							<td><input type="text" name="stdInfo.fathersName" class="normalTextBoxReq" value='<s:property value="stdInfo.fathersName"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Mother's Name:</label></td>
							<td><input type="text" name="stdInfo.mothersName" class="normalTextBoxReq" value='<s:property value="stdInfo.mothersName"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Father's Profession:</label></td><td>
							<input type="text" name="stdInfo.fathersProfess" class="normalTextBoxReq" value='<s:property value="stdInfo.fathersProfess"/>'/></td>
							<td><span class="normalTextBoxReqErr"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Mother's Profession:</label></td><td><input type="text" name="stdInfo.mothersProfess" class="normalTextBox" value='<s:property value="stdInfo.mothersProfess"/>'/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Monthly Income:</label></td><td><input type="text" name="stdInfo.monthlyIncome" class="normalTextBox" value='<s:property value="stdInfo.monthlyIncome"/>'/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Parent's Phone No:</label></td><td><input type="text" name="stdInfo.parentPhoneNo" class="normalTextBox" value='<s:property value="stdInfo.parentPhoneNo"/>'/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Parent's Mobile No:</label></td>
							<td><input id="mobileReq2" type="text" name="stdInfo.parentMobileNo" class="otherReq" value='<s:property value="stdInfo.parentMobileNo"/>'/></td>
							<td><span id="mobileReqErr2" class="mobNoErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Parent's Email:</label></td>
							<td><input id="emailReq2" type="text" name="stdInfo.parentEmail" class="otherReq" value='<s:property value="stdInfo.parentEmail"/>'/></td>
							<td><span id="emailReqErr2"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Fax:</label></td><td><input type="text" name="stdInfo.fax" class="normalTextBox" value='<s:property value="stdInfo.fax"/>'/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<s:if test="isSearched">
							<tr>
								<td>Select Course:</td><td>
									<div class="ui-widget">
										<select id="crsBtch1" name="courseInfoId">
										<option value="-1">Select</option>
											<s:iterator value="courseInfoList">
												<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
											</s:iterator>
										</select>
									</div>
								</td>
								<td><span id="crsBtchErr1"></span></td>
							</tr>
							<tr>
									<td>&nbsp;</td></tr>
									<tr ><td>Select Batch:</td>
									<td width="50%">
										<div class="ui-widget">
											<select id="crsBtch2" name="btchInfoId">
												<option value="-1">Select</option>
											</select>
										</div>
									</td>
									<td><span id="crsBtchErr2"></span></td>
							</tr>						
						</s:if>
					</table>
				</td>
			</table>
					<br/>
					<s:if test="isSearched">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="Update Record" onclick="javascript:createUpdateBasicMod('stdCreationAction.action',false,false,'stdCreate')"/>
						<input type="submit" value="Clear" onclick="javascript:clearForm('nav2StdAdmission.action')"/>
					</s:if>
					<s:else>
						<input type="submit" value="Update Record" onclick="javascript:submitUserCreate('stdBasicInfoUpdateAction.action',true)"/>
					</s:else>
					<br/>
					&nbsp;
					</s:if>
					<s:else>
					<table width="100%">
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Father's Name:</label></td>
							<td><input type="text" name="stdInfo.fathersName" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Mother's Name:</label></td>
							<td><input type="text" name="stdInfo.mothersName" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Father's Profession:</label></td>
							<td><input type="text" name="stdInfo.fathersProfess" class="normalTextBoxReq" /></td>
							<td><span class="normalTextBoxReqErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Mother's Profession:</label></td><td><input type="text" name="stdInfo.mothersProfess" class="normalTextBox" /></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Monthly Income:</label></td><td><input type="text" name="stdInfo.monthlyIncome" class="normalTextBox" /></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Parent's Phone No:</label></td><td><input type="text" name="stdInfo.parentPhoneNo" class="normalTextBox" /></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Parent's Mobile No:</label></td>
							<td><input id="mobileReq2" type="text" name="stdInfo.parentMobileNo" class="otherReq" /></td>
							<td><span id="mobileReqErr2" class="mobNoErr"></span></td>	
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td><label>Parent's Email:</label></td>
							<td><input id="emailReq2" type="text" name="stdInfo.parentEmail" class="otherReq" /></td>
							<td><span id="emailReqErr2"></span></td>
						</tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><label>Fax:</label></td><td><input type="text" name="stdInfo.fax" class="normalTextBox" /></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr>
							<td>Select Course:</td><td>
								<div class="ui-widget">
									<select id="crsBtch1" name="courseInfoId">
									<option value="-1">Select</option>
										<s:iterator value="courseInfoList">
											<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
										</s:iterator>
									</select>
								</div>
							</td>
							<td><span id="crsBtchErr1"></span></td>
						</tr>
						<tr>
						<td>&nbsp;</td></tr>
							<tr ><td>Select Batch:</td>
							<td width="50%">
								<div class="ui-widget">
									<select id="crsBtch2" name="btchInfoId">
										<option value="-1">Select</option>
									</select>
								</div>
							</td>
							<td><span id="crsBtchErr2"></span></td>
						</tr>
					</table>
				</td>
			</table>
					<br>
					<input type="submit" value="Create Student" onclick="javascript:createUpdateBasicMod('stdCreationAction.action',false,false,'stdCreate')""/>
					<br>
					&nbsp;
		</s:else>
	 </form>
	 </center>
