<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<p>Показать: <a class="view_status" href="?status=done">Доставленные</a> <a class="view_status" href="?status=new">Новые</a> <a class="view_status" href="?status=processed">В обработке</a> <a class="view_status" href="?status=canceled">Отменённые</a></p>
<table class="table table-border table-striped">
    <thead>
    <tr>
        <th><a href="?sort=id">ID</a></th>
        <th><a href="?sort=status">Статус</a></th>
        <th><a href="?sort=date">Дата доставки</a></th>
        <th><a href="?sort=address">Адрес доставки</a></th>
        <th></th>
    </tr>
    <tr>
        <td><input type="text" class="input input_table" name="search_id" id="search_id" /></td>
        <td><input type="text" class="input input_table" name="search_status" id="search_status" /></td>
        <td><input type="text" class="input input_table" name="search_delivery" id="search_delivery" /></td>
        <td><input type="text" class="input input_table" name="search_address" id="search_address" /></td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>В обработке</td>
        <td>21.03.2016</td>
        <td>г. Волгоград, ул. Паперника, дом 13</td>
        <td>
            <a href="/admin/delivery?id=1">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>В обработке</td>
        <td>21.03.2016</td>
        <td>г. Волгоград, ул. Паперника, дом 13</td>
        <td>
            <a href="/admin/delivery?id=1">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>Отменён</td>
        <td>21.03.2016</td>
        <td>г. Волгоград, ул. Паперника, дом 13</td>
        <td>
            <a href="/admin/delivery?id=1">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>4</td>
        <td>В обработке</td>
        <td>21.03.2016</td>
        <td>г. Волгоград, ул. Паперника, дом 13</td>
        <td>
            <a href="/admin/delivery?id=1">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>5</td>
        <td>Доставлен</td>
        <td>21.03.2016</td>
        <td>г. Волгоград, ул. Паперника, дом 13</td>
        <td>
            <a href="/admin/delivery?id=1">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    </tbody>
</table>