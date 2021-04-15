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

<center><h2>Enter Book Details To Update</h2>
	<form action='UpdateServ' method='get'>
		Book id		:<input type='text' name='id' value='<%=request.getParameter("id")%>'><br/><br/> 
		<!-- Book id		:<input type='text' name='id' value='${requestScope.id}'><br/><br/>  -->
		<!-- Book Name		:<input type='text' name='name' value='" + request.getParameter("name")+ "'><br/><br/> -->
		Book Name		:<input type='text' name='name' value='${requestScope.name}'><br/><br/>
		<!-- Price		:<input type='text' name='price' value='" + request.getParameter("price")+ "'><br/><br/> -->
		Price		:<input type='text' name='price' value='${requestScope.price}'><br/><br/>
		<!-- Author		:<input type='text' name='author' value='" + request.getParameter("author")+ "'><br/><br/> -->
		Author		:<input type='text' name='author' value='${requestScope.price}'><br/><br/>
				<input type='submit' value='Update Book'>
				
	</form>
</center>
</body>
</html>