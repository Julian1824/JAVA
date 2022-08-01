-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 02, 2022 at 09:04 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistemaventa`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `runt` int(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `razon` varchar(30) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` (`id`, `runt`, `nombre`, `telefono`, `direccion`, `razon`, `fecha`) VALUES
(3, 1843, 'prueba 2', 2141560, 'Cra 336', 'LICU', '2022-06-13 16:06:32');

-- --------------------------------------------------------

--
-- Table structure for table `config`
--

CREATE TABLE `config` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `runt` varchar(30) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `razon` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `config`
--

INSERT INTO `config` (`id`, `nombre`, `runt`, `telefono`, `direccion`, `razon`) VALUES
(1, 'Julian', '144', 31940182, 'MEDELLIN - ANTIOQUIA', 'FUTBOL');

-- --------------------------------------------------------

--
-- Table structure for table `detalle`
--

CREATE TABLE `detalle` (
  `id` int(11) NOT NULL,
  `cod_pruducto` varchar(30) NOT NULL,
  `cantidad` int(30) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `id_venta` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detalle`
--

INSERT INTO `detalle` (`id`, `cod_pruducto`, `cantidad`, `precio`, `id_venta`) VALUES
(5, '123', 5, '1200.00', 10),
(6, '123', 5, '1200.00', 11),
(7, '123', 5, '1200.00', 12),
(8, '123', 5, '1200.00', 13),
(9, '123', 20, '1200.00', 14),
(10, '123', 5, '1200.00', 15),
(11, '234', 5, '15900.00', 17),
(12, '123', 5, '1200.00', 18),
(13, '234', 10, '15900.00', 18),
(14, '123', 5, '1200.00', 19),
(15, '123', 5, '1200.00', 20),
(16, '234', 5, '15900.00', 20),
(17, '123', 1, '1200.00', 22),
(18, '234', 5, '15900.00', 23),
(19, '123', 6, '1200.00', 23),
(20, '123', 6, '1200.00', 24),
(21, '123', 5, '1200.00', 30),
(22, '234', 5, '15900.00', 30),
(23, '234', 2, '15900.00', 31),
(24, '123', 23, '1200.00', 31),
(25, '234', 2, '15900.00', 32),
(26, '123', 2, '1200.00', 32),
(27, '123', 4, '1200.00', 33),
(28, '234', 5, '15900.00', 33),
(29, '123', 5, '1200.00', 34),
(30, '234', 5, '15900.00', 34),
(31, '123', 5, '1200.00', 35),
(32, '234', 10, '15900.00', 35),
(33, '123', 2, '1200.00', 36),
(34, '123', 6, '1200.00', 36),
(35, '123', 2, '1200.00', 37),
(36, '234', 5, '15900.00', 37),
(37, '123', 6, '1200.00', 38);

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `cantidad` int(10) NOT NULL,
  `proveedor` varchar(30) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`id`, `codigo`, `nombre`, `cantidad`, `proveedor`, `precio`, `fecha`) VALUES
(1, '234', 'Papel carta', 16, 'Jero', '15900.00', '2022-06-14 22:16:47'),
(3, '123', 'Lapicero Rojo', 40, 'Daniel', '1200.00', '2022-06-15 17:22:53');

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `runt` int(20) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `telefono` int(15) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `razon` varchar(30) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`id`, `runt`, `nombre`, `telefono`, `direccion`, `razon`, `fecha`) VALUES
(6, 5555, 'Jero', 555, '555', '555', '2022-06-13 22:30:18'),
(7, 8, 'Juan', 8, '88', '8', '2022-06-13 22:31:05'),
(8, 55, 'Daniel', 55, 'a', 'a', '2022-06-14 18:04:14'),
(27, 2141560, 'Julian', 2141560, 'cra 36-96-46', 'PEPROPI', '2022-06-27 16:21:07'),
(34, 3, '3', 3, '3', '3', '2022-06-27 16:24:11'),
(35, 2, '22', 2, '2', '2', '2022-06-27 16:24:26'),
(36, 0, '', 0, '', '', '2022-06-27 16:24:27'),
(37, 3, '3', 3, '3', '3', '2022-06-27 16:25:03'),
(38, 3, '3', 3, '3', '3', '2022-06-27 16:25:34'),
(39, 2, '22', 2, '2', '2', '2022-06-27 16:26:18'),
(40, 2, '22', 2, '2', '2', '2022-06-27 16:27:00'),
(41, 0, '', 0, '', '', '2022-06-27 16:27:01'),
(42, 2, '22', 2, '2', '2', '2022-06-27 16:27:46'),
(43, 2, '222', 2, '2', '2', '2022-06-27 16:28:28'),
(44, 3, '3', 3, '3', '3', '2022-06-27 16:29:05'),
(45, 2, '2', 2, '2', '2', '2022-06-27 16:29:24'),
(46, 2, '222', 2, '2', '2', '2022-06-27 16:30:56'),
(47, 2, '222', 2, '2', '2', '2022-06-27 16:31:15'),
(48, 2, '22', 2, '2', '2', '2022-06-27 16:32:30'),
(49, 2, '22', 2, '2', '2', '2022-06-27 16:32:47'),
(50, 3, '3', 3, '3', '3', '2022-06-27 16:33:23'),
(51, 3, '3', 3, '3', '3', '2022-06-27 16:34:06'),
(52, 3, '3', 3, '3', '3', '2022-06-27 16:34:29'),
(53, 3, '3', 3, '3', '3', '2022-06-27 16:35:03'),
(54, 2, '22', 2, '2', '2', '2022-06-27 16:35:20'),
(55, 2, '2', 2, '2', '2', '2022-06-27 16:35:46'),
(56, 3, '3', 3, '3', '3', '2022-06-27 16:36:04'),
(57, 2, '22', 2, '2', '2', '2022-06-27 16:36:16'),
(58, 2, '222', 2, '2', '2', '2022-06-27 16:36:44'),
(59, 2, '22', 2, '2', '2', '2022-06-27 16:36:55'),
(60, 2, '22', 2, '2', '2', '2022-06-27 16:37:13'),
(61, 2, '222', 2, '2', '2', '2022-06-27 16:37:51'),
(62, 2, '22', 2, '2', '2', '2022-06-27 16:38:31'),
(63, 2, '22', 2, '2', '2', '2022-06-27 16:38:58'),
(64, 2, '22', 2, '2', '', '2022-06-27 16:39:47'),
(65, 0, '', 0, '', '2', '2022-06-27 16:39:48'),
(66, 2, '22', 2, '2', '2', '2022-06-27 16:40:21'),
(67, 2, '2', 2, '2', '', '2022-06-27 16:40:53'),
(68, 2, '22', 2, '2', '2', '2022-06-27 16:41:08'),
(69, 2, '22', 2, '2', '2', '2022-06-27 16:41:21'),
(70, 2, '2', 2, '2', '2', '2022-06-27 16:41:29');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `password` varchar(15) NOT NULL,
  `rol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `correo`, `password`, `rol`) VALUES
(1, 'Julian', 'julian@correo.com', '123', 'Asistente'),
(2, 'Jero', 'jero@correo.com', '123', 'Administrador'),
(3, 'Maria', 'maria@correo.com', '123', 'Administrador'),
(4, 'h', 'hh', 'h', 'Seleccione'),
(5, 'j', 'j', 'j', 'Seleccione'),
(6, 'a', 'a', 'a', 'Administrador');

-- --------------------------------------------------------

--
-- Table structure for table `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `cliente` varchar(30) NOT NULL,
  `vendedor` varchar(30) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ventas`
--

INSERT INTO `ventas` (`id`, `cliente`, `vendedor`, `total`, `fecha`) VALUES
(34, 'prueba 2', 'Julian Bedoya', '85500.00', '2022-06-18 16:48:46'),
(35, 'prueba 2', 'Julian Bedoya', '165000.00', '2022-06-18 16:49:25'),
(36, 'prueba 2', 'Julian Bedoya', '2400.00', '2022-06-19 14:07:03'),
(37, 'prueba 2', '', '81900.00', '22/59/2022'),
(38, 'prueba 2', 'Jero', '7200.00', '26/29/2022');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `config`
--
ALTER TABLE `config`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `config`
--
ALTER TABLE `config`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
