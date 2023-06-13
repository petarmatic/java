-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\dvd.sql

drop database if exists dvd;
create database dvd;
use dvd;

CREATE table posjetitelj(
    ip_adresa int
);

CREATE table dvd(
    sifra int not null PRIMARY key auto_increment,
    naziv VARCHAR(44) not null,
    email varchar(33) not null,
    adresa VARCHAR(44) not null
);

CREATE TABLE dogadanja(
    datum datetime,
    mjesto varchar(33),
    dvd INT
);

create table vijesti(
    autor VARCHAR(44),
    naslov varchar(44),
    datum datetime,
    sadrzaj TEXT not null,
    dvd INT
);

CREATE table prijave(
    ime VARCHAR(44),
    prezime varchar(44),
    email varchar(44),
    dvd int
);

alter table dogadanja add FOREIGN key (dvd) REFERENCES dvd(sifra);
alter table vijesti add FOREIGN key (dvd) references dvd(sifra);
alter table prijave add FOREIGN key (dvd) REFERENCES dvd(sifra);


insert into posjetitelj(ip_adresa) values('192.186.2.1');
insert into dvd(naziv,email,adresa) values('DVD Branjin Vrh','dvdbv@gmail.com','Nova 33 Branjin Vrh');
insert into dogadanja(datum,mjesto,dvd) values(2023-5-15,'Branjin Vrh',1);
insert into vijesti(naslov,datum,sadrzaj,dvd) values('Natjecanje','2023-7-17','Neki tekst',1);
INSERT into prijave(ime,prezime,email,dvd) values('Marko','Markić','mm@mgail.com',1);

update prijave set ime='Sara', prezime='Sarić';

