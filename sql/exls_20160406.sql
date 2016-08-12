-- MySQL dump 10.13  Distrib 5.6.25, for osx10.10 (x86_64)
--
-- Host: localhost    Database: exls
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Table structure for table `lxm_website`
--

DROP TABLE IF EXISTS `lxm_website`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lxm_website` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ico` varchar(255) DEFAULT NULL,
  `seq_no` int(11) DEFAULT NULL,
  `key` char(1) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `create_time` bigint(13) DEFAULT NULL,
  `editable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lxm_website`
--

LOCK TABLES `lxm_website` WRITE;
/*!40000 ALTER TABLE `lxm_website` DISABLE KEYS */;
INSERT INTO `lxm_website` VALUES (1,'https://www.taobao.com','淘宝','http://www.taobao.com/favicon.ico',1,'','剁手',NULL,0),(2,'http://www.tmall.com','天猫','http://www.tmall.com/favicon.ico',2,NULL,'剁手',NULL,0),(3,'http://www.jd.com','京东','http://www.jd.com/favicon.ico',3,NULL,'剁手',NULL,0),(4,'http://www.letv.com','乐视','http://www.letv.com/favicon.ico',1,NULL,'视频',NULL,0),(5,'http://www.iqiyi.com','爱奇艺','http://www.iqiyi.com/favicon.ico',2,NULL,'视频',NULL,0),(6,'http://www.youku.com','优酷','http://www.youku.com/favicon.ico',3,NULL,'视频',NULL,0),(7,'http://www.srrsh.com/html/main/gb2312/','邵逸夫医院',NULL,1,NULL,'工作',NULL,0),(8,'http://www.hzyhwy.cn/index/index.jhtml','余杭五院',NULL,2,NULL,'工作',NULL,0),(9,'http://115.236.23.137:8070/','医学考试系统',NULL,3,NULL,'工作',NULL,0),(10,'dym.html','大姨妈登记',NULL,NULL,NULL,'嘿嘿',1459856416235,1),(11,'http://www.yingshidaquan.cc','影视大全',NULL,4,NULL,'视频',NULL,0),(12,'http://www.tudou.com','土豆','http://www.tudou.com/favicon.ico',NULL,NULL,'视频',1459860198041,0);
/*!40000 ALTER TABLE `lxm_website` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-06 22:09:54
