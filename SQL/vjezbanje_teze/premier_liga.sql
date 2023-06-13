-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\premier_liga.sql
drop database if exists premier_liga;
create database premier_liga;
use premier_liga;

CREATE table klub(
    id int not null primary key auto_increment,
    naziv varchar(30),
    mjesto varchar(30),
    ime_stadiona varchar(40)
);

create table igrac(
    id int not null primary key auto_increment,
    ime VARCHAR(30),
    prezime varchar(30),
    broj_dresa varchar(30),
    klub int,
    pozicija varchar(30)   
);

CREATE table trener(
    id int not null primary key auto_increment,
    ime VARCHAR(30),
    prezime varchar(30),
    klub INT
);

CREATE table utakmica(
    id int not null PRIMARY key auto_increment,
    domacin varchar(40),
    gost varchar(33),
    datum datetime,
    mjesto varchar(33)
);

CREATE table ulaznica(
    id int not null PRIMARY key auto_increment,
    utakmica int,
    cijena decimal(3,2)
);

create table korisnik(
    id int not null primary key auto_increment,
    email varchar(50),
    ime varchar(33),
    prezime varchar(55)
);

create table rezervacija(
    ulaznica int,
    broj_karata varchar(10),
    korisnik INT
);

create table kladenje(
    pobjeda_domacina boolean,
    pobjeda_gost boolean,
    korisnik int
);

alter table igrac add FOREIGN key(klub) REFERENCES klub(id);
alter table trener add FOREIGN key(klub) REFERENCES klub(id);
alter table ulaznica add FOREIGN key(utakmica) REFERENCES utakmica(id);
alter table rezervacija add FOREIGN key(ulaznica) REFERENCES ulaznica(id);
alter table rezervacija add FOREIGN key (korisnik) REFERENCES korisnik(id);
alter table kladenje add FOREIGN key(korisnik) REFERENCES korisnik(id);