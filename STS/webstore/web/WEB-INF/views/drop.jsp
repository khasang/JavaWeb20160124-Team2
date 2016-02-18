<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Technology
  Date: 11.02.16
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"  %>
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
                <p><b>Или выберите из списка:</b></p>
                <p><center><select required class="selectButton"  name="namet" id="namet">
                <option>Select table</option>
                <%Iterator itr;%>
                <%List data = (List)request.getAttribute("data");
                    for(itr=data.iterator();itr.hasNext();) {
                %>
                <option><%=itr.next()%></option>
                <%}%>
            </select></center></p>
            <p><center><input class="dropButton" type="submit" value="Drop" ></center></p>
                <p><h6>Обновите страницу после нажатия кнопки</h6></p>
            </form>
    </center>
</body>
</html>
