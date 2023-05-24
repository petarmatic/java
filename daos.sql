-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\daos.sql

drop database if exists daos;
create database daos;
use daos;

CREATE table maticna_knjiga(
    vrsta varchar(50),
    vjeroispovijest varchar(50),
    područje varchar(50),
    javnogradivo boolean,
    razdoblje_od datetime,
    razdoblje_do datetime,
    zahtjev INT
);

CREATE table zahtjev(
    sifra int not null primary key auto_increment,
    ime varchar(40),
    prezime varchar(50),
    datum_rezervacije DATETIME
);

alter table maticna_knjiga add FOREIGN key(zahtjev) REFERENCES zahtjev(sifra);



