<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<s:set var="usrInfo" value="usrInfo"></s:set>
		<div class="profile_picture">
			<a href="#"><img src='<s:property value="profilePicPath"/>'></a>
		</div>
		<div class="profile_header">
			<h1><s:property value="usrInfo.firstName"/>&nbsp;<s:property value="usrInfo.initials"/>&nbsp;<s:property value="usrInfo.lastName"/></h1>
			<h2>~<s:property value="usrInfo.userName"/></h2>
			<h2>
				<s:if test="%{#usrInfo.userType=='Student'}">
					<s:property value="stdInfo.addLine1"/>
					<br><s:property value="stdInfo.addLine2"/>
					<br><s:property value="stdInfo.city"/>,&nbsp;<s:property value="stdInfo.state"/>,&nbsp;<s:property value="stdInfo.country"/>
					<br><br>E-Mail: <s:property value="stdInfo.stdEmail"/>
					<br>Mob: <s:property value="stdInfo.stdMobileNo"/>
				</s:if>
				<s:elseif test="%{#usrInfo.userType=='InstAdmin'}">
					<s:property value="instAdmin.address"/>
					<br><s:property value="instAdmin.addressLine2"/>
					<br><s:property value="instAdmin.addressLine3"/>
					<br><s:property value="instAdmin.city"/>,&nbsp;<s:property value="instAdmin.state"/>,&nbsp;<s:property value="instAdmin.country"/>
					<br><br>E-Mail: <s:property value="instAdmin.email"/>
					<br>Mob: <s:property value="instAdmin.contactNo"/>
				</s:elseif>
				
			</h2>
		</div>
		<div class="profile_tabs">
		<s:if test="%{#usrInfo.userType=='Student'}">
			<input type="hidden" id="usrUID" value='<s:property value="stdInfo.userInfo.userName"/>' name="userUID"/>
			<div id="current"><a href="nav2StdHome.action">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div ><a href="nav2MarksPV.action">Educatinal Qualification</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div ><a href="nav2ProfesQual.action">Professional Qualification</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div ><a href="nav2StdWorkExp.action">Work Experience</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div ><a href="nav2ProfileAchievement.action">Achievements</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</s:if>
		<s:elseif test="%{#usrInfo.userType=='InstAdmin'}">
			<div id="current"><a href="#">HOME</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
		
		</s:elseif>
		</div>
		<div class="profile_body">
			<s:if test="%{#usrInfo.userType=='Student'}">
				<jsp:include page="/pages/StdHome.jsp"/>
			</s:if>
			<s:else>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>Hey.........................................................................................................<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			</s:else>
		</div>