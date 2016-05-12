<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="nav-bar">
    <div id="containerNav" class="inTheLeftPosition">
        <div class="left-nav"><a href="/"><img id="nav-logo" src="images/nav-logo.png" alt="WebStore" title="WebStore"/></a>
        </div>
        <ul class="ul-nav right-nav">
            <li><a href="/">Главная</a></li>
            <li><a href="/about">О компании</a></li>
            <li><a href="/contacts">Контакты</a></li>
            <li><a id="getCatalog" href="/catalog">Товары</a></li>
            <sec:authorize access="isAuthenticated()">
                <sec:authorize access="hasRole('USER')">
                    <sec:authorize access="!hasRole('ADMIN')">
                        <li><a href="/account">Личный кабинет</a></li>
                    </sec:authorize>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="/admin">Панель администратора</a></li>
                </sec:authorize>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a href="/login">Вход</a></li>
            </sec:authorize>
        </ul>
    </div>
</nav>
<div id="sidebar" class="inTheLeftPosition">
    <div class="sidebar_logo_container"><a href="/"><img id="sidebar-logo" src="images/sidebar-logo.png" alt="WebStore"
                                                         title="WebStore"/></a></div>
    <ul>
        <li><a href="/catalog?id=1">Books</a></li>
        <li><a href="/catalog?id=2">Велосипеды</a></li>
        <li><a href="/catalog?id=3">Лекарства</a></li>
        <li><a href="/catalog?id=4">Продукты</a></li>
        <li><a href="/catalog?id=5">Компьютеры</a></li>
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
    <a href="/cart" id="cart_link" class="inTheLeftPosition">
        <img src="/images/cart.png"/>
    </a>
</div>