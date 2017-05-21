<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>
<jsp:useBean id="product" class="entity.Product" scope="request"/>
<html>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container" style=width:500px>
    <table class="table table-condensed">
        <thead>
        <th bgcolor="#99CC99" colspan=2>
            <center>
            <font size=5>ВЫ УСПЕШНО ДОБАВИЛИ ПРОДУКТ!</font>
            <br/>
            <font size=2>Регистрационный номер № <%=product.getId()%>
            </font>
            </center>
        </th>
        </thead>
        <font size=4>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    Категория:
                    <br/>
                    <jsp:getProperty name="product" property="category"/>
                </td>
                <td valign=top>
                    Название:
                    <br/>
                    <jsp:getProperty name="product" property="productName"/>
                </td>
            </tr>

            <tr bgcolor="#CCFFCC">
                <td valign=top colspan=2 style="width:300px;">
                    Описание:
                    <br/>
                    <jsp:getProperty name="product" property="description"/>
                </td>
            </tr>

            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    Цена:
                    <br/>
                    <jsp:getProperty name="product" property="price"/>
                    руб.
                </td>
                <td valign=top>
                    Остаток:
                    <br/>
                    <jsp:getProperty name="product" property="residue"/>
                    шт.
                </td>
            </tr>
        </font>
    </table>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
