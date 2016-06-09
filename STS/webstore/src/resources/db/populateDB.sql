DELETE FROM `webstore`.`users`;
DELETE FROM `webstore`.`products`;

INSERT INTO `webstore`.`products` (`id`, `pname`, `productDescription`, `cost`) VALUES
  ('0', 'classical poem','Author: Pushkin',100 ),
  ('1', 'poems','Author: Lermontov',200),
  ('2', 'novel','Author: B',400),
  ('3', 'story','Author: C',500),
  ('4', 'detective','Author: D',700),
  ('5', 'horror','Author: E',600),
  ('6', 'mystic','Author: F',900),
  ('7', 'satire','Author: G',800),
  ('8', 'adventure','Author: H',1000),
  ('9', 'hokku','Author: J',1100);