<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <style>
        <%@include file="../../../css/style.css" %>
        <%@include file="../../../css/bootstrap.min.css" %>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script>
        <%@include file="../../../js/bootstrap.js" %>
    </script>
    <title>Feedback</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:include page="login.jsp"/>
<jsp:include page="menu.jsp"/>
<div class="container-fluid mt-3">
    <p>Your feedback:</p>
    <br>
    <div class="wrong_message">
        <p><c:out value="${ message }"/></p>
    </div>
    <c:choose>
        <c:when test="${user.role == 3}">
            <form action="controller" method="POST">
                <div class="input-group mb-3">
                    <textarea class="form-control" name="review" rows="3" placeholder="max 2000 symbols" required></textarea>
                </div>
                <input type="hidden" name="command" value="add_feedback">
                <input type="submit" value="Send feedback" class="btn btn-outline-secondary">
            </form>
        </c:when>
        <c:otherwise>
            <div class="input-group mb-3">
                <textarea class="form-control" name="review" rows="3" placeholder="max 2000 symbols" required></textarea>
            </div>
            <input type="submit" value="Send feedback" class="btn btn-outline-secondary" data-toggle="modal"
                   data-target="#AddNewFeedback">
            <div class="modal fade" id="AddNewFeedback">
                <div class="modal-dialog modal-dialog-centered modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;
                            </button>
                        </div>
                        <div class="modal-body">
                            You need to log in as a user!
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary"
                                    data-dismiss="modal">Close
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
    <br>
    <c:forEach var="element" items="${feedback}" varStatus="status">
        <br>
        <div class="feedback media border p-3">
            <div class="media-body">
                <h4><c:out value="${ element.user.surname }"/> <c:out value="${ element.user.name }"/><small><i> posted
                    <c:out value="${ element.localDateTime.toString().replace(\"T\", \" \") }"/></i></small></h4>
                <p><c:out value="${ element.review }"/></p>
            </div>
        </div>
    </c:forEach>
    <ul class="pagination justify-content-center" style="margin:20px 0">
        <li class="page-item"><a class="pagination_color page-link"
                                 href="${request.contextPath}controller?command=show_feedback&page=1">The first</a></li>
        <li class="page-item"><a class="pagination_color page-link"
                                 href="${request.contextPath}controller?command=show_feedback_decrease_page&page=${page}&count=${count}"><<</a>
        </li>
        <li class="pagination_number">
            <span class="pagination_number"><mark>&nbspPage <c:out value="${ page }"/> from <c:out value="${ count }"/>&nbsp</mark></span>
        </li>
        <li class="page-item">
            <a class="pagination_color page-link"
               href="${request.contextPath}controller?command=show_feedback_increase_page&page=${page}&count=${count}">>></a>
        </li>
        <li class="page-item"><a class="pagination_color page-link"
                                 href="${request.contextPath}controller?command=show_feedback&page=${count}">The
            last</a></li>
    </ul>
</div>
<div class="container-fluid pt-3">
    <div class="footer">
        <jsp:include page="footer.jsp"/>
    </div>
</div>
</body>
</html>