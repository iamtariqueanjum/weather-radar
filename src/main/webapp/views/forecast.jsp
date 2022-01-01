<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>WR | DR</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="../static/css/styles.css">
	<link rel="shortcut icon" href="../static/img/fav.png" type="image/x-icon">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script src="//geodata.solutions/includes/countrystatecity.js"></script>
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
		<center>
			<form method="post" action="/forecast">
				<div class="reg-box">
					<div class="reg">
						<select name="country" class="countries form-control" id="countryId" required>
							<option value="">Select Country</option>
						</select>
						<select name="state" class="states form-control" id="stateId" required>
							<option value="">Select State</option>
						</select>
						<select name="city" class="cities form-control" id="cityId" required>
							<option value="">Select City</option>
						</select>
						<input type="submit" class="btn btn-outline-dark" value="Get Weather Report"/>
					</div>
				</div>
			</form>
		</center>
	</div>
</body>
</html>