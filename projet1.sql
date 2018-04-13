-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 13 avr. 2018 à 14:56
-- Version du serveur :  5.7.17-log
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetschool1.0`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `numSecu` int(55) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `genre` enum('h','f') NOT NULL,
  `idAdresse` int(150) NOT NULL,
  `lieuNaissance` varchar(250) NOT NULL,
  `Datenaiss` date NOT NULL,
  `numtel` varchar(10) NOT NULL,
  `email` varchar(150) NOT NULL,
  PRIMARY KEY (`numSecu`),
  KEY `fk_adresseSecretaire` (`idAdresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`numSecu`, `Nom`, `Prenom`, `genre`, `idAdresse`, `lieuNaissance`, `Datenaiss`, `numtel`, `email`) VALUES
(123456789, 'Patcheappane', 'Vignesh', 'h', 1, 'inde', '1997-06-22', '0699999999', 'vignesh91350@outlook.fr');

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
CREATE TABLE IF NOT EXISTS `adresse` (
  `idAdresse` int(255) NOT NULL AUTO_INCREMENT,
  `numRue` int(255) NOT NULL,
  `nomRue` varchar(300) NOT NULL,
  `CP` int(5) NOT NULL,
  `Ville` varchar(50) NOT NULL,
  `complementAdresse` varchar(300) NOT NULL,
  PRIMARY KEY (`idAdresse`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`idAdresse`, `numRue`, `nomRue`, `CP`, `Ville`, `complementAdresse`) VALUES
(1, 12, 'square surcouf', 91350, 'grigny', 'null');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `login` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL,
  `numeroSecu` int(55) NOT NULL,
  PRIMARY KEY (`login`),
  KEY `fk_ref_travailleur` (`numeroSecu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `idEtudiant` int(255) NOT NULL AUTO_INCREMENT,
  `NomE` varchar(100) NOT NULL,
  `PrenomE` varchar(100) NOT NULL,
  `genre` varchar(1) NOT NULL,
  `idAdresse` int(255) NOT NULL,
  PRIMARY KEY (`idEtudiant`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idAdresse` (`idAdresse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `fk_adresseSecretaire` FOREIGN KEY (`idAdresse`) REFERENCES `adresse` (`idAdresse`);

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `fk_ref_travailleur` FOREIGN KEY (`numeroSecu`) REFERENCES `administrateur` (`numSecu`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK_adresse` FOREIGN KEY (`idAdresse`) REFERENCES `adresse` (`idAdresse`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
