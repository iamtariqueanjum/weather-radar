<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WR | Admin Login</title>
    <link rel="stylesheet" href="../static/css/styles.css">
    <link rel="shortcut icon" href="../static/img/fav.png" type="image/x-icon">
</head>
<style>
    body{
        color:white;
    }
</style>
<body>
<div class="wrapper">
    <nav class="navbar">
        <img class="logo" src="../static/img/logo.svg">
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/about">About</a></li>
            <li><a href="/contact">Contact</a></li>
            <li><a href="/register">Register</a></li>
            <li><a href="/login">Login</a></li>
            <li><a class="active" href="/admin/login">Admin Login</a></li>
        </ul>
    </nav>
</div>
<div class="reg-box">
    <div class="reg">
        <h2 align="center">Enter your admin credentials</h2><br>
        <center>
            <form method="post" action="/checkadminuser">
                <input type="text" placeholder="Enter Admin Username" name="adminusername" required>
                <input type="password" placeholder="Enter Admin Password" name="adminpassword" required><br>
                <input type="submit" value="Login">
            </form>
        </center>
    </div>
</div>
</body>
</html>