<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 25.04.2017
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container">
    <table class="table table-condensed">
        <thead>
        <c:if test="${requestScope.allOders == null}">
            <th bgcolor="#99CC99" colspan=8>
                <center>ЗАКАЗЫ ПОЛЬЗОВАТЕЛЯ № ${requestScope.id}</center>
            </th>
        </c:if>
        <tr bgcolor="#99CC99">
            <td valign=top style="width: 70px;">
                <strong> <center>#</center></strong>
            </td>
            <td valign=top>
                <strong> <center>НАИМЕНОВАНИЕ</center></strong>
            </td>
            <td valign=top>
                <strong> <center>СТОИМОСТЬ</center></strong>
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
            <td valign=top>
            </td>
        </tr>
        </thead>
        <c:forEach var="oder" items="${requestScope.oder}">

            <tr bgcolor="#CCFFCC">
                <td valign=top align=center>
                    <span><a href="/Order?id=${oder.id}">${oder.id}</a></span>
                </td>
                <td valign=top>
                    <c:forEach var="orderItem" items="${oder.orderItem}">
                    <li>${orderItem.key.productName} -
                            ${orderItem.value}шт.
                        </c:forEach>
                </td>
                <td valign=top align=center >
                        ${oder.orderPrice()} &nbsp; руб.
                </td>
                <td valign=top>
                        ${oder.dateCreated}
                </td>
                <td valign=top>
                        ${oder.dateClosing}
                </td>
                <td valign=top>
                        ${oder.orderStatus}
                </td>
                <td valign=top>
                    <c:if test="${oder.orderStatus eq 'CREATED'}">
                    <a href="/ChangeStatus?id=${oder.id}">
                        <button class="btn-small label-inverse" type="button">
                            <font size=2>Закрыть</font></button></a>
                    </c:if>
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

