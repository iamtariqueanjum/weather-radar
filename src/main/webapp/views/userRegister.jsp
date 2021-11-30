<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="ISO-8859-1">
		<title>User Register</title>
		<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
	    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<jsp:include page="userHome.jsp"></jsp:include>
		<form th:action="@{/adduser}" method="post" th:object="${user}">
			<label for="firstName"><b>First Name:</b></label>
	    	<input type="text" th:field="*{firstName}" required><br/>
			
			<label for="lastName"><b>Last Name:</b></label>
	    	<input type="text" th:field="*{lastName}" required><br/>
			
			<label for="email"><b>Email:</b></label>
	    	<input type="email" th:field="*{email}" required><br/>
			
			<label for="mobile"><b>Mobile:</b></label>
	    	<input type="number" th:field="*{mobile}" required><br/>
			
			<label for="username"><b>Username:</b></label>
	    	<input type="text" th:field="*{username}" required><br/>
			
			<label for="password"><b>Password:</b></label>
	    	<input type="password" th:field="*{password}" required><br/>

			<input class="btn btn-outline-warning" type="submit" value="SIGN-UP">
			<a class="btn btn-outline-warning" href="/login" role="button">LOGIN</a>
						
		</form>
	</body>
</html>