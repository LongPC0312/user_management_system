-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 17, 2025 at 09:27 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salemanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE IF NOT EXISTS `hoadon` (
  `MaHD` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaKH` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaNV` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayGD` datetime NOT NULL,
  `TGia` double(10,2) NOT NULL,
  PRIMARY KEY (`MaHD`),
  KEY `MaKH` (`MaKH`),
  KEY `MaNV` (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKH`, `MaNV`, `NgayGD`, `TGia`) VALUES
('HD1', '001', '001', '2025-10-17 00:00:00', 2550000.00);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `MaKH` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HTen` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `DChi` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayS` date NOT NULL,
  `NgayDK` date NOT NULL,
  `DSo` double NOT NULL,
  PRIMARY KEY (`MaKH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `HTen`, `DChi`, `SoDT`, `NgayS`, `NgayDK`, `DSo`) VALUES
('001', 'Đỗ Hoàng Long', '009 Chung cư Him Lam', '0397761190', '2000-12-03', '2022-12-03', 2000000);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MaNV` bigint(255) NOT NULL AUTO_INCREMENT,
  `HTen` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SoDT` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `NgayVL` date NOT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `HTen`, `SoDT`, `NgayVL`) VALUES
(1, 'Nguyễn Văn A', '0912345678', '2023-10-03'),
(4, 'Quan', '0397761180', '2025-12-01'),
(7, 'Hai', '0908593866', '2025-04-01'),
(8, 'Loan', '0123456789', '2025-04-09'),
(11, 'Trang', '0123456789', '2025-04-30'),
(12, 'Cường', '9876543210', '2025-04-21'),
(13, 'Kiên', '0123456789', '2025-04-12'),
(14, 'Madam', '0908593866', '2025-04-10');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE IF NOT EXISTS `sanpham` (
  `MaSP` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `TenSP` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `SL` int(11) NOT NULL,
  `NoiSX` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Gia` decimal(10,2) NOT NULL,
  PRIMARY KEY (`MaSP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`MaSP`, `TenSP`, `SL`, `NoiSX`, `Gia`) VALUES
('BanChai001', 'Bàn Chải MaxFresh', 10, 'China', '15000.00');

-- --------------------------------------------------------

--
-- Table structure for table `tttk`
--

DROP TABLE IF EXISTS `tttk`;
CREATE TABLE IF NOT EXISTS `tttk` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `TK` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `MK` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `VTro` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tttk`
--

INSERT INTO `tttk` (`ID`, `TK`, `MK`, `VTro`) VALUES
(1, 'long', '123', 'Admin'),
(3, 'Quân', '123', 'Khách hàng'),
(4, 'Loan', '123', 'Nhân viên'),
(5, 'beba', '123', 'Nhân viên'),
(6, 'hai', '123', 'Nhân viên');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
