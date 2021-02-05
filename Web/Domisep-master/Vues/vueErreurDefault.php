<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['error']); ?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Domisep error</title>
</head>
<body>
<?php include("header.php") ?>

<div class="container">
    <h1 class="title">Oops.. an error occured.</h1>
    <br/>

    <?php foreach ($dataError as $e) { ?>

        <p><?php echo $e ?></p><br/>

    <?php } ?>

    <button onclick="goBack()" class="submit">Go Back</button>

</div>

<script>
    function goBack() {
        window.history.back();
    }
</script>

</body>

</html>