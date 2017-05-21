<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 17.04.2017
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>
<jsp:useBean id="person" class="entity.Person" scope="request"/>

<html>
<body>
<%@include file="header.jsp" %>
<br/>
<div class="container" style=width:500px>
    <table class="table table-condensed">
        <thead>
        <th bgcolor="#99CC99" colspan=2>
            <center>
                <font size=4>ВЫ УСПЕШНО ЗАРЕГИСТРИРОВАЛИСЬ!</font>
                <br/>
                <font size=2>Регистрационный номер № <%=person.getId()%>
                </font>
            </center>
        </th>
        </thead>
        <font size=4>
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    Имя:
                    <br/>
                    <jsp:getProperty name="person" property="firstName"/>
                </td>
                <td valign=top>
                    Фамилия:
                    <br/>
                    <jsp:getProperty name="person" property="lastName"/>
                </td>
            </tr>

            <tr bgcolor="#CCFFCC">
                <td valign=top>
                    E-Mail:
                    <br/>
                    <jsp:getProperty name="person" property="email"/>
                </td>
                <td valign=top>
                    Мобильный телефон:
                    <br/>
                    <jsp:getProperty name="person" property="phone"/>
                </td>

            </tr>

            <tr bgcolor="#CCFFCC">
                <td valign=top colspan=2>
                    Адрес:
                    <br/>
                    <jsp:getProperty name="person" property="address"/>
                </td>
            </tr>
            <tr bgcolor="#CCFFCC">
                <td colspan=2 align=center>
                    <%
                        session.setAttribute("userId", person.getId());
                        session.setAttribute("userName", person.getName());
                    %>
                    <input type="button" onclick="window.location='Home'" value="Войти">
                </td>
            </tr>
        </font>
    </table>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
