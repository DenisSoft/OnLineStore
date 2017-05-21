<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>
<jsp:useBean id="category" class="entity.Category" scope="request">
    <jsp:setProperty name="category" property="*"/>
</jsp:useBean>

<html>
<body>
<%@include file="header.jsp"%>
<br/>
<div class="container" style=width:500px>
<form action="${pageContext.request.contextPath}/CreateCategory" method="post">
        <table class="table table-condensed">
            <thead>
            <th bgcolor="#99CC99" colspan=2>
                <center>
                <font size=5>СОЗДАНИЕ КАТЕГОРИИ</font>
                <br/>
                <font size=1>* Обязательное поле для заполнения</font>
                </center>
            </th>
            </thead>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    НАЗВАНИЕ НОВОЙ КАТЕГОРИИ*
                    <input type="text" name="categoryName"
                           value='<%=category.getCategoryName()%>' size=70 maxlength=70>
                    <br/>
                    <font size=2
                          color=red><%=category.getErrors()%>
                    </font>
                </td>
            </tr>
            <tr bgcolor="#CCFFCC">
                <td colspan=2 align=center>
                    <input type="submit" value="Сохранить">
                    <input type="reset" value="Очистить">
                </td>
            </tr>

        </table>
</form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
