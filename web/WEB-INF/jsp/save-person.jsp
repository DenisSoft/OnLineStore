<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 15.04.2017
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Registration </title>
</head>
<body>
<p>${requestScope.errors.name}</p>
<form action="${pageContext.request.contextPath}/Registration" method="post">
    <label for="firstName"> ВВЕДИТЕ ИМЯ </label>
    <input type="text" name ="firstName" id="firstName"><br>
    <label for="lastName"> ВВЕДИТЕ ФАМИЛИЮ </label>
    <input type="text" name ="lastName" id="lastName" ><br>
    <label for="email"> ВВЕДИТЕ EMAIL </label>
    <input type="text" name ="email" id="email" ><br>
    <label for="password"> ВВЕДИТЕ ПАРОЛЬ </label>
    <input type="text" name ="password" id="password" ><br>
    <label for="address"> ВВЕДИТЕ АДРЕС </label>
    <input type="text" name ="address" id="address" ><br>
    <label for="phone"> ВВЕДИТЕ ТЕЛЕФОН </label>
    <input type="text" name ="phone" id="phone" ><br>

    <button type="submit"> ЗАРЕГИСТРИРОВАТЬСЯ </button>
</form>

</body>
</html>
