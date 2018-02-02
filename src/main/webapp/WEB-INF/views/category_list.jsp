<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <style type="text/css">
        h1 {
            color: firebrick;
            font-family: Arial;
            font-size: 50px;
            text-align: center;
        }

        .class1 {
            border: 4px outset firebrick;
            padding: 10px;

        }

        th.class1 {
            color: antiquewhite;
        }
    </style>
</head>
<body>
<h1>Category list</h1>
<table border="1" class="class1">
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <c:forEach items="${categoryList}" var="category">
        <tr>

            <td>${category.categoryId}</td>
            <td>${category.name}</td>
            <td>
                <form action="/category/delete/${category.categoryId}/" method="get">
                    <input type="submit" value="Delete" name="remove">
                </form>

            </td>
            <td>
                <form:form action="/category/update/${category.categoryId}/" method="put" modelAttribute="category">
                    <%--<input type="button" value="Update" name="update" onclick="">--%>
                    <button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#myModal">
                        Update
                    </button>
                    <div id="myModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button class="close" type="button" data-dismiss="modal">×</button>
                                    <h4 class="modal-title">Please update category</h4>
                                </div>
                                <div class="modal-body">
                                    <table border="1" class="class1">
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                        </tr>
                                        <tr>

                                            <td>${category.categoryId}</td>
                                            <input type="text" name="name"/>
                                        </tr>
                                    </table>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
                                </div>
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </div>

                </form:form>
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
    <input type="submit"/>
</form:form>


<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>