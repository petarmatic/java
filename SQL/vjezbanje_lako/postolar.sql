-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\postolar.sql

drop database if exists postolar;
CREATE database postolar;
use postolar;

CREATE table osoba(
    sifra int not null primary key auto_increment,
    ime varchar(66),
    prezime varchar(55)
);

CREATE table korisnik(
   sifra int not null primary key auto_increment,
    osoba int,
    komada_obuce varchar(44)
);

create table obuca(
    sifra int not null PRIMARY key auto_increment,
    naziv varchar(44),
    korisnik int
);
CREATE table popravak(
    sifra int not null PRIMARY key auto_increment,
    obuca int
);

create table segrt(
    osoba int,
    popravak int
);

alter table korisnik add foreign key(osoba) REFERENCES osoba(sifra);
alter table obuca add FOREIGN key(korisnik) REFERENCES korisnik(sifra);
alter table popravak add FOREIGN key(obuca) REFERENCES obuca(sifra);
alter table segrt add FOREIGN key(osoba) REFERENCES osoba(sifra);
ALTER table segrt add FOREIGN key(popravak) REFERENCES popravak(sifra);

insert into osoba(ime,prezime) values('Ivan','Ivić');
insert into osoba(ime,prezime) values('Atila','Gligorević');

insert into korisnik(osoba,komada_obuce) values(1,'5');
insert into obuca(naziv,korisnik) values('patike',1);

insert into popravak(obuca) values(1);

insert into segrt(osoba,popravak) values(2,1);

