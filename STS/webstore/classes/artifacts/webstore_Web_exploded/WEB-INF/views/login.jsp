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
            <br/>
            <input class="input" type="text" name="username" id="username" placeholder="Login"/>
            <span id="username_help_text" class="help_message"></span>
        </div>
        <div class="form_element">
            <label for="password" class="label">Пароль</label>
            <br/>
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
    <div class="form_element">
        <a class="href" href="/registry">Регистрация</a>
        <a class="href" href="/recovery">Забыли пароль?</a>
    </div>
</sec:authorize>