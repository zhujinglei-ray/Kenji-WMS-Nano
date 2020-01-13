DROP TABLE IF EXISTS product;
CREATE TABLE products
(
  uuid               UUID PRIMARY KEY NOT NULL,
  product_id         bigint(20) PRIMARY KEY NOT NULL,
  product_json       JSON NOT NULL
);

DROP TABLE IF EXISTS productStock
CREATE TABLE productStock
(
  uuid               UUID PRIMARY KEY NOT NULL,
  stock_id           bigint(20) PRIMARY KEY NOT NULL,
  product_id         bigint(20) FOREIGN KEY NOT NULL,
  stock_json         JSON NOT NULL
);