<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<ul id="tabs">
		      <li><a id="current" href="nav2StdAdmission.action" name="#tab1">Basic Information</a></li>
		      <li><a id="" href="nav2UsrRoleSummary.action" name="#tab2">Admission Fee</a></li>
		      <li><a id="" href="nav2InstUserCreate.action" name="#tab3">Fee slip</a></li>
		      <li><a id="" href="nav2UsrsSummary.action" name="#tab4">Books</a></li>    
	  		</ul>
		<div class="divider"></div>
		<div class="submitStatusBar"></div>
		<div class="mainContent">
			<script type="text/javascript">
				$(document).ready(function(){
					showFirstTab("nav2StdAdmission.action");
					});
			</script>
		</div>