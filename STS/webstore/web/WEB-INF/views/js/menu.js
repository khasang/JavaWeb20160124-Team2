/**
 * Анимация бокового меню и элементов страницы при клике на кнопку открытия меню. Пока без возможности
 * клиентской настройки.
 * @author LevSeleznev
 * @version 1.0
 */
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

/**
 * Отвечает за анимацию бокового меню
 * @type {{openMenu: sidebar.openMenu, closeMenu: sidebar.closeMenu}}
 */
var sidebar = {
    openMenu: function () {
        sidebarEl.style.left = sidebarX + "%";
        sidebarX += 1;
        if (sidebarX >= sidebarXPositionOpen) {
            sidebarX = sidebarXPositionOpen;
            sidebarEl.style.left = sidebarX + "%";
            sidebarEl.classList.add("open");
            sidebarEl.classList.remove("close");
            return false;
        }
    },
    closeMenu: function () {
        sidebarEl.style.left = sidebarX + "%";
        sidebarX -= 1;
        if (sidebarX <= sidebarXPositionClose) {
            sidebarX = sidebarXPositionClose;
            sidebarEl.style.left = sidebarX + "%";
            sidebarEl.classList.add("close");
            sidebarEl.classList.remove("open");
            return false;
        }
    }
};

/**
 * Отвечает за анимацию кнопки открытия меню
 * @type {{moveButtonToRight: menuButton.moveButtonToRight, moveButtonToLeft: menuButton.moveButtonToLeft}}
 */
var menuButton = {
    moveButtonToRight: function () {
        menuButtonEl.style.left = menuButtonX + "%";
        menuButtonX += 1;
        if (menuButtonX >= menuButtonXRightPosition) {
            menuButtonX = menuButtonXRightPosition;
            menuButtonEl.style.left = menuButtonX + "%";
            menuButtonEl.classList.add("inTheRightPosition");
            menuButtonEl.classList.remove("inTheLeftPosition");
            return false;
        }
    },
    moveButtonToLeft: function () {
        menuButtonEl.style.left = menuButtonX + "%";
        menuButtonX -= 1;
        if (menuButtonX <= menuButtonXLeftPosition) {
            menuButtonX = menuButtonXLeftPosition;
            menuButtonEl.style.left = menuButtonX + "%";
            menuButtonEl.classList.add("inTheLeftPosition");
            menuButtonEl.classList.remove("inTheRightPosition");
            return false;
        }
    }
}

/**
 * Отвечает за анимацию контента
 * @type {{moveContainerToRight: divContainer.moveContainerToRight, moveContainerToLeft: divContainer.moveContainerToLeft}}
 */
var divContainer = {
    moveContainerToRight: function () {
        divContainerEl.style.left = divContainerX + "%";
        divContainerX += 1;
        if (divContainerX >= divContainerXRightPosition) {
            divContainerX = divContainerXRightPosition;
            divContainerEl.style.left = divContainerX + "%";
            divContainerEl.classList.add("inTheRightPosition");
            divContainerEl.classList.remove("inTheLeftPosition");
            return false;
        }
    },
    moveContainerToLeft: function () {
        divContainerEl.style.left = menuButtonX + "%";
        divContainerX -= 1;
        if (divContainerX <= divContainerXLeftPosition) {
            divContainerX = divContainerXLeftPosition;
            divContainerEl.style.left = divContainerX + "%";
            divContainerEl.classList.add("inTheLeftPosition");
            divContainerEl.classList.remove("inTheRightPosition");
            return false;
        }
    }
}

/**
 * Отвечает за анимацию верхнего меню
 * @type {{moveContainerToRight: containerNav.moveContainerToRight, moveContainerToLeft: containerNav.moveContainerToLeft}}
 */
var containerNav = {
    moveContainerToRight: function () {
        containerNavEl.style.left = containerNavX + "%";
        containerNavX += 1;
        if (containerNavX >= containerNavXRightPosition) {
            containerNavX = containerNavXRightPosition;
            containerNavEl.style.left = containerNavX + "%";
            containerNavEl.classList.add("inTheRightPosition");
            containerNavEl.classList.remove("inTheLeftPosition");
            return false;
        }
    },
    moveContainerToLeft: function () {
        containerNavEl.style.left = containerNavX + "%";
        containerNavX -= 1;
        if (containerNavX <= containerNavXLeftPosition) {
            containerNavX = containerNavXLeftPosition;
            containerNavEl.style.left = containerNavX + "%";
            containerNavEl.classList.add("inTheLeftPosition");
            containerNavEl.classList.remove("inTheRightPosition");
            return false;
        }
    }
}

/**
 * При клике по кнопке меню будет вызываться функция, переданная 3-м параметром, и воспроизводить анимацию
 * с помощью таймеров.
 */
utils.addListener(menuButtonEl, "click", function (event) {
    if (event.preventDefault) {
        event.preventDefault();
    } else {
        event.returnValue = false;
    }

    if (sidebarEl.classList.contains("close") && menuButtonEl.classList.contains("inTheLeftPosition")) {
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