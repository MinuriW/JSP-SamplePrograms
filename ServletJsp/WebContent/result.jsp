<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${requestScope.title }" ></c:out></title>
</head>
<body>
	<center>
		<h1><c:out value="${requestScope.title}" ></c:out></h1>
		<p><c:out value="${requestScope.message}" ></c:out></p>
		<p><a href='<c:out value="${requestScope.link}" ></c:out>'><c:out value="${requestScope.linkMessage}" ></c:out></a></p>

	</center>
</body>
</html>