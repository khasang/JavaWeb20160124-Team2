<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<p>Юр. адрес: 3-я улица Строителей, дом 25, кв. 12</p>
<p>Телефон: 8 800 8001234</p>
<p>Отдел продаж: sales@webstore.com</p>
<p>Техническая поддержка: admin@webstore.com</p>
<br/>
<h2>Обратный звонок</h2>
<form id="contacts_form" method="post">
    <div class="form_element">
        <label for="name" class="label">Имя</label>
        <br/>
        <input class="input" type="text" name="name" id="name" placeholder="Name"/>
        <span id="name_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="email" class="label">Email</label>
        <br/>
        <input class="input" type="email" name="email" id="email" placeholder="Email"/>
        <span id="email_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="email" class="label">Телефон</label>
        <br/>
        <input class="input" type="tel" name="phone" id="phone" placeholder="Phone"/>
        <span id="phone_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="email" class="label">Комментарий</label>
        <br/>
        <textarea class="input" name="comment" id="comment" placeholder="Comment"></textarea>
        <span id="comment_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <input id="btn_contact" type="submit" value="Отправить" class="btn btn-login"/>
    </div>
</form>