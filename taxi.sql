-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\taxi.sql

drop database if exists taxi;
create database taxi;
use taxi;

CREATE table tvrtka(
    sifra int not NULL PRIMARY KEY AUTo_increment,
    naziv varchar(49),
    adresa varchar(44)
);

CREATE table vozac(
    sifra int not null PRIMARY KEY auto_increment,
    osoba INT,
    radno_vrijeme datetime,
    tvrtka int
);

CREATE table vozilo(
    marka varchar(44),
    vozac int
);

CREATE table osoba(
    sifra int not null PRIMARY key auto_increment,
    ime VARCHAR(44),
    prezime varchar(33)
);

CREATE table voznja(
    sifra int not NULL PRIMARY key auto_increment,
    vozac int,
    cijena decimal(5.2)
);

CREATE table putnik(
    osoba int,
    voznja int
);

alter table vozac add FOREIGN KEY(osoba) REFERENCES osoba(sifra);
alter table vozac add FOREIGN KEY(tvrtka) REFERENCES tvrtka(sifra);
alter table vozilo add FOREIGN KEY(vozac) REFERENCES vozac(sifra);
alter table voznja add FOREIGN KEY(vozac) REFERENCES vozac(sifra);
ALTER table putnik add foreign key(osoba) REFERENCES osoba(sifra);
alter table putnik add foreign key(voznja) REFERENCES voznja(sifra);

INSERT into tvrtka(naziv,adresa) values ('Brzi', 'Nova 33 Osijek');
INSErt into osoba(ime,prezime) values ('Marko','Lik');
INSERT into osoba(ime,prezime) values ('Ana','Lok');
INSERT into vozac(osoba,radno_vrijeme,tvrtka) values (1,'2023-4-5',1);
INSERT into vozilo(marka,vozac) values('Audi',1);
insert into voznja(vozac,cijena) values(1,'44');
INSERT into putnik(osoba,voznja) values(2,1);

update tvrtka set naziv='Matrix' where sifra=1

