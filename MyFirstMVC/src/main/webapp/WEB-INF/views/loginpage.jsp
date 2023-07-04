<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	${msg}
	<form action="validate" method="post">
		User-name: <input type="text" name="uname" id="uname"><br>
		Password: <input type="password" name="passwd" id="passwd"><br>
		<button type="submit" name="btn" id="btn" value="login">Login</button>
	</form>
</body>
</html>