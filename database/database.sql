CREATE DATABASE IF NOT EXISTS CreditDB;
CREATE DATABASE IF NOT EXISTS CustomerDB;
CREATE DATABASE IF NOT EXISTS ProductDB;

CREATE TABLE IF NOT EXISTS CreditDB.credit(
    id INT(11) NOT NULL AUTO_INCREMENT,
    credit_name varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS CustomerDB.customer(
    id INT NOT NULL AUTO_INCREMENT,
    creditid INT NOT NULL,
    first_name varchar(255),
    pesel varchar(11),
    surname varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ProductDB.product(
    id INT NOT NULL AUTO_INCREMENT,
    creditid INT,
    product_name varchar(255),
    value INT,
    PRIMARY KEY (id)
);

INSERT INTO CreditDB.credit(credit_name) VALUES (
"Ala");
INSERT INTO CreditDB.credit(credit_name) VALUES (
"Ala");

INSERT INTO  CustomerDB.customer(creditid, first_name, pesel, surname) VALUES (
 1, "Ala", 931108029, "Ela");
INSERT INTO  CustomerDB.customer(creditid, first_name, pesel, surname) VALUES (
 2, "Ala2", 931108022, "Ela2");

INSERT INTO ProductDB.product(creditid, product_name, value) VALUES (
1,"Cola", 212);
INSERT INTO ProductDB.product(creditid, product_name, value) VALUES (
2,"peps", 210);

GRANT ALL PRIVILEGES ON *.* TO 'demo_java'@'%';