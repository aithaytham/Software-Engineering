<?php

namespace Domisep\Auth;

/** @brief Validation des données de login/password reçues via $_REQUEST.
 * Nettoyage de toutes les chaînes.
 * Initialisation à vide des inputs inexistants */
class ValidationRequest
{
    /** @brief Nettoie une chaîne avec filter_var et FILTER_SANITIZE_STRING */
    public static function sanitizeString($chaine)
    {
        return isset($chaine) ? filter_var($chaine, FILTER_SANITIZE_STRING) : "";
    }

    /** @brief Validation et initialisation des données du login/password
     * à partir des données reçues dans le tableau superglobal $_REQUEST.
     */
    public static function validationLogin(&$dataError, &$email, &$password)
    {
        // Test sur la forme des données de login et de mot de passe :
        $wouldBePasswd = $_POST['password'];
        if (empty($wouldBePassword)) {
            $password = "";
            $dataError['password'] = "Invalid password.";
        } else {
            $password = $wouldBePasswd;
        }
        if (filter_var($_POST['email'], FILTER_VALIDATE_EMAIL) == FALSE) {
            $email = "";
            $dataError['login'] = "Invalid mail adress.";
        } else {
            $email = $_POST["email"];
        }
    }
}

?>
