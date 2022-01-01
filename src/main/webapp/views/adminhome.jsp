<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WR | Admin Home</title>
    <link rel="stylesheet" href="../static/css/styles.css">
    <link rel="shortcut icon" href="../static/img/fav.png" type="image/x-icon">
</head>
<body>
<div class="wrapper">
    <nav class="navbar">
        <img class="logo" src="../static/img/logo.svg">
        <ul>
            <li><a class="active" href="/admin">Home</a></li>
            <li><a href="/admin/logout">Logout</a></li>
        </ul>
    </nav>
    <div class="center">
        <h1>Welcome <br><%= session.getAttribute("adminusername")%></h1><br><br><br>
        <div class="weather-opts">
            <a href="/view/users">Get Users data</a>
        </div>
    </div>
</div>
</body>
</html>