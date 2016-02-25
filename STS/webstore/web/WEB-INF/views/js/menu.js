/**
 * Анимация бокового меню и элементов страницы при клике на кнопку открытия меню.
 * @author LevSeleznev
 * @version 1.0
 */
function ElementFactory() {}

/**
 * Сдвигает элементы влево
 * @returns {Function} - функция обратного вызова для сохранения контекста
 */
ElementFactory.prototype.moveToLeft = function() {
    var that = this;
    return function() {
        that.elem.style.left = that.xPosition + "%";
        that.xPosition -= 1;
        if (that.xPosition <= that.xPositionClose) {
            that.xPosition = that.xPositionClose;
            that.elem.style.left = that.xPosition + "%";
            that.elem.classList.add("inTheLeftPosition");
            that.elem.classList.remove("inTheRightPosition");
            return false;
        }
    }
};

/**
 * Сдвигает элементы вправо
 * @returns {Function} - функция обратного вызова для сохранения контекста
 */
ElementFactory.prototype.moveToRight = function() {
    var that = this;
    return function() {
        that.elem.style.left = that.xPosition + "%";
        that.xPosition += 1;
        if (that.xPosition >= that.xPositionOpen) {
            that.xPosition = that.xPositionOpen;
            that.elem.style.left = that.xPosition + "%";
            that.elem.classList.add("inTheRightPosition");
            that.elem.classList.remove("inTheLeftPosition");
            return false;
        }
    }
};

/**
 * Фабрика, создающая необходимые для анимации элементы
 * @param type - тип элемента
 * @returns {*} - возвращает созданный элемент указанного типа, который унаследовал необходимы методы фабрики
 */
ElementFactory.factory = function(type) {
    var constr = type,
        newElement;

    if(typeof ElementFactory[constr] !== "function") {
        throw {
            name: 'Error',
            message: "Construct doesn't function"
        };
    }

    if(typeof ElementFactory[constr].prototype.moveToLeft !== 'function') {
        ElementFactory[constr].prototype.moveToLeft = ElementFactory.prototype.moveToLeft;
    }

    if(typeof ElementFactory[constr].prototype.moveToRight !== 'function') {
        ElementFactory[constr].prototype.moveToRight = ElementFactory.prototype.moveToRight;
    }

    newElement = new ElementFactory[constr]();
    return newElement;
}

/**
 * Отвечает за анимацию бокового меню
 */
ElementFactory.Sidebar = function() {
    this.elem = document.getElementById("sidebar");
    this.xPosition = -20;
    this.xPositionOpen = 0;
    this.xPositionClose = -20;
};

/**
 * Отвечает за анимацию кнопки открытия меню
 */
ElementFactory.MenuButton = function() {
    this.elem = document.getElementById("sidebar-toggle");
    this.xPosition = 0;
    this.xPositionOpen = 20;
    this.xPositionClose = 0;
};

/**
 * Отвечает за анимацию контента
 */
ElementFactory.DivContainer = function() {
    this.elem = document.getElementById("div_container");
    this.xPosition = 0;
    this.xPositionOpen = 20;
    this.xPositionClose = 0;
};

/**
 * Отвечает за анимацию верхнего меню
 */
ElementFactory.ContainerNav = function() {
    this.elem = document.getElementById("containerNav");
    this.xPosition = 0;
    this.xPositionOpen = 20;
    this.xPositionClose = 0;
};

var sidebar = ElementFactory.factory('Sidebar'),
    menuButton = ElementFactory.factory('MenuButton'),
    divContainer = ElementFactory.factory('DivContainer'),
    containerNav = ElementFactory.factory('ContainerNav');

utils.addListener(menuButton.elem, "click", function (event) {
    if (event.preventDefault) {
        event.preventDefault();
    } else {
        event.returnValue = false;
    }

    if (sidebar.elem.classList.contains("inTheLeftPosition") && menuButton.elem.classList.contains("inTheLeftPosition")) {
        timers.stop();
        timers.add(sidebar.moveToRight());
        timers.add(menuButton.moveToRight());
        timers.add(divContainer.moveToRight());
        timers.add(containerNav.moveToRight());
    } else if (sidebar.elem.classList.contains("inTheRightPosition") && menuButton.elem.classList.contains("inTheRightPosition")) {
        timers.stop();
        timers.add(sidebar.moveToLeft());
        timers.add(menuButton.moveToLeft());
        timers.add(divContainer.moveToLeft());
        timers.add(containerNav.moveToLeft());
    } else {
        return false;
    }

    timers.setTimeout(100);
    timers.start();
});