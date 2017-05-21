<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 20.04.2017
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<html>
<head>
    <title>Главная</title>
    <style>
        select {
            width: 50px;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container">
    <table class="table table-condensed">
        <thead>
        <tr bgcolor="#99CC99">
            <th >
                <center><strong>#</strong></center>
            </th>
            <th>
                <strong>
                    <center> НАИМЕНОВАНИЕ</center>
                </strong>
            </th>
            <th>
                <strong>КАТЕГОРИЯ</strong>
            </th>
            <th align=center>
                <strong>ЦЕНА</strong>
            </th>
            <th align=center>
                <strong>ОСТАТОК</strong>
            </th>
            <th>
            </th>
            <th>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${requestScope.products}">

        <tr bgcolor="#CCFFCC">
            <td valign=top style="width: 70px;" align=center>
                    ${product.id}
            </td>
            <td valign=top>
                <span><a href="/Product?id=${product.id}">${product.productName}</a></span>
            </td>
            <td valign=top>
                    ${product.category}
            </td>
            <td valign=top>
                    ${product.price}
            </td>
            <td valign=top align=center>
                    ${product.residue}
            </td>
            <td valign=top>
                <c:if test="${sessionScope.admin eq true}">
                    <a href="${pageContext.request.contextPath}/AllProductOrders?id=${product.id}">
                        <button class="btn-small btn-success" type="button"><font size=2>Заказы</font></button>
                    </a>
                </c:if>
            </td>
            <td valign=top>
                <c:if test="${sessionScope.admin eq true}">
                    <a href="${pageContext.request.contextPath}/DeleteProduct?id=${product.id}">
                        <button class="btn-small btn-danger" type="button"><font size=2>Удалить</font></button>
                    </a>
                </c:if>
                <c:if test="${!sessionScope.admin eq true}">
                    <c:if test="${product.residue == 0}">
                        <center>Товар не доступен!</center>
                    </c:if>
                    <c:if test="${product.residue != 0}">
                        <form action="${pageContext.request.contextPath}/AddProductToCatr" method="get">
                            <select size="1" name="amount">
                                <c:forEach var="number" begin="1" end="${product.residue}">
                                    <option value="${number}">${number}</option>
                                </c:forEach>
                            </select>
                            <% request.setAttribute("product", "${product.id}"); %>
                            <button type="submit" class="btn-small btn-success"
                                    name="productId" value="${product.id}"
                            >Добавить в корзину</button>
                        </form>
                    </c:if>
                </c:if>
            </td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
<br/>
<br/>
<%@include file="footer.jsp" %>
</body>
</html>
