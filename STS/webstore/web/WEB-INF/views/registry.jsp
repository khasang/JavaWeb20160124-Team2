<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<div>
    <div class="title">
        <p>Регистрация</p>
    </div>
    <div class="form_element">
        <label class="label">Логин:</label>
        <br />
        <input class="in_reg" type="text" name="login" id="login"/>
    </div>
    <div class="form_element">
        <label class="label">Пароль:</label>
        <br />
        <input class="in_reg" type="password" name="password" id="password"/>
    </div>
    <div class="form_element">
        <label class="label">Повторите пароль:</label>
        <br />
        <input class="in_reg" type="password" name="repeatpassword" id="repeatpassword"/>
    </div>
    <div class="form_element">
        <label class="label">Email:</label>
        <br />
        <input class="in_reg" type="text" name="email" id="email"/>
    </div>
    <div class="form_element">
        <label class="label">Телефон:</label>
        <br />
        <input class="in_reg" type="text" name="telephone" id="telephone"/>
    </div>
    <div class="form_element">
        <label class="label">Имя:</label>
        <br />
        <input class="in_reg" type="text" name="name" id="name"/>
    </div>
    <div class="form_element">
        <label class="label">Адрес:</label>
        <br />
        <input class="in_reg" type="text" name="address" id="address"/>
    </div>
    <div class="form_element">
        <input class="button" id="registry" type="submit" value="Регистрация"/>
    </div>
</div>