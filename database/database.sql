-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: dealership
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `email` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone_num` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('aaluzzi@dealership.com','Austin','Aluzzi','3569963216','123'),('amask@dealership.com','Alon','Mask','9563265543','123'),('bdukowski@dealership.com','Blake','Dukowski','1236523362','123'),('customer1@gmail.com','Customer','One','1111111111','111'),('customer2@gmail.com','Customer','Two','2222222222','222'),('customer3@gmail.com','Customer','Three','3333333333','333'),('hzhang@dealership.com','Hanmo','Zhang','0125634479','123'),('jbiden@dealership.com','Jonny','Biden','1230456678','123'),('jcena@dealership.com','John','Cena','7422013347','123'),('kkinoshita@dealership.com','Kristine','Kinoshita','1224537088','123'),('rreyes@dealership.com','Richard','Reyes','2665593265','123');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `customer_email` varchar(45) NOT NULL,
  `vin` varchar(45) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`customer_email`,`vin`),
  KEY `vin_idx` (`vin`) /*!80000 INVISIBLE */,
  KEY `customer_email_idx` (`customer_email`),
  CONSTRAINT `customer_email` FOREIGN KEY (`customer_email`) REFERENCES `customer` (`customer_email`),
  CONSTRAINT `vin` FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES ('customer1@gmail.com','1HGCV1F34KA098390','2022-12-11 09:00:00'),('customer1@gmail.com','2C3CDXHG1JH272487','2022-12-08 12:00:00'),('customer1@gmail.com','WAUACGFF7F1002554','2022-12-08 16:00:00');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commission`
--

DROP TABLE IF EXISTS `commission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commission` (
  `employee_email` varchar(45) NOT NULL,
  `vin` varchar(45) NOT NULL,
  `percentage` int DEFAULT NULL,
  PRIMARY KEY (`employee_email`,`vin`),
  KEY `vin3_idx` (`vin`),
  CONSTRAINT `email3` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`employee_email`),
  CONSTRAINT `vin3` FOREIGN KEY (`vin`) REFERENCES `sale` (`vin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commission`
--

LOCK TABLES `commission` WRITE;
/*!40000 ALTER TABLE `commission` DISABLE KEYS */;
INSERT INTO `commission` VALUES ('amask@dealership.com','1N4BL4BV6LC116800',5),('amask@dealership.com','WBAJA9C5XKB254090',4),('jcena@dealership.com','1N4BL4BV6LC116800',10),('jcena@dealership.com','3GNBABDB9AS527906',15),('jcena@dealership.com','WBAJA9C5XKB254090',9),('rreyes@dealership.com','WBAJA9C5XKB254090',2);
/*!40000 ALTER TABLE `commission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_email` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_email`),
  CONSTRAINT `email2` FOREIGN KEY (`customer_email`) REFERENCES `account` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('customer1@gmail.com','111 St'),('customer2@gmail.com','222 St'),('customer3@gmail.com','333 St');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_email` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`employee_email`),
  CONSTRAINT `email` FOREIGN KEY (`employee_email`) REFERENCES `account` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('aaluzzi@dealership.com','Sr Salesperson'),('amask@dealership.com','Jr Salesperson'),('bdukowski@dealership.com','Jr Salesperson'),('jcena@dealership.com','Sr Salesperson'),('kkinoshita@dealership.com','Sr Salesperson'),('rreyes@dealership.com','Manager');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `vin` varchar(45) NOT NULL,
  `agreed_price` float DEFAULT NULL,
  `tax` float DEFAULT NULL,
  `card_num` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `customer_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`vin`),
  KEY `vin_idx` (`vin`),
  KEY `email_idx` (`customer_email`),
  CONSTRAINT `email4` FOREIGN KEY (`customer_email`) REFERENCES `customer` (`customer_email`),
  CONSTRAINT `vin4` FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES ('1N4BL4BV6LC116800',15000,1500,'1234123412341234','2022-12-04 16:40:59','customer1@gmail.com'),('3GNBABDB9AS527906',5500,550,'2222222222222222','2022-12-04 16:41:46','customer2@gmail.com'),('WBAJA9C5XKB254090',30000,3000,'3333333333333333','2022-12-04 16:42:43','customer3@gmail.com');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `vin` varchar(45) NOT NULL,
  `year` int NOT NULL,
  `make` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `style` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `mileage` int NOT NULL,
  `listing_price` int NOT NULL,
  `sold` tinyint NOT NULL,
  PRIMARY KEY (`vin`),
  UNIQUE KEY `vin_UNIQUE` (`vin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('19XFB2F88DE235496',2013,'Honda','Civic','Sedan','Gray',116717,12725,0),('1C3CDFFA5GD796272',2016,'Dodge','Dart','Sedan','Silver',102289,9038,0),('1D7HA18N04S669455',2004,'Dodge','Ram 1500','Pickup Truck','Gray',203584,6528,0),('1FA6P8TH5H5307545',2017,'Ford','Mustang','Coupe','White',121387,16715,0),('1FADP5BU8DL503117',2013,'Ford','C-Max','Sedan','White',107530,10850,0),('1FM5K7D8XGGA97973',2016,'Ford','Explorer','SUV','Silver',145839,13899,0),('1FTEW1C44LFA74631',2020,'Ford','F-150','Pickup Truck','Blue',64091,39991,0),('1FTEW1EB0JKE78333',2018,'Ford','F-150','Pickup Truck','Silver',70457,28395,0),('1G1105S32HU191829',2017,'Chevrolet','Impala','Sedan','Black',94764,14899,0),('1G1BE5SM4J7104340',2018,'Chevrolet','Cruze','Sedan','White',93537,11499,0),('1G1FB1RX2H0177289',2017,'Chevrolet','Camaro','Coupe','Silver',49896,21809,0),('1G1PF5SC8C7118805',2012,'Chevrolet','Cruze','Sedan','White',127593,6767,0),('1G1RC6E48FU129398',2015,'Chevrolet','Volt','Sedan','Black',124068,11712,0),('1G1RC6S51KU111560',2019,'Chevrolet','Volt','Sedan','Silver',37734,23598,0),('1G1ZC5ST3LF063574',2020,'Chevrolet','Malibu','Sedan','Silver',7395,19998,0),('1G1ZD5ST0KF106084',2019,'Chevrolet','Malibu','Sedan','Black',57136,18946,0),('1G1ZD5ST0LF036409',2020,'Chevrolet','Malibu','Sedan','Silver',46321,18678,0),('1GNKRHKDXGJ347327',2016,'Chevrolet','Traverse','SUV','Black',62700,17500,0),('1GNSCAKC8KR209828',2019,'Chevrolet','Tahoe','SUV','Gray',39225,36000,0),('1HGCR2F52GA195980',2016,'Honda','Accord','Sedan','White',116279,16586,0),('1HGCV1F34KA098390',2019,'Honda','Accord','Sedan','White',40647,25999,0),('1HGCV1F38LA111109',2020,'Honda','Accord','Sedan','White',39478,28319,0),('1N4AL3AP1HC157688',2017,'Nissan','Altima','Sedan','Blue',54393,16999,0),('1N4AL3AP7HC163303',2017,'Nissan','Altima','Sedan','Black',44298,16799,0),('1N4BL4BV6LC116800',2020,'Nissan','Altima','Sedan','White',27515,19995,1),('1N4BL4CV9LC131564',2020,'Nissan','Altima','Sedan','Blue',35000,23010,0),('1N4BL4DVXKC123311',2019,'Nissan','Altima','Sedan','Silver',30247,18699,0),('1N6AD0EV5KN728543',2019,'Nissan','Frontier','Pickup Truck','White',44762,25902,0),('1ZVBP8AM2E5257334',2014,'Ford','Mustang','Coupe','Black',78664,15160,0),('2C3CDXHG1JH272487',2018,'Dodge','Charger','Sedan','White',44754,20999,0),('2C3CDXL99NH159322',2022,'Dodge','Charger','Sedan','Black',4648,91991,0),('2FMPK3J96HBB57450',2017,'Ford','Edge','SUV','Silver',93854,14333,0),('2G1FK1EJ8D9106292',2013,'Chevrolet','Camaro','Coupe','Black',94192,18698,0),('2HGFC2F63KH545425',2019,'Honda','Civic','Sedan','White',49496,22095,0),('2HGFC2F66KH536170',2019,'Honda','Civic','Sedan','White',57504,21345,0),('2HGFC2F88KH603000',2019,'Honda','Civic','Sedan','White',45387,22898,0),('2HGFG3B50EH516508',2014,'Honda','Civic','Coupe','Gray',106118,12241,0),('2HKRW5H39JH407708',2018,'Honda','CR-V','SUV','Silver',60654,20399,0),('2T1BURHE5FC424936',2015,'Toyota','Corolla','Sedan','White',160408,11225,0),('2T2ZZMCA0JC115340',2018,'Lexus','RX','SUV','White',39307,30999,0),('2T3H1RFV1MW104554',2021,'Toyota','RAV4','SUV','White',72547,23011,0),('2T3YL4DV3DW001622',2013,'Toyota','RAV4','SUV','White',92535,15070,0),('3CZRM3H3XEG712945',2014,'Honda','CR-V','SUV','Black',87485,14998,0),('3FA6P0H76FR151530',2015,'Ford','Fusion','Sedan','Silver',95514,9980,0),('3FA6P0HD7JR156640',2018,'Ford','Fusion','Sedan','White',53177,18000,0),('3FA6P0HD9KR218444',2019,'Ford','Fusion','Sedan','Blue',104603,14000,0),('3FA6P0RU6JR250085',2018,'Ford','Fusion','Sedan','White',48374,22499,0),('3GNBABDB9AS527906',2010,'Chevrolet','HHR','SUV','Silver',123300,5169,1),('3GNEC12077G221060',2007,'Chevrolet','Avalanche','Pickup Truck','Silver',188969,7777,0),('3KPFK4A78HE048601',2017,'Kia','Forte','Sedan','Silver',104850,11111,0),('3N1AB7AP5FY361079',2015,'Nissan','Sentra','Sedan','Black',66780,10000,0),('3N1AB7AP9GY309018',2016,'Nissan','Sentra','Sedan','Silver',106795,10212,0),('3N1AB8BV7LY234896',2020,'Nissan','Sentra','Sedan','Black',58483,16567,0),('3N1CN7AP3GL907084',2016,'Nissan','Versa','Sedan','Black',66451,11750,0),('3N1CN7AP9JL807336',2018,'Nissan','Versa','Sedan','White',73271,11999,0),('3N1CP5DV1LL562012',2020,'Nissan','Kicks','SUV','White',30000,21999,0),('3TMCZ5AN2HM112124',2017,'Toyota','Tacoma','Pickup Truck','White',61504,38500,0),('3TMDZ5BN7JM046758',2018,'Toyota','Tacoma','Pickup Truck','Black',78402,28888,0),('3TMLU4ENXDM121764',2013,'Toyota','Tacoma','Pickup Truck','Gray',165946,19999,0),('3VV1B7AX2KM050192',2019,'Volkswagen','Tiguan','SUV','White',49982,18843,0),('3VV3B7AX5KM064550',2019,'Volkswagen','Tiguan','SUV','Black',40989,21499,0),('3VV3B7AX5LM025071',2020,'Volkswagen','Tiguan','SUV','White',42132,23891,0),('3VW4T7AJ0HM337962',2017,'Volkswagen','Jetta','Sedan','Black',126525,13555,0),('3VWCB7BU0KM169593',2019,'Volkswagen','Jetta','Sedan','Black',46451,17900,0),('3VWD17AJ6EM368313',2014,'Volkswagen','Jetta','Sedan','White',92290,8999,0),('3VWDP7AJ0DM422704',2013,'Volkswagen','Jetta','Sedan','Black',85305,11405,0),('3VWVA7AT6CM605868',2012,'Volkswagen','Beetle','Hatchback','Black',120000,7769,0),('4T1B11HK1JU569060',2018,'Toyota','Camry','Sedan','Gray',80941,20000,0),('4T1B11HK7JU657899',2018,'Toyota','Camry','Sedan','Gray',59992,19599,0),('4T1BF32K83U046689',2003,'Toyota','Camry','Sedan','Silver',207366,4859,0),('4T1G11AK9LU331802',2020,'Toyota','Camry','Sedan','White',79451,22205,0),('4T1M11AK7LU503540',2020,'Toyota','Camry','Sedan','White',15667,26991,0),('5FNYF3H5XFB031883',2015,'Honda','Pilot','SUV','Black',114503,15498,0),('5FNYF5H56LB021679',2020,'Honda','Pilot','SUV','Black',25677,32945,0),('5FNYF5H91HB013810',2017,'Honda','Pilot','SUV','Black',94262,22555,0),('5FNYF6H79LB000509',2020,'Honda','Pilot','SUV','Black',79723,30977,0),('5J6RW1H52KL005627',2019,'Honda','CR-V','SUV','White',18888,25324,0),('5J6RW1H55JA014199',2018,'Honda','CR-V','SUV','Silver',55055,23595,0),('5J6RW1H83JA007584',2018,'Honda','CR-V','SUV','White',21570,25799,0),('5N1AT3BA4MC720422',2021,'Nissan','Rogue','SUV','Black',10518,26999,0),('5N1AZ2MG3HN143712',2017,'Nissan','Murano','SUV','White',85595,17500,0),('5NPE24AF0KH751440',2019,'Hyundai','Sonata','Sedan','Black',57575,17977,0),('5NPE24AF6HH528571',2017,'Hyundai','Sonata','Sedan','Gray',115229,10897,0),('5NPEB4ACXBH183364',2011,'Hyundai','Sonata','Sedan','White',82000,7109,0),('5TDKK3DC0FS647545',2015,'Toyota','Sienna','Minivan','White',171564,12750,0),('5TDYK3DCXFS578731',2015,'Toyota','Sienna','Minivan','White',23285,29919,0),('5TDZK3EH6CS073389',2012,'Toyota','Highlander','SUV','Gray',137520,12846,0),('5TFRX5GN9KX146117',2019,'Toyota','Tacoma','Pickup Truck','White',86593,22000,0),('5TFRY5F16GX209810',2016,'Toyota','Tundra','Pickup Truck','White',128437,22768,0),('5XXGR4A61EG343808',2014,'Kia','Optima','Sedan','White',51532,17898,0),('5XXGT4L32GG070465',2016,'Kia','Optima','Sedan','Gray',101269,11990,0),('5XXGT4L38LG397527',2020,'Kia','Optima','Sedan','Black',28696,20499,0),('5XYPG4A37GG120022',2016,'Kia','Sorento','SUV','White',98187,13013,0),('5YFBURHE4JP780979',2018,'Toyota','Corolla','Sedan','White',29106,20360,0),('5YFBURHEXEP023705',2014,'Toyota','Corolla','Sedan','White',144428,11222,0),('5YFEPRAE5LP089512',2020,'Toyota','Corolla','Sedan','White',46882,19499,0),('5YJ3E1EA2KF308118',2019,'Tesla','Model 3','Sedan','White',78218,36192,0),('5YJ3E1EA8JF009425',2018,'Tesla','Model 3','Sedan','Silver',31579,40199,0),('5YJ3E1EB0JF056098',2018,'Tesla','Model 3','Sedan','Red',36649,41699,0),('5YJSA1H14EFP61695',2014,'Tesla','Model S','Hatchback','Red',138555,24998,0),('JHMFC1F33KX006909',2019,'Honda','Civic','Sedan','White',18868,24299,0),('JN1AZ0CP5BT009543',2011,'Nissan','LEAF','Hatchback','Black',57066,7465,0),('JTDEPRAE8LJ099181',2020,'Toyota','Corolla','Sedan','Black',44373,18699,0),('JTDKARFU7H3544560',2017,'Toyota','Prius','Hatchback','Silver',84813,21229,0),('JTDKBRFU5J3581139',2018,'Toyota','Prius','Hatchback','Black',54000,23989,0),('JTDKN3DU1E0358109',2014,'Toyota','Prius','Sedan','Gray',153416,12257,0),('JTDKN3DU7F1913138',2015,'Toyota','Prius','Hatchback','Black',101897,16891,0),('JTDKN3DU8C1518008',2012,'Toyota','Prius','Sedan','White',83211,15120,0),('JTHBF30G530103343',2003,'Lexus','ES','Sedan','Silver',86314,8499,0),('JTHBJ46G782189424',2008,'Lexus','ES','Sedan','White',60532,11599,0),('JTJGK31U089852087',2008,'Lexus','RX','SUV','Black',221278,6804,0),('JTJZK1BA0A2402987',2010,'Lexus','RX','SUV','White',87471,14698,0),('JTMH1RFV0KD035186',2019,'Toyota','RAV4','SUV','White',13967,26499,0),('KMHE54L23GA029746',2016,'Hyundai','Sonata','Sedan','Black',93414,17000,0),('KNDJN2A25E7736934',2014,'Kia','Soul','Hatchback','Black',106074,9500,0),('KNDPM3AC9J7332802',2018,'Kia','Sportage','SUV','White',119022,12852,0),('KNMAT2MT6KP508432',2019,'Nissan','Rogue','SUV','Black',93498,16399,0),('WA1GFCFS7FR008229',2015,'Audi','Q3','SUV','Gray',110218,15408,0),('WAUACGFF7F1002554',2015,'Audi','A3','Sedan','Black',128790,10777,0),('WAUBFAFL2BA078062',2011,'Audi','A4','Sedan','White',101210,9998,0),('WBA4J1C56JBM11255',2018,'BMW','4 Series','Hatchback','White',69960,23999,0),('WBAFR7C53BC601658',2011,'BMW','5 Series','Sedan','Gray',118417,11430,0),('WBAJA9C5XKB254090',2019,'BMW','5 Series','Sedan','Black',40505,31497,1),('WBAPH5G51BNM79375',2011,'BMW','3 Series','Sedan','Black',120656,8531,0);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 16:44:22
