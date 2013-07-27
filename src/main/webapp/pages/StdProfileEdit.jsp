<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<ul id="tabs">
		       	<li><a id="current" href="nav2StdBasiInfoEdit.action" name="#tab1">Basic Info</a></li>
		       	<li><a id="" href="nav2StdWorkExpEdit.action" name="#tab1">Work Exp</a></li>
		       	<li><a id="" href="nav2AchieveEdit.action" name="#tab1">Achievement</a></li>
		      	
	  		</ul>
		<div class="divider"></div>
		<div class="submitStatusBar"></div>
		<div class="mainContent">
			<script type="text/javascript">
				$(document).ready(function(){
					showFirstTab("nav2StdBasiInfoEdit.action");
					});
			</script>
		</div>