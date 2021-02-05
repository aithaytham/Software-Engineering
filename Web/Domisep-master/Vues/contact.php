<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['contact']); ?>


<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Domisep contact</title>
</head>
<body>
<?php include("header.php") ?>

<div class="container">
    <h1 class="title" style="margin-left: -10%">Contact us</h1>
    <br/>
    <form class="form-container" method="post">
        <h2>Call us on <b>0123456789</b> or email us at <b>contact@domisep.com</b></h2>
        <h2>Want us to get back to you ?</h2>
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
        <textarea class="form-control " name="message" id="message" rows="6" placeholder=" Message"
                  aria-label="Entrez votre message ici" required></textarea>
        <br/>
        <br/>
        <br/>
        <p style="margin-left: 20em"><input type="submit" name="submit" value="Send" class="submit" style="margin-left: 0%;"></p>
    </form>
</div>
</body>
</html>