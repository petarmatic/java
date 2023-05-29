--c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\aukcijska_kuca.sql

drop database if exists aukcijska_kuca;
CREATE database aukcijska_kuca;
use aukcijska_kuca;

CREATE table aukcija(
    datum datetime,
    umjetnina int
);

CREATE table umjetnina(
    sifra int not null primary key auto_increment,
    naziv varchar(50),
    autor varchar(50),
    vrsta varchar(50),
    cijena decimal(9.2),
    prodavac INT
);

CREATE table prodavac(
    sifra int not null primary key auto_increment,
    ime VARCHAR(50),
    prezime varchar(50),
    email VARCHAR(50),
    kontakt VARCHAR(50)
);

ALTER table aukcija add FOREIGN key(umjetnina) REFERENCES umjetnina(sifra);
alter table umjetnina add FOREIGN key(prodavac) REFERENCES prodavac(sifra);

INSERT into prodavac(ime,prezime,email,kontakt) VALUES('Petar','Matić','petarmatic00@gmail.com','09852486');
INSERT into umjetnina(naziv,autor,vrsta,cijena,prodavac) VALUes('Plavo nebo','Imre Nagy','slika','858.14',1);
INSERT into aukcija(datum,umjetnina) values('2023-5-28 16:00',1);
