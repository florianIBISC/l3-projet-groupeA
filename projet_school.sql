-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 15 avr. 2018 à 15:48
-- Version du serveur :  5.7.19
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
-- Base de données :  `projet_school`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `numSecu` int(55) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `genre` varchar(1) NOT NULL,
  `Adresse` varchar(500) NOT NULL,
  `lieuNaissance` varchar(255) NOT NULL,
  `dateNaissance` date NOT NULL,
  `numTel` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`numSecu`)
) ENGINE=InnoDB AUTO_INCREMENT=987654322 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`numSecu`, `nom`, `prenom`, `genre`, `Adresse`, `lieuNaissance`, `dateNaissance`, `numTel`, `email`) VALUES
(123456789, 'Patcheappane', 'Vignesh', 'h', '1', 'Inde', '1997-06-22', '0606060606', 'vignesh91350@outlook.fr'),
(987654321, 'Rabarisoa', 'Nico', 'h', '1 Rue de grigny', 'Madagascar', '1997-09-17', '0700000000', 'nicorabarisoa@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `login` varchar(255) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `numSecu` int(55) NOT NULL,
  PRIMARY KEY (`login`),
  KEY `numSecu` (`numSecu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`login`, `mdp`, `numSecu`) VALUES
('nicoraba', '1234', 987654321),
('test', 'test', 123456789),
('test2', 'test2', 123456789),
('vpatchea', '123456', 123456789);

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `idCours` int(11) NOT NULL AUTO_INCREMENT,
  `matiere` varchar(255) NOT NULL,
  `idSalle` int(11) NOT NULL,
  `volumeHoraire` int(11) NOT NULL,
  `idEnseignant` int(11) NOT NULL,
  `sessionCours` varchar(255) NOT NULL,
  `groupe` enum('a','b') NOT NULL,
  PRIMARY KEY (`idCours`),
  KEY `cours_ibfk_1` (`idEnseignant`),
  KEY `idSalle` (`idSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `idEnseignant` int(11) NOT NULL AUTO_INCREMENT,
  `cours` varchar(255) NOT NULL,
  `matiere` varchar(255) NOT NULL,
  PRIMARY KEY (`idEnseignant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `idEtudiant` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `genre` enum('h','f') NOT NULL,
  `adresse` varchar(500) NOT NULL,
  `lieuNaissance` varchar(255) NOT NULL,
  `dateNaissance` date NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`idEtudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `capacite` int(10) NOT NULL,
  `idSession` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  PRIMARY KEY (`idGroupe`),
  KEY `idMatiere` (`idMatiere`),
  KEY `idSession` (`idSession`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `idInscription` int(11) NOT NULL AUTO_INCREMENT,
  `dateInscription` date NOT NULL,
  `dateAbandon` date NOT NULL,
  `idEtudiant` int(11) NOT NULL,
  `matiere` varchar(255) NOT NULL,
  `sessionSchool` int(255) NOT NULL,
  `idGroupe` int(11) NOT NULL,
  PRIMARY KEY (`idInscription`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idGroupe` (`idGroupe`),
  KEY `inscription_ibfk_3` (`sessionSchool`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `idMatiere` int(11) NOT NULL AUTO_INCREMENT,
  `nomMatiere` varchar(255) NOT NULL,
  PRIMARY KEY (`idMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `idSalle` int(11) NOT NULL AUTO_INCREMENT,
  `capacite` int(11) NOT NULL,
  PRIMARY KEY (`idSalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sessionschool`
--

DROP TABLE IF EXISTS `sessionschool`;
CREATE TABLE IF NOT EXISTS `sessionschool` (
  `idSession` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebutSession` date NOT NULL,
  `dateFinSession` date NOT NULL,
  PRIMARY KEY (`idSession`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`numSecu`) REFERENCES `administrateur` (`numSecu`);

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `cours_ibfk_1` FOREIGN KEY (`idEnseignant`) REFERENCES `enseignant` (`idEnseignant`),
  ADD CONSTRAINT `cours_ibfk_2` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`idSalle`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `groupe_ibfk_1` FOREIGN KEY (`idMatiere`) REFERENCES `matiere` (`idMatiere`),
  ADD CONSTRAINT `groupe_ibfk_2` FOREIGN KEY (`idSession`) REFERENCES `sessionschool` (`idSession`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`idEtudiant`),
  ADD CONSTRAINT `inscription_ibfk_2` FOREIGN KEY (`idGroupe`) REFERENCES `groupe` (`idGroupe`),
  ADD CONSTRAINT `inscription_ibfk_3` FOREIGN KEY (`sessionSchool`) REFERENCES `sessionschool` (`idSession`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
