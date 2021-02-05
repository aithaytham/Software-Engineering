<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 10:04
 */

namespace Domisep\Metier;


class Maison
{
    public $id_maison;
    public $nom;
    public $adresse;
    public $id_lotissement;

    /**
     * Maison constructor.
     * @param $id_maison
     * @param $nom
     * @param $adresse
     * @param $id_lotissement
     */
    public function __construct($id_maison, $nom, $adresse, $id_lotissement)
    {
        $this->id_maison = $id_maison;
        $this->nom = $nom;
        $this->adresse = $adresse;
        $this->id_lotissement = $id_lotissement;
    }

}