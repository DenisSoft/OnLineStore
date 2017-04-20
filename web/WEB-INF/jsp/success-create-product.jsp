<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="product" class="entity.Product" scope="request"/>

<html>
<body>
<center>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>ВЫ УСПЕШНО ДОБАВИЛИ ПРОДУКТ!</font>
            <br />
            <font size=2>Регистрационный номер № <%=product.getId()%></font>

        </th>

        <font size=4>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Категория:
                    <br />
                    <jsp:getProperty name="product" property="categoryId"/>
                </td>
                <td valign=top>
                    Название:
                    <br />
                    <jsp:getProperty name="product" property="productName"/>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top colspan=2>
                    Описание:
                    <br />
                    <jsp:getProperty name="product" property="description"/>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Цена:
                    <br />
                    <jsp:getProperty name="product" property="price"/>
                </td>
                <td valign=top>
                    Количество:
                    <br />
                    <jsp:getProperty name="product" property="residue"/>
                </td>
            </tr>

            </tr>

        </font>
    </table>
</center>
</body>
</html>
