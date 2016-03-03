<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<div id="hitsList">
<c:choose>
    <c:when test="${productHitsList.size() > '0'}">
        <h2>Хиты продаж</h2>
        <c:forEach items="${productHitsList}" var="product">
            <div class="about">
                <a href="/product?id=${product.getID()}">
                    <img class="img" src="images/fotonotfound.png" alt="Product not found"/>
                    <p class="text">
                            ${product.getPname()}
                    </p>
                    <p class="text">Цена: <span>15000</span> руб.</p>
                </a>
            </div>
        </c:forEach>
    </c:when>
</c:choose>
</div>
<div id="recommendedList">
<c:choose>
    <c:when test="${productRecommendedList.size() > '0'}">
        <h2>Наши рекомендации</h2>
        <c:forEach items="${productRecommendedList}" var="product">
            <div class="about">
                <a href="/product?id=${product.getID()}">
                    <img class="img" src="images/fotonotfound.png" alt="Product not found"/>
                    <p class="text">
                            ${product.getPname()}
                    </p>
                    <p class="text">Цена: <span>15000</span> руб.</p>
                </a>
            </div>
        </c:forEach>
    </c:when>
</c:choose>
</div>
<div id="aboutMainPage">
    <h2>Описание интернет магазина</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
        ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
        fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
        mollit anim id est laborum.</p>
</div>