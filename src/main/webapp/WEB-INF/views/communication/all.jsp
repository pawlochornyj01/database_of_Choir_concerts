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
                            <li><a href="/singer/all/">Workers</a></li>
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
            <td>
                <a class="btn btn-danger" href="/communication/delete/${communication.communicationId}/" >Delete</a>

            </td>

        </tr>
        <br/>
    </c:forEach>
        </tbody>
    </table>
<h2>Add a new Communication</h2>

<form:form action="/communication/add/" method="post" modelAttribute="communication">


    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#Add">
        Add
    </button>

    <!-- Modal -->
    <div class="modal fade" id="Add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Add new Communication</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-4">Name:
                            <input type="text" name="name"/></div>
                        <div class="col-md-4 col-md-offset-4">email:
                            <input type="text" name="email"/></div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">phone:
                            <input type="text" name="phone"/></div>
                        <div class="col-md-4 col-md-offset-4">Date of membership:
                            <input type="text" name="membershipDate"/></div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">first met :
                            <input type="text" name="concert"/></div>
                        <div class="col-md-4 col-md-offset-4"> Description:
                            <input type="text" name="description"/></div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">first met :
                            <input type="text" name="concert"/></div>
                        <div class="col-md-4 col-md-offset-4"> other information:
                            <input type="text" name="comment"/></div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>