<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <table border="2px">
        <tr><th>Id</th><th>Name</th><th>Price</th><th>Author</th></tr>
        <c:forEach var="b" items="${requestScope.bookslist}">
        <tr>
            <td>${b.getId()}</td>
            <td>${b.getName()}</td>
            <td>${b.getPrice()}</td>
            <td>${b.getAuthor()}</td>
            <td><a href="DeleteBookServ?name=${b.getName()}">Delete</a>
        </tr>
    </c:forEach>
    </table>
    
    <a href="add.jsp">Add Book</a>
</body>
</html>