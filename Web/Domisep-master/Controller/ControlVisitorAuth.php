<?php

namespace Domisep\Controller;

use Domisep\Auth\Authentication;
use Domisep\Auth\ModelUser;
use Domisep\Config\Config;
use Domisep\Model\ModelCapteur;
use Domisep\Model\ModelHome;
use Domisep\Model\ModelProblem;
use Domisep\Model\ModelRoom;

class ControlVisitorAuth
{
    public static function stats()
    {
        require(Config::getVues()['stats']);
    }

    public static function account()
    {
        require(Config::getVues()['account']);
    }


    public static function assistance()
    {
        require(Config::getVues()['assistance']);
    }

    public static function problemContact()
    {
        ModelProblem::createProblem($_POST);
        require(Config::getVues()['assistance']);
        echo("<script src='Vues/problem_send.js'></script>");
    }

    public static function checkSession()
    {
        $password = $_POST["one"] . $_POST["two"] . $_POST["three"] . $_POST["four"];
        $sess = ModelUser::checkSession($_POST["idsess"], $password);
        if (!$sess) {
            require(Config::getVues()["session"]);
        } else {
            $_SESSION["session"] = $sess[0];
            require(Config::getVues()['clientAuth']);
        }
    }

    public static function getRooms()
    {
        return ModelRoom::getRooms();
    }

    public static function getClient()
    {
        return ModelUser::getClient($_SESSION["user"]["id"]);
    }

    public static function addHome()
    {
        ModelHome::createHome($_POST);
        require(Config::getVues()["account"]);
        echo("<script src='Vues/add_modal.js'></script>");

    }

    public static function createSession()
    {
        if (empty($_POST["p"]) || empty($_POST["a"]) || empty($_POST["s"]) || empty($_POST["ss"]) || empty($_POST["name"])) {
            require(Config::getVues()["session"]);
        } else {
            ModelUser::createSession($_POST);
            require(Config::getVues()["session"]);
        }
    }

    public static function getHomes()
    {
        return ModelHome::getHomes();
    }

    public static function getSessions()
    {
        return ModelUser::getSessions();
    }

    public static function getSensors()
    {
        switch ($_POST["sensorType"]) {

            case "1":
                include(Config::getVues()["clientAuth"]);
                break;
            case "2":
                include(Config::getVues()["clientAuth"]);
                break;
            case "3":
                include(Config::getVues()["clientAuth"]);
                break;
            case "4":
                include(Config::getVues()["clientAuth"]);
                break;
        }
    }

    public static function getLights()
    {
        echo "control";
        return ModelCapteur::getLights($_POST);
    }

    public static function logout()
    {
        Authentication::disconnection();
        //Changement de l'action
        require(Config::getVues()['default']);
    }




}