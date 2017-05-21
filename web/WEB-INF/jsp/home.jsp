<%--
  Created by IntelliJ IDEA.
  User: Dzianis
  Date: 23.04.2017
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="jstl-connect.jsp"%>

<html>
<head>
    <title>Главная</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img src="${pageContext.request.contextPath}resources/images/1.jpg" alt="Black Clean">
                <%--<div class="carousel-caption">--%>
                    <%--<h1>Black Clean</h1>--%>
                    <%--<p>Бамбуковый черный уголь в народе получил название "черный бриллиант"</p>--%>
                <%--</div>--%>
            </div>

            <div class="item">
                <img src="${pageContext.request.contextPath}resources/images/2.jpg" alt="LASER LIKE system">
                <%--<div class="carousel-caption">--%>
                    <%--<h1>LASER LIKE system</h1>--%>
                    <%--<p>Инновационный комплексный подход к уходу за кожей лица!</p>--%>
                <%--</div>--%>
            </div>

            <div class="item">
                <img src="${pageContext.request.contextPath}resources/images/3.jpg" alt="Aqua Active">
                <%--<div class="carousel-caption">--%>
                    <%--<h1>Aqua Active</h1>--%>
                    <%--<p>Увлажнение — первый шаг на пути к здоровой и сияющей коже.!</p>--%>
                <%--</div>--%>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
