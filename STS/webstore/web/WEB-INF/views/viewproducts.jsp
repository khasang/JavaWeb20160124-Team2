<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>${page_name}</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <link rel="stylesheet" type="text/css" href="css/style_viewproducts.css"/>
</head>
<body>
<div class="container">
    <nav class="nav-bar">
        <div id="containerNav" class="inTheLeftPosition">
            <div class="left-nav"></div>
            <ul class="ul-nav right-nav">
                <li><a href="#">Главная</a></li>
                <li><a href="#">О Компании</a></li>
                <li><a href="#">Контакты</a></li>
                <li><a href="#">Выход</a></li>
            </ul>
        </div>
    </nav>
    <div id="sidebar" class="close">
        <ul>
            <li><a href="#">Магнитофоны</a></li>
            <li><a href="#">Велосипеды</a></li>
            <li><a href="#">Лекарства</a></li>
            <li><a href="#">Продукты</a></li>
            <li><a href="#">Компьютеры</a></li>
        </ul>
    </div>
    <div class="main-content">
        <div class="swipe-area"></div>
            <a href="#" data-toggle=".container" id="sidebar-toggle" class="inTheLeftPosition">
                <span class="bar"></span>
                <span class="bar"></span>
                <span class="bar"></span>
            </a>
        <div class="content">
            <!-- Произвольный текст -->
        </div>
    </div>
    <div id="div_container" class="inTheLeftPosition">
        <h1>${page_name}</h1>
        <c:choose>
            <c:when test="${viewproducts.size() > '0'}">
                <table id="cart_table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>image</th>
                        <th>name</th>
                        <th>description</th>
                        <th>cost</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${viewproducts}" var="product">
                        <tr>
                            <td><c:out value="${product.ID}"/></td>
                            <td><img style="width:100px" alt="Фото товара отсутствует" src="css/fotonotfound.png" /></td>
                            <td><c:out value="${product.pname}"/></td>
                            <td><c:out value="${product.product}"/></td>
                            <td>100</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>В базе отсутствуют товары. <a href="/insertdata">Загрузить товары</a></p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<script type="text/javascript" src="js/eventsAndTimers.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</body>
</html>