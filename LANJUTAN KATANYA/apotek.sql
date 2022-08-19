-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2021 at 11:39 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `apotek`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `banyak_unit` ()  begin
	select unit,count(unit) as jumlah from table_med group by unit;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `expired` ()  begin
	select nama_obat from table_med where kedaluwarsa = now() || now() >= date_sub(kedaluwarsa,interval 60 day);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `penjualan` (`thn` DATE)  begin
	select * from table_invoice where tgl_beli = thn;
end$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `maxx` () RETURNS INT(11) BEGIN
	RETURN (SELECT Max(grandtotal) FROM table_purchase);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `minn` () RETURNS INT(11) begin
	RETURN (select min(grandtotal) from table_invoice i);
end$$

CREATE DEFINER=`root`@`localhost` FUNCTION `penjualan` (`tamp` VARCHAR(20)) RETURNS INT(11) begin
declare bnyk int;
	set bnyk = (select count(*) from table_invoice where ref = tamp);
return bnyk;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `month`
--

CREATE TABLE `month` (
  `month_num` int(2) NOT NULL,
  `month_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `month`
--

INSERT INTO `month` (`month_num`, `month_name`) VALUES
(1, 'Januari'),
(2, 'Februari'),
(3, 'Maret'),
(4, 'April'),
(5, 'Mei'),
(6, 'Juni'),
(7, 'Juli'),
(8, 'Agustus'),
(9, 'September'),
(10, 'Oktober'),
(11, 'November'),
(12, 'Desember');

-- --------------------------------------------------------

--
-- Table structure for table `spring_session`
--

CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `spring_session`
--

INSERT INTO `spring_session` (`PRIMARY_ID`, `SESSION_ID`, `CREATION_TIME`, `LAST_ACCESS_TIME`, `MAX_INACTIVE_INTERVAL`, `EXPIRY_TIME`, `PRINCIPAL_NAME`) VALUES
('e5c315c5-cf6a-4d07-829b-ab20b3f7bb66', '48c2a8a6-da86-4594-9203-f33e7e452b95', 1620106732154, 1620120835322, 1800, 1620122635322, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `spring_session_attributes`
--

CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `spring_session_attributes`
--

INSERT INTO `spring_session_attributes` (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_BYTES`) VALUES
('e5c315c5-cf6a-4d07-829b-ab20b3f7bb66', 'email', 0xaced000574001368657264692e616e6140676d61696c2e636f6d),
('e5c315c5-cf6a-4d07-829b-ab20b3f7bb66', 'fullname', 0xaced00057400084865726469616e61),
('e5c315c5-cf6a-4d07-829b-ab20b3f7bb66', 'id_adm', 0xaced0005737200116a6176612e6c616e672e496e746567657212e2a0a4f781873802000149000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b020000787000000001),
('e5c315c5-cf6a-4d07-829b-ab20b3f7bb66', 'password', 0xaced0005740006313233343536),
('e5c315c5-cf6a-4d07-829b-ab20b3f7bb66', 'status', 0xaced00057400074d616e61676572);

-- --------------------------------------------------------

--
-- Table structure for table `table_adm`
--

CREATE TABLE `table_adm` (
  `id_adm` int(11) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `table_adm`
--

INSERT INTO `table_adm` (`id_adm`, `fullname`, `email`, `password`, `status`) VALUES
(1, 'Herdiana', 'herdi.ana@gmail.com', '123456', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `table_cat`
--

CREATE TABLE `table_cat` (
  `id_kat` int(3) NOT NULL,
  `nama_kategori` varchar(30) NOT NULL,
  `des_kat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `table_cat`
--

INSERT INTO `table_cat` (`id_kat`, `nama_kategori`, `des_kat`) VALUES
(207, 'Antioksidan', 'Mencegah penuaan dini'),
(208, 'Anti Depresan', 'Mengurangi depresi'),
(209, 'Vitamin', 'Suplemen'),
(216, 'Stimulan', 'Menstimulasi hewan'),
(217, 'Antibiotik', 'bakteriostatik'),
(222, 'Hemolitika', 'Menghentikan pendarahan'),
(223, 'Paracetamol', 'Jenis Penurun Panas dan Demam dan lain lain'),
(226, 'Anti-Derma', 'untuk masalah penyakit kulit'),
(227, 'Anti-Radang', 'untuk mengatasi masalah peradangan');

--
-- Triggers `table_cat`
--
DELIMITER $$
CREATE TRIGGER `delete_child2` BEFORE DELETE ON `table_cat` FOR EACH ROW begin
	delete from table_med where nama_kategori = old.nama_kategori;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `table_invoice`
--

CREATE TABLE `table_invoice` (
  `id_tagihan` int(5) NOT NULL,
  `ref` varchar(10) NOT NULL,
  `nama_obat` varchar(30) NOT NULL,
  `harga_jual` int(11) NOT NULL,
  `banyak` int(3) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `nama_pembeli` varchar(40) NOT NULL,
  `tgl_beli` date NOT NULL,
  `grandtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `table_invoice`
--

INSERT INTO `table_invoice` (`id_tagihan`, `ref`, `nama_obat`, `harga_jual`, `banyak`, `subtotal`, `nama_pembeli`, `tgl_beli`, `grandtotal`) VALUES
(80, 'JMBSErmmo0', 'Adona', 15000, 1, 15000, 'Melinda', '2018-08-09', 29000),
(81, 'JMBSErmmo0', 'Asam Mefenamat', 4000, 1, 4000, 'Melinda', '2018-08-09', 29000),
(82, 'JMBSErmmo0', 'Salbutamol', 10000, 1, 10000, 'Melinda', '2018-08-09', 29000),
(87, 'xl23Q6whsP', 'Salbutamol', 10000, 3, 30000, 'Melinda', '2018-01-10', 30000),
(90, '9ab7RcZHma', 'Adrome', 15000, 6, 90000, 'Doni', '2018-02-14', 90000),
(91, 'fAMEjr9rA0', 'Ambroxol', 22000, 5, 110000, 'Amirullah', '2018-03-14', 110000),
(92, 'so5518T1vI', 'Salbutamol', 10000, 6, 60000, 'Doni', '2018-04-18', 60000),
(97, 'VS27jjD5Ze', 'Ambroxol', 22000, 1, 22000, 'Pitaloka', '2018-07-18', 32000),
(98, 'VS27jjD5Ze', 'Stimuno', 10000, 1, 10000, 'Pitaloka', '2018-07-18', 32000),
(99, 'nyptFm9i43', 'Stimuno', 10000, 3, 30000, 'Andi', '2018-06-13', 30000),
(101, 'e7QgBweE8X', 'Adrome', 15000, 1, 15000, 'Andi', '2018-09-15', 15000),
(105, 'zPpAfLsmd7', 'Adrome', 15000, 1, 15000, 'Amila', '2018-05-16', 25000),
(106, 'zPpAfLsmd7', 'Amoxilin', 10000, 1, 10000, 'Amila', '2018-05-16', 25000),
(119, 'FfndSkUmh6', 'Asam Mefenamat', 4000, 2, 8000, 'Alina', '2018-09-24', 12000),
(120, 'FfndSkUmh6', 'Vitamin E', 4000, 1, 4000, 'Alina', '2018-09-24', 12000),
(121, 'cOltdILbc6', 'Adrome', 15000, 5, 75000, 'Jamil Hamdi', '2021-04-27', 185000),
(122, 'cOltdILbc6', 'Ambroxol', 22000, 5, 110000, 'Jamil Hamdi', '2021-04-27', 185000),
(123, 'kHQIDfCbky', 'Amoxilin', 10000, 1, 10000, 'Herdi', '2021-04-28', 16000),
(124, 'kHQIDfCbky', 'Cetirizen', 3000, 2, 6000, 'Herdi', '2021-04-28', 16000),
(125, 'VsAbNGo8yh', 'Cetirizen', 3000, 2, 6000, 'Iqbal Sihabudin', '2021-04-29', 46000),
(126, 'VsAbNGo8yh', 'Amoxilin', 10000, 4, 40000, 'Iqbal Sihabudin', '2021-04-29', 46000),
(127, 'G6DGYjrIZI', 'Adrome', 15000, 1, 15000, 'Helma', '2021-04-29', 55000),
(128, 'G6DGYjrIZI', 'Amoxilin', 10000, 4, 40000, 'Helma', '2021-04-29', 55000),
(132, '0LIF0LgrF2', 'Amoxilin', 10000, 1, 10000, 'Herdi', '2021-05-01', 47000),
(133, '0LIF0LgrF2', 'Cetirizen', 3000, 11, 33000, 'Herdi', '2021-05-01', 47000),
(134, '0LIF0LgrF2', 'Asam Mefenamat', 4000, 1, 4000, 'Herdi', '2021-05-01', 47000),
(135, '3bBNUxp4sP', 'Ambroxol', 22000, 2, 44000, 'Elvina', '2021-05-01', 50000),
(136, '3bBNUxp4sP', 'Corovit', 3000, 2, 6000, 'Elvina', '2021-05-01', 50000),
(137, 'WHE9AXB3T0', 'Ambroxol', 22000, 3, 66000, 'Sihabudin Ali', '2021-05-02', 86000),
(138, 'WHE9AXB3T0', 'Amoxilin', 10000, 1, 10000, 'Sihabudin Ali', '2021-05-02', 86000),
(139, 'WHE9AXB3T0', 'Salbutamol', 10000, 1, 10000, 'Sihabudin Ali', '2021-05-02', 86000),
(140, 'dkfkdhhfhd', 'Salbutamol', 10000, 2, 20000, 'Herdi', '2021-05-03', 20000),
(141, 'ggfggfg', 'Salbutamol', 10000, 2, 20000, 'Herdi', '2021-05-03', 20000),
(142, 'fuiihfd', 'Salbutamol', 10000, 2, 20000, 'Herdi', '2021-05-04', 20000),
(143, 'K95SEDG51T', 'Calpanax', 15000, 2, 30000, 'Sihabudin Ali', '2021-05-04', 40000),
(144, 'K95SEDG51T', 'Paramex', 2000, 5, 10000, 'Sihabudin Ali', '2021-05-04', 40000),
(145, 'NKZ8HXJMNB', 'Salbutamol', 10000, 5, 50000, 'Ari Sandi', '2021-05-04', 50000);

--
-- Triggers `table_invoice`
--
DELIMITER $$
CREATE TRIGGER `penjualan` AFTER INSERT ON `table_invoice` FOR EACH ROW begin
	update table_med set stok = stok-new.banyak where nama_obat = new.nama_obat;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `table_med`
--

CREATE TABLE `table_med` (
  `id_obat` int(4) NOT NULL,
  `nama_obat` varchar(30) NOT NULL,
  `penyimpanan` varchar(30) NOT NULL,
  `stok` int(3) NOT NULL,
  `unit` varchar(20) NOT NULL,
  `nama_kategori` varchar(30) NOT NULL,
  `kedaluwarsa` date NOT NULL,
  `des_obat` text NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `harga_jual` int(11) NOT NULL,
  `nama_pemasok` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `table_med`
--

INSERT INTO `table_med` (`id_obat`, `nama_obat`, `penyimpanan`, `stok`, `unit`, `nama_kategori`, `kedaluwarsa`, `des_obat`, `harga_beli`, `harga_jual`, `nama_pemasok`) VALUES
(1008, 'Asam Mefenamat', 'Gudang', 40, 'Semprot', 'Antioksidan', '2020-07-20', 'Untuk meringankan gejala nyeri', 4000, 4000, 'Bina Jaya Apotek'),
(1016, 'Salbutamol', 'Gudang', 10, 'Sirup', 'Antioksidan', '2020-07-20', 'Tidak ada', 6000, 10000, 'Bina Jaya Apotek'),
(1043, 'Calpanax', 'Lemari', 98, 'Cream', 'Anti-Derma', '2021-08-07', '', 12000, 15000, 'Kimia Farma'),
(1044, 'Paramex', 'Etalase', 145, 'Tablet', 'Anti Depresan', '2021-10-09', '', 1500, 2000, 'Surya Farmasi'),
(1045, 'Panadol', 'Etalase', 100, 'Tablet', 'Anti Depresan', '2021-05-04', '', 2800, 3000, 'Kenanga Apotek');

--
-- Triggers `table_med`
--
DELIMITER $$
CREATE TRIGGER `delete_child3` BEFORE DELETE ON `table_med` FOR EACH ROW begin
	delete from table_purchase where nama_obat = old.nama_obat;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `table_purchase`
--

CREATE TABLE `table_purchase` (
  `id_pembelian` int(5) NOT NULL,
  `ref` varchar(10) NOT NULL,
  `nama_obat` varchar(30) NOT NULL,
  `harga_beli` int(11) NOT NULL,
  `banyak` int(3) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `nama_pemasok` varchar(40) NOT NULL,
  `tgl_beli` date NOT NULL,
  `grandtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `table_purchase`
--

INSERT INTO `table_purchase` (`id_pembelian`, `ref`, `nama_obat`, `harga_beli`, `banyak`, `subtotal`, `nama_pemasok`, `tgl_beli`, `grandtotal`) VALUES
(3, 'L8BvtCyFDZ', 'Salbutamol', 6000, 3, 18000, 'Bina Jaya Apotek', '2018-08-11', 24000),
(4, 'L8BvtCyFDZ', 'Stimuno', 6000, 1, 6000, 'Bina Jaya Apotek', '2018-08-11', 24000),
(8, 'pwoaFcmGVs', 'Asam Mefenamat', 4000, 12, 48000, 'Bina Jaya Apotek', '2018-02-22', 48000),
(9, '96kHYMepS9', 'Salbutamol', 6000, 7, 42000, 'Bina Jaya Apotek', '2018-03-21', 42000),
(10, 'Tbb6pLVCJr', 'Ambroxol', 20000, 4, 80000, 'Bina Jaya Apotek', '2018-01-24', 80000),
(11, 'fdMGrBa4nS', 'Stimuno', 6000, 16, 96000, 'Bina Jaya Apotek', '2018-04-18', 96000),
(12, 'aDxtUA0rsc', 'Adrome', 12000, 6, 72000, 'Bina Jaya Apotek', '2018-05-09', 72000),
(14, 'KCZxZ1MqID', 'Ambroxol', 20000, 2, 40000, 'Bina Jaya Apotek', '2018-07-18', 40000),
(15, 'Ar9235n1ny', 'Adrome', 12000, 3, 36000, 'Kenanga Apotek', '2018-06-06', 56000),
(16, 'Ar9235n1ny', 'Ambroxol', 20000, 1, 20000, 'Kenanga Apotek', '2018-06-06', 56000),
(25, 'q8ke6ToBMo', 'Cetirizen', 2000, 3, 6000, 'Kenanga Apotek', '2018-09-24', 6000),
(26, 'EsgLJXxjyQ', 'Ambroxol', 20000, 12, 240000, 'Kenanga Apotek', '2021-04-28', 1140000),
(27, 'EsgLJXxjyQ', 'Cetirizen', 2000, 100, 200000, 'Kenanga Apotek', '2021-04-28', 1140000),
(28, 'EsgLJXxjyQ', 'Ambroxol', 20000, 35, 700000, 'Kenanga Apotek', '2021-04-28', 1140000),
(29, '3p3m9P5GKz', 'Vitamin E', 3000, 1, 6000, 'Bina Jaya Apotek', '2021-05-01', 6000),
(33, 'aPsI0eay3I', 'Salbutamol', 6000, 2, 12000, 'Bina Jaya Apotek', '2021-05-02', 12000),
(35, 'fhdhkhfdfh', 'Salbutamol', 4000, 5, 20000, 'Kenanga Apotek', '2021-05-04', 20000),
(42, 'PWCARGSOP3', 'Asam Mefenamat', 4000, 30, 120000, 'Bina Jaya Apotek', '2021-05-04', 120000);

--
-- Triggers `table_purchase`
--
DELIMITER $$
CREATE TRIGGER `pembelian` AFTER INSERT ON `table_purchase` FOR EACH ROW BEGIN
	UPDATE table_med SET stok = stok+new.banyak WHERE nama_obat = new.nama_obat;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `table_sup`
--

CREATE TABLE `table_sup` (
  `id_pem` int(3) NOT NULL,
  `nama_pemasok` varchar(30) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `table_sup`
--

INSERT INTO `table_sup` (`id_pem`, `nama_pemasok`, `alamat`, `telepon`) VALUES
(101, 'Bina Jaya Apotek', 'Jalan Kaliurang KM 7', '089693330253'),
(103, 'Kimia Farma', 'Jalan Kaliurang', '025745559999'),
(104, 'Tina Farma', 'Jalan Kaliurang', '08775544'),
(105, 'Kenanga Apotek', 'Jalan Magelang', '08965555'),
(108, 'Surya Farmasi', 'Jalan Magelang KM 9 Kota Magelang', '08546677790'),
(110, 'Ari Sandi Jaya Tbk', 'Jl Dakota No.8A Sukaraja, Cicendo, Kota Bandung', '025745559999');

--
-- Triggers `table_sup`
--
DELIMITER $$
CREATE TRIGGER `delete_child4` BEFORE DELETE ON `table_sup` FOR EACH ROW BEGIN
	DELETE FROM table_purchase WHERE nama_pemasok = old.nama_pemasok;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `table_unit`
--

CREATE TABLE `table_unit` (
  `id_unit` int(2) NOT NULL,
  `unit` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `table_unit`
--

INSERT INTO `table_unit` (`id_unit`, `unit`) VALUES
(8, 'Cream'),
(1, 'Kapsul'),
(2, 'Semprot'),
(3, 'Sirup'),
(7, 'Tablet');

--
-- Triggers `table_unit`
--
DELIMITER $$
CREATE TRIGGER `delete_child` BEFORE DELETE ON `table_unit` FOR EACH ROW begin
	delete from table_med where unit = old.unit;
end
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `month`
--
ALTER TABLE `month`
  ADD PRIMARY KEY (`month_num`);

--
-- Indexes for table `spring_session`
--
ALTER TABLE `spring_session`
  ADD PRIMARY KEY (`PRIMARY_ID`),
  ADD UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  ADD KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  ADD KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`);

--
-- Indexes for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`);

--
-- Indexes for table `table_adm`
--
ALTER TABLE `table_adm`
  ADD PRIMARY KEY (`id_adm`);

--
-- Indexes for table `table_cat`
--
ALTER TABLE `table_cat`
  ADD PRIMARY KEY (`id_kat`),
  ADD UNIQUE KEY `kategori` (`nama_kategori`);

--
-- Indexes for table `table_invoice`
--
ALTER TABLE `table_invoice`
  ADD PRIMARY KEY (`id_tagihan`);

--
-- Indexes for table `table_med`
--
ALTER TABLE `table_med`
  ADD PRIMARY KEY (`id_obat`),
  ADD UNIQUE KEY `nama_obat` (`nama_obat`),
  ADD KEY `med_unit` (`unit`),
  ADD KEY `med_cat` (`nama_kategori`),
  ADD KEY `med_sup` (`nama_pemasok`);

--
-- Indexes for table `table_purchase`
--
ALTER TABLE `table_purchase`
  ADD PRIMARY KEY (`id_pembelian`);

--
-- Indexes for table `table_sup`
--
ALTER TABLE `table_sup`
  ADD PRIMARY KEY (`id_pem`),
  ADD UNIQUE KEY `nama_supplier` (`nama_pemasok`);

--
-- Indexes for table `table_unit`
--
ALTER TABLE `table_unit`
  ADD PRIMARY KEY (`id_unit`),
  ADD UNIQUE KEY `unit` (`unit`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_adm`
--
ALTER TABLE `table_adm`
  MODIFY `id_adm` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `table_cat`
--
ALTER TABLE `table_cat`
  MODIFY `id_kat` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=228;

--
-- AUTO_INCREMENT for table `table_invoice`
--
ALTER TABLE `table_invoice`
  MODIFY `id_tagihan` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT for table `table_med`
--
ALTER TABLE `table_med`
  MODIFY `id_obat` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1046;

--
-- AUTO_INCREMENT for table `table_purchase`
--
ALTER TABLE `table_purchase`
  MODIFY `id_pembelian` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `table_sup`
--
ALTER TABLE `table_sup`
  MODIFY `id_pem` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- AUTO_INCREMENT for table `table_unit`
--
ALTER TABLE `table_unit`
  MODIFY `id_unit` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;

--
-- Constraints for table `table_med`
--
ALTER TABLE `table_med`
  ADD CONSTRAINT `med_sup` FOREIGN KEY (`nama_pemasok`) REFERENCES `table_sup` (`nama_pemasok`) ON UPDATE CASCADE,
  ADD CONSTRAINT `med_unit` FOREIGN KEY (`unit`) REFERENCES `table_unit` (`unit`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
