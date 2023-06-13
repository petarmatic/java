-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\catering.sql

drop database if exists catering;
create database catering;
use catering;

create table ponuda(
    id int not null primary key auto_increment,
    jelo text,
    pice text,
    broj_osoba varchar(30),
    cijena decimal(10,2)
);

create table korisnik(
    id int not null primary key auto_increment,
    ime varchar(50),
    prezime VARCHAR(50)
);

create table narudzba(
    prigoda text,
    korisnik int,
    ponuda int,
    datum int,
    adresa varchar(255),
    FOREIGN key (korisnik) REFERENCES korisnik(id) 
);

create table registracija(
    id int not null primary key auto_increment,
    korisnik INT,
    FOREIGN key (korisnik) REFERENCES korisnik(id)
);

create table komentar(
    tekst text,
    registracija int,
    FOREIGN key (registracija) REFERENCES registracija(id)
);

CREATE table rating(
    korisnik int,
    FOREIGN key (korisnik) REFERENCES korisnik(id)
);

CREATE table popust(
    registracija int,
    FOREIGN KEY(registracija) REFERENCES registracija(id)
);

CREATE table galerija(
    id int not null primary key auto_increment,
    slika text
);

CREATE table informacija(
    opremljenost text,
    kontakt varchar(255),
    obrazac text,
    galerija int,
    FOREIGN key (galerija) REFERENCES galerija(id)
);
