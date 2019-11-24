CREATE DATABASE IF NOT EXISTS CreditDB;
CREATE DATABASE IF NOT EXISTS CustomerDB;
CREATE DATABASE IF NOT EXISTS ProductDB;

CREATE TABLE IF NOT EXISTS CreditDB.Credit(
    ID INT NOT NULL AUTO_INCREMENT,
    CreditName varchar(255),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS CustomerDB.Customer(
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT NOT NULL,
    FirstName varchar(255),
    Pesel varchar(11),
    Surname varchar(255),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS ProductDB.Product(
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT,
    ProductName varchar(255),
    Value INT,
    PRIMARY KEY (ID)
);

INSERT INTO CreditDB.Credit(CreditName) VALUES (
"Ala");
INSERT INTO CreditDB.Credit(CreditName) VALUES (
"Ala");

INSERT INTO  CustomerDB.Customer(CreditID, FirstName, Pesel, Surname) VALUES (
1, "Ala", 931108029, "Ela");
INSERT INTO  CustomerDB.Customer(CreditID, FirstName, Pesel, Surname) VALUES (
 2, "Ala2", 931108022, "Ela2");

INSERT INTO ProductDB.Product(CreditID, ProductName, Value) VALUES (
1,"Cola", 212);
INSERT INTO ProductDB.Product(CreditID, ProductName, Value) VALUES (
2,"peps", 210);

GRANT ALL PRIVILEGES ON *.* TO 'demo_java'@'%';