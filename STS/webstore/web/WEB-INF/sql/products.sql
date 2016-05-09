CREATE TABLE `webstore`.`products` (
  `id` INT NOT NULL,
  `pname` MEDIUMTEXT NOT NULL,
  `product` MEDIUMTEXT NULL,
  `productorder` LONGTEXT NOT NULL,
  `cost` INT NULL,
  PRIMARY KEY (`id`));