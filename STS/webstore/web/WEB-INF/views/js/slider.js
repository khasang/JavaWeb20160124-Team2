var slider = (function() {
    var index = 0,
        slides = ['slide1', 'slide2', 'slide3', 'slide4', 'slide5'],
        length = slides.length;

    return {
        next: function() {
            var element;
            if(!this.hasNext()) {
                return null;
            }
            element = slides[index];
            index += 1;
            return element;
        },
        hasNext: function() {
            return index < length;
        },
        rewind: function() {
            index = 0;
        },
        current: function() {
            return slides[index];
        }
    }
})();

while(slider.hasNext()) {
    console.log(slider.current());
    slider.next();
}