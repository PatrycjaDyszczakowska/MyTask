CREATE DATABASE IF NOT EXISTS task;
use task;

CREATE TABLE IF NOT EXISTS Credit (
    ID INT NOT NULL,
    CreditName varchar(50),
    PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS Customer (
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT,
    FirstName varchar(50),
    Pesel varchar(11),
    Surname varchar(50),
    PRIMARY KEY (ID),
    FOREIGN KEY (CreditID) REFERENCES Credit(ID)
);

CREATE TABLE IF NOT EXISTS Product (
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT,
    ProductName varchar(50),
    Value INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (CreditID) REFERENCES Credit(ID)
);

INSERT INTO Credit(ID, CreditName) VALUES (
1,"Ala");
INSERT INTO Credit(ID, CreditName) VALUES (
2,"Ala");

INSERT INTO Customer(CreditID, FirstName, Pesel, Surname) VALUES (
1, "Ala", 931108029, "Ela");
INSERT INTO Customer(CreditID, FirstName, Pesel, Surname) VALUES (
2, "Ala2", 931108022, "Ela2");

INSERT INTO Product(CreditID, ProductName, Value) VALUES (
1,"Cola", 2.33);
INSERT INTO Product(CreditID, ProductName, Value) VALUES (
2,"peps", 2.33);