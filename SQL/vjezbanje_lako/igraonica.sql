-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\igraonica.sql

DROP DATABASE if exists igraonica;
CREATE DATABASE igraonica;
use igraonica;

create table dijete(
    sifra int not NULL PRIMARY KEY auto_increment,
    ime VARCHAR(59),
    imeRoditelja varchar(40),
    prezime VARCHAR(40),
    telefonRoditelja VARCHAR(15)
);

CREATE table dijeteposjeta(
    dijete int,
    posjeta INT
);

create table posjeta(
    sifra int not NULL PRIMARY KEY auto_increment,
    datumVrijemeDolaska datetime,
    datumVrijemeOdlaska datetime,
    napomena varchar(100),
    djelatnik_sifra int
);

CREATE table djelatnik(
    sifra int not null PRIMARY key auto_increment,
    iban varchar(20),
    ime VARCHAR(20),
    oib varchar(20),
    prezime VARCHAR(30),
    radnoMjesto varchar(50)
);

CREATE table uslugaposjeta(
    usluga int,
    posjeta int
);

CREATE table usluga(
    sifra int not null PRIMARY KEY auto_increment,
    cijena DECIMAL(3.2),
    jedinicaMjere DECIMAL(3.3),
    kolicina char(3),
    naziv VARCHAR(30)
);

CREATE table operater(
    sifra int not null PRIMARY key auto_increment,
    email VARCHAR(50),
    ime VARCHAR(40),
    lozinka VARCHAR(40),
    oib varchar(40),
    prezime varchar(40)
);

ALTER table dijeteposjeta add FOREIGN key(dijete) REFERENCES dijete(sifra);
ALTER TABLE dijeteposjeta add FOREIGN KEY(posjeta) REFERENCES posjeta(sifra);
ALTER table posjeta add FOREIGN key(djelatnik_sifra) REFERENCES djelatnik(sifra);
alter table uslugaposjeta add FOREIGN key(usluga) REFERENCES posjeta(sifra);
ALTER table uslugaposjeta  add FOREIGN key(posjeta) REFERENCES usluga(sifra);

INSERT into dijete(ime,imeRoditelja,prezime,telefonRoditelja) values('Marko','Marin','Klon','098522');
INSERT into djelatnik(iban,ime,oib,prezime,radnoMjesto) values ('HR44545','Mirna','55544','Lav','Igraonica Zeleno');
INSERT into posjeta (datumVrijemeDolaska,datumVrijemeOdlaska,napomena,djelatnik_sifra)
VALUES('2023-5-19 9:55:55', '2023-5-19 10:44:55', 'PS5',1);
insert into dijeteposjeta(dijete,posjeta) values(1,1);
INSERT into usluga(cijena,jedinicaMjere,kolicina,naziv) VALUES(55,'djeca',2,'igra');
INSERT into uslugaposjeta(usluga,posjeta) values(1,1);

INSERT into dijete(ime,imeRoditelja,prezime,telefonRoditelja) values('Marin','Marko','Klan','0985252');
INSERT into djelatnik(iban,ime,oib,prezime,radnoMjesto) values ('HR444545','Mira','556544','Lav6','Igraonica Zeleno3');
INSERT into posjeta (datumVrijemeDolaska,datumVrijemeOdlaska,napomena,djelatnik_sifra)
VALUES('2023-5-19 10:55:55', '2023-5-19 12:44:55', 'Nintendo',2);
insert into dijeteposjeta(dijete,posjeta) values(2,2);
INSERT into usluga(cijena,jedinicaMjere,kolicina,naziv) VALUES(45,'djeca',3,'bauštela');
INSERT into uslugaposjeta(usluga,posjeta) values(2,2);

INSERT into dijete(ime,imeRoditelja,prezime,telefonRoditelja) values('Marinko','Born','Lan','09851252');
INSERT into djelatnik(iban,ime,oib,prezime,radnoMjesto) values ('HR44456345','Ana','5456544','Lav2','Igraonica Zeleno2');
INSERT into posjeta (datumVrijemeDolaska,datumVrijemeOdlaska,napomena,djelatnik_sifra)
VALUES('2023-5-19 8:55:55', '2023-5-19 20:44:55', 'Bez tehnologje',3);
insert into dijeteposjeta(dijete,posjeta) values(3,3);
INSERT into usluga(cijena,jedinicaMjere,kolicina,naziv) VALUES(150,'djeca',4,'Plavo');
INSERT into uslugaposjeta(usluga,posjeta) values(3,3);

UPDATE dijete set ime='Ana' WHERE sifra=1;
update posjeta set datumVrijemeDolaska='2023-20-5 16:50:00', datumVrijemeOdlaska='2023-20-5 18:50:00', napomena='glazba', djelatnik_sifra=2 where sifra=1;
UPDATE usluga set cijena=200, jedinicaMjere='pingvini', kolicina=4, naziv='djeca vesela' where sifra=3;
