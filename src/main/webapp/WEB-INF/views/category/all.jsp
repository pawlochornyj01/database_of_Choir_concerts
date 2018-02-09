<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ include file="update.jsp" %>--%>

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
    <h1>Category list</h1>

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        <tbody>
        <c:forEach  items="${categoryList}" var="category">
<%--<c:set var="id" value="${category.categoryId}"></c:set>--%>

            <tr>

                <td><c:out value="${category.categoryId}"/></td>
                <td><c:out value="${category.name}"/></td>

                <td>
                    <%--<%@ include file="/WEB-INF/views/update.jsp" %>--%>
                    <jsp:include page="/WEB-INF/views/category/update.jsp">
                        <jsp:param name="categoryId" value="${category.categoryId}"/>
                    </jsp:include>

                        <%--<c:import url="update.jsp" var = "category"></c:import>--%>

                    <form action="/category/update/${category.categoryId}/" method="post" >
                    <a class="btn btn-info btn-lg" href="/category/update/${category.categoryId}/" >Update</a>
                            </form>

                </td>

                <td>
                    <a class="btn btn-danger" href="/category/delete/${category.categoryId}/" >Delete</a>

                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>



    <h2>Add a new Category</h2>
    <form:form action="/category/add/" method="post" modelAttribute="category">
        <p>
            Name:
            <input type="text" name="name"/>
        <div class="form-group">
                <%--<label for="name">Name:</label>--%>
                <%--<textarea class="form-control" rows="1"  id="name" name="name" ></textarea>--%>
                <%--</div>--%>
            <form:errors path="name" cssclass="error"><span id="name.errors"
                                                            cssclass="error">may not be empty</span>
            </form:errors>
        </p>
        <button type="submit" class="btn btn-success">Add</button>

    </form:form>
</div>


</body>

</html>