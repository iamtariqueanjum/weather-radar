<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register your account</title>
	</head>
	<body>
		<jsp:include page="index.jsp"></jsp:include>
		<form action="/adduser" method="post">
			<label for="firstName"><b>First Name:</b></label>
	    	<input type="text" name="firstName" placeholder="Enter first name here" required><br/>
			
			<label for="lastName"><b>Last Name:</b></label>
	    	<input type="text" name="lastName" placeholder="Enter last name here" required><br/>
			
			<label for="email"><b>Email:</b></label>
	    	<input type="email" name="email" placeholder="Enter email here" required><br/>
			
			<label for="mobile"><b>Mobile:</b></label>
	    	<input type="number" name="mobile" placeholder="Enter mobile here" required><br/>
			
			<label for="username"><b>Username:</b></label>
	    	<input type="text" name="username" placeholder="Enter username here" required><br/>
			
			<label for="password"><b>Password:</b></label>
	    	<input type="password" name="password" placeholder="Enter password here" required><br/>

			<input class="btn btn-outline-warning" type="submit" value="SIGNUP">
			<a class="btn btn-outline-warning" href="/login" role="button">LOGIN</a>
						
		</form>
	</body>
</html>