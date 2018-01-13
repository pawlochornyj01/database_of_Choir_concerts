<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13.01.2018
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<h3>find category by dudaruk</h3>

<form:form method="post" modelAttribute="category">
    <p>
        dudaryk id:
        <input type="number" name="id"/>

    </p>

    <input type="submit"/>
</form:form>

<h4>This is the category you were looking for</h4>
<h5>${category.categoryId}
    ${category.name}</h5>

</body>
</html>
