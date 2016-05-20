<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<td><div style="text-align:right"><a style="color: white" href="logout.html">Log out</a></div></td>
				
			</tr>
		</table>
	</div>
</div>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="../resources/css/style2.css" />
<title>Spring3Example</title>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<h3>
				Welcome
				<c:out value="${viewposts.userName}" />
			</h3>

			<div id="header">
				<a href="viewposts.html">NewsFeed:</a>
			</div>
			<div id="container">
				<div id="first">


					<c:forEach items="${viewposts.getviewResult()}" var="element">
						<div id="inner_container">
							<div id="inner_first" style="color: white;">
								${element.getUserName()}</div>
							<div id="inner_second">
								<table border=2 style="width: 100%;" bordercolor="gray">
									<tr style="text-align: left;">
										<%-- <td>${element.getUserName()}</td> --%>
										<%-- <form:form action="viewposts.html" commandName="viewposts" method="POST"> --%>
										<td><a
											href="viewcomments.html?param1=${element.getTitle()}&param2=${element.getUserName()}"><b>${element.getTitle()}</b></a></td>
										<%-- <form:hidden path="title"/> --%>
										<%-- </form:form> --%>
									</tr>
									<tr style="text-align: left; font-size: small;">
										<td>${element.getContent()}</td>
										<%-- <td>${element.getTimestamp()}</td> --%>
									</tr>
								</table>
							</div>
						</div>
					</c:forEach>

					<div id="inner_container">
						<div id="inner_first"
							style="background-color: white; height: 250px">
							<table>
								<tr>
									<a href="registerreactions.html?vote=up">up</a>|
								</tr>
								<tr>
									<a href="registerreactions.html?vote=down">down<br></a>
								</tr>
								<tr>
									Happy:
									<c:out value="${registerreactions.happyCount}" />
									<br>
								</tr>
								<tr>
									Angry:
									<c:out value="${registerreactions.angryCount}" />
									<br>
								</tr>
								<tr>
									Sad:
									<c:out value="${registerreactions.sadCount}" />
									<br>
								</tr>
								<form:form action="registerreactions.html"
									commandName="registerreactions" method="POST">
									<%-- <tr><form:select path="react" items="<c:out value="${registerReactions.setReactions()}"/>"/></tr> --%>
									<tr>
										<select name="reactions">
											<option value="happy">Happy</option>
											<option value="angry">Angry</option>
											<option value="sad">Sad</option>
										</select>
									</tr>
									<tr>
										<input type="submit" value="React" />
									</tr>
								</form:form>
							</table>
						</div>
						<div id="inner_second" style="height: 250px">
							<table style="width: 100%;">
								<tr>
									No. of upvotes:
									<c:out value="${registerreactions.upCount}" />
									<br>
								</tr>
								<tr>
									No. of downvotes:
									<c:out value="${registerreactions.downCount}" />
									<br>
								</tr>
								<tr>
									Enter your comments below:
									<br>
								</tr>
								<tr style="text-align: right;">
									<%-- <td>${element.getUserName()}</td> --%>
									<form:form action="viewcomments.html"
										commandName="createcomments" method="POST">
										<td style="width: 20%"><form:input path="comment" /></td>
										<%-- <form:hidden path="post_id" /> --%>
								</tr>
								<tr style="text-align: right; font-size: small;">
									<td><input type="submit" value="Comment" /></td>
									</form:form>
									<%-- <td>${element.getTimestamp()}</td> --%>
								</tr>
							</table>
						</div>
					</div>

					<c:forEach items="${viewcomments.getviewResult()}" var="element">
						<div id="inner_container">
							<div id="inner_first" style="color: white;">
							<a href="viewinfo.html?info=${element.getUserName()}">
								${element.getUserName()}</a></div>
							<div id="inner_second">
								<table border=2 style="width: 100%;" bordercolor="gray">
									<tr style="text-align: left;">
										<%-- <td>${element.getUserName()}</td> --%>
										<%-- <form:form action="viewposts.html" commandName="viewposts" method="POST"> --%>
										<td><b>${element.getComment()}</b></td>
										<%-- <form:hidden path="title"/> --%>
										<%-- </form:form> --%>
									</tr>
									<tr style="text-align: left; font-size: small;">
										<td>${element.getTimestamp()}</td>
										<%-- <td>${element.getTimestamp()}</td> --%>
									</tr>
								</table>
							</div>
						</div>
					</c:forEach>



				</div>
				<div id="second">
					<div id="header" style="background-color: gray;">TRENDING:</div>
					<c:forEach items="${viewposts.getviewTrend()}" var="element">
						<div id="inner_container">
							<div id="inner_first2" style="color: white;">
							<a href="viewinfo.html?info=${element.getUserName()}">
								${element.getUserName()}</a></div>
							<div id="inner_second2">
								<table border=2 style="width: 100%;" bordercolor="gray">
									<tr style="text-align: left;">
										<%-- <td>${element.getUserName()}</td> --%>
										<td><a
											href="viewcomments.html?param1=${element.getTitle()}&param2=${element.getUserName()}"><b>${element.getTitle()}</b></a></td>
									</tr>
									<tr style="text-align: left; font-size: small;">
										<td>${element.getContent()}</td>
										<%-- <td>${element.getTimestamp()}</td> --%>
									</tr>
								</table>
							</div>
						</div>
					</c:forEach>

				</div>

			</div>

		</div>
	</div>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="../resources/js/index.js"></script>
</body>
</html>