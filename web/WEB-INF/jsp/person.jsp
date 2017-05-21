<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 06.05.2017
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>
<html>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container">
    <table class="table table-condensed">
        <thead>
        <tr bgcolor="#99CC99">

            <td valign=top>
                <strong>#</strong>
            </td>
            <td valign=top>
                <strong>ИМЯ</strong>
            </td>
            <td valign=top>
                <strong>ФАМИЛИЯ</strong>
            </td>
            <td valign=top>
                <strong><center>АДРЕС</center></strong>
            </td>
            <td valign=top>
                <strong>E-Mail</strong>
            </td>
            <td valign=top>
                <strong>ТЕЛЕФОН</strong>
            </td>
            <td valign=top>
                <strong>ПАРОЛЬ</strong>
            </td>
            <td >
            </td>
            <td >
            </td>
        </tr>
        </thead>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                        ${requestScope.person.id}
                </td>
                <td valign=top>
                        ${requestScope.person.firstName}
                </td>
                <td valign=top >
                        ${requestScope.person.lastName}
                </td>
                <td valign=top>
                        ${requestScope.person.address}
                </td>
                <td valign=top>
                        ${requestScope.person.email}
                </td>
                <td valign=top>
                        ${requestScope.person.phone}
                </td>
                <td valign=top >
                        ${requestScope.person.password}
                </td>
                <td valign=top>
                    <a href="${pageContext.request.contextPath}/AllCustomerOrders?id=${requestScope.person.id}">
                        <button class="btn-small btn-success" type="button"><font size=2>Заказы</font></button></a>
                </td>
                <td valign=top>
                    <a href="${pageContext.request.contextPath}/DeletePerson?id=${requestScope.person.id}">
                        <button class="btn-small btn-danger" type="button"><font size=2>Удалить</font></button></a>
                </td>
            </tr>
    </table>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
