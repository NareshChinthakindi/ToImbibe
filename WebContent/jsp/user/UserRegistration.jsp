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
   <link href="css/style.css" rel="stylesheet" type="text/css" />
   
   <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
   <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
   <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
   
   
    <script>
$(function() {
$( "#datepicker" ).datepicker();
});
</script>


</head>

<body>
<jsp:include page="../includes/imbibeheader.jspf"/>


<div id="menu_wrapper">    
    <div id="menu">
        <ul>
            <li><a href="#"><span></span>Home</a></li>
            <li><a href="#" class="current"><span></span>Registration</a></li>
            <li><a href="#"><span></span>Partners</a></li>
            <li><a href="#"><span></span>Company</a></li>
            <li><a href="#"><span></span>Contact</a></li>
        </ul>    	
    </div> <!-- end of menu -->
</div> <!-- end of menu wrapper -->

<div id="content_wrapper">
<div id="content">

  <form:form method="post" name="userForm" id="userForm" action="registerUser.html" enctype="multipart/form-data" modelAttribute="userModel">


  <table border="1" cellpadding="10" cellspacing="0" id="regTable">

    <tr bgcolor="#707070">
        <th colspan="3"><font style="color: white; font-size: 16px; font-family: HELVETICA;">User Registration</font>
         <br/><font style="color: white; font-size: 10px; font-family: HELVETICA;">Please fill the details below</font>
        </th>
    </tr>
    
    <tr><th style="border-right: none;">
    <table border="0" id="cdatasetTab" cellpadding="5" cellspacing="5">

       <tr>
          <td align="left">First Name :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="text" name="firstName" id="firstName" autocomplete="off" /></td>
       </tr> 
       <tr>
          <td>Last Name : &nbsp;<font style="color: red;font-size: 17px;">*</font></td>
          <td><input type="text" name="lastName" id="lastName" autocomplete="off" /></td>
       </tr> 
       <tr>
          <td>Email Id :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="text" name="loginId" id="loginId" autocomplete="off" /></td>
       </tr> 
       
       <tr>
          <td>Password :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="password" name="password" id="password" autocomplete="off" /></td>
       </tr> 
       <tr>
          <td>Confirm Password :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="password" name="rePassword" id="rePassword" autocomplete="off" /></td>
       </tr> 
       <tr>
           <td>Security Question : &nbsp;<font style="color: red;font-size: 17px;">*</font></td>
           <td>
              <select name="securityQuestionId">
                <c:forEach var="questionVoList" items="${securityQuestionsList}"> 
                     <option value="${questionVoList.id}">${questionVoList.question}</option>
                </c:forEach>
             </select>
          </td>
         </tr>
       
       <tr>
          <td>Security Question Answer : &nbsp;<font style="color: red;font-size: 17px;">*</font></td>
          <td>
                            
          
          <input type="text" name="securityQuestionAns" id="securityQuestionAns" autocomplete="off" /></td>
       </tr>
       
        <tr>
          <td>Gender :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td>
          Male:<input type="radio" name="gender"  value="M"/>
          Female:<input type="radio" name="gender" value="F"/>
          </td>
       </tr>
       
       
        <tr>
          <td>Date Of Birth : &nbsp;<font style="color: red;font-size: 17px;">*</font></td>
          <td> <input type="text" id="datepicker" name="dateOfBirth"/></td>
       </tr>
       
        <tr>
          <td>Profile Photo :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="file" id="profilePicture" name="profilePicture"/>
          
             
               
          </td>
       </tr>
     
       
       
     </table>
  </th>
  
  
  <th style="border-left: none; border-right: none;">&nbsp;</th>
  
  <th valign="top" style="border-left: none;">
      <table border="0" id="cdatasetTab" cellpadding="5" cellspacing="5">

       <tr>
          <td>Address : </td>
          <td><input type="text" name="address" id="address" autocomplete="off" /></td>
       </tr> 
       <tr>
          <td>State : </td>
          <td><input type="text" name="state" id="state" autocomplete="off" /></td>
       </tr> 

       <tr>
          <td>Country : </td>
          <td><input type="text" name="country" id="country" autocomplete="off" /></td>
       </tr> 
       
         <tr>
          <td>Pin : </td>
          <td><input type="text" name="pin" id="pin" autocomplete="off" /></td>
       </tr> 
       
         <tr>
          <td>Mobile : </td>
          <td><input type="text" name="mobileNumber" id="mobileNumber" autocomplete="off" /></td>
       </tr> 
       
       
       
       </table></th></tr>
  
    <tr>
          <th colspan="3" align="center">&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset" name="resetDSBtn"/> &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" value="Create" name="subDSBtn"/> </td>
      </tr>
  
  
  </table>
  </form:form>    
    

</div> <!-- end of content -->
</div> <!-- end of content wrapper -->

<jsp:include page="../includes/imbibeFotter.jspf"/>
</body>
</html>