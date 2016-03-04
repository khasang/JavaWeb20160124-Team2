<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form id="login_form" method="post" th:action="@{/logout}">
    <input type="hidden" name="<c:out value='${_csrf.parameterName}'/>"
           value="<c:out value='${_csrf.token}'/>"/>
    <input type="submit" value="Выйти" class="btn btn-logout"/>
</form>
<form id="contacts_form" method="post">
    <div class="form_element">
        <label for="name" class="label">Имя</label>
        <br />
        <input class="input" type="text" name="name" id="name" placeholder="Name"/>
        <span id="name_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="email" class="label">Email</label>
        <br />
        <input class="input" type="email" name="email" id="email" placeholder="Email"/>
        <span id="email_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="email" class="label">Телефон</label>
        <br />
        <input class="input" type="tel" name="phone" id="phone" placeholder="Phone"/>
        <span id="phone_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <label for="address" class="label">Адрес</label>
        <br />
        <input class="input" type="text" name="address" id="address" placeholder="Address"/>
        <span id="address_help_text" class="help_message"></span>
    </div>
    <div class="form_element">
        <input id="btn_account" type="submit" value="Изменить" class="btn btn-login"/>
    </div>
</form>
<div class="delivery_inform">
    <p class="right-float">Статус заказа: доставлен</p>
    <p>Дата заказа: 25.02.2016</p>
    <table id="prod_table">
        <tbody>
        <tr class="table-head">
            <th id="first">Описание</th>
            <th id="second">Цена</th>
            <th id="third">Кол-во</th>
            <th id="fourth">Итого</th>
        </tr>
        <tr class="prod" style="background-color:#ffffff;">
            <td>
                <div class="left_img inline_i">
                    <img src="images/fotonotfound.png">
                </div>
                <div class="right_desc  inline_i">
                    <p class="product_name">Название товара</p>
                    <p>Характеристики</p>
                </div>
            </td>
            <td>
                <p><span class="cost_t color product_price">15000.00</span> рублей</p>
            </td>
            <td>
                <span class="count_t product_count">1</span>
            </td>
            <td>
                <p>15000 рублей</p>
            </td>
        </tr>
        </tbody>
    </table>
    <p><b>Итого:</b> 15000 рублей</p>
</div>