--c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\panonian.sql
drop database if exists panonian;
CREATE database panonian;
use panonian;

create table galerija(
    id int not null primary key auto_increment,
    slika VARCHAR(30),
    naslov varchar(30)
);

create table povijest(
    galerija int,
    tekst text,
    FOREIGN key(galerija)REFERENCES galerija(id)
);
CREATE table organizacija(
    organizator varchar(30),
    sponzor varchar(30),
    kontakt varchar(15)
);

create table korisnik(
    ime varchar(30),
    prezime varchar(30),
    lozinka varchar(30)
);

create table natjecatelj(
    korisnik int,
    kategorija varchar(30),
    dob varchar(30),
    FOREIGN key(korisnik) REFERENCES korisnik(id)
);

CREATE table volonter(
    korisnik int,
    dob varchar(30),
    iskustvo boolean,
    FOREIGN key (korisnik) REFERENCES korisnik(id)
);