<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17.02.2016
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style_login.css">
</head>
<body>
<form>
    <fieldset >
        Имя:<br>
        <input list="logins" name="browser">
        <datalist id="logins">
            <option value="Internet Explorer">
            <option value="Firefox">
            <option value="Chrome">
            <option value="Opera">
            <option value="Safari">
        </datalist>
        <br>
        Пароль:<br>
        <input type="password" name="password">
        <br><br>
        <input type="button" name="okButton" value="Войти">
        <br><br>
        <a href="url">Зарегистрироваться</a>
        <br><br>
        <a href="url">Вспомнить пароль</a>
    </fieldset>
</form>
</body>
</html>
