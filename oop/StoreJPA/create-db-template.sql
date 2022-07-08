CREATE DATABASE store_jpa;

USE store_jpa;

CREATE TABLE store (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    number INT NOT NULL
) engine = InnoDB;

CREATE TABLE director (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    salary DECIMAL(8,2) NOT NULL,
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES store(id)
) engine = InnoDB;

CREATE TABLE aisle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255),
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES store(id)
) engine = InnoDB;

CREATE TABLE product (
    id VARCHAR(5) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL
) engine = InnoDB;

CREATE TABLE store_product (
    product_id VARCHAR(5),
    store_id INT ,
    PRIMARY KEY (product_id, store_id),
    FOREIGN KEY (product_id) REFERENCES  product( id ),
    FOREIGN KEY (store_id) REFERENCES store(id)
) engine = InnoDB;