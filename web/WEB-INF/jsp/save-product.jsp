<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 15.04.2017
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> New Product </title>
</head>
<body>
<p>${requestScope.errors.name}</p>
<form action="${pageContext.request.contextPath}/newProduct" method="post">
    <label for="categoryId"> КАТЕГОРИЯ ПРОДУКТА </label>
    <input type="text" name ="categoryId" id="categoryId"><br>
    <label for="productName"> НАЗВАНИЕ </label>
    <input type="text" name ="productName" id="productName" ><br>
    <label for="description"> ОПИСАНИЕ </label>
    <input type="text" name ="description" id="description" ><br>
    <label for="price"> ЦЕНА </label>
    <input type="text" name ="price" id="price" ><br>
    <label for="residue"> КОЛИЧЕСТВО </label>
    <input type="text" name ="residue" id="residue" ><br>

    <button type="submit"> СОХРАНИТЬ </button>
</form>
</body>
</html>
