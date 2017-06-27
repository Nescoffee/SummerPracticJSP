<%@page import="model.Visitor"%>
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
		Відвідувачі <select size="5" name="visId">
			<%
			JpaController controller = 
(JpaController) session.getAttribute("controller");
				Class<Visitor> v = Visitor.class;
				for (Object x : controller.getObjectList(v)) {
					Visitor obj = (Visitor) x;
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
