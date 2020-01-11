-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-11-2019 a las 12:38:34
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbticketmaster`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `cod_artista` int(11) DEFAULT NULL,
  `nombre_artista` varchar(15) DEFAULT NULL,
  `estilo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`cod_artista`, `nombre_artista`, `estilo`) VALUES
(1, 'Adrian', 'Futbol'),
(2, 'Julian', 'Reggaeton'),
(3, 'Ivan', 'Reggaeton');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evento`
--

CREATE TABLE `evento` (
  `cod_evento` int(11) NOT NULL,
  `nombre_evento` varchar(20) DEFAULT NULL,
  `fecha_evento` date DEFAULT NULL,
  `nombre_artista` varchar(20) DEFAULT NULL,
  `recintos` varchar(40) DEFAULT NULL,
  `localidades` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `evento`
--

INSERT INTO `evento` (`cod_evento`, `nombre_evento`, `fecha_evento`, `nombre_artista`, `recintos`, `localidades`) VALUES
(1, 'El Clasico', '2019-12-18', 'nombre1', 'Camp Nou', 90000),
(2, 'Bon Jovi', '2019-12-18', 'nombre2', 'Wizink Center', 25000),
(3, 'Myke Towers', '2019-12-18', 'nombre3', 'Ifema', 67500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidad`
--

CREATE TABLE `localidad` (
  `cod_localidad` int(11) NOT NULL,
  `nombre_ciudad` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `localidad`
--

INSERT INTO `localidad` (`cod_localidad`, `nombre_ciudad`) VALUES
(1, 'Madrid'),
(2, 'Alcorcon'),
(3, 'Mostoles');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recinto`
--

CREATE TABLE `recinto` (
  `cod_recinto` int(11) NOT NULL,
  `nombre_recinto` varchar(30) DEFAULT NULL,
  `coste` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recinto`
--

INSERT INTO `recinto` (`cod_recinto`, `nombre_recinto`, `coste`) VALUES
(1, 'Camp Nou', 20.5),
(2, 'Fabrik', 25.5),
(3, 'Jowke', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoevento`
--

CREATE TABLE `tipoevento` (
  `cod_evento` int(11) NOT NULL,
  `tipoevento` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipoevento`
--

INSERT INTO `tipoevento` (`cod_evento`, `tipoevento`) VALUES
(1, 'Concierto'),
(2, 'Exposicion StarWars'),
(3, 'Exposicion Arte Mode');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`cod_evento`);

--
-- Indices de la tabla `localidad`
--
ALTER TABLE `localidad`
  ADD PRIMARY KEY (`cod_localidad`);

--
-- Indices de la tabla `recinto`
--
ALTER TABLE `recinto`
  ADD PRIMARY KEY (`cod_recinto`);

--
-- Indices de la tabla `tipoevento`
--
ALTER TABLE `tipoevento`
  ADD PRIMARY KEY (`cod_evento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
