<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<jsp:useBean id="product" class="entity.Product" scope="request">
    <jsp:setProperty name="product" property="*"/>
</jsp:useBean>

<html>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container" style=width:700px>
    <form action="${pageContext.request.contextPath}/CreateProduct" method="post">
        <table class="table table-condensed">
            <thead>
            <th bgcolor="#99CC99" colspan=2>
                <center>
                    <font size=5>ДОБАВЛЕНИЕ ПРОДУКТА</font>
                    <br/>
                    <font size=1>* Обязательное поле для заполнения</font>
                </center>
            </th>
            </thead>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    Выберите категорию*

                    <select name="category.id">
                        <c:forEach items="${requestScope.categories}" var="category">
                            <option value="${category.id}">${category.categoryName}</option>
                        </c:forEach>
                    </select>

                    <br/>
                    <font size=2
                          color=red><%=product.getErrorMsg("category")%>
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

            <tr bgcolor="#CCFFCC">
                <td valign=top colspan=2>
                    Описание*

                    <br/>
                    <textarea cols="91" rows="5" name="description">
                        <c:out value="<%=product.getDescription()%>"/>
                    </textarea>
                    <br/>
                    <font size=2 color=red><%=product.getErrorMsg("description")%>
                    </font>
                </td>
            </tr>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    Цена*

                    <input type="number" name="price" size=10
                           value='<%=product.getPrice()%>' maxlength=10>
                    <br/>
                    <font size=2
                          color=red><%=product.getErrorMsg("price")%>
                    </font>
                </td>
                <td valign=top>
                    Количество*

                    <input type="number" name="residue" size=10
                           value='<%=product.getResidue()%>' maxlength=10>
                    <br/>
                    <font size=2
                          color=red><%=product.getErrorMsg("residue")%>
                    </font>
                </td>

            </tr>
            <tr bgcolor="#CCFFCC">
                <td colspan=2 align=center>
                    <input type="submit" value="Сохранить"> <input type="reset" value="Очистить">
                </td>
            </tr>
        </table>
    </form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
