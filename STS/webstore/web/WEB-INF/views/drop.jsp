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
    <link rel="stylesheet" href="css/styledrop.css">
</head>
<body>
    <p><center><h1>Drop table</h1></center></p>
    <input class="menuButton" type="button" onclick="history.back();" value="Back to menu">
    <input class="logoutButton" type="button" onclick="" value="Log out">
    <center><p><b>Enter the name of the table to remove:</b></p>
            <form action="drop" method="GET">
            <input class="placeForInput" type="text" size="40" name="name" id="name">
                <p><b>Or select from the list:</b></p>
                <p><center><select required class="selectButton"  name="namet" id="namet">
                <option>Select table</option>
                <%Iterator itr;%>
                <%List data = (List)request.getAttribute("data");
                    for(itr=data.iterator();itr.hasNext();) {
                %>
                <option><%=itr.next()%></option>
                <%}%>
            </select></center></p>
                <script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
                <script>
                    $(document).ready(function(){
                        //Скрыть PopUp при загрузке страницы
                        PopUpHide();
                    });
                    //Функция отображения PopUp
                    function PopUpShow(){
                        $("#popup1").show();
                    }
                    //Функция скрытия PopUp
                    function PopUpHide(){
                        $("#popup1").hide();
                    }
                </script>
                    <div class="b-container">
                        <p><center><input class="dropButton" type="button" value="Drop" onclick="PopUpShow()" ></center></p>
                    </div>
                    <div class="b-popup" id="popup1">
                        <div class="b-popup-content">
                            Are you sure to delete this table?
                            <p><center><input class="dropButton" type="submit" value="Yes" ></center></p>
                            <p><center><input class="dropButton" type="button" value="No" onclick="PopUpHide()" ></center></p>
                        </div>
                    </div>
                <p><h6>Refresh the page after clicking</h6></p>
            </form>
    </center>
</body>
</html>
