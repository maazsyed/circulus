<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="refresh" content="0; url=uploadfile.jsp" />
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<h2><a href="uploadfile.jsp">Upload Example</a></h2>
<br>
<br>
<br>
<br>
<%
	if (session.getAttribute("uploadFile") != null
			&& !(session.getAttribute("uploadFile")).equals("")) {
%>
<h3>Uploaded File</h3>
<br>
<img
	src="<%=request.getRealPath("/") + "/images/"
						+ session.getAttribute("uploadFile")%>"
	alt="Upload Image" />
<%
	session.removeAttribute("uploadFile");
	}
%>
</body>
</html>