<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['account']); ?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>Mon compte</title>
</head>
<body>

<?php include("header_connect.php") ?>
<?php $client = \Domisep\Controller\ControlVisitorAuth::getClient(); ?>
<?php $home = \Domisep\Controller\ControlVisitorAuth::getHomes(); ?>

<div id="container">
    <div id="account">
        <h2>My informations</h2>
        <ul class="list_inputs">
            <li class="li_input">
                <input type="text" class="inscri_input" id="lastname" name="nom" placeholder="Name"
                       value="<?php echo $client["nom"] ?>"/>
            </li>
            <li class="li_input">
                <input type="text" class="inscri_input" id="firstname" name="prenom" placeholder="First name"
                       value="<?php echo $client["prenom"] ?>"/>
            </li>
            <li class="li_input">
                <input type="text" class="inscri_input" id="email" name="email" placeholder="email"
                       value="<?php echo $_SESSION["user"]["email"] ?>"/>
            </li>
            <li class="li_input">
                <input type="text" class="inscri_input" id="number" name="number" placeholder="Phone"
                       value="<?php echo $_SESSION["user"]["phone"] ?>"/>
            </li>
            <li>
                <input type="submit" value="Valider" class="button" style="margin-left: 35%"/>
            </li>
        </ul>
    </div>
    <hr>

    <div id="home">
        <h2>My houses</h2>
        <select class="inscri_input" style="height: 7%" id="home" name="home" placeholder="Home">
            <option value="" disabled selected>Select a House</option>
            <?php foreach ($home as $h) { ?>
                <option><?php echo $h["nom"] ?> </option>
            <?php } ?>
        </select><br/>
        <button class="button-home" id="editHome">Edit House</button>
        <button class="button-home" id="addHome">Add House</button>
    </div>
    <hr>


    <div id="subscription">
        <h2>My subscription</h2>
        <p>
            Your subscription expires on January 1st 2018<br/>
            <br/>
        </p>
        <button class="button" style="margin-left: 40%">Renew subscription</button>

    </div>
    <hr>

    <div id="subscription">
        <h2>My bills</h2>
        <button class="button" style="margin-left: 40%;">Download my bills</button>
    </div>

</div>

<div id="createHomeModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeHome">&times;</span>
            <h2 style="color: gray">Add a new home</h2>
        </div>
        <div class="modal-body">
            <form method="post" action="?action=addHome">
                <input type="text" name="nom" placeholder="Name" class="input"/><br/>
                <input type="text" name="adresse" placeholder="Adress" class="input"/><br/>
                <input type="submit" class="submit" value="Create"/>
            </form>
        </div>

    </div>

</div>

<div id="editHomeModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <div class="modal-header">
            <span class="close" id="closeEdit">&times;</span>
            <h2 style="color: gray">Edit this home</h2>
        </div>
        <div class="modal-body">
            <form method="post" action="?action=editHome">
                <input type="text" name="nom" placeholder="Name" class="input"/><br/>
                <input type="text" name="adress" placeholder="Adress" class="input"/><br/>
                <input type="submit" class="submit" value="Create"/>
            </form>
        </div>

    </div>

</div>

<div id="myModaladd" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2 style="color: gray">Adding has been made successfully.</h2>
        <button class="submit" id="answerbutton">Ok</button>
    </div>

</div>


<script>
    var createHomeModal = document.getElementById('createHomeModal'),
        closeHome = document.getElementById("closeHome"),
        editHomeModal = document.getElementById('editHomeModal'),
        closeEdit = document.getElementById("closeEdit");


    closeHome.onclick = function () {
        createHomeModal.style.display = "none";
    }


    $("#addHome").click(function () {
        createHomeModal.style.display = "block";
    });


    window.onclick = function (event) {
        if (event.target == createHomeModal) {
            createHomeModal.style.display = "none";
        } else if (event.target == editHomeModal) {
            editHomeModal.style.display = "none";
        }
    }

    closeEdit.onclick = function () {
        editHomeModal.style.display = "none";
    }


    $("#editHome").click(function () {
        editHomeModal.style.display = "block";
    });


</script>


</body>
</html>