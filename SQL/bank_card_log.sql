-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
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
-- Table structure for table `card_log`
--

DROP TABLE IF EXISTS `card_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `operate` varchar(15) NOT NULL,
  `operatetime` varchar(40) NOT NULL,
  `cid` int DEFAULT NULL,
  `ctype` tinyint(1) DEFAULT '1',
  `cnumber` varchar(16) DEFAULT NULL,
  `cdate` varchar(4) DEFAULT NULL,
  `cccv` varchar(32) DEFAULT NULL,
  `cccv_salt` varchar(32) DEFAULT NULL,
  `cactive` tinyint(1) DEFAULT '0',
  `ccurrent` decimal(38,4) DEFAULT NULL,
  `climit` decimal(38,4) DEFAULT NULL,
  `cfailed` tinyint(1) DEFAULT '0',
  `cverify` varchar(6) DEFAULT NULL,
  `aid` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `cacitve` int DEFAULT NULL,
  `statuss` int DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_log`
--

LOCK TABLES `card_log` WRITE;
/*!40000 ALTER TABLE `card_log` DISABLE KEYS */;
INSERT INTO `card_log` VALUES (2,'','',1,1,'123123','2244','456','7897456',1,0.0000,0.0000,0,NULL,NULL,1,1,NULL,NULL),(3,'DELETE','2023-02-04 10:42:39(UTC+8)',1,1,'123123','2244','456','7897456',1,0.0000,0.0000,0,NULL,NULL,1,1,NULL,NULL);
/*!40000 ALTER TABLE `card_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-24 18:19:27
