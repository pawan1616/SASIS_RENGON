<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>Institutive</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="shortcut icon" href="images/logo.jpg" type="image/x-icon">
        <link rel="stylesheet" href="jquery-ui-1.8.21.custom/development-bundle/themes/base/jquery.ui.all.css">
		<link rel="stylesheet" href="css/demos.css">
		<link rel="stylesheet" href="css/jquery.multiselect.css" type="text/css"/>
		<link rel="stylesheet" href="css/multiSelStyle.css" type="text/css"/>
		<link rel="stylesheet" href="css/prettify.css" type="text/css"/>
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
		
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.json-2.3.min.js"></script>
        
		<script src="jquery-ui-1.8.21.custom/development-bundle/jquery-1.7.2.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.core.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.widget.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.button.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.position.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.autocomplete.js"></script>
		<script src="jquery-ui-1.8.21.custom/development-bundle/ui/jquery.ui.datepicker.js"></script>
		<script src="js/prettify.js"></script>
		<script src="js/jquery.multiselect.js"></script>
		
		<script type="text/javascript" src="js/script.js"></script>
		<script type="text/javascript" src="js/BasicModInstValidation.js"></script>
    </head>

    <body>
    	<div class="loginInfo">| Welcome:&nbsp;<a href="#"><s:property value="username"/></a>&nbsp;&nbsp; |</div>&nbsp;<div class="logout"><a href="logout.action">Logout</a></div>
        <div id="content">
            <div class="navigation" id="nav">
                <div class="item home">
                    <img src="images/templateIcons/bg_home.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Home</h2>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Portfolio</a></li>
                        <li><a href="#">Contacts</a></li>
                    </ul>
                </div>
                <div class="item user">
                    <img src="images/templateIcons/bg_user.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>User</h2>
                    <ul>
                        <li><a href="#" name="nav2UserProfile.action">Profile</a></li>
                        <li><a href="#" name="nav2UserOptPage.action">Setting</a></li>
                        <li><a href="#" name="nav2UserSetting.action">Other Users</a></li>
                    </ul>
                </div>
                <div class="item shop">
                    <img src="images/templateIcons/bg_shop.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Institute</h2>
                    <ul>
                        <li><a href="#" name="fee/nav2Fee.action">Fee</a></li>
                        <li><a href="#" name="nav2ExmsTemplate.action">Exams</a></li>
                        <li><a href="#" name="nav2InstSetting.action">Settings</a></li>
                    </ul>
                </div>
                <div class="item camera">
                    <img src="images/templateIcons/bg_camera.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Students</h2>
                    <ul>
                        <li><a href="#" name="nav2AdmissionSetting.action">Admission</a></li>
                        <li><a href="#" name="nav2StdRecords.action">Records</a></li>
                         <li><a href="#"name="nav2InstStdViewSetting.action">Students</a></li>
                    </ul>
                </div>
                <div class="item fav">
                    <img src="images/templateIcons/bg_fav.png" alt="" width="199" height="199" class="circle"/>
                    <a href="#" class="icon"></a>
                    <h2>Others</h2>
                    <ul>
                        <li><a href="#">Stuff</a></li>
                        <li><a href="#">Accountancy</a></li>
                        <li><a href="#">Library</a></li>
                        <li><a href="#">Cabs</a></li>
                    </ul>
                </div>
            </div>
        </div>
	<div class="pageContent">
		<script type="text/javascript">
				$(document).ready(function(){
					changePage("nav2UserProfile.action", ".pageContent", "");
					});
			</script>
		</div>
		
    </body>
</html>