-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 08/01/2013 às 08h28min
-- Versão do Servidor: 5.5.28
-- Versão do PHP: 5.3.10-1ubuntu3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `conselho_2013`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidatos`
--

CREATE TABLE IF NOT EXISTS `candidatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `apelido` varchar(80) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `candidatos`
--

INSERT INTO `candidatos` (`id`, `nome`, `apelido`, `numero`) VALUES
(1, 'CANDIDATO 01', 'CAND 001', 1),
(2, 'CANDIDATO 02', 'CAND 002', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `eleitor`
--

CREATE TABLE IF NOT EXISTS `eleitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sala` varchar(10) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `eleitor`
--

INSERT INTO `eleitor` (`id`, `sala`, `nome`, `titulo`, `rg`, `cpf`, `status`) VALUES
(1, '02', 'JENNIFER MELO', '12', '9869859', '5978758', '0'),
(2, '02', 'JOÃO DA SILVA', '12356', '9868', '3456789', '1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
