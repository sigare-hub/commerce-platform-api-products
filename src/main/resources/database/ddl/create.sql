CREATE TABLE product (
  id INT NOT NULL,
  name VARCHAR(40) NOT NULL,
  description TEXT(200) NOT NULL,
  video_link VARCHAR(100),
  sale_price DOUBLE NOT NULL,
  promotional_price DOUBLE,
  product_type VARCHAR(20) NOT NULL,
  stock_sku VARCHAR(20) NOT NULL,
  stock_bar_code VARCHAR(20) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE product_image (
  id INT NOT NULL,
  link VARCHAR(50) NOT NULL,
  description TEXT(40),
  product_id INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE product_stock (
  id INT NOT NULL,
  product_id INT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (product_id) REFERENCES product (id)
);
