<?php
/**
 * Created by PhpStorm.
 * User: adrien
 * Date: 28/11/17
 * Time: 10:00
 */

namespace Domisep\Metier;


class User
{
    public $username;
    public $email;
    public $password;
    public $abonnement;
    public $date_abonnement;
    public $role;


    public function __construct($user) {
        $this->email = $user['email'];
        $this->password = $user['password'];
        $this->username = $user['username'];
        $this->abonnement = false;
    }

}