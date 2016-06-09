<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div>
    <div id="right_column">
        <h2>Название ${thisProduct.getPname()}</h2>
        <p>Производитель: </p>
        <p>Выберите цвет:</p>
        <div id="prod_color">
        </div>
        <p>Цена: <span id="cost" class="color">${thisProduct.getCost()} руб.</span></p>
        <form id="pay_product_form" method="post">
            <div class="form_element">
                <input id="btn_login" type="submit" value="Купить" class="btn btn-login"/>
            </div>
        </form>
    </div>
    <div class="images">
        <div id="big_image">
            <div id="width_image">
                <a class="cboxElement" rel="group1" href="images/fotonotfound.png"><img id="big_img" src="images/fotonotfound.png"></a>
            </div>
            <div id="small_images">
                <div class="small_image">
                    <a class="cboxElement" rel="group1" href="images/fotonotfound.png"><img src="images/fotonotfound.png"></a>
                </div>
                <div class="small_image">
                    <a class="cboxElement" rel="group1" href="images/fotonotfound.png"><img src="images/fotonotfound.png"></a>
                </div>
                <div class="small_image">
                    <a class="cboxElement" rel="group1" href="images/fotonotfound.png"><img src="images/fotonotfound.png"></a>
                </div>
            </div>
        </div>
    </div>
</div>
<div>
    <h2>Описание</h2>
    <p>
        ${thisProduct.getProductDescription()}
    </p>
</div>
