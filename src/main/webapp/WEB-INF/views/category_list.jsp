<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
</head>
<body>
<h1>Category list</h1>

<c:forEach items="${categoryList}" var="category">
    ${category.categoryId} - ${category.name} is a category from  ${category.dudaryk.name} ${category.dudaryk.lastname}
    <br/>
</c:forEach>

</body>
</html>
