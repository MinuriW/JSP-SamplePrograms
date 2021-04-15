<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Airport</title>
</head>
<body>
	<center>
		<h2>Create Airport</h2>
		<form action='Index' method='POST'>
			<table>
				<tr>
					<td>IATA Code:</td>
					<td><input id="iataCode" type="text" name="iataCode" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input id="name" type="text" name="name" /></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input id="city" type="text" name="city" /></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><input id="country" type="text" name="country" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input id="create" type="submit" value="Create" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>