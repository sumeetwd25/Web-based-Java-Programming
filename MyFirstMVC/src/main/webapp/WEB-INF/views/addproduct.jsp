<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<form action="addproduct" method="post">
	
		Product Id:		<input type="number" name="pid" id="pid" /><br> 
		Product name:	<input type="text" name="pname" id="pname"/><br>
		Quantity:		<input type="text" name="qty" id="qty" /><br> 
		Price:			<input type="number" name="price" id="price" /><br>
		
		<button type="submit" name="btn" id="btn" value="add">Add product</button>
	</form>
</body>
</html>