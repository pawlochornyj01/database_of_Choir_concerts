<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="category_list.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" media="screen">


    <script type="text/javascript" src="/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</head>
<body>
<c:import url="category_list.jsp" var = "category"></c:import>

<%--&lt;%&ndash;<%@ include file="category_list.jsp" %>&ndash;%&gt;--%>
<form:form action="/category/update/${category.categoryId}/" method="post"  >

    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <tr>

            <td><c:out value="${category.categoryId}"/></td>
            <%--<td><input type="text" name="name"/>--%>

            <td><textarea class="form-control" id="name" name="name"></textarea>
            </td>
            <td>
                <button type="submit" class="btn btn-primary">Save</button>
            </td>
        </tr>
    </table>

    <a class="btn btn-default" href="/category/all/">Cancel</a>


</form:form>
</body>
</html>
