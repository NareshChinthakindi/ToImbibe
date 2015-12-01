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
   <title>Update User Profile</title>
   <link href="css/style.css" rel="stylesheet" type="text/css" />
   
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>       
  <script type="text/javascript" src="js/jquery-ui.min.js"></script>       
 
  <script>

  $(document).ready(function () {
	  
	    
	});
  
  
  
  
  </script>


</head>

<body>





  <form:form method="post" name="userForm" id="userForm" action="updateProfileSubmit.html" enctype="multipart/form-data" modelAttribute="userModel">


  <table border="1" cellpadding="10" cellspacing="0" id="regTable">

    <tr bgcolor="#707070">
        <th colspan="3"><font style="color: white; font-size: 16px; font-family: HELVETICA;">Update Profile</font>
         <br/><font style="color: white; font-size: 10px; font-family: HELVETICA;">Please update the details below</font>
        </th>
    </tr>
    
    <tr><th style="border-right: none;">
    <table border="0" id="cdatasetTab" cellpadding="5" cellspacing="5">

       <tr>
          <td align="left">First Name :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="text" name="firstName" id="firstName" value="${userVo.firstName}" autocomplete="off" /></td>
       </tr> 
       <tr>
          <td>Last Name : &nbsp;<font style="color: red;font-size: 17px;">*</font></td>
          <td><input type="text" name="lastName" id="lastName" value="${userVo.lastName}" autocomplete="off" /></td>
       </tr> 
       <tr>
          <td>Email Id :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="text" name="loginId" id="loginId" value="${userVo.loginId}" readonly="readonly"/></td>
       </tr> 
       
       <tr>
          <td>Password :&nbsp;<font style="color: red;font-size: 17px;">*</font> </td>
          <td><input type="password" name="password" id="password" value="${userVo.password}"  readonly/></td>
       </tr> 
       
       <tr>
           <td>Security Question : &nbsp;<font style="color: red;font-size: 17px;">*</font></td>
           <td>
              <select name="securityQuestionId" disabled="disabled">
                <c:forEach var="questionVoList" items="${securityQuestionsList}"> 
                
                	<c:if test="${questionVoList.id == userVo.securityQuestionId }">
                       <option value="${questionVoList.id}" selected="selected" >${questionVoList.question}</option>
                    </c:if>
                    <c:if test="${questionVoList.id != userVo.securityQuestionId }">
                       <option value="${questionVoList.id}" >${questionVoList.question}</option>
                    </c:if>
                    
                    
                </c:forEach>
             </select>
          </td>
         </tr>
       
       <tr>
          <td>Security Question Answer : &nbsp;<font style="color:red;font-size: 17px;">*</font></td>
          <td><input type="text" name="securityQuestionAns" id="securityQuestionAns" value="${userVo.securityQuestionAns}" /></td>
       </tr>
       
       </tr>
     
       
       
     </table>
  </th>
  
  
  <th style="border-left: none; border-right: none;">&nbsp;</th>
  
  <th valign="top" style="border-left: none;">
      <table border="0" id="cdatasetTab" cellpadding="5" cellspacing="5">

       <tr>
          <td>Address : </td>
          <td><input type="text" name="address" id="address" value="${userVo.addressVo.address}" autocomplete="off" /></td>
       </tr> 
       <tr>
          <td>State : </td>
          <td><input type="text" name="state" id="state" value="${userVo.addressVo.state}" autocomplete="off" /></td>
       </tr> 

       <tr>
          <td>Country : </td>
          <td><input type="text" name="country" id="country" value="${userVo.addressVo.country}" autocomplete="off"  /></td>
       </tr> 
       
         <tr>
          <td>Pin : </td>
          <td><input type="text" name="pin" id="pin" value="${userVo.addressVo.pin}" autocomplete="off" /></td>
       </tr> 
       
         <tr>
          <td>Mobile : </td>
          <td><input type="text" name="mobileNumber" id="mobileNumber" value="${userVo.addressVo.mobileNumber}" autocomplete="off" /></td>
       </tr> 
       
       
       
       </table></th></tr>
  
    <tr>
          <th colspan="3" align="center">&nbsp;&nbsp;&nbsp;
          <input type="button" value="Update Profile" name="subDSBtn" onclick="javascript:updateProfile();"/> 
          &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <input type="reset" value="Reset" name="resetDSBtn"/>  </td>
      </tr>
  
  
  </table>
  </form:form>    
    


</body>
</html>