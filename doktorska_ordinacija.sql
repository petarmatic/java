-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\doktorska_ordinacija.sql

drop database if EXISTS doktorska_ordinacija;
CREATE database doktorska_ordinacija;
use doktorska_ordinacija;

CREATE table osoba(
    sifra int not NULL PRIMARY KEY auto_increment,
    ime VARCHAR(44),
    prezime VARCHAR(44)
);

CREATE table doktor(
    sifra int not null PRIMARY key auto_increment,
    osoba INT
);

create table med_sestra(
    sifra int not null primary key auto_increment,
    osoba int
);

CREATE table pacijent(
    sifra int not null primary key auto_increment,
    osoba int,
    doktor int,
    med_sestra INT
);
 CREATE table lijecenje(
    pacijent int
 );
 
 ALTER table doktor  add FOREIGN KEY(osoba) REFERENCES osoba(sifra);
 ALTER table med_sestra add FOREIGN KEY(osoba) REFERENCES osoba(sifra);
 alter table pacijent ADD FOREIGN KEY(osoba) REFERENCES osoba(sifra);
 ALTER table pacijent add FOREIGN KEY(doktor) REFERENCES doktor(sifra);
 ALTER table pacijent add FOREIGN key(med_sestra) REFERENCES med_sestra(sifra);
 ALTER table lijecenje add FOREIGN KEY(pacijent) REFERENCES pacijent(sifra);

 INSERT INTO osoba(ime,prezime) VALUES('Ana','Kan');
 INSERT INTO osoba(ime,prezime) VALUES('Ana','Ivan');
 INSERT into osoba(ime,prezime) VALUES('Klara','Mlakar');

 insert into doktor(osoba) VALUes(1);
 insert into med_sestra(osoba) values(2);
 insert into pacijent(osoba,doktor,med_sestra) values(3,1,1);
 insert into lijecenje(pacijent) values (1);

 UPDATE osoba set ime='Monika' where sifra=1;