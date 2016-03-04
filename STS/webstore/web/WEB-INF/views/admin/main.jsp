<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form id="login_form" method="post" th:action="@{/logout}">
    <input type="hidden" name="<c:out value='${_csrf.parameterName}'/>"
           value="<c:out value='${_csrf.token}'/>"/>
    <input type="submit" value="Выйти" class="btn btn-logout"/>
</form>