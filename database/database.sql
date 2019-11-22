CREATE DATABASE IF NOT EXISTS CreditDB;
CREATE DATABASE IF NOT EXISTS CustomerDB;
CREATE DATABASE IF NOT EXISTS ProductBD;

CREATE TABLE IF NOT EXISTS CreditDB.Credit (
    ID INT NOT NULL AUTO_INCREMENT,
    CreditName varchar(50),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS CustomerDB.Customer (
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT,
    FirstName varchar(50),
    Pesel varchar(11),
    Surname varchar(50),
    PRIMARY KEY (ID),
    FOREIGN KEY (CreditID) REFERENCES CreditDB.Credit(ID)
);

CREATE TABLE IF NOT EXISTS ProductBD.Product (
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT,
    ProductName varchar(50),
    Value INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (CreditID) REFERENCES CreditDB.Credit(ID)
);

INSERT INTO CreditDB.Credit(CreditName) VALUES (
"Ala");
INSERT INTO CreditDB.Credit(CreditName) VALUES (
"Ala");

INSERT INTO CustomerDB.Customer(CreditID, FirstName, Pesel, Surname) VALUES (
1, "Ala", 931108029, "Ela");
INSERT INTO CustomerDB.Customer(CreditID, FirstName, Pesel, Surname) VALUES (
2, "Ala2", 931108022, "Ela2");

INSERT INTO ProductBD.Product(CreditID, ProductName, Value) VALUES (
1,"Cola", 2.33);
INSERT INTO ProductBD.Product(CreditID, ProductName, Value) VALUES (
2,"peps", 2.33);