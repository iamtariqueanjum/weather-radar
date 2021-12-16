<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="ISO-8859-1">
		<title>Login - Weather Radar</title>
	</head>
	<body>
		<jsp:include page="index.jsp"></jsp:include>	
		<form action="/checkuser" method="post">
			<label for="username"><b>Username:</b></label>
	    	<input type="text" name="username" placeholder="Enter username here" required><br/>
			<label for="password"><b>Password:</b></label>
	    	<input type="password" name="password" placeholder="Enter password here" required><br/>
			<input class="btn btn-outline-warning" type="submit" value="LOGIN">
			<a class="btn btn-outline-warning" href="/register" role="button">SIGNUP</a>
		</form>
	</body> 	
</html>