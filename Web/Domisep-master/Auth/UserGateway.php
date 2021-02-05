<?php

namespace Domisep\Auth;

use Domisep\Persistance\Connection;

/** @brief Permet d'accéder et de mettre à jour les données de la table User
 * dans la base de données (au moins les opérations CRUD). */
class UserGateway
{
    private $dbcon;

    public function __construct(Connection $con)
    {
        $this->dbcon = $con;
    }

    /** @brief Permet d'obtenir un utilisateur à partir de son login et son mot de passe.
     * Renvoie false si echec lors de l'authentification
     * @param $dataError array Tableau d'erreur
     * @param $login string Identifiant de l'utilisateur sur le site
     * @param $hashedPassword string Mot de passe de l'utilisateur crypté
     * @return mixed Array vide si identifiants invalide, données de l'utilisteur sinon
     */
    public function getUser(&$dataError, $login, $hashedPassword)
    {
        $query = 'SELECT * FROM user WHERE email=:login AND password=:password';
        $tab = array(
            ':login' => array($login, \PDO::PARAM_STR),
            ':password' => array($hashedPassword, \PDO::PARAM_STR)
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong login or password.";
            return $res;
        }
        return $this->dbcon->getResults();
    }

    /**@brief Permet de retourner le client grâce à l'id utilisateur
     * @param $user_id
     * @return bool|mixed
     */
    public function getClient($user_id)
    {
        $query = 'SELECT * FROM client WHERE id_user=:userid';
        $tab = array(
            ':userid' => array($user_id, \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong login or password.";
            return $res;
        }
        return $this->dbcon->getResults();
    }

    /** Permet de retourner un technicien grace a son id user
     * @param $user_id
     * @return bool|mixed
     */
    public function getTechnicien($user_id)
    {
        $query = 'SELECT * FROM technicien WHERE id_user=:userid';
        $tab = array(
            ':userid' => array($user_id, \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong login or password.";
            return $res;
        }
        return $this->dbcon->getResults();
    }

    /** Retourne la ville d'un technicien
     * @param $id
     * @return bool|mixed
     */
    public function getVilleTechnicien($id)
    {
        $query = 'SELECT * FROM ville WHERE id=:ville_id';
        $tab = array(
            ':ville_id' => array($id, \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong city id";
            return $res;
        }
        return $this->dbcon->getResults();
    }

    /** retourne l'id d'une ville par son nom
     * @param $nom
     * @return bool|mixed
     */
    public function getVilleId($nom) {
        $query = 'SELECT id FROM ville WHERE nom=:ville_nom';
        $tab = array(
            ':ville_nom' => array($nom, \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong city id";
            return $res;
        }
        return $this->dbcon->getResults();
    }

    /**Récupère l'id d'un utilisateur par son login. Deprecated utiliser $_session.
     * @param $dataError
     * @param $login
     * @return bool|mixed
     */
    public function getUserId(&$dataError, $login)
    {
        $query = 'SELECT * FROM user WHERE email=:login';
        $tab = array(
            ':login' => array($login, \PDO::PARAM_STR)
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong login or password.";
            echo "error";
            return $res;
        }
        return $this->dbcon->getResults();
    }

    /**
     * @param $dataError
     * @param $login
     * @return bool|mixed
     */
    public function getUserSessions(&$dataError, $login) {
        $query = 'SELECT * FROM user WHERE email=:login';
        $tab = array(
            ':login' => array($login, \PDO::PARAM_STR)
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong login or password.";
            return $res;
        }
        return $this->dbcon->getResults();
    }



    // SESSIONS

    /**
     * @param $dataError
     * @param $login
     * @return bool|mixed
     */
    public function getSessions() {
        $client = $this->getClient($_SESSION["user"]["id"]);
        $query = 'SELECT * FROM sessions WHERE id_client=:id';
        $tab = array(
            ':id' => array($client[0]["id"], \PDO::PARAM_STR)
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong login or password.";
            return $res;
        }
        return $this->dbcon->getResults();
    }

    /** Check si le password entré correspond à celui de la session en bdd.
     * @param $password
     */
    public function checkSession($id, $password)
    {
        $query = 'SELECT * FROM sessions WHERE id=:id AND password=:pass';
        $tab = array(
            ':id' => array($id, \PDO::PARAM_STR),
            ':pass' => array($password, \PDO::PARAM_STR)
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Wrong login or password.";
            return $res;
        }
        return $this->dbcon->getResults();
    }


    //  VILLES

    /**
     * @return bool|mixed
     */
    public function getVilles()
    {
        $query = 'SELECT * FROM ville ORDER BY nom';
        $res = $this->dbcon->prepareAndExecuteQuery($query);
        if (!$res) {
            return $res;
        }
        return $this->dbcon->getResults();
    }


    // CREATION


    /** @brief Créée un utilisateur dans la BD
     * @param $dataError array Tableau d'erreurs à remplir en cas de besoin
     * @param $inputArray array Tableau d'entrée contenant un login (e-mail), un mot de passe, et un rôle
     * @return bool
     */
    public function createUser(&$dataError, $inputArray)
    {
        $inputArray['password'] = hash("sha512", $inputArray['password']);
        $query = 'INSERT INTO user(email, password) VALUES(:email,:password)';
        $tab = array(
            ':email' => array($inputArray['email'], \PDO::PARAM_STR),
            ':password' => array($inputArray['password'], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
        }
        return $res;
    }

    /**
     * @param $inputArray
     * @return bool
     */
    public function createUserT($inputArray)
    {
        $inputArray['password'] = hash("sha512", $inputArray['password']);
        $query = 'INSERT INTO user(email, password, role) VALUES(:email,:password,"technicien")';
        $tab = array(
            ':email' => array($inputArray['email'], \PDO::PARAM_STR),
            ':password' => array($inputArray['password'], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
        }
        return $res;
    }

    /**
     * @param $inputArray
     * @return bool
     */
    public function createUserS($inputArray)
    {
        $inputArray['password'] = hash("sha512", $inputArray['password']);
        $query = 'INSERT INTO user(email, password, role) VALUES(:email,:password,"promotteur")';
        $tab = array(
            ':email' => array($inputArray['email'], \PDO::PARAM_STR),
            ':password' => array($inputArray['password'], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
        }
        return $res;
    }

    /**
     * @param $inputArray
     * @return bool
     */
    public function createUserE($inputArray)
    {
        $inputArray['password'] = hash("sha512", $inputArray['password']);
        $query = 'INSERT INTO user(email, password, role) VALUES(:email,:password, "entite_geographique")';
        $tab = array(
            ':email' => array($inputArray['email'], \PDO::PARAM_STR),
            ':password' => array($inputArray['password'], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
            foreach ($dataError as $error) {
                echo $error . "<br/>";
            }
        }
        return $res;
    }

    /**
     * @param $dataError
     * @param $inputArray
     * @return bool
     */
    public function createClient(&$dataError, $inputArray)
    {
        $user = $this->getUserId($dataError, $inputArray["email"]);
        $query = 'INSERT INTO client(nom, prenom, id_user) VALUES(:nom,:prenom,:id)';
        $tab = array(
            ':nom' => array($inputArray['nom'], \PDO::PARAM_STR),
            ':prenom' => array($inputArray['prenom'], \PDO::PARAM_STR),
            ':id' => array($user[0]["id"], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
        }
        return $res;
    }

    /**
     * @param $inputArray
     * @return bool
     */
    public function createTechnicien($inputArray)
    {
        $user = $this->getUserId($dataError, $inputArray["email"]);
        $ville = $this->getVilleId($inputArray["ville"]);
        $query = 'INSERT INTO technicien(nom, prenom, id_user, id_ville) VALUES(:nom,:prenom,:id,:idville)';
        $tab = array(
            ':nom' => array($inputArray['nom'], \PDO::PARAM_STR),
            ':prenom' => array($inputArray['prenom'], \PDO::PARAM_STR),
            ':id' => array($user[0]["id"], \PDO::PARAM_STR),
            ':idville' => array($ville[0]["id"], \PDO::PARAM_STR),

        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
        }
        return $res;

    }

    /**
     * @param $inputArray
     * @return bool
     */
    public function createSponsor($inputArray)
    {
        $user = $this->getUserId($dataError, $inputArray["email"]);
        $query = 'INSERT INTO promotteur(nom, id_user) VALUES(:nom,:id)';
        $tab = array(
            ':nom' => array($inputArray['nom'], \PDO::PARAM_STR),
            ':id' => array($user[0]["id"], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
        }
        return $res;
    }

    /**
     * @param $inputArray
     * @return bool
     */
    public function createEntity($inputArray)
    {
        $user = $this->getUserId($dataError, $inputArray["email"]);
        $ville = $this->getVilleId($inputArray["ville"]);
        $query = 'INSERT INTO entite_geographique(nom, id_user, id_ville) VALUES(:nom,:id,:idville)';
        $tab = array(
            ':nom' => array($inputArray['nom'], \PDO::PARAM_STR),
            ':id' => array($user[0]["id"], \PDO::PARAM_STR),
            ':idville' => array($ville[0]["id"], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
        }
        return $res;
    }

    public function createSession($inputArray)
    {
        $pass = $inputArray["p"].$inputArray["a"].$inputArray["s"].$inputArray["ss"];
        $client = ModelUser::getClient($_SESSION['user']['id']);
        $query = 'INSERT INTO sessions(nom, password, id_client) VALUES(:nom,:pass,:id)';
        $tab = array(
            ':nom' => array($inputArray['name'], \PDO::PARAM_STR),
            ':pass' => array($pass, \PDO::PARAM_STR),
            ':id' => array($client["id"], \PDO::PARAM_STR),
        );
        $res = $this->dbcon->prepareAndExecuteQuery($query, $tab);
        if (!$res) {
            $dataError['persistance'] = "Query could not be executed. Email may already exist.";
        }
        return $res;
    }


}

?>