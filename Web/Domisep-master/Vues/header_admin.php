<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['header']); ?>


<html>
<head>
    <meta charset="UTF-8">
</head>

<body onload="init()">
<ul class="list">
    <li class="link" style="width: 3%" ><a href="?action=adminAuth"><img src="<?= Domisep\Config\Config::getResources()['logo'] ?>"style=" width: 90%; border-color: white; border-radius: 10px; border: solid;"></a></li>
    <li class="link"><a href="?action=adminAuth">Home</a></li>
    <li class="link"><a href="?action=account_admin">My account</a></li>
    <li class="link"><a href="?action=logout">Log out</a></li>
</ul>



<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script type="text/javascript" src="js.js"></script>
</body>

</html>