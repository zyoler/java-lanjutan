DROP DATABASE pub;
CREATE DATABASE pub;
USE pub;

CREATE TABLE provinsi (
	id CHAR(2) NOT NULL PRIMARY KEY,
	nama VARCHAR(32) NOT NULL,
    lintang DOUBLE PRECISION NOT NULL,
    bujur DOUBLE PRECISION NOT NULL
);

INSERT INTO provinsi VALUES
	(11, 'Aceh', 4.368550, 97.025300),
	(12, 'Sumatera Utara', 2.192350, 99.381220),
	(13, 'Sumatera Barat', -1.342250, 100.076100),
	(14, 'Riau', 0.500410, 101.547580),
	(15, 'Jambi', -1.611570, 102.779700),
	(16, 'Sumatera Selatan', -3.126680, 104.093060),
	(17, 'Bengkulu', -3.518680, 102.535980),
	(18, 'Lampung', -4.855500, 105.027300),
	(19, 'Kepulauan Bangka Belitung', -2.757750, 107.583940),
	(21, 'Kepulauan Riau', -0.154780, 104.580370),
	(31, 'Dki Jakarta', 6.174500, 106.822700),
	(32, 'Jawa Barat', -6.889170, 107.640470),
	(33, 'Jawa Tengah', -7.303240, 110.004410),
	(34, 'Di Yogyakarta', 7.795600, 110.369500),
	(35, 'Jawa Timur', -6.968510, 113.980050),
	(36, 'Banten', -6.445380, 106.137560),
	(51, 'Bali', -8.235660, 115.122390),
	(52, 'Nusa Tenggara Barat', -8.121790, 117.636960),
	(53, 'Nusa Tenggara Timur', -8.565680, 120.697860),
	(61, 'Kalimantan Barat', -0.132240, 111.096890),
	(62, 'Kalimantan Tengah', -1.499580, 113.290330),
	(63, 'Kalimantan Selatan', -2.943480, 115.375650),
	(64, 'Kalimantan Timur', 0.788440, 116.242000),
	(65, 'Kalimantan Utara', 2.725940, 116.911000),
	(71, 'Sulawesi Utara', 0.655570, 124.090150),
	(72, 'Sulawesi Tengah', -1.693780, 120.808860),
	(73, 'Sulawesi Selatan', -3.644670, 119.947190),
	(74, 'Sulawesi Tenggara', -3.549120, 121.727960),
	(75, 'Gorontalo', 0.718620, 122.455590),
	(76, 'Sulawesi Barat', -2.497450, 119.391900),
	(81, 'Maluku', -3.118840, 129.420780),
	(82, 'Maluku Utara', 0.630120, 127.972020),
	(91, 'Papua Barat', -1.384240, 132.902530),
	(94, 'Papua', -3.988570, 138.348530);

CREATE TABLE kabupaten (
	id CHAR(4) NOT NULL PRIMARY KEY,
	provinsi CHAR(2) NOT NULL,
	nama VARCHAR(64) NOT NULL,
    lintang DOUBLE PRECISION NOT NULL,
    bujur DOUBLE PRECISION NOT NULL,
	FOREIGN KEY (provinsi) REFERENCES provinsi (id)
);

INSERT INTO kabupaten VALUES
	(1101, 11, 'Kabupaten Simeulue', 2.616670, 96.083330),
	(1102, 11, 'Kabupaten Aceh Singkil', 2.416670, 97.916670),
	(1103, 11, 'Kabupaten Aceh Selatan', 3.166670, 97.416670),
	(1104, 11, 'Kabupaten Aceh Tenggara', 3.366670, 97.700000),
	(1105, 11, 'Kabupaten Aceh Timur', 4.633330, 97.633330),
	(1106, 11, 'Kabupaten Aceh Tengah', 4.510000, 96.855000),
	(1107, 11, 'Kabupaten Aceh Barat', 4.450000, 96.166670),
	(1108, 11, 'Kabupaten Aceh Besar', 5.383330, 95.516670),
	(1109, 11, 'Kabupaten Pidie', 5.080000, 96.110000),
	(1110, 11, 'Kabupaten Bireuen', 5.083330, 96.583330),
	(1111, 11, 'Kabupaten Aceh Utara', 4.970000, 97.140000),
	(1112, 11, 'Kabupaten Aceh Barat Daya', 3.833330, 96.883330),
	(1113, 11, 'Kabupaten Gayo Lues', 3.950000, 97.390000),
	(1114, 11, 'Kabupaten Aceh Tamiang', 4.250000, 97.966670),
	(1115, 11, 'Kabupaten Nagan Raya', 4.166670, 96.516670),
	(1116, 11, 'Kabupaten Aceh Jaya', 4.860000, 95.640000),
	(1117, 11, 'Kabupaten Bener Meriah', 4.730150, 96.861560),
	(1118, 11, 'Kabupaten Pidie Jaya', 5.150000, 96.216670),
	(1171, 11, 'Kota Banda Aceh', 5.541670, 95.333330),
	(1172, 11, 'Kota Sabang', 5.821640, 95.310860),
	(1173, 11, 'Kota Langsa', 4.470000, 97.930000),
	(1174, 11, 'Kota Lhokseumawe', 5.133330, 97.066670),
	(1175, 11, 'Kota Subulussalam', 2.750000, 97.933330),
	(1201, 12, 'Kabupaten Nias', 1.033330, 97.766670),
	(1202, 12, 'Kabupaten Mandailing Natal', 0.783780, 99.254950),
	(1203, 12, 'Kabupaten Tapanuli Selatan', 1.516670, 99.250000),
	(1204, 12, 'Kabupaten Tapanuli Tengah', 1.900000, 98.666670),
	(1205, 12, 'Kabupaten Tapanuli Utara', 2.002800, 99.070700),
	(1206, 12, 'Kabupaten Toba Samosir', 2.397930, 99.216780),
	(1207, 12, 'Kabupaten Labuhan Batu', 2.266670, 100.100000),
	(1208, 12, 'Kabupaten Asahan', 2.783330, 99.550000),
	(1209, 12, 'Kabupaten Simalungun', 2.900000, 99.000000),
	(1210, 12, 'Kabupaten Dairi', 2.866670, 98.233330),
	(1211, 12, 'Kabupaten Karo', 3.116670, 98.300000),
	(1212, 12, 'Kabupaten Deli Serdang', 3.416670, 98.666670),
	(1213, 12, 'Kabupaten Langkat', 3.716670, 98.216670),
	(1214, 12, 'Kabupaten Nias Selatan', 0.770000, 97.750000),
	(1215, 12, 'Kabupaten Humbang Hasundutan', 2.265510, 98.503760),
	(1216, 12, 'Kabupaten Pakpak Bharat', 2.566670, 98.283330),
	(1217, 12, 'Kabupaten Samosir', 2.640250, 98.715250),
	(1218, 12, 'Kabupaten Serdang Bedagai', 3.366670, 99.033330),
	(1219, 12, 'Kabupaten Batu Bara', 3.161660, 99.526520),
	(1220, 12, 'Kabupaten Padang Lawas Utara', 1.460110, 99.673460),
	(1221, 12, 'Kabupaten Padang Lawas', 1.446840, 99.992070),
	(1222, 12, 'Kabupaten Labuhan Batu Selatan', 1.983000, 100.097600),
	(1223, 12, 'Kabupaten Labuhan Batu Utara', 2.333490, 99.637760),
	(1224, 12, 'Kabupaten Nias Utara', 1.330370, 97.319640),
	(1225, 12, 'Kabupaten Nias Barat', 1.059660, 97.586060),
	(1271, 12, 'Kota Sibolga', 1.733330, 98.800000),
	(1272, 12, 'Kota Tanjung Balai', 2.958330, 99.791670),
	(1273, 12, 'Kota Pematang Siantar', 2.966670, 99.050000),
	(1274, 12, 'Kota Tebing Tinggi', 3.325000, 99.141670),
	(1275, 12, 'Kota Medan', 3.650000, 98.666670),
	(1276, 12, 'Kota Binjai', 3.800000, 108.233330),
	(1277, 12, 'Kota Padang Sidempuan', 1.373750, 99.268430),
	(1278, 12, 'Kota Gunungsitoli', 1.327310, 97.550180),
	(1301, 13, 'Kabupaten Kepulauan Mentawai', 1.989170, 99.518890),
	(1302, 13, 'Kabupaten Pesisir Selatan', -1.583330, 100.850000),
	(1303, 13, 'Kabupaten Solok', -0.966670, 100.816670),
	(1304, 13, 'Kabupaten Sijunjung', -1.182700, 101.605600),
	(1305, 13, 'Kabupaten Tanah Datar', -0.455500, 100.577100),
	(1306, 13, 'Kabupaten Padang Pariaman', -0.600000, 100.283330),
	(1307, 13, 'Kabupaten Agam', -0.250000, 100.166670),
	(1308, 13, 'Kabupaten Lima Puluh Kota', -0.016800, 100.587200),
	(1309, 13, 'Kabupaten Pasaman', 0.425030, 99.946060),
	(1310, 13, 'Kabupaten Solok Selatan', -1.233330, 101.417000),
	(1311, 13, 'Kabupaten Dharmasraya', -1.050000, 101.367000),
	(1312, 13, 'Kabupaten Pasaman Barat', 0.281520, 99.519650),
	(1371, 13, 'Kota Padang', -0.983330, 100.450000),
	(1372, 13, 'Kota Solok', -0.766670, 100.616670),
	(1373, 13, 'Kota Sawah Lunto', -0.600000, 100.750000),
	(1374, 13, 'Kota Padang Panjang', -0.450000, 100.433330),
	(1375, 13, 'Kota Bukittinggi', -0.275000, 100.375000),
	(1376, 13, 'Kota Payakumbuh', -0.233330, 100.633330),
	(1377, 13, 'Kota Pariaman', -0.626820, 100.120470),
	(1401, 14, 'Kabupaten Kuantan Singingi', -0.475320, 101.458570),
	(1402, 14, 'Kabupaten Indragiri Hulu', -0.550000, 102.316670),
	(1403, 14, 'Kabupaten Indragiri Hilir', -0.333330, 103.166670),
	(1404, 14, 'Kabupaten Pelalawan', 0.208220, 102.186070),
	(1405, 14, 'Kabupaten Siak', 0.974530, 102.013550),
	(1406, 14, 'Kabupaten Kampar', 0.234400, 101.213100),
	(1407, 14, 'Kabupaten Rokan Hulu', 0.883330, 100.483330),
	(1408, 14, 'Kabupaten Bengkalis', 0.983800, 102.509600),
	(1409, 14, 'Kabupaten Rokan Hilir', 2.165990, 100.825140),
	(1410, 14, 'Kabupaten Kepulauan Meranti', 0.974880, 102.695390),
	(1471, 14, 'Kota Pekanbaru', 0.533330, 101.466670),
	(1473, 14, 'Kota Dumai', 1.615920, 101.491700),
	(1501, 15, 'Kabupaten Kerinci', -2.033330, 101.533330),
	(1502, 15, 'Kabupaten Merangin', -2.069330, 102.133030),
	(1503, 15, 'Kabupaten Sarolangun', -2.300000, 102.650000),
	(1504, 15, 'Kabupaten Batang Hari', -1.750000, 103.116670),
	(1505, 15, 'Kabupaten Muaro Jambi', -1.552140, 103.821630),
	(1506, 15, 'Kabupaten Tanjung Jabung Timur', -1.131980, 103.617550),
	(1507, 15, 'Kabupaten Tanjung Jabung Barat', -1.154400, 103.244020),
	(1508, 15, 'Kabupaten Tebo', -1.455760, 102.374730),
	(1509, 15, 'Kabupaten Bungo', -1.502220, 101.960000),
	(1571, 15, 'Kota Jambi', -1.616670, 103.650000),
	(1572, 15, 'Kota Sungai Penuh', -2.108960, 101.321750),
	(1601, 16, 'Kabupaten Ogan Komering Ulu', -4.133330, 104.033330),
	(1602, 16, 'Kabupaten Ogan Komering Ilir', -3.366670, 105.366670),
	(1603, 16, 'Kabupaten Muara Enim', -4.232700, 103.614100),
	(1604, 16, 'Kabupaten Lahat', -3.786400, 103.542800),
	(1605, 16, 'Kabupaten Musi Rawas', -3.083330, 103.200000),
	(1606, 16, 'Kabupaten Musi Banyu Asin', -2.416670, 103.750000),
	(1607, 16, 'Kabupaten Banyu Asin', -2.883330, 104.383060),
	(1608, 16, 'Kabupaten Ogan Komering Ulu Selatan', -4.657280, 104.006590),
	(1609, 16, 'Kabupaten Ogan Komering Ulu Timur', -3.856790, 104.752090),
	(1610, 16, 'Kabupaten Ogan Ilir', -3.431860, 104.627270),
	(1611, 16, 'Kabupaten Empat Lawang', 3.226670, 99.092560),
	(1612, 16, 'Kabupaten Penukal Abab Lematang Ilir', -3.213420, 104.087220),
	(1613, 16, 'Kabupaten Musi Rawas Utara', -2.485330, 103.293460),
	(1671, 16, 'Kota Palembang', -3.000000, 104.716670),
	(1672, 16, 'Kota Prabumulih', -3.462020, 104.222900),
	(1673, 16, 'Kota Pagar Alam', -4.130550, 103.268220),
	(1674, 16, 'Kota Lubuk Linggau', -3.293080, 102.855030),
	(1701, 17, 'Kabupaten Bengkulu Selatan', -4.350000, 103.033330),
	(1702, 17, 'Kabupaten Rejang Lebong', -3.433330, 102.716670),
	(1703, 17, 'Kabupaten Bengkulu Utara', -3.333330, 102.050000),
	(1704, 17, 'Kabupaten Kaur', -4.781790, 103.361090),
	(1705, 17, 'Kabupaten Seluma', -3.966440, 102.474290),
	(1706, 17, 'Kabupaten Mukomuko', -3.074380, 101.547660),
	(1707, 17, 'Kabupaten Lebong', -3.242780, 102.334900),
	(1708, 17, 'Kabupaten Kepahiang', -3.601940, 102.564240),
	(1709, 17, 'Kabupaten Bengkulu Tengah', -3.206790, 102.126160),
	(1771, 17, 'Kota Bengkulu', -3.816670, 102.316670),
	(1801, 18, 'Kabupaten Lampung Barat', -5.149040, 104.193090),
	(1802, 18, 'Kabupaten Tanggamus', -5.385080, 104.623490),
	(1803, 18, 'Kabupaten Lampung Selatan', -5.453100, 104.987700),
	(1804, 18, 'Kabupaten Lampung Timur', -5.102730, 105.680030),
	(1805, 18, 'Kabupaten Lampung Tengah', -4.866670, 105.266670),
	(1806, 18, 'Kabupaten Lampung Utara', -4.816670, 104.800000),
	(1807, 18, 'Kabupaten Way Kanan', -4.447050, 104.527530),
	(1808, 18, 'Kabupaten Tulangbawang', -4.206040, 105.579990),
	(1809, 18, 'Kabupaten Pesawaran', -5.429800, 105.178990),
	(1810, 18, 'Kabupaten Pringsewu', -5.422110, 104.934540),
	(1811, 18, 'Kabupaten Mesuji', -4.043900, 105.401300),
	(1812, 18, 'Kabupaten Tulang Bawang Barat', -4.439750, 105.044400),
	(1813, 18, 'Kabupaten Pesisir Barat', -5.193230, 103.939760),
	(1871, 18, 'Kota Bandar Lampung', -5.416670, 105.250000),
	(1872, 18, 'Kota Metro', -5.118560, 105.299490),
	(1901, 19, 'Kabupaten Bangka', -1.916670, 105.933330),
	(1902, 19, 'Kabupaten Belitung', -2.866670, 107.700000),
	(1903, 19, 'Kabupaten Bangka Barat', -1.958390, 105.537410),
	(1904, 19, 'Kabupaten Bangka Tengah', -2.339890, 106.114200),
	(1905, 19, 'Kabupaten Bangka Selatan', -2.668030, 106.012570),
	(1906, 19, 'Kabupaten Belitung Timur', -2.962700, 108.152160),
	(1971, 19, 'Kota Pangkal Pinang', -2.133330, 106.133330),
	(2101, 21, 'Kabupaten Karimun', 0.807640, 103.419110),
	(2102, 21, 'Kabupaten Bintan', 0.950000, 104.619440),
	(2103, 21, 'Kabupaten Natuna', 4.714170, 107.976390),
	(2104, 21, 'Kabupaten Lingga', 0.200000, 104.616670),
	(2105, 21, 'Kabupaten Kepulauan Anambas', 3.000000, 106.000000),
	(2171, 21, 'Kota Batam', 1.052110, 104.028510),
	(2172, 21, 'Kota Tanjung Pinang', 0.916830, 104.443290),
	(3101, 31, 'Kabupaten Kepulauan Seribu', -5.598500, 106.552710),
	(3171, 31, 'Kota Jakarta Selatan', -6.266000, 106.813500),
	(3172, 31, 'Kota Jakarta Timur', -6.252100, 106.884000),
	(3173, 31, 'Kota Jakarta Pusat', -6.177700, 106.840300),
	(3174, 31, 'Kota Jakarta Barat', -6.167600, 106.767300),
	(3175, 31, 'Kota Jakarta Utara', -6.133900, 106.882300),
	(3201, 32, 'Kabupaten Bogor', -6.583330, 106.716670),
	(3202, 32, 'Kabupaten Sukabumi', -7.066670, 106.700000),
	(3203, 32, 'Kabupaten Cianjur', -6.772500, 107.083060),
	(3204, 32, 'Kabupaten Bandung', -7.100000, 107.600000),
	(3205, 32, 'Kabupaten Garut', -7.383330, 107.766670),
	(3206, 32, 'Kabupaten Tasikmalaya', -7.500000, 108.133330),
	(3207, 32, 'Kabupaten Ciamis', -7.283330, 108.416670),
	(3208, 32, 'Kabupaten Kuningan', -7.000000, 108.550000),
	(3209, 32, 'Kabupaten Cirebon', -6.800000, 108.566670),
	(3210, 32, 'Kabupaten Majalengka', -6.816670, 108.283330),
	(3211, 32, 'Kabupaten Sumedang', -6.816670, 107.983330),
	(3212, 32, 'Kabupaten Indramayu', -6.450000, 108.166670),
	(3213, 32, 'Kabupaten Subang', -6.508330, 107.702500),
	(3214, 32, 'Kabupaten Purwakarta', -6.583330, 107.450000),
	(3215, 32, 'Kabupaten Karawang', -6.266670, 107.416670),
	(3216, 32, 'Kabupaten Bekasi', -6.246670, 107.108330),
	(3217, 32, 'Kabupaten Bandung Barat', -6.833330, 107.483330),
	(3218, 32, 'Kabupaten Pangandaran', -7.667300, 108.640370),
	(3271, 32, 'Kota Bogor', -6.591670, 106.800000),
	(3272, 32, 'Kota Sukabumi', -6.950000, 106.933330),
	(3273, 32, 'Kota Bandung', -6.917500, 107.624440),
	(3274, 32, 'Kota Cirebon', -6.750000, 108.550000),
	(3275, 32, 'Kota Bekasi', -6.283330, 106.983330),
	(3276, 32, 'Kota Depok', -6.400000, 106.816670),
	(3277, 32, 'Kota Cimahi', -6.891670, 107.550000),
	(3278, 32, 'Kota Tasikmalaya', -7.350000, 108.216670),
	(3279, 32, 'Kota Banjar', -7.369960, 108.532090),
	(3301, 33, 'Kabupaten Cilacap', -7.574170, 108.988610),
	(3302, 33, 'Kabupaten Banyumas', -7.450000, 109.166670),
	(3303, 33, 'Kabupaten Purbalingga', -7.284170, 109.350280),
	(3304, 33, 'Kabupaten Banjarnegara', -7.351110, 109.587500),
	(3305, 33, 'Kabupaten Kebumen', -7.639170, 109.660560),
	(3306, 33, 'Kabupaten Purworejo', -7.700000, 109.966670),
	(3307, 33, 'Kabupaten Wonosobo', -7.361390, 109.926670),
	(3308, 33, 'Kabupaten Magelang', -7.427500, 110.161940),
	(3309, 33, 'Kabupaten Boyolali', -7.500000, 110.700000),
	(3310, 33, 'Kabupaten Klaten', -7.683330, 110.616670),
	(3311, 33, 'Kabupaten Sukoharjo', -7.683330, 110.833330),
	(3312, 33, 'Kabupaten Wonogiri', -7.916670, 111.000000),
	(3313, 33, 'Kabupaten Karanganyar', -7.628060, 111.062500),
	(3314, 33, 'Kabupaten Sragen', -7.412780, 110.935000),
	(3315, 33, 'Kabupaten Grobogan', -7.116670, 110.916670),
	(3316, 33, 'Kabupaten Blora', -7.066670, 111.383330),
	(3317, 33, 'Kabupaten Rembang', -6.783330, 111.466670),
	(3318, 33, 'Kabupaten Pati', -6.766670, 111.100000),
	(3319, 33, 'Kabupaten Kudus', -6.800000, 110.866670),
	(3320, 33, 'Kabupaten Jepara', -6.583330, 110.766670),
	(3321, 33, 'Kabupaten Demak', -6.899300, 110.612200),
	(3322, 33, 'Kabupaten Semarang', -7.206670, 110.441390),
	(3323, 33, 'Kabupaten Temanggung', -7.250000, 110.116670),
	(3324, 33, 'Kabupaten Kendal', -7.025600, 110.168500),
	(3325, 33, 'Kabupaten Batang', -7.033330, 109.883330),
	(3326, 33, 'Kabupaten Pekalongan', -7.031900, 109.624000),
	(3327, 33, 'Kabupaten Pemalang', -7.033330, 109.400000),
	(3328, 33, 'Kabupaten Tegal', -7.033330, 109.166670),
	(3329, 33, 'Kabupaten Brebes', -7.050000, 108.900000),
	(3371, 33, 'Kota Magelang', -7.500000, 110.225000),
	(3372, 33, 'Kota Surakarta', -7.550000, 110.816670),
	(3373, 33, 'Kota Salatiga', -7.332780, 110.483330),
	(3374, 33, 'Kota Semarang', -7.033330, 110.383330),
	(3375, 33, 'Kota Pekalongan', -6.900000, 109.683330),
	(3376, 33, 'Kota Tegal', -6.868600, 109.112900),
	(3401, 34, 'Kabupaten Kulon Progo', -7.645000, 110.026940),
	(3402, 34, 'Kabupaten Bantul', -7.900000, 110.366670),
	(3403, 34, 'Kabupaten Gunung Kidul', -7.983330, 110.616670),
	(3404, 34, 'Kabupaten Sleman', -7.681670, 110.323330),
	(3471, 34, 'Kota Yogyakarta', -7.800000, 110.375000),
	(3501, 35, 'Kabupaten Pacitan', -8.133330, 111.166670),
	(3502, 35, 'Kabupaten Ponorogo', -7.933330, 111.500000),
	(3503, 35, 'Kabupaten Trenggalek', -8.166670, 111.616670),
	(3504, 35, 'Kabupaten Tulungagung', -8.116670, 111.916670),
	(3505, 35, 'Kabupaten Blitar', -8.133330, 112.250000),
	(3506, 35, 'Kabupaten Kediri', -7.833330, 112.166670),
	(3507, 35, 'Kabupaten Malang', -8.166670, 112.666670),
	(3508, 35, 'Kabupaten Lumajang', -8.116670, 113.150000),
	(3509, 35, 'Kabupaten Jember', -8.250000, 113.650000),
	(3510, 35, 'Kabupaten Banyuwangi', -8.333330, 114.200000),
	(3511, 35, 'Kabupaten Bondowoso', -7.940400, 113.983400),
	(3512, 35, 'Kabupaten Situbondo', -7.716670, 114.050000),
	(3513, 35, 'Kabupaten Probolinggo', -7.866670, 113.316670),
	(3514, 35, 'Kabupaten Pasuruan', -7.733330, 112.833330),
	(3515, 35, 'Kabupaten Sidoarjo', -7.450000, 112.700000),
	(3516, 35, 'Kabupaten Mojokerto', -7.550000, 112.500000),
	(3517, 35, 'Kabupaten Jombang', -7.550000, 112.250000),
	(3518, 35, 'Kabupaten Nganjuk', -7.600000, 111.933330),
	(3519, 35, 'Kabupaten Madiun', -7.616670, 111.650000),
	(3520, 35, 'Kabupaten Magetan', -7.644720, 111.359170),
	(3521, 35, 'Kabupaten Ngawi', -7.474440, 111.334440),
	(3522, 35, 'Kabupaten Bojonegoro', -7.250000, 111.800000),
	(3523, 35, 'Kabupaten Tuban', -6.966670, 111.900000),
	(3524, 35, 'Kabupaten Lamongan', -7.133330, 112.316670),
	(3525, 35, 'Kabupaten Gresik', -7.193300, 112.553000),
	(3526, 35, 'Kabupaten Bangkalan', -7.050000, 112.933330),
	(3527, 35, 'Kabupaten Sampang', -7.050000, 113.250000),
	(3528, 35, 'Kabupaten Pamekasan', -7.066670, 113.500000),
	(3529, 35, 'Kabupaten Sumenep', -7.116670, 114.333330),
	(3571, 35, 'Kota Kediri', -7.833330, 112.016670),
	(3572, 35, 'Kota Blitar', -8.100000, 112.166670),
	(3573, 35, 'Kota Malang', -7.975000, 112.633330),
	(3574, 35, 'Kota Probolinggo', -7.783330, 113.216670),
	(3575, 35, 'Kota Pasuruan', -7.650000, 112.900000),
	(3576, 35, 'Kota Mojokerto', -7.466670, 112.433330),
	(3577, 35, 'Kota Madiun', -7.633330, 111.533330),
	(3578, 35, 'Kota Surabaya', -7.266670, 112.716670),
	(3579, 35, 'Kota Batu', -7.832720, 112.537510),
	(3601, 36, 'Kabupaten Pandeglang', -6.633330, 105.750000),
	(3602, 36, 'Kabupaten Lebak', -6.650000, 106.216670),
	(3603, 36, 'Kabupaten Tangerang', -6.200000, 106.466670),
	(3604, 36, 'Kabupaten Serang', -6.150000, 106.000000),
	(3671, 36, 'Kota Tangerang', -6.179440, 106.629910),
	(3672, 36, 'Kota Cilegon', -6.016670, 106.016670),
	(3673, 36, 'Kota Serang', -6.125630, 106.149990),
	(3674, 36, 'Kota Tangerang Selatan', -6.293730, 106.712440),
	(5101, 51, 'Kabupaten Jembrana', -8.300000, 114.666670),
	(5102, 51, 'Kabupaten Tabanan', -8.433330, 115.066670),
	(5103, 51, 'Kabupaten Badung', -8.516670, 115.200000),
	(5104, 51, 'Kabupaten Gianyar', -8.466670, 115.283330),
	(5105, 51, 'Kabupaten Klungkung', -8.550000, 115.400000),
	(5106, 51, 'Kabupaten Bangli', -8.283330, 115.350000),
	(5107, 51, 'Kabupaten Karang Asem', -8.389100, 115.539300),
	(5108, 51, 'Kabupaten Buleleng', -8.250000, 114.966670),
	(5171, 51, 'Kota Denpasar', -8.666670, 115.216630),
	(5201, 52, 'Kabupaten Lombok Barat', -8.695830, 116.116670),
	(5202, 52, 'Kabupaten Lombok Tengah', -8.700000, 116.300000),
	(5203, 52, 'Kabupaten Lombok Timur', -8.533330, 116.533330),
	(5204, 52, 'Kabupaten Sumbawa', -8.743900, 117.332400),
	(5205, 52, 'Kabupaten Dompu', -8.509400, 118.481600),
	(5206, 52, 'Kabupaten Bima', -8.600000, 118.616670),
	(5207, 52, 'Kabupaten Sumbawa Barat', -8.751590, 116.921320),
	(5208, 52, 'Kabupaten Lombok Utara', -8.352140, 116.401520),
	(5271, 52, 'Kota Mataram', -8.583300, 116.116700),
	(5272, 52, 'Kota Bima', -8.467280, 118.752590),
	(5301, 53, 'Kabupaten Sumba Barat', -9.566670, 119.450000),
	(5302, 53, 'Kabupaten Sumba Timur', -9.883330, 120.250000),
	(5303, 53, 'Kabupaten Kupang', -9.916670, 123.833330),
	(5304, 53, 'Kabupaten Timor Tengah Selatan', -9.833330, 124.400000),
	(5305, 53, 'Kabupaten Timor Tengah Utara', -9.331360, 124.519040),
	(5306, 53, 'Kabupaten Belu', -9.412580, 124.950660),
	(5307, 53, 'Kabupaten Alor', -8.300000, 124.566670),
	(5308, 53, 'Kabupaten Lembata', -8.413960, 123.552250),
	(5309, 53, 'Kabupaten Flores Timur', -8.242240, 122.968170),
	(5310, 53, 'Kabupaten Sikka', -8.666670, 122.366670),
	(5311, 53, 'Kabupaten Ende', -8.840560, 121.663890),
	(5312, 53, 'Kabupaten Ngada', -8.666670, 121.000000),
	(5313, 53, 'Kabupaten Manggarai', -8.566670, 120.416670),
	(5314, 53, 'Kabupaten Rote Ndao', -10.736170, 123.120540),
	(5315, 53, 'Kabupaten Manggarai Barat', -8.644840, 119.882810),
	(5316, 53, 'Kabupaten Sumba Tengah', -9.629410, 119.619140),
	(5317, 53, 'Kabupaten Sumba Barat Daya', -9.562160, 119.089050),
	(5318, 53, 'Kabupaten Nagekeo', -8.872100, 121.209630),
	(5319, 53, 'Kabupaten Manggarai Timur', -8.555330, 120.597610),
	(5320, 53, 'Kabupaten Sabu Raijua', -10.562860, 121.788940),
	(5321, 53, 'Kabupaten Malaka', -9.563200, 124.894810),
	(5371, 53, 'Kota Kupang', -10.216670, 123.600000),
	(6101, 61, 'Kabupaten Sambas', 1.416670, 109.333330),
	(6102, 61, 'Kabupaten Bengkayang', 1.069110, 109.663930),
	(6103, 61, 'Kabupaten Landak', 0.423730, 109.759170),
	(6104, 61, 'Kabupaten Mempawah', 0.250000, 109.166670),
	(6105, 61, 'Kabupaten Sanggau', 0.254720, 110.450000),
	(6106, 61, 'Kabupaten Ketapang', -1.583330, 110.500000),
	(6107, 61, 'Kabupaten Sintang', -0.083330, 112.083330),
	(6108, 61, 'Kabupaten Kapuas Hulu', 0.816670, 112.766670),
	(6109, 61, 'Kabupaten Sekadau', 0.034850, 110.950660),
	(6110, 61, 'Kabupaten Melawi', -0.336170, 111.698000),
	(6111, 61, 'Kabupaten Kayong Utara', -1.437110, 110.797810),
	(6112, 61, 'Kabupaten Kubu Raya', 0.016370, 109.337310),
	(6171, 61, 'Kota Pontianak', -0.083330, 109.366670),
	(6172, 61, 'Kota Singkawang', 0.907340, 109.001030),
	(6201, 62, 'Kabupaten Kotawaringin Barat', -2.400000, 111.733330),
	(6202, 62, 'Kabupaten Kotawaringin Timur', -2.083330, 112.750000),
	(6203, 62, 'Kabupaten Kapuas', -2.016670, 114.383330),
	(6204, 62, 'Kabupaten Barito Selatan', -1.866670, 114.733330),
	(6205, 62, 'Kabupaten Barito Utara', -0.983330, 115.100000),
	(6206, 62, 'Kabupaten Sukamara', -2.626750, 111.236810),
	(6207, 62, 'Kabupaten Lamandau', -1.838280, 111.286900),
	(6208, 62, 'Kabupaten Seruyan', -2.333330, 112.250000),
	(6209, 62, 'Kabupaten Katingan', -2.066670, 113.400000),
	(6210, 62, 'Kabupaten Pulang Pisau', -3.118580, 113.862300),
	(6211, 62, 'Kabupaten Gunung Mas', -0.950000, 113.500000),
	(6212, 62, 'Kabupaten Barito Timur', -1.933330, 115.100000),
	(6213, 62, 'Kabupaten Murung Raya', -0.016670, 114.266670),
	(6271, 62, 'Kota Palangka Raya', -1.769790, 113.731260),
	(6301, 63, 'Kabupaten Tanah Laut', -3.883330, 114.866670),
	(6302, 63, 'Kabupaten Kota Baru', -3.000000, 116.000000),
	(6303, 63, 'Kabupaten Banjar', -3.316670, 115.083330),
	(6304, 63, 'Kabupaten Barito Kuala', -3.083330, 114.616670),
	(6305, 63, 'Kabupaten Tapin', -2.916670, 115.033330),
	(6306, 63, 'Kabupaten Hulu Sungai Selatan', -2.750000, 115.200000),
	(6307, 63, 'Kabupaten Hulu Sungai Tengah', -2.616670, 115.416670),
	(6308, 63, 'Kabupaten Hulu Sungai Utara', -2.450000, 115.133330),
	(6309, 63, 'Kabupaten Tabalong', -1.883330, 115.500000),
	(6310, 63, 'Kabupaten Tanah Bumbu', -3.454130, 115.703720),
	(6311, 63, 'Kabupaten Balangan', -2.323140, 115.629220),
	(6371, 63, 'Kota Banjarmasin', -3.324440, 114.591020),
	(6372, 63, 'Kota Banjar Baru', -3.416670, 114.833330),
	(6401, 64, 'Kabupaten Paser', -1.435170, 116.235350),
	(6402, 64, 'Kabupaten Kutai Barat', -0.594170, 115.515750),
	(6403, 64, 'Kabupaten Kutai Kartanegara', -0.440190, 116.981390),
	(6404, 64, 'Kabupaten Kutai Timur', 1.037690, 117.831120),
	(6405, 64, 'Kabupaten Berau', 2.000000, 117.300000),
	(6409, 64, 'Kabupaten Penajam Paser Utara', -1.250000, 116.833330),
	(6411, 64, 'Kabupaten Mahakam Hulu', 0.378220, 115.380480),
	(6471, 64, 'Kota Balikpapan', -1.166670, 116.883330),
	(6472, 64, 'Kota Samarinda', -0.433330, 117.183330),
	(6474, 64, 'Kota Bontang', 0.125260, 117.496030),
	(6501, 65, 'Kabupaten Malinau', 2.450000, 115.683330),
	(6502, 65, 'Kabupaten Bulungan', 3.000000, 117.166670),
	(6503, 65, 'Kabupaten Tana Tidung', 3.550000, 117.250000),
	(6504, 65, 'Kabupaten Nunukan', 4.133330, 116.700000),
	(6571, 65, 'Kota Tarakan', 3.366670, 117.600000),
	(7101, 71, 'Kabupaten Bolaang Mongondow', 0.750000, 124.083330),
	(7102, 71, 'Kabupaten Minahasa', 1.253700, 124.830000),
	(7103, 71, 'Kabupaten Kepulauan Sangihe', 3.500000, 125.550000),
	(7104, 71, 'Kabupaten Kepulauan Talaud', 4.311780, 126.780850),
	(7105, 71, 'Kabupaten Minahasa Selatan', 1.212910, 124.597080),
	(7106, 71, 'Kabupaten Minahasa Utara', 1.402500, 124.960000),
	(7107, 71, 'Kabupaten Bolaang Mongondow Utara', 0.785270, 123.417660),
	(7108, 71, 'Kabupaten Siau Tagulandang Biaro', 2.117280, 125.375120),
	(7109, 71, 'Kabupaten Minahasa Tenggara', 1.056330, 124.792500),
	(7110, 71, 'Kabupaten Bolaang Mongondow Selatan', 0.409120, 123.759610),
	(7111, 71, 'Kabupaten Bolaang Mongondow Timur', 0.720730, 124.502560),
	(7171, 71, 'Kota Manado', 1.516670, 124.883330),
	(7172, 71, 'Kota Bitung', 1.483330, 125.150000),
	(7173, 71, 'Kota Tomohon', 1.313070, 124.834040),
	(7174, 71, 'Kota Kotamobagu', 0.689150, 124.326780),
	(7201, 72, 'Kabupaten Banggai Kepulauan', -1.642400, 123.548810),
	(7202, 72, 'Kabupaten Banggai', -1.283500, 122.889200),
	(7203, 72, 'Kabupaten Morowali', -1.893420, 121.254730),
	(7204, 72, 'Kabupaten Poso', -1.650000, 120.500000),
	(7205, 72, 'Kabupaten Donggala', -0.583330, 119.850000),
	(7206, 72, 'Kabupaten Toli-Toli', 1.308620, 120.886430),
	(7207, 72, 'Kabupaten Buol', 0.750000, 120.750000),
	(7208, 72, 'Kabupaten Parigi Moutong', 0.336800, 120.178410),
	(7209, 72, 'Kabupaten Tojo Una-Una', -1.203600, 121.482010),
	(7210, 72, 'Kabupaten Sigi', -1.385000, 119.966940),
	(7211, 72, 'Kabupaten Banggai Laut', -1.618410, 123.493880),
	(7212, 72, 'Kabupaten Morowali Utara', -1.720700, 121.246490),
	(7271, 72, 'Kota Palu', -0.869720, 119.900000),
	(7301, 73, 'Kabupaten Kepulauan Selayar', -6.816670, 120.800000),
	(7302, 73, 'Kabupaten Bulukumba', -5.416670, 120.233330),
	(7303, 73, 'Kabupaten Bantaeng', -5.483330, 119.983330),
	(7304, 73, 'Kabupaten Jeneponto', -5.633330, 119.733330),
	(7305, 73, 'Kabupaten Takalar', -5.416670, 119.516670),
	(7306, 73, 'Kabupaten Gowa', -5.316670, 119.750000),
	(7307, 73, 'Kabupaten Sinjai', -5.216670, 120.150000),
	(7308, 73, 'Kabupaten Maros', -5.050000, 119.716670),
	(7309, 73, 'Kabupaten Pangkajene Dan Kepulauan', -4.782700, 119.550600),
	(7310, 73, 'Kabupaten Barru', -4.433330, 119.683330),
	(7311, 73, 'Kabupaten Bone', -4.700000, 120.133330),
	(7312, 73, 'Kabupaten Soppeng', -4.384200, 119.890000),
	(7313, 73, 'Kabupaten Wajo', -4.000000, 120.166670),
	(7314, 73, 'Kabupaten Sidenreng Rappang', -3.850000, 119.966670),
	(7315, 73, 'Kabupaten Pinrang', -3.616670, 119.600000),
	(7316, 73, 'Kabupaten Enrekang', -3.500000, 119.866670),
	(7317, 73, 'Kabupaten Luwu', -2.557700, 121.324200),
	(7318, 73, 'Kabupaten Tana Toraja', -3.002400, 119.796550),
	(7322, 73, 'Kabupaten Luwu Utara', -2.600000, 120.250000),
	(7325, 73, 'Kabupaten Luwu Timur', -2.509570, 120.397800),
	(7326, 73, 'Kabupaten Toraja Utara', -2.927380, 119.792180),
	(7371, 73, 'Kota Makassar', -5.150000, 119.450000),
	(7372, 73, 'Kota Pare-Pare', -4.033330, 119.650000),
	(7373, 73, 'Kota Palopo', -2.978410, 120.110780),
	(7401, 74, 'Kabupaten Buton', -5.316670, 122.583330),
	(7402, 74, 'Kabupaten Muna', -4.966670, 122.666670),
	(7403, 74, 'Kabupaten Konawe', -3.917170, 122.088230),
	(7404, 74, 'Kabupaten Kolaka', -4.083330, 121.666670),
	(7405, 74, 'Kabupaten Konawe Selatan', -4.191910, 122.448540),
	(7406, 74, 'Kabupaten Bombana', -4.625700, 121.816410),
	(7407, 74, 'Kabupaten Wakatobi', -5.319340, 123.594800),
	(7408, 74, 'Kabupaten Kolaka Utara', -3.104520, 121.124270),
	(7409, 74, 'Kabupaten Buton Utara', -5.014570, 122.930150),
	(7410, 74, 'Kabupaten Konawe Utara', -3.415520, 121.990810),
	(7411, 74, 'Kabupaten Kolaka Timur', -4.018070, 121.861720),
	(7412, 74, 'Kabupaten Konawe Kepulauan', -4.116560, 123.101810),
	(7413, 74, 'Kabupaten Muna Barat', -4.833330, 122.483330),
	(7414, 74, 'Kabupaten Buton Tengah', -5.316670, 122.333330),
	(7415, 74, 'Kabupaten Buton Selatan', -5.566670, 122.700000),
	(7471, 74, 'Kota Kendari', -3.983330, 122.500000),
	(7472, 74, 'Kota Baubau', -5.477000, 122.616600),
	(7501, 75, 'Kabupaten Boalemo', 0.626890, 122.356800),
	(7502, 75, 'Kabupaten Gorontalo', 0.572800, 122.233700),
	(7503, 75, 'Kabupaten Pohuwato', 0.709800, 121.595820),
	(7504, 75, 'Kabupaten Bone Bolango', 0.502960, 123.275010),
	(7505, 75, 'Kabupaten Gorontalo Utara', 0.770000, 122.316670),
	(7571, 75, 'Kota Gorontalo', 0.533330, 123.100000),
	(7601, 76, 'Kabupaten Majene', -3.150000, 118.866670),
	(7602, 76, 'Kabupaten Polewali Mandar', -3.300000, 119.166670),
	(7603, 76, 'Kabupaten Mamasa', -2.964920, 119.306310),
	(7604, 76, 'Kabupaten Mamuju', -2.500000, 119.416670),
	(7605, 76, 'Kabupaten Mamuju Utara', -1.516390, 119.421390),
	(7606, 76, 'Kabupaten Mamuju Tengah', -2.821200, 119.266200),
	(8101, 81, 'Kabupaten Maluku Tenggara Barat', -7.611860, 131.380000),
	(8102, 81, 'Kabupaten Maluku Tenggara', -5.750000, 132.733340),
	(8103, 81, 'Kabupaten Maluku Tengah', -3.291670, 128.967500),
	(8104, 81, 'Kabupaten Buru', -3.327670, 126.684130),
	(8105, 81, 'Kabupaten Kepulauan Aru', -6.170590, 134.469910),
	(8106, 81, 'Kabupaten Seram Bagian Barat', -3.102700, 128.429960),
	(8107, 81, 'Kabupaten Seram Bagian Timur', -3.398510, 130.391660),
	(8108, 81, 'Kabupaten Maluku Barat Daya', -7.829600, 126.173860),
	(8109, 81, 'Kabupaten Buru Selatan', -3.521870, 126.592710),
	(8171, 81, 'Kota Ambon', -3.700000, 128.183330),
	(8172, 81, 'Kota Tual', -5.643010, 132.749340),
	(8201, 82, 'Kabupaten Halmahera Barat', 1.417090, 127.552640),
	(8202, 82, 'Kabupaten Halmahera Tengah', 0.480560, 128.250000),
	(8203, 82, 'Kabupaten Kepulauan Sula', -1.864600, 125.690460),
	(8204, 82, 'Kabupaten Halmahera Selatan', -0.395500, 127.908330),
	(8205, 82, 'Kabupaten Halmahera Utara', 1.731940, 128.007780),
	(8206, 82, 'Kabupaten Halmahera Timur', 1.335170, 128.486270),
	(8207, 82, 'Kabupaten Pulau Morotai', 2.199240, 128.405460),
	(8208, 82, 'Kabupaten Pulau Taliabu', -1.845780, 124.789920),
	(8271, 82, 'Kota Ternate', 0.896180, 127.310160),
	(8272, 82, 'Kota Tidore Kepulauan', 0.609620, 127.569810),
	(9101, 91, 'Kabupaten Fak-Fak', -2.926410, 132.296080),
	(9102, 91, 'Kabupaten Kaimana', -3.660930, 133.774510),
	(9103, 91, 'Kabupaten Teluk Wondama', -2.700000, 134.500000),
	(9104, 91, 'Kabupaten Teluk Bintuni', -1.880370, 133.331050),
	(9105, 91, 'Kabupaten Manokwari', -0.900000, 133.750000),
	(9106, 91, 'Kabupaten Sorong Selatan', -1.504950, 132.286380),
	(9107, 91, 'Kabupaten Sorong', -1.166670, 131.500000),
	(9108, 91, 'Kabupaten Raja Ampat', -0.500000, 130.000000),
	(9109, 91, 'Kabupaten Tambrauw', -0.605150, 132.489620),
	(9110, 91, 'Kabupaten Maybrat', -1.215500, 132.350920),
	(9111, 91, 'Kabupaten Manokwari Selatan', -1.079800, 133.967290),
	(9112, 91, 'Kabupaten Pegunungan Arfak', -0.935230, 133.895870),
	(9171, 91, 'Kota Sorong', -0.865070, 131.251530),
	(9401, 94, 'Kabupaten Merauke', -7.666670, 139.666670),
	(9402, 94, 'Kabupaten Jayawijaya', -4.083330, 139.083330),
	(9403, 94, 'Kabupaten Jayapura', -3.000000, 139.950000),
	(9404, 94, 'Kabupaten Nabire', -3.540160, 135.555110),
	(9408, 94, 'Kabupaten Kepulauan Yapen', -1.787730, 136.277160),
	(9409, 94, 'Kabupaten Biak Numfor', -1.033330, 136.000000),
	(9410, 94, 'Kabupaten Paniai', -3.900000, 136.600010),
	(9411, 94, 'Kabupaten Puncak Jaya', -3.672410, 137.438960),
	(9412, 94, 'Kabupaten Mimika', -4.543570, 136.565550),
	(9413, 94, 'Kabupaten Boven Digoel', -5.705190, 140.363490),
	(9414, 94, 'Kabupaten Mappi', -6.499710, 139.344410),
	(9415, 94, 'Kabupaten Asmat', -5.379500, 138.463440),
	(9416, 94, 'Kabupaten Yahukimo', -4.604030, 139.584050),
	(9417, 94, 'Kabupaten Pegunungan Bintang', -4.521670, 140.295410),
	(9418, 94, 'Kabupaten Tolikara', -3.426610, 137.416990),
	(9419, 94, 'Kabupaten Sarmi', -2.416670, 139.083330),
	(9420, 94, 'Kabupaten Keerom', -3.300000, 140.616670),
	(9426, 94, 'Kabupaten Waropen', -2.286000, 137.018370),
	(9427, 94, 'Kabupaten Supiori', -0.738810, 135.611110),
	(9428, 94, 'Kabupaten Mamberamo Raya', -2.235610, 137.782290),
	(9429, 94, 'Kabupaten Nduga', -4.450930, 138.100890),
	(9430, 94, 'Kabupaten Lanny Jaya', -3.912440, 138.287660),
	(9431, 94, 'Kabupaten Mamberamo Tengah', -2.460640, 138.452450),
	(9432, 94, 'Kabupaten Yalimo', -3.860370, 138.473050),
	(9433, 94, 'Kabupaten Puncak', -4.142040, 137.097020),
	(9434, 94, 'Kabupaten Dogiyai', -4.031860, 135.439450),
	(9435, 94, 'Kabupaten Intan Jaya', -3.410160, 136.708370),
	(9436, 94, 'Kabupaten Deiyai', -3.947370, 135.950320),
	(9471, 94, 'Kota Jayapura', -2.646470, 140.777790);

CREATE TABLE fakultas (
	id INT PRIMARY KEY,
	nama VARCHAR(16)
);

INSERT INTO fakultas VALUES
	(1, 'Ilmu Komputer'),
	(2, 'Ekonomi'),
	(3, 'Psikologi'),
	(4, 'Sastra'),
	(5, 'Teknik');

CREATE TABLE jenjang (
	id INT PRIMARY KEY,
	nama VARCHAR(16)
);

INSERT INTO jenjang VALUES
	(1, 'D3'),
	(2, 'S1');

CREATE TABLE jurusan (
	id INT PRIMARY KEY,
	nama VARCHAR(32),
	fakultas INT,
	FOREIGN KEY (fakultas) REFERENCES fakultas (id)
);

INSERT INTO jurusan VALUES
	(1, 'Teknik Informatika', 1),
	(2, 'Manajemen Informatika', 1),
	(3, 'Akuntansi', 2),
	(4, 'Manajemen', 2),
	(5, 'Psikologi', 3),
	(6, 'Sastra Jepang', 4),
	(7, 'Bahasa Inggris', 4),
	(8, 'Teknik Industri', 5);

CREATE TABLE program_studi (
	id INT PRIMARY KEY,
    jenjang INT,
	jurusan INT,
	FOREIGN KEY (jenjang) REFERENCES jenjang (id),
	FOREIGN KEY (jurusan) REFERENCES jurusan (id)
);

INSERT INTO program_studi VALUES
	(1, 2, 1),
	(2, 1, 2),
	(3, 2, 3),
	(4, 2, 4),
	(5, 2, 5),
	(6, 2, 6),
	(7, 1, 7),
	(8, 2, 8);

CREATE TABLE status (
	id INT PRIMARY KEY,
	nama VARCHAR(16)
);

INSERT INTO status VALUES
	(0, 'Aktif'),
	(1, 'Nonaktif'),
	(2, 'Alumni');

CREATE TABLE angkatan (
	nomor INT PRIMARY KEY,
	nama VARCHAR(32),
	yel_yel VARCHAR(64),
	warna CHAR(6)
);

INSERT INTO angkatan (nomor, nama) VALUES
	(1, '1st PUB'),
	(2, '2nd PUB'),
	(3, '3rd PUB'),
	(4, '4th Generation'),
	(5, 'Pascal'),
	(6, 'GENIX'),
	(7, 'BASIC'),
	(8, '8th Cell'),
	(9, 'Linux'),
	(10, 'Vista'),
	(11, 'Fedora'),
	(12, 'Smadav'),
	(13, 'XAMPP'),
	(14, 'Dreamweaver'),
	(15, 'Python'),
	(16, 'Malware');

INSERT INTO angkatan (nomor, nama, yel_yel) VALUES
	(17, 'Firewall', 'Spirit as fire, strong as wall, no one can stop us.'),
	(18, 'Jarvis', 'One dream, one destination, now or never.'),
	(19, 'Neophyte', 'New optimizm from the powerfull programmer');

CREATE TABLE pelatihan (
	id INT PRIMARY KEY NOT NULL,
    nama VARCHAR(32) NOT NULL
);

INSERT INTO pelatihan VALUES
	(0, 'Logika & Algoritma (C)'),
	(1, 'Struktur Data (C)'),
	(2, 'Basis Data (MySQL)'),
	(3, 'HTML, CSS, dan JavaScript'),
	(4, 'PHP Fundamental'),
	(5, 'Java Fundamental'),
	(6, '.NET Fundamental'),
	(7, 'PHP Lanjutan'),
	(8, 'Java Lanjutan'),
	(9, '.NET Lanjutan'),
	(10, 'Bahasa Inggris');

CREATE TABLE grup_pelatihan (
	id INT PRIMARY KEY NOT NULL,
    pelatihan INT NOT NULL,
    instruktur VARCHAR(16) NOT NULL,
    hari INT,
    waktu_mulai TIME,
    waktu_selesai TIME,
    FOREIGN KEY (pelatihan) REFERENCES pelatihan (id)
);

CREATE TABLE akun (
	# Akun
	id VARCHAR(16) PRIMARY KEY NOT NULL,
	nama_pengguna VARCHAR(32) UNIQUE,
    kata_sandi CHAR(60) BINARY DEFAULT '$2a$10$izN/5EDMPOXQ0MZfCI3rRuZWx6V2tN5xE/9gp.jCziREX261xDmme',
    # Kata sandi default: 1234
	developer BOOL DEFAULT FALSE NOT NULL,
	nama VARCHAR(64) NOT NULL,
	jenis_kelamin BIT,
    daerah_asal CHAR(4),
    tempat_lahir CHAR(4),
	tanggal_lahir DATE,
	FOREIGN KEY (daerah_asal) REFERENCES kabupaten (id),
	FOREIGN KEY (tempat_lahir) REFERENCES kabupaten (id),
    
    # Akun > Mahasiswa
    program_studi INT,
	status INT,
	angkatan INT,
	FOREIGN KEY (angkatan) REFERENCES angkatan (nomor),
    aktif BOOL DEFAULT TRUE,
    
    # Akun > Mahasiswa > Aktif
    # Kerohanian
    hafalan_ke_bapak BOOL,
	poin INT,
    # Keasramaan
    asrama INT,
    # Kesehatan
	sehat BOOL,
    
    # Akun > Mahasiswa > Alumni
    perusahaan INT,
    jabatan_perusahaan VARCHAR(32)
);

ALTER TABLE grup_pelatihan
	ADD CONSTRAINT FOREIGN KEY (instruktur) REFERENCES akun (id);

CREATE TABLE organisasi (
	id INT PRIMARY KEY,
    nama VARCHAR(64),
    akronim VARCHAR(16)
);

INSERT INTO organisasi VALUES
	(1, 'Pemberdayaan Umat Berkelanjutan', 'PUB'),
	(2, 'Panitia Penerimaan Mahasiswa Baru PUB', 'PPMB PUB');

CREATE TABLE divisi (
	id INT PRIMARY KEY NOT NULL,
    nama VARCHAR(32) NOT NULL,
    organisasi INT NOT NULL,
    FOREIGN KEY (organisasi) REFERENCES organisasi (id)
);

SET @pendidikan = 1;
SET @kerohanian = 2;
SET @kebersihan = 3;
SET @kesejahteraan = 4;
SET @keasramaan = 5;
SET @magang = 6;
SET @kesehatan = 7;
SET @logistik = 8;
SET @humas = 9;
SET @konsumsi = 10;
SET @acara = 11;
SET @dokumentasi = 12;
SET @d_keamanan = 13;

INSERT INTO divisi VALUES
	(@pendidikan, 'Divisi Pendidikan', 1),
	(@kerohanian, 'Divisi Kerohanian', 1),
	(@kebersihan, 'Divisi Kebersihan', 1),
	(@kesejahteraan, 'Divisi Kesejahteraan', 1),
	(@keasramaan, 'Divisi Keasramaan', 1),
	(@magang, 'Divisi Magang', 1),
	(@kesehatan, 'Divisi Kesehatan', 1),
	(@logistik, 'Divisi Logistik', 2),
	(@humas, 'Divisi Humas', 2),
	(@konsumsi, 'Divisi Konsumsi', 2),
	(@acara, 'Divisi Acara', 2),
	(@dokumentasi, 'Divisi Dokumentasi', 2),
	(@d_keamanan, 'Divisi Keamanan', 2);

CREATE TABLE jabatan (
	id INT PRIMARY KEY NOT NULL,
    nama VARCHAR(32) NOT NULL
);

SET @pembina = 1;
SET @ketua = 2;
SET @keamanan = 3;
SET @sekretaris = 4;
SET @bendahara = 5;
SET @koordinator = 6;
SET @wakil_koordinator = 7;
SET @anggota = 8;

INSERT INTO jabatan VALUES
	(@pembina, 'Pembina'),
	(@ketua, 'Ketua'),
	(@keamanan, 'Keamanan'),
	(@sekretaris, 'Sekretaris'),
	(@bendahara, 'Bendahara'),
	(@koordinator, 'Koordinator'),
	(@wakil_koordinator, 'Wakil Koordinator'),
	(@anggota, 'Anggota');

CREATE TABLE jabatan_akun (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	akun VARCHAR(16) NOT NULL,
    jabatan INT NOT NULL,
    divisi INT,
    organisasi INT,
    awal_menjabat YEAR,
    akhir_menjabat YEAR,
    FOREIGN KEY (akun) REFERENCES akun (id),
    FOREIGN KEY (jabatan) REFERENCES jabatan (id),
    FOREIGN KEY (divisi) REFERENCES divisi (id),
    FOREIGN KEY (organisasi) REFERENCES organisasi (id)
);

CREATE TABLE acara (
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    judul VARCHAR(64) NOT NULL,
    deskripsi VARCHAR(64),
    tanggal DATE,
    
    # Dengan waktu
    waktu_mulai TIME,
    waktu_selesai TIME,
    
    # Dengan pengulangan
    pengulangan INT,
    interval_pengulangan INT,
    
    # Harian
    harian BOOL,
    
    # Mingguan
    hari_minggu BOOL,
    hari_senin BOOL,
    hari_selasa BOOL,
    hari_rabu BOOL,
    hari_kamis BOOL,
    hari_jumat BOOL,
    hari_sabtu BOOL,
    
    # Bulanan berdasarkan tanggal
    tanggal_dalam_bulan INT,
    
    # Bulanan berdasarkan hari dan minggu
    hari INT,
    minggu INT,
    
    # Tahunan
    bulan INT,
    
    # Kelompok bersangkutan
    kelompok INT,
    
    # Divisi bersangkutan
    divisi INT
);

# Kegiatan harian
INSERT INTO acara (judul, waktu_mulai, waktu_selesai) VALUES
	('Salat Subuh', '04:30', '05:00'),
	('Piket Kampus', '05:00', '07:00'),
	('Salat Zuhur', '12:00', '12:30'),
	('Salat Asar', '15:30', '16:00'),
	('Salat Magrib', '18:00', '18:30'),
	('Salat Isya', '19:30', '20:00');

# Kegiatan mingguan
INSERT INTO acara (judul, deskripsi, hari, waktu_mulai, waktu_selesai, divisi) VALUES
	('Pembinaan PUB', 'Bersama Bapak Abdul Hafiz Tanjung, SE., M.Si., Ak., CA.', 5, '19:45', '23:00', NULL),
	('Pengajian Masjid Al-Ikhlas','Bersama Ustadz Cecep Supiyan', 2, '18:15', '18:45', @kerohanian),
	('Pengajian Masjid Al-Ikhlas','Bersama Ustadz Rahmat Abu Zahra', 3, '18:15', '18:45', @kerohanian),
	('Pengajian Asrama Ikhwan', NULL, 6, '18:45', '19:15', @kerohanian),
	('Pengajian Asrama Ikhwan', NULL, 7, '18:45', '19:15', @kerohanian),
	('General Cleaning', NULL, 7, '07:00', '08:00', @kebersihan);

# Kegiatan bulanan
INSERT INTO acara (judul, tanggal_dalam_bulan) VALUES
	('Pembagian Uang Toiletris', 1);

# Kegiatan tahunan
INSERT INTO acara (judul, tanggal_dalam_bulan, bulan, waktu_mulai, waktu_selesai) VALUES
	('Pemilu PUB', 17, 8, '07:30', '23:00'),
	('Sertijab PUB', 31, 12, '19:30', '23:00');

INSERT INTO akun (id, nama_pengguna, nama, jenis_kelamin, daerah_asal, tempat_lahir, tanggal_lahir) VALUES
	('0402067001', 'junkssiboga', 'Abdul Hafiz Tanjung', 0, '1271', '1271', '1970-06-02');

# Mahasiswa aktif
ALTER TABLE akun
	ALTER status SET DEFAULT 0,
    ALTER poin SET DEFAULT 10,
    ALTER sehat SET DEFAULT TRUE;

# Angkatan 16
ALTER TABLE akun
	ALTER angkatan SET DEFAULT 16;

INSERT INTO akun (id, nama, jenis_kelamin, daerah_asal, tempat_lahir, tanggal_lahir, program_studi) VALUES
	('0204171001', 'Abdul Wahid', 0, 3275, 3275, '1999-07-13', 2),
	('0407171001', 'Aldi Mulyadi', 0, 3217, 3204, '1999-12-30', 7),
	('0204171002', 'Amelia Yuniar', 1, 3207, 3207, '1998-06-05', 2),
	('0204171005', 'Caridi', 0, 3212, 3212, '1999-09-07', 2),
	('0204171006', 'Dani Kusnaedi', 0, 3207, 3207, '1998-10-23', 2),
	('0204171007', 'Deded Rolistio Alamsyah', 0, 3212, 3212, '1998-12-02', 2),
	('0407171002', 'Della Yulianisha', 1, 3214, 3214, '1999-07-13', 7),
	('0204171008', 'Fahmi Ali', 0, 3217, 3204, '1997-08-15', 2),
	('0204171009', 'Fenita Oktaviani', 1, 3302, 3302, '1999-10-05', 2),
	('0204171010', 'Fitra Surya Saputra', 0, 3205, 3205, '1999-03-06', 2),
	('0203171082', 'Fitriani', 1, 3207, 3207, '1998-12-27', 1),
	('0204171011', 'Hadiyanto', 0, 3217, 3204, '1999-06-13', 2),
	('0204171012', 'Hafidh Almarogi', 0, 3217, 3204, '1998-12-07', 2),
	('0204171013', 'Hasri Nuryawati', 1, 3203, 3203, '1998-07-10', 2),
	('0102171037', 'Helma Yunia Putri', 1, 3217, 3204, '1999-06-06', 3),
	('0203171083', 'Herdiana', 0, 3203, 3203, '1997-05-04', 1),
	('0204171014', 'Husnul Roby Gunawan', 0, 3205, 3205, '1997-06-12', 2),
	('0204171018', 'Ihsan Nasihin', 0, 3205, 3205, '1999-02-01', 2),
	('0204171016', 'Irsyad Ilyasa', 0, 3309, 3301, '1999-07-25', 2),
	('0204171017', 'Iyan Sanjaya', 0, 3203, 3203, '1998-12-02', 2),
	('0101171134', 'Lusi Kusnaeni', 1, 3309, 3309, '1998-09-10', 4),
	('0204171019', 'M Baghyan Widyanto', 0, 3206, 3206, '1998-03-04', 2),
	('0204171020', 'Monica Dyah Pratiwi', 1, 3373, 3374, '2001-04-08', 2),
	('0203171084', 'Nenti Gustini Nurhidayah', 1, 3217, 3204, '1999-08-02', 1),
	('0204171021', 'Nina Man Aida', 1, 3218, 3207, '1999-10-25', 2),
	('0204171022', 'Ninda Try Alviani', 1, 3279, 3207, '1998-10-26', 2),
	('0204171023', 'Novelina Erlin Saputri', 1, 3304, 3304, '1998-11-06', 2),
	('0204171024', 'Nurdin', 0, 3279, 3207, '1999-01-19', 2),
	('0204171026', 'Putri Widiyanti Rohman', 1, 3603, 3315, '1999-11-11', 2),
	('0406171007', "Putria Nur'ainun", 1, 3214, 3214, '1999-09-16', 6),
	('0204171027', 'Rini Oktaviani', 1, 3211, 3211, '1998-10-25', 2),
	('0203171085', 'Rizky Fardiansyah Tanjung', 0, 1271, 1271, '1999-07-20', 1),
	('0204171028', 'Saeful Mizwar', 0, 3279, 3207, '1998-05-15', 2),
	('0204171029', 'Saiful Nur Iksan', 0, 3309, 3309, '1999-06-09', 2),
	('0102171047', 'Salma Rizkiyanti Alamsyah', 1, 3217, 3204, '1999-03-22', 3),
	('0204171030', 'Saras Ayuwati', 1, 3279, 3207, '1998-11-21', 2),
	('0102171049', 'Sihabudin Ali', 0, 3279, 3279, '1999-01-14', 3),
	('0203171086', 'Sinta Cantika', 1, 3217, 3204, '1999-08-23', 1),
	('0204171031', 'Siti Nurliani Susanti', 1, 3203, 3203, '1999-03-03', 2),
	('0101171156', 'Siti Salbyah', 1, 3271, 3271, '1999-10-15', 4),
	('0204171032', 'Sri Hayati', 1, 3207, 3207, '1999-05-25', 2),
	('0204171033', 'Suyanto', 0, 3274, 3274, '1998-09-05', 2),
	('0204171034', 'Syamsul Abdul Azis', 0, 3217, 3204, '1998-08-25', 2),
	('0305171046', 'Tiara Guntari', 1, 3204, 3204, '1999-06-21', 5),
	('0204171036', 'Tina Oktapiani', 1, 3279, 3279, '1998-10-29', 2),
	('0204171037', 'Tri Noverita Sari', 1, 3302, 3302, '1998-11-09', 2),
	('0101171159', 'Ulfiana Dewi', 1, 3271, 3173, '1999-09-21', 4),
	('0203171087', 'Wia Handayani', 1, 3274, 3274, '1998-07-04', 1),
	('0204171038', 'Yandi', 0, 3212, 3212, '1997-04-10', 2);

UPDATE akun SET nama_pengguna = 'sihab' WHERE id = '0102171049';
UPDATE akun SET nama_pengguna = 'aldi' WHERE id = '0407171001';
UPDATE akun SET nama_pengguna = 'nenti' WHERE id = '0203171084';
UPDATE akun SET nama_pengguna = 'salma' WHERE id = '0102171047';
UPDATE akun SET nama_pengguna = 'helma' WHERE id = '0102171037';
UPDATE akun SET nama_pengguna = 'herdi' WHERE id = '0203171083';

# Angkatan 17
ALTER TABLE akun
	ALTER angkatan SET DEFAULT 17;

INSERT INTO akun (id, nama, jenis_kelamin, daerah_asal, tempat_lahir, tanggal_lahir, program_studi) VALUES
	('0204181001', 'Abdul Manaf Yusro', 0, 3217, 3204, '2000-01-21', 2),
	('0204181002', 'Abdul Rozaq Rizki Akbar', 0, 3217, 3204, '2001-03-22', 2),
	('0203181027', 'Ade Radia Rahmat', 0, 3279, 3207, '2000-04-08', 1),
	('0204181003', 'Agam Mudhaqir', 0, 3203, 3205, '1999-08-29', 2),
	('0204181004', 'Ahmad Sukriana', 0, 3217, 3204, '1999-12-15', 2),
	('0204181005', 'Alif Rahman Firdaus', 0, 3203, 3203, '2000-06-02', 2),
	('0204181006', 'Anisa Restu Nurhamidah', 1, 3217, 3204, '2000-02-22', 2),
	('0305181058', 'Anjani Arum Safitri', 1, 3373, 3322, '1999-12-14', 5),
	('0102181021', 'Annisa Rizky Mulya', 1, 1471, 1471, '2000-07-27', 3),
	('0204181007', 'Cahyati Ayuningtias', 1, 3301, 3301, '2001-03-24', 2),
	('0204181009', 'Dadan Ramdani', 0, 3207, 3207, '1999-01-06', 2),
	('0204181010', 'Dandy Fadillah Setiady', 0, 3217, 3173, '1999-08-08', 2),
	('0204181013', 'Della Octa Irmulvani', 1, 1471, 1471, '1999-10-05', 2),
	('0204181014', 'Desi Ramadhani', 1, 1471, 1471, '1999-12-30', 2),
	('0101181140', 'Desy Rachmawati', 1, 3217, 3204, '1999-10-11', 4),
	('0204181015', 'Dio Prasetiyo', 0, 3212, 3212, '2000-04-21', 2),
	('0204181016', 'Elisa Septiani Lubis', 1, 1277, 1203, '2000-09-10', 2),
	('0204181017', "Halimatus Sa'diah", 1, 3212, 3212, '2000-02-10', 2),
	('0204181018', 'Hana Hasanah', 1, 3205, 3205, '2000-07-11', 2),
	('0406181006', 'Hesti Lestari', 1, 3207, 3207, '1999-10-05', 6),
	('0102181024', 'Ica Octa Monica', 1, 3217, 3204, '1999-10-30', 3),
	('0101181139', 'Kartini Rosady Tanjung', 1, 1271, 1271, '2000-08-28', 4),
	('0204181020', 'Laesya Ayu Reana', 1, 3218, 3207, '2000-10-13', 2),
	('0204181021', 'Lia Rizkiani', 1, 3207, 3207, '1999-12-27', 2),
	('0204181024', 'Muhamad Iqbal', 0, 3217, 3204, '1999-12-07', 2),
	('0204181022', 'Muhammad Fahmi Rosyadi', 0, 3373, 3322, '1999-06-26', 2),
	('0204181025', 'Muhammad Nurfaadil', 0, 3207, 3207, '1999-06-06', 2),
	('0204181026', 'Muhammad Resha Ansori', 0, 3205, 3205, '1999-03-10', 2),
	('0204181027', 'Muhridho Aldyansyah', 0, 3212, 3311, '2000-04-20', 2),
	('0204181030', 'Ragil Hadiworo', 0, 3203, 3203, '1999-07-20', 2),
	('0204181031', 'Raihan Rizqi Fauzan', 0, 3279, 3207, '2001-01-17', 2),
	('0203181044', 'Randi Firmansyah', 0, 3217, 3204, '2000-06-04', 1),
	('0204181033', 'Rian Hidayat', 0, 3217, 3204, '1999-09-20', 2),
	('0102181023', 'Sri Putri Andriani', 1, 1471, 1471, '2000-07-03', 3),
	('0204181034', 'Suratri', 1, 3304, 3304, '2001-04-06', 2),
	('0204181035', 'Tarisa Sri Rizki', 1, 3206, 3206, '2000-04-04', 2),
	('02041891036', 'Tria Sagita Kusparmanto', 0, 3302, 3302, '2000-07-10', 2),
	('0204181038', 'Winna Dwi Waluyo', 1, 3302, 3302, '2000-01-26', 2),
	('0102181020', 'Yayat Hidayat', 0, 3217, 3204, '1999-07-09', 3),
	('0204181039', 'Yayu Fajriati Rahayu', 1, 3207, 3207, '1999-05-29', 2),
	('0204181040', 'Yessy Sylviana Adyawati', 1, 3309, 3309, '1999-04-22', 2);

UPDATE akun SET nama_pengguna = 'aderadia' WHERE id = '0203181027';
UPDATE akun SET nama_pengguna = 'randi' WHERE id = '0203181044';
UPDATE akun SET nama_pengguna = 'yayat' WHERE id = '0102181020';
UPDATE akun SET nama_pengguna = 'sriputri' WHERE id = '0102181023';

# Angkatan 18
ALTER TABLE akun
	ALTER angkatan SET DEFAULT 18;

INSERT INTO akun (id, nama_pengguna, nama, jenis_kelamin, daerah_asal, tempat_lahir, tanggal_lahir, program_studi) VALUES
	('02041911001', 'ade', 'Ade Heriyanto', 0, 3212, 3212, '2000-07-30', 2),
	('03051911024', 'adi', 'Adi Kurniawan', 0, 1471, 1471, '2001-09-07', 5),
	('01021911017', 'afida', "Af'idatul Maghfiroh", 1, 3373, 3322, '2001-09-08', 3),
	('02041911002', 'analuam', 'Anjar Maulana', 0, 3217, 3204, '2000-07-02', 2),
	('02041911003', 'annisa', 'Annisa Nur Wachidah', 1, 3373, 3374, '2001-05-03', 2),
	('02041911004', 'ara', 'Ara Irawan', 0, 3207, 3207, '2000-07-03', 2),
	('02041911005', 'arina', 'Arina Anggelina Lubis', 1, 1277, 1203, '2000-07-16', 2),
	('02041911006', 'auliya', 'Auliya Annidatunnisa', 1, 3203, 3203, '2001-04-30', 2),
	('02041911007', 'candra', 'Candra Komara', 0, 3217, 3204, '2001-04-24', 2),
	('02041911008', 'dede', 'Dede Rifaldi', 0, 3212, 3212, '2001-01-13', 2),
	('01021911021', 'dian', "Dian Nurul Khazaainatu Qurrota A'yun", 1, 3206, 3207, '2001-08-27', 3),
	('02041911009', 'mazlemon', 'Diki Indrayana', 0, 3309, 3309, '2002-01-17', 2),
	('02041911010', 'donni', 'Donni Rahmad Harahap', 0, 1277, 1203, '2001-07-10', 2),
	('02041911011', 'eka', 'Eka Apriliani', 1, 3373, 3374, '2001-04-05', 2),
	('01021911024', 'elvina', 'Elvina Fitriani', 1, 1471, 1377, '2001-01-04', 3),
	('02041911012', 'firdi', 'Fatin Firdiansyah', 0, 3301, 3302, '2001-10-02', 2),
	('03051911029', 'galih', 'Galih Ahmad Septian', 0, 3309, 3309, '2001-09-30', 5),
	('02031911056', 'habib', 'Habib Jannata', 0, 1471, 1471, '2001-05-31', 1),
	('02031911057', 'hanafi', 'Hanafi Abdullah', 0, 3309, 3309, '2000-04-23', 1),
	('02041911013', 'hani', 'Hani Octaviani', 1, 3218, 3213, '2000-10-10', 2),
	('02041911014', 'hasby', 'Hasby Ramadhan', 0, 1275, 1275, '1999-12-08', 2),
	('02041911015', 'helen', 'Helen Miftakhul Jannah', 1, 3309, 3309, '2001-01-20', 2),
	('02041911016', 'hera', 'Hera Elvira', 1, 3279, 3207, '2000-07-12', 2),
	('02041911017', 'ima', 'Ima Nirmala', 1, 3205, 3210, '2000-11-02', 2),
	('02041911018', 'iqbal', 'Iqbal Sihabudin', 0, 3207, 3207, '2000-02-12', 2),
	('02041911019', 'iskandar', 'Iskandar Zulkarnain Hasibuan', 0, 1277, 1203, '2000-02-05', 2),
	('02041911020', 'jaja', 'Jaja Nurjana', 0, 3279, 3207, '2000-01-30', 2),
	('02041911021', 'lulu', 'Lulu Fitri Ramadani', 1, 3217, 3204, '2000-12-26', 2),
	('02041911022', 'maratus', "Mar'atus Sholikha", 1, 3373, 3322, '2001-01-11', 2),
	('02041911023', 'mia', 'Mia Salha Syakila', 1, 3205, 3205, '2001-06-16', 2),
	('03051911032', 'afkarhq', 'Moh Afkarul Haq', 0, 3207, 3207, '2000-09-27', 5),
	('02041911024', 'rizal', 'Muhammad Rizal', 0, 3214, 3214, '2001-05-13', 2),
	('02041911025', 'niki', 'Nikita Putri Septemby', 1, 3279, 5171, '2000-09-04', 2),
	('02041911026', 'putri', 'Putri Melenia', 1, 3279, 3207, '2000-01-22', 2),
	('02041911027', 'danil', 'Rahma Danil', 0, 1471, 1406, '2000-07-31', 2),
	('02041911028', 'rahma', 'Rahma Fauziah', 1, 3309, 3309, '2001-10-07', 2),
	('02041911029', 'raisa', 'Raisa Kamel', 1, 3203, 3205, '2000-08-08', 2),
	('02031911067', 'romi', 'Romi Kusuma Bakti', 0, 3309, 3309, '2001-02-02', 1),
	('02041911030', 'aisyah', 'Siti Nuraisah', 1, 3207, 3207, '2000-08-06', 2),
	('02041911031', 'bila', 'Siti Nursabila', 1, 3217, 3204, '2001-04-26', 2),
	('02041911032', 'tasya', 'Tasya Nurfatimah', 1, 3214, 3214, '2000-01-31', 2),
	('01021911037', 'tiara', 'Tiara Agustin', 1, 3214, 3214, '2001-08-23', 3),
	('02031911070', 'titik', 'Titik Andini', 1, 3301, 3315, '2001-03-27', 1),
	('02041911033', 'tito', 'Tito Soediro', 0, 3212, 3212, '2001-11-26', 2),
	('02041911034', 'wati', 'Wati Haryati', 1, 3207, 3207, '2000-09-09', 2),
	('03051911040', 'yhepra', 'Yoga Hendrapratama', 0, 3207, 3207, '2000-07-07', 5);

UPDATE akun SET developer = TRUE WHERE nama_pengguna = 'romi';

# Angkatan 19
ALTER TABLE akun
	ALTER angkatan SET DEFAULT 19,
    ALTER program_studi SET DEFAULT 2;

INSERT INTO akun (id, nama, jenis_kelamin, daerah_asal, tempat_lahir, tanggal_lahir) VALUES
	('02042011001', 'Agus Shofyan Dwi Saputro', 0, 3373, 3322, '2001-09-01'),
	('02042011002', 'Aren Kurnia', 1, 3213, 3213, '2001-03-06'),
	('02042011003', 'Ari Sandi Shefa Maldini', 0, 3279, 3279, '2001-04-12'),
	('02042011004', 'Arie Akbar', 0, 1305, 1508, '2002-03-25'),
	('02042011005', 'Aris Purnama', 0, 3207, 3207, '2001-11-16'),
	('02042011006', 'Asep Hidayat', 0, 3217, 3204, '2002-02-01'),
	('02042011007', 'Awaludin Muhammad Iqbal', 0, 3207, 3207, '2002-03-20'),
	('02042011008', 'Bayu Wijiana', 0, 3302, 3302, '2002-09-12'),
	('02042011009', 'Burhanudin Hawari', 0, 3214, 3214, '2002-02-01'),
	('02042011010', 'Cahaya Hartati Sitanggang', 1, 1271, 1271, '2001-06-07'),
	('02042011011', 'Dani Hidayat', 0, 1471, 1471, '2001-10-16'),
	('02042011012', 'Dion Ferdian Syam', 0, 1471, 1471, '2001-02-08'),
	('02042011013', 'Edwar Maulana Sitompul', 0, 1271, 1271, '2001-08-18'),
	('02042011014', 'Imron Fuadi', 0, 3304, 3304, '2000-11-18'),
	('02042011015', 'Indah Mentari', 1, 3217, 3173, '2002-05-23'),
	('02042011016', 'Jamil Hamdi Harahap', 0, 1277, 1203, '2001-12-06'),
	('02042011017', 'Kurnia Zulianti', 1, 3302, 3302, '2002-07-22'),
	('02042011018', 'Mita Zuriati', 1, 1471, 5206, '2002-10-12'),
	('02042011019', 'Muhammad Rozin Dzakwan', 0, 3309, 3374, '2001-02-11'),
	('02042011020', 'Muzayyin Al-Afnan Siregar', 0, 1277, 1203, '2002-06-11'),
	('02042011021', "Nushrotummillah Nurul 'Aini", 1, 3309, 3309, '2003-05-19'),
	('02042011022', 'Risa Alfadila', 1, 1277, 1203, '2002-06-23'),
	('02042011023', 'Sabila Noor Sania', 1, 3217, 3204, '2002-12-15'),
	('02042011024', 'Seli Deslia', 1, 3217, 3204, '2002-04-30'),
	('02042011025', 'Sely Amalia', 1, 3217, 3204, '2001-07-19'),
	('02042011026', 'Sri Nuhayatun', 1, 3212, 3212, '2001-08-03'),
	('02042011027', 'Yusfa Julian', 0, 3217, 3204, '2001-07-16');

# Angkatan 14
ALTER TABLE akun
	ALTER angkatan SET DEFAULT 14;

INSERT INTO akun (id, nama_pengguna, nama, jenis_kelamin, daerah_asal, tempat_lahir, tanggal_lahir) VALUES
	('0000000001', 'ilfa', 'Ilfa Sri Desy', 1, 3203, 3203, '1997-12-06'),
	('0000000002', 'sandi', 'Sandi Saputra', 0, 3205, 3205, '1997-10-01');
    
UPDATE akun SET nama_pengguna = 'ozin' WHERE id = '02042011019';
UPDATE akun SET nama_pengguna = 'nunun' WHERE id = '02042011021';

UPDATE akun SET status = 2 WHERE angkatan = 16 AND (program_studi = 1 OR program_studi = 6);

# Organisasi PUB
ALTER TABLE jabatan_akun
	ALTER organisasi SET DEFAULT 1;

INSERT INTO jabatan_akun (akun, jabatan, awal_menjabat) VALUES
	('0402067001', @pembina, 2002);

INSERT INTO jabatan_akun (akun, jabatan, awal_menjabat, akhir_menjabat) VALUES
	('0204171017', @ketua, 2018, 2019),
	('0204171014', @keamanan, 2018, 2019),
	('0102171047', @sekretaris, 2018, 2019),
	('0102171037', @bendahara, 2018, 2020),
	('0204171032', @bendahara, 2018, 2019),

    ('0102171049', @ketua, 2019, 2020),
	('0203171085', @keamanan, 2019, 2020),
	('0203171084', @sekretaris, 2019, 2020),
	('0102171037', @bendahara, 2019, 2020),
	('0102171047', @bendahara, 2019, 2020),
    
	('0203181027', @ketua, 2020, 2021),
	('0203181044', @keamanan, 2020, 2021),
	('0102181023', @sekretaris, 2020, 2021),
	('0102181021', @bendahara, 2020, 2021),
	('0203171084', @bendahara, 2020, 2021);

INSERT INTO jabatan_akun (akun, jabatan, divisi, awal_menjabat, akhir_menjabat) VALUES
	('0203171085', 6, @pendidikan, 2018, 2019),
	('0204171008', 6, @kerohanian, 2018, 2019),
	('0204171006', 6, @kebersihan, 2018, 2019),
	('0204171018', 6, @kesejahteraan, 2018, 2019),
	('0204171014', 6, @keasramaan, 2018, 2019),
	('0203171083', 6, @magang, 2018, 2019),
	('0204171010', 6, @kesehatan, 2018, 2019),
    
	('0407171001', 6, @pendidikan, 2019, 2020),
	('0203181027', 6, @kerohanian, 2019, 2020),
	('0204181004', 6, @kebersihan, 2019, 2020),
	('0204181026', 6, @kesejahteraan, 2019, 2020),
	('0203171085', 6, @keasramaan, 2019, 2020),
	('0204181005', 6, @magang, 2019, 2020),
	('0203181044', 6, @kesehatan, 2019, 2020),
    
	('0102181020', 6, @pendidikan, 2020, 2021),
	('02031911067', 6, @kerohanian, 2020, 2021),
	('02031911056', 6, @kebersihan, 2020, 2021),
	('02041911020', 6, @kesejahteraan, 2020, 2021),
	('02041911033', 6, @keasramaan, 2020, 2021),
	('0204181015', 6, @kesehatan, 2020, 2021),
    
	('0102181024', 8, @pendidikan, 2020, 2021),
	('02041911007', 8, @pendidikan, 2020, 2021),
	('02041911027', 8, @pendidikan, 2020, 2021),
	('02041911025', 8, @pendidikan, 2020, 2021),
	('01021911037', 8, @pendidikan, 2020, 2021),
	('02041911002', 8, @pendidikan, 2020, 2021),
	('02041911008', 8, @pendidikan, 2020, 2021),
	('02041911016', 8, @pendidikan, 2020, 2021),
	('03051911040', 8, @pendidikan, 2020, 2021),

	('02041911017', 8, @kerohanian, 2020, 2021),
	('02041911030', 8, @kerohanian, 2020, 2021),

	('02041911009', 8, @kebersihan, 2020, 2021),
	('02041911001', 8, @kebersihan, 2020, 2021),
	('02041911014', 8, @kebersihan, 2020, 2021),
	('02041911011', 8, @kebersihan, 2020, 2021),

	('02041911012', 8, @kesejahteraan, 2020, 2021),
	('02031911057', 8, @kesejahteraan, 2020, 2021),
	('02031911070', 8, @kesejahteraan, 2020, 2021),
	('02041911022', 8, @kesejahteraan, 2020, 2021),

	('02041911024', 8, @keasramaan, 2020, 2021),
	('0101181139', 8, @keasramaan, 2020, 2021),
	('0406181006', 8, @keasramaan, 2020, 2021),
	('02041911006', 8, @keasramaan, 2020, 2021),
	('02041911013', 8, @keasramaan, 2020, 2021),

	('03051911029', 8, @kesehatan, 2020, 2021),
	('0305181058', 8, @kesehatan, 2020, 2021),
	('02041911032', 8, @kesehatan, 2020, 2021),
	('02041911028', 8, @kesehatan, 2020, 2021);

# Organisasi PPMB PUB
ALTER TABLE jabatan_akun
	ALTER organisasi SET DEFAULT 2;

INSERT INTO jabatan_akun (akun, jabatan, awal_menjabat, akhir_menjabat) VALUES
	('03051911032', @ketua, 2020, 2021),
	('02041911003', @sekretaris, 2020, 2021),
	('01021911024', @sekretaris, 2020, 2021),
	('01021911021', @sekretaris, 2020, 2021);
    
INSERT INTO jabatan_akun (akun, jabatan, divisi, awal_menjabat, akhir_menjabat) VALUES
	('01021911017', 8, @humas, 2020, 2021),
	('02041911026', 8, @humas, 2020, 2021),
    
	('03051911040', 8, @logistik, 2020, 2021),
	('01021911037', 8, @logistik, 2020, 2021),
	('02041911025', 8, @logistik, 2020, 2021),
	('02041911027', 8, @logistik, 2020, 2021),
	('02041911018', 8, @logistik, 2020, 2021),
    
	('02031911067', 8, @dokumentasi, 2020, 2021),
	('02042011012', 8, @dokumentasi, 2020, 2021),
    
	('03051911024', 8, @d_keamanan, 2020, 2021),
	('02041911019', 8, @d_keamanan, 2020, 2021);

CREATE TABLE pengumuman (
	id INT PRIMARY KEY NOT NULL,
    judul VARCHAR(32) NOT NULL,
    isi VARCHAR(32) NOT NULL,
    dari VARCHAR(16) NOT NULL,
    tanggal_waktu DATETIME,
    FOREIGN KEY (dari) REFERENCES akun (id)
);

CREATE TABLE mudik (
	id VARCHAR(16) PRIMARY KEY NOT NULL,
    berangkat DATETIME NOT NULL,
    kembali DATETIME NOT NULL,
    tujuan CHAR(4),
    FOREIGN KEY (id) REFERENCES akun (id),
	FOREIGN KEY (tujuan) REFERENCES kabupaten (id)
);

# Mudik pembina
INSERT INTO mudik VALUES
	('0402067001', '2021-05-04 22:00', '2021-05-26 09:00', 1271);

# Mudik angkatan 16
INSERT INTO mudik VALUES
	('0203171082', '2021-05-05 07.00', '2021-05-25 17.00', 3207),
	('0102171037', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('0101171134', '2021-05-04 22.00', '2021-05-26 09.00', 3309),
	('0203171084', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('0204171024', '2021-05-05 07.00', '2021-05-25 17.00', 3279),
	('0406171007', '2021-05-05 07.00', '2021-05-25 17.00', 3214),
	('0102171047', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('0102171049', '2021-05-05 07.00', '2021-05-25 17.00', 3279),
	('0203171086', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('0101171156', '2021-05-05 07.00', '2021-05-25 17.00', 3271),
	('0305171046', '2021-05-05 07.00', '2021-05-25 17.00', 3204),
	('0101171159', '2021-05-05 07.00', '2021-05-25 17.00', 3271),
	('0203171087', '2021-05-05 02.00', '2021-05-25 17.00', 3274);

# Mudik angkatan 17
INSERT INTO mudik VALUES
	('0203181027', '2021-05-05 07:00', '2021-05-25 17:00', 3279),
	('0305181058', '2021-05-04 22:00', '2021-05-26 09:00', 3373),
	('0102181021', '2021-05-04 23:00', '2021-05-25 17:00', 1471),
	('0204181015', '2021-05-05 02:00', '2021-05-25 17:00', 3212),
	('0406181006', '2021-05-05 07:00', '2021-05-25 17:00', 3207),
	('0102181024', '2021-05-05 06:00', '2021-05-25 17:00', 3217),
	('0101181139', '2021-05-05 07:00', '2021-05-26 17:00', 1271),
	('0203181044', '2021-05-05 07:00', '2021-05-25 17:00', 3217),
	('0102181023', '2021-05-05 02:00', '2021-05-25 17:00', 1471),
	('0102181020', '2021-05-05 07:00', '2021-05-25 17:00', 3217);

# Mudik angkatan 18
INSERT INTO mudik VALUES
	('02041911001', '2021-05-05 07:00', '2021-05-25 17:00', 3275),
	('01021911017', '2021-05-04 22:00', '2021-05-26 09:00', 3373),
	('02041911002', '2021-05-05 07:00', '2021-05-25 17:00', 3217),
	('02041911003', '2021-05-04 22:00', '2021-05-26 09:00', 3373),
	('02041911005', '2021-05-04 22:00', '2021-05-26 09:00', 3309),
	('02041911006', '2021-05-05 05:00', '2021-05-25 17:00', 3203),
	('02041911007', '2021-05-05 07:00', '2021-05-25 17:00', 3217),
	('02041911008', '2021-05-05 02:00', '2021-05-25 17:00', 3212),
	('01021911021', '2021-05-05 07:00', '2021-05-25 17:00', 3206),
	('02041911009', '2021-05-04 22:00', '2021-05-26 09:00', 3309),
	('02041911011', '2021-05-04 22:00', '2021-05-26 09:00', 3373),
	('01021911024', '2021-05-04 23:00', '2021-05-25 17:00', 1471),
	('02041911012', '2021-05-05 07:00', '2021-05-25 17:00', 3301),
	('03051911029', '2021-05-04 22:00', '2021-05-26 09:00', 3309),
	('02031911056', '2021-05-05 07:00', '2021-05-25 17:00', 1471),
	('02031911057', '2021-05-04 22:00', '2021-05-26 09:00', 3309),
	('02041911013', '2021-05-05 07:00', '2021-05-25 17:00', 3218),
	('02041911015', '2021-05-04 22:00', '2021-05-26 09:00', 3309),
	('02041911016', '2021-05-05 07:00', '2021-05-25 17:00', 3279),
	('02041911017', '2021-05-05 05:00', '2021-05-25 17:00', 3205),
	('02041911018', '2021-05-05 07:00', '2021-05-25 17:00', 3207),
	('02041911020', '2021-05-05 07:00', '2021-05-25 17:00', 3279),
	('02041911022', '2021-05-04 22:00', '2021-05-26 09:00', 3373),
	('02041911023', '2021-05-05 05:00', '2021-05-25 17:00', 3205),
	('03051911032', '2021-05-05 07:00', '2021-05-25 17:00', 3207),
	('02041911024', '2021-05-05 07:00', '2021-05-25 17:00', 3214),
	('02041911025', '2021-05-04 19:30', '2021-05-25 17:00', 3279),
	('02041911026', '2021-05-05 05:00', '2021-05-25 17:00', 3279),
	('02041911027', '2021-05-05 07:00', '2021-05-25 17:00', 1471),
	('02041911028', '2021-05-04 22:00', '2021-05-26 09:00', 3309),
	('02041911029', '2021-05-05 05:00', '2021-05-25 17:00', 3203),
	('02031911067', '2021-05-04 22:00', '2021-05-26 09:00', 3309),
	('02041911030', '2021-05-05 07:00', '2021-05-25 17:00', 3207),
	('02041911031', '2021-05-05 07:00', '2021-05-25 17:00', 3217),
	('02041911032', '2021-05-05 07:00', '2021-05-25 17:00', 3214),
	('01021911037', '2021-05-05 07:00', '2021-05-25 17:00', 3214),
	('02031911070', '2021-05-05 07:00', '2021-05-25 17:00', 3301),
	('02041911033', '2021-05-05 02:00', '2021-05-25 17:00', 3212),
	('03051911040', '2021-05-05 05:00', '2021-05-25 17:00', 3207);

# Mudik angkatan 19
INSERT INTO mudik VALUES
	('02042011001', '2021-05-04 22.00', '2021-05-26 09.00', 3373),
	('02042011002', '2021-05-05 07.00', '2021-05-25 17.00', 3213),
	('02042011003', '2021-05-05 07.00', '2021-05-25 17.00', 3279),
	('02042011004', '2021-05-05 07.00', '2021-05-25 17.00', 1305),
	('02042011005', '2021-05-04 23.00', '2021-05-25 17.00', 3207),
	('02042011006', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('02042011007', '2021-05-05 07.00', '2021-05-25 17.00', 3207),
	('02042011008', '2021-05-05 07.00', '2021-05-25 17.00', 3302),
	('02042011009', '2021-05-05 07.00', '2021-05-25 17.00', 3214),
	('02042011010', '2021-05-05 07.00', '2021-05-26 17.00', 1271),
	('02042011011', '2021-05-05 07.00', '2021-05-25 17.00', 3279),
	('02042011012', '2021-05-05 07.00', '2021-05-25 17.00', 1471),
	('02042011013', '2021-05-05 07.00', '2021-05-26 17.00', 1271),
	('02042011014', '2021-05-05 07.00', '2021-05-25 17.00', 3304),
	('02042011015', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('02042011017', '2021-05-05 07.00', '2021-05-25 17.00', 3302),
	('02042011018', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('02042011019', '2021-05-04 22.00', '2021-05-26 09.00', 3309),
	('02042011020', '2021-05-04 23.00', '2021-05-26 17.00', 1277),
	('02042011021', '2021-05-04 22.00', '2021-05-26 09.00', 3309),
	('02042011022', '2021-05-04 23.00', '2021-05-26 17.00', 1277),
	('02042011023', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('02042011024', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('02042011025', '2021-05-05 07.00', '2021-05-25 17.00', 3217),
	('02042011026', '2021-05-05 07.00', '2021-05-25 17.00', 3212),
	('02042011027', '2021-05-05 07.00', '2021-05-25 17.00', 3217);

# Mudik angkatan 14
INSERT INTO mudik VALUES
	('0000000001', '2021-05-04 22:00', '2021-05-26 09:00', 3203),
	('0000000002', '2021-05-04 22:00', '2021-05-26 09:00', 3205);