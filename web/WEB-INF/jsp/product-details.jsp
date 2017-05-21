<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 25.04.2017
  Time: 12:28
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
<div class="container">
    <table class="table table-bordered">
        <thead>
        <th bgcolor="#99CC99" colspan=2>
            <center>
                <font size=5>
                    <jsp:getProperty name="product" property="productName"/>
                </font>
                <br/>
                <font size=2>Регистрационный номер №
                    <jsp:getProperty name="product" property="id"/>
                </font>
            </center>
        </th>
        </thead>
        <tr bgcolor="#CCFFCC">
            <td valign=top colspan=2 style="width:300px;">
                Категория:
                <jsp:getProperty name="product" property="category"/>
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
        <tr bgcolor="#CCFFCC">
            <td colspan=2 align=center>
                <c:if test="${sessionScope.admin eq true}">
                    <a href="${pageContext.request.contextPath}/AllProductOrders?id=${product.id}">
                        <button class="btn-small btn-success" type="button">Заказы</button>
                    </a>
                    <a href="${pageContext.request.contextPath}/DeleteProduct?id=${product.id}">
                        <button class="btn-small btn-danger" type="button">Удалить</button>
                    </a>
                </c:if>
                <c:if test="${sessionScope.admin eq null}">
                    <c:if test="${product.residue != 0}">

                        <form action="${pageContext.request.contextPath}/AddProductToCatr" method="get" >
                            <select size="1" name="amount" >
                                <c:forEach var="number" begin="1" end="${product.residue}">
                                    <option value="${number}">${number}</option>
                                </c:forEach>
                            </select>
                            <button  type="submit" class="btn-small btn-success"
                                     name="productId" value="${product.id}"
                                     >Добавить в корзину</button>
                        </form>
                    </c:if>
                    <c:if test="${product.residue == 0}">
                        <center>К сожалению, этот товар теперь не доступен!</center>
                    </c:if>
                </c:if>
            </td>
        </tr>
    </table>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
