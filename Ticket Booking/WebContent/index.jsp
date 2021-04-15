<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Ticket Booking</h1>
<form action="Calculate" method="GET">
Seating Type<select name='seatType'>
<option value="1">Platinum</option>
<option value="2">Gold</option>
<option value="3">Silver</option>
</select><br>
Number of tickets<input type="text" name="numberOfTickets"><br>
<input type="submit" id="submit" value="submit"><br>
</form>
</center>
</body>
</html>