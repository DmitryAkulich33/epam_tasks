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
    <title>Courier account</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="courier_menu.jsp"/>
<div class="container-fluid">
    <br>
    <br>
    <h2>Users:</h2>
    <br>
    <ul class="nav">
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModal4">
                Find user by id
            </button>
            <div class="modal fade" id="myTopModal4">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find user</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter Id</span>
                                    </div>
                                    <input type="text" class="form-control" name="userId">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="courier_find_client_by_id">
                                    <input type="submit" value="Find user" class="btn btn-secondary">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </li>
        <li class="li_admin nav-item">
            <button type="button" class="change-info btn btn-primary" data-toggle="modal" data-target="#myTopModal5">
                Find user by surname
            </button>
            <div class="modal fade" id="myTopModal5">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Find user</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="controller" method="POST">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Enter surname</span>
                                    </div>
                                    <input type="text" class="form-control" name="userSurname">
                                </div>
                                <div class="modal-footer">
                                    <input type="hidden" name="command" value="courier_find_client_by_surname">
                                    <input type="submit" value="Find user" class="btn btn-secondary">
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
                <input type="hidden" name="command" value="courier_clients">
                <input type="submit" class="change-info btn btn-primary" value="Show all users">
            </form>
        </li>
    </ul>
    <br>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Role</th>
            <th>Surname</th>
            <th>Name</th>
            <th>Patronymic</th>
            <th>Address</th>
            <th>PhoneNumber</th>
            <th>Note</th>
            <th>Action</th>
            <th></th>
        </tr>
        </thead>
        <c:forEach var="element" items="${clients}" varStatus="status">
            <tr>
                <td><c:out value="${ element.id }"/></td>
                <td><c:out value="${ element.role }"/></td>
                <td><c:out value="${ element.surname }"/></td>
                <td><c:out value="${ element.name }"/></td>
                <td><c:out value="${ element.patronymic }"/></td>
                <td><c:out value="${ element.address }"/></td>
                <td><c:out value="${ element.phone }"/></td>
                <td><c:out value="${ element.note }"/></td>
                <td>
                    <button type="button" class="change-info btn btn-primary" data-toggle="modal"
                            data-target="#mySecModal${ element.id }">
                        Change note
                    </button>
                    <div class="modal fade" id="mySecModal${ element.id }">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Change note</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <form action="controller" method="POST">
                                        <div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">New note</span>
                                            </div>
                                            <input type="text" class="form-control" name="changeNote">
                                        </div>
                                        <div class="modal-footer">
                                            <input type="hidden" name="changeId" value="${ element.id }"/>
                                            <input type="hidden" name="command" value="change_note">
                                            <input type="submit" class="btn btn-secondary" value="Change">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                Cancel
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>