DROP DATABASE IF EXISTS jalgo;
CREATE DATABASE IF NOT EXISTS jalgo;
USE jalgo;

DROP TABLE IF EXISTS StockTickers;
CREATE TABLE StockTickers (
  ticker VARCHAR(5) NOT NULL,
  company_name VARCHAR(25) NOT NULL,
  PRIMARY KEY (ticker)
);

DROP TABLE IF EXISTS MyStockInterests;
CREATE TABLE MyStockInterests (
  ticker VARCHAR(5) NOT NULL,
  last_open FLOAT(8,2),
  last_close FLOAT(8,2),
  date_info DATE,
  PRIMARY KEY (ticker)
);

DROP TABLE IF EXISTS Trades;
CREATE TABLE Trades (
  ticker VARCHAR(5) NOT NULL,
  move VARCHAR(4) NOT NULL,
  price FLOAT(8,2) NOT NULL,
  time_movement DATETIME NOT NULL,
  PRIMARY KEY (ticker)
);
