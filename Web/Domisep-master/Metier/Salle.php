<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 10:13
 */

namespace Domisep\Metier;


class Salle
{
    public $id_salle;
    public $type;
    public $id_maison;

    /**
     * Salle constructor.
     * @param $id_salle
     * @param $type
     * @param $id_maison
     */
    public function __construct($id_salle, $type, $id_maison)
    {
        $this->id_salle = $id_salle;
        $this->type = $type;
        $this->id_maison = $id_maison;
    }





}