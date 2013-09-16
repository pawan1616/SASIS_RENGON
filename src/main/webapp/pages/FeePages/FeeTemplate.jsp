<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript" src="js/scriptFee.js"></script>
</head>
<ul id="tabs">
		      <li><a id="" href="nav2Subjects.action" name="#tab1">Pay Fee</a></li>
		      <li><a id="current" href="fee/nav2FeeSetting.action" name="#tab2">Fee Setting</a></li> 
	  		</ul>
		<div class="divider"></div>
		<div class="submitStatusBar"></div>
		<div class="mainContent">
			<script type="text/javascript">
				$(document).ready(function(){
					showFirstTab("fee/nav2FeeSetting.action");
					});
			</script>
		</div>
