<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Technology
  Date: 11.02.16
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Drop Table</title>
    <link rel="stylesheet" href="/css/styleDrop.css">
</head>
<body>

    <input class="menuButton" type="button" onclick="history.back();" value="Back to menu">
    <input class="logoutButton" type="button" onclick="" value="Log out">
    <center><p><b>Введите название таблицы для удаления:</b></p>

            <form action="drop" method="GET">
            <input class="placeForInput" type="text" size="40" name="name" id="name">
            <p><center><input class="dropButton" type="submit" value="Drop" ></center></p>
            </form>

    </center>
</body>
</html>
