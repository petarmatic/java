--  c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\aucustic_duo.sql

drop database if EXISTS aucustic_duo;
CREATE database aucustic_duo;
use aucustic_duo;

CREATE table dogadanja(
    sifra int not null PRIMARY key auto_increment,
    datum date,
    mjesto varchar(50)
);

CREATE table novosti(
    sadrzaj text,
    dogadanja int
);

CREATE table korisnik(
    sifra int not null primary KEY auto_increment,
    ime VARCHAR(50),
    prezime varchar(50),
    email VARCHAR(59)
);

CREATE table kontakt(
    adresa varchar(55),
    telefon  varchar (20),
    email VARCHAR(50)
);

CREATE table glazbena_zelja(
    korisnik int
);

alter TABLE novosti add FOREIGN key(dogadanja) REFERENCES dogadanja(sifra);
ALTER table glazbena_zelja add FOREIGN KEY(korisnik) REFERENCES korisnik(sifra);

insert into dogadanja(datum,mjesto) VALUES('2023-9-19', 'Barcelona pub');
INSERT into novosti(sadrzaj,dogadanja) values ('tekst',1);
INSERT into korisnik(ime,prezime,email) VALUES('Marko','Markić','nekiemail27@gmail.com');
insert into kontakt(adresa,telefon,email) VALUEs('Osijek','2254554','emialodgrupe@gmail.com');
INSERT into glazbena_zelja(korisnik) values(1);