CREATE DATABASE IF NOT EXISTS products;

USE products;

CREATE TABLE IF NOT EXISTS product(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
price DOUBLE,
description VARCHAR(20)
);

INSERT INTO product(name,price,description) VALUES
("beaf",14.0,"fresh"),
("apple",4.0,"fresh"),
("banana",3.0,"fresh"),
("cake",23.0,"favor"),
("orange",3.0,"orange");

CREATE TABLE IF NOT EXISTS users(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(20),
password VARCHAR(20),
role VARCHAR(20)
);

INSERT INTO users(email,password,role) VALUES
("utoraliev@gmail.com","password","ROLE_ADMIN"),
("tu12257@auca.kg","password","ROLE_USER"),
("toralliev@gmail.com","password123","ROLE_USER");