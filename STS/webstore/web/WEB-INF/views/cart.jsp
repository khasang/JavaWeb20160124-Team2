<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="table_products">
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
                    <p>15000 рублей</p><br>
                    <form id="delete_product_form" method="post">
                        <div class="form_element">
                            <input id="btn_delete" type="submit" value="Удалить" class="btn btn-logout"/>
                        </div>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
    <p><b>Итого:</b> 15000 рублей</p>
    <div>
        <div class="form_element">
            <label class="label">Имя:</label>
            <br />
            <input class="in_reg" type="text" name="name" id="name"/>
        </div>
        <div class="form_element">
            <label class="label">Телефон:</label>
            <br />
            <input class="in_reg" type="text" name="telephone" id="telephone"/>
        </div>
        <div class="form_element">
            <label class="label">Email:</label>
            <br />
            <input class="in_reg" type="text" name="email" id="email"/>
        </div>
        <div class="form_element">
            <label class="label">Адрес:</label>
            <br />
            <input class="in_reg" type="text" name="address" id="address"/>
        </div>
        <div class="form_element">
            <label class="label">Время:</label>
            <br />
            <input class="in_reg" type="text" name="time" id="time"/>
        </div>
        <form id="buy_product_form" method="post">
            <div class="form_element">
            <input id="btn_cart" type="submit" value="Заказать" class="btn btn-login"/>
            </div>
        </form>
    </div>
</div>
