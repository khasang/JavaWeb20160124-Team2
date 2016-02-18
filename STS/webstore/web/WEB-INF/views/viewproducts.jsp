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
    <div id="sidebar" class="close">
        <ul>
            <li><a href="#">Главная</a></li>
            <li><a href="#">Каталог</a></li>
            <li><a href="#">Контакты</a></li>
            <li><a href="#">Товары</a></li>
            <li><a href="#">Выход</a></li>
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
    <div id="div_container">
        <h1>${page_name}</h1>
        <div id="buttons_container">
            <%--<button id="button_logout">Выход</button>--%>
            <%--<button id="button_menu">Меню</button>--%>
        </div>
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
<script type="text/javascript" src="js/clickAndTimer.js"></script>
<script type="text/javascript">
var menuButtonEl = document.getElementById("sidebar-toggle"),
        sidebarEl = document.getElementById("sidebar"),
        sidebarXPositionOpen = 0,
        sidebarXPositionClose = -240,
        menuButtonXRightPosition = 240,
        menuButtonXLeftPosition = 0,
        sidebarX = sidebarXPositionClose,
        sidebarY,
        menuButtonX = menuButtonXLeftPosition,
        menuButtonY;

var sidebar = {
    openMenu: function() {
        sidebarEl.style.left = sidebarX + "px";
        sidebarX += 2;
        if(sidebarX >= sidebarXPositionOpen) {
            sidebarX == sidebarXPositionOpen;
            sidebarEl.style.left = sidebarX + "px";
            sidebarEl.classList.add("open");
            sidebarEl.classList.remove("close");
            return false;
        }
    },
    closeMenu: function() {
        sidebarEl.style.left = sidebarX + "px";
        sidebarX -= 1;
        if(sidebarX <= sidebarXPositionClose) {
            sidebarX = sidebarXPositionClose;
            sidebarEl.style.left = sidebarX + "px";
            sidebarEl.classList.add("close");
            sidebarEl.classList.remove("open");
            return false;
        }
    }
};

var menuButton = {
    moveButtonToRight: function() {
        menuButtonEl.style.left = menuButtonX + "px";
        menuButtonX += 1;
        if(menuButtonX >= menuButtonXRightPosition) {
            menuButtonX = menuButtonXRightPosition;
            menuButtonEl.style.left = menuButtonX + "px";
            menuButtonEl.classList.add("inTheRightPosition");
            menuButtonEl.classList.remove("inTheLeftPosition");
            return false;
        }
    },
    moveButtonToLeft: function() {
        menuButtonEl.style.left = menuButtonX + "px";
        menuButtonX -= 2;
        if(menuButtonX <= menuButtonXLeftPosition) {
            menuButtonX = menuButtonXLeftPosition;
            menuButtonEl.style.left = menuButtonX + "px";
            menuButtonEl.classList.add("inTheLeftPosition");
            menuButtonEl.classList.remove("inTheRightPosition");
            return false;
        }
    }
}

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
    } else if (sidebarEl.classList.contains("open") && menuButtonEl.classList.contains("inTheRightPosition")) {
        timers.stop();
        timers.add(sidebar.closeMenu);
        timers.add(menuButton.moveButtonToLeft);
    } else {
        return false;
    }

    timers.setTimeout(40);
    timers.start();
});
</script>
</body>
</html>