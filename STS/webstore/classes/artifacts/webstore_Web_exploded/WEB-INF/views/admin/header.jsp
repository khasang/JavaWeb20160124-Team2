<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav class="nav-bar">
    <div id="containerNav">
        <div class="left-nav"><a href="/"><img id="nav-logo" src="/images/sidebar-logo.png" alt="WebStore"
                                               title="WebStore"/></a>
        </div>
        <ul class="ul-nav right-nav">
            <li><a href="/admin">Статистика</a></li>
            <li><a href="/admin/pages">Страницы</a></li>
            <li><a href="/admin/categories">Категории</a></li>
            <li><a href="/admin/products">Товары</a></li>
            <li><a href="/admin/deliveries">Заказы</a></li>
        </ul>
    </div>
</nav>