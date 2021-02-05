<?= Domisep\Vues\VueHtmlUtils::cssHTML5(\Domisep\Config\Config::getStyleSheetsURL()['stats']); ?>


<html>
  <head>
    <script src="/Domisep/Vues/js_stats.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <meta charset="UTF-8">
  </head>

  <body onload="loadCharts()">
  <?php include("header_connect.php") ?>

    <div class="containerButton">
      <button class="buttonRoom">Change room</button>
    </div>

    <div class="line">
      <div class="container_charts" id="containerGraphTempHumi"></div>

      <ul class="list_statIcon" >
        <li class="statIcon">
          <img class="img_statIcon" src="<?= Domisep\Config\Config::getResources()['thermometer'] ?>"></img>
          <label class="label_statIcon">22.3 °C</label>
        </li>

        <li class="statIcon">
          <img class="img_statIcon" src="<?= Domisep\Config\Config::getResources()['sun'] ?>"></img>
          <label class="label_statIcon">36 Su</label>
        </li>

        <li class="statIcon">
          <img class="img_statIcon" style="width:4.5vw" src="<?= Domisep\Config\Config::getResources()['drop'] ?>"></img>
          <label class="label_statIcon">4.3 %</label>
        </li>
      </ul>

      <div class="container_charts" id="containerConso"></div>
    </div>

    <div class="line">
      <div class="alarmIcon">
        <img class="img_alarmIcon" src="<?= Domisep\Config\Config::getResources()['alarm'] ?>"></img>
        <label class="label_alarmIcon">2</label>
      </div>

        <div class="container_charts" id="containerluminosité"></div>


    </div>




  </body>

</html>
