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

                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container">
    <h1> List of Singers</h1>

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

    <%--<select class="form-control">--%>
    <%--<option>1</option>--%>
    <%--<option>2</option>--%>
    <%--<option>3</option>--%>
    <%--<option>4</option>--%>
    <%--<option>5</option>--%>
    <%--</select>--%>


    <h2>Add a new Singer</h2>

    <form:form action="/singer/add/" method="post" modelAttribute="dudaryk">


    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#Add">
        Add
    </button>

    <!-- Modal -->
    <div class="modal fade" id="Add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Add new Dudaryk</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-4">Name:
                            <input type="text" name="name"/></div>
                        <div class="col-md-4 col-md-offset-4">LastName:
                            <input type="text" name="lastName"/></div>

                    </div>
                    <div class="row">
                        <div class="col-md-4">phone:
                            <input type="text" name="phone"/></div>
                        <div class="col-md-4 col-md-offset-4">Birthday:
                            (YYYY-MM-DD)
                            <input type="text" name="birthday"/></div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">email:
                            <input type="text" name="email"/></div>
                        <div class="col-md-4 col-md-offset-4"> Description:
                            <input type="text" name="description"/></div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">action:
                            <div class="checkbox">
                                <label><input type="checkbox" value="true" name="isAction">true</label>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="false" name="isAction">false</label>
                            </div>
                                <%--<form:radiobutton path="isAction" value="true"/> true--%>
                                <%--<form:radiobutton path="isAction" value="false"/> false--%>
                        </div>
                        <div class="col-md-4 col-md-offset-4">Voice:
                            <div class="checkbox">
                                <label><input type="checkbox" value="DISCANTO" name="voice">DISCANTO</label>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="ALTO" name="voice">ALTO</label>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="TENOR" name="voice">TENOR</label>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" value="BASS" name="voice">BASS</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    </div>
    </form:form>
<h2>Search Singer</h2>
    <form:form action="/singer/search/" method="get">
    <select class="mdb-select colorful-select dropdown-primary" searchable="Search here..">
        <option value="ID" name="searchMode">by Id</option>
        <option value="NAME" name="searchMode">by Name</option>
        <option value="LASTNAME" name="searchMode">by LastName</option>
        <option value="VOICE" name="searchMode">by Voice</option>
        <option value="ACTION" name="searchMode">Action Singers</option>
        <option value="CONCERT" name="searchMode">by Concert Id</option>
    </select>
    <label>please choose a mode of searching </label>

    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="searchParam">
    <button class="btn btn-outline-success btn-rounded btn-sm my-0" type="submit">Search</button>


    </form:form>


</body>
</html>
