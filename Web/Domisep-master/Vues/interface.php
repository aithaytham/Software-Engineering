<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['interface']); ?>


<html>
<head>
    <meta charset="UTF-8">
    <title>Domisep - Interface</title>
</head>

<body onload="init()">
<?php include("header_connect.php"); ?>
<?php $rooms = \Domisep\Controller\ControlVisitorAuth::getRooms(); ?>
<?php $home = \Domisep\Controller\ControlVisitorAuth::getHomes(); ?>


<div class="centrer">
    <ul class="list_icons">
        <li class="container_icon" id="cam">
            <img class="icon" src="<?= Domisep\Config\Config::getResources()['cam'] ?> "/>
        </li>
        <li class="container_icon" id="light">
            <img class="icon" src="<?= Domisep\Config\Config::getResources()['ampoule'] ?> "/>
        </li>
        <li class="container_icon" id="temp" >
            <img class="icon" src="<?= Domisep\Config\Config::getResources()['thermometre'] ?> "/>
        </li>
        <li class="container_icon" id="sun" >
            <img class="icon" src="<?= Domisep\Config\Config::getResources()['store'] ?> "/>
        </li>
    </ul>

</div>

<form method="post" action="?action=getSensors">

    <input type="text" id="sensorType" name="sensorType" hidden>

    <div class="container_list">
        <select class="select_room" style="margin-bottom: 2%" name="houseSelect" id="houseSelect" required>
            <option value="" disabled selected>Select your house</option>

            <?php foreach ($home as $h) { ?>

                <option> <?php echo $h["nom"] ?> </option>

            <?php } ?>
        </select>

        <select class="select_room" name="roomSelect" id="roomSelect" required>
            <option value="" disabled selected>Select your room</option>

            <?php foreach ($rooms as $r) { ?>

                <option> <?php echo $r["nom"] ?> </option>

            <?php } ?>
        </select>

        <input type="submit" class="submit" value="Show sensors">
    </div>

</form>

<script>
    $("#temp").on('click', function () {
        document.getElementById("sensorType").value = "1";
    });

    $("#sun").on('click', function () {
        document.getElementById("sensorType").value = "2";
    });

    $("#light").on('click', function () {
        document.getElementById("sensorType").value = "3";
    });

    $("#cam").on('click', function () {
        document.getElementById("sensorType").value = "4";
    });
</script>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script type="text/javascript" src="/Domisep/Vues/js_interface.js"></script>
</body>

</html>
