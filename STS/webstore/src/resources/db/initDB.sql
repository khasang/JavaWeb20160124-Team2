DROP TABLE IF EXISTS `webstore`.`productorder`;
DROP TABLE IF EXISTS `webstore`.`users`;
DROP TABLE IF EXISTS `webstore`.`images`;
DROP TABLE IF EXISTS `webstore`.`products`;

CREATE TABLE `webstore`.`products` (
  `id` INT NOT NULL,
  `pname` MEDIUMTEXT NOT NULL,
  `productDescription` MEDIUMTEXT NULL,
  `cost` INT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `webstore`.`images`(
  `id` INT AUTO_INCREMENT,
  `alt` VARCHAR(250) NOT NULL DEFAULT "",
  `title` VARCHAR(250) NOT NULL DEFAULT "",
  `src` VARCHAR(250) NOT NULL DEFAULT "",
  `product_id` INT NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES products (`id`)
);

CREATE TABLE `webstore`.`productorder` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orderid` INT NOT NULL,
  `productorder` MEDIUMTEXT NOT NULL,
  `count` INT NOT NULL,
  `cost` VARCHAR(45) NOT NULL,
  `totalcost` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NULL,
  `userid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `webstore`.`users` (
  `id` INT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `security` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);
