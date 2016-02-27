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
        <div class="block" title="click to add this product">
            <h4 align="center">${nameOfFirstBlock} with cost: </h4>
            <button type="button" class="btn" onclick=${menuHelper.addSelectedProductToTempList(nameOfFirstBlock)}>
                Got it!
            </button>
        </div>
        <div class="block" title="click to add this product">
            <h4 align="center">${nameOfSecondBlock} with cost: </h4>
            <button type="button" class="btn" onclick=${menuHelper.addSelectedProductToTempList(nameOfSecondBlock)}>
                Got it!
            </button>
        </div>
        <div class="block" title="click to add this product">
            <h4 align="center">${nameOfThirdBlock} with cost: </h4>
            <button type="button" class="btn" onclick=${menuHelper.addSelectedProductToTempList(nameOfThirdBlock)}>
                Got it!
            </button>
        </div>
        <div class="block" title="click to add this product">
            <h4 align="center">${nameOfFourthBlock} with cost: </h4>
            <button type="button" class="btn" onclick=${menuHelper.addSelectedProductToTempList(nameOfFourthBlock)}>
                Got it!
            </button>
        </div>
        <div class="block" title="link to /viewproducts">
            <h4 align="center">${nameOfFifthlock} with cost: </h4>
            <button type="button" class="btn" onclick=${menuHelper.addSelectedProductToTempList(nameOfFifthBlock)}>
                Got it!
            </button>
        </div>
        <div class="block" title="click to add this product" >
            <h4 align="center">${nameOfSixBlock} with cost: </h4>
            <button type="button" class="btn" onclick=${menuHelper.addSelectedProductToTempList(nameOfSixBlock)}>
                Got it!
            </button>
        </div>
        <div class="block" title="click to see your products" >
            <h4 align="center">${nameOfSevenBlock}</h4>
        </div>
</div>
</body>
<p>choosen product =${menuHelper.sizeProdIdSelectedFromUser()}+${nameOfFirstBlock}</p>
<p>product = ${menuHelper.pnametest()}</p>
</html>
