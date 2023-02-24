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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `atype` tinyint(1) NOT NULL,
  `aaccount` varchar(20) NOT NULL,
  `abalance` decimal(38,4) NOT NULL,
  `aactive` tinyint(1) NOT NULL,
  `averify` varchar(6) DEFAULT NULL,
  `anickname` varchar(10) DEFAULT NULL,
  `uid` int NOT NULL,
  `statuss` int DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `UKk1hu995p90bet1khvnjrblb3g` (`aaccount`),
  UNIQUE KEY `UKs1eiwy12xvscxve1562fl7l9` (`aaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,1,'000000000019',878978878907.9999,1,NULL,'ctbc',1,NULL,NULL),(2,1,'000000000028',105.0000,1,NULL,'hnbc',1,NULL,NULL),(3,1,'000000000037',48.0000,1,NULL,NULL,1,NULL,NULL),(4,1,'000000000046',135.0000,1,NULL,NULL,1,NULL,NULL),(5,1,'000000000055',62.0000,1,NULL,NULL,1,NULL,NULL),(6,1,'000000000064',1108.0000,1,NULL,NULL,1,NULL,NULL),(7,1,'000000000073',80.0000,1,NULL,NULL,1,NULL,NULL),(8,1,'000000000082',9478.0000,1,NULL,NULL,1,NULL,NULL),(9,1,'000000000091',123.0001,1,NULL,NULL,1,NULL,NULL),(10,1,'000000000106',0.0000,1,NULL,NULL,1,NULL,NULL),(11,1,'000000000115',62.3512,1,NULL,'lol',1,NULL,NULL),(12,1,'000000000124',0.0000,1,NULL,NULL,1,NULL,NULL),(13,1,'000000000133',91.7887,1,NULL,NULL,1,NULL,NULL),(14,1,'000000000142',123.0000,1,NULL,'abc',1,NULL,NULL),(15,1,'000000000151',146289.0000,1,NULL,NULL,1,NULL,NULL),(16,1,'000000000160',431.0000,1,NULL,NULL,1,NULL,NULL),(17,1,'000000000179',213.5678,0,NULL,NULL,1,NULL,NULL),(18,1,'000000000188',10135.0000,1,NULL,'xyz',1,NULL,NULL),(19,1,'000000000197',763.1420,1,NULL,'richman',1,NULL,NULL),(39,1,'000000000202',0.0000,2,NULL,NULL,1,NULL,NULL),(40,1,'000000000211',0.0000,2,NULL,NULL,1,NULL,NULL),(41,1,'000000000220',0.0000,2,NULL,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `account_AFTER_INSERT` AFTER INSERT ON `account` FOR EACH ROW BEGIN
insert into account_log values(null,'INSERT',concat(now(),'(UTC+8)'),new.aid,new.atype,new.aaccount,new.abalance,new.aactive,new.averify,new.uid,new.statuss,new.message);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `account_BEFORE_UPDATE` BEFORE UPDATE ON `account` FOR EACH ROW BEGIN
insert into account_log values(null,'UPDATE(OLD)',concat(now(),'(UTC+8)'),old.aid,old.atype,old.aaccount,old.abalance,old.aactive,old.averify,old.uid,old.statuss,old.message);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `account_AFTER_UPDATE` AFTER UPDATE ON `account` FOR EACH ROW BEGIN
insert into account_log values(null,'UPDATE(NEW)',concat(now(),'(UTC+8)'),new.aid,new.atype,new.aaccount,new.abalance,new.aactive,new.averify,new.uid,new.statuss,new.message);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `account_BEFORE_DELETE` BEFORE DELETE ON `account` FOR EACH ROW BEGIN
insert into account_log values(null,'DELETE',concat(now(),'(UTC+8)'),old.aid,old.atype,old.aaccount,old.abalance,old.aactive,old.averify,old.uid,old.statuss,old.message);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-24 18:19:27
