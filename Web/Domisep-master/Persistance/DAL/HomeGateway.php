<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 26/01/18
 * Time: 14:35
 */

namespace Domisep\Persistance\DAL;


use Domisep\Auth\ModelUser;
use Domisep\Persistance\Connection;

class HomeGateway
{

    private $dbcon;

    public function __construct(Connection $con)
    {
        $this->dbcon = $con;
    }

    public function createHome($inputArray)
    {
        $client = ModelUser::getClient($_SESSION["user"]["id"]);
        $query = 'INSERT INTO maison(nom, adresse, id_client) VALUES(:nom, :adresse, :client)';
        $tab = array(
            ':nom' => array($inputArray["nom"], \PDO::PARAM_STR),
            ':adresse' => array($inputArray["adresse"], \PDO::PARAM_STR),
            ':client' => array($client["id"], \PDO::PARAM_STR),
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

    public function getHomes()
    {

        $client = ModelUser::getClient($_SESSION["user"]["id"]);
        $query = 'SELECT nom FROM maison WHERE id_client = :client';
        $tab = array(
            ':client' => array($client["id"], \PDO::PARAM_STR),
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

    public function getHomeId($client)
    {
        $query = 'SELECT id FROM maison WHERE id_client = :client';
        $tab = array(
            ':client' => array($client["id"], \PDO::PARAM_STR),
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