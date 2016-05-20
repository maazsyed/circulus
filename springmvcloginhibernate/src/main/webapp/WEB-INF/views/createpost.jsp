<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<div id=header>
	<div style="width: 10%; float: left;">CIRCULUS</div>

	<div style="width: 90%; float: left; text-align: right;">
		<table>
			<tr>
				<td><form:form action="viewposts.html" commandName="viewposts">
						<form:input path="search" />
					</td>
				<td><select name="option">
						<option value="title">Title</option>
						<option value="user">User</option>
						<option value="tag">Tag</option>
				</select></td>
				<td><td style="float: right;"><input
					style="background-color: #800000; color: white" type="submit"
					value="Search" /></form:form></td>
					</td>
					
				<td>	<a href="profilesettings.html" style=" color: rgb(255,255,255)">Change Profile Settings</a></td>
				<td><div style="text-align:right;"><a style="color: white" href="logout.html">Log out</a></div></td>
				
			</tr>
		</table>
	</div>
</div>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../resources/css/style2.css" />

<link  href="http://fonts.googleapis.com/css?family=PT+Sans+Narrow:regular,bold" rel="stylesheet" type="text/css" >

 <link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="css/core.css">
  
<link rel="stylesheet" type="text/css" href="../resources/css/style3.css" />

<title>Create Post</title>
</head>
<body link="maroon">
 <div class="login-page">
  <div class="form" >
<h3>Welcome <c:out value="${viewposts.userName}" /></h3>


		<!-- <a href="loginform.html">Back</a> -->
			<!-- 	<a href="loginform.html" class="action-button shadow animate blue"> Login Form </a>  -->
		
		
		
		<!-- <a href="createpost.html" class="action-button shadow animate red">
		Create POST
       		</a> -->
       		
	
	<table align = "center">	
		<tr>
		<td></td>
		<td>
		<a href="createpoll.html" class="action-button shadow animate yellow">Create POLL</a>
		<a href="viewposts.html" class="action-button shadow animate green">View POSTs</a>
		<a href="viewpolls.html" class="action-button shadow animate blue">View POLLs</a>
		</td>
		</tr>
		</table>
	<table>
	<form:form action="createpost.html"  commandName="createpost">
	<table style="width: 100%"><!-- <thead>Post something:</thead> -->
	<tr height="25"> <th width="20%"></th> <th width="80%"></th> </tr>
	<tr><td style="font-weight: bolder;">Post something:</td></tr>
		<%-- <tr>
		
			<td>User Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>

			<td><form:input  path="userName" /></td>
		</tr> --%>
		
		
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
		
		<%-- <tr>
			<td>Tags:<FONT color="red"><form:errors
				path="tags" /></FONT></td>

			<td><form:input path="tags" /></td>
		</tr> --%>
		<tr>
		<td>Tags: </td>
		<td><select name="tags">
		<c:forEach items="${information.getviewTagResult()}" var="element">
		<option value="${element.getTag()}">${element.getTag()}</option>
		</c:forEach>
		</select></td>
		</tr>
		
		
		<tr>
		<td></td>
			<td style="float: right;"><input style="background-color: #800000; color: white" type="submit" value="Post" /></td>
		</tr>
	</table>
</form:form>
</table>

