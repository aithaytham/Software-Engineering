<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 21/01/18
 * Time: 14:49
 */

namespace Domisep\Model;


use Domisep\Config\Config;
use Domisep\Persistance\DAL\RoomGateway;

class ModelRoom
{
    public static function createRoom($inputArray){
        $gw = new RoomGateway(Config::createConnection());
        return $gw->createRoom($inputArray);
    }

    public static function getRooms()
    {
        $gw = new RoomGateway(Config::createConnection());
        return $gw->getRooms();
    }

    public static function getRoomByName($inputArray)
    {
        echo "modelroom";
        $gw = new RoomGateway(Config::createConnection());
        return $gw->getRoomByName($inputArray);
    }

}