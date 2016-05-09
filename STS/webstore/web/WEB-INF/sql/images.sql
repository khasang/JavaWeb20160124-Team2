DROP TABLE IF EXISTS `webstore`.images;

CREATE TABLE `webstore`.`images`(
  `id` INT AUTO_INCREMENT,
  `alt` VARCHAR(250) NOT NULL DEFAULT "",
  `title` VARCHAR(250) NOT NULL DEFAULT "",
  `src` VARCHAR(250) NOT NULL DEFAULT "",
  `product_id` INT NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY(`product_id`) REFERENCES products (`id`)
);

