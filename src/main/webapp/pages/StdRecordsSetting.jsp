<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<ul id="tabs">
		      <li><a id="current" href="nav2MarksInfo.action" name="#tab1">Enter Marks</a></li>
		      <li><a id="" href="nav2EditMarks.action" name="#tab2">Edit Marks</a></li>    	
		      <li><a id="" href="nav2InstResultView" name="#tab1">View Result</a></li>
		     <li><a id="" href="nav2InstResultView" name="#tab1">Result View Setting</a></li>		     	          
	  		</ul>
		<div class="divider"></div>
		<div class="submitStatusBar"></div>
		<div class="mainContent">
			<script type="text/javascript">
				$(document).ready(function(){
					showFirstTab("nav2MarksInfo.action");
					});
			</script>
		</div>