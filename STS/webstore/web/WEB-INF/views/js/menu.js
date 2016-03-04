/**
 * Отвечает за анимацию бокового меню
 */
ElementFactory.Sidebar = function () {
    this.elem = document.getElementById("sidebar");
    this.xPosition = -20;
    this.xPositionOpen = 0;
    this.xPositionClose = -20;
    this.moveToLeftInterval = 0.1;
    this.moveToRightInterval = 0.1;
};

/**
 * Отвечает за анимацию кнопки открытия меню
 */
ElementFactory.MenuButton = function () {
    this.elem = document.getElementById("sidebar-toggle");
    this.xPosition = 0;
    this.xPositionOpen = 20;
    this.xPositionClose = 0;
    this.moveToLeftInterval = 0.1;
    this.moveToRightInterval = 0.1;
};

/**
 * Отвечает за анимацию контента
 */
ElementFactory.DivContainer = function () {
    this.elem = document.getElementById("div_container");
    this.xPosition = 0;
    this.xPositionOpen = 20;
    this.xPositionClose = 0;
    this.moveToLeftInterval = 0.1;
    this.moveToRightInterval = 0.1;
};

/**
 * Отвечает за анимацию верхнего меню
 */
ElementFactory.ContainerNav = function () {
    this.elem = document.getElementById("containerNav");
    this.xPosition = 0;
    this.xPositionOpen = 20;
    this.xPositionClose = 0;
    this.moveToLeftInterval = 0.1;
    this.moveToRightInterval = 0.1;
};

/**
 * Отвечает за анимацию подвала
 */
ElementFactory.Footer = function() {
    this.elem = document.getElementById("footer_inform");
    this.xPosition = 0;
    this.xPositionOpen = 20;
    this.xPositionClose = 0;
    this.moveToLeftInterval = 0.1;
    this.moveToRightInterval = 0.1;
};

/**
 * Отвечает за анимацию значка корзины
 */
ElementFactory.Cart = function() {
    this.elem = document.getElementById("cart_link");
    this.xPosition = 0;
    this.xPositionOpen = -20;
    this.xPositionClose = 0;
    this.moveToLeftInterval = 0.1;
    this.moveToRightInterval = 0.1;
};

ElementFactory.Cart.prototype.moveToLeft = function () {
    var that = this;
    return function () {
        that.elem.style.right = that.xPosition + "%";
        that.xPosition += that.moveToLeftInterval;
        if (that.xPosition <= that.xPositionClose) {
            that.xPosition = that.xPositionClose;
            that.elem.style.right = that.xPosition + "%";
            that.elem.classList.add("inTheLeftPosition");
            that.elem.classList.remove("inTheRightPosition");
            return false;
        }
    }
};

ElementFactory.Cart.prototype.moveToRight = function () {
    var that = this;
    return function () {
        that.elem.style.right = that.xPosition + "%";
        that.xPosition -= that.moveToRightInterval;
        if (that.xPosition >= that.xPositionOpen) {
            that.xPosition = that.xPositionOpen;
            that.elem.style.right = that.xPosition + "%";
            that.elem.classList.add("inTheRightPosition");
            that.elem.classList.remove("inTheLeftPosition");
            return false;
        }
    }
};

function moveMenu(event) {
    if (event.preventDefault) {
        event.preventDefault();
    } else {
        event.returnValue = false;
    }

    if(timers.getLength() != 0) {
        return false;
    }

    if (sidebar.elem.classList.contains("inTheLeftPosition")
        && menuButton.elem.classList.contains("inTheLeftPosition")
        && divContainer.elem.classList.contains("inTheLeftPosition")
        && containerNav.elem.classList.contains("inTheLeftPosition")
        && cart.elem.classList.contains("inTheLeftPosition")
        && footer.elem.classList.contains("inTheLeftPosition")) {
        timers.stop();
        timers.add(sidebar.moveToRight());
        timers.add(menuButton.moveToRight());
        timers.add(divContainer.moveToRight());
        timers.add(containerNav.moveToRight());
        timers.add(cart.moveToRight());
        timers.add(footer.moveToRight());
    } else if (sidebar.elem.classList.contains("inTheRightPosition")
        && menuButton.elem.classList.contains("inTheRightPosition")
        && divContainer.elem.classList.contains("inTheRightPosition")
        && containerNav.elem.classList.contains("inTheRightPosition")
        && cart.elem.classList.contains("inTheRightPosition")
        && footer.elem.classList.contains("inTheRightPosition")) {
        timers.stop();
        timers.add(sidebar.moveToLeft());
        timers.add(menuButton.moveToLeft());
        timers.add(divContainer.moveToLeft());
        timers.add(containerNav.moveToLeft());
        timers.add(cart.moveToLeft());
        timers.add(footer.moveToLeft());
    } else {
        return false;
    }

    timers.setTimeout(30);
    timers.start();
}

var sidebar = ElementFactory.factory('Sidebar'),
    menuButton = ElementFactory.factory('MenuButton'),
    divContainer = ElementFactory.factory('DivContainer'),
    containerNav = ElementFactory.factory('ContainerNav'),
    footer = ElementFactory.factory('Footer'),
    cart = ElementFactory.factory('Cart'),
    catalogLink = document.getElementById('getCatalog');

utils.addListener(menuButton.elem, "click", function (event) {
    moveMenu(event);
});
utils.addListener(catalogLink, "click", function (event) {
    moveMenu(event);
});