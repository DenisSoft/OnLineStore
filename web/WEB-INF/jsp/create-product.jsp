<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="product" class="entity.Product" scope="request">
    <jsp:setProperty name="product" property="*"/>
</jsp:useBean>

<html>
<body>
<form action="${pageContext.request.contextPath}/CreateProduct" method="post">
    <center>
        <table cellpadding=4 cellspacing=2 border=0>

            <th bgcolor="#CCCCFF" colspan=2>
                <font size=5>ДОБАВЛЕНИЕ ПРОДУКТА</font>
                <br/>
                <font size=1>* Обязательное поле для заполнения</font>
            </th>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Выберите категорию*

                    <input type="text" name="categoryId"
                           value='<%=product.getCategoryId()%>' size=30 maxlength=30>
                    <br/>
                    <font size=2
                          color=red><%=product.getErrorMsg("categoryId")%>
                    </font>
                </td>
                <td valign=top>
                    Название*

                    <input type="text" name="productName"
                           value='<%=product.getProductName()%>' size=30 maxlength=30>
                    <br/>
                    <font size=2
                          color=red><%=product.getErrorMsg("productName")%>
                    </font>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top colspan=2>
                    Описание*
                    <br/>
                    <input type="text" name="description" value='<%=product.getDescription()%>'
                           size=100 maxlength=100>
                    <br/>
                    <font size=2 color=red><%=product.getErrorMsg("description")%>
                    </font>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Цена*

                    <input type="text" name="price" size=10
                           value='<%=product.getPrice()%>' maxlength=10>
                    <br/>
                    <font size=2
                          color=red><%=product.getErrorMsg("price")%>
                    </font>
                </td>
                <td valign=top>
                    Количество*

                    <input type="text" name="residue" size=10
                           value='<%=product.getResidue()%>' maxlength=10>
                    <br/>
                    <font size=2
                          color=red><%=product.getErrorMsg("residue")%>
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
