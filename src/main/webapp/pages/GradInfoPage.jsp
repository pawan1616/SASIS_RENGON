<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<center>
	<s:if test="isUpdate">
			<form action="" method="post" >
		<table>
			<tr><td>&nbsp;</td></tr>
			<tr><td><input type="hidden" name="gradInfo.gradId" value='<s:property value="gradInfo.gradId"/>'/></td></tr>
			<tr>
				<td><label>Low Marks Range:</label></td>
				<td><input id="normalTxtReq1" type="text" name="gradInfo.lowRange" class="normalTextBox" value='<s:property value="gradInfo.lowRange"/>'/></td>
				<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type low mark Range</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>High Marks Range:</label></td>
				<td><input id="normalTxtReq2" type="text" name="gradInfo.highRange" class="normalTextBox" value='<s:property value="gradInfo.highRange"/>'/></td>
				<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type high mark Range</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Name or Symbol:</label></td>
				<td><input id="normalTxtReq3" type="text" name="gradInfo.gradName" class="normalTextBox" value='<s:property value="gradInfo.gradName"/>'/></td>
				<td><span id="normalTxtReqDes3" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type name of the grad or the symbol</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Grad Point:</label></td>
				<td><input id="normalTxtReq4" type="text" name="gradInfo.gradPoint" class="normalTextBox" value='<s:property value="gradInfo.gradPoint"/>'/></td>
				<td><span id="normalTxtReqDes4" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type grad point</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Is History</label></td>
					<td>
						<label><input type="radio" name="gradInfo.isHistory" value="true" <s:if test="gradInfo.isHistory">checked="checked"</s:if>/>Yes</label>&nbsp;
						<label><input type="radio" name="gradInfo.isHistory" value="false" <s:if test="gradInfo.isHistory==false">checked="checked"</s:if>/>No</label>
					</td>
				<td><span id='radioErr1' class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Check if the course is professional</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td>
				<td><input type="submit" value="Update" onclick="javascript:createUpdateBasicMod('gradCreate.action',true,false,'gradCreate')"/></td>
				<td><input type="submit" value="Cancel" onclick="javascript:cancelSubmit()"/></td>
			</tr>
		</table>
	</form>
	</s:if>
	<s:else>
	<form action="" method="post" >
		<table>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Low Marks Range:</label></td>
				<td><input id="normalTxtReq1" type="text" name="gradInfo.lowRange" class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes1" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type low mark Range</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>High Marks Range:</label></td>
				<td><input id="normalTxtReq2" type="text" name="gradInfo.highRange" class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes2" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type high mark Range</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Name or Symbol:</label></td>
				<td><input id="normalTxtReq3" type="text" name="gradInfo.gradName" class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes3" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type name of the grad or the symbol</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td><label>Grade Point:</label></td>
				<td><input id="normalTxtReq4" type="text" name="gradInfo.gradPoint" class="normalTextBox"/></td>
				<td><span id="normalTxtReqDes4" class="blurInputDescript">--->&nbsp;&nbsp;&nbsp;&nbsp;Type grad point</span></td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr><td></td><td><input type="submit" value="Create Grade" onclick="javascript:createUpdateBasicMod('gradCreate.action',false,false,'gradCreate')"/></td></tr>
		</table>
	</form>
	</s:else>
</center>