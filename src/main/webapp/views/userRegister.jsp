<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User Register</title>
	</head>
	<body>
		<jsp:include page="userHome.jsp"></jsp:include><br/><br/><br/>
		<h1>Fill the details to create an account</h1>
		<form:form method="post" action="/adduser" modelAttribute="user">
			Enter First Name <form:input path="firstName"/><br/>
			Enter Last Name <form:input path="lastName"/><br/>
			Enter Email <form:input path="email"/><br/>
			Enter Mobile <form:input path="mobile"/><br/>
			Enter username <form:input path="username"/><br/>
			Enter password <form:input type="password" path="password"/><br/>
			<input class="btn btn-outline-warning" type="submit" value="Sign-Up">
		</form:form>
	</body>
</html>