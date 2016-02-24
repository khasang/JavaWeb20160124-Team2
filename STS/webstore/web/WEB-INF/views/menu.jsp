<html>
<head>
    <link href="css/style_of_menu.css" rel="stylesheet">
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
    <a href="https://github.com/khasang-incubator/JavaWeb20160124-Team2/blob/iserba/aboutShop.txt" onclick=${actionOnclickFirstBlock}>
        <div class="block" title="link to first page of this shop">
            <h4 align="center">${nameOfFirstBlock}</h4>
        </div>
    </a>
    <a href="https://github.com/khasang-incubator/JavaWeb20160124-Team2/blob/iserba/userStory.txt">
        <div class="block" title="link to second page of this shop">
            <h4 align="center">${nameOfSecondBlock}</h4>
        </div>
    </a>
    <a href="/select">
        <div class="block" title="link to /select">
            <h4 align="center">${nameOfThirdBlock}</h4>
        </div>
    </a>
    <a href="/cart">
        <div class="block" title="link to /cart">
            <h4 align="center">${nameOfFourthBlock}</h4>
        </div>
    </a>
    <a href="/viewproducts">
        <div class="block" title="link to /viewproducts">
            <h4 align="center">${nameOfFifthlock}</h4>
        </div>
    </a>
    <a href="/deletecurrentorder">
        <div class="block" title="link to /deletecurrentorder">
            <h4 align="center">DeleteOrder</h4>
        </div>
    </a>
    <a href="/drop">
        <div class="block" title="link to /drop">
            <h4 align="center">Drop table</h4>
        </div>
    </a>
</div>
</body>
</html>
