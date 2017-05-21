<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 07.05.2017
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<html>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container" style=width:900px>
    <table class="table table-condensed">
        <thead>
        <th bgcolor="#99CC99" colspan=4>
            <center>ВЫ УСПЕШНО ОФОРМИЛИ ЗАКАЗ</center>
            <center>Ваш заказ № ${requestScope.order.id}</center>
        </th>
        <tr bgcolor="#99CC99">
            <td valign=top align=center>
                <strong>
                    НАИМЕНОВАНИЕ
                </strong>
            </td>
            <td valign=top align=center>
                <strong>
                    КОЛ.
                </strong>
            </td>
            <td valign=top align=center>
                <strong>
                    ЦЕНА ЗА ЕД.
                </strong>
            </td>
            <td valign=top align=center>
                <strong>
                    СТОИМОСТЬ
                </strong>
            </td>
        </tr>
        </thead>
        <c:forEach var="orderItem" items="${requestScope.order.orderItem}">
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    <li>${orderItem.key.productName}
                </td>
                <td valign=top align=center>
                        ${orderItem.value}
                </td>
                <td valign=top align=center>
                        ${orderItem.key.price}
                </td>
                <td valign=top align=center>
                        ${orderItem.key.price * orderItem.value}
                </td>
            </tr>
        </c:forEach>
        <tr bgcolor="#CCFFCC">
            <td colspan=3>
                <strong>Итого:</strong>
            </td>
            <td colspan=1 align=center>
                ${requestScope.order.orderPrice()*1.0}
            </td>
        </tr>
        <th bgcolor="#CCFFCC" colspan=4>
            <center>
            <a href="${pageContext.request.contextPath}/DownloadReport?id=${requestScope.order.id}">
                <button class="btn btn-info" type="button">Скачать отчет</button>
                </a>
                </center>
        </th>
    </table>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
