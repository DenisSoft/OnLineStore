<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 25.04.2017
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>
<html>
<body>
<%@include file="header.jsp"%>
<br/>
<div class="container" style=width:500px>
    <table class="table table-condensed">
        <thead >
        <tr bgcolor="#99CC99" align=center>
            <td >
                <strong>#</strong>
            </td>
            <td>
                <strong><center>НАИМЕНОВАНИЕ</center></strong>
            </td>
            <td >
            </td>
        </tr>
        </thead>
        <c:forEach var="сategory" begin="1" items="${requestScope.сategory}">
            <tr bgcolor="#CCFFCC">
                <td valign=top style="width: 70px;">
                    <center>  ${сategory.id}</center>
                </td>
                <td valign=top>
                    ${сategory.categoryName}
                </td>
                <td valign=top>
                   <a href="${pageContext.request.contextPath}/DeleteCategory?id=${сategory.id}">
                       <button class="btn-small btn-danger" type="button"><font size=2>Удалить</font></button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file="footer.jsp"%>
</body>
</html>

