<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 09:57
 */

namespace Domisep\Metier;


class Lotissement
{
    public $id_lotissement;
    public $nom;
    public $nb_logements;
    public $id_ville;

    /**
     * Lotissement constructor.
     * @param $nom
     * @param $nb_logements
     * @param $id_ville
     */
    public function __construct($nom, $nb_logements, $id_ville)
    {
        $this->nom = $nom;
        $this->nb_logements = $nb_logements;
        $this->id_ville = $id_ville;
    }


}