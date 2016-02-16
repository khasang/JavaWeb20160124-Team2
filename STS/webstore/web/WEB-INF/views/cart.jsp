<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Корзина</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<div id="div_container">
    <h1>${page_name}</h1>
    <div id="buttons_container">
        <button id="button_logout">Выход</button>
        <button id="button_menu">Меню</button>
    </div>
    <table id="cart_table">
        <thead>
        <tr>
            <th>position</th>
            <th>count</th>
            <th>cost</th>
            <th>summary</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>10000</td>
            <td>Японский магнитофон</td>
        </tr>
        <tr>
            <td>2</td>
            <td>6</td>
            <td>2500</td>
            <td>Электрический чайник</td>
        </tr>
        <tr>
            <td>3</td>
            <td>7</td>
            <td>5400</td>
            <td>Пылесос</td>
        </tr>
        <tr>
            <td>4</td>
            <td>8</td>
            <td>12000</td>
            <td>Столешница</td>
        </tr>
        </tbody>
    </table>
</div>
</html>
