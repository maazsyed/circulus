<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<div id = header><div style="width: 60%; float: left;"> Circulus</div>
<div style="width: 40%; float: right; text-align: right;"><a style="color: white" href="logout.html">Log out</a></div></div>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../resources/css/style2.css" />

<link  href="http://fonts.googleapis.com/css?family=PT+Sans+Narrow:regular,bold" rel="stylesheet" type="text/css" >

 <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="css/core.css">
  
<link rel="stylesheet" type="text/css" href="../resources/css/style3.css" />
<title>Create Post</title>
</head>
<body>
 <div class="login-page">
  <div class="form" >
<h3>Welcome to Profile settings <c:out value="${loginForm.userName}" /></h3>




	 <table align = "center">	
		<tr>
		<td></td>
		<td>
		<!-- <a href="loginform.html" class="action-button shadow animate blue"> Login Form </a>  -->
		<a href="createpost.html" class="action-button shadow animate green">Create POST</a>
		<a href="viewposts.html" class="action-button shadow animate green">View POSTs</a>
		<a href="createpoll.html" class="action-button shadow animate yellow">Create POLL</a> 
		<a href="viewpolls.html" class="action-button shadow animate blue">View POLLs</a>
		</td>
		</tr>
		</table>
		 <table align="center">
	<form:form method="Post" action="profilesettings.html"  commandName="profilesettings">
	<table  align="center">
	<!-- <tr height="25"> <th width="20%"></th> <th width="80%"></th> </tr> -->
	<tr><td style="font-weight: bolder;">Enter New Credentials:</td></tr>
	
	
		<tr>
			<td>Enter New User Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" /></td>
		</tr>
		
		
		<tr>
			<td>Enter New Password:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
		<td>	<form:input path="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="SUBMIT" /></td>
		</tr>
				
	</table>
</form:form>
</table> 
</body>
</html>
