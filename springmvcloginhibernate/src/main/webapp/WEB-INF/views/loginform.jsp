<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 Example</title>
</head>
<body>

<!-- <h3 id="name">Login Form</h3> -->
<FONT color="blue">
<!-- User Name="UserName" and password="password" -->
</FONT>
 <div class="login-page">
  <div class="form">
<form:form action="loginform.html"  commandName="loginForm" class="login-form">
	<table>
		<tr>
		<td>CIRCULUS</td>
			<td><FONT color="red"><form:errors
				path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" placeholder="username:"/></td>
		</tr>
		<tr>
			<td><FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" placeholder="password:"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="SIGN IN" />
			<a href="registrationform.html"><b>Create an account</b></a></td>
		</tr>
	</table>
</form:form>
 </div>
</div>
 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src="../resources/js/index.js"></script>
</body>
</html>