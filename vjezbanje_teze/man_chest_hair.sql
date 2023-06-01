--c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\man_chest_hair.sql

drop database if exists man_chest_hair;
create database man_chest_hair;
use man_chest_hair;

create table ponuda(
    opis_ponude text,
    korisnik int
);

create table korisnik(
    sifra int not null PRIMARY key auto_increment,
    ime varchar(59),
    prezime varchar(50),
    oib varchar(15),
    email varchar(50),
    karma INT
);

CREATE table karma(
    korisnik int,
    komentar text,
    rejting boolean
);

alter table ponuda add FOREIGN key (korisnik) REFERENCES korisnik(sifra);
alter table karma add FOREIGN key (korisnik) REFERENCES korisnik(sifra);