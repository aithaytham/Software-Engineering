<?php

namespace Domisep\Config;

use Domisep\Persistance\Connection;

/** @brief Classe de configuration
 * Donne accès aux paramètres spécifique concernant l'application
 * tels que les chemins vers les vues, les vues d'erreur, les hash
 * pour les ID de sessions, etc. */
class Config
{
    /** @brief Données nécessaires à la connexion à la base de données.
     * Les valeurs pourraient être initialisées à partir d'un fichier
     * de configuration séparé (require('configuration.php'))
     * pour faciliter la maintenance par le webmaster
     * @return string DSN
     */

    public static function getAuthData(&$db_host, &$db_name, &$db_user, &$db_password)
    {
        $db_host = "localhost";
        $db_name = "domisep";
        $db_user = "root";
        $db_password = "";
        return "mysql:host=$db_host;dbname=$db_name";
    }

    public static function createConnection()
    {
        return new Connection(Config::getAuthData($db_host, $db_name, $db_user, $db_passwd), $db_user, $db_passwd);
    }

    /** @brief retourne le tableau des (chemins vers les) Vues */
    public static function getVues()
    {
        // Racine du site
        global $rootDirectory;
        // Répertoire contenant les Vues
        $vueDirectory = $rootDirectory . "Vues/";
        return array(
            "default" => $vueDirectory . "index.php",
            "pageAuth" => $vueDirectory . "index.php",
            "contact" => $vueDirectory . "contact.php",
            "pageRegister" => $vueDirectory . "index.php",
            "clientAuth" => $vueDirectory . "interface.php",
            "admin" => $vueDirectory . "vueAdmin.php",
            "stats" => $vueDirectory . "stats.php",
            "account" => $vueDirectory . "account.php",
            "assistance" => $vueDirectory . "assistance.php",
            "session" => $vueDirectory . "session.php",
            "technicienAuth" => $vueDirectory . "interface_technicien.php",
            "account_tech" => $vueDirectory . "account_tech.php",
            "adminAuth" => $vueDirectory . "admin.php",
            "account_admin" => $vueDirectory . "account_admin.php",
            "light" => $vueDirectory . "light.php",
            "store" => $vueDirectory . "store.php"
        );
    }

    /** @brief retourne le tableau des (chemins vers les) Vues d'erreur */
    public static function getVuesErreur()
    {
        // Racine du site
        global $rootDirectory;
        // Répertoire contenant les Vues d'erreur
        $vueDirectory = $rootDirectory . "Vues/";
        return array(
            "default" => $vueDirectory . "vueErreurDefault.php"
        );
    }


    /** @brief retourne l'URI (sans le nom d'hôte du site et sans la query string)
     * du répertoire à la racine de notre architecture MVC.
     * Exemple : pour l'URL http://example.org/path/to/my/mvc/?action=goToSleep,
     * l'URI est : /path/to/my/mvc/
     */
    public static function getRootURI()
    {
        global $rootURI; // Variable globale initialisée dans le fichier index.php
        return $rootURI;
    }


    /** @brief retourne le tableau des (URLs vers les) feuilles de style CSS */
    public static function getStyleSheetsURL()
    {
        // Répertoire contenant les styles css
        // Le nettoyage par filter_var evite tout risque d'injection XSS
        $cssDirectoryURL = filter_var("http://" . $_SERVER['SERVER_NAME'] . self::getRootURI() . "/Vues/assets/", FILTER_SANITIZE_URL);
        return array(
            "default" => $cssDirectoryURL . "style.css",
            "user" =>  $cssDirectoryURL . "user.css",
            "inscription" => $cssDirectoryURL . "style_inscription.css",
            "interface" => $cssDirectoryURL . "style_interface.css",
            "stats" => $cssDirectoryURL . "style_stats.css",
            "login" => $cssDirectoryURL . "style_login.css",
            "header" => $cssDirectoryURL . "style_header.css",
            "contact" => $cssDirectoryURL . "style_contact.css",
            "account" => $cssDirectoryURL . "style_account.css",
            "accueil" => $cssDirectoryURL . "style_accueil.css",
            "session" => $cssDirectoryURL . "style_session.css",
            "technicien" => $cssDirectoryURL . "style_technicien.css",
            "admin" => $cssDirectoryURL . "style_admin.css",
            "error" => $cssDirectoryURL . "style_error.css",

        );
    }


    public static function getResources()
    {
        $javaDirectoryURL = filter_var("http://" . $_SERVER['SERVER_NAME'] . self::getRootURI() . "/Vues/assets/", FILTER_SANITIZE_URL);
        return array(
            "logo" => $javaDirectoryURL . "images/logo.png",
            "email" => $javaDirectoryURL . "images/email.png",
            "glob" => $javaDirectoryURL . "images/glob.png",
            "lock" => $javaDirectoryURL . "images/lock.png",
            "open_lock" => $javaDirectoryURL . "images/open_lock.png",
            "person" => $javaDirectoryURL . "images/person.png",
            "phone" => $javaDirectoryURL . "images/phone.png",
            "ampoule" => $javaDirectoryURL . "images/ampoule.png",
            "ampoule_ciel" => $javaDirectoryURL . "images/ampoule_ciel.png",
            "ampoule_marine" => $javaDirectoryURL . "images/ampoule_marine.png",
            "cam" => $javaDirectoryURL . "images/cam.png",
            "goutte" => $javaDirectoryURL . "images/goutte.png",
            "soleil" => $javaDirectoryURL . "images/soleil.png",
            "thermometre" => $javaDirectoryURL . "images/thermomètre.png",
            "loading" => $javaDirectoryURL . "images/loading.gif",
            "alarm" => $javaDirectoryURL . "images/alarm.png",
            "drop" => $javaDirectoryURL . "images/drop.png",
            "sun" => $javaDirectoryURL . "images/sun.png",
            "thermometer" => $javaDirectoryURL . "images/thermometer.png",
            "cb" => $javaDirectoryURL . "images/cb.png",
            "facture" => $javaDirectoryURL . "images/facture.pdf",
            "logoAccueil" => $javaDirectoryURL . "images/logoAccueil.png",
            "aboutus" => $javaDirectoryURL . "images/Aboutus.png",
            "vision" => $javaDirectoryURL . "images/vision.png",
            "whatwedo" => $javaDirectoryURL . "images/Whatwedo.png",
            "plus" => $javaDirectoryURL . "images/plus.png",
            "users" => $javaDirectoryURL . "images/users.png",
            "maison" => $javaDirectoryURL . "images/maison.jpeg",
            "logomarine" => $javaDirectoryURL . "images/logomarine.png",
            "main" => $javaDirectoryURL . "images/main.png",
            "remote" => $javaDirectoryURL . "images/remote.png",
            "secure" => $javaDirectoryURL . "images/secure.png",
            "store" => $javaDirectoryURL . "images/store1.png",

        );
    }


    /** @brief Génère 10 chiffres hexa aléatoires (soit 5 octets) */
    public static function generateRandomId()
    {
        // Génération de 5 octets (pseudo-)aléatoires codés en hexa
        $cryptoStrong = false; // Variable pour le passage par référence
        $octets = openssl_random_pseudo_bytes(5, $cryptoStrong);
        return bin2hex($octets);
    }
}

?>