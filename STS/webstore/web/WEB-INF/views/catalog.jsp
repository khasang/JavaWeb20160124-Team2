<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<div>
    <c:choose>
        <c:when test="${productsList.size() > '0'}">
            <c:forEach items="${productsList}" var="product">
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
        <c:otherwise>
            <p>В каталоге на данный момент нет товаров. <a href="/">Главная страница</a></p>
        </c:otherwise>
    </c:choose>
    <br>
    <h2>Описание каталога</h2>
    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
        ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
        fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
        mollit anim id est laborum.</p>
</div>
