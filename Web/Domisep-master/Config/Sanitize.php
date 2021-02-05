<?php

namespace Domisep\Config;

class Sanitize
{
    function getSanitizeFilter($type)
    {
        switch ($type) {
            case "string":
                $filter = FILTER_SANITIZE_STRING;
                break;
            case "text":
                $filter = FILTER_SANITIZE_FULL_SPECIAL_CHARS;
                break;
            case "url":
                $filter = FILTER_SANITIZE_URL;
                break;
            case "int":
                $filter = FILTER_SANITIZE_NUMBER_INT;
                break;
            case "float":
                $filter = FILTER_SANITIZE_NUMBER_FLOAT;
                break;
            case "email":
                $filter = FILTER_SANITIZE_EMAIL;
                break;
            case "magic_quotes":
                $filter = FILTER_SANITIZE_MAGIC_QUOTES;
                break;
            default:
                $filter = false;
        }
        return $filter;
    }

    public static function sanitizeItems($param)
    {
        foreach ($param as $ligne) {
            $ret[] = filter_var($ligne['valeur'], self::getSanitizeFilter($ligne['type']));
        }
        return $ret;
    }

    public static function sanitizeItem($item, $type){
        return filter_var($item, self::getSanitizeFilter($type));
    }
}

?>

