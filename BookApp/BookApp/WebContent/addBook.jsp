<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<center>

		<h1>Add Book</h1>
		<form action='addBook' method='post'>
			<table>
				<tr>
					<td>Id:</td>
					<td><input type="number" required="required" name="id" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><input type="number" required="required" name="price" /></td>
				</tr>
				<tr>
					<td>Author:</td>
					<td><input type="text" required="required" name="author" /></td>
				</tr>
				<tr>
					<td colspan='2'><input type="submit" value="Add Book" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>