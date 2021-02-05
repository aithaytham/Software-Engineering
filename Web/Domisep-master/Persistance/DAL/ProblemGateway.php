<?php

namespace Domisep\Persistance\DAL;

use Domisep\Auth\ModelUser;
use Domisep\Config\Config;
use Domisep\Persistance\Connection;

class ProblemGateway
{
    private $dbcon;

    public function __construct(Connection $con)
    {
        $this->dbcon = $con;
    }

    public function getAllProblems()
    {
        $query = 'SELECT * FROM probleme ORDER BY date DESC';
        $res = $this->dbcon->prepareAndExecuteQuery($query);
        if (!$res) {
            return $res;
        }
        return $this->dbcon->getResults();
    }

    public function createproblem($inputArray)
    {
        $client = ModelUser::getClient($_SESSION['user']['id']);
        $query = 'INSERT INTO probleme(id_client, nom, prenom, email, sujet, message) VALUES(:idclient,:nom,:prenom,:email,:sujet,:message)';
        $tab = array(
            ':idclient' => array($client['id'], \PDO::PARAM_STR),
            ':nom' => array($inputArray['nom'], \PDO::PARAM_STR),
            ':prenom' => array($inputArray['prenom'], \PDO::PARAM_STR),
            ':email' => array($inputArray['email'], \PDO::PARAM_STR),
            ':sujet' => array($inputArray['sujet'], \PDO::PARAM_STR),
            ':message' => array($inputArray['message'], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
            return $res;
        }
        return $res;
    }

    public function answerProblem($inputArray)
    {
        $query = 'UPDATE probleme SET etat = :viewed WHERE id = :id';
        $tab = array(
            ':viewed' => array('viewed', \PDO::PARAM_STR),
            ':id' => array($inputArray['id'], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Problem does not exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
            return $res;
        }
        return $res;
    }

    public function closeProblem($inputArray)
    {
        $query = 'UPDATE probleme SET etat = :done WHERE id = :id';
        $tab = array(
            ':done' => array('done', \PDO::PARAM_STR),
            ':id' => array($inputArray['id'], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Problem does not exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
            return $res;
        }
        return $res;
    }

}