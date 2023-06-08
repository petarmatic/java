-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\kavisimo.sql

drop database if exists kavisimo;
CREATE database kavisimo;
use kavisimo;

create table korisnik(
    id int not null primary key auto_increment,
    ime VARCHAR(30),
    prezime varchar(30),
    email varchar(50)
);

create table kafic(
    id int not null PRIMARY KEY auto_increment,
    naziv varchar(30) not null,
    lokacija varchar(30) not null,
    kontakt varchar(14) not null,
    pogodnosti text,
    vrsta_kave text not null,
    ime_vlasnika varchar(30),
    prezime_vlasnika varchar(30),
    kucni_ljubimci boolean
);

CREATE table recenzija(
    korisnik int,
    ocjena int,
    kafic int,

    FOREIGN key (korisnik) REFERENCES korisnik(id),
    FOREIGN key (kafic) REFERENCES kafic(id)
);