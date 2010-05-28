SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE `NoBrainer` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `NoBrainer`;

CREATE TABLE IF NOT EXISTS `Friends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `playerOneId` int(11) NOT NULL,
  `playerTwoId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `HighScore` (
  `scoreId` int(11) NOT NULL AUTO_INCREMENT,
  `playerId` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`scoreId`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

INSERT INTO `HighScore` (`scoreId`, `playerId`, `level`, `score`) VALUES
(4, 5, 3, 125);

CREATE TABLE IF NOT EXISTS `Invitation` (
  `playerTwoId` int(11) NOT NULL,
  `playerOneId` int(11) NOT NULL,
  `invitationId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`playerTwoId`,`playerOneId`,`invitationId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

INSERT INTO `Invitation` (`playerTwoId`, `playerOneId`, `invitationId`) VALUES
(6, 5, 1);

CREATE TABLE IF NOT EXISTS `Player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `pwd` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=101 ;

INSERT INTO `Player` (`id`, `name`, `pwd`) VALUES
(100, 'Toto', '9d4e1e23bd5b727046a9e3b4b7db57bd8d6ee684');
