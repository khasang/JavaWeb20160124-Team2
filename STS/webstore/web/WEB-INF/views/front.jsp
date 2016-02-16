<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 10.02.2016
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        .styletext{
            color: darkblue;
            font-size: 14px;
            font-family: Calibri;
        }
        ul.nav li ul {
            display: none;
        }
        ul.nav li:hover > ul{
            display: block;
        }
    </style>
    <title>Front</title>
</head>
<body class="styletext">
<h1> ${front} </h1>
<ul class="nav">
    <li >список
        <ul>
            <li >table 1</li>
            <li> table 2</li>
            <li> table 3</li>
        </ul>
    </li>
</ul>
<form>
    <button > insert </button>

    <button > logoff </button>

    <button > возврат в меню </button>
</form>
</body>
</html>
