<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Books</title>
</head>
<body>
	<center>
		<h1>
			Update Book
		</h1>
		<form action='UpdateBookServlet' method='GET'>
			<input type="hidden" name="id" value='${param["id"]}' />
			<table border="1px" style='border-collapse: collapse;'>
				<tr>
					<td>Name</td>
					<td><input type="text" required="required" name="name" value='${param["name"]}' /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="number" required="required" name="price" value='${param["price"]}' /></td>
				</tr>
				<tr>
					<td>Author</td>
					<td><input type="text" name="author" required="required"  value='${param["author"]}' /></td>
				</tr>
				<tr>
					<td></td>
					<td> <input type="submit" value="Update" /></td>
				</tr>

			</table>
		</form>

	</center>
</body>
</html>