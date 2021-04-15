<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div style="text-align: center">
		<%-- Declaration element --%>
		<%! public boolean isLoggedIn; %> 
		<%!int i =0; %>
		
		<%-- expression element only one line --%>
		 <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>
		
		<br><br>
		
		<%-- Scriplet multiple lines --%>	
		<%
			if(session.getAttribute("isUserLoggedIn")!=null)
			{  	
				out.println("<h1> Welcome "+session.getAttribute("username").toString()+" !!</h1><br>");
				out.println("<a href='userlist'>View Users</a><br><br>");
				out.println("<a href='logout'>Logout</a>");
			}
			else
			{
				out.println("<h1>Hello Guest !!</h1><br>");
				out.println("Please <a href='login.jsp'>login</a> to continue..");
			}
			
		%>
	</div>
</body>
</body>
</html>