<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 22.04.2017
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jstl-connect.jsp" %>
<jsp:useBean id="person" class="entity.Person" scope="request">
    <jsp:setProperty name="person" property="*"/>
</jsp:useBean>

<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container" style="width:350px;">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table class="table table-condensed" cellpadding=2 cellspacing=1 border=0>
            <thead>
            <th bgcolor="#99CC99" colspan=2>
                <center> <font size=5><fmt:message key="login.entrance"/></font></center>
            </th>
            </thead>
            <tr bgcolor="#CCFFCC">
                <td valign=top colspan=1>
                    E-Mail:
                </td>
                <td valign=top colspan=1>
                    <input type="text" name="email" value='<%=person.getEmail()%>'
                           size=20 maxlength=20>
                    <font size=2 color=red><%=person.getErrorMsg("email")%></font>
                </td>
            </tr>
            <tr bgcolor="CCFFCC">
                <td valign=top colspan=1>
                    <fmt:message key="login.password"/>
                </td>
                <td valign=top colspan=1>
                    <input type="password" name="password" size=20
                           value='<%=person.getPassword()%>' maxlength=20>
                    <br/>
                    <font size=2 color=red><%=person.getErrorMsg("password")%></font>
                </td>
            </tr>

            <tr bgcolor="#CCFFCC">
                <td valign=top colspan=2>
                    <a href="${pageContext.request.contextPath}/Registration">
                        <fmt:message key="login.registration"/>
                    </a>
                </td>
            </tr>

            <tr bgcolor="#CCFFCC">
                <td colspan=2 align=center>
                    <input type="submit" value="<fmt:message key="login.submit"/>">
                    <input type="reset" value="<fmt:message key="login.reset"/>">
                </td>
            </tr>
        </table>
    </form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
