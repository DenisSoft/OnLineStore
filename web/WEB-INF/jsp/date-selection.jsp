<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 09.05.2017
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>
<html>
<head>
    <title>DateSelection</title>
</head>
<body>
<%@include file="header.jsp"%>
<br/>
<div class="container" style=width:520px>
    <form action="${pageContext.request.contextPath}/DeleteOrders" method="post">
        <table class="table table-condensed">
            <thead>
            <th bgcolor="#99CC99" colspan=2>
                <center>
                    <font size=5>УДАЛЕНИЕ ЗАКАЗОВ</font>
                    <br/>
                    <font size=1>* Обязательное поле для заполнения</font>
                </center>
            </th>
            </thead>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    ВЫБЕРИТЕ ДАТУ ДО КОТОРОЙ НУЖНО УДАЛИТЬ ЗАКАЗЫ*
                    <input type="date" name="date">
                           <%--value='<%=category.getCategoryName()%>' size=70 maxlength=70>--%>
                    <br/>
                    <font size=2 color=red>${requestScope.errorDate}</font>
                </td>
            </tr>
            <tr bgcolor="#CCFFCC">
                <td colspan=2 align=center>
                    <input type="submit" class="btn-danger" value="Удалить">
                </td>
            </tr>

        </table>
    </form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
