<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/calculate" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String num1 = "30";
	String num2 = "40";
	%>
	<h1>Welcome to custom tags</h1>
	<mytag:myhello lname="Wadile" fname="Sumeet"></mytag:myhello>
	<br>
	<mytag:mycalculate num2="<%=num2%>" num1="<%=num1%>"></mytag:mycalculate>
</body>
</html>