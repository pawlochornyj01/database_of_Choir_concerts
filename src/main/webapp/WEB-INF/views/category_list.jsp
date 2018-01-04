<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style type="text/css">
        h1{
            color: firebrick;
            font-family: Arial;
            font-size: 70px;
            text-align: center;
        }

    .class1{
    border: 4px outset firebrick;
        padding: 10px;

    }
        th.class1{
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
        <th>Dudaryk Name</th>
        <th>Dudaryk LastName</th>
    </tr>

    <c:forEach items="${categoryList}" var="category">
        <tr>

            <td>${category.categoryId}</td>
            <td>${category.name}</td>
            <td>${category.dudaryk.name}</td>
            <td>${category.dudaryk.lastname}</td>

        </tr>
        <br/>
    </c:forEach>
</table>
</body>
</html>
