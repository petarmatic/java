--  c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\zok_vitez.sql


drop database if exists zok_vitez;
CREATE database zok_vitez;
use zok_vitez;

CREATE table klub(
    sifra int not null primary key  auto_increment,
    naziv varchar(50),
    adresa varchar(50),
    email VARCHAR(59)
);

CREATE table trener(
    sifra int not null primary key auto_increment,
    ime VARCHAR(59),
    prezime varchar(44),
    klub int
);

CREATE table igrac(
    sifra int not null primary key auto_increment,
    ime VARCHAR(50),
    prezime varchar(50),
    klub INT
);

CREATE table utakmica(
    sifra int not null primary key auto_increment,
    domacin varchar(44),
    gosti varchar(44),
    datum datetime,
    mjesto varchar(44)
);

CREATE table vijesti(
    sifra int not null primary key auto_increment,
    utakmica int,
    tekst text
);

create table korisnik(
    sifra int not null primary key auto_increment,
    nadminak varchar(50),
    lozinka varchar(50),
    email varchar(50)
);

create table komentar(
    korisnik int,
    igrac int,
    trener int,
    vijesti INT
);

alter table trener add FOREIGN key(klub) REFERENCES klub(sifra);
alter table igrac add FOREIGN key (klub) REFERENCES klub(sifra);
alter table vijesti add FOREIGN key(utakmica) REFERENCES utakmica(sifra);
alter table komentar add FOREIGN key(korisnik) REFERENCES korisnik(sifra);
alter table komentar add FOREIGN key(igrac) REFERENCES igrac(sifra);
alter table komentar add FOREIGN key(trener) REFERENCES trener(sifra);
alter table komentar add FOREIGN key(vijesti) REFERENCES vijesti(sifra);