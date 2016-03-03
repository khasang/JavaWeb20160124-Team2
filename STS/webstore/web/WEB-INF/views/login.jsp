<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<c:if test="${not empty error}">
    <p class="error_message">${error}</p>
</c:if>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
<sec:authorize access="isAuthenticated()">
    <p>Вы зашли как
        <sec:authorize access="hasRole('ROLE_USER')"> пользователь</sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')"> администратор</sec:authorize>
    </p>
    <p>Страница <a href="/secure">/secure</a></p>
    <form id="login_form" method="post" th:action="@{/logout}">
        <input type="hidden" name="<c:out value='${_csrf.parameterName}'/>"
               value="<c:out value='${_csrf.token}'/>"/>
        <input type="submit" value="Выйти" class="btn btn-logout"/>
    </form>
</sec:authorize>
<sec:authorize access="isAnonymous()">
    <form id="login_form" method="post" th:action="@{/login}">
        <div class="form_element">
            <label for="username" class="label">Логин</label>
            <br />
            <input class="input" type="text" name="username" id="username" placeholder="Login"/>
            <span id="username_help_text" class="help_message"></span>
        </div>
        <div class="form_element">
            <label for="password" class="label">Пароль</label>
            <br />
            <input class="input" type="password" name="password" id="password" placeholder="Password"/>
            <span id="password_help_text" class="help_message"></span>
        </div>
        <div class="form_element">
            <p><input type="checkbox" name="_spring_security_remember_me"/> Запомнить меня</p>
            <input type="hidden" name="<c:out value='${_csrf.parameterName}'/>"
                   value="<c:out value='${_csrf.token}'/>"/>
        </div>
        <div class="form_element">
            <input id="btn_login" type="submit" value="Войти" class="btn btn-login"/>
        </div>
    </form>
</sec:authorize>
<%--Skip to content--%>
<%--This repository--%>
<%--Search--%>
<%--Pull requests--%>
<%--Issues--%>
<%--Gist--%>
<%--@LevSeleznev--%>
<%--Unwatch 11--%>
<%--Star 2--%>
<%--Fork 1 khasang-incubator/JavaWeb20160124-Team2--%>
<%--Code  Issues 5  Pull requests 0  Wiki  Pulse  Graphs--%>
<%--Branch: development Find file Copy pathJavaWeb20160124-Team2/STS/webstore/web/WEB-INF/views/login.jsp--%>
<%--b84ec83  5 days ago--%>
<%--@SKuznet SKuznet pull--%>
<%--3 contributors @SKuznet @bMik98 @AnkBurov--%>
<%--RawBlameHistory     40 lines (39 sloc)  1.07 KB--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: admin--%>
  <%--Date: 17.02.2016--%>
  <%--Time: 2:08--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="ru">--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>Login</title>--%>
    <%--<link rel="stylesheet" type="text/css" href="css/style_login.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<form>--%>
    <%--<fieldset>--%>
        <%--Имя:<br>--%>
        <%--<input list="users" name="browser">--%>
        <%--<datalist id="users">--%>
            <%--<c:forEach items="${login}" var="users">--%>
                <%--<option value=${users.login} ></option>--%>
            <%--</c:forEach>--%>
        <%--</datalist>--%>
        <%--<br>--%>
        <%--Пароль:<br>--%>
        <%--<input type="password" name="password">--%>
        <%--<br><br>--%>
        <%--<input type="button" name="okButton" value="Войти">--%>
        <%--<br><br>--%>
        <%--<a href="url">Зарегистрироваться</a>--%>
        <%--<br><br>--%>
        <%--<a href="url">Вспомнить пароль</a>--%>
    <%--</fieldset>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%--Status API Training Shop Blog About Pricing--%>
<%--© 2016 GitHub, Inc. Terms Privacy Security Contact Help--%>