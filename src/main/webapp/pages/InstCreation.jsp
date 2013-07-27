<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="sd" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <title>Institutive</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="shortcut icon" href="images/logo.jpg" type="image/x-icon">
        <link rel="stylesheet" href="jquery-ui-1.8.21.custom/development-bundle/themes/base/jquery.ui.all.css">
		<link rel="stylesheet" href="css/demos.css">
		<link rel="stylesheet" href="css/jquery.multiselect.css" type="text/css"/>
		<link rel="stylesheet" href="css/multiSelStyle.css" type="text/css"/>
		<link rel="stylesheet" href="css/prettify.css" type="text/css"/>
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
		
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.json-2.3.min.js"></script>
        
		<script src="jquery-ui-1.8.21.custom/development-bundle/jquery-1.7.2.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.core.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.widget.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.button.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.position.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.autocomplete.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.datepicker.js"></script>
		<script src="js/prettify.js"></script>
		<script src="js/jquery.multiselect.js"></script>
		
		<script type="text/javascript" src="js/script.js"></script>
		<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
		<script type="text/javascript" src="js/countries.js"></script>
		<script type="text/javascript" src="js/customFormValidation.js"></script>
		<script type="text/javascript">
		$(function() {
			for(i=1;i<=4;i++)
				$( "#combobox"+i ).combobox();
			print_country("combobox2");
		});
		
		</script>
		
    </head>
<body>
	<div class="headerStripe"><span class="leftHeaderStripe"><a href="nav2Login.action">home</a>&nbsp;&nbsp;|&nbsp;&nbsp; <a href="">help</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="">What is institutive?</a></span><span class="centerHeaderStripe">WELCOME TO INSTITUTIVE</span></div>
	<div class="mainContent">
	<center>
			<div class="submitStatusBar"></div>
			<form action="instCreation.action" method="post" class="valForm">
				<table>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* Institute Name:</label></td><td>&nbsp;</td>
						<td><input id="normalTxtReq1" type="text" name="instAdmin.schoolName"  class="normalTextBox"/></td>
						<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type name of the institution</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td width="20%"><label>* Institute Description:</label></td><td></td>
						<td><textarea id="normalTxtReq2" cols="40" rows="5" name="instAdmin.description"></textarea></td>
						<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Give description about the institute</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td><label>* Institute Type:</label></td><td>&nbsp;</td>
							<td>
								<div class="ui-widget">
										<select id="combobox1" name="instAdmin.instType">
											<s:iterator value="instTypeList" var="val">
												<option value='<s:property value="val"/>'><s:property value="val"/></option>
											</s:iterator>
											
										</select>
									</div>
							</td>
							<td><span id='comboErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select type of the institute from the dropdown</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* Address Line1:</label></td><td></td><td><input id="normalTxtReq3" type="text" name="instAdmin.address" class="normalTextBox"/></td>
						<td><span id="normalTxtReqDes3" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Give you address here and below textboxes</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td><label>Address Line2:</label></td><td></td><td><input  type="text" name="instAdmin.addressLine2" class="normalTextBox"/></td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td><label>Address LIne3:</label></td><td></td><td><input type="text" name="instAdmin.addressLine3" class="normalTextBox"/></td></tr>
					
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* Country:</label></td><td></td>
						<td>
							<div class="ui-widget">
								<select id="combobox2" class="selReq" name="instAdmin.country" onchange="javascript:print_state('combobox3',this.selectedIndex);print_city('combobox4',this.selectedIndex)">										
								</select>
							</div>	
						</td>
						<td><span id="comboErr2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select your Country from the dropdown</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* State:</label></td><td></td>
						<td>
							<div class="ui-widget">
								<select id="combobox3" class="selReq" name="instAdmin.state" >										
								</select>
							</div>		
						</td>
						<td><span id="comboErr3" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select your state from the dropdown</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* City:</label></td><td></td>
						<td>
							<div class="ui-widget">
								<select id="combobox4" class="selReq" name="instAdmin.city" >										
								</select>
							</div>		
						</td>
						<td><span id="comboErr4" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Select your city from the dropdown</span></td>
					</tr>
					
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* Pin:</label></td><td></td><td><input id="numCheck"  type="text" name="instAdmin.pin" class="normalTextBox"/></td>
						<td><span class="blurInputDescript" id="pinReq">--->&nbsp;&nbsp;&nbsp;&nbsp;Type your area pin</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* User Name:</label></td><td></td><td><input id="userName" type="text" name="instAdmin.userName" class="normalTextBox"/></td>
						<td><span id="userNmErrDesc" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type the username for login</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* Password:</label></td><td></td><td><input id="normalPassReq" type="password" name="instAdmin.password" class="normalTextBox"/></td>
						<td><span id="normalPassReqErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type your password e.g. give a number and a special symbol</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td><label>* Confirm Password:</label></td>
						<td></td><td><input id="confrimPassReq" type="password" name="confirmPassword" class="normalTextBox"/></td>
						<td><span id="confirmPassReqErr" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Retype password for matching</span></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td></td><td></td><td><input type="Submit" value="Create Account" id="createRecord" onclick="javascript:validateSwitch('instCreation.action',false,false)"/></td></tr>
				</table>
			</form>
			&nbsp;<br>
			&nbsp;<br>
			&nbsp;<br>
	</center>
	</div>
		
</body>
</html>