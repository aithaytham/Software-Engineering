<?php $stores=array(); ?>


<div class="screen" id="sun_screen">
    <ul class="tempList">

        <?php foreach ($stores as $s) { ?>

        <li class="liStore ">
            <div class="store active">
                <img class="icon" src="<?= Domisep\Config\Config::getResources()['store'] ?> "/>
            </div>
            <div id="active1" class="divStore">
            </div>
            <label class="labelStore">Store <?php echo $s["id"] ?></label>
        </li>

        <?php } ?>

    </ul>
</div>