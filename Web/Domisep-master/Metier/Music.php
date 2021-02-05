<?php

namespace Domisep\Metier;

use Domisep\Config\Config;

class Music
{
    public $idMusique;
    public $titre;
    public $avisfav;  
    public $datamaj;
    public $musicPath;

    public function __construct($musicID, $title, $nbLike, $link)
    {
        $this->idMusique = $musicID;
        $this->titre = $title;
        $this->avisfav = $nbLike;

        $this->musicPath = $link;
    }

}

?>