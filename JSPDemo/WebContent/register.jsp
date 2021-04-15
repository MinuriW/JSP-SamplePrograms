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
		<h1>Register</h1>
		<form action="register" method="post" id="RegisterForm">
			<label for="fullname"> Full Name :</label>
			<input type="text" name="fullname" required/>
			<br><br>
			<label for="email"> Email :</label>
			<input type="email" name="email" required/>
			<br><br>
			<label for="password"> Password :</label>
			<input type="password" name="password" required/>
			<br><br>
			<label for="confirm"> Confirm Password:</label>
			<input type="password" name="confirm" required/>
			<br><br>
			<font color="red">${message}</font>
			<br><br>			
			<button type="submit">Register</button>
		</form>	
	</div>
</body>
</html>

<%! int i=1; %> 

<%-- This is JSP comment --%>