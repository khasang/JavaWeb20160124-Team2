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
    <div id="sidebar">
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
            <a href="#" data-toggle=".container" id="sidebar-toggle">
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
<script type="text/javascript">
    window.onload = function () {
        /**
         * Через этот объект кроссбраузерно добавляем события к элементам
         */
        var utils = {
            addListener: null,
            removeListener: null
        };

        /**
         * Добавление события к элементу
         * addEventListener - новые броузеры
         * attachEvent - IE
         * остальные - совсем устаревшие
         */
        if(typeof window.addEventListener == "function") {
            utils.addListener = function(el, type, fn) {
                el.addEventListener(type, fn, false);
            }
            utils.removeListener = function(el, type, fn) {
                el.removeEventListener(type, fn, false);
            }
        } else if(typeof document.attachEvent == "function") {
            utils.addListener = function(el, type, fn) {
                el.attachEvent("on" + type, fn);
            }
            utils.removeListener = function(el, type, fn) {
                el.detachEvent("on" + type, fn);
            }
        } else {
            utils.addListener = function(el, type, fn) {
                el["on" + type] = fn;
            }
            utils.removeListener = function(el, type, fn) {
                el["on" + type] = null;
            }
        }

        /**
         * Объект учитывает работу таймеров
         * @type {{timerId: number, timers: Array, add: timers.add, start: timers.start, stop: timers.stop}}
         */
        var timers = {
            timerId: 0,
            timers: [],
            add: function(fn) {
                this.timers.push(fn);
            },
            start: function() {
                if(this.timerId) {
                    return;
                }
                (function runNext() {
                    if(timers.timers.length > 0) {
                        for(var i = 0; i < timers.timers.length; i += 1) {
                            if(timers.timers[i]() === false) {
                                timers.timers.splice(i, 1);
                                i -= 1;
                            }
                            timers.timerId = setTimeout(runNext, 0);
                        }
                    }
                })();
            },
            stop: function() {
                clearTimeout(this.timerId);
                this.timerId = 0;
            }
        }

        var menuButton = document.getElementById("sidebar-toggle"),
                sidebar = document.getElementById("sidebar"),
                CLOSE = -240,
                OPEN = 0,
                INTERVAL = 10,
                menuLeft = CLOSE;
        /**
         * Устанавливает таймер для открытия или закрытия меню
         */
        function setTimers() {
            if(timers.timers.length == 0) {
                timers.stop();
            }
            if (menuLeft == CLOSE) {
                timers.add(function () {
                    sidebar.style.left = menuLeft + "px";
                    menuLeft += INTERVAL;
                    if (menuLeft >= OPEN) {
                        menuLeft = OPEN;
                        sidebar.style.left = menuLeft + "px";
                        return false;
                    }
                });
            } else if(menuLeft == OPEN) {
                timers.add(function () {
                    sidebar.style.left = menuLeft + "px";
                    menuLeft -= INTERVAL;
                    if (menuLeft <= CLOSE) {
                        menuLeft = CLOSE;
                        sidebar.style.left = menuLeft + "px";
                        return false;
                    }
                });
            }
            timers.start();
        }

        utils.addListener(menuButton, "click", setTimers);
    }
</script>
</body>
</html>