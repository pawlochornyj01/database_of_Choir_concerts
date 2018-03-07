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

                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container">
    <h1>Category list</h1>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>LastName</th>
            <th>email</th>
            <th>phone</th>
            <th>Voice</th>
            <th>Action</th>
            <th></th>
        </tr>
        <tbody>
        <c:forEach items="${dudarykList}" var="dudaryk">

            <tr>

                <td><c:out value="${dudaryk.dudarykId}"/></td>
                <td><c:out value="${dudaryk.name}"/></td>
                <td><c:out value="${dudaryk.lastName}"/></td>
                <td><c:out value="${dudaryk.email}"/></td>
                <td><c:out value="${dudaryk.phone}"/></td>
                <td><c:out value="${dudaryk.voice}"/></td>
                    <%--<td><c:out value="${dudaryk.action}"/></td>--%>
                <td><c:choose>
                    <c:when test="${dudaryk.action}">
                        <p><span class="glyphicon glyphicon-ok"></span></p>
                    </c:when>
                    <c:otherwise>
                        <p><span class="glyphicon glyphicon-remove"></span></p>
                    </c:otherwise>
                </c:choose>
                </td>

                <td>

                        <%--<%@ include file="/WEB-INF/views/dudaryk/update.jsp" %>--%>
                </td>

                <td>
                    <a class="btn btn-danger" href="/singer/delete/${dudaryk.dudarykId}/">Delete</a>

                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</body>
</html>
