-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\vet.sql

drop database if exists vet;
create database vet;
use vet;

create table veterinar(
    sifra int not null primary key auto_increment,
    ime varchar(50),
    prezime varchar(50),
    oib varchar(50)
);
CREATE table vlasnik(
    id_vlasnik int not null primary key auto_increment,
    ime varchar(30),
    prezime varchar(30)
);

create table zivotinja(
    id_vlasnik int not null,
    veterinar int not null,
    tretman text,
    vrijeme_tretmana datetime,
    cjepivo varchar(20),
    iduci_tretman datetime,
    iduci_tretman_napomena text,
    vrsta varchar(30),
    pasmina varchar(30),
    starost varchar(3),
    broj_cipa varchar(10)
);

alter table zivotinja add FOREIGN KEY(id_vlasnik) REFERENCES vlasnik(id_vlasnik);
alter table zivotinja add FOREIGN key(veterinar) REFERENCES veterinar(sifra);
