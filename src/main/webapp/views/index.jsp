<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>WR | Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<link rel="stylesheet" href="static/css/styles.css">
	<link rel="shortcut icon" href="static/img/fav.png" type="image/x-icon">
</head>
<body onload="getLocation()" style="background:grey;">
	<script>  
		var OpenWeather_API_key = "a77258fa6083c3ab9c85b43a57dbd73c";
		var x= document.getElementById("location");  
		function getLocation() {
          if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition)
          }
        }
		function showPosition(position) {
        	var x = "Your current location is (" + "Latitude: " + position.coords.latitude + ", " + "Longitude: " +    position.coords.longitude + ")";  
            document.getElementById("location").innerHTML = x;
    		//"http://api.openweathermap.org/data/2.5/weather?lat="position.coords.latitude+"&lon="+position.coords.longitude+"&appid="+OpenWeather_API_key
            var datas = fetch("https://api.github.com/users/iamtariqueanjum")
            	    console.log(datas)           		 
		}

	</script>  
	<div class="wrapper">
			<nav class="navbar">
				<img class="logo" src="static/img/logo.svg">			
				<ul>
					<li><a class="active" href="/">Home</a></li>
					<li><a href="about">About</a></li>
					<li><a href="contact">Contact</a></li>
					<li><a href="register">Register</a></li>
					<li><a href="login">Login</a></li>
				</ul>
			</nav>
			<div class="content">
				<input value="" placeholder="Enter your city name here..."/>
				<button>Get Today's Weather</button>
			</div>
	</div>
	<div id="location"></div>
	<div id="first"></div>
</body>
</html>