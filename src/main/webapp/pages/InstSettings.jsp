<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<ul id="tabs">
		      <li><a id="current" href="nav2Subjects.action" name="#tab1">Subjects</a></li>
		      <li><a id="" href="nav2ExamType.action" name="#tab2">Exam Type</a></li>
		      <li><a id="" href="nav2ExamTypeSummary.action" name="#tab3">Exam Type Summary</a></li>
		      <li><a id="" href="nav2Course.action" name="#ta4">Course</a></li>
		      <li><a id="" href="nav2CourseSummary.action" name="#tab5">Course Summary</a></li>
		      <li><a id="" href="nav2BatchInfo.action" name="#tab8">Batch</a></li>
		      <li><a id="" href="nav2BatchSummary.action" name="#tab9">Batch Summary</a></li>
		      <li><a id="" href="nav2Grad.action" name="#tab10">Grad Table</a></li>    
		      <li><a id="" href="nav2GradSummary.action" name="#tab11">Grad Summary</a></li>    
	  		</ul>
		<div class="divider"></div>
		<div class="submitStatusBar"></div>
		<div class="mainContent">
			<script type="text/javascript">
				$(document).ready(function(){
					showFirstTab("nav2Subjects.action");
					});
			</script>
		</div>
