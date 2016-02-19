CREATE TABLE `webstore`.`productorder` (
  `id` INT NOT NULL,
  `orderid` INT NOT NULL,
  `productorder` MEDIUMTEXT NOT NULL,
  `count` INT NOT NULL,
  `cost` VARCHAR(45) NOT NULL,
  `totalcost` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NULL,
  `userid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
