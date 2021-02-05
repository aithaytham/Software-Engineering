<?php

/** @brief Classe d'utilitaires de génération de code HTML.
 * Définit des méthodes pour générer l'en-tête et la fin d'un document,
 * ainsi qu'un formulaire d'authentification (saisie login/password) */
namespace Domisep\Vues;

class VueHtmlUtils
{
    /** @brief Génère le header HTML5 (doctype et &lt;head&gt;)
     * @param $title titre de la page (contenu de la balise &lt;title&gt;)
     * @param $charset Jeu de caractères pour encodage (généralement "UTF-8")
     * @param $css_sheet URL de la feuille de style globale de la page.
     */
    public static function enTeteHTML5($charset, $css_sheet)
    {
        $htmlCode = "<!doctype html>\n<html lang=\"fr\">\n";
        $htmlCode .= "<head>\n<meta charset=\"" . $charset . "\"/>\n";
        $htmlCode .= "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/> \n";
        $htmlCode .= "<link href=\"" . $css_sheet . "\" rel=\"stylesheet\" type=\"text/css\" />\n";
        //$htmlCode .= "<title>".$title."</title>\n";
        //$htmlCode .= "</head>\n<body>\n";
        return $htmlCode;
    }

    public static function cssHTML5($css_sheet)
    {
        $htmlCode = "<link href=\"" . $css_sheet . "\" rel=\"stylesheet\" type=\"text/css\" />\n";
        return $htmlCode;
    }

    /** Génère la fin de fichier HTML (ferme le &lt;body&gt; et le &lt;html&gt;) */
    public static function finFichierHTML5()
    {
        return "\n</body>\n</html>\n";
    }

    /** Fonction qui retourne le code HTML d'un formulaire de login
     * @param $formAction chemin (ou URL absolue) vers le script de réception
     */
    public static function getHTML_LoginForm($formAction)
    {

        $htmlCode = "";
        // Test de connexion SSL et le cas échéant, warning.
        if (!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] == "off") {
            $htmlCode .= "<p><strong>Warning :</strong> Vous n'êtes pas "
                . "sur une connexion sécurisée <i>HTTPS</i> avec <i>SSL</i>."
                . "<br/>Votre confidentialité n'est pas garantie !!!</p>";
        }
        // Code du formulaire :
        $htmlCode .= '<form method="POST" action="' . $formAction . '">';
        $htmlCode .= '<input type="hidden" name="action" value="validateAuth"/>';
        $htmlCode .= '<p><label for="e-mail">e-mail</label>'
            . '<input type="email" name="email" size="25"/></p>';
        $htmlCode .= '<p><label for="motdepasse">Mot de passe</label>'
            . '<input type="password" name="motdepasse" size="25"/></p>';
        $htmlCode .= '<input class="sansLabel" value="Envoyer" type="submit"/>';
        $htmlCode .= '</form>';
        $htmlCode .= "<p>L'adresse <i>e-mail</i> doit être valide et votre "
            . "mot de passe doit contenir au moins 8 caractères, une "
            . "minuscule, une majuscule, un chiffre, et un caractère parmis "
            . htmlentities("#-|.@[]=!&", ENT_QUOTES, "UTF-8")
            . ", merci de votre compréhension...</p>";
        return $htmlCode;
    }
}

?>
