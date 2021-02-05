<?php


namespace Domisep\Config;
/** @brief classe Autoload : permet de charger automatiquement les classes.
 * La méthode autoloadCallback() permer de charger le code source
 * d'une classe dont le nom est passé en paramètre.
 * Pour cela, la méthode load() déclare autoloadCallback()
 * par un appel à spl_autoload_register()                  */
class Autoload
{

    /** Préfixe principal des namespaces du projet */
    public static $vendorNamespace;

    /** @brief Enregistrement du callback d'autoload.
     * @param $vendorNamespace Préfixe principal des namespaces du projet
     */
    public static function load_PSR_4($vendorNamespace)
    {
        self::$vendorNamespace = $vendorNamespace;
        // Enregistrement d'un callback chargé d'inclure les classes.
        // Il peut y en avoir plusieurs, appelés successivement
        // en cas d'échec des premier...
        spl_autoload_register('Domisep\Config\Autoload::autoloadCallback_PSR_4');
    }

    /** @brief Callback d'Autoload suivant la norme PSR-4,
     * Cette méthode est appelée automatiquement en cas d'instanciation
     * d'une classe inconnue. La méthode charge alors la classe en question.
     *
     * @param $class : nom complet de la classe à charger.
     *
     * @note L'arborescence des répertoires et les noms de fichiers PHP
     * contenant les classes doivent coincider avec les sous-namespace
     * de la classe pour trouver directement le répertoire contenant
     * le fichier source de la classe.                               */
    public static function autoloadCallback_PSR_4($class)
    {
        // La classe a-t-elle le bon préfixe de namespace ?
        $longueurVendorNamespace = strlen(self::$vendorNamespace);
        if (strncmp(self::$vendorNamespace, $class, $longueurVendorNamespace) !== 0) {
            // Echec de l'autoloader. Espérons qu'il y en a un deuxième...
            return;
        }
        // On enlève le préfixe ``Vendor Namespace".
        $relativeClass = substr($class, $longueurVendorNamespace);
        // Chemin vers le fichier source de la classe :
        global $rootDirectory; // Voir début de index.php
        $filePath = $rootDirectory . str_replace('\\', '/', $relativeClass) . '.php';
        // si le fichier existe
        if (file_exists($filePath)) {
            // Chargement de la classe :
            require($filePath);
        }
    }
} // Fin de la classe Autoload
?>
