-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\urar_silvija.sql

drop database if exists urar_silvija;
CREATE database urar_silvija;
use urar_silvija;

create table osoba(
    sifra int not null primary key auto_increment,
    ime VARCHAR(44),
    prezime VARCHAR(44)
);

CREATE table korisnik(
    sifra int not null PRIMARY key auto_increment,
    osoba INT
);

CREATE table sat(
    sifra int not null PRIMARY key auto_increment,
    kvar varchar(100),
    korisnik int
);

CREATE table segrt(
    sifra int not NULL PRIMARY key auto_increment,
    osoba INT
);

create table popravak(
    sifra int not null PRIMARY key auto_increment,
    sat int,
    segrt int
);

ALTER table korisnik add FOREIGN KEY (osoba) REFERENCES osoba(sifra);
ALTER table sat add FOREIGN KEY(korisnik) REFERENCES korisnik(sifra);
ALTER table segrt add FOREIGN key(osoba) REFERENCES osoba(sifra);
alter table popravak add foreign key(sat) REFERENCES sat(sifra);
ALTER table popravak add FOREIGN key (segrt) REFERENCES segrt(sifra);

INSERT into osoba(ime,prezime) VALUES('Marko','Makić');
insert into osoba(ime,prezime) values('Mirko','Mikić');
insert into korisnik(osoba) values(1);
insert into sat(kvar,korisnik) values('baterija',1);
insert into segrt(osoba) values(2);
INSERT into popravak(sat,segrt) values(1,1);


