<%--
  Created by IntelliJ IDEA.
  User: Technology
  Date: 11.02.16
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageView</title>
    <link rel="stylesheet" href="/css/stylePageView.css">
</head>
<body>
<form>
    <input class="menuButton" type="button" onclick="history.back();" value="Back to menu">
    <input class="logoutButton" type="button" onclick="" value="Log out">
    <p><center><select required class="selectButton">
    <option disabled>Select item</option>
    <option value="table1" >table1</option>
    <option value="table2">table2</option>
    <option value="table3">table3</option>
</select></center></p>
    <p><center><input class="dropButton" type="button" value="Drop"></center></p>
</form>
</body>
</html>
