-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Lun 17 Mai 2010 à 22:46
-- Version du serveur: 5.1.41
-- Version de PHP: 5.3.2-1ubuntu4.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `NoBrainer`
--
CREATE DATABASE `NoBrainer` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `NoBrainer`;

-- --------------------------------------------------------

--
-- Structure de la table `HighScore`
--

CREATE TABLE IF NOT EXISTS `HighScore` (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT,
  `playerId` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`scoreId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `HighScore`
--

INSERT INTO `HighScore` (`scoreId`, `playerId`, `level`, `score`) VALUES
(4, 5, 3, 125);

-- --------------------------------------------------------

--
-- Structure de la table `Invitation`
--

CREATE TABLE IF NOT EXISTS `Invitation` (
  `playerTwoId` int(11) NOT NULL,
  `playerOneId` int(11) NOT NULL,
  `invitationId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`playerTwoId`,`playerOneId`,`invitationId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contenu de la table `Invitation`
--

INSERT INTO `Invitation` (`playerTwoId`, `playerOneId`, `invitationId`) VALUES
(6, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Player`
--

CREATE TABLE IF NOT EXISTS `Player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `pwd` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `Player`
--

INSERT INTO `Player` (`id`, `name`, `pwd`) VALUES
(5, 'toto', 'df7c723782538f401fc57e02e40fba75e05ddff6'),
(6, 'tof', 'df7c723782538f401fc57e02e40fba75e05ddff6');
