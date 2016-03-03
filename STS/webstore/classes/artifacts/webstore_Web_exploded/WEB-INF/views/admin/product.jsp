<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form id="login_form" method="post">
    <div class="form_element">
        <label for="menu_name" class="label">Название в меню</label>
        <br />
        <input class="input input_up" type="text" name="menu_name" id="menu_name" placeholder="Menu name"/>
        <span id="menu_name_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="h1" class="label">Заголовок h1</label>
        <br />
        <input class="input input_up" type="password" name="h1" id="h1" placeholder="H1"/>
        <span id="h1_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="title" class="label">Заголовок title</label>
        <br />
        <input class="input input_up" type="text" name="title" id="title" placeholder="Title"/>
        <span id="title_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="meta_keywords" class="label">Meta keywords</label>
        <br />
        <textarea class="input input_up" name="meta_keywords" id="meta_keywords" placeholder="Meta Keywords"></textarea>
        <span id="meta_keywords_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="meta_description" class="label">Meta description</label>
        <br />
        <textarea class="input input_up" name="meta_description" id="meta_description" placeholder="Meta description"></textarea>
        <span id="meta_description_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="meta_description" class="label">Категория</label>
        <br />

    </div>
    <div class="form_element">
        <label for="meta_description" class="label">Цвет</label>
        <br />
        
    </div>
    <div class="form_element">
        <label for="description" class="label">Описание</label>
        <br />
        <textarea class="input input_up" name="description" id="description" placeholder="Description"></textarea>
        <span id="description_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <input id="btn_up" type="submit" value="Изменить" class="btn btn-login"/>
        <input id="btn_delete" type="submit" value="Удалить" class="btn btn-logout"/>
    </div>
</form>