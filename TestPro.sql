-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: testpro
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `kid` varchar(45) DEFAULT NULL,
  `parent` varchar(45) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `verification` varchar(45) DEFAULT NULL,
  `expireDate` datetime DEFAULT NULL,
  `issueCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Aabbee','Alpha','Alpha@yahoo.com','0','6132295fcf5570fb8b0a944ef322a598','2017-08-05 00:58:46',0),(2,'Aabriella','Beta','Beta@yahoo.com','0','0b87d66b88c72957dfea8c9605016442',NULL,0),(3,'Aahana','Gamma','Gamma@hotmail.com','1','d9cdb0f6e0d556347c10a8695545a4b5','2017-08-05 01:15:59',1),(4,'Aahliyah','Delta','Delta@hotmail.com','0','db1f4ab5845def61a83d5df13e0c2397','2017-07-29 00:47:11',0),(5,'Aahna','Delta','Delta@hotmail.com','0','db1f4ab5845def61a83d5df13e0c2397','2017-07-29 00:47:11',0),(6,'Aailiyah','Alpha','Alpha@yahoo.com','0','6132295fcf5570fb8b0a944ef322a598','2017-08-05 00:58:46',0),(7,'Aaleah','Delta','Delta@hotmail.com','0','db1f4ab5845def61a83d5df13e0c2397','2017-07-29 00:47:11',0),(8,'Aalexi','Beta','Beta@yahoo.com','0','0b87d66b88c72957dfea8c9605016442',NULL,0);
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

-- Dump completed on 2017-07-29  2:28:45
