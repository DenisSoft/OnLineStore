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
<body>
<form action="${pageContext.request.contextPath}/Registration" method="post">
    <center>
        <table cellpadding=4 cellspacing=2 border=0>

            <th bgcolor="#CCCCFF" colspan=2>
                <font size=5>РЕГИСТРАЦИЯ</font>
                <br/>
                <font size=1>* Обязательное поле для заполнения</font>
            </th>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Имя*

                    <input type="text" name="firstName"
                           value='<%=person.getFirstName()%>' size=22 maxlength=22>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("firstName")%>
                    </font>
                </td>
                <td valign=top>
                    Фамилия*

                    <input type="text" name="lastName"
                           value='<%=person.getLastName()%>' size=24 maxlength=24>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("lastName")%>
                    </font>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    E-Mail*

                    <input type="text" name="email" value='<%=person.getEmail()%>'
                           size=20 maxlength=20>
                    <br/>
                    <font size=2 color=red><%=person.getErrorMsg("email")%>
                    </font>
                </td>
                <td valign=top>
                    Мобильный телефон*

                    <input type="text" name="phone" value='<%=person.getPhone()%>' size=13
                           maxlength=20>
                    <br/>
                    <font size=2 color=red><%=person.getErrorMsg("phone")%>
                    </font>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top colspan=2>
                    Адрес*
                    <input type="text" name="address" value='<%=person.getAddress()%>' size=62 maxlength=62>
                    <br/>
                    <font size=2 color=red><%=person.getErrorMsg("address")%>
                    </font>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Пароль*

                    <input type="password" name="password" size=10
                           value='<%=person.getPassword()%>' maxlength=10>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("password")%>
                    </font>
                </td>
                <td valign=top>
                    Подтвердите пароль*

                    <input type="password" name="password1" size=10
                           value='<%=person.getPassword1()%>' maxlength=10>
                    <br/>
                    <font size=2
                          color=red><%=person.getErrorMsg("password1")%>
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
