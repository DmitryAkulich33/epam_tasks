<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="../../css/style.css" %>
        <%@include file="../../css/bootstrap.min.css" %>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script>
        <%@include file="../../js/bootstrap.js" %>
    </script>
    <title>Admin account</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="admin_menu.jsp"/>
<div class="container-fluid">
    <br>
    <br>
    <h2>Baskets:</h2>
    <br>
    <ul class="nav">
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModal4">
                Find basket by user id
            </button>
            <div class="modal fade" id="myTopModal4">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find basket</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter id</span>
                                    </div>
                                    <input type="text" class="form-control" name="userId">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="find_basket_by_user_id">
                                    <input type="submit" value="Find basket" class="btn btn-secondary">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="li_admin nav-item">
            <form action="controller" method="POST">
                <input type="hidden" name="command" value="admin_basket">
                <input type="submit" class="change-info btn btn-primary" value="Show all baskets">
            </form>
        </li>
    </ul>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>User id</th>
            <th>User surname</th>
            <th>User name</th>
            <th>User patronymic</th>
            <th>Total</th>
            <th>Action</th>
            <th></th>
        </tr>
        </thead>
        <%--        <c:forEach var="element" items="${orders}" varStatus="status">--%>
        <%--            <tr>--%>
        <%--                <td><c:out value="${ element.id }"/></td>--%>
        <%--                <td><c:out value="${ element.role }"/></td>--%>
        <%--                <td><c:out value="${ element.surname }"/></td>--%>
        <%--                <td><c:out value="${ element.name }"/></td>--%>
        <%--                <td><c:out value="${ element.patronymic }"/></td>--%>
        <%--                <td><c:out value="${ element.address }"/></td>--%>
        <%--                <td><c:out value="${ element.phone }"/></td>--%>
        <%--                <td><c:out value="${ element.note }"/></td>--%>
        <%--                <td>--%>
        <%--                    <button type="button" class="change-info btn btn-primary" data-toggle="modal"--%>
        <%--                            data-target="#myModal${ element.id }">--%>
        <%--                        Delete--%>
        <%--                    </button>--%>
        <%--                    <div class="modal fade" id="myModal${ element.id }">--%>
        <%--                        <div class="modal-dialog modal-dialog-centered modal-sm">--%>
        <%--                            <div class="modal-content">--%>
        <%--                                <div class="modal-body">--%>
        <%--                                    Do you want to remove the order from the database?--%>
        <%--                                </div>--%>
        <%--                                <div class="modal-footer">--%>
        <%--                                    <form action="controller" method="POST">--%>
        <%--                                        <input type="hidden" name="delId" value="${ element.id }"/>--%>
        <%--                                        <input type="hidden" name="command" value="delete_basket">--%>
        <%--                                        <input type="submit" class="btn btn-secondary" value="Delete">--%>
        <%--                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel--%>
        <%--                                        </button>--%>
        <%--                                    </form>--%>
        <%--                                </div>--%>
        <%--                            </div>--%>
        <%--                        </div>--%>
        <%--                    </div>--%>
        <%--                </td>--%>
        <%--            </tr>--%>
        <%--        </c:forEach>--%>
    </table>
</div>

<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>