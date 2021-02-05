<?php

namespace Domisep\Config;

class Validation
{
    function getValidateFilter($type)
    {
        switch ($type) {
            case "email":
                $filter = FILTER_VALIDATE_EMAIL;
                break;
            case "int":
                $filter = FILTER_VALIDATE_INT;
                break;
            case "boolean":
                $filter = FILTER_VALIDATE_BOOLEAN;
                break;
            case "ip":
                $filter = FILTER_VALIDATE_IP;
                break;
            case "url":
                $filter = FILTER_VALIDATE_URL;
                break;
            case "float":
                $filter = FILTER_VALIDATE_FLOAT;
                break;
            case "mac":
                $filter = FILTER_VALIDATE_MAC;
                break;
            case "regexp":
                $filter = FILTER_VALIDATE_REGEXP;
                break;
            default:
                $filter = false;
        }
        return $filter;
    }

    public static function validateItems($param)
    {
        foreach ($param as $ligne) {
            $ret[] = filter_var($ligne['valeur'], self::getValidateFilter($ligne['type']));
        }
        return $ret;
    }

    public static function validateItem($item, $type){
        return filter_var($item, self::getValidateFilter($type));
    }
}

?>

