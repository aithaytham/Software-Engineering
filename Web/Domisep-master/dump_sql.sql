-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 01 Février 2018 à 23:03
-- Version du serveur :  5.7.20-0ubuntu0.16.04.1
-- Version de PHP :  7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `domisep`
--
-- --------------------------------------------------------
--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `code_postal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `ville`
--

INSERT INTO `ville` (`id`, `nom`, `code_postal`) VALUES
(1, 'Paris', 75000);


-- ---------------------------------------------------------
--
-- Structure de la table `user`
--


CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `abonnement` tinyint(1) DEFAULT '1',
  `date_abonnement` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `role` varchar(30) DEFAULT 'client'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `tel`, `abonnement`, `date_abonnement`, `role`) VALUES
(5, 'admin@admin.fr', 'c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec', '0987654321', 1, '2018-01-20 15:30:00', 'admin'),
(6, 'test@sponsor.fr', '25a0a1c4c9d19b808516f7d3e731cf719c96368a37608646f59a3b7c5823b5129ee75e44d5da66d4d8e92a4061f57e5ccf04d4e5e2e695397128593fe18a1900', NULL, 1, '2018-01-21 12:35:57', 'promotteur'),
(12, 'test@entity.fr', '99132351e8abea98dea026ffa6ac23a0bd5a0d82f2521b1e92846af1de4a65615075104ffa3e8958f3f18bc05bace430bd9496f9c66d4cba3d874c0b64384afe', NULL, 1, '2018-01-21 12:42:38', 'entite_geographique'),
(14, 'test@tech.fr', 'ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff', NULL, 1, '2018-01-26 17:27:28', 'technicien'),
(16, 'client@client.fr', '85d7741af27f18cbefc7fdc96d4465f63d4e8da2126a196f87c4f7e1f65298855a0e4a4a8986936eae95e2b899e837c48ae39d8048f907ebd0095c87c49fb0af', NULL, 1, '2018-02-01 22:55:34', 'client'),
(17, 'tech@tech.fr', '03e27e1cb5c4dc29a516e09233b4ab6d6521eb98d2da9be0522e197798149f9be841dafc8833c431f295d6ce1d1fe6beadaaa1d31d726d227f0627c82757664b', NULL, 1, '2018-02-01 22:57:59', 'technicien');

-- --------------------------------------------------------

--
-- Structure de la table `type_capteur`
--

CREATE TABLE `type_capteur` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `type_capteur`
--

INSERT INTO `type_capteur` (`id`, `nom`) VALUES
(1, 'Temperature'),
(2, 'Store'),
(3, 'Light'),
(4, 'Camera');

-- --------------------------------------------------------


--
-- Structure de la table `capteur`
--

CREATE TABLE `capteur` (
  `id` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `id_salle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `id_user`) VALUES
(4, 'client', 'client', 16);

-- --------------------------------------------------------

--
-- Structure de la table `donnee`
--

CREATE TABLE `donnee` (
  `id` int(11) NOT NULL,
  `val` float DEFAULT NULL,
  `dateData` date DEFAULT NULL,
  `id_capteur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

CREATE TABLE `droit` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sessions`
--

CREATE TABLE `sessions` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `password` char(4) NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `sessions`
--

INSERT INTO `sessions` (`id`, `nom`, `password`, `id_client`) VALUES
(7, 'master', '1234', 4);

-- --------------------------------------------------------

--
-- Structure de la table `droit_sessions`
--

CREATE TABLE `droit_sessions` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `id_sessions` int(11) NOT NULL,
  `id_droit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `entite_geographique`
--

CREATE TABLE `entite_geographique` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `id_ville` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `entite_geographique`
--

INSERT INTO `entite_geographique` (`id`, `nom`, `id_user`, `id_ville`) VALUES
(2, 'entity', 12, 1);

-- --------------------------------------------------------
--
-- Structure de la table `promotteur`
--

CREATE TABLE `promotteur` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `promotteur`
--

INSERT INTO `promotteur` (`id`, `nom`, `id_user`) VALUES
(1, 'test sponsor', 6);

-- --------------------------------------------------------

--
-- Structure de la table `lotissement`
--

CREATE TABLE `lotissement` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `nb_logements` int(11) DEFAULT NULL,
  `id_ville` int(11) NOT NULL,
  `id_promotteur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `maison`
--

CREATE TABLE `maison` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `id_lotissement` int(11) DEFAULT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `maison`
--

INSERT INTO `maison` (`id`, `nom`, `adresse`, `id_lotissement`, `id_client`) VALUES
(12, 'Maison 1', '10 rue du charpentier', NULL, 4);

-- --------------------------------------------------------

--
-- Structure de la table `probleme`
--

CREATE TABLE `probleme` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `prenom` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sujet` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `message` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `etat` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'new',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `probleme`
--

INSERT INTO `probleme` (`id`, `id_client`, `nom`, `prenom`, `email`, `sujet`, `message`, `etat`, `date`) VALUES
(36, 4, 'nom', 'prenom', 'client@client.fr', 'Sensors problem', 'I have a problem with my sensors, they don\'t send data anymore. Contact me please.', 'new', '2018-02-01 23:01:38'),
(37, 4, 'nom', 'prenom', 'client@client.fr', 'camera problem', 'I have a problem with my camera. It doesn\'t send any video.', 'viewed', '2018-02-01 23:01:38'),
(38, 4, 'nom', 'prenom', 'client@client.fr', 'Cannot add Session', 'I can\'t add a session to my account', 'done', '2018-02-01 23:02:36');

-- --------------------------------------------------------

--
-- Structure de la table `type_salle`
--

CREATE TABLE `type_salle` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `type_salle`
--

INSERT INTO `type_salle` (`id`, `nom`) VALUES
(1, 'Office'),
(2, 'Living Room'),
(3, 'Room'),
(4, 'Kitchen'),
(5, 'Bathroom');


-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `id` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `id_maison` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------



--
-- Structure de la table `technicien`
--

CREATE TABLE `technicien` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `id_ville` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `technicien`
--

INSERT INTO `technicien` (`id`, `nom`, `prenom`, `id_user`, `id_ville`) VALUES
(5, 'tech', 'tech', 17, 1);

-- --------------------------------------------------------



--
-- Index pour les tables exportées
--

--
-- Index pour la table `capteur`
--
ALTER TABLE `capteur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type` (`id_type`),
  ADD KEY `id_salle` (`id_salle`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `donnee`
--
ALTER TABLE `donnee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_capteur` (`id_capteur`);

--
-- Index pour la table `droit`
--
ALTER TABLE `droit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `droit_sessions`
--
ALTER TABLE `droit_sessions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_sessions` (`id_sessions`),
  ADD KEY `id_droit` (`id_droit`);

--
-- Index pour la table `entite_geographique`
--
ALTER TABLE `entite_geographique`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_ville` (`id_ville`);

--
-- Index pour la table `lotissement`
--
ALTER TABLE `lotissement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ville` (`id_ville`),
  ADD KEY `id_promotteur` (`id_promotteur`);

--
-- Index pour la table `maison`
--
ALTER TABLE `maison`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_lotissement` (`id_lotissement`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `probleme`
--
ALTER TABLE `probleme`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `promotteur`
--
ALTER TABLE `promotteur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type` (`id_type`),
  ADD KEY `id_maison` (`id_maison`);

--
-- Index pour la table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `technicien`
--
ALTER TABLE `technicien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_ville` (`id_ville`);

--
-- Index pour la table `type_capteur`
--
ALTER TABLE `type_capteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_salle`
--
ALTER TABLE `type_salle`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `capteur`
--
ALTER TABLE `capteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `donnee`
--
ALTER TABLE `donnee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `droit`
--
ALTER TABLE `droit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `droit_sessions`
--
ALTER TABLE `droit_sessions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `entite_geographique`
--
ALTER TABLE `entite_geographique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `lotissement`
--
ALTER TABLE `lotissement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `maison`
--
ALTER TABLE `maison`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `probleme`
--
ALTER TABLE `probleme`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- AUTO_INCREMENT pour la table `promotteur`
--
ALTER TABLE `promotteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `sessions`
--
ALTER TABLE `sessions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `technicien`
--
ALTER TABLE `technicien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `type_capteur`
--
ALTER TABLE `type_capteur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `type_salle`
--
ALTER TABLE `type_salle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT pour la table `ville`
--
ALTER TABLE `ville`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `capteur`
--
ALTER TABLE `capteur`
  ADD CONSTRAINT `capteur_ibfk_1` FOREIGN KEY (`id_type`) REFERENCES `type_capteur` (`id`),
  ADD CONSTRAINT `capteur_ibfk_2` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `donnee`
--
ALTER TABLE `donnee`
  ADD CONSTRAINT `donnee_ibfk_1` FOREIGN KEY (`id_capteur`) REFERENCES `capteur` (`id`);

--
-- Contraintes pour la table `droit_sessions`
--
ALTER TABLE `droit_sessions`
  ADD CONSTRAINT `droit_sessions_ibfk_1` FOREIGN KEY (`id_sessions`) REFERENCES `sessions` (`id`),
  ADD CONSTRAINT `droit_sessions_ibfk_2` FOREIGN KEY (`id_droit`) REFERENCES `droit` (`id`);

--
-- Contraintes pour la table `entite_geographique`
--
ALTER TABLE `entite_geographique`
  ADD CONSTRAINT `entite_geographique_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `entite_geographique_ibfk_2` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id`);

--
-- Contraintes pour la table `lotissement`
--
ALTER TABLE `lotissement`
  ADD CONSTRAINT `lotissement_ibfk_1` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id`),
  ADD CONSTRAINT `lotissement_ibfk_2` FOREIGN KEY (`id_promotteur`) REFERENCES `promotteur` (`id`);

--
-- Contraintes pour la table `maison`
--
ALTER TABLE `maison`
  ADD CONSTRAINT `maison_ibfk_1` FOREIGN KEY (`id_lotissement`) REFERENCES `lotissement` (`id`),
  ADD CONSTRAINT `maison_ibfk_2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `probleme`
--
ALTER TABLE `probleme`
  ADD CONSTRAINT `probleme_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `promotteur`
--
ALTER TABLE `promotteur`
  ADD CONSTRAINT `promotteur_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`id_type`) REFERENCES `type_salle` (`id`),
  ADD CONSTRAINT `salle_ibfk_2` FOREIGN KEY (`id_maison`) REFERENCES `maison` (`id`);

--
-- Contraintes pour la table `sessions`
--
ALTER TABLE `sessions`
  ADD CONSTRAINT `sessions_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `technicien`
--
ALTER TABLE `technicien`
  ADD CONSTRAINT `technicien_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `technicien_ibfk_2` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
