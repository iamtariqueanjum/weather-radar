<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>WR | Register</title>
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
					<li><a  class="active" href="/register">Register</a></li>
					<li><a href="/login">Login</a></li>
					<li><a href="/admin/login">Admin</a></li>
				</ul>
			</nav>
		<div class="reg-box">
			<div class="reg">
				<h2 align="center">Register</h2><br>
				<center>
					<form method="post" action="/adduser">
						<input type="text" placeholder="Enter First Name" name="firstname" required>>
						<input type="text" placeholder="Enter Last Name" name="lastname" required>>
						<input type="text" placeholder="Enter Email" name="email" required>>
						<input type="text" placeholder="Enter Mobile" name="mobile" required>>
						<input type="text" placeholder="Enter Username" name="username" required>>
						<input type="password" placeholder="Enter Password" name="password" required>><br>
						<input type="submit" value="Register">
					</form>
				</center>
			</div>
		</div>
	</div>
</body>
</html>