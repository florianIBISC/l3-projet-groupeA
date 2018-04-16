-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 15 avr. 2018 à 23:42
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
) ENGINE=InnoDB AUTO_INCREMENT=1212121213 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`numSecu`, `nom`, `prenom`, `genre`, `Adresse`, `lieuNaissance`, `dateNaissance`, `numTel`, `email`) VALUES
(123456789, 'Patcheappane', 'Vignesh', 'h', '1', 'Inde', '1997-06-22', '0606060606', 'vignesh91350@outlook.fr'),
(444444444, 'Berrichi', 'Yassine', 'h', 'adresse', 'france', '1994-05-01', '0695959595', 'berrichi@gmail.com'),
(969696969, 'Michaud', 'Florian', 'h', 'france', 'france', '1996-04-21', '0678787878', 'florian@gmail.com'),
(1212121212, 'Rabarisoa', 'Sitraka', 'h', 'rue jpp', 'madagascar', '2018-04-10', '0695789545', 'sitraka@gmail.com');

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
('vpatchea', '123456', 123456789);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `idEtudiant` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `numTel` varchar(11) NOT NULL,
  `dateNaissance` varchar(15) NOT NULL,
  `matiere` varchar(50) NOT NULL,
  `idGroupe` varchar(250) NOT NULL,
  PRIMARY KEY (`idEtudiant`)
) ENGINE=InnoDB AUTO_INCREMENT=286 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`idEtudiant`, `prenom`, `nom`, `email`, `numTel`, `dateNaissance`, `matiere`, `idGroupe`) VALUES
(283, 'Vignesh', 'Patcheappane', 'vignesh@gmail.com', '0695570896', '1997-06-22', 'Tamoul', '1'),
(284, 'jean', 'Baptise', 'jb@gmail.com', '0695570896', '1995-05-21', 'Anglais', 'null'),
(285, 'hugo', 'paul', 'hp@gmail.com', '0105060908', '1986-05-21', 'Tamoul', '1');

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `capacite` int(10) NOT NULL,
  `matiere` varchar(50) NOT NULL,
  PRIMARY KEY (`idGroupe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`idGroupe`, `capacite`, `matiere`) VALUES
(1, 30, 'Tamoul'),
(2, 25, 'Malgache'),
(3, 45, 'Anglais'),
(4, 30, 'Anglais');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`numSecu`) REFERENCES `administrateur` (`numSecu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
