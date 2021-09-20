DROP DATABASE IF EXISTS Jurilog;
CREATE DATABASE IF NOT EXISTS Jurilog;

CREATE USER IF NOT EXISTS 'root' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON Jurilog . * TO 'root';

CREATE TABLE client(
   id int NOT NULL,
   nom VARCHAR(255) NOT NULL,
   prenom VARCHAR(255) NOT NULL,
   adresse VARCHAR(255) NOT NULL,
   phone VARCHAR(255) NOT NULL,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO client (nom, prenom, adresse, phone, username, password) VALUES ('daniel', 'rest', 'test', 'test', 'test', 'test')