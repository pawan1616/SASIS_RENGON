<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table border="2">
	<tr><th><b>Grade:</b></th><th><b>Percentage:</b></th></tr>
	<tr><td><s:property value="resInfo.grade"/></td><td><s:property value="resInfo.percentage"/></td></tr>
</table>
<br/><br/><br/><br/>
<table border="2">
	<tr>
		<th><b><i>Subjects</i></b></th>
		<s:iterator value="examTypeList">
			<th><s:property value="examTypeName"/></th>
		</s:iterator>
	</tr>
	<s:iterator value="subjectInfoList" id="sub">
		<tr>
			<td><s:property value="#sub.subName"/></td>
			<s:set var="mrkList" value="marksSubwise.get(#sub.subjectId)"/>
			<s:iterator value="examTypeList" id="exmTyp">	
				<s:set var="isNA" value="false"/>
				<s:iterator value="mrkList" id="mrk">
					<s:if test="#mrk.examInfo.examType.examTypeId==#exmTyp.examTypeId">
						<s:if test="isUpdate">
							<td><a class="marksUpdate" href="nav2UpdateMarks.action?isUpdate=true&&markId=<s:property value="markId"/>" ><s:property value="#mrk.marksObtained"/></a></td>
						</s:if>
						<s:else>
							<td><s:property value="#mrk.marksObtained"/></td>
						</s:else>
					</s:if>
					<s:else>
						<s:set var="isNA" value="true"/>
					</s:else>
			</s:iterator>
					<s:if test="IsNA">
						<td>N/A</td>
					</s:if>
			</s:iterator>		
		</tr>	
	</s:iterator>
</table>