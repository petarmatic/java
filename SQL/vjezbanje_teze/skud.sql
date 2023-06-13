--c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\skud.sql

drop database if exists skud;
create database skud;
use skud;

CREATE TABLE Clan(
    ime VARCHAR(50),
    prezime VARCHAR(50),
    grupa VARCHAR(50)
);

CREATE TABLE Kontakt(
    email VARCHAR(50),
    telefon VARCHAR(20),
    adresa VARCHAR(100)
);

CREATE TABLE galerija(
    id INT not null PRIMARY KEY auto_increment,
    naziv VARCHAR(100),
    slika VARCHAR(200)
);

CREATE TABLE Nastup(
    naziv VARCHAR(55),
    datum DATEtime,
    opis TEXT,
    galerija int,
    FOREIGN key(galerija) REFERENCES galerija(id)
);

CREATE TABLE Projekt(
  naziv VARCHAR(100),
  opis TEXT
);