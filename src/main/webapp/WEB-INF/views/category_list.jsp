<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" media="screen">


    <script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
    <title>Index</title>

</head>
<body>
<div class="container">
<h1>Category list</h1>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th></th>
        <th></th>
    </tr>

    <c:forEach items="${categoryList}" var="category">
        <tr>

            <td>${category.categoryId}</td>
            <td>${category.name}</td>

            <td>
                <form:form action="/category/update/${category.categoryId}/" method="post" modelAttribute="category">
                    <button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#Update">
                        Update
                    </button>

                    <div id="Update" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" type="button" data-dismiss="modal">×</button>
                                    <h4 class="modal-title">Please update category</h4>
                                </div>
                                <div class="modal-body">
                                    <table class="table table-striped">
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                        </tr>
                                        <tr>

                                            <td>${category.categoryId}</td>
                                            <td><input type="text" name="name"/></td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-default" type="button" data-dismiss="modal">Cancel</button>
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </div>

                            </div>
                        </div>
                    </div>


                </form:form>
            </td>

            <td>
                <form action="/category/delete/${category.categoryId}/" method="get">

                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>

            </td>
        </tr>
        <br/>
    </c:forEach>
</table>


<h2>Add a new Category</h2>
<form:form method="post" modelAttribute="category">
    <p>
        Name:
        <input type="text" name="name"/>
        <form:errors path="name" cssclass="error"><span id="name.errors"
                                                        cssclass="error">may not be empty</span>
        </form:errors>
    </p>
    <button type="submit" class="btn btn-success">Add</button>

</form:form>
</div>

</body>

</html>