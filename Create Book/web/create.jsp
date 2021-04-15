<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Book</title>
</head>
<body>
	<center>
		<h2>Create Book</h2>
		<form action='Index'>
			 Title:<input id="Title" type="text" name="title" />
			 Category:<input id="Category" type="text" name="category" /> 
			 Author:<input id="Author" type="text" name="author" /> Price:<input id="Price" type="text" name="price" /> 
			<input id="Create" type="submit" value="Create" />
		</form>
	</center>
	<a href='Index'>Back to List</a>
</body>
</html>