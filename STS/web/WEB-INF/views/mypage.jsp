<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 13.02.2016
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<h1> ${mypage} </h1>
<form>
    <p style="text-align: center"><select size="1" style="">
        <option>
            <table border="3">
                <caption>table1</caption>
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

<form>
    <p style="text-align: center">
        <button onclick="window.location.reload();">
    <p>DELET</p></button>
    <button onclick="window.location.reload();"><p>BACK</p></button>
    <button onclick="window.location.reload();"><p>LOGOFF</p></button>
    </p>
</form>
</body>
</html>