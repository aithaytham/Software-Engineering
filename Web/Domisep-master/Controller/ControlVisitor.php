<?php

namespace Domisep\Controller;


use Domisep\Auth\Authentication;
use Domisep\Auth\ModelUser;
use Domisep\Auth\ValidationRequest;
use Domisep\Config\Config;

class ControlVisitor
{
    public static function register()
    { // Vue d'inscription
        require(Config::getVues()["pageRegister"]);
    }

    public static function authenticate()
    { // Vue d'authentification
        require(Config::getVues()["pageAuth"]);
    }

    public static function validateRegister() // Validation d'inscription
    {
        global $dataError;
        // Récupération du tableau d'erreurs, de l'email et du mdp (par référence).
        if ($_POST["password"] != $_POST["confirm_password"]) {
            $dataError["password"] = "Passwords différents";
        }
        $email = $_POST['email'];
        $password = $_POST['password'];
        // + filtrage
        //ValidationRequest::validationLogin($dataError, $email, $password);
        // Si e-mail et mot de passe de la bonne forme :
        if (empty($dataError)) {
            ModelUser::createUser($dataError, $_POST);
            ModelUser::createClient($dataError, $_POST);
            // Si la requête a fonctionné :
            if (empty($dataError)) {
                $role = Authentication::checkAndInitiateSession($email, $password, $dataError);
                // Si l'authentification du nouvel utilisateur a fonctionné :
                if (empty($dataError)) {
                    if ($role === "admin") {
                        require(Config::getVues()["admin"]);
                    } else if ($role === "client") {
                        require(Config::getVues()["clientAuth"]);
                    }
                    else if ($role === "technicien") {
                        require(Config::getVues()["technicienAuth"]);
                    }
                    else if ($role === "promotteur") {
                        require(Config::getVues()["promoteurAuth"]);
                    }
                    else if ($role === "entite_geographique") {
                        require(Config::getVues()["entiteGeographiqueAuth"]);
                    }
                } else {
                    require(Config::getVuesErreur()['default']);
                }
            } // Echec de la requête de création de l'utilisateur
            else {
                // Affiche la page d'erreur par défaut
                require(Config::getVuesErreur()['default']);
                echo "<script src='Vues/error_signup.js'></script>";
            }
        } // E-mail & mot de passe invalides, on affiche les erreurs, puis on affiche le formulaire
        else {
            require(Config::getVues()["default"]);
            echo "<script src='Vues/error_signup.js'></script>";
        }
    }

    /**
     * @brief à partir des données passées en POST, vérifie les identifiants
     * de l'utilisateur, créée la session de cet utilisateur et le redirige vers
     * la page d'accueil en tant qu'utilisateur connecté.
     */
    public static function validateAuth()
    { // Valider l'authentification

        global $dataError;
        // Les données seront filtrées par PDO::prepare()
        $email = $_POST['email'];
        $password = $_POST['password'];
        $role = Authentication::checkAndInitiateSession($email, $password, $dataError);
        $_SESSION['user'] = ModelUser::getUser($dataError, $email, hash("sha512", $password));
        // Si pas d'erreur
        if (empty($dataError)) {
            if ($role === "admin") {
                require(Config::getVues()["adminAuth"]);
            } else if ($role === "client") {
                require(Config::getVues()["session"]);
            }
            else if ($role === "technicien") {
                require(Config::getVues()["technicienAuth"]);
            }
            else if ($role === "promotteur") {
                require(Config::getVues()["promoteurAuth"]);
            }
            else if ($role === "entite_geographique") {
                require(Config::getVues()["entiteGeographiqueAuth"]);
            }
        } else {
            // On affiche la page d'authentification, avec les erreurs.
            $dataError['login'] = 'Identifiant ou mot de passe incorrect';
            require(Config::getVues()["default"]);
            echo "<script src='Vues/error_login.js'></script>";
        }
    }
}

