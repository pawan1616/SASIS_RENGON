<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<ul id="tabs">
		      <li><a id="current" href="nav2Exam.action" name="#tab1">Exam</a></li>
		      <li><a id="" href="nav2ExamSummary.action" name="#tab2">Exam Summary</a></li>
		      <li><a id="" href="nav2InstSess.action" name="#tab3">Exam Session</a></li>
		      <li><a id="" href="nav2InstSessSummary.action" name="#tab3">Session Summary</a></li>    
	  		</ul>
		<div class="divider"></div>
		<div class="submitStatusBar"></div>
		<div class="mainContent">
			<script type="text/javascript">
				$(document).ready(function(){
					showFirstTab("nav2Exam.action");
					});
			</script>
		</div>
