<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Login</h1>
		<form action="login" method="post" id="loginForm">
			<label for="email">Email :</label>
			<input type="email" name="email" required/>
			<br><br>
			<label for="password">Password :</label>
			<input type="password" name="password" required/>
			<br>
			<font color="red">${message}</font>
			<br>			
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>