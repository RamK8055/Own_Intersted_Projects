<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Speed test</title>
</head>
<body>
	<h2>Download Speed:</h2>
	<form method = "get" action= "/downloadSpeed">
		<input type = "submit" name = "Calculate Download Speed">
	</form>
	<h2> ${speed }</h2>
	<br><br>
	<h2>Upload Speed:</h2>
	<form method = "get" action= "/uploadSpeed">
		<input type = "submit" name = "Calculate Upload Speed">
	</form>
	<h2> ${speed }</h2>
	
</body>
</html>