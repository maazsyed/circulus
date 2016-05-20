<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link  href="http://fonts.googleapis.com/css?family=Cabin:400,500,600,bold" rel="stylesheet" type="text/css" >
<link  href="http://fonts.googleapis.com/css?family=PT+Sans+Narrow:regular,bold" rel="stylesheet" type="text/css" > -->

 <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="css/core.css">
  
<link rel="stylesheet" type="text/css" href="../resources/css/style3.css" />
<title>Spring3Example</title>
</head>
<body>



<h3><center>Welcome <c:out value="${loginForm.userName}" /></center></h3>


	<%-- <center>
		
		<a href="loginform.html" class="action-button shadow animate blue"> Login Form </a> 
		
		
		
		<a href="createpost.html" class="action-button shadow animate red">
		Create POST
       		</a>
			
		<a href="viewposts.html" class="action-button shadow animate green">View POSTs</a> <br><br><br><br><br><br>
	<a href="createpoll.html" class="action-button shadow animate yellow">Create POLLs</a>
		<a href="viewpolls.html" class="action-button shadow animate blue">View POLLs</a>
	</center> --%>
	
		<table align = "center">	
		<tr>
		<td></td>
		<td>
		<!-- <a href="loginform.html" class="action-button shadow animate blue"> Login Form </a> --> 
		<a href="createpost.html" class="action-button shadow animate green">Create POST</a>
		<a href="viewposts.html" class="action-button shadow animate green">View POSTs</a><br><br><br><br><br><br>
		<a href="createpoll.html" class="action-button shadow animate yellow">Create POLL</a> 
		<a href="viewpolls.html" class="action-button shadow animate blue">View POLLs</a>
		</td>
		</tr>
		</table>

</body>
</html>