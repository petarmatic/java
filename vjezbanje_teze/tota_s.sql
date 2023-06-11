-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\tota_s.sql
drop database if exists tota_s;
CREATE database tota_s;
use tota_s;

CREATE table informacija(
    id int not null PRIMARY key auto_increment,
    naziv varchar(30),
    lokacija varchar(30)
);

create table korisnik(
    id int not null PRIMARY key auto_increment,
    ime varchar(30),
    prezime varchar(30),
    email varchar(30)
);

CREATE table recenzija(
    tekst text,
    korisnik int
);

CREATE table izmjena_podataka(
    korisnik int,
    informacija int
);

alter TABLE recenzija add FOREIGN key(korisnik) REFERENCES korisnik(id);
alter table izmjena_podataka add FOREIGN key(korisnik) REFERENCES korisnik(id);
alter table izmjena_podataka add FOREIGN key(informacija) REFERENCES informacija(id);