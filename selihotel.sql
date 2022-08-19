/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.17-MariaDB : Database - selihotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`selihotel` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `selihotel`;

/*Table structure for table `detail_kamar` */

DROP TABLE IF EXISTS `detail_kamar`;

CREATE TABLE `detail_kamar` (
  `id_transaksi` char(5) NOT NULL,
  `id_kamar` char(5) NOT NULL,
  KEY `fk_transaksi` (`id_transaksi`),
  KEY `fk_kamar` (`id_kamar`),
  CONSTRAINT `fk_kamar` FOREIGN KEY (`id_kamar`) REFERENCES `kamar` (`id_kamar`),
  CONSTRAINT `fk_transaksi` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `detail_kamar` */

insert  into `detail_kamar`(`id_transaksi`,`id_kamar`) values 
('TR001','K0001'),
('TR002','K0003');

/*Table structure for table `detail_makan` */

DROP TABLE IF EXISTS `detail_makan`;

CREATE TABLE `detail_makan` (
  `id_transaksi` char(5) NOT NULL,
  `id_makanan` char(5) NOT NULL,
  `id_minuman` char(5) NOT NULL,
  KEY `fk_transaksi1` (`id_transaksi`),
  KEY `fk_makanan` (`id_makanan`),
  KEY `fk_minuman` (`id_minuman`),
  CONSTRAINT `fk_makanan` FOREIGN KEY (`id_makanan`) REFERENCES `makanan` (`id_makanan`),
  CONSTRAINT `fk_minuman` FOREIGN KEY (`id_minuman`) REFERENCES `minuman` (`id_minuman`),
  CONSTRAINT `fk_transaksi1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `detail_makan` */

insert  into `detail_makan`(`id_transaksi`,`id_makanan`,`id_minuman`) values 
('TR001','MK001','MN002'),
('TR002','MK002','MN002');

/*Table structure for table `kamar` */

DROP TABLE IF EXISTS `kamar`;

CREATE TABLE `kamar` (
  `id_kamar` char(5) NOT NULL,
  `tipe_kamar` varchar(30) NOT NULL,
  `harga_kamar` int(11) NOT NULL,
  PRIMARY KEY (`id_kamar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `kamar` */

insert  into `kamar`(`id_kamar`,`tipe_kamar`,`harga_kamar`) values 
('K0001','Standar',750000),
('K0002','Executive',850000),
('K0003','Deluxe',900000),
('K0004','Suite',950000);

/*Table structure for table `makanan` */

DROP TABLE IF EXISTS `makanan`;

CREATE TABLE `makanan` (
  `id_makanan` char(5) NOT NULL,
  `menu_makanan` varchar(30) NOT NULL,
  `harga_makanan` int(11) NOT NULL,
  PRIMARY KEY (`id_makanan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `makanan` */

insert  into `makanan`(`id_makanan`,`menu_makanan`,`harga_makanan`) values 
('MK001','Seafood',56000),
('MK002','Sundanese',30000),
('MK003','Chinese',25000),
('MK004','Padang',17000),
('MK005','Mie Goreng',12000);

/*Table structure for table `minuman` */

DROP TABLE IF EXISTS `minuman`;

CREATE TABLE `minuman` (
  `id_minuman` char(5) NOT NULL,
  `menu_minuman` varchar(30) NOT NULL,
  `harga_minuman` int(11) NOT NULL,
  PRIMARY KEY (`id_minuman`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `minuman` */

insert  into `minuman`(`id_minuman`,`menu_minuman`,`harga_minuman`) values 
('MN001','Softdrink',5000),
('MN002','coffee',8000),
('MN003','Bottle tea',4500);

/*Table structure for table `tamu` */

DROP TABLE IF EXISTS `tamu`;

CREATE TABLE `tamu` (
  `id_tamu` char(5) NOT NULL,
  `nama_tamu` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `nomor_telepon` int(13) NOT NULL,
  PRIMARY KEY (`id_tamu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tamu` */

insert  into `tamu`(`id_tamu`,`nama_tamu`,`alamat`,`nomor_telepon`) values 
('T0001','Seli Deslia','KBB',2147483647),
('T0002','Avita Diah Saputri','Blasteran',2147483647),
('T0003','Riyanda Ramadan','Banyumas',2147483647),
('T0004','Melani Putri','Banjar',2147483647);

/*Table structure for table `transaksi` */

DROP TABLE IF EXISTS `transaksi`;

CREATE TABLE `transaksi` (
  `id_transaksi` char(5) NOT NULL,
  `id_tamu` char(5) NOT NULL,
  `tgl_checkin` date NOT NULL,
  `tgl_checkout` date NOT NULL,
  `lama_inap` int(11) NOT NULL,
  `total_biaya` int(11) NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `fk_tamu` (`id_tamu`),
  CONSTRAINT `fk_tamu` FOREIGN KEY (`id_tamu`) REFERENCES `tamu` (`id_tamu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `transaksi` */

insert  into `transaksi`(`id_transaksi`,`id_tamu`,`tgl_checkin`,`tgl_checkout`,`lama_inap`,`total_biaya`) values 
('TR001','T0001','2022-04-01','2022-04-02',1,750000),
('TR002','T0002','2022-04-04','2022-04-06',2,1800000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
