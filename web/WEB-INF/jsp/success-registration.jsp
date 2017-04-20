<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 17.04.2017
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" class="entity.Person" scope="request"/>

<html>
<body>
<center>
    <table cellpadding=4 cellspacing=2 border=0>

        <th bgcolor="#CCCCFF" colspan=2>
            <font size=5>ВЫ УСПЕШНО ЗАРЕГИСТРИРОВАЛИСЬ!</font>
            <br />
            <font size=2>Регистрационный номер № <%=person.getId()%></font>

        </th>

        <font size=4>
            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    Имя:
                    <br />
                    <jsp:getProperty name="person" property="firstName"/>
                </td>
                <td valign=top>
                    Фамилия:
                    <br />
                    <jsp:getProperty name="person" property="lastName"/>
                </td>
            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top>
                    E-Mail:
                    <br />
                    <jsp:getProperty name="person" property="email"/>
                </td>
                <td valign=top>
                    Мобильный телефон:
                    <br />
                    <jsp:getProperty name="person" property="phone"/>
                </td>

            </tr>

            <tr bgcolor="#c8d8f8">
                <td valign=top colspan=2>
                    Адрес:
                    <br />
                    <jsp:getProperty name="person" property="address"/>
                </td>
            </tr>


            <tr bgcolor="#c8d8f8">

            </tr>

        </font>
    </table>
</center>
</body>
</html>
