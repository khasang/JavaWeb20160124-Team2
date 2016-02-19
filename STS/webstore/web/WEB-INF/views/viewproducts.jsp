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
<script type="text/javascript">
var menuButtonEl = document.getElementById("sidebar-toggle"),
        sidebarEl = document.getElementById("sidebar"),
        divContainerEl = document.getElementById("div_container"),
        containerNavEl = document.getElementById("containerNav"),
        sidebarXPositionOpen = 0,
        sidebarXPositionClose = -20,
        menuButtonXLeftPosition = 0,
        menuButtonXRightPosition = 20,
        divContainerXLeftPosition = 0,
        divContainerXRightPosition = 20,
        containerNavXLeftPosition = 0,
        containerNavXRightPosition = 20,
        sidebarX = sidebarXPositionClose,
        sidebarY,
        menuButtonX = menuButtonXLeftPosition,
        menuButtonY,
        divContainerX = divContainerXLeftPosition,
        divContainerY,
        containerNavX = containerNavXLeftPosition,
        containerNavY;

var sidebar = {
    openMenu: function() {
        sidebarEl.style.left = sidebarX + "%";
        sidebarX += 1;
        if(sidebarX >= sidebarXPositionOpen) {
            sidebarX = sidebarXPositionOpen;
            sidebarEl.style.left = sidebarX + "%";
            sidebarEl.classList.add("open");
            sidebarEl.classList.remove("close");
            return false;
        }
    },
    closeMenu: function() {
        sidebarEl.style.left = sidebarX + "%";
        sidebarX -= 1;
        if(sidebarX <= sidebarXPositionClose) {
            sidebarX = sidebarXPositionClose;
            sidebarEl.style.left = sidebarX + "%";
            sidebarEl.classList.add("close");
            sidebarEl.classList.remove("open");
            return false;
        }
    }
};

var menuButton = {
    moveButtonToRight: function() {
        menuButtonEl.style.left = menuButtonX + "%";
        menuButtonX += 1;
        if(menuButtonX >= menuButtonXRightPosition) {
            menuButtonX = menuButtonXRightPosition;
            menuButtonEl.style.left = menuButtonX + "%";
            menuButtonEl.classList.add("inTheRightPosition");
            menuButtonEl.classList.remove("inTheLeftPosition");
            return false;
        }
    },
    moveButtonToLeft: function() {
        menuButtonEl.style.left = menuButtonX + "%";
        menuButtonX -= 1;
        if(menuButtonX <= menuButtonXLeftPosition) {
            menuButtonX = menuButtonXLeftPosition;
            menuButtonEl.style.left = menuButtonX + "%";
            menuButtonEl.classList.add("inTheLeftPosition");
            menuButtonEl.classList.remove("inTheRightPosition");
            return false;
        }
    }
}

var divContainer = {
    moveContainerToRight: function() {
        divContainerEl.style.left = divContainerX + "%";
        divContainerX += 1;
        if(divContainerX >= divContainerXRightPosition) {
            divContainerX = divContainerXRightPosition;
            divContainerEl.style.left = divContainerX + "%";
            divContainerEl.classList.add("inTheRightPosition");
            divContainerEl.classList.remove("inTheLeftPosition");
            return false;
        }
    },
    moveContainerToLeft: function() {
        divContainerEl.style.left = menuButtonX + "%";
        divContainerX -= 1;
        if(divContainerX <= divContainerXLeftPosition) {
            divContainerX = divContainerXLeftPosition;
            divContainerEl.style.left = divContainerX + "%";
            divContainerEl.classList.add("inTheLeftPosition");
            divContainerEl.classList.remove("inTheRightPosition");
            return false;
        }
    }
}

var containerNav = {
    moveContainerToRight: function() {
        containerNavEl.style.left = containerNavX + "%";
        containerNavX += 1;
        if(containerNavX >= containerNavXRightPosition) {
            containerNavX = containerNavXRightPosition;
            containerNavEl.style.left = containerNavX + "%";
            containerNavEl.classList.add("inTheRightPosition");
            containerNavEl.classList.remove("inTheLeftPosition");
            return false;
        }
    },
    moveContainerToLeft: function() {
        containerNavEl.style.left = containerNavX + "%";
        containerNavX -= 1;
        if(containerNavX <= containerNavXLeftPosition) {
            containerNavX = containerNavXLeftPosition;
            containerNavEl.style.left = containerNavX + "%";
            containerNavEl.classList.add("inTheLeftPosition");
            containerNavEl.classList.remove("inTheRightPosition");
            return false;
        }
    }
}

/**
 * При клике по кнопке меню будет вызываться функция, переданная 3-м параметром.
 */
utils.addListener(menuButtonEl, "click", function(event) {
    if(event.preventDefault) {
        event.preventDefault();
    } else {
        event.returnValue = false;
    }

    if(sidebarEl.classList.contains("close") && menuButtonEl.classList.contains("inTheLeftPosition")) {
        timers.stop();
        timers.add(sidebar.openMenu);
        timers.add(menuButton.moveButtonToRight);
        timers.add(divContainer.moveContainerToRight);
        timers.add(containerNav.moveContainerToRight);
    } else if (sidebarEl.classList.contains("open") && menuButtonEl.classList.contains("inTheRightPosition")) {
        timers.stop();
        timers.add(sidebar.closeMenu);
        timers.add(menuButton.moveButtonToLeft);
        timers.add(divContainer.moveContainerToLeft);
        timers.add(containerNav.moveContainerToLeft);
    } else {
        return false;
    }

    timers.setTimeout(100);
    timers.start();
});
</script>
</body>
</html>