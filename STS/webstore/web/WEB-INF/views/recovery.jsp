<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<div class="title">
    <p>Восстановление пароля</p>
</div>
<div class="form_element">
    <p>
        <label class="label">Введите ваш email:</label>
        <input class="in_reg" type="text" name="email" id="email"/>
    </p>
</div>
<div class="form_element">
    <input class="button" id="recovery" type="submit" value="Создать новый пароль" onclick="history.back()"/>
</div>

