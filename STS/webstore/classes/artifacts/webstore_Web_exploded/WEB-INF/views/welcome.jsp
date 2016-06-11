<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<div id="slider">
    <div id="img_container">
        <img class="slider_img" src="images/slider1.png"/>
        <img class="slider_img" src="images/slider2.png"/>
        <img class="slider_img" src="images/slider3.png"/>
        <img class="slider_img" src="images/slider4.png"/>
        <img class="slider_img" src="images/slider5.png"/>
    </div>
    <span id="slider_nav">
        <span data-value="0" class="navButton current_nav_button"></span>
        <span data-value="1" class="navButton"></span>
        <span data-value="2" class="navButton"></span>
        <span data-value="3" class="navButton"></span>
        <span data-value="4" class="navButton"></span>
    </span>
    <div id="navButtonContainer">
        <a id="sliderPrev"></a>
        <a id="sliderNext"></a>
    </div>
</div>
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
                        <p class="text">Цена: <span>${product.getCost()}</span> руб.</p>
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
                        <p class="text">Цена: <span>${product.getCost()}</span> руб.</p>
                    </a>
                </div>
            </c:forEach>
        </c:when>
    </c:choose>
</div>
<div id="aboutMainPage">
    <h2>Описание интернет-магазина</h2>
    <p>Интернет-магазин книг WebBookStore создан командой разрабочиков и является open source проектом
       на платформе JavaEE. Код проекта находится в репозитории <a href="https://github.com/khasang/JavaWeb20160124-Team2" target="_blank">github.com</a></p>
</div>