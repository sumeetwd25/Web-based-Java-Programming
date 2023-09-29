<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit product</title>
<style>
	.errmsg{
		color:red;
	}
</style>
</head>
<body>
	<form:form action="/updateproduct" method="post" modelAttribute="product">
		Product Id: <form:input path="pid" id="pid"/><br><br>
		
		Product name: <form:input path="pname" id="pname"/><br>
		<small><form:errors path="pname" cssClass="errmsg"></form:errors></small><br>
		
		Quantity: <form:input path="qty" id="qty"/><br>
		<small><form:errors path="qty" cssClass="errmsg"></form:errors></small><br>
		
		Price: <form:input path="price" id="price"/><br>
		<small><form:errors path="price" cssClass="errmsg"></form:errors></small><br>
		
		<button type="submit" name="btn" id="btn" value="update">Update Product</button>	
	</form:form>
</body>
</html>