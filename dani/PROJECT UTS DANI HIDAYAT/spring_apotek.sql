/*
SQLyog Community v13.1.8 (64 bit)
MySQL - 10.4.22-MariaDB : Database - spring_apotek
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_apotek` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `spring_apotek`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id_adm` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_adm`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin` */

insert  into `admin`(`id_adm`,`email`,`nama`,`password`) values 
(1,'admin@gmail.com','admin','admin');

/*Table structure for table `kategori` */

DROP TABLE IF EXISTS `kategori`;

CREATE TABLE `kategori` (
  `id_kat` int(11) NOT NULL AUTO_INCREMENT,
  `keterangan` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_kat`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kategori` */

insert  into `kategori`(`id_kat`,`keterangan`,`nama`) values 
(1,'Mencegah penuaan dini','Antioksidan'),
(2,'Mengurangi depresi','Anti Depresin'),
(3,'Suplemen','Vitamin'),
(4,'Menstimulasi hewan','Stimulan'),
(5,'Meredakan sakit','Antibiotik'),
(6,'Penurun panas demam','Paracetamol');

/*Table structure for table `obat` */

DROP TABLE IF EXISTS `obat`;

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL AUTO_INCREMENT,
  `hargabeli` int(11) DEFAULT NULL,
  `hargajual` int(11) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `pemasok` varchar(255) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_obat`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `obat` */

insert  into `obat`(`id_obat`,`hargabeli`,`hargajual`,`kategori`,`nama`,`pemasok`,`stok`,`unit`) values 
(1,5000,7000,'Antioksidan','Asam Astefat','Tina Farma',40,'Tablet'),
(2,15000,19000,'Stimulan','Combantrine','Kimia Farma',80,'Sirup'),
(3,400,800,'Antibiotik','Salbutamol','Dani Farmasi',65,'Kaplet'),
(4,4000,5000,'Antibiotik','Paramex','Bina Jaya Apotek',140,'Tablet');

/*Table structure for table `pegawai` */

DROP TABLE IF EXISTS `pegawai`;

CREATE TABLE `pegawai` (
  `id_peg` int(11) NOT NULL AUTO_INCREMENT,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `jk` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nohp` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_peg`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pegawai` */

insert  into `pegawai`(`id_peg`,`alamat`,`email`,`jk`,`nama`,`nohp`,`status`) values 
(1,'Pekanbaru','dani@gmail.com','Laki-laki','Dani Hidayat','0895631810165','Pegawai'),
(2,'Boyolali','romi.kece@gmail.com','Laki-laki','Romi Kusuma Bakti','081265971289','Pegawai'),
(3,'Pekanbaru','mitaku@gmail.com','Laki-laki','Mita Zuriati','086701928374','Pegawai');

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `id_peg` int(11) NOT NULL AUTO_INCREMENT,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `jk` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nohp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_peg`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pelanggan` */

insert  into `pelanggan`(`id_peg`,`alamat`,`email`,`jk`,`nama`,`nohp`) values 
(1,'Banjarsari','purnama@gmail.com','Laki-laki','Aris Purnama','089286375193'),
(2,'Pekanbaru','fitri.elvina@gmail.com','Perempuan','Elvina Fitriani','089288100193'),
(3,'Banyumas','aini.aini@gmail.com','Perempuan','Nurul Aini','089286378888');

/*Table structure for table `pemasok` */

DROP TABLE IF EXISTS `pemasok`;

CREATE TABLE `pemasok` (
  `id_peg` int(11) NOT NULL AUTO_INCREMENT,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nohp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_peg`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pemasok` */

insert  into `pemasok`(`id_peg`,`alamat`,`email`,`nama`,`nohp`) values 
(1,'Jalan Dakota No 35','jaya.apotek@gmail.com','Bina Jaya Apotek','089286654393'),
(2,'Jalan Sudirman No 8A','kimia_farma@gmail.com','Kimia Farma','084499665193'),
(3,'Jalan Pegawai No 88','farmatina@gmail.com','Tina Farma','089948239612'),
(4,'Jalan Sakuntala No 4A','farmasi_dani@gmail.com','Dani Farmasi','089371925427');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
