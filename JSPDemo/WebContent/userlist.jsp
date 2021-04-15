<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List" %> 
<%@page import="com.hcl.User" %> <%-- Import Java class for list --%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<h1>User List</h1>
	<table border='2'>
	<tr>
	<th>Id</th><th>Name</th><th>Email</th><th>Password Hash</th><th colspan=2>Options</th>
	</tr>
	<%! String deleteURL; %>
		<% List<User> listUsers = (List)request.getAttribute("userslist"); 
			for(User u : listUsers){
				out.print("<tr><td>"+u.getId()+"</td><td>"+u.getFullname()+"</td>");
				out.print("<td>"+u.getEmail()+"</td><td>"+u.getPassword()+"</td>");
				String updateURL = request.getContextPath()+"/searchuser?id="+u.getId();
				deleteURL = request.getContextPath()+"/deleteuser?id="+u.getId();
				out.print("<td><a href='"+updateURL+"'>Update</a></td>");

		%>
		<td>
		<a href="<%= deleteURL %>" 
			onclick="if(!confirm('Are you sure to delete the user?')) return false"> Delete </a>
			</td>
			</tr>
		<% } %>
	</table>
	<br><br>
	<a href="create.jsp">Create Users</a> 
	<br><br>
	<a href="home.jsp">Back to home</a> 
</body>
</html>