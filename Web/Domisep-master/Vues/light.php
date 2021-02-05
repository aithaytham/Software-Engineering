<?php $lights=\Domisep\Controller\ControlVisitorAuth::getLights(); ?>
<?php echo "page light" ?>

<div class="screen" id="light_screen">
    <ul class="list_light">
        <?php echo "test test";
        foreach ($lights as $l) { ?>

        <li class="light">
            <img class="lightImg" src="<?= Domisep\Config\Config::getResources()['ampoule_marine'] ?>"/>
            <h3>light <?php echo $l["id"] ?> </h3>
        </li>

        <?php}?>
    </ul>
</div>
