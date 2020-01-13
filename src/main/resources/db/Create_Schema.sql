-- create database kenjidb;
-- \connect kenjidb;

DROP TABLE IF EXISTS products;
CREATE TABLE products(
    uuid               UUID PRIMARY KEY NOT NULL,
    product_id         BIGINT NOT NULL,
    product_json       JSON NOT NULL
);

DROP TABLE IF EXISTS productStock;
CREATE TABLE productStock
(
  uuid               UUID PRIMARY KEY NOT NULL,
  stock_id           BIGINT NOT NULL,
  product_id         BIGINT NOT NULL,
  barcode            BIGINT NOT NULL,
  stock_json         JSON NOT NULL
);