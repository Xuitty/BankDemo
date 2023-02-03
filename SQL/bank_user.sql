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
  `message` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `lasttime` bigint NOT NULL DEFAULT '-1',
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uname_UNIQUE` (`uname`),
  UNIQUE KEY `UK33usp01rahy3w7nv0g62b3s8s` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ABCD','78b3454ceabced218481dece70862d68','ZkXi6H5pY3nyCLJ00KjWhyGRtGchQ5sK','123','ufokun@gmail.com','123','123',1,'1999-09-09','123123',1,0,NULL,NULL,NULL,NULL,NULL,1675396110005),(2,'wadaw','494fd4b7a970e05dd6ae514e6208772e','R5bBdXg1JxGIbj6YTplXMdVDJoV28uEA','dwadwadaw','ufokun@gmail.com','weaewa','eawewae',1,'1999-09-09','awewaea',0,0,NULL,NULL,'091437',NULL,NULL,-1),(3,'waeawe','9a4531e4022410bbd8aea71a883efb42','qLmfFeNysGAIk1PUKQPJjx3yB5YtYQgK','waewaeawe','ufokun@gmail.com','weewq','wqeqew',1,'1999-09-09','qweqwe',1,0,NULL,NULL,NULL,NULL,NULL,1675409035185),(4,'wadawd','6de5962580344004f1d2f5414730de89','S18B9VhrlzNQF6RqXqatauxzE5tyYoQC','wadaw','ufokun@gmail.com','weqwe','qweqwewq',1,'1999-09-09','eqweqwe',1,0,NULL,NULL,NULL,NULL,NULL,1675409674908),(5,'waewae','2efdaa8cee2ae3577746f8cb3910581f','D8ebLtvqJlTxwoDTEaAyD171tYLmhV0y','waeawe','ufokun@gmail.com','3213wqewq','wqewqe',1,'1999-09-09','ewqewqe',1,0,NULL,NULL,NULL,NULL,NULL,1675411801445),(6,'aweawe','50919eda222f8dd23f01dfde4f8e4f29','uFeiPLCRlcJDj5gk7Lm6famgVU0ZJ6lb','eaweawe','ufokun@gmail.com','213123wq','wqeqweqwe',1,'1999-09-09','wqeqwe',1,0,NULL,NULL,NULL,NULL,NULL,1675413343639),(7,'asdf','879a20bc217dfec1fa9b9d05a3f1dc4c','Y9NF67bT1ZSq9IBjAg9WWUYHL5bDewr3','wqeqw','ufokun@gmail.com','ewea','waeaw',1,'1999-09-09','eawea',1,0,NULL,NULL,NULL,NULL,NULL,1675417640323);
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

-- Dump completed on 2023-02-03 18:25:42
