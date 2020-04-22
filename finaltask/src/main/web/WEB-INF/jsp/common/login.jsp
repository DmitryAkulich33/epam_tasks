<%--<jsp:useBean id="user" class="by.epam.bakery.domain.User" scope="application"/>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="../../../css/bootstrap.min.css" %>
        <%@include file="../../../css/style.css" %>
    </style>
    <script>
        <%@include file="../../../js/bootstrap.js" %>
    </script>
    <title>Bakery</title>
</head>
<body>
<div class="container-fluid pt-3">
    <div>
        <c:choose>
            <c:when test="${user.role == 1}">
                <div class="welcome">
                    <p><em>Welcome, <c:out value="${ user.surname }"/> <c:out value="${ user.name }"/> <c:out value="${ user.patronymic }"/></em></p>
                    <ul class="nav">
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=admin_account">Admin account</a>
                        </li>
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=log_out">Exit</a>
                        </li>
                    </ul>
                </div>
                <br/>
            </c:when>
            <c:when test="${user.role == 2}">
                <div class="welcome">
                    <p><em>Welcome, <c:out value="${ user.surname }"/> <c:out value="${ user.name }"/> <c:out value="${ user.patronymic }"/></em></p>
                    <ul class="nav">
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=courier_account">Courier account</a>
                        </li>
                        <li class="li_admin">
                            <a class= "link_acc nav_link" href="${request.contextPath}controller?command=log_out">Exit</a>
                        </li>
                    </ul>
                </div>
                <br/>
            </c:when>
            <c:when test="${user.role == 3}">
                <div class="welcome">
                    <p><em>Welcome, <c:out value="${ user.surname }"/> <c:out value="${ user.name }"/> <c:out value="${ user.patronymic }"/></em></p>
                    <ul class="nav">
                        <li class="li_admin">
                            <a class= "link_acc nav_link pl-1" href="${request.contextPath}controller?command=personal_account&page=1">Personal account</a>
                        </li>
                        <li class="li_admin">
                            <a class= "link_acc nav_link pl-1" href="${request.contextPath}controller?command=log_out">Exit</a>
                        </li>
                    </ul>
                </div>
                <br/>
            </c:when>
            <c:otherwise>
                <form action="controller" method="POST">
                    <label for="login-field">Login</label>
                    <input type="text" name="login" id="login-field" placeholder="Login(5-12 symbols)" pattern="(^[a-zA-Z0-9_-]{5,12}$)" required>
                    <label for="password-field">Password</label>
                    <input type="password" name="password" id="password-field" placeholder="Password(5-12 symbols)" pattern="(^[a-zA-Z0-9_-]{5,12}$)" required>
                    <input type="hidden" name="command" value="login">
                    <input type="submit" value="Submit" class="button_enter">
                    <a class= "link_acc nav_link pl-1" href="${request.contextPath}controller?command=registration">Registration!</a>
                    <div class="wrong_login">
                        <p><c:out value="${ message }"/></p>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>