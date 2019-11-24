-- Tworzenie oddzielnych schematów
CREATE DATABASE IF NOT EXISTS CreditDB;
CREATE DATABASE IF NOT EXISTS CustomerDB;
CREATE DATABASE IF NOT EXISTS ProductDB;

-- Tworzenie tabeli Credit
CREATE TABLE IF NOT EXISTS CreditDB.Credit(
    ID INT NOT NULL AUTO_INCREMENT,
    CreditName varchar(255),
    PRIMARY KEY (ID)
);

-- Tworzenie tabeli Customer
CREATE TABLE IF NOT EXISTS CustomerDB.Customer(
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT NOT NULL,
    FirstName varchar(255),
    Pesel varchar(11),
    Surname varchar(255),
    PRIMARY KEY (ID)
);

-- Tworzenie tabeli Product
CREATE TABLE IF NOT EXISTS ProductDB.Product(
    ID INT NOT NULL AUTO_INCREMENT,
    CreditID INT,
    ProductName varchar(255),
    Value INT,
    PRIMARY KEY (ID)
);

-- Dodanie przykładowych danych do tabeli Credit
INSERT INTO CreditDB.Credit(CreditName) VALUES (
"Credit Name Test 1");
INSERT INTO CreditDB.Credit(CreditName) VALUES (
"Credit Name Test 2");

-- Dodanie przykładowych danych do tabeli Customer
INSERT INTO  CustomerDB.Customer(CreditID, FirstName, Pesel, Surname) VALUES (
1, "First Name Test 1", 00000000001, "Surname Test 1");
INSERT INTO  CustomerDB.Customer(CreditID, FirstName, Pesel, Surname) VALUES (
2, "First Name Test 2", 00000000002, "Surname Test 2");

-- Dodanie przykładowych danych do tabeli Product
INSERT INTO ProductDB.Product(CreditID, ProductName, Value) VALUES (
1,"Product Name Test 1", 111);
INSERT INTO ProductDB.Product(CreditID, ProductName, Value) VALUES (
2,"Product Name Test 2", 222);

-- Nadanie praw do całej bazy danych uzytkownikowi demo_java
GRANT ALL PRIVILEGES ON *.* TO 'demo_java'@'%';