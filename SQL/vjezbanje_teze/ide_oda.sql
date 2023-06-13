--c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\ide_oda.sql
DROP DATABASE IF EXISTS ide_oda;
CREATE DATABASE ide_oda;
USE ide_oda;

CREATE TABLE korisnik(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ime VARCHAR(50),
    prezime VARCHAR(50),
    oib CHAR(15),
    turistickaagencija_id INT
);

CREATE TABLE rezervacija(
    od DATETIME,
    do DATETIME,
    korisnik_id INT,
    broj_osoba VARCHAR(2),
    FOREIGN KEY (korisnik_id) REFERENCES korisnik (id)
);


CREATE TABLE turisticka_agencija(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    naziv VARCHAR(30),
    sjediste VARCHAR(40),
    email VARCHAR(40)
);


CREATE TABLE uplata(
    ukupan_iznos DECIMAL(5,2),
    udio_agenciji DECIMAL(5,2),
    udio_vlasnik DECIMAL(5,2)
);

alter table korisnik add FOREIGN key(turistickaagencija_id) REFERENCES turisticka_agencija(id);