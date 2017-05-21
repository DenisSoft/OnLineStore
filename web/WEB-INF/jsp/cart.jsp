<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 04.05.2017
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<html>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container" style=width:900px>
    <table class="table table-condensed">
        <c:if test="${sessionScope.cart.orderItem.isEmpty()}">
            <th bgcolor="#99CC99" colspan=5>
                <center>ВАША КОРЗИНА ПУСТА</center>
            </th>
        </c:if>
        <c:if test="${!sessionScope.cart.orderItem.isEmpty()}">
            <thead>
            <th bgcolor="#99CC99" colspan=5>
                <center>КОРЗИНА</center>
                <font size=2 color=red>
                <center> ${sessionScope.cart.errors}</center>
                </font>
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
                <td></td>
            </tr>
            </thead>
            <c:forEach var="orderItem" items="${sessionScope.cart.orderItem}">
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
                    <td valign=top>
                        <a href="${pageContext.request.contextPath}/DeleteProductFromCart?productId=${orderItem.key.id}">
                            <button class="btn-small btn-danger" type="button">
                                <font size=2>Удалить</font></button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
                <tr bgcolor="#CCFFCC">
                    <td colspan=3 >
                        <strong>Итого к оплате:</strong>
                    </td>
                    <td colspan=1 align=center>
                            ${sessionScope.cart.orderPrice()*1.0}
                    </td>
                    <td>
                        рублей
                    </td>
                </tr>
            <tr bgcolor="#CCFFCC">
                <td colspan=5 align=center>
                    <a href="${pageContext.request.contextPath}/SaveOrder">
                        <button class="btn btn-success" type="button">Оплатить</button>
                    </a>
                </td>
            </tr>
        </c:if>
    </table>
</div>
<%@include file="footer.jsp" %>
</body>
</html>