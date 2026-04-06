USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `users` 
VALUES 
('user','{bcrypt}$2a$10$9UHOarXjJgC8jNs3sa469uxWd7GW.cc0WRt7VSKpY1boC7LR3FI1e',1),
('manager','{bcrypt}$2a$10$9UHOarXjJgC8jNs3sa469uxWd7GW.cc0WRt7VSKpY1boC7LR3FI1e',1),
('admin','{bcrypt}$2a$10$9UHOarXjJgC8jNs3sa469uxWd7GW.cc0WRt7VSKpY1boC7LR3FI1e',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('user','ROLE_EMPLOYEE'),
('manager','ROLE_EMPLOYEE'),
('manager','ROLE_MANAGER'),
('admin','ROLE_EMPLOYEE'),
('admin','ROLE_MANAGER'),
('admin','ROLE_ADMIN');