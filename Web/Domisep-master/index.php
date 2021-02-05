<?php


// Répertoire racine du MVC
$rootDirectory = dirname(__FILE__) . "/";
// Calcul portable de l'URI de la racine du MVC (sans la query string)

// 1) On enlève la "query string" : ?action=blabla&id=03456789
$urlWithoutQueryString = explode("?", $_SERVER['REQUEST_URI'])[0];

// 2) On coupe l'URL du script au niveau de l'extension ".php"
$scriptWithoutExtention = explode(".php", $urlWithoutQueryString)[0];

// 3) Puis on s'arrête au dernier / (pour enlever la basename du script)
$longueurRootURI = strrpos($scriptWithoutExtention, '/');

// 4) On prend le début de l'URL en coupant à la bonne longueur
$rootURI = substr($_SERVER['REQUEST_URI'], 0, $longueurRootURI);

// Chargement de l'autoload pour autochargement des classes
require_once($rootDirectory . '/Config/Autoload.php');

Domisep\Config\Autoload::load_PSR_4('Domisep');

// Quelques variables globales
$sessionOK=false;
$dataError = array();
//Création de l'instance du frontController :
$controller = new \Domisep\Controller\FrontController();
?>