DROP TABLE IF EXISTS products;

CREATE TABLE products (
  product_id INT AUTO_INCREMENT  PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  product_price DOUBLE ,
  quantity INT
);



INSERT INTO products (product_name, product_price, quantity) VALUES
  ('Phone', 50.0, 20),
  ('Laptop', 25.3, 10),
  ('Monitor', 110.7, 15),
  ('HeadPhone', 75.0, 20);

  DROP TABLE IF EXISTS orders;

  CREATE TABLE orders(
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT not null,
  product_id INT not null,
  product_quantity INT not null,
  price Double
  );


