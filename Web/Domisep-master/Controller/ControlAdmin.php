<?php

namespace Domisep\Controller;


use Domisep\Auth\ModelUser;
use Domisep\Config\Config;
use Domisep\Model\ModelCapteur;
use Domisep\Model\ModelRoom;

class ControlAdmin
{

    public static function account_admin() {
        require(Config::getVues()['account_admin']);
    }

    public static function getVilles()
    {
        return ModelUser::getVilles();
    }

    public static function getSensors()
    {
        return ModelCapteur::getSensors();
    }

    public static function addSensor()
    {
        ModelCapteur::createSensor($_POST);
        require(Config::getVues()["adminAuth"]);
        echo("<script src='Vues/add_modal.js'></script>");
    }

    public static function addTechnicien()
    {
        ModelUser::createUserT($_POST);
        ModelUser::createTechnicien($_POST);
        require(Config::getVues()["adminAuth"]);
        echo("<script src='Vues/add_modal.js'></script>");

    }

    public static function addSponsor()
    {
        ModelUser::createUserS($_POST);
        ModelUser::createSponsor($_POST);
        require(Config::getVues()["adminAuth"]);
        echo("<script src='Vues/add_modal.js'></script>");
    }

    public static function addEntity()
    {
        ModelUser::createUserE($_POST);
        ModelUser::createEntity($_POST);
        require(Config::getVues()["adminAuth"]);
        echo("<script src='Vues/add_modal.js'></script>");
    }

    public static function addRoom()
    {
        ModelRoom::createRoom($_POST);
        require(Config::getVues()["adminAuth"]);
        echo("<script src='Vues/add_modal.js'></script>");
    }


}