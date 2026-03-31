CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Farshad','Hasanvand','delochi@gmail.com'),
	(2,'Ali','Farshidi','alifrash@gmail.com'),
	(3,'Mo','Alol','alol@gmail.com'),
	(4,'Mohsen','Asgar','grandpa@gmail.com'),
	(5,'Reza','Kiampour','kian@gmail.com');

