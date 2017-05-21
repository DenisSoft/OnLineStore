<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 15.04.2017
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp" %>
<%@ include file="styles-connect.jsp" %>

<nav class="navbar navbar-fixed-top navbar-inverse" bgcolor="#00FF00">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <c:if test="${sessionScope.cart != null}">
                    <p><img src="${pageContext.request.contextPath}resources/images/logo.png" alt=""></p>
                    </c:if>
                    <%--<a><b>--%>
                    <%--<font size=4 color=#ADFF2F>БЕЛИТА</font>--%>
                    <%--<font size=4 color=red>&</font>--%>
                    <%--<font size=4 color=#ADFF2F>ВИТЭКС</font></b></a></li>--%>
                    <c:if test="${sessionScope.admin eq true}">
                <li><a href="/Admin"><fmt:message key="header.admin"/></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><fmt:message key="header.products"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/AllProduct"><fmt:message key="header.allProducts"/></a></li>
                        <li><a href="/CreateProduct"><fmt:message key="header.addProducts"/></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><fmt:message key="header.category"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/AllCategory"><fmt:message key="header.allCategory"/></a></li>
                        <li><a href="/CreateCategory"><fmt:message key="header.createCategory"/></a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.request.contextPath}/AllPerson">
                    <fmt:message key="header.allPerson"/></a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false"><fmt:message key="header.orders"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/AllOrders">
                            <fmt:message key="header.allOrders"/></a></li>
                        <li><a href="${pageContext.request.contextPath}/DeleteOrders">
                            <fmt:message key="header.delete"/></a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${sessionScope.cart != null && sessionScope.admin == null}">
                    <li><a href="/Home"><fmt:message key="header.home"/></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false"><fmt:message key="header.products"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="category" items="${applicationScope['category']}">
                        <li><a href="${pageContext.request.contextPath}/AllProductByCategory?id=${category.id}">
                                ${category.categoryName}</a></li>
                        </c:forEach>
                    </ul>
                    </li>
                    <li><a href="/Cart"><fmt:message key="header.cart"/></a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.cart != null}">
                <li class="active"><a><fmt:message key="header.welcome"/>
                    <c:out value="${sessionScope.cart.person.getName()}"/></a></li>&nbsp;
                </c:if>

                <li class="${sessionScope.currentLanguage == 'ru_RU' ? "active" : ''}">
                    <a href="${pageContext.request.contextPath}/ChangeLanguage?language=ru_RU">Рус</a></li>
                <li class="${sessionScope.currentLanguage == 'en_US' ? "active" : ''}">
                    <a href="${pageContext.request.contextPath}/ChangeLanguage?language=en_US">Eng</a></li>
                <c:if test="${sessionScope.cart != null}">
                    <li><a href="/logout"><fmt:message key="header.exit"/></a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<br/>
<br/>
<br/>
