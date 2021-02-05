<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 21/01/18
 * Time: 15:39
 */

namespace Domisep\Model;


use Domisep\Config\Config;
use Domisep\Persistance\DAL\CapteurGateway;

class ModelCapteur
{

    public static function createSensor($inputArray){
        $gw = new CapteurGateway(Config::createConnection());
        return $gw->createSensor($inputArray);
    }

    public static function getSensors()
    {
        $gw = new CapteurGateway(Config::createConnection());
        return $gw->getSensors();
    }

    public static function getLights($inputArray)
    {
        echo "modelCaptuer";
        $gw = new CapteurGateway(Config::createConnection());
        return $gw->getLights($inputArray);
    }

}