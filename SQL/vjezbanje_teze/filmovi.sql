-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\filmovi.sql
drop database if exists filmovi;
CREATE database filmovi;
use filmovi;

create table registracija(
    id int not null primary key auto_increment,
    ime varchar(30),
    prezime varchar(30),
    email varchar(50)
);

CREATE table recenzija(
    ocjena DECIMAL(10),
    film int,
    registracija int,
    tekst text
);

CREATE table film(
    id int not null primary key auto_increment,
    naziv varchar(30),
    godina_izlaska datetime
);

create table fanart(
    slika VARCHAR(255),
    opis text,
    registracija int
);

alter table recenzija add FOREIGN KEY(film) REFERENCES FIlm(id);
alter table recenzija add FOREIGN key(registracija) REFERENCES registracija(id);
alter table fanart add FOREIGN KEY(registracija) REFERENCES registracija(id);
