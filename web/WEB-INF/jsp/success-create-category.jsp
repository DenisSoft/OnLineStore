<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>
<jsp:useBean id="category" class="entity.Category" scope="request"/>

<html>
<body>
<%@include file="header.jsp"%>
<br/>
<div class="container" style=width:600px>
    <table class="table table-condensed">
        <th bgcolor="#99CC99" colspan=2>
            <center>
            <font size=5>ВЫ УСПЕШНО СОЗДАЛИ КАТЕГОРИЮ</font>
            <br />
            <font size=2>Регистрационный номер № <%=category.getId()%></font>
            </center>
        </th>
        <font size=4>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    Название:
                    <jsp:getProperty name="category" property="categoryName"/>
                </td>
            </tr>
        </font>
    </table>
</div>
<%@include file="footer.jsp"%>
</body>
</html>

