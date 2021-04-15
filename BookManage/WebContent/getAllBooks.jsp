<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2px">
        <tr><th>Id</th><th>Name</th><th>Price</th><th>Author</th><th>Action</th><th>Action</th></tr>
        <c:forEach var="b" items="${requestScope.bookslist}">
        <tr>
            <td>${b.getId()}</td>
            <td>${b.getName()}</td>
            <td>${b.getPrice()}</td>
            <td>${b.getAuthor()}</td>
			<td><a href="UpdateBookServlet?id=${b.getId()}&name=${b.getName()}&price=${b.getPrice()}&author=${b.getAuthor()}">update</a></td>
            <td><a href="DeleteBookServlet?name=${b.getName()}">Delete</a></td>
         
        </tr>
    </c:forEach>
    </table>
</body>
</html>