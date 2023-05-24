-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\galerija.sql

drop database if exists galerija;
CREATE database galerija;
use galerija;

CREATE table galerija(
    sifra int not null PRIMARY key auto_increment,
    naziv int,
    nadredena int,
    autor int
);

CREATE table autor(
    sifra int not NULL PRIMARY key auto_increment,
    ime varchar(40),
    prezime varchar(40)
);

create table slika(
    sifra int not null primary key auto_increment,
    galerija int,
    putanja varchar(22)
);

CREATE table slika_oznaka(
    slika int, 
    oznaka INT
);

create table oznaka(
    sifra int not null primary key auto_increment,
    naziv varchar(44)
);

alter table galerija add FOREIGN key(nadredena) REFERENCES galerija(sifra);
alter table slika add FOREIGN key(galerija) REFERENCES galerija(sifra);
ALTER table slika_oznaka add FOREIGN key (slika) REFERENCES slika(sifra);
ALTER table slika_oznaka ADD FOREIGN KEY(oznaka) REFERENCES oznaka(sifra);
ALTER table galerija add FOREIGN KEY AUTO (autor) REFERENCES autor(sifra);

insert into autor(ime,prezime) VALUES('Klara','Kartica');
insert into galerija(naziv,nadredena,autor) VALUES('Plavo',1,1);
insert into slika(galerija,putanja) values(1,'nesto');
INSERT into oznaka(naziv) VALUES('More');
insert into slika_oznaka(slika,oznaka) values(1,1);

insert into autor(ime,prezime) VALUES('Lara','Katica');
insert into galerija(naziv,nadredena,autor) VALUES('Zeleno',2,2);
insert into slika(galerija,putanja) values(2,'nesto');
INSERT into oznaka(naziv) VALUES('MoreNebo');
insert into slika_oznaka(slika,oznaka) values(2,2);

insert into autor(ime,prezime) VALUES('Klara','Kartica');
insert into galerija(naziv,nadredena,autor) VALUES('Žuto',3,3);
insert into slika(galerija,putanja) values(3,'nesto');
INSERT into oznaka(naziv) VALUES('More3');
insert into slika_oznaka(slika,oznaka) values(3,3);

UPDATE autor SET ime='Marko', prezime='Kičić' where sifra=1;
UPDATE autor set ime='Dado', prezime='Paluba' where sifra=2;
UPDATE autor set ime='Nikola', prezime='Nikić' where sifra=3;

update galerija set naziv='Živo more' where sifra=1;
UPDATE galerija set naziv='Što je to' where sifra=2;
update galerija set naziv='Hodam oko svijeta' where sifra=3;

delete from slika where putanja='neznam';
delete from autor where ime='Klara';






