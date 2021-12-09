<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="ISO-8859-1">
		<title>User Login</title>
	</head>
	<body>
		<jsp:include page="userHome.jsp"></jsp:include>	
		<form th:action="@{/login}" method="post" th:object="${user}">
			<label for="username"><b>Username:</b></label>
	    	<input type="text" th:field="*{username}" required><br/>
			<label for="password"><b>Password:</b></label>
	    	<input type="password" th:field="*{password}" required><br/>
			<input class="btn btn-outline-warning" type="submit" value="LOGIN">
			<a class="btn btn-outline-warning" href="/register" role="button">SIGNUP</a>
		</form>
	</body> 	
</html>