<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 04.05.2017
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<html>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container" style="width: 600px;">
    <table class="table table-condensed">
        <c:if test="${not empty requestScope.oder}">
            <thead>
            <th bgcolor="#99CC99" colspan=6>
                <center>ЗАКАЗЫ В КОТОРЫЕ ВКЛЮЧЕН ТОВАР № ${requestScope.id}</center>
            </th>
            </thead>
            <tr bgcolor="#99CC99">
                <td valign=top style="width: 70px;">
                    <center>#</center>
                </td>
                <td valign=top>
                    ОФОРМЛЕН
                </td>
                <td valign=top>
                    ЗАКРЫТ
                </td>
                <td valign=top>
                    СТАТУС
                </td>
            </tr>
            <c:forEach var="oder" items="${requestScope.oder}">
                <tr bgcolor="#CCFFCC">
                    <td valign=top align=center>
                        <span><a href="/Order?id=${oder.id}">${oder.id}</a></span>
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
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty requestScope.oder}">
            <thead>
            <th bgcolor="#99CC99" colspan=6>
                <center>ТОВАР № ${requestScope.id} ОТСУТСТВУЕТ В ЗАКАЗАХ</center>
            </th>
            </thead>
        </c:if>
    </table>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
