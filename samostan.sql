-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\samostan.sql

drop database if exists samostan;
create database samostan;
use samostan;

create table svecenik(
    sifra int not NULL PRIMARY key auto_increment,
    ime VARCHAR(44),
    prezime VARCHAR(55),
    poslovi INT,
    nadredeni INT
);

create TABLE poslovi(
    sifra int not null PRIMARY KEY auto_increment,
    ciscenje varchar(40),
    gradnja VARCHAR(44),
    bogoslovlje VARCHAR(44)
);

CREATE table samostan(
    svecenik int,
    adresa VARCHAR(44)
);

create table nadredeni(
    sifra int not null primary key auto_increment,
    ime VARCHAR(44),
    prezime VARCHAR(44)
);

alter table svecenik add FOREIGN key(nadredeni) REFERENCES nadredeni(sifra);
alter table svecenik add FOREIGN key (poslovi) REFERENCES poslovi(sifra);
alter table samostan add foreign key (svecenik) REFERENCES svecenik (sifra);

insert into poslovi(ciscenje,gradnja,bogoslovlje) values('crkva','svetiše','nedjelja');
INSERT into nadredeni(ime,prezime) values('Mirko','Stari');
insert into svecenik(ime,prezime,poslovi,nadredeni) values('Marin','Sveti',1,1);
insert into samostan (svecenik) values(1);
insert into samostan (adresa) values('osijek nova 66');

update svecenik set ime='Ivan' where sifra=1;
update nadredeni set ime='Karlo' where sifra=1;

delete from samostan where adresa='osijek nova 66';
