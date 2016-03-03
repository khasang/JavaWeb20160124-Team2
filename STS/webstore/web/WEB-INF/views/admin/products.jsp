<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<a href="">
    <button class="btn btn-logout">Создать товар</button>
</a>
<table class="table table-border table-striped">
    <thead>
    <tr>
        <th><a href="?sort=id">ID</a></th>
        <th><a href="?sort=url">URL</a></th>
        <th><a href="?sort=h1">Заголовок h1</a></th>
        <th><a href="?sort=title">Заголовок title</a></th>
        <th></th>
    </tr>
    <tr>
        <td><input type="text" class="input input_table" name="search_id" id="search_id" /></td>
        <td><input type="text" class="input input_table" name="search_url" id="search_url" /></td>
        <td><input type="text" class="input input_table" name="search_menu" id="search_h1" /></td>
        <td><input type="text" class="input input_table" name="search_name" id="search_title" /></td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>/audio</td>
        <td>Магнитофоны</td>
        <td>Японские магнитофоны</td>
        <td>
            <a href="/admin/product?id=1">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>/audio</td>
        <td>Магнитофоны</td>
        <td>Японские магнитофоны</td>
        <td>
            <a href="/admin/product?id=2">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>/audio</td>
        <td>Магнитофоны</td>
        <td>Японские магнитофоны</td>
        <td>
            <a href="/admin/product?id=3">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>4</td>
        <td>/audio</td>
        <td>Магнитофоны</td>
        <td>Японские магнитофоны</td>
        <td>
            <a href="/admin/product?id=4">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    <tr>
        <td>5</td>
        <td>/audio</td>
        <td>Магнитофоны</td>
        <td>Японские магнитофоны</td>
        <td>
            <a href="/admin/product?id=5">
                <button class="btn btn-login">Изменить</button>
            </a>
        </td>
    </tr>
    </tbody>
</table>