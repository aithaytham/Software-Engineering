<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 10:05
 */

namespace Domisep\Metier;

use \Domisep\Metier\User;

class Client extends User
{
    public $id_client;
    public $last_name;
    public $first_name;
    public $user;
    public $liste_maison;

    public function __construct($last_name, $first_name, $user){
        parent::__construct($user->email, $user->password, $user->username);
        $this->last_name = $last_name;
        $this->first_name = $first_name;
        $this->liste_maison = [];
    }
}