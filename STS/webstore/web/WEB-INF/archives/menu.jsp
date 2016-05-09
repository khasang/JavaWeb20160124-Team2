<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="../views/css/style_of_menu.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Program's shop</title>
</head>
<body>
<div class="blockUp">
    <h1 align="center">WebStore</h1>
    <h1 align="center">${menu}</h1>
</div>
<div class="blockTop">
    <center>
        <h1 class="textWhite">${textInTopBlock}</h1>
    </center>
</div>
<div class="blockDown">
    <form action="menuHelper" method="POST">
        <div class="block" title="click to add this productDescritption">
            <h4 align="center">${nameOfFirstBlock} with cost: </h4>
            <input type="submit" class="btn" name="name" value="Get first!"/>
        </div>
        <div class="block" title="click to add this productDescritption">
            <h4 align="center">${nameOfSecondBlock} with cost: </h4>
            <input type="submit" class="btn" name="name" value="Get two!"/>
        </div>
        <div class="block" title="click to add this productDescritption">
            <h4 align="center">${nameOfThirdBlock} with cost: </h4>
            <input type="submit" class="btn" name="name" value="Get three!"/>
        </div>
        <div class="block" title="click to add this productDescritption">
            <h4 align="center">${nameOfFourthBlock} with cost: </h4>
            <input type="submit" class="btn" name="name" value="Get four!"/>
        </div>
        <div class="block" title="click to add this productDescritption">
            <h4 align="center">${nameOfFifthlock} with cost: </h4>
            <input type="submit" class="btn" name="name" value="Get five!"/>
        </div>
        <div class="block" title="click to add this productDescritption" >
            <h4 align="center">${nameOfSixBlock} with cost: </h4>
            <input type="submit" class="btn" name="name" value="Get six!"/>
        </div>
        <div class="block" title="click to see your products">
            <h4 align="center">${nameOfSevenBlock}</h4>
            <button type="button" class="btn" onclick='location.href="/cart"'>Link</button>
        </div>
    </form>
</div>
</body>

</html>
