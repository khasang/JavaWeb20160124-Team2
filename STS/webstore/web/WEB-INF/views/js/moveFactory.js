/**
 * Анимация бокового меню и элементов страницы при клике на кнопку открытия меню.
 * @author LevSeleznev
 * @version 2.0
 */
function ElementFactory() {
}

/**
 * Сдвигает элементы влево
 * @returns {Function} - функция обратного вызова для сохранения контекста
 */
ElementFactory.prototype.moveToLeft = function () {
    var that = this;
    return function () {
        that.elem.style.left = that.xPosition + "%";
        that.xPosition -= that.moveToLeftInterval;
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
ElementFactory.prototype.moveToRight = function () {
    var that = this;
    return function () {
        that.elem.style.left = that.xPosition + "%";
        that.xPosition += that.moveToRightInterval;
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
ElementFactory.factory = function (type) {
    var constr = type,
        newElement;

    if (typeof ElementFactory[constr] !== "function") {
        throw {
            name: 'Error',
            message: "Construct doesn't function"
        };
    }

    if (typeof ElementFactory[constr].prototype.moveToLeft !== 'function') {
        ElementFactory[constr].prototype.moveToLeft = ElementFactory.prototype.moveToLeft;
    }

    if (typeof ElementFactory[constr].prototype.moveToRight !== 'function') {
        ElementFactory[constr].prototype.moveToRight = ElementFactory.prototype.moveToRight;
    }

    newElement = new ElementFactory[constr]();
    return newElement;
}
