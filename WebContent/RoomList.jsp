<%@page import="model.Room"%>
<%@page import="controller.JpaController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>studList</title>
</head>
<body>
	<center>
		Кімнати <select size="5" name="roomId">
			<%
			JpaController controller = 
(JpaController) session.getAttribute("controller");
				Class<Room> r = Room.class;
				for (Object x : controller.getObjectList(r)) {
					Room obj = (Room) x;
			%>
			<option>
				<%=obj.toString()%></option>
			<%
				}
			%>
		</select>
	</center>
</body>
</html>
l>