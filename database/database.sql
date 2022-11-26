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
INSERT INTO `account` VALUES ('amiquelet7@bloglovin.com','Alexandrina','Miquelet','225-670-1525','0o6I3MJ'),('bpengelleya@mlb.com','Bianca','Pengelley','651-839-6997','iDkPFZX'),('bringe4@naver.com','Briney','Ringe','731-844-3027','3YgQYcyKU'),('gbaser9@sciencedirect.com','Giustino','Baser','551-498-8776','QS2xBhFaJ8Dn'),('gschimonek8@sfgate.com','Gerek','Schimonek','531-230-9716','TXXFD0cv6'),('hzoellner0@nhs.uk','Honoria','Zoellner','324-838-5523','PiDam5Jd'),('igodfery6@fema.gov','Isa','Godfery','455-319-2622','6eaF2BPg76l9'),('ljimmesb@geocities.jp','Latrena','Jimmes','988-302-8866','wMuHiBIKIo1'),('lmccoveney5@ibm.com','Lydon','McCoveney','531-497-0113','WXSJcNaOOs'),('mdewerkd@soundcloud.com','Millicent','de Werk','912-199-3055','P8Ih9oXx'),('sclurowc@google.it','Sybille','Clurow','728-591-8087','zkzTn0pICk'),('vcluitt3@unc.edu','Valle','Cluitt','507-808-2690','cjnnRc'),('wgammett1@eepurl.com','Willem','Gammett','221-124-5271','QvrIEVezzd8Q'),('wkayese@pinterest.com','Wheeler','Kayes','224-827-4461','Jq29nvSOIX'),('wosharkey2@ucsd.edu','Webb','O\'Sharkey','401-940-8713','h1b57dytIZi7');
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
INSERT INTO `appointment` VALUES ('hzoellner0@nhs.uk','JN1AZ4EH3CM440956','2000-09-04 12:00:00');
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
  `sale_id` int NOT NULL,
  `percentage` int DEFAULT NULL,
  PRIMARY KEY (`employee_email`,`sale_id`),
  KEY `saleid_idx` (`sale_id`),
  CONSTRAINT `email3` FOREIGN KEY (`employee_email`) REFERENCES `employee` (`employee_email`),
  CONSTRAINT `saleid` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commission`
--

LOCK TABLES `commission` WRITE;
/*!40000 ALTER TABLE `commission` DISABLE KEYS */;
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
INSERT INTO `customer` VALUES ('amiquelet7@bloglovin.com','4003 Horner Street'),('hzoellner0@nhs.uk','2703 Arbor Court'),('lmccoveney5@ibm.com','95 West Virginia Avenue');
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
INSERT INTO `employee` VALUES ('hzoellner0@nhs.uk','role2'),('lmccoveney5@ibm.com','role2'),('vcluitt3@unc.edu','role1'),('wkayese@pinterest.com','role1');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `sale_id` int NOT NULL,
  `agreed_price` float DEFAULT NULL,
  `tax` float DEFAULT NULL,
  `card_num` varchar(45) DEFAULT NULL,
  `vin` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `vin_idx` (`vin`),
  CONSTRAINT `vin2` FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,666,6,'58585',NULL);
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
  `make` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `condition` varchar(45) DEFAULT NULL,
  `mileage` int DEFAULT NULL,
  `listing_price` int DEFAULT NULL,
  `sold` tinyint DEFAULT NULL,
  PRIMARY KEY (`vin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('1C3CCBABXCN987184','Audi',2002,'A4','used',121032,20613,0),('1C4RDHEG8EC068407','Audi',2007,'RS 4','used',208654,49951,0),('1C6RD7GP5CS629292','Jaguar',1992,'XJ Series','new',56034,38681,0),('1G6AE5SX9D0240878','Volvo',1997,'960','new',87593,13090,0),('1G6AY5SX4E0097069','Pontiac',2004,'GTO','new',185934,49389,0),('1G6DA1ED1B0844523','Nissan',2007,'Altima','used',93023,47584,0),('3D7TP2CT7BG253573','Mitsubishi',1985,'Starion','new',302293,19826,0),('3GTXKYEJ0AG530152','GMC',1994,'3500','used',69503,41155,0),('3VW1K7AJ6CM378711','Volkswagen',2009,'Jetta','used',50393,39858,0),('asdasdeqwec','ABC',8888,'XYZ','new',123456,84621,0),('JN1AZ4EH3CM440956','Mazda',1986,'RX-7','used',50394,45439,0),('WAUDF58E85A177360','Saturn',2010,'Outlook','used',23240,17132,0),('WAUEF78E17A862576','Ford',1986,'Aerostar','used',149384,11730,0),('WAUFFBFL6BA466936','BMW',2007,'M5','new',194534,22003,0),('WAUJT54B23N389667','Oldsmobile',2000,'Bravada','used',90434,34028,0),('WAUNF98P46A768655','Lamborghini',2001,'Diablo','used',129503,12690,0),('WBA1J9C56FV948604','Mitsubishi',2002,'Galant','used',80934,32598,0),('WBAAV33451F570190','Ford',2008,'Ranger','new',50754,23485,0),('WP0CA2A87AS916044','Chevrolet',1994,'Impala SS','used',230593,12944,0);
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

-- Dump completed on 2022-11-25 17:18:39
