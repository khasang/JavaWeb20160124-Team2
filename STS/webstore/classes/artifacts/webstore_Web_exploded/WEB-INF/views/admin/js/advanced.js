var _, advancedEditor, authorship, cursorManager,
    descriptionTextArea = document.getElementById("description");

_ = Quill.require('lodash');

advancedEditor = new Quill('.advanced-wrapper .editor-container', {
    modules: {
        'toolbar': {
            container: '.advanced-wrapper .toolbar-container'
        },
        'link-tooltip': true,
        'image-tooltip': true,
        'multi-cursor': true
    },
    styles: false,
    theme: 'snow'
});

cursorManager = advancedEditor.getModule('multi-cursor');

cursorManager.setCursor('basic', 0, 'basic', 'rgba(255,153,51,0.9)');

advancedEditor.on('selection-change', function (range) {
    return console.info('advanced', 'selection', range);
});

advancedEditor.on('text-change', function (delta, source) {
    var html;
    if (source === 'api') {
        return;
    }
    html = advancedEditor.getHTML();
    descriptionTextArea.innerHTML = html;
});
