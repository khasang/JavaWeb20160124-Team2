var slider = (function () {
    var index = 0,
        slides = [0, 100, 200, 300, 400],
        length = slides.length,
        sliderNav = document.getElementById('slider_nav'),
        sliderNavElements = sliderNav.getElementsByTagName('span');

    return {
        next: function () {
            var element;
            if (!this.hasNext()) {
                return null;
            }
            element = slides[index];
            sliderNavElements[index].classList.remove('current_nav_button');
            index += 1;
            return element;
        },
        prev: function () {
            var element;
            if (!this.hasPrev()) {
                return null;
            }
            element = slides[index];
            sliderNavElements[index].classList.remove('current_nav_button');
            index -= 1;
            return element;
        },
        hasNext: function () {
            return index + 1 < length;
        },
        hasPrev: function () {
            return index > 0;
        },
        rewind: function () {
            sliderNavElements[index].classList.remove('current_nav_button');
            index = 0;
        },
        last: function () {
            sliderNavElements[index].classList.remove('current_nav_button');
            index = length - 1;
        },
        current: function () {
            sliderNavElements[index].classList.add('current_nav_button');
            return slides[index];
        }
    }
})();

ElementFactory.Slider = function () {
    this.elem = document.getElementById("img_container");
    this.right = 0;
    this.moveToLeftInterval = 5;
    this.moveToRightInterval = 5;
};

ElementFactory.Slider.prototype.moveToLeft = function (finishRight) {
    var that = this,
        finish = finishRight;
    return function () {
        that.elem.style.right = that.right + "%";
        that.right -= that.moveToLeftInterval;
        if (that.right <= finish) {
            that.right = finish;
            that.elem.style.right = that.right + "%";
            return false;
        }
    }
};

ElementFactory.Slider.prototype.moveToRight = function (finishRight) {
    var that = this,
        finish = finishRight;
    return function () {
        that.elem.style.right = that.right + "%";
        that.right += that.moveToRightInterval;
        if (that.right >= finish) {
            that.right = finish;
            that.elem.style.right = that.right + "%";
            return false;
        }
    }
};

var sliderContainer = ElementFactory.factory('Slider'),
    buttonPrev = document.getElementById("sliderPrev"),
    buttonNext = document.getElementById("sliderNext");

utils.addListener(buttonPrev, "click", function (event) {
    if (event.preventDefault) {
        event.preventDefault();
    } else {
        event.returnValue = false;
    }

    if(timers.getLength() == 0) {
        timers.stop();
        if (slider.hasPrev()) {
            slider.prev();
            timers.add(sliderContainer.moveToLeft(slider.current()));
        } else {
            slider.last();
            timers.add(sliderContainer.moveToRight(slider.current()));
        }
        timers.start();
    }
});

utils.addListener(buttonNext, "click", function (event) {
    if (event.preventDefault) {
        event.preventDefault();
    } else {
        event.returnValue = false;
    }

    if(timers.getLength() == 0) {
        timers.stop();
        if (slider.hasNext()) {
            slider.next();
            timers.add(sliderContainer.moveToRight(slider.current()));
        } else {
            slider.rewind();
            timers.add(sliderContainer.moveToLeft(slider.current()));
        }
        timers.start();
    }
});

