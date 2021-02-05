<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 10:03
 */

namespace Domisep\Metier;


class Ville
{
    public $id_ville;
    public $nom;
    public $code_postal;

    /**
     * Ville constructor.
     * @param $id_ville
     * @param $nom
     * @param $code_postal
     */
    public function __construct($id_ville, $nom, $code_postal)
    {
        $this->id_ville = $id_ville;
        $this->nom = $nom;
        $this->code_postal = $code_postal;
    }


}