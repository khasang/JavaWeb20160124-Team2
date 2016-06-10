<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: e.karpov
  Date: 17.02.2016
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer cart</title>
    <link rel="stylesheet" type="text/css" href="../views/css/webstore_style.css"/>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1 align="center">Иной способ отображения корзины клиента</h1>
<h3 align="center">Имеет методы addItem, removeItem и getCartItems</h3>
<h3 align="center">Корректно пересчитывает quantity одинаковых товаров при добавлении и удалении товара</h3>
<p><table align="center">
    <tr>
        <th>Product name</th>
        <th>Description</th>
        <th>Vendor code</th>
        <th>Quantity</th>
    </tr>
    <c:forEach items="${cartitems}" var="cartitem">
        <tr>
            <td><c:out value="${cartitem.productName}"/></td>
            <td><c:out value="${cartitem.description}"/></td>
            <td><c:out value="${cartitem.vendorCode}"/></td>
            <td><c:out value="${cartitem.quantity}"/></td>
        </tr>
    </c:forEach>
    </tr>
</table>
</p>
</body>
</html>
