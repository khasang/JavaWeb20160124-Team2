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
    <title>Select table page</title>
</head>
<form>
    <p style="text-align: center"><select size="1">
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
        <button formaction="localhost:80">
    <p>Menu</p></button>
    <button formaction="localhost:80">
        <p>Select</p></button>
    <button formaction="localhost:80"><p>Logoff</p></button>
    </p>
</form>
</body>
</html>
