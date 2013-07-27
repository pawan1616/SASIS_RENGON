<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/autocompleteCombobox.js"></script>
<link rel="stylesheet" href="css/styleFee.css" type="text/css"/>
<script>
	$(function() {
		$('#installCourseCombo').combobox();
		for(i=1;i<=2;i++){
			$( "#datepickerReq"+i ).datepicker({
				changeMonth: true,
				changeYear: true
			});
		}
	});
	</script>
</head>
<center>	
	<table width="100%" >
		<tr>
			<td width="50%" >
			<form action="" method="post">
				<table width="100%">
					<tr><td>&nbsp;</td></tr>
					<tr><td>Course:</td>
						<td>
							<select id="installCourseCombo" name="courseId" >
								<s:iterator value="courseInfoList" id="crs">
									<s:if test="%{#crs.courseId==courseId}">
										<option value="<s:property value="courseId"/>" selected="selected"><s:property value="courseName"/></option>
									</s:if>
									<s:else>
											<option value='<s:property value="courseId"/>'><s:property value="courseName"/></option>
									</s:else>
								</s:iterator>
								
							</select>
						</td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td>Total Course Fee:</td><td><span style="font-size:18px" id="totalCourseFee"><b><i><s:property value="totalCourseFee.amnt"/></i></b></span></td></tr>
					<tr><td>&nbsp;</td></tr>
					<tr><td>No. of Installment</td>
						<td><input id="noOfInstall" type="text" value='<s:property value="noOfInstallment"/>' name="noOfInstallment" class="normalTextBox"/></td>
					</tr>
					<tr><td>&nbsp;</td></tr>
					<tr>
						<td>&nbsp;</td>
						<td>
							<input type="submit" value="Create Installments" onclick="javascript:createInstallments()"/>
							<input type="submit" value="Save" onclick="javascript:saveInstallmentValues()"/>
						</td>
					</tr>
					<tr><td>&nbsp;</td></tr>
				</table>	
				</form>		
			</td>
			<td>
				<div class="scrollableWhiteBackground">
					<table border="2" bordercolor="#000000" width="100%" id="installTblDisplay" >
						<tr><th>Installments</th><th>Due Date</th><th>Delete</th></tr>
						<s:iterator value="installmentsDisplayMap">
							<tr><td><input type="text" name="installmentsSaveList" class="normalTextBox" value='<s:property value="value"/>'/></td><td><input type="text"  name="installmentsSaveList" class="normalTextBox" value='<s:property value="key"/>'/></td><td align="center"><img src="images/delete-big.jpg"></td></tr>
						</s:iterator>
					</table>
				</div>
			</td>
		</tr>
	</table>
	
</center>