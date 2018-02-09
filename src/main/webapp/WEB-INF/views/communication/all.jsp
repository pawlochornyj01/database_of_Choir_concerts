<%--
  Created by IntelliJ IDEA.
  User: Main
  Date: 12-Jan-18
  Time: 13:23
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

<table border="1" class="class1">

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
                            <li><a href="/category/all/">Concerts</a></li>
                            <li><a href="/category/all/">Workers</a></li>
                            <li><a href="/category/all/">Participants</a></li>
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
        <h1>All Communications</h1>
    </div>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>email</th>
        <th>phone</th>
        <th>membershipDate</th>
        <th>concert</th>
        <th>comment</th>
        <th>description</th>
    </tr>

    <c:forEach items="${communicationList}" var="communication">
        <tr>

            <td>${communication.communicationId}</td>
            <td>${communication.name}</td>
            <td>${communication.email}</td>
            <td>${communication.phone}</td>
            <td>${communication.membershipDate}</td>
            <td>${communication.concert}</td>
            <td>${communication.comment}</td>
            <td>${communication.description}</td>

        </tr>
        <br/>
    </c:forEach>
</table>
<h2>Add a new Communication</h2>

<form:form method="post" modelAttribute="communication">
    <p>
        Name:
        <input type="text" name="name"/>
        <form:errors path="name" cssclass="error"><span id="name.errors"
                                                        cssclass="error">may not be empty</span></form:errors>
    </p>
    <p>
        email:
        <input type="text" name="email"/>

    </p>
    <p>
        phone:
        <input type="text" name="phone"/>
    </p>
    <p>
        Date of membership:
        <input type="text" name="membershipDate"/>

    </p>
    <p>
        first met :
        <input type="text" name="concert"/>

    </p>
    <p>
        other information:
        <input type="text" name="comment"/>

    </p><p>
    Description:
    <input type="text" name="description"/>

</p>



    <input type="submit"/>
</form:form>
</body>
</html>