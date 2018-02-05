<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">

    <script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <%--<link  href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.1/css/bootstrap.min.css"--%>
    <%--th:href="@{/webjars/bootstrap/3.3.1/css/bootstrap.min.css}"--%>
    <%--rel='stylesheet' media="screen"/>--%>
    <title>Index</title>
</head>
<body>
<h1>
    <c:out value="greeting"/>
</h1>

<button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#myModal">Показать всплывающее окно
</button>
<div id="myModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">×</button>
                <h4 class="modal-title">Заголовок окна</h4>
            </div>
            <div class="modal-body">Текст уведомления</div>
            <div class="modal-footer">
                <button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>
<%--<script src="http://code.jquery.com/jquery-2.2.4.min.js."th:src="@{/webjars/jquery/2.2.4/jquery.min.js}"></script>--%>


</body>
</html>