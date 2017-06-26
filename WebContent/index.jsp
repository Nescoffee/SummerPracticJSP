<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="controller.JpaController"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hotel</title>
</head>
<body>
<center>
	<h3>Робота з базою даних Hotel</h3>
	<iframe name="forMenu" src="MenuTable.html" width="200" height="250">
	</iframe>
	<iframe name="forTable" width="520" height="250"> </iframe>
	<br>
	<iframe name="forOperation" src="MenuOperation.html" width="730"
		height="80"> </iframe>
	<br>
	<iframe name="forDialog" width="730" height="220"> </iframe>
</center>
		<%
				session.setAttribute("controller", new JpaController());
		%>

</body>
</html>