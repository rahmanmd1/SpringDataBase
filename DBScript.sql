CREATE DATABASE  IF NOT EXISTS `springdatabase`;
USE `springdatabase`;

--
-- Table structure for table `continent`
--

DROP TABLE IF EXISTS `continent`;

CREATE TABLE `continent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `continent`
--



INSERT INTO `continent` VALUES (1,'Asia'),(2,'North America'),(3,'South America'),(4,'Asia'),(5,'Europe'),(6,'Africa'),(7,'Anterctica')


