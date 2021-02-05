<?php

namespace Domisep\Persistance;

class Connection extends \PDO
{
    private $stmt;

    /**
     * Connection constructor.
     * @param $dsn string Data Source Name
     * @param $username string Identifiant pour la BD
     * @param $password string MDP pour la BD
     */
    public function __construct($dsn, $username, $password)
    {
        parent::__construct($dsn, $username, $password);
        $this->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION);
    }

    /**
     * @param $query string Requête à exécuter
     * @param array $parameters Parmètres de la requête
     * @return bool
     */
    public function prepareAndExecuteQuery($query, array $parameters = [])
    {
        $this->stmt = parent::prepare($query);
        foreach ($parameters as $name => $value) {
            $this->stmt->bindValue($name, $value[0], $value[1]);
        }
        try {
            $res = $this->stmt->execute();
        } catch (\Exception $e) {
            throw $e;
        }
        return $res;
    }

    /** @brief Obtenir les résultats d'une requête
     * @return mixed résultat d'une query
     */
    public function getResults()
    {
        return $this->stmt->fetchAll();
    }

    /**
     * @return int Nombre de résultats de la requête.
     */
    public function getNbResults()
    {
        return $this->stmt->rowCount();
    }
}