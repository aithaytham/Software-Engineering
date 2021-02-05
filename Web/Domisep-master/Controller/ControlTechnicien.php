<?php

namespace Domisep\Controller;


use Domisep\Auth\Authentication;
use Domisep\Auth\ModelUser;
use Domisep\Config\Config;
use Domisep\Model\ModelProblem;

class ControlTechnicien
{

    public static function account_tech() {
        require(Config::getVues()['account_tech']);
    }

    public static function getProblems() {
        return ModelProblem::getProblems();
    }

    public static function closeProblem() {
        ModelProblem::closeProblem($_POST);
        require(Config::getVues()['technicienAuth']);
        echo("<script src='Vues/problem_close.js'></script>");
    }

    public static function answerProblem() {
        require(Config::getVues()['technicienAuth']);
        echo("<script src='Vues/problem_answer.js'></script>");
    }

    public static function getTechnicien()
    {
        return ModelUser::getTechnicien($_SESSION["user"]["id"]);
    }

    public static function getVilleTechnicien($id)
    {
        return ModelUser::getVilleTechnicien($id);
    }

    public static function logout()
    {
        Authentication::disconnection();
        //Changement de l'action
        require(Config::getVues()['default']);
    }




}