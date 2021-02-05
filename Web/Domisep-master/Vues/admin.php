<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['admin']); ?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
</head>

<body onload="init()">

<?php include("header_admin.php"); ?>
<?php $villes = \Domisep\Controller\ControlAdmin::getVilles(); ?>

<ul class="list_create">
    <li class="session" id="createSensor">
        <img src="<?= Domisep\Config\Config::getResources()['plus'] ?>" class="picture"/>
        <label class="nom_session">Create sensor </label>
    </li>
    <li class="session" id="create_user">
        <img src="<?= Domisep\Config\Config::getResources()['plus'] ?>" id="pic_user" class="picture"/>
        <div class="list_password" hidden="false">
            <ul id="answerTicket">
                <li>
                    <button class="button" type="button" name="technician" id="createTechnician">Technician</button>
                </li>
                <li>
                    <button class="button" type="button" name="sponsor" id="createSponsor">Sponsor</button>
                </li>
                <li>
                    <button class="button" type="button" name="entity" id="createEntity">Entity</button>
                </li>
            </ul>
        </div>
        <label class="nom_session" id="labelcreateuser">Create user</label>
    </li>


    <li class="session" id="createRoom">
        <img src="<?= Domisep\Config\Config::getResources()['plus'] ?>" class="picture"/>
        <label class="nom_session">Create room </label>
    </li>

</ul>

<div id="createSensorModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeSensor">&times;</span>
            <h2>Add Sensor type</h2>
        </div>
        <div class="modal-body">
            <form method="post" action="?action=addSensor">
                <input type="text" name="nom" placeholder="Name" class="input"/><br/>
                <input type="submit" class="submit" value="Create"/>
            </form>
        </div>
    </div>

</div>

<div id="createRoomModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeRoom">&times;</span>
            <h2>Add Room type</h2>
        </div>
        <div class="modal-body">
            <form method="post" action="?action=addRoom">
                <input type="text" name="nom" placeholder="Room type name" class="input"/><br/>
                <input type="submit" class="submit" value="Create"/>
            </form>
        </div>
    </div>

</div>

<div id="createTechnicianModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeTechnician">&times;</span>
            <h2>Add Technician</h2>
        </div>
        <div class="modal-body">
            <form method="post" action="?action=addTechnicien">
                <input type="text" name="nom" placeholder="Name" class="input"/><br/>
                <input type="text" name="prenom" placeholder="First Name" class="input"/><br/>
                <input type="text" name="email" placeholder="Email" class="input"/><br/>
                <input type="password" name="password" placeholder="Password" class="input"/><br/>
                <select class="input_select" name="ville">
                    <option value="" disabled selected>Select a city</option>

                    <?php foreach ($villes as $v) { ?>
                        <option><?php echo $v["nom"] ?> </option>
                    <?php } ?>

                </select><br/>
                <input type="submit" class="submit" value="Create"/>
            </form>
        </div>
    </div>
</div>

<div id="createSponsorModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeSponsor">&times;</span>
            <h2>Add Sponsor</h2>
        </div>
        <div class="modal-body">
            <form method="post" action="?action=addSponsor">
                <input type="text" name="nom" placeholder="Name" class="input"/><br/>
                <input type="text" name="email" placeholder="Email" class="input"/><br/>
                <input type="password" name="password" placeholder="Password" class="input"/><br/>
                <input type="submit" class="submit" value="Create"/>
            </form>
        </div>
    </div>

</div>

<div id="createEntityModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeEntity">&times;</span>
            <h2>Add Entity</h2>
        </div>
        <div class="modal-body">
            <form method="post" action="?action=addEntity">
                <select class="input_select" name="ville">
                    <option value="" disabled selected>Select a city</option>

                    <?php foreach ($villes as $v) { ?>
                        <option><?php echo $v["nom"] ?> </option>
                    <?php } ?>

                </select><br/>
                <input type="text" name="nom" placeholder="Name" class="input"/><br/>
                <input type="text" name="email" placeholder="Email" class="input"/><br/>
                <input type="password" name="password" placeholder="Password" class="input"/><br/>
                <input type="submit" class="submit" value="Create"/>
            </form>
        </div>

    </div>

</div>

<div id="myModaladd" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>Adding has been made successfully.</h2>
        <button style="margin-left: 38%" class="submit" id="answerbutton">Ok</button>
    </div>

</div>

<script type="text/javascript" src="Vues/js_admin.js"></script>
</body>

</html>
