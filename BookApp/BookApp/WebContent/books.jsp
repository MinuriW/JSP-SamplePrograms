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
			<c:out value="${requestScope.title}"></c:out>
		</h1>
		<table border="1px" style='border-collapse: collapse;'>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Author</th>
				<th colspan='2'></th>
			</tr>
			<c:forEach var="book" items="${requestScope.books}">
				<tr>
					<td>${book.getId()}</td>
					<td>${book.getName()}</td>
					<td>${book.getPrice()}</td>
					<td>${book.getAuthor()}</td>
					<td>
						<form action='updateBook.jsp' method="post">
							<input type="hidden" name="id" value="${book.getId()}" />
							<input type="hidden" name="name" value="${book.getName()}" />
							<input type="hidden" name="price" value="${book.getPrice()}" />
							<input type="hidden" name="author" value="${book.getAuthor()}" />
							<input type="submit" value="Update" />
						</form>
					</td>
					<td>
						<form action='deleteBook' method="post">
							<input type="hidden" name="id" value="${book.getId()}" />
							<input type="submit" value="Delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

	</center>
</body>
</html>