<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 21/01/18
 * Time: 15:38
 */

namespace Domisep\Persistance\DAL;


use Domisep\Model\ModelRoom;
use Domisep\Persistance\Connection;

class CapteurGateway
{

    private $dbcon;

    public function __construct(Connection $con)
    {
        $this->dbcon = $con;
    }

    public function getSensors()
    {
        $query = 'SELECT * FROM type_capteur ORDER BY nom';
        $res = $this->dbcon->prepareAndExecuteQuery($query);
        if (!$res) {
            return $res;
        }
        return $this->dbcon->getResults();
    }

    public function createSensor($inputArray)
    {
        $query = 'INSERT INTO type_capteur(nom) VALUES(:nom)';
        $tab = array(
            ':nom' => array($inputArray["nom"], \PDO::PARAM_STR)
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Type may already exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
            return $res;
        }
        return $res;
    }

    public function getLights($inputArray)
    {
        echo "gwcapteur";
        $salle = ModelRoom::getRoomByName($inputArray);
        echo $salle;
        $query = 'SELECT * FROM capteur WHERE type=:idtype AND id_salle=:salle';
        $tab = array(
            ':idtype' => array($inputArray["sensorType"], \PDO::PARAM_STR),
            ':salle' => array($salle[0]["id"], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Type may already exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
            return $res;
        }
        return $this->dbcon->getResults();
    }


}