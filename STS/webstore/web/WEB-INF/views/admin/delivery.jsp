<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<form id="login_form" method="post">
    <div class="form_element">
        <label for="address" class="label">Адрес доставки</label>
        <br/>
        <input class="input input_up" type="text" name="address" id="address" placeholder="Address"/>
        <span id="address_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="date" class="label">Дата доставки</label>
        <br/>
        <input class="input input_up" type="text" name="date" id="date" placeholder="Date"/>
        <span id="date_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="name" class="label">Контактное лицо</label>
        <br/>
        <input class="input input_up" type="text" name="name" id="name" placeholder="User"/>
        <span id="name_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="phone" class="label">Телефон</label>
        <br/>
        <input class="input input_up" type="text" name="phone" id="phone" placeholder="Phone"/>
        <span id="phone_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="email" class="label">Email</label>
        <br/>
        <input class="input input_up" type="text" name="email" id="email" placeholder="Email"/>
        <span id="email_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="status_select" class="label">Статус</label>
        <br/>
        <select id="status_select" class="select">
            <option>Новый</option>
            <option>В обработке</option>
            <option>Отменён</option>
            <option>Доставлен</option>
        </select>
    </div>
    <div class="form_element">
        <input id="btn_up" type="submit" value="Изменить" class="btn btn-login"/>
        <input id="btn_delete" type="submit" value="Удалить" class="btn btn-logout"/>
    </div>
</form>