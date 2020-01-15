-- create database kenjidb;
\connect kenjidb;

DROP TABLE IF EXISTS products;
CREATE TABLE products(
    product_id         BIGINT NOT NULL,
    barcode            BIGINT NOT NULL,
    product_json       JSON NOT NULL,
    PRIMARY KEY (product_id, barcode)
);

DROP TABLE IF EXISTS productStock;
CREATE TABLE productStock
(
  stock_id           BIGINT PRIMARY KEY NOT NULL,
  product_id         BIGINT NOT NULL REFERENCES products(product_id),
  stock_json         JSON NOT NULL
);

DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_user;
CREATE TABLE auth_role (
                           auth_role_id SERIAL PRIMARY KEY NOT NULL,
                           role_name varchar(255) DEFAULT NULL,
                           role_desc varchar(255) DEFAULT NULL
);
INSERT INTO auth_role VALUES (1,'SUPER_USER','This user has ultimate rights for everything');
INSERT INTO auth_role VALUES (2,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO auth_role VALUES (3,'SITE_USER','This user has access to site, after login - normal user');

CREATE TABLE auth_user (
                           auth_user_id SERIAL  PRIMARY KEY NOT NULL,
                           first_name varchar(255) NOT NULL,
                           last_name varchar(255) NOT NULL,
                           email varchar(255) NOT NULL,
                           password varchar(255) NOT NULL,
                           status varchar(255)
);

CREATE TABLE auth_user_role (
                                auth_user_id SERIAL NOT NULL,
                                auth_role_id SERIAL NOT NULL,
                                PRIMARY KEY (auth_user_id,auth_role_id),
                                FOREIGN KEY (auth_user_id) REFERENCES auth_user (auth_user_id),
                                FOREIGN KEY (auth_role_id) REFERENCES auth_role (auth_role_id)
) ;

insert into auth_user (auth_user_id,first_name,last_name,email,password,status) values (1,'ray','zhu','rayzhu@gmail.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i','VERIFIED');
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','1');
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','2');
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','3');
select u.email, r.role_name from auth_user u inner join auth_user_role ur on(u.auth_user_id=ur.auth_user_id) inner join auth_role r on(ur.auth_role_id=r.auth_role_id)
