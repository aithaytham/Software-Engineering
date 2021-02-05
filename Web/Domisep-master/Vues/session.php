<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['session']); ?>


<html>
<head>
    <meta charset="UTF-8">
</head>

<body onload="init()">

<?php include("header_connect.php"); ?>
<?php $sessions = \Domisep\Controller\ControlVisitorAuth::getSessions(); ?>

<ul class="list_session">
    <?php foreach ($sessions as $s) {
        ?>
        <li class="session">
            <img src="<?= Domisep\Config\Config::getResources()['users'] ?>" class="picture"></img>
            <div class="list_password">
                <form method="post" action="?action=checkSession">
                    <input class="input" type="password" maxlength="1" name="one" required>
                    <input class="input" type="password" maxlength="1" name="two" required>
                    <input class="input" type="password" maxlength="1" name="three" required>
                    <input class="input" type="password" maxlength="1" name="four" required>
                    <input type="text" name="idsess" value="<?php echo $s["id"] ?>" hidden>
                    <input class="input" type="submit" value="Go" style="font-size: 1vw">
                </form>
            </div>
            <label class="nom_session"><?php echo strtoupper($s["nom"]) ?></label>
        </li>

    <?php } ?>

    <form method="post" action="?action=createSession">
        <li class="session last" style="margin-top: -0.25%">
            <div class="list_password">
                <input class="input" type="password" maxlength="1" name="p">
                <input class="input" type="password" maxlength="1" name="a">
                <input class="input" type="password" maxlength="1" name="s">
                <input class="input" type="password" maxlength="1" name="ss">
            </div>
            <input class="input_name" placeholder="Session name" type="text" name="name">
            <img class="img_plus" src="<?= Domisep\Config\Config::getResources()['plus'] ?>"/> <br/>
            <input type="submit" id="sub" value="add" class="input" style="width: 10vw; font-size: 1vw;">
        </li>
    </form>
</ul>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="/Domisep/Vues/js_session.js"></script>
</body>

</html>
