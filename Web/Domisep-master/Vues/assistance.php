<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['contact']); ?>


<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Domisep - Assistance</title>
</head>
<body>

<?php include("header_connect.php") ?>


<div class="container">
    <h1 class="title" style="margin-left: -10%">Got an issue ?</h1>
    <br/>
    <form class="form-container" method="post" action="?action=problemContact">
        <h2>Fill the following form and our technicians will contact you.</h2>
        <p>

            <input required type="text" class="input-text" name="nom" placeholder="Last name" value=""/>
            <input required type="text" class="input-text" name="prenom" placeholder="First name" value=""/>

        </p>
        <p>
            <input required type="text" class="input-text" name="email" placeholder=" Email" value=""/>
            <input required type="tel" class="input-text" name="phone" placeholder=" Phone" value=""/>
        </p>
        <p>
            <input required type="text" class="input-text" name="sujet" placeholder=" Subject" value=""/>

        </p>
        <textarea class="form-control " name="message" id="message" rows="6" placeholder=" Message" required></textarea>
        <br/>
        <p style="margin-left: 20em"><input type="submit" name="submit" value="Send" class="submit" style="margin-left: 0%;"></p>
    </form>

    <button id="myBtn" hidden></button>
    <!-- The Modal -->
    <div id="myModal" class="modal">

        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2 style="color: gray; margin-left: 33%">Votre demande a bien été envoyée.</h2>
                <button type="submit" id="closemodal" class="buttonbis"> Ok </button>
        </div>

    </div>
</div>
</body>
</html>