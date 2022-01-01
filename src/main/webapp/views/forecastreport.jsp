<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
            <div class="frdata">
                <div class="row">
                    <c:forEach var="data" items="${lst}">
                        <div class="column">
                            <div class="card">
                                <table>
                                    <tr>
                                        <td>Temperature</td>
                                        <td>${data.get(0)}</td>
                                    </tr>
                                    <tr>
                                        <td>Temperature Feels like</td>
                                        <td>${data.get(1)}</td>
                                    </tr>
                                    <tr>
                                        <td>Minimum Temperature</td>
                                        <td>${data.get(2)}</td>
                                    </tr>
                                    <tr>
                                        <td>Maximum Temperature</td>
                                        <td>${data.get(3)}</td>
                                    </tr>
                                    <tr>
                                        <td>Pressure</td>
                                        <td>${data.get(4)}</td>
                                    </tr>
                                    <tr>
                                        <td>Sea Level</td>
                                        <td>${data.get(5)}</td>
                                    </tr>
                                    <tr>
                                        <td>Ground Level</td>
                                        <td>${data.get(6)}</td>
                                    </tr>
                                    <tr>
                                        <td>Humidity</td>
                                        <td>${data.get(7)}</td>
                                    </tr>
                                    <tr>
                                        <td>Climatic Condition</td>
                                        <td>${data.get(8)}</td>
                                    </tr>
                                    <tr>
                                        <td>Description</td>
                                        <td>${data.get(9)}</td>
                                    </tr>
                                    <tr>
                                        <td>Wind Speed</td>
                                        <td>${data.get(10)}</td>
                                    </tr>
                                    <tr>
                                        <td>Wind Degree</td>
                                        <td>${data.get(11)}</td>
                                    </tr>
                                    <tr>
                                        <td>Wind Gust</td>
                                        <td>${data.get(12)}</td>
                                    </tr>
                                    <tr>
                                        <td>Visibility</td>
                                        <td>${data.get(13)}</td>
                                    </tr>
                                    <tr>
                                        <td>Date & Time</td>
                                        <td>${data.get(14)}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>