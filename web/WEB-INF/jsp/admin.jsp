<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 23.04.2017
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<jsp:useBean id="person" class="entity.Person" scope="request"/>
<html>
<head>
    <title>Admin</title>
</head>
<%--<body bgcolor="#619d28" background="${pageContext.request.contextPath}resources/images/bg.jpg" bgproperties="fixed">--%>
<%@include file="header.jsp" %>
<br/>
<div class="container">
    <h4><strong>Статистика с ${requestScope.startDate} по ${requestScope.finalDate}</strong></h4>
    <form action="${pageContext.request.contextPath}/Admin" method="post">
        <h4>Период:</h4>
        с &nbsp;<input type="date" name="startDate">&nbsp;
        по&nbsp; <input type="date" name="finalDate">&nbsp;
        <input type="submit" class="btn-primary" value="Показать">
    </form>
    <table class="table table-condensed">
        <thead>
        <tr bgcolor="#99CC99">
            <td valign=top style="width: 70px;">
                <strong>
                    <center>#</center>
                </strong>
            </td>
            <td valign=top>
                <strong>
                    <center>НАИМЕНОВАНИЕ</center>
                </strong>
            </td>
            <td valign=top>
                <strong>
                    <center>СТОИМОСТЬ</center>
                </strong>
            </td>
            <td valign=top>
                <strong> ОФОРМЛЕН</strong>
            </td>
            <td valign=top>
                <strong> ЗАКРЫТ</strong>
            </td>
            <td valign=top>
                <strong>СТАТУС</strong>
            </td>
        </tr>
        </thead>
        <c:forEach var="order" items="${requestScope.order}">
            <tr bgcolor="#CCFFCC">
                <td valign=top align=center>
                    <span><a href="/Order?id=${order.id}">${order.id}</a></span>
                </td>
                <td valign=top>
                    <c:forEach var="orderItem" items="${order.orderItem}">
                    <li>${orderItem.key.productName} -
                            ${orderItem.value}шт.
                        </c:forEach>
                </td>
                <td valign=top align=center >
                        ${order.orderPrice()} &nbsp; руб.
                </td>
                <td valign=top>
                        ${order.dateCreated}
                </td>
                <td valign=top>
                        ${order.dateClosing}
                </td>
                <td valign=top>
                        ${order.orderStatus}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<br/>


<%@include file="footer.jsp" %>
</body>
</html>
