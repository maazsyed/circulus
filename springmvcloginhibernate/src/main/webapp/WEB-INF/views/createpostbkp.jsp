<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../resources/css/style2.css" />
<title>Spring3Example</title>
</head>
<body>
 <div class="login-page">
  <div class="form" >
<h3>Welcome <c:out value="${viewposts.userName}" /></h3>

<%-- <%
String str = request.getParameter("password");
out.println(str);
%> --%>
<table>
	<tr>
		<td><a href="loginform.html">Back</a></td>
		<td><a href="createpost.html">Create POST</a></td>
		<td><a href="viewposts.html">View POSTs</a></td>
	</tr>
	<form:form action="viewposts.html"  commandName="viewposts">
	<table><!-- <thead>Post something:</thead> -->
	<tr height="25"> <th width="200"></th> <th width="700"></th> </tr>
	<tr><td>Post something:</td></tr>
		<tr>
		
			<td>User Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>

			<td><form:input  path="userName" /></td>
		</tr>
		
		
		<tr>
			<td>Title:<FONT color="red"><form:errors
				path="title" /></FONT></td>

			<td><form:input path="title" /></td>
		</tr>
		
		<tr>
			<td>Description:<FONT color="red"><form:errors
				path="content" /></FONT></td>

			<td><form:input path="content" /></td>
		</tr>
		
		
		<tr>
		<td></td>
			<td style="float: right"><input type="submit" value="Post" /></td>
		</tr>
	</table>
</form:form>
</table>
<div id="header">
NewsFeed:</div>
<div id="container">
    <div id="first">
	
	<div id="inner_container">
    <div id="inner_first">
	<%-- <c:forEach items="${viewposts.getviewResult()}" var="element"> 
<table border = 1>
  <tr>
	<td>${element.getUserName()}</td>
	<td>${element.getTitle()}</td>
    <td>${element.getContent()}</td>
  </tr>
</table>
</c:forEach> --%>
  </div>
    <div id="inner_second">
	<c:forEach items="${viewposts.getviewResult()}" var="element"> 
<table border = 1>
  <tr>
	<td>${element.getUserName()}</td>
	<td>${element.getTitle()}</td>
    <td>${element.getContent()}</td>
  </tr>
</table>
</c:forEach>
  </div>
  
</div>

<div id="inner_container">
    <div id="inner_first">
	<%-- <c:forEach items="${viewposts.getviewResult()}" var="element"> 
<table border = 1>
  <tr>
	<td>${element.getUserName()}</td>
	<td>${element.getTitle()}</td>
    <td>${element.getContent()}</td>
  </tr>
</table>
</c:forEach> --%>
  </div>
    <div id="inner_second">
	<c:forEach items="${viewposts.getviewResult()}" var="element"> 
<table border = 1>
  <tr>
	<td>${element.getUserName()}</td>
	<td>${element.getTitle()}</td>
    <td>${element.getContent()}</td>
  </tr>
</table>
</c:forEach>
  </div>
  
</div>
<div id="inner_container">
    <div id="inner_first">
	<%-- <c:forEach items="${viewposts.getviewResult()}" var="element"> 
<table border = 1>
  <tr>
	<td>${element.getUserName()}</td>
	<td>${element.getTitle()}</td>
    <td>${element.getContent()}</td>
  </tr>
</table>
</c:forEach> --%>
  </div>
    <div id="inner_second">
	<c:forEach items="${viewposts.getviewResult()}" var="element"> 
<table border = 1>
  <tr>
	<td>${element.getUserName()}</td>
	<td>${element.getTitle()}</td>
    <td>${element.getContent()}</td>
  </tr>
</table>
</c:forEach>
  </div>
  
</div>


  </div>
    <div id="second"><div id="header" style="background-color: gray;">
TRENDING:</div>
	
  </div>
  
</div>

 </div>
</div>

 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src="../resources/js/index.js"></script>

</body>
</html>