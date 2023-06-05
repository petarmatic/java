-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\adopt.sql

drop database if exists adopt;
create database adopt;
use adopt;

create table informacija(
    id int not null primary key auto_increment,
    ime_zivotinje varchar(30),
    vrsta_zivotinje varchar(255),
    starost varchar(3),
    zdravlje text,
    navike text,
    osobine text
);

create table registracija(
    id int not null primary key auto_increment,
    ime varchar(30),
    prezime varchar(30),
    lozinka varchar(20),
    email varchar(50)
);

create table zivotinja(
    informacija int,
    slika text,
    svida_mi_se boolean,
    registracija int,
    FOREIGN key(informacija) REFERENCES informacija(id),
    FOREIGN key(registracija) REFERENCES registracija(id)
);

CREATE table komentar(
    tekst text,
    registracija int,
    FOREIGN KEY (registracija) REFERENCES registracija(id)
);

create table azil(
    naziv varchar(30),
    adresa varchar(40),
    kontakt varchar(40),
    opremljenost text
);