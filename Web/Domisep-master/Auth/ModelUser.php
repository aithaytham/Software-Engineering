<?php


namespace Domisep\Auth;
use Domisep\Config\Config;

/** @brief Classe Modèle pour les données de l'utilisateur
 * e-mail (qui sert ici de login), rôle (visiteur, admin, etc.)
 * Les données peuvent venir d'une session ou d'un accès à la BD. */
class ModelUser
{

    /** @brief Donne le role de l'utilisateur si il existe dans la base
     * @param $email string e-mail de l'utilisateur servant d'ID unique
     * @param $hashedPassword string mot de passe après hashage.
     * @return mixed Role de l'utilisateur ou false si le user n'existe pas dans la base
     * ou si problème avec la base.*/
    public static function getRoleUser(&$dataError, $email, $hashedPassword)
    {
        $gw = new UserGateway(Config::createConnection());
        // Appel de la couche d'accès aux données :
        $user = $gw->getUser($dataError, $email, $hashedPassword);
        // Si le couple login/password n'existe pas en base :
        if ($user === false) {
            return false;
        }
        if (empty($user)) {
            $dataError['login'] = "Invalid login or password.";
            return false;
        }
        return $user[0]['role'];
    }

    public static function getUser(&$dataError, $email, $hashedPassword)
    {
        $gw = new UserGateway(Config::createConnection());
        // Appel de la couche d'accès aux données :
        $user = $gw->getUser($dataError, $email, $hashedPassword);
        if ($user === false) {
            return false;
        }
        if (empty($user)) {
            $dataError['login'] = "Invalid login or password.";
            return false;
        }
        return $user[0];
    }

    public static function getClient($id_user)
    {
        $gw = new UserGateway(Config::createConnection());
        // Appel de la couche d'accès aux données :
        $user = $gw->getClient($id_user);
        if ($user === false) {
            return false;
        }
        if (empty($user)) {
            $dataError['login'] = "Invalid login or password.";
            return false;
        }
        return $user[0];
    }

    public static function getTechnicien($id_user)
    {
        $gw = new UserGateway(Config::createConnection());
        // Appel de la couche d'accès aux données :
        $user = $gw->getTechnicien($id_user);
        if ($user === false) {
            return false;
        }
        if (empty($user)) {
            $dataError['login'] = "Invalid login or password.";
            return false;
        }
        return $user[0];
    }

    public static function getVilleTechnicien($id)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->getVilleTechnicien($id);
    }

    public static function getVilles() {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->getVilles();
    }

    public static function getSessions() {
        $gw = new UserGateway(Config::createConnection());
        return $gw->getSessions();
    }

    public static function checkSession($id, $password)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->checkSession($id, $password);
    }




    /** @brief Créée un nouvel utilisateur
     * @param $inputArray array Tableau d'entrée contenant les données d'un user
     * @return bool contenant les données du nouveau user
     */
    public static function createUser(&$dataError, $inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createUser($dataError, $inputArray);
    }

    public static function createUserT($inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createUserT($inputArray);
    }

    public static function createUserS($inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createUserS($inputArray);
    }

    public static function createUserE($inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createUserE($inputArray);
    }

    public static function createClient(&$dataError, $inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createClient($dataError, $inputArray);
    }

    public static function createTechnicien($inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createTechnicien($inputArray);
    }

    public static function createSponsor($inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createSponsor($inputArray);
    }

    public static function createEntity($inputArray)
    {
        $gw = new UserGateway((Config::createConnection()));
        return $gw->createEntity($inputArray);
    }

   public static function createSession($inputArray)
   {
       $gw = new UserGateway((Config::createConnection()));
       return $gw->createSession($inputArray);
   }


}

?>

