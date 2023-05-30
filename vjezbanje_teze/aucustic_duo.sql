--  c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\aucustic_duo.sql

drop database if EXISTS aucustic_duo;
CREATE database aucustic_duo;
use aucustic_duo;

CREATE table dogadaj(
    sifra int not null PRIMARY key auto_increment,
    datum date,
    mjesto varchar(50)
);

CREATE table novost(
    sifra int not null primary key auto_increment,
    sadrzaj text,
    dogadaj int not null
);

CREATE table korisnik(
    sifra int not null primary KEY auto_increment,
    ime VARCHAR(50),
    prezime varchar(50),
    email VARCHAR(59)
);

CREATE table glazbena_zelja(
    korisnik int,
    zelja text
);

alter TABLE novost add FOREIGN key(dogadaj) REFERENCES dogadaj(sifra);
ALTER table glazbena_zelja add FOREIGN KEY(korisnik) REFERENCES korisnik(sifra);

insert into dogadaj(datum,mjesto) VALUES('2023-9-19', 'Barcelona pub');
INSERT into novost(sadrzaj,dogadaj) values ('tekst',1);
INSERT into korisnik(ime,prezime,email) VALUES('Marko','Markić','nekiemail27@gmail.com');
INSERT into glazbena_zelja(korisnik,zelja) values(1,'Moje more');
