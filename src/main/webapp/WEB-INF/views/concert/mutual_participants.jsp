<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 06.03.2018
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" media="screen">


    <script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <title>Index</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://dudaryk.ua/">Dudaryk</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">

                        <li><a href="/">Home</a></li>
                        <li><a href="/category/all/">Categories</a></li>
                        <li><a href="/concert/all/">Concerts</a></li>
                        <li><a href="/singer/all/">Workers</a></li>
                        <li><a href="/participant/all/">Participants</a></li>
                        <li><a href="/communication/all/">Communications</a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="http://www.library.dudaryk.ua/">Lidrary</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container">
    <h1>Mutual Participants</h1>
</div>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>email</th>
        <th>phone</th>
        <th>membershipDate</th>
        <th>concert</th>
        <th>comment</th>
        <th>description</th>
        <th></th>
    </tr>
    <tbody>
    <c:forEach items="${participantList}" var="participant">
        <tr>

            <td>${participant.participantId}</td>
            <td>${participant.name}</td>
            <td>${participant.email}</td>
            <td>${participant.phone}</td>
            <td>${participant.comment}</td>
            <td>${participant.description}</td>


        </tr>
        <br/>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
