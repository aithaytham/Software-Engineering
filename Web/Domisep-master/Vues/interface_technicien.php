<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['technicien']); ?>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Interface technicien</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="Vues/js_tech.js"></script>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
</head>
<body onload="init()">

<?php include("header_technicien.php") ?>
<?php $problems = \Domisep\Controller\ControlTechnicien::getProblems(); ?>


<ul id="listTickets">
    <h2 style="color: white; margin-left: 8%">Clients problems are shown here.</h2>
    <?php foreach ($problems as $pb) {
        ?>

        <li class='liTicket' id="liTicket<?php echo $pb["id"] ?>">
            <div class="ticket">
                <div class="id"><?php echo utf8_encode($pb["id"]) ?></div>
                <div class="object"><?php echo utf8_encode($pb["sujet"]) ?></div>
                <div class="statecontainer">
                    <div class="<?php echo "state " . $pb["etat"] ?>"></div>
                </div>
            </div>
            <div class="descriptionTicket">
                <p class="alignerGauche" id="commentaireTicket">
                    <?php echo utf8_encode($pb["message"]) ?>
                </p><br/>
                <span class="alignerGauche"><?php echo utf8_encode($pb["prenom"] . " " . $pb["nom"]) ?> </span><br/>
                <span class="alignerGauche"><?php echo date_format(new DateTime($pb["date"]), 'd/m/Y à H:i') ?> </span>
                <ul id="answerTicket">
                    <li>
                        <button class="button" type="button" id="myBtn" name="Answer">Answer</button>
                    </li>
                    <?php if ($pb["etat"] != "done") { ?>
                        <li>
                            <form method="post" action="?action=closeProblem">
                                <input type="text" name="id" value="<?php echo $pb["id"] ?>" hidden>
                                <input class="buttonclose" type="submit" name="close" value=" Close "> </input>
                            </form>
                        </li>
                    <?php } ?>
                </ul>

            </div>
        </li>

        <?php
    }
    ?>
</ul>


<!-- The Modal -->
<div id="myModal" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>Answer the question:</h2>
        <form method="post" action="?action=answerProblem">
            <input type="text" name="id" value="" hidden>
            <textarea placeholder="Answer to the message here." rows="12" cols="110" name="response" id="response"
                      required></textarea> <br/>
            <input type="submit" class="buttonbis" value="Send">
        </form>
    </div>

</div>

<div id="myModalclose" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>Problem has been set on "done" successfully.</h2>
        <button class="buttonbis" id="closebutton">Ok</button>
    </div>

</div>

<div id="myModalanswer" class="modal">

    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">&times;</span>
        <h2>Your answer has been sent successfully.</h2>
        <button class="buttonbis" id="answerbutton">Ok</button>
    </div>

</div>

<script>


    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    $('.button').on('click', function () {
        modal.style.display = "block";
    });

    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

</body>
</html>
