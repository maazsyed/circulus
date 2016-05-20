<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				<td><div style="text-align:right"><a style="color: white" href="logout.html">Log out</a></div></td>
				
			</tr>
		</table>
	</div>
</div>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring3Example</title>
</head>
<body>
<h3>Welcome <c:out value="${loginForm.userName}" /></h3>
<c:forEach items="${ViewPosts.viewResult}" var="element"> 
  <tr>
    <td>'${element.getTittle}'</td>
  </tr>
</c:forEach>
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
</table>
</body>
</html>