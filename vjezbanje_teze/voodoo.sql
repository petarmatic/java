-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\voodoo.sql

drop database if exists voodoo;
CREATE DATABASE voodoo;
use voodoo;

create table profil(
    id int not null primary key auto_increment,
    ime varchar(30),
    prezime varchar(30),
    email varchar(30)
);

create table dogadaj(
    id int not null primary KEY auto_increment,
    vrsta varchar(30),
    opis text,
    datum datetime
);

create table komentar(
    id int not null primary key auto_increment,
    sadrzaj text,
    profil INT
);

create table prijava(
    dogadaj int,
    profil int,
    obrazac text
);

CREATE table galerija(
    foto_url VARCHAR(255),
    komentar int,
    naziv varchar(30)
);

alter table komentar add FOREIGN KEY(profil) REFERENCES profil(id);
alter table prijava add FOREIGN key(dogadaj) REFERENCES dogadaj(id);
alter table prijava add FOREIGN key(profil) REFERENCES profil(id);
alter table galerija add FOREIGN KEY(komentar) REFERENCES komentar(id);
