<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <meta http-equiv="X-UA-Compatible" content="IE=9" />
   <title>New User Registration</title>
   <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
   
 <!--   <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
   <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
   <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> -->
   
   <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>       
   <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>       
   <script type="text/javascript" src="<%=request.getContextPath() %>/js/tinybox.js"></script>    
   <script type="text/javascript" src="<%=request.getContextPath() %>/js/imbibe.js"></script>   
   
   
   
<script>
 

  $(document).ready(function () {
	  
	    /*$('#updateProfile').click(function (e) {
	    	
	        $.ajax({
	            "url": "updateProfile.html", //Cannot use "http://localhost:8085/reports/popupData.jsp" for fiddle
	            "method": "GET",
	            "dataType": "html",
	            "success": function (data) {
	                $('#dlg').html(data).dialog({
	                    "autoOpen": true,
	                    "modal": true,
	                    "title": "Update Profile",
	                    "width": 200,
	                    "height": 360
	                });
	            }
	        });
	    });*/
	});






 function logoutUser(logoutUrl)
 {
	 document.f.action = '<%=request.getContextPath()%>/userLogin/'+logoutUrl;
	 document.f.submit();
 }

 function updateProfile()
 {
	  document.userForm.action = '<%=request.getContextPath()%>/userLogin/updateProfileSubmit.html';
	  document.userForm.submit();
 }


</script>


</head>

<body>

<jsp:include page="../includes/imbibeheader.jspf"/>


<div id="menu_wrapper">    
    <div id="menu">
        <ul>
            <li><a href="#" class="current"><span></span>My Home</a></li>
            <li onclick="TINY.box.show({iframe:'#',boxid:'frameless',width:750,height:450,fixed:false,maskid:'bluemask',maskopacity:40,closejs:function(){closeJS()}})">
               <a href="#" id="updateProfile"><span></span>         
            My Friends</a></li>

            <li onclick="TINY.box.show({url:'<%=request.getContextPath() %>/userLogin/updateProfileView.html',boxid:'frameless',width:741,height:350,animate:true,openjs:function(){openJS()}})">
              <a href="#"><span></span>Update Profile</a>
            </li>
            
            <li><a href="#"><span></span>Find People</a></li>
            <li><a href="#"><span></span>Start Discussion</a></li>
        </ul>    	
    </div> 
</div> 


<div id="content_wrapper">


 <div id="leftNav">
 <ul style="padding-left: 25px;">
  <li><a href="#">Change Profile Picture</a></li>
  <li><a href="#">Find Friends</a></li>
  <li><a href="#">Inbox</a></li>
  <li><a href="#">Send Message</a></li>
 </ul>
 </div>
 
 
 
   <div id="content">
   
   <div id="statusMessages">
       <span id="successMessage" class="green">${strStatusMessage }</span>
   
       <span id="errorMessage" class="red">${strErrMessage }</span>
   
   </div>
   
   <div id="welcomeMsg">
   <ul><li><font style="font-size: 16px;">Welcome  ${userVo.firstName}  ${userVo.lastName} </font> </li></ul>
     <img src='<%=request.getContextPath() %>/userLogin/open.html' style="position: absolute;" height="100px" width="100px"/>   
   </div>
   
   
   </div> 





<div id="dlg"></div>


</div> 
<jsp:include page="../includes/imbibeFotter.jspf"/>

</body>
</html>