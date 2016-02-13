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
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<form>
    <p style="text-align: center"><select size="1" style="">
        <option>
            <table border="3">
                <caption>Products</caption>
            </table>
        </option>
        <option>
            <table border="3">
                <caption>table2</caption>
            </table>
        </option>
        <option>
            <table border="3">
                <caption>table3</caption>
            </table>
        </option>
    </select></p>
</form>
<table align="center">
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${items}" var="product">
        <tr>
            <td><c:out value="${product.ID}"/></td>
            <td><c:out value="${product.pName}"/></td>
            <td><c:out value="${product.description}"/></td>
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
