<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03.01.2018
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1>Category list</h1>

<c:forEach items="${categoryList}" var="category">
    ${category.id}-${category.name} is a category from  ${category.dudaryk.name} ${category.dudaryk.lastname}
    <br/>
</c:forEach>
</body>
</html>
