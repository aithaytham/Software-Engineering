<?php

namespace Domisep\Controller;

use Domisep\Auth\SessionHandler;
use Domisep\Config\Config;
use Domisep\Config\Sanitize;

/**
 * @brief Identifie l'action et le rôle de l'utilisateur.
 * Dans le cas où l'utilisateur a des droits insuffisants pour l'action,
 * le frontController affiche une vue d'authentification ou une vue d'erreur.
 * Sinon, frontController instancie le contrôleur adapté pour les rôles et actions
 * de l'utilisateur
 * Il gère aussi les exceptions et appelle, le cas échéant, une vue d'erreur.
 */
class FrontController
{
    /**
     * @brief C'est dans le constructeur que le front fait son travail.
     */
    function __construct()
    {
        try {
            // L'utilisateur est il identifié ?
            $sess = SessionHandler::getInstance();

            // Récupération de l'action
            $action = Sanitize::sanitizeItem($_REQUEST['action'], "string");


            // On distingue des cas d'utilisation, suivant l'action
            switch ($action) {

                // 1) actions accessibles à tout le monde


                case "index":
                    require(Config::getVues()["default"]);
                    break;

                case "login": // Vue de saisie du login/password
                    require(Config::getVues()["pageAuth"]);
                    //ControlVisitor::authenticate();
                    break;

                case "contact"://Vue formulaire de contact
                    if (!$_SESSION["user"]) {
                        require(Config::getVues()["contact"]);
                    } else {
                        $dataError["contact"] = "You are logged in, please use the assistance form.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "validateLogin": // Validation du login/password
                    ControlVisitor::validateAuth();
                    break;

                case "register": // Vue de création d'un compte utilisateur
                    ControlVisitor::register();
                    break;

                case "validateRegister": // Validation de la création d'un compte utilisateur
                    ControlVisitor::validateRegister();
                    break;

                case "logout": // Se déconnecter
                    ControlVisitorAuth::logout();
                    break;

                // 2) actions accessibles aux clients authentifiés


                case "visitorAuth": //Vue accueil client authentifié
                    if ($_SESSION["user"]["role"] == "client" && $_SESSION["session"] != null) {
                        require(Config::getVues()["clientAuth"]);
                    } else {
                        require(Config::getVues()["default"]);
                    }
                    break;

                case "stats": //Vue statistiques client
                    if ($_SESSION["user"]["role"] == "client" && $_SESSION["session"] != null) {
                        ControlVisitorAuth::stats();
                    } else {
                        $dataError["stats"] = "You are not logged in, please sign in to access statistics.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "checkSession": //Validation des droits pour pages Clients
                    ControlVisitorAuth::checkSession();
                    break;

                case "createSession": //Ajout d'une session client
                    ControlVisitorAuth::createSession();
                    break;

                case "account": //Vue "mon compte"
                    if ($_SESSION["user"]["role"] == "client" && $_SESSION["session"] != null) {
                        ControlVisitorAuth::account();
                    } else {
                        $dataError["account"] = "You are not logged in, please sign in to access account.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "assistance":
                    if ($_SESSION["user"]["role"] == "client") {
                        ControlVisitorAuth::assistance();
                    } else {
                        $dataError["assistance"] = "You are not logged in, please sign in to access assistance.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "problemContact":
                    if ($_SESSION["user"]["role"] == "client") {
                        ControlVisitorAuth::problemContact();
                    } else {
                        $dataError["assistance"] = "You are not logged in, please sign in to access assistance.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "addHome":
                    if ($_SESSION["user"]["role"] == "client" && $_SESSION["session"] != null) {
                        ControlVisitorAuth::addHome();
                    } else {
                        $dataError["home"] = "You are not logged in, please sign in to add homes.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "getSensors":
                    if ($_SESSION["user"]["role"] == "client" && $_SESSION["session"] != null) {
                        ControlVisitorAuth::getSensors();
                    } else {
                        $dataError["home"] = "You are not logged in, please sign in to see sensors.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;


                // 3) actions accessibles aux techniciens authentifiés


                case "technicienAuth": //Vue accueil technicien authentifié
                    if ($_SESSION["user"]["role"] == "technicien") {
                        require(Config::getVues()["technicienAuth"]);
                    } else {
                        $dataError["technicien"] = "Only technicians can access this page, please sign in.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "account_tech": //Vue "mon compte Technicien"
                    if ($_SESSION["user"]["role"] == "technicien") {
                        ControlTechnicien::account_tech();
                    } else {
                        $dataError["technicien"] = "Only technicians can access this page, please sign in.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "answerProblem": //Réponse à un problème Client
                    if ($_SESSION["user"]["role"] == "technicien") {
                        ControlTechnicien::answerProblem();
                    } else {
                        $dataError["technicien"] = "Only technicians can access this page, please sign in.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "closeProblem": //Cloture d'un problème Client
                    if ($_SESSION["user"]["role"] == "technicien") {
                        ControlTechnicien::closeProblem();
                    } else {
                        $dataError["technicien"] = "Only technicians can access this page, please sign in.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;


                // 4) actions accessibles aux promoteurs authentifiés


                // 5) actions accessibles aux entités géographiques authentifiés


                // 6) actions accessibles aux administrateurs authentifiés


                case "adminAuth": //Vue accueil admin authentifié
                    if ($_SESSION["user"]["role"] == "admin") {
                        require(Config::getVues()["adminAuth"]);
                    } else {
                        $dataError["admin"] = "You have not access to this page.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "account_admin": //Vue mon compte admin
                    if ($_SESSION["user"]["role"] == "admin") {
                        ControlAdmin::account_admin();
                    } else {
                        $dataError["admin"] = "You have not access to this page.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "addSensor": //Vue ajout d'un type de capteur
                    if ($_SESSION["user"]["role"] == "admin") {
                        ControlAdmin::addSensor();
                    } else {
                        $dataError["admin"] = "You have not access to this page.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "addTechnicien": //Vue création compte technicien
                    if ($_SESSION["user"]["role"] == "admin") {
                        ControlAdmin::addTechnicien();
                    } else {
                        $dataError["admin"] = "You have not access to this page.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "addSponsor": //Vue création compte promoteur
                    if ($_SESSION["user"]["role"] == "admin") {
                        ControlAdmin::addSponsor();
                    } else {
                        $dataError["admin"] = "You have not access to this page.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "addEntity": //Vue création compte entité géographique
                    if ($_SESSION["user"]["role"] == "admin") {
                        ControlAdmin::addEntity();
                    } else {
                        $dataError["admin"] = "You have not access to this page.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                case "addRoom": //Vue création d'un type de pièce
                    if ($_SESSION["user"]["role"] == "admin") {
                        ControlAdmin::addRoom();
                    } else {
                        $dataError["admin"] = "You have not access to this page.";
                        require(Config::getVuesErreur()["default"]);
                    }
                    break;

                // 7) pas d'action (premier appel)


                case NULL:
                    $this->Reinit();
                    break;

                // 8) action invalide


                default :
                    $dataError['error'] = "This page doesn't exist";
                    require(Config::getVuesErreur()["default"]);
            }
        } catch
        (\Exception $e) {
            global $dataError;
            require(Config::getVuesErreur()["default"]);
        }
    }

    function Reinit()
    {
        global $dataError;
        require(Config::getVues()["default"]);
    }
}

?>