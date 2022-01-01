<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>WR | Home</title>
	<link rel="stylesheet" href="../static/css/styles.css">
	<link rel="shortcut icon" href="../static/img/fav.png" type="image/x-icon">  
</head>
<body>
	<div class="wrapper">
		<nav class="navbar">
			<img class="logo" src="static/img/logo.svg">
			<ul>
				<li><a class="active" href="/">Home</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="/logout">Logout</a></li>
			</ul>
		</nav>
		<div class="center">
			<h1>Welcome <br><%= session.getAttribute("username")%></h1><br><br><br>
			<div class="weather-opts">
				<a href="/today">Get Today's Weather</a>
				<a href="/forecast">Get Future Forecasts</a>
			</div>
		</div>
	</div>
</body>
</html>