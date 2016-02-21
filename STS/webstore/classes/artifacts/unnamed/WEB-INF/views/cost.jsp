<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yulia
  Date: 16.02.2016
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cost</title>
    <link rel="stylesheet" type="text/css" href="css/styleCost.css"/>
</head>
<body>
<br/><br/>
<h2> ${cost} </h2>
<br/>
<table class="table">
    <tr>
        <td>ID</td>
        <td>ProductName</td>
        <td>Cost</td>
    </tr>
    <c:forEach items="${items}" var="costs">
    <tr>
        <td><c:out value="${costs.ID}"/></td>
        <td><c:out value="${costs.pName}"/></td>
        <td><c:out value="${costs.cost}"/></td>
    </tr>
    </c:forEach>
    </tr>
</table>
<p>${insertcosts}</p>
</body>
</html>
