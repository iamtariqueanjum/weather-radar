<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>WR | Login</title>
	<link rel="stylesheet" href="static/css/styles.css">
	<link rel="shortcut icon" href="../static/img/fav.png" type="image/x-icon">  
</head>
<body>
	<div class="wrapper">
			<nav class="navbar">
				<img class="logo" src="static/img/logo.svg">
				<ul>
					<li><a href="/">Home</a></li>
					<li><a href="/about">About</a></li>
					<li><a href="/contact">Contact</a></li>
					<li><a href="/register">Register</a></li>
					<li><a class="active" href="/login">Login</a></li>
				</ul>
			</nav>
    </div>
	<div class="reg-box">
		<div class="reg">
			<h2 align="center">Login</h2><br>
			<center>
			<form method="post" action="/checkuser">
				<input type="text" placeholder="Enter Username" name="username" required>
				<input type="password" placeholder="Enter Password" name="password" required><br>
				<input type="submit" value="Login">
			</form>
		</center>
		</div>
	</div>
</body>
</html>