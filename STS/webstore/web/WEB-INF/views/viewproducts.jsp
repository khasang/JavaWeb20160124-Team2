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
<div id="main_container">
    <nav class="nav-bar">
        <div id="containerNav" class="inTheLeftPosition">
            <div class="left-nav"><img id="nav-logo" src="css/nav-logo.png" alt="WebStore" title="WebStore"/></div>
            <ul class="ul-nav right-nav">
                <li><a href="#">Главная</a></li>
                <li><a href="#">О компании</a></li>
                <li><a href="#">Контакты</a></li>
                <li><a href="#">Выход</a></li>
            </ul>
        </div>
    </nav>
    <div id="sidebar" class="inTheLeftPosition">
        <div class="sidebar_logo_container"><img id="sidebar-logo" src="css/sidebar-logo.png" alt="WebStore"
                                                 title="WebStore"/></div>
        <ul>
            <li><a href="#">Магнитофоны</a></li>
            <li><a href="#">Велосипеды</a></li>
            <li><a href="#">Лекарства</a></li>
            <li><a href="#">Продукты</a></li>
            <li><a href="#">Компьютеры</a></li>
        </ul>
        <div class="sidebar_content">
            <p>Телефон: 88008001234</p>
            <p>Отдел продаж: sales@webstore.com</p>
            <p>Техническая поддержка: admin@webstore.com</p>
        </div>
    </div>
    <div class="menu_open_container">
        <div class="swipe-area"></div>
        <a href="#" data-toggle=".container" id="sidebar-toggle" class="inTheLeftPosition">
            <span class="bar"></span>
            <span class="bar"></span>
            <span class="bar"></span>
        </a>
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
                    <c:forEach items="${viewproducts}" var="productorder">
                        <tr>
                            <td><c:out value="${productorder.ID}"/></td>
                            <td><img style="width:100px" alt="Фото товара отсутствует" src="css/fotonotfound.png"/></td>
                            <td><c:out value="${productorder.pname}"/></td>
                            <td><c:out value="${productorder.productorder}"/></td>
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