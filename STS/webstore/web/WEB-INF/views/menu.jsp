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
    <a href="/managecustomercart" onclick=${insertChoosenProductOfFirstBlock}>
        <div class="block" title="TEST SELECT AND INSERT THIS PRODUCT">
            <h4 align="center">${nameOfProductInFirstBlock}</h4>
        </div>
    </a>
    <a href="/managecustomercart">
        <div class="block" title="link to /managecustomercart">
            <h4 align="center">Your choosen Item v.1</h4>
        </div>
    </a>
    <a href="/select">
        <div class="block" title="link to /select">
            <h4 align="center">Your choosen Item v.2</h4>
        </div>
    </a>
    <a href="/cart">
        <div class="block" title="link to /cart">
            <h4 align="center">Your choosen Item v.3</h4>
        </div>
    </a>
    <a href="/viewproducts">
        <div class="block" title="link to /viewproducts">
            <h4 align="center">View all product</h4>
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