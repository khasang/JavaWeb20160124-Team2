<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<form id="login_form" method="post">
    <div class="form_element">
        <label for="menu_name" class="label">Название в меню</label>
        <br/>
        <input class="input input_up" type="text" name="menu_name" id="menu_name" placeholder="Menu name"/>
        <span id="menu_name_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="h1" class="label">Заголовок h1</label>
        <br/>
        <input class="input input_up" type="password" name="h1" id="h1" placeholder="H1"/>
        <span id="h1_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="title" class="label">Заголовок title</label>
        <br/>
        <input class="input input_up" type="text" name="title" id="title" placeholder="Title"/>
        <span id="title_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="meta_keywords" class="label">Meta keywords</label>
        <br/>
        <textarea class="input input_up" name="meta_keywords" id="meta_keywords" placeholder="Meta Keywords"></textarea>
        <span id="meta_keywords_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="meta_description" class="label">Meta description</label>
        <br/>
        <textarea class="input input_up" name="meta_description" id="meta_description"
                  placeholder="Meta description"></textarea>
        <span id="meta_description_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="meta_description" class="label">Категория</label>
        <br/>

    </div>
    <div class="form_element">
        <label for="meta_description" class="label">Цвет</label>
        <br/>

    </div>
    <div class="form_element">
        <label for="meta_description" class="label">Описание</label>
        <br/>
        <div id="content-container">
            <textarea class="input input_up" style="display:none" name="description" id="description"
                      placeholder="Description"></textarea>
            <div class="advanced-wrapper">
                <div class="toolbar-container"><span class="ql-format-group">
            <select title="Font" class="ql-font">
                <option value="sans-serif" selected>Sans Serif</option>
                <option value="Georgia, serif">Serif</option>
                <option value="Monaco, 'Courier New', monospace">Monospace</option>
            </select>
            <select title="Size" class="ql-size">
                <option value="10px">Small</option>
                <option value="13px" selected>Normal</option>
                <option value="18px">Large</option>
                <option value="32px">Huge</option>
            </select></span><span class="ql-format-group"><span title="Bold"
                                                                class="ql-format-button ql-bold"></span><span
                        class="ql-format-separator"></span><span title="Italic"
                                                                 class="ql-format-button ql-italic"></span><span
                        class="ql-format-separator"></span><span title="Underline"
                                                                 class="ql-format-button ql-underline"></span></span><span
                        class="ql-format-group">
            <select title="Text Color" class="ql-color">
                <option value="rgb(0, 0, 0)" selected></option>
                <option value="rgb(230, 0, 0)"></option>
                <option value="rgb(255, 153, 0)"></option>
                <option value="rgb(255, 255, 0)"></option>
                <option value="rgb(0, 138, 0)"></option>
                <option value="rgb(0, 102, 204)"></option>
                <option value="rgb(153, 51, 255)"></option>
                <option value="rgb(255, 255, 255)"></option>
                <option value="rgb(250, 204, 204)"></option>
                <option value="rgb(255, 235, 204)"></option>
                <option value="rgb(255, 255, 204)"></option>
                <option value="rgb(204, 232, 204)"></option>
                <option value="rgb(204, 224, 245)"></option>
                <option value="rgb(235, 214, 255)"></option>
                <option value="rgb(187, 187, 187)"></option>
                <option value="rgb(240, 102, 102)"></option>
                <option value="rgb(255, 194, 102)"></option>
                <option value="rgb(255, 255, 102)"></option>
                <option value="rgb(102, 185, 102)"></option>
                <option value="rgb(102, 163, 224)"></option>
                <option value="rgb(194, 133, 255)"></option>
                <option value="rgb(136, 136, 136)"></option>
                <option value="rgb(161, 0, 0)"></option>
                <option value="rgb(178, 107, 0)"></option>
                <option value="rgb(178, 178, 0)"></option>
                <option value="rgb(0, 97, 0)"></option>
                <option value="rgb(0, 71, 178)"></option>
                <option value="rgb(107, 36, 178)"></option>
                <option value="rgb(68, 68, 68)"></option>
                <option value="rgb(92, 0, 0)"></option>
                <option value="rgb(102, 61, 0)"></option>
                <option value="rgb(102, 102, 0)"></option>
                <option value="rgb(0, 55, 0)"></option>
                <option value="rgb(0, 41, 102)"></option>
                <option value="rgb(61, 20, 102)"></option>
            </select><span class="ql-format-separator"></span>
            <select title="Background Color" class="ql-background">
                <option value="rgb(0, 0, 0)"></option>
                <option value="rgb(230, 0, 0)"></option>
                <option value="rgb(255, 153, 0)"></option>
                <option value="rgb(255, 255, 0)"></option>
                <option value="rgb(0, 138, 0)"></option>
                <option value="rgb(0, 102, 204)"></option>
                <option value="rgb(153, 51, 255)"></option>
                <option value="rgb(255, 255, 255)" selected></option>
                <option value="rgb(250, 204, 204)"></option>
                <option value="rgb(255, 235, 204)"></option>
                <option value="rgb(255, 255, 204)"></option>
                <option value="rgb(204, 232, 204)"></option>
                <option value="rgb(204, 224, 245)"></option>
                <option value="rgb(235, 214, 255)"></option>
                <option value="rgb(187, 187, 187)"></option>
                <option value="rgb(240, 102, 102)"></option>
                <option value="rgb(255, 194, 102)"></option>
                <option value="rgb(255, 255, 102)"></option>
                <option value="rgb(102, 185, 102)"></option>
                <option value="rgb(102, 163, 224)"></option>
                <option value="rgb(194, 133, 255)"></option>
                <option value="rgb(136, 136, 136)"></option>
                <option value="rgb(161, 0, 0)"></option>
                <option value="rgb(178, 107, 0)"></option>
                <option value="rgb(178, 178, 0)"></option>
                <option value="rgb(0, 97, 0)"></option>
                <option value="rgb(0, 71, 178)"></option>
                <option value="rgb(107, 36, 178)"></option>
                <option value="rgb(68, 68, 68)"></option>
                <option value="rgb(92, 0, 0)"></option>
                <option value="rgb(102, 61, 0)"></option>
                <option value="rgb(102, 102, 0)"></option>
                <option value="rgb(0, 55, 0)"></option>
                <option value="rgb(0, 41, 102)"></option>
                <option value="rgb(61, 20, 102)"></option>
            </select><span class="ql-format-separator"></span>
            <select title="Text Alignment" class="ql-align">
                <option value="left" selected></option>
                <option value="center"></option>
                <option value="right"></option>
                <option value="justify"></option>
            </select></span><span class="ql-format-group"><span title="Link"
                                                                class="ql-format-button ql-link"></span><span
                        class="ql-format-separator"></span><span title="Image" class="ql-format-button ql-image"></span><span
                        class="ql-format-separator"></span><span title="List"
                                                                 class="ql-format-button ql-list"></span></span></div>
                <div class="editor-container"></div>
            </div>
        </div>
        <%--<textarea class="input input_up" name="description" id="description" placeholder="Description"></textarea>--%>
        <%--<span id="description_help_text" class="help_message"></span>--%>
    </div>
    <div class="form_element">
        <input id="btn_up" type="submit" value="Изменить" class="btn btn-login"/>
        <input id="btn_delete" type="submit" value="Удалить" class="btn btn-logout"/>
    </div>
</form>