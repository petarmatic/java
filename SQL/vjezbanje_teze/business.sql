-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\business.sql
drop database if exists business;
CREATE database business;
use business;

CREATE table korisnik(
    id int not null primary key auto_increment,
    ime varchar(30),
    prezime varchar(30),
    lozinka varchar(39)
);

CREATE table investitor(
    korisnik int,
    kapital decimal(10.2),
    FOREIGN key (korisnik) REFERENCES korisnik(id)
);

CREATE table sektor_trzista(
    naziv varchar(30),
    opis text
);

create table usluga(
    predlosci text,
    tecajevi varchar(50),
    korisnik int,
    FOREIGN key (korisnik) REFERENCES korisnik(id)
);

