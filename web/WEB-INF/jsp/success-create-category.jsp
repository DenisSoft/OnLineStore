<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="category" class="entity.Category" scope="request"/>

<html>
<body>
<center>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>ВЫ УСПЕШНО СОЗДАЛИ КАТЕГОРИЮ</font>
            <br />
            <font size=2>Регистрационный номер № <%=category.getId()%></font>
        </th>
        <font size=4>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Название:
                    <br />
                    <jsp:getProperty name="category" property="categoryName"/>
                </td>
            </tr>
        </font>
    </table>
</center>
</body>
</html>

