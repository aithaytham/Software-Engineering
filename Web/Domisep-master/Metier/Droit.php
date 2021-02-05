<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 09:43
 */

namespace Domisep\Metier;


class Droit
{
    public $id_droit;
    public $nom;

    /**
     * Droit constructor.
     * @param $nom
     */
    public function __construct($nom)
    {
        $this->nom = $nom;
    }


}