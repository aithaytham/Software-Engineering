<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 21/01/18
 * Time: 14:50
 */

namespace Domisep\Persistance\DAL;


use Domisep\Auth\ModelUser;
use Domisep\Model\ModelHome;
use Domisep\Persistance\Connection;

class RoomGateway
{

    private $dbcon;

    public function __construct(Connection $con)
    {
        $this->dbcon = $con;
    }

    public function getRoomByName($inputArray)
    {
        echo " getRoomByName ";
        $maison = ModelHome::getHomeId(ModelUser::getClient($_SESSION["user"]["id"]));
        $query = 'SELECT * FROM salle WHERE id_type=:idtype AND id_maison=:idmaison';
        $tab = array(
            ':idtype' => array($inputArray["roomSelect"], \PDO::PARAM_STR),
            ':idmaison' => array($maison["id"], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query);

        if (!$res) {
            return $res;
        }
        return $this->dbcon->getResults();
    }

    public function getRooms()
    {
        $query = 'SELECT * FROM type_salle ORDER BY nom';
        $res = $this->dbcon->prepareAndExecuteQuery($query);
        if (!$res) {
            return $res;
        }
        return $this->dbcon->getResults();
    }

    public function createRoom($inputArray)
    {
        $query = 'INSERT INTO type_salle(nom) VALUES(:nom)';
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



}