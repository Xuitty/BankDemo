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
  `uid` int NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`aid`),
  UNIQUE KEY `UKk1hu995p90bet1khvnjrblb3g` (`aaccount`),
  UNIQUE KEY `UKs1eiwy12xvscxve1562fl7l9` (`aaccount`)
) ENGINE=InnoDB AUTO_INCREMENT=486 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (6,1,'000000000019',0.0000,0,1,NULL,NULL),(7,1,'000000000028',0.0000,0,1,NULL,NULL),(8,1,'000000000037',0.0000,0,1,NULL,NULL),(9,1,'000000000046',0.0000,0,1,NULL,NULL),(10,1,'000000000055',0.0000,0,1,NULL,NULL),(11,1,'000000000064',0.0000,0,1,NULL,NULL),(12,1,'000000000073',0.0000,0,1,NULL,NULL),(13,1,'000000000082',0.0000,0,1,NULL,NULL),(14,1,'000000000091',0.0000,0,1,NULL,NULL),(15,1,'000000000106',0.0000,0,1,NULL,NULL),(16,1,'000000000115',0.0000,0,1,NULL,NULL),(17,1,'000000000124',0.0000,0,1,NULL,NULL),(18,1,'000000000133',0.0000,0,1,NULL,NULL),(19,1,'000000000142',0.0000,0,1,NULL,NULL),(20,1,'000000000151',0.0000,0,1,NULL,NULL),(21,1,'000000000160',0.0000,0,1,NULL,NULL),(22,1,'000000000179',0.0000,0,1,NULL,NULL),(23,1,'000000000188',0.0000,0,1,NULL,NULL),(24,1,'000000000197',0.0000,0,1,NULL,NULL),(25,1,'000000000202',0.0000,0,1,NULL,NULL),(26,1,'000000000211',0.0000,0,1,NULL,NULL),(27,1,'000000000220',0.0000,0,1,NULL,NULL),(28,1,'000000000239',0.0000,0,1,NULL,NULL),(29,1,'000000000248',0.0000,0,1,NULL,NULL),(30,1,'000000000257',0.0000,0,1,NULL,NULL),(31,1,'000000000266',0.0000,0,1,NULL,NULL),(32,1,'000000000275',0.0000,0,1,NULL,NULL),(33,1,'000000000284',0.0000,0,1,NULL,NULL),(34,1,'000000000293',0.0000,0,1,NULL,NULL),(35,1,'000000000307',0.0000,0,1,NULL,NULL),(36,1,'000000000316',0.0000,0,1,NULL,NULL),(37,1,'000000000325',0.0000,0,1,NULL,NULL),(38,1,'000000000334',0.0000,0,1,NULL,NULL),(39,1,'000000000343',0.0000,0,1,NULL,NULL),(40,1,'000000000352',0.0000,0,1,NULL,NULL),(41,1,'000000000361',0.0000,0,1,NULL,NULL),(42,1,'000000000370',0.0000,0,1,NULL,NULL),(43,1,'000000000389',0.0000,0,1,NULL,NULL),(44,1,'000000000398',0.0000,0,1,NULL,NULL),(45,1,'000000000403',0.0000,0,1,NULL,NULL),(46,1,'000000000412',0.0000,0,1,NULL,NULL),(47,1,'000000000421',0.0000,0,1,NULL,NULL),(48,1,'000000000430',0.0000,0,1,NULL,NULL),(49,1,'000000000449',0.0000,0,1,NULL,NULL),(50,1,'000000000458',0.0000,0,1,NULL,NULL),(51,1,'000000000467',0.0000,0,1,NULL,NULL),(52,1,'000000000476',0.0000,0,1,NULL,NULL),(53,1,'000000000485',0.0000,0,1,NULL,NULL),(54,1,'000000000494',0.0000,0,1,NULL,NULL),(55,1,'000000000508',0.0000,0,1,NULL,NULL),(56,1,'000000000517',0.0000,0,1,NULL,NULL),(57,1,'000000000526',0.0000,0,1,NULL,NULL),(58,1,'000000000535',0.0000,0,1,NULL,NULL),(59,1,'000000000544',0.0000,0,1,NULL,NULL),(60,1,'000000000553',0.0000,0,1,NULL,NULL),(61,1,'000000000562',0.0000,0,1,NULL,NULL),(62,1,'000000000571',0.0000,0,1,NULL,NULL),(63,1,'000000000580',0.0000,0,1,NULL,NULL),(64,1,'000000000599',0.0000,0,1,NULL,NULL),(65,1,'000000000604',0.0000,0,1,NULL,NULL),(66,1,'000000000613',0.0000,0,1,NULL,NULL),(67,1,'000000000622',0.0000,0,1,NULL,NULL),(68,1,'000000000631',0.0000,0,1,NULL,NULL),(69,1,'000000000640',0.0000,0,1,NULL,NULL),(70,1,'000000000659',0.0000,0,1,NULL,NULL),(71,1,'000000000668',0.0000,0,1,NULL,NULL),(72,1,'000000000677',0.0000,0,1,NULL,NULL),(73,1,'000000000686',0.0000,0,1,NULL,NULL),(74,1,'000000000695',0.0000,0,1,NULL,NULL),(75,1,'000000000700',0.0000,0,1,NULL,NULL),(76,1,'000000000719',0.0000,0,1,NULL,NULL),(77,1,'000000000728',0.0000,0,1,NULL,NULL),(78,1,'000000000737',0.0000,0,1,NULL,NULL),(79,1,'000000000746',0.0000,0,1,NULL,NULL),(80,1,'000000000755',0.0000,0,1,NULL,NULL),(81,1,'000000000764',0.0000,0,1,NULL,NULL),(82,1,'000000000773',0.0000,0,1,NULL,NULL),(83,1,'000000000782',0.0000,0,1,NULL,NULL),(84,1,'000000000791',0.0000,0,1,NULL,NULL),(85,1,'000000000805',0.0000,0,1,NULL,NULL),(86,1,'000000000814',0.0000,0,1,NULL,NULL),(87,1,'000000000823',0.0000,0,1,NULL,NULL),(88,1,'000000000832',0.0000,0,1,NULL,NULL),(89,1,'000000000841',0.0000,0,1,NULL,NULL),(90,1,'000000000850',0.0000,0,1,NULL,NULL),(91,1,'000000000869',0.0000,0,1,NULL,NULL),(92,1,'000000000878',0.0000,0,1,NULL,NULL),(93,1,'000000000887',0.0000,0,1,NULL,NULL),(94,1,'000000000896',0.0000,0,1,NULL,NULL),(95,1,'000000000901',0.0000,0,1,NULL,NULL),(96,1,'000000000910',0.0000,0,1,NULL,NULL),(97,1,'000000000929',0.0000,0,1,NULL,NULL),(98,1,'000000000938',0.0000,0,1,NULL,NULL),(99,1,'000000000947',0.0000,0,1,NULL,NULL),(100,1,'000000000956',0.0000,0,1,NULL,NULL),(101,1,'000000000965',0.0000,0,1,NULL,NULL),(102,1,'000000000974',0.0000,0,1,NULL,NULL),(103,1,'000000000983',0.0000,0,1,NULL,NULL),(104,1,'000000000992',0.0000,0,1,NULL,NULL),(105,1,'000000001003',0.0000,0,1,NULL,NULL),(106,1,'000000001012',0.0000,0,1,NULL,NULL),(107,1,'000000001021',0.0000,0,1,NULL,NULL),(108,1,'000000001030',0.0000,0,1,NULL,NULL),(109,1,'000000001049',0.0000,0,1,NULL,NULL),(110,1,'000000001058',0.0000,0,1,NULL,NULL),(111,1,'000000001067',0.0000,0,1,NULL,NULL),(112,1,'000000001076',0.0000,0,1,NULL,NULL),(113,1,'000000001085',0.0000,0,1,NULL,NULL),(114,1,'000000001094',0.0000,0,1,NULL,NULL),(115,1,'000000001109',0.0000,0,1,NULL,NULL),(116,1,'000000001118',0.0000,0,1,NULL,NULL),(117,1,'000000001127',0.0000,0,1,NULL,NULL),(118,1,'000000001136',0.0000,0,1,NULL,NULL),(119,1,'000000001145',0.0000,0,1,NULL,NULL),(120,1,'000000001154',0.0000,0,1,NULL,NULL),(121,1,'000000001163',0.0000,0,1,NULL,NULL),(122,1,'000000001172',0.0000,0,1,NULL,NULL),(123,1,'000000001181',0.0000,0,1,NULL,NULL),(124,1,'000000001190',0.0000,0,1,NULL,NULL),(125,1,'000000001205',0.0000,0,1,NULL,NULL),(126,1,'000000001214',0.0000,0,1,NULL,NULL),(127,1,'000000001223',0.0000,0,1,NULL,NULL),(128,1,'000000001232',0.0000,0,1,NULL,NULL),(129,1,'000000001241',0.0000,0,1,NULL,NULL),(130,1,'000000001250',0.0000,0,1,NULL,NULL),(131,1,'000000001269',0.0000,0,1,NULL,NULL),(132,1,'000000001278',0.0000,0,1,NULL,NULL),(133,1,'000000001287',0.0000,0,1,NULL,NULL),(134,1,'000000001296',0.0000,0,1,NULL,NULL),(135,1,'000000001300',0.0000,0,1,NULL,NULL),(136,1,'000000001319',0.0000,0,1,NULL,NULL),(137,1,'000000001328',0.0000,0,1,NULL,NULL),(138,1,'000000001337',0.0000,0,1,NULL,NULL),(139,1,'000000001346',0.0000,0,1,NULL,NULL),(140,1,'000000001355',0.0000,0,1,NULL,NULL),(141,1,'000000001364',0.0000,0,1,NULL,NULL),(142,1,'000000001373',0.0000,0,1,NULL,NULL),(143,1,'000000001382',0.0000,0,1,NULL,NULL),(144,1,'000000001391',0.0000,0,1,NULL,NULL),(145,1,'000000001406',0.0000,0,1,NULL,NULL),(146,1,'000000001415',0.0000,0,1,NULL,NULL),(147,1,'000000001424',0.0000,0,1,NULL,NULL),(148,1,'000000001433',0.0000,0,1,NULL,NULL),(149,1,'000000001442',0.0000,0,1,NULL,NULL),(150,1,'000000001451',0.0000,0,1,NULL,NULL),(151,1,'000000001460',0.0000,0,1,NULL,NULL),(152,1,'000000001479',0.0000,0,1,NULL,NULL),(153,1,'000000001488',0.0000,0,1,NULL,NULL),(154,1,'000000001497',0.0000,0,1,NULL,NULL),(155,1,'000000001501',0.0000,0,1,NULL,NULL),(156,1,'000000001510',0.0000,0,1,NULL,NULL),(157,1,'000000001529',0.0000,0,1,NULL,NULL),(158,1,'000000001538',0.0000,0,1,NULL,NULL),(159,1,'000000001547',0.0000,0,1,NULL,NULL),(160,1,'000000001556',0.0000,0,1,NULL,NULL),(161,1,'000000001565',0.0000,0,1,NULL,NULL),(162,1,'000000001574',0.0000,0,1,NULL,NULL),(163,1,'000000001583',0.0000,0,1,NULL,NULL),(164,1,'000000001592',0.0000,0,1,NULL,NULL),(165,1,'000000001607',0.0000,0,1,NULL,NULL),(166,1,'000000001616',0.0000,0,1,NULL,NULL),(167,1,'000000001625',0.0000,0,1,NULL,NULL),(168,1,'000000001634',0.0000,0,1,NULL,NULL),(169,1,'000000001643',0.0000,0,1,NULL,NULL),(170,1,'000000001652',0.0000,0,1,NULL,NULL),(171,1,'000000001661',0.0000,0,1,NULL,NULL),(172,1,'000000001670',0.0000,0,1,NULL,NULL),(173,1,'000000001689',0.0000,0,1,NULL,NULL),(174,1,'000000001698',0.0000,0,1,NULL,NULL),(175,1,'000000001703',0.0000,0,1,NULL,NULL),(176,1,'000000001712',0.0000,0,1,NULL,NULL),(177,1,'000000001721',0.0000,0,1,NULL,NULL),(178,1,'000000001730',0.0000,0,1,NULL,NULL),(179,1,'000000001749',0.0000,0,1,NULL,NULL),(180,1,'000000001758',0.0000,0,1,NULL,NULL),(181,1,'000000001767',0.0000,0,1,NULL,NULL),(182,1,'000000001776',0.0000,0,1,NULL,NULL),(183,1,'000000001785',0.0000,0,1,NULL,NULL),(184,1,'000000001794',0.0000,0,1,NULL,NULL),(185,1,'000000001808',0.0000,0,1,NULL,NULL),(186,1,'000000001817',0.0000,0,1,NULL,NULL),(187,1,'000000001826',0.0000,0,1,NULL,NULL),(188,1,'000000001835',0.0000,0,1,NULL,NULL),(189,1,'000000001844',0.0000,0,1,NULL,NULL),(190,1,'000000001853',0.0000,0,1,NULL,NULL),(191,1,'000000001862',0.0000,0,1,NULL,NULL),(192,1,'000000001871',0.0000,0,1,NULL,NULL),(193,1,'000000001880',0.0000,0,1,NULL,NULL),(194,1,'000000001899',0.0000,0,1,NULL,NULL),(195,1,'000000001904',0.0000,0,1,NULL,NULL),(196,1,'000000001913',0.0000,0,1,NULL,NULL),(197,1,'000000001922',0.0000,0,1,NULL,NULL),(198,1,'000000001931',0.0000,0,1,NULL,NULL),(199,1,'000000001940',0.0000,0,1,NULL,NULL),(200,1,'000000001959',0.0000,0,1,NULL,NULL),(201,1,'000000001968',0.0000,0,1,NULL,NULL),(202,1,'000000001977',0.0000,0,1,NULL,NULL),(203,1,'000000001986',0.0000,0,1,NULL,NULL),(204,1,'000000001995',0.0000,0,1,NULL,NULL),(205,1,'000000002005',0.0000,0,1,NULL,NULL),(206,1,'000000002014',0.0000,0,1,NULL,NULL),(207,1,'000000002023',0.0000,0,1,NULL,NULL),(208,1,'000000002032',0.0000,0,1,NULL,NULL),(209,1,'000000002041',0.0000,0,1,NULL,NULL),(210,1,'000000002050',0.0000,0,1,NULL,NULL),(211,1,'000000002069',0.0000,0,1,NULL,NULL),(212,1,'000000002078',0.0000,0,1,NULL,NULL),(213,1,'000000002087',0.0000,0,1,NULL,NULL),(214,1,'000000002096',0.0000,0,1,NULL,NULL),(215,1,'000000002101',0.0000,0,1,NULL,NULL),(216,1,'000000002110',0.0000,0,1,NULL,NULL),(217,1,'000000002129',0.0000,0,1,NULL,NULL),(218,1,'000000002138',0.0000,0,1,NULL,NULL),(219,1,'000000002147',0.0000,0,1,NULL,NULL),(220,1,'000000002156',0.0000,0,1,NULL,NULL),(221,1,'000000002165',0.0000,0,1,NULL,NULL),(222,1,'000000002174',0.0000,0,1,NULL,NULL),(223,1,'000000002183',0.0000,0,1,NULL,NULL),(224,1,'000000002192',0.0000,0,1,NULL,NULL),(225,1,'000000002207',0.0000,0,1,NULL,NULL),(226,1,'000000002216',0.0000,0,1,NULL,NULL),(228,1,'000000002225',0.0000,0,1,NULL,NULL),(229,1,'000000002234',0.0000,0,1,NULL,NULL),(230,1,'000000002243',0.0000,0,1,NULL,NULL),(231,1,'000000002252',0.0000,0,1,NULL,NULL),(232,1,'000000002261',0.0000,0,1,NULL,NULL),(233,1,'000000002270',0.0000,0,1,NULL,NULL),(234,1,'000000002289',0.0000,0,1,NULL,NULL),(235,1,'000000002298',0.0000,0,1,NULL,NULL),(236,1,'000000002302',0.0000,0,1,NULL,NULL),(237,1,'000000002311',0.0000,0,1,NULL,NULL),(238,1,'000000002320',0.0000,0,1,NULL,NULL),(239,1,'000000002339',0.0000,0,1,NULL,NULL),(240,1,'000000002348',0.0000,0,1,NULL,NULL),(242,1,'000000002357',0.0000,0,1,NULL,NULL),(243,1,'000000002366',0.0000,0,1,NULL,NULL),(244,1,'000000002375',0.0000,0,1,NULL,NULL),(245,1,'000000002384',0.0000,0,1,NULL,NULL),(246,1,'000000002393',0.0000,0,1,NULL,NULL),(247,1,'000000002408',0.0000,0,1,NULL,NULL),(248,1,'000000002417',0.0000,0,1,NULL,NULL),(249,1,'000000002426',0.0000,0,1,NULL,NULL),(250,1,'000000002435',0.0000,0,1,NULL,NULL),(251,1,'000000002444',0.0000,0,1,NULL,NULL),(252,1,'000000002453',0.0000,0,1,NULL,NULL),(253,1,'000000002462',0.0000,0,1,NULL,NULL),(254,1,'000000002471',0.0000,0,1,NULL,NULL),(255,1,'000000002480',0.0000,0,1,NULL,NULL),(256,1,'000000002499',0.0000,0,1,NULL,NULL),(257,1,'000000002503',0.0000,0,1,NULL,NULL),(258,1,'000000002512',0.0000,0,1,NULL,NULL),(259,1,'000000002521',0.0000,0,1,NULL,NULL),(260,1,'000000002530',0.0000,0,1,NULL,NULL),(261,1,'000000002549',0.0000,0,1,NULL,NULL),(262,1,'000000002558',0.0000,0,1,NULL,NULL),(263,1,'000000002567',0.0000,0,1,NULL,NULL),(264,1,'000000002576',0.0000,0,1,NULL,NULL),(265,1,'000000002585',0.0000,0,1,NULL,NULL),(266,1,'000000002594',0.0000,0,1,NULL,NULL),(267,1,'000000002609',0.0000,0,1,NULL,NULL),(268,1,'000000002618',0.0000,0,1,NULL,NULL),(269,1,'000000002627',0.0000,0,1,NULL,NULL),(270,1,'000000002636',0.0000,0,1,NULL,NULL),(271,1,'000000002645',0.0000,0,1,NULL,NULL),(272,1,'000000002654',0.0000,0,1,NULL,NULL),(273,1,'000000002663',0.0000,0,1,NULL,NULL),(274,1,'000000002672',0.0000,0,1,NULL,NULL),(275,1,'000000002681',0.0000,0,1,NULL,NULL),(276,1,'000000002690',0.0000,0,1,NULL,NULL),(277,1,'000000002705',0.0000,0,1,NULL,NULL),(278,1,'000000002714',0.0000,0,1,NULL,NULL),(279,1,'000000002723',0.0000,0,1,NULL,NULL),(280,1,'000000002732',0.0000,0,1,NULL,NULL),(281,1,'000000002741',0.0000,0,1,NULL,NULL),(282,1,'000000002750',0.0000,0,1,NULL,NULL),(283,1,'000000002769',0.0000,0,1,NULL,NULL),(284,1,'000000002778',0.0000,0,1,NULL,NULL),(285,1,'000000002787',0.0000,0,1,NULL,NULL),(286,1,'000000002796',0.0000,0,1,NULL,NULL),(288,1,'000000002800',0.0000,0,1,NULL,NULL),(289,1,'000000002819',0.0000,0,1,NULL,NULL),(290,1,'000000002828',0.0000,0,1,NULL,NULL),(291,1,'000000002837',0.0000,0,1,NULL,NULL),(292,1,'000000002846',0.0000,0,1,NULL,NULL),(293,1,'000000002855',0.0000,0,1,NULL,NULL),(294,1,'000000002864',0.0000,0,1,NULL,NULL),(295,1,'000000002873',0.0000,0,1,NULL,NULL),(296,1,'000000002882',0.0000,0,1,NULL,NULL),(297,1,'000000002891',0.0000,0,1,NULL,NULL),(298,1,'000000002906',0.0000,0,1,NULL,NULL),(299,1,'000000002915',0.0000,0,1,NULL,NULL),(300,1,'000000002924',0.0000,0,1,NULL,NULL),(301,1,'000000002933',0.0000,0,1,NULL,NULL),(302,1,'000000002942',0.0000,0,1,NULL,NULL),(303,1,'000000002951',0.0000,0,1,NULL,NULL),(304,1,'000000002960',0.0000,0,1,NULL,NULL),(305,1,'000000002979',0.0000,0,1,NULL,NULL),(306,1,'000000002988',0.0000,0,1,NULL,NULL),(307,1,'000000002997',0.0000,0,1,NULL,NULL),(308,1,'000000003007',0.0000,0,1,NULL,NULL),(309,1,'000000003016',0.0000,0,1,NULL,NULL),(310,1,'000000003025',0.0000,0,1,NULL,NULL),(311,1,'000000003034',0.0000,0,1,NULL,NULL),(312,1,'000000003043',0.0000,0,1,NULL,NULL),(313,1,'000000003052',0.0000,0,1,NULL,NULL),(314,1,'000000003061',0.0000,0,1,NULL,NULL),(315,1,'000000003070',0.0000,0,1,NULL,NULL),(316,1,'000000003089',0.0000,0,1,NULL,NULL),(317,1,'000000003098',0.0000,0,1,NULL,NULL),(318,1,'000000003103',0.0000,0,1,NULL,NULL),(319,1,'000000003112',0.0000,0,1,NULL,NULL),(320,1,'000000003121',0.0000,0,1,NULL,NULL),(321,1,'000000003130',0.0000,0,1,NULL,NULL),(322,1,'000000003149',0.0000,0,1,NULL,NULL),(323,1,'000000003158',0.0000,0,1,NULL,NULL),(324,1,'000000003167',0.0000,0,1,NULL,NULL),(325,1,'000000003176',0.0000,0,1,NULL,NULL),(326,1,'000000003185',0.0000,0,1,NULL,NULL),(327,1,'000000003194',0.0000,0,1,NULL,NULL),(328,1,'000000003209',0.0000,0,1,NULL,NULL),(329,1,'000000003218',0.0000,0,1,NULL,NULL),(330,1,'000000003227',0.0000,0,1,NULL,NULL),(331,1,'000000003236',0.0000,0,1,NULL,NULL),(332,1,'000000003245',0.0000,0,1,NULL,NULL),(333,1,'000000003254',0.0000,0,1,NULL,NULL),(334,1,'000000003263',0.0000,0,1,NULL,NULL),(335,1,'000000003272',0.0000,0,1,NULL,NULL),(336,1,'000000003281',0.0000,0,1,NULL,NULL),(337,1,'000000003290',0.0000,0,1,NULL,NULL),(338,1,'000000003304',0.0000,0,1,NULL,NULL),(339,1,'000000003313',0.0000,0,1,NULL,NULL),(340,1,'000000003322',0.0000,0,1,NULL,NULL),(341,1,'000000003331',0.0000,0,1,NULL,NULL),(342,1,'000000003340',0.0000,0,1,NULL,NULL),(343,1,'000000003359',0.0000,0,1,NULL,NULL),(344,1,'000000003368',0.0000,0,1,NULL,NULL),(345,1,'000000003377',0.0000,0,1,NULL,NULL),(346,1,'000000003386',0.0000,0,1,NULL,NULL),(347,1,'000000003395',0.0000,0,1,NULL,NULL),(348,1,'000000003400',0.0000,0,1,NULL,NULL),(349,1,'000000003419',0.0000,0,1,NULL,NULL),(350,1,'000000003428',0.0000,0,1,NULL,NULL),(351,1,'000000003437',0.0000,0,1,NULL,NULL),(352,1,'000000003446',0.0000,0,1,NULL,NULL),(353,1,'000000003455',0.0000,0,1,NULL,NULL),(354,1,'000000003464',0.0000,0,1,NULL,NULL),(355,1,'000000003473',0.0000,0,1,NULL,NULL),(356,1,'000000003482',0.0000,0,1,NULL,NULL),(357,1,'000000003491',0.0000,0,1,NULL,NULL),(358,1,'000000003505',0.0000,0,1,NULL,NULL),(359,1,'000000003514',0.0000,0,1,NULL,NULL),(360,1,'000000003523',0.0000,0,1,NULL,NULL),(361,1,'000000003532',0.0000,0,1,NULL,NULL),(362,1,'000000003541',0.0000,0,1,NULL,NULL),(363,1,'000000003550',0.0000,0,1,NULL,NULL),(364,1,'000000003569',0.0000,0,1,NULL,NULL),(365,1,'000000003578',0.0000,0,1,NULL,NULL),(366,1,'000000003587',0.0000,0,1,NULL,NULL),(367,1,'000000003596',0.0000,0,1,NULL,NULL),(368,1,'000000003601',0.0000,0,1,NULL,NULL),(369,1,'000000003610',0.0000,0,1,NULL,NULL),(370,1,'000000003629',0.0000,0,1,NULL,NULL),(371,1,'000000003638',0.0000,0,1,NULL,NULL),(372,1,'000000003647',0.0000,0,1,NULL,NULL),(373,1,'000000003656',0.0000,0,1,NULL,NULL),(374,1,'000000003665',0.0000,0,1,NULL,NULL),(375,1,'000000003674',0.0000,0,1,NULL,NULL),(376,1,'000000003683',0.0000,0,1,NULL,NULL),(377,1,'000000003692',0.0000,0,1,NULL,NULL),(378,1,'000000003707',0.0000,0,1,NULL,NULL),(379,1,'000000003716',0.0000,0,1,NULL,NULL),(380,1,'000000003725',0.0000,0,1,NULL,NULL),(381,1,'000000003734',0.0000,0,1,NULL,NULL),(382,1,'000000003743',0.0000,0,1,NULL,NULL),(383,1,'000000003752',0.0000,0,1,NULL,NULL),(384,1,'000000003761',0.0000,0,1,NULL,NULL),(385,1,'000000003770',0.0000,0,1,NULL,NULL),(386,1,'000000003789',0.0000,0,1,NULL,NULL),(387,1,'000000003798',0.0000,0,1,NULL,NULL),(388,1,'000000003802',0.0000,0,1,NULL,NULL),(389,1,'000000003811',0.0000,0,1,NULL,NULL),(390,1,'000000003820',0.0000,0,1,NULL,NULL),(391,1,'000000003839',0.0000,0,1,NULL,NULL),(392,1,'000000003848',0.0000,0,1,NULL,NULL),(393,1,'000000003857',0.0000,0,1,NULL,NULL),(394,1,'000000003866',0.0000,0,1,NULL,NULL),(395,1,'000000003875',0.0000,0,1,NULL,NULL),(396,1,'000000003884',0.0000,0,1,NULL,NULL),(397,1,'000000003893',0.0000,0,1,NULL,NULL),(398,1,'000000003908',0.0000,0,1,NULL,NULL),(399,1,'000000003917',0.0000,0,1,NULL,NULL),(400,1,'000000003926',0.0000,0,1,NULL,NULL),(401,1,'000000003935',0.0000,0,1,NULL,NULL),(402,1,'000000003944',0.0000,0,1,NULL,NULL),(403,1,'000000003953',0.0000,0,1,NULL,NULL),(404,1,'000000003962',0.0000,0,1,NULL,NULL),(405,1,'000000003971',0.0000,0,1,NULL,NULL),(406,1,'000000003980',0.0000,0,1,NULL,NULL),(407,1,'000000003999',0.0000,0,1,NULL,NULL),(408,1,'000000004000',0.0000,0,1,NULL,NULL),(409,1,'000000004019',0.0000,0,1,NULL,NULL),(410,1,'000000004028',0.0000,0,1,NULL,NULL),(411,1,'000000004037',0.0000,0,1,NULL,NULL),(412,1,'000000004046',0.0000,0,1,NULL,NULL),(413,1,'000000004055',0.0000,0,1,NULL,NULL),(414,1,'000000004064',0.0000,0,1,NULL,NULL),(415,1,'000000004073',0.0000,0,1,NULL,NULL),(416,1,'000000004082',0.0000,0,1,NULL,NULL),(417,1,'000000004091',0.0000,0,1,NULL,NULL),(418,1,'000000004106',0.0000,0,1,NULL,NULL),(419,1,'000000004115',0.0000,0,1,NULL,NULL),(420,1,'000000004124',0.0000,0,1,NULL,NULL),(421,1,'000000004133',0.0000,0,1,NULL,NULL),(422,1,'000000004142',0.0000,0,1,NULL,NULL),(423,1,'000000004151',0.0000,0,1,NULL,NULL),(424,1,'000000004160',0.0000,0,1,NULL,NULL),(425,1,'000000004179',0.0000,0,1,NULL,NULL),(426,1,'000000004188',0.0000,0,1,NULL,NULL),(427,1,'000000004197',0.0000,0,1,NULL,NULL),(428,1,'000000004202',0.0000,0,1,NULL,NULL),(429,1,'000000004211',0.0000,0,1,NULL,NULL),(430,1,'000000004220',0.0000,0,1,NULL,NULL),(431,1,'000000004239',0.0000,0,1,NULL,NULL),(432,1,'000000004248',0.0000,0,1,NULL,NULL),(433,1,'000000004257',0.0000,0,1,NULL,NULL),(434,1,'000000004266',0.0000,0,1,NULL,NULL),(435,1,'000000004275',0.0000,0,1,NULL,NULL),(436,1,'000000004284',0.0000,0,1,NULL,NULL),(437,1,'000000004293',0.0000,0,1,NULL,NULL),(438,1,'000000004307',0.0000,0,1,NULL,NULL),(439,1,'000000004316',0.0000,0,1,NULL,NULL),(440,1,'000000004325',0.0000,0,1,NULL,NULL),(441,1,'000000004334',0.0000,0,1,NULL,NULL),(442,1,'000000004343',0.0000,0,1,NULL,NULL),(443,1,'000000004352',0.0000,0,1,NULL,NULL),(444,1,'000000004361',0.0000,0,1,NULL,NULL),(446,1,'000000004370',0.0000,0,1,NULL,NULL),(447,1,'000000004389',0.0000,0,1,NULL,NULL),(448,1,'000000004398',0.0000,0,1,NULL,NULL),(449,1,'000000004403',0.0000,0,1,NULL,NULL),(450,1,'000000004412',0.0000,0,1,NULL,NULL),(451,1,'000000004421',0.0000,0,1,NULL,NULL),(452,1,'000000004430',0.0000,0,1,NULL,NULL),(453,1,'000000004449',0.0000,0,1,NULL,NULL),(454,1,'000000004458',0.0000,0,1,NULL,NULL),(455,1,'000000004467',0.0000,0,1,NULL,NULL),(456,1,'000000004476',0.0000,0,1,NULL,NULL),(457,1,'000000004485',0.0000,0,1,NULL,NULL),(458,1,'000000004494',0.0000,0,1,NULL,NULL),(459,1,'000000004508',0.0000,0,1,NULL,NULL),(460,1,'000000004517',0.0000,0,1,NULL,NULL),(461,1,'000000004526',0.0000,0,1,NULL,NULL),(462,1,'000000004535',0.0000,0,1,NULL,NULL),(463,1,'000000004544',0.0000,0,1,NULL,NULL),(464,1,'000000004553',0.0000,0,1,NULL,NULL),(465,1,'000000004562',0.0000,0,1,NULL,NULL),(466,1,'000000004571',0.0000,0,1,NULL,NULL),(467,1,'000000004580',0.0000,0,1,NULL,NULL),(468,1,'000000004599',0.0000,0,1,NULL,NULL),(469,1,'000000004604',0.0000,0,1,NULL,NULL),(470,1,'000000004613',0.0000,0,1,NULL,NULL),(471,1,'000000004622',0.0000,0,1,NULL,NULL),(472,1,'000000004631',0.0000,0,1,NULL,NULL),(473,1,'000000004640',0.0000,0,1,NULL,NULL),(474,1,'000000004659',0.0000,0,1,NULL,NULL),(476,1,'000000004668',0.0000,0,1,NULL,NULL),(477,1,'000000004677',0.0000,0,1,NULL,NULL),(478,1,'000000004686',0.0000,0,1,NULL,NULL),(479,1,'000000004695',0.0000,0,1,NULL,NULL),(480,1,'000000004700',0.0000,0,1,NULL,NULL),(481,1,'000000004719',0.0000,0,1,NULL,NULL),(482,1,'000000004728',0.0000,0,1,NULL,NULL),(483,1,'000000004737',0.0000,0,1,NULL,NULL),(484,1,'000000004746',0.0000,0,1,NULL,NULL),(485,1,'000000004755',0.0000,0,1,NULL,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
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
