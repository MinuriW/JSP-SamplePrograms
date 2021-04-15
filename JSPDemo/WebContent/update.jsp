<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
<div style="text-align: center">
<h1>Update User</h1>
<form action="update" method="post" id="UpdateForm">
<label for="fullname"> Full Name :</label>
<%-- JSP Expression Language used to read data in pojo --%>
<input type="text" name="fullname" value="${user.fullname}" required/>
<br><br>
<label for="email"> Email :</label>
<input type="email" name="email" value="${user.email}" required/>
<br><br>
<label for="password"> Password :</label>
<input type="password" name="password" value="${user.password}" required/>
<br><br>
<input type="hidden" name="id" value="${user.id}"/>
<font color="red">${message}</font>
<br><br>			
<button type="submit">Update</button>
<br><br>
<a href="userlist">Back to List</a>
</form>
</div>				
</body>
</html>