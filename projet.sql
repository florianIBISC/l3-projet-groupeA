-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 12 avr. 2018 à 09:40
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresses`
--

DROP TABLE IF EXISTS `adresses`;
CREATE TABLE IF NOT EXISTS `adresses` (
  `idAdresse` int(11) NOT NULL AUTO_INCREMENT,
  `numRue` int(11) NOT NULL,
  `CP` int(11) NOT NULL,
  `Arrondissement` int(11) DEFAULT NULL,
  `NomRue` varchar(255) NOT NULL,
  `NomVille` varchar(255) NOT NULL,
  `complementAdresse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idAdresse`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adresses`
--

INSERT INTO `adresses` (`idAdresse`, `numRue`, `CP`, `Arrondissement`, `NomRue`, `NomVille`, `complementAdresse`) VALUES
(1, 1, 93420, 2, 'ta', 'Daronne', 'j');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `idCompte` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  PRIMARY KEY (`idCompte`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`idCompte`, `login`, `mdp`) VALUES
(1, 'yayaboss', 'floboloss');

-- --------------------------------------------------------

--
-- Structure de la table `individus`
--

DROP TABLE IF EXISTS `individus`;
CREATE TABLE IF NOT EXISTS `individus` (
  `idIndividu` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `genre` varchar(1) NOT NULL,
  `idAdresse` int(11) NOT NULL,
  `lieuNaissance` varchar(255) NOT NULL,
  `dateDeNaissance` date NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`idIndividu`),
  KEY `idAdresse` (`idAdresse`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `individus`
--

INSERT INTO `individus` (`idIndividu`, `nom`, `prenom`, `genre`, `idAdresse`, `lieuNaissance`, `dateDeNaissance`, `email`) VALUES
(1, 'berrichi', 'yassine', 'h', 1, 'France', '2018-09-09', 'tamere');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `individus`
--
ALTER TABLE `individus`
  ADD CONSTRAINT `individus_ibfk_1` FOREIGN KEY (`idAdresse`) REFERENCES `adresses` (`idAdresse`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
