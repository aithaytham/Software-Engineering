<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 10:17
 */

namespace Domisep\Metier;


class Capteur
{
    public $id_capteur;
    public $type;
    public $id_salle;

    /**
     * Capteur constructor.
     * @param $id_capteur
     * @param $type
     * @param $id_salle
     */
    public function __construct($id_capteur, $type, $id_salle)
    {
        $this->id_capteur = $id_capteur;
        $this->type = $type;
        $this->id_salle = $id_salle;
    }


}