<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="rdct" uri="/WEB-INF/tld/RedirectTag.tld" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="pie" class="by.epam.bakery.domain.Pie" scope="application"/>
<%--<jsp:useBean id="basket" class="by.epam.bakery.domain.Basket" scope="application"/>--%>
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
    <title>Bakery</title>
</head>
<body>
<div class="container-fluid pt-3">
    <div class="row">
        <ul class="ul_pages">
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="${request.contextPath}controller?command=show_about_us" class="a_link"><img
                            src="image/group.png" class="ico"> ABOUT US</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="${request.contextPath}controller?command=show_main_page" class="a_link"><img
                            src="image/magazine.png" class="ico"> OUR
                        PIES</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="${request.contextPath}controller?command=show_contacts" class="a_link"><img
                            src="image/hours.png" class="ico"> CONTACTS</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="${request.contextPath}controller?command=show_delivery" class="a_link"><img
                            src="image/runner.png" class="ico"> DELIVERY</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <a href="${request.contextPath}controller?command=show_feedback" class="a_link"><img
                            src="image/pen.png" class="ico">
                        FEEDBACK</a>
                </div>
            </li>
            <li class="li_pages">
                <div class="button_navbar_menu">
                    <button type="button" class="in_basket_menu h5" data-toggle="modal" data-target="#myModal">
                        <a href="${request.contextPath}controller?command=show_basket" class="a_link"><img
                                src="image/basket.png" class="ico">
                            BASKET</a>
                    </button>
<%--                    <button type="button" class="in_basket_menu h5" data-toggle="modal" data-target="#myModal">--%>
<%--                        <a href="#" class="a_link"><img src="image/basket.png" class="ico"> BASKET</a>--%>
<%--                    </button>--%>
<%--                    <div class="modal fade" id="myModal">--%>
<%--                        <div class="modal-dialog modal-lg">--%>
<%--                            <div class="modal-content">--%>
<%--                                <!-- Modal Header -->--%>
<%--                                <div class="modal-header">--%>
<%--                                    <h4 class="modal-title">Your basket:</h4>--%>
<%--                                    <button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--                                </div>--%>
<%--                                <!-- Modal body -->--%>
<%--                                <div class="modal-body">--%>
<%--                                    <table class="table table-striped">--%>
<%--                                        <tbody>--%>
<%--&lt;%&ndash;                                        <c:forEach var="elem" items="${basket.pies}" varStatus="status">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <tr>&ndash;%&gt;--%>
<%--                                                <td><img class="image_pie_basket"--%>
<%--                                                         src="<c:out value="${ elem.picture }"/>"></td>--%>
<%--                                                <td><c:out value="${ elem.name }"/></td>--%>
<%--                                                <td><c:out value="${ elem.weight }"/> gramm</td>--%>
<%--                                                <td><c:out value="${ elem.price }"/>0 BYN</td>--%>
<%--&lt;%&ndash;                                            </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        </c:forEach>&ndash;%&gt;--%>
<%--                                        <tr>--%>
<%--                                            <td>--%>
<%--                                                Total:--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                            </td>--%>
<%--                                            <td>--%>
<%--                                                <c:out value="${ total }0 BYN"/>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>
<%--                                        </tbody>--%>
<%--                                    </table>--%>
<%--                                </div>--%>
<%--                                <!-- Modal footer -->--%>
<%--                                <div class="modal-footer">--%>
<%--                                    <form action="controller" method="POST">--%>
<%--                                        <input type="hidden" name="command" value="add_order">--%>
<%--                                        <input type="submit" name="button" class="btn btn-secondary"--%>
<%--                                               value="To order"/>--%>
<%--                                    </form>--%>
<%--                                    <form action="controller" method="POST">--%>
<%--                                        <input type="hidden" name="command" value="clear_basket">--%>
<%--                                        <input type="submit" name="button" class="btn btn-secondary"--%>
<%--                                               value="Clear basket"/>--%>
<%--                                    </form>--%>
<%--                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </li>
        </ul>
    </div>
</div>
</body>
</html>