<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WR | DR</title>
    <link rel="stylesheet" href="../static/css/styles.css">
    <link rel="shortcut icon" href="../static/img/fav.png" type="image/x-icon">
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
    <div class="drdata">
        <h1 align="center">Weather Data</h1>
        <table>
            <tr>
                <td>Climate Condition</td>
                <td>${lst.get(0)}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${lst.get(1)}</td>
            </tr>
            <tr>
                <td>Temperature</td>
                <td>${lst.get(2)}</td>
            </tr>
            <tr>
                <td>Feels like</td>
                <td>${lst.get(3)}</td>
            </tr>
            <tr>
                <td>Minimum temperature</td>
                <td>${lst.get(4)}</td>
            </tr>
            <tr>
                <td>Maximum temperature</td>
                <td>${lst.get(5)}</td>
            </tr>
            <tr>
                <td>Pressure</td>
                <td>${lst.get(6)}</td>
            </tr>
            <tr>
                <td>Humidity</td>
                <td>${lst.get(7)}</td>
            </tr>
            <tr>
                <td>Sea Level</td>
                <td>${lst.get(8)}</td>
            </tr>
            <tr>
                <td>Ground Level</td>
                <td>${lst.get(9)}</td>
            </tr>
            <tr>
                <td>Wind Speed</td>
                <td>${lst.get(10)}</td>
            </tr>
            <tr>
                <td>Wind Degree</td>
                <td>${lst.get(11)}</td>
            </tr>
            <tr>
                <td>Wind Gust</td>
                <td>${lst.get(12)}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>