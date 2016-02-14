<%--
  Created by IntelliJ IDEA.
  User: Yulia
  Date: 11.02.2016
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tableselect</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<h2> ${dropdownlist} </h2>
<table>
    <tr>
        <td>
            <select><option>select the table</option>
            <option>table1</option>
            <option>table2</option>
            <option>table3</option></select>
        </td>
        <td>
            <button class="button">Join</button>
        </td>
    </tr>
</table>
<br/><br/><br/>
<table>
    <tr>
        <td>
            <button class="button">return to menu</button>
        </td>
        <td>
            <button class="button">logoff</button>
        </td>
    </tr>
</table>
</body>
</html>
