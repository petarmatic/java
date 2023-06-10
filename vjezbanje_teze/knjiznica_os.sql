-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\knjiznica_os.sql


drop database if exists knjiznica_os;
CREATE database knjiznica_os;
use knjiznica_os;

CREATE table upit(
    sadrzaj text,
    korisnik int
);

create table informacija(
    naziv varchar(50),
    email varchar(30),
    adresa varchar(30)
);

create table korisnik(
    id int not null PRIMARY key auto_increment,
    ime VARCHAR(30),
    prezime VARCHAR(30),
    email VARCHAR(30)
);

alter table upit add FOREIGN key(korisnik) REFERENCES korisnik(id);