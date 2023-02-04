-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) NOT NULL,
  `upassword` varchar(32) NOT NULL,
  `upassword_salt` varchar(32) NOT NULL,
  `urealname` varchar(50) NOT NULL,
  `uemail` varchar(60) NOT NULL,
  `utelephone` varchar(50) NOT NULL,
  `uaddress` varchar(100) NOT NULL,
  `usex` tinyint(1) NOT NULL,
  `udate` date NOT NULL,
  `uidentity` varchar(10) NOT NULL,
  `uactive` tinyint(1) NOT NULL DEFAULT '0',
  `ulevel` tinyint(1) NOT NULL DEFAULT '0',
  `ucookie` varchar(32) DEFAULT NULL,
  `ucookie_salt` varchar(32) DEFAULT NULL,
  `uverify` varchar(6) DEFAULT NULL,
  `statuss` int DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `lasttime` bigint NOT NULL DEFAULT '-1',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uname_UNIQUE` (`uname`),
  UNIQUE KEY `UK33usp01rahy3w7nv0g62b3s8s` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ABCD','85735e7d2283b9123862cabda06cbce8','FHTQcDDeJRldt1TEw2u4JYaeu6CLk6Tv','123456','ufokun@gmail.com','123456789','erwerew',1,'1999-09-09','qweqwe',1,0,'d1270dac8ee2a099b82174ff78d4baa6','PuX0O744gkwZlKoDcgmZ1LprLYmUFmTw',NULL,NULL,NULL,1675506602885);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-04 18:22:58
