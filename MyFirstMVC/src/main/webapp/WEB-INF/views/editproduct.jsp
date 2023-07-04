<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
	<form action="/MyFirstMVC/product/updateproduct" method="post">
	
		Product Id:		<input type="number" name="pid" id="pid" value="${prod.pid}" readonly/><br> 
		Product name:	<input type="text" name="pname" id="pname" value="${prod.pname}"/><br>
		Quantity:		<input type="text" name="qty" id="qty" value="${prod.qty}" /><br> 
		Price:			<input type="number" name="price" id="price"  value="${prod.price}"/><br>
		
		<button type="submit" name="btn" id="btn" value="add">Update product</button>
	</form>
</body>
</html>