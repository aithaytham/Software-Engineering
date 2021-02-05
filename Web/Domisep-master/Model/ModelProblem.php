<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 16/01/18
 * Time: 14:12
 */

namespace Domisep\Model;


use Domisep\Config\Config;
use Domisep\Persistance\DAL\ProblemGateway;

class ModelProblem
{
    public static function getProblems()
    {
        $gw = new ProblemGateway(Config::createConnection());
        return $gw->getAllProblems();
    }


    public static function createProblem($inputArray){
        $gw = new ProblemGateway(Config::createConnection());
        return $gw->createProblem($inputArray);
    }


    public static function answerProblem($inputArray) {
        $gw = new ProblemGateway(Config::createConnection());
        return $gw->answerProblem($inputArray);
    }


    public static function closeProblem($inputArray){
        $gw = new ProblemGateway(Config::createConnection());
        return $gw->closeProblem($inputArray);
    }
}