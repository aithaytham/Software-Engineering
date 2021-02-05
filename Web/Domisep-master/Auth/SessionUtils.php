<?php

namespace Domisep\Auth;
/** @brief Gère le cycle de vie de la session (Identification utilisateur)
 * génère des SID aléatoires, crée et met à jour le cookie pour le SID */
class SessionUtils
{
    /** Durée du cookie en secondes */
    const DUREE_COOKIE = 120;

    /** @brief fonction de génération de l'ID de session aléatoire */
    public static function generateSessionId()
    {
        // Génération de 10 octets (pseudo-)aléatoires codés en hexa
        $cryptoStrong = false; // Variable pour le passage par référence
        $octets = openssl_random_pseudo_bytes(10, $cryptoStrong);
        $mySid = bin2hex($octets);
        return $mySid;
    }

    /** Création d'une session de SID aléatoire avec l'e-mail (login unique)
     * @param $email string e-mail servant de login (identifiant unique de l'utilisateur)
     * @param $role string rôle de l'utilisteur (admin, visiteur, gestionnaire...)
     * (voir le chapitre sur le Front Controller) **/
    public static function createSession($email, $role = "visitor")
    {
        // Dans le cas improbable d'une collision sur le SID,
        // Mais surtout d'une usurpation d'identité, on détruit la session
        // avant de redémarrer une session vide
        session_start();
        session_destroy();
        // Le numéro de session aléatoire
        $mySid = self::generateSessionId();
        session_id($mySid);
        // Destruction du cookie avant de le recréer
        //setcookie("session-id", "", time() - 60, '/');
        // Création du cookie avec SID aléatoire. Validité du cookie : 2mn
        // Un pirate aura besoin de temps pour voler le cookie...
        //setcookie("session-id", $mySid, time() + self::DUREE_COOKIE, '/');
        // Démarrage de la session
        session_start();
        // On échappe, même si on sait qu'on a validé l'adresse e-mail....
        $_SESSION['email'] = htmlentities($email, ENT_QUOTES, "UTF-8");
        $_SESSION['role'] = htmlentities($role, ENT_QUOTES, "UTF-8");
        $_SESSION['ipAddress'] = $_SERVER['REMOTE_ADDR'];
    }

    /** Destruction d'une session
     **/
    public static function endSession()
    {
        // On supprime le cookie de session en lui affectant une date passée
        session_unset();     // unset $_SESSION variable for the run-time
        session_destroy();   // destroy session data in storage
        // Il faut réappeler session_start() pour accéder de nouveau aux variables de session
        setcookie(session_name(),'',time()-1); // deletes the session cookie containing the session ID
    }
}

?>
