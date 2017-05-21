<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 17.04.2017
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" class="entity.Person" scope="request">
    <jsp:setProperty name="person" property="*"/>
</jsp:useBean>

<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container" style=width:500px>
      <form action="${pageContext.request.contextPath}/Registration" method="post">
        <table class="table table-condensed">
            <thead>
            <th bgcolor="#99CC99" colspan=2>
                <center>
                <font size=5>РЕГИСТРАЦИЯ</font>
                <br/>
                <font size=1>* Обязательное поле для заполнения</font>
                </center>
            </th>
            </thead>
            <tbody>
            <tr bgcolor="#CCFFCC">
                <td >
                    Имя*
                    <input type="text" name="firstName"
                           value='<%=person.getFirstName()%>' size=23 maxlength=20>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("firstName")%>
                    </font>
                </td>
                <td>
                    Фамилия*
                    <input type="text" name="lastName"
                           value='<%=person.getLastName()%>' size=33 maxlength=20>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("lastName")%>
                    </font>
                </td>
            </tr>
            <tr bgcolor="#CCFFCC">
                <td>
                    E-Mail*

                    <input type="text" name="email" value='<%=person.getEmail()%>'
                           size=23 maxlength=20>
                    <br/>
                    <font size=2 color=red><%=person.getErrorMsg("email")%>
                    </font>
                </td>
                <td>
                    Мобильный телефон*

                    <input type="text" name="phone" value='<%=person.getPhone()%>' size=33
                           maxlength=20>
                    <br/>
                    <font size=2 color=red><%=person.getErrorMsg("phone")%>
                    </font>
                </td>
            </tr>
            <tr bgcolor="#CCFFCC">
                <td colspan=2>
                    Адрес*
                    <input type="text" name="address" value='<%=person.getAddress()%>' size=62 maxlength=40>
                    <br/>
                    <font size=2 color=red><%=person.getErrorMsg("address")%>
                    </font>
                </td>
            </tr>
            <tr bgcolor="#CCFFCC">
                <td >
                    <font size=3px>Пароль*</font>
                    <input type="password" name="password" size=12
                           value='<%=person.getPassword()%>' maxlength=12>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("password")%>
                    </font>
                </td>
                <td valign=top>
                    <font size=3px>Подтвердите пароль*</font>
                    <input type="password" name="password1" size=12
                           value='<%=person.getPassword1()%>' maxlength=12>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("password1")%>
                    </font>
                </td>

            </tr>
            <tr bgcolor="#CCFFCC">
                <td colspan=2 align=center>
                    <input type="submit" value="Сохранить"> <input type="reset" value="Очистить">
                </td>
            </tr>
            </tbody>
        </table>
       </form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
