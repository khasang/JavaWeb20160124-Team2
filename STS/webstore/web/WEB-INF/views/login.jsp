<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <fieldset>
        Имя:<br>
        <input list="users" name="browser">
        <datalist id="users">
            <c:forEach items="${login}" var="users">
                <option value=${users.login} ></option>
            </c:forEach>
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
