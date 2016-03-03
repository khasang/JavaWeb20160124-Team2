<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <title>403 ошибка</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/css/style_viewproducts.css"/>
</head>
<body>
<div id="main_container">
    <nav class="nav-bar">
        <div id="containerNav" class="inTheLeftPosition">
            <div class="left-nav"><img id="nav-logo" src="/images/nav-logo.png" alt="WebStore" title="WebStore"/></div>
            <ul class="ul-nav right-nav">
                <li><a href="#">Главная</a></li>
                <li><a href="#">О компании</a></li>
                <li><a href="#">Контакты</a></li>
                <li><a href="#">Выход</a></li>
            </ul>
        </div>
    </nav>
    <div id="sidebar" class="inTheLeftPosition">
        <div class="sidebar_logo_container"><img id="sidebar-logo" src="/images/sidebar-logo.png" alt="WebStore"
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
        <div id="content_container">
            <img src="/images/403.png" />
            <p>Доступ к этой странице запрещён администратором сайта.</p>
            <p>Вы можете вернуться на <a href="/">главную страницу</a>.</p>
        </div>
    </div>
</div>
<footer>
    <div id="footer_inform" class="inTheLeftPosition">
        <div>
            <p>Интернет магазин @2016</p>
            <p>Юр. адрес: 3-я улица Строителей, дом 25, кв. 12</p>
            <p>Телефон: 8 800 8001234</p>
            <p>Отдел продаж: sales@webstore.com</p>
            <p>Техническая поддержка: admin@webstore.com</p>
        </div>
    </div>
</footer>
<script type="text/javascript" src="/js/helpers.js"></script>
<script type="text/javascript" src="/js/menu.js"></script>
</body>
</html>