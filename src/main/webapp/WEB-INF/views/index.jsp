<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">

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

                        <li><a href="#">Home</a></li>
                        <li><a href="category/all/">Categories</a></li>
                        <li><a href="category/all/">Concerts</a></li>
                        <li><a href="singer/all/">Workers</a></li>
                        <li><a href="category/all/">Participants</a></li>
                        <li><a href="communication/all/">Communications</a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="http://www.library.dudaryk.ua/">Lidrary</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="d-block w-100" src="<c:url value="/WEB-INF/images/dudaryk0.jpg" />"/>
                    <div  class="carousel-caption">
                    </div>
                </div>
                <div class="item">
                    <img class="d-block w-100" src="<c:url value="/WEB-INF/images/dudaryk1.jpg" />"/>
                    <div class="carousel-caption">
                    </div>
                </div>
                <div class="item">
                    <img class="d-block w-100" src="<c:url value="/WEB-INF/images/dudaryk2.jpg" />"/>
                    <div class="carousel-caption">
                    </div>
                </div>
                ...
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>
</body>
</html>