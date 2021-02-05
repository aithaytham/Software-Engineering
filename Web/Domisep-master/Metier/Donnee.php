<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 10:21
 */

namespace Domisep\Metier;


class Donnee
{
    public $id_donnee;
    public $val;
    public $date;
    public $id_capteur;

    /**
     * Donnee constructor.
     * @param $id_donnee
     * @param $val
     * @param $date
     * @param $id_capteur
     */
    public function __construct($id_donnee, $val, $date, $id_capteur)
    {
        $this->id_donnee = $id_donnee;
        $this->val = $val;
        $this->date = $date;
        $this->id_capteur = $id_capteur;
    }
}