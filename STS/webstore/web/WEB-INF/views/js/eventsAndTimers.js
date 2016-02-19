/**
 * Хелперы: кроссбраузерная обработка событий и объект, координирующий поочерёдную работу таймеров.
 * @author LevSeleznev
 * @version 1.0
 */

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
if (typeof window.addEventListener == "function") {
    utils.addListener = function (el, type, fn) {
        el.addEventListener(type, fn, false);
    }
    utils.removeListener = function (el, type, fn) {
        el.removeEventListener(type, fn, false);
    }
} else if (typeof document.attachEvent == "function") {
    utils.addListener = function (el, type, fn) {
        el.attachEvent("on" + type, fn);
    }
    utils.removeListener = function (el, type, fn) {
        el.detachEvent("on" + type, fn);
    }
} else {
    utils.addListener = function (el, type, fn) {
        el["on" + type] = fn;
    }
    utils.removeListener = function (el, type, fn) {
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
    timeout: 0,
    setTimeout: function (timeout) {
        if (typeof timeout == "number") {
            this.timeout = timeout;
        }
    },
    add: function (fn) {
        this.timers.push(fn);
    },
    start: function () {
        if (this.timerId) {
            return;
        }
        (function runNext() {
            if (timers.timers.length > 0) {
                for (var i = 0; i < timers.timers.length; i += 1) {
                    if (timers.timers[i]() === false) {
                        timers.timers.splice(i, 1);
                        i -= 1;
                    }
                    timers.timerId = setTimeout(runNext, timers.timeout);
                }
            }
        })();
    },
    stop: function () {
        clearTimeout(this.timerId);
        this.timerId = 0;
    }
}
