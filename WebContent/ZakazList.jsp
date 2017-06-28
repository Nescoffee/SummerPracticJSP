<%@page import="model.Zakaz"%>
<%@page import="controller.JpaController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		Замовлення <select size="5" name="zakazId">
			<%
			JpaController controller = 
(JpaController) session.getAttribute("controller");
				Class<Zakaz> v = Zakaz.class;
				for (Object x : controller.getObjectList(v)) {
					Zakaz obj = (Zakaz) x;
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