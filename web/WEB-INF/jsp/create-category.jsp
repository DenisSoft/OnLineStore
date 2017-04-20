<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="category" class="entity.Category" scope="request">
    <jsp:setProperty name="category" property="*"/>
</jsp:useBean>

<html>
<body>
<form action="${pageContext.request.contextPath}/CreateCategory" method="post">
    <center>
        <table cellpadding=4 cellspacing=2 border=0>

            <th bgcolor="#CCCCFF" colspan=2>
                <font size=5>СОЗДАНИЕ КАТЕГОРИИ</font>
                <br/>
                <font size=1>* Обязательное поле для заполнения</font>
            </th>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    НАЗВАНИЕ НОВОЙ КАТЕГОРИИ*

                    <input type="text" name="categoryName"
                           value='<%=category.getCategoryName()%>' size=22 maxlength=22>
                    <br/>
                    <font size=2
                          color=red><%=category.getErrors()%>
                    </font>
                </td>
            </tr>
            <tr bgcolor="#c8d8f8">
                <td colspan=2 align=center>
                    <input type="submit" value="Сохранить"> <input type="reset"
                                                                   value="Очистить">
                </td>
            </tr>

        </table>
    </center>
</form>
</body>
</html>
