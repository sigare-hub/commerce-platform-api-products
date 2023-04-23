INSERT INTO `product`(
	`id`,
	`description`,
	`name`,
	`product_type`,
	`promotional_price`,
	`sales_price`,
	`stock_bar_code`,
	`stock_sku`,
	`stock_type`,
	`video_link`
)
VALUES
(
	1,
	'FORMA EM SILICONE PARA AIR FRYER, FORNO, MICROONDAS, FRITADEIRA ELÉTRICA, ASSADEIRA - ANTIADERENTE RESISTENTE MALEÁVEL E REUTILIZÁVEL',
	'KIT 3 Forma Assadeira Para Fritadeira Air Fryer Microondas Forno Em Silicone Flexível Lavável',
	'Físico',
	39.90,
	29.90,
	'PRD0231J23',
	'PRD0231J23',
	'Limitado',
	''
);


INSERT INTO `product_image`(
	`id`,
	`description`,
	`link`,
	`product_id`
)
VALUES
(
	1,
	'Imagem 1',
	'https://exemplo.com/imagem1.jpg',
	1
),
(
	2,
	'Imagem 2',
	'https://exemplo.com/imagem2.jpg',
	1
),
(
	3,
	'Imagem 3',
	'https://exemplo.com/imagem3.jpg',
	1
);

INSERT INTO product_stock (id, quantity, product_id)
VALUES
  (1, 10, 1),
  (2, 5, 1),
  (3, 15, 1);
