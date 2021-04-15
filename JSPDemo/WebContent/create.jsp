<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create User</title>
</head>
<body>

<div style="text-align: center">
<h1>Create User</h1>
<form action="create" method="post" id="CreateForm">
<label for="fullname"> Full Name :</label>
<input type="text" name="fullname" required/>
<br><br>
<label for="email"> Email :</label>
<input type="email" name="email"  required/>
<br><br>
<label for="password"> Password :</label>
<input type="text" name="password" required/>
<br><br>			
<button type="submit">Create</button>		
</form>
<br><br>
<a href="userlist">Back to List</a>	
</div>
			
</body>
</html>