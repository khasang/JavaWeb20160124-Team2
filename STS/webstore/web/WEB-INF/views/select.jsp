<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 134
  Date: 09.02.2016
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Select table page</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<p style="text-align: center">Берет содержимое таблицы productorder и динамически рисует ее содержимое</p>
<table align="center">
    <tr>
        <th>id</th>
        <th>orderid</th>
        <th>product</th>
        <th>count</th>
        <th>cost</th>
        <th>totalcost</th>
        <th>status</th>
        <th>userid</th>
    </tr>
    <c:forEach items="${items}" var="productorder">
        <tr>
            <td><c:out value="${productorder.id}"/></td>
            <td><c:out value="${productorder.orderid}"/></td>
            <td><c:out value="${productorder.product}"/></td>
            <td><c:out value="${productorder.count}"/></td>
            <td><c:out value="${productorder.cost}"/></td>
            <td><c:out value="${productorder.totalcost}"/></td>
            <td><c:out value="${productorder.status}"/></td>
            <td><c:out value="${productorder.userid}"/></td>
        </tr>
    </c:forEach>
    </tr>
</table>
<form>
    <p style="text-align: center">
        <button onclick="window.location.reload();">
    <p>Menu</p></button>
    <button onclick="window.location.reload();"><p>Select</p></button>
    <button onclick="window.location.reload();"><p>Logoff</p></button>
    </p>
</form>
</body>
</html>
