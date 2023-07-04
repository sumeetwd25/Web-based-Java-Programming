<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Product</title>
</head>
<body>

	<table border=2>
		<tr>
			<th>Product id</th>
			<th>Product name</th>
			<th>Product qty</th>
			<th>Product price</th>
		</tr>

		<c:forEach var="prod" items="${plist}">
			<tr>
				<td>${prod.pid}</td>
				<td>${prod.pname}</td>
				<td>${prod.qty}</td>
				<td>${prod.price}</td>
				<td><a href="edit/${prod.pid}">edit</a>/
					<a href="delete/${prod.pid}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="addnewproduct">Add new product</a>&nbsp;&nbsp;
	<a href="logout">Logout</a>
</body>
</html>