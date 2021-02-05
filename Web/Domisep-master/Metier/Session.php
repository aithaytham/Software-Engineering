<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 09:34
 */

namespace Domisep\Metier;


class Session
{
    public $id_session;
    public $name;
    public $password;
    public $droits;
    public $id_client;

    /**
     * Session constructor.
     * @param $name
     * @param $password
     */
    public function __construct($name, $password, $id_client)
    {
        $this->name = $name;
        $this->password = $password;
        $this->droits = [];
        $this->id_client = $id_client;
    }


}