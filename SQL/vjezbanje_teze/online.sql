-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\online.sql

drop database if exists online;
create database online;
use online;

create table korisnik(
    id int not null primary key auto_increment,
    ime varchar(100),
    prezime varchar(100),
    email varchar(100),
    lozinka varchar(20)
);

create table knjizara(
    id int not null primary key auto_increment,
    naziv varchar(30),
    adresa varchar(100),
    kontakt varchar(20)
);

create table artikl(
    id int not null PRIMARY KEY auto_increment,
    naziv VARCHAR(30),
    autor varchar(30),
    izdavac varchar(30),
    cijena decimal(3.2)
);

create table narudzba(
    knjizara int,
    korisnik int,
    artikl int,
    FOREIGN key(knjizara) REFERENCES knjizara(id),
    FOREIGN key(korisnik) REFERENCES korisnik(id),
    FOREIGN key(artikl) REFERENCES artikl(id)
);

CREATE table komentar(
    tekst text,
    korisnik int
);