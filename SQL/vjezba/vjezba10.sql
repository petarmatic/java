-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba10.sql
drop database if EXISTS vjezba10;
CREATE DATABASE vjezba10;
use vjezba10;

CREATE table zarucnica(
    sifra int not NULL PRIMARY KEY auto_increment,
    treciputa datetime,
    prviputa datetime,
    suknja varchar(32) not null,
    eura DECIMAL(16,10)
);

create TABLE sestra(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    suknja varchar(46) not null,
    bojaociju varchar(49),
    indiferentno bit,
    dukserica VARCHAR(32) not null,
    drugiputa datetime,
    prviputa DATETIME not null,
    zarucnica INT
);

CREATE table punac(
    sifra int not null PRIMARY KEY auto_increment,
    lipa decimal(15,9),
    eura decimal(15,10) not null,
    stilfrizura varchar(37)
);

create table punac_neprijatelj(
    sifra int not null PRIMARY KEY auto_increment,
    punac int not NULL,
    neprijatelj int not NULL
);

create table neprijatelj(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    gustoca DECIMAL(15,10) not NULL,
    dukserica varchar(32) not NULL,
    maraka DECIMAL(15,7),
    stilfrizura VARCHAR(49) not NULL
);

CREATE table svekrva(
    sifra int not NULL PRIMARY KEY auto_increment,
    eura  DECIMAL(17,9),
    carape VARCHAR(43),
    kuna decimal(13,9),
    majica varchar(30),
    introvertno bit not NULL,
    punac INT
);

CREATE table mladic(
    sifra int not NULL PRIMARY KEY auto_increment,
    hlace varchar(48) not null,
    lipa decimal(18,6),
    stilfrizura VARCHAR(35) not null,
    prstena int,
    maraka DECIMAL(12,6) not NULL,
    svekrva INT
);

CREATE TABLE zena(
    sifra int not NULL PRIMARY KEY auto_increment,
    bojaociju varchar(49) not null,
    maraka decimal(13,9) not null,
    majica varchar(45),
    indiferentno bit,
    prviputa datetime,
    mladic int
);

alter table sestra add FOREIGN KEY(zarucnica) REFERENCES zarucnica(sifra);
alter table punac_neprijatelj add FOREIGN KEY(punac) REFERENCES punac(sifra);
ALTER table punac_neprijatelj add FOREIGN KEY(neprijatelj)REFERENCES neprijatelj(sifra);
ALTER table svekrva add FOREIGN KEY(punac) REFERENCES punac(sifra);
ALTER table mladic add FOREIGN KEY(svekrva) REFERENCES svekrva(sifra);
alter table zena add FOREIGN KEY(mladic) REFERENCES mladic(sifra);

INSERT into punac(lipa,eura,stilfrizura)
    VALUES  ('23444,22','54646,22','dobra firzura'),
            ('6456,22','45466,22','loša frizura'),
            ('34253,344','24424,55','može proći');

INSERT INTO neprijatelj(gustoca,dukserica,maraka,stilfrizura)
    VALUES ('12555,55','plava duksa','424434,67','ošišana glava'),
            ('54554,787','crna duksa','54545,33','obrijana glava'),
            ('4334356,88','žuta duksa','65465,33','dug glava');

INSERT into punac_neprijatelj(punac,neprijatelj)
    VALUES  (1,1),
            (2,2),
            (3,3);

insert into svekrva(eura,carape,kuna,majica,introvertno,punac)
    values('24545,55','poderane','25656,4','nike majica','1',1),
            ('5663,3','zakrpane','666643,23','adidas majica',',',2),
            ('545643,2','carape od babe','54545,22','crvena majica','0',3);


insert into mladic(hlace,lipa,stilfrizura,prstena,maraka,svekrva)
    values ('plave hlace','12344,33','frizura2','pojam1','12455,88',1),
            ('crne hlace','15544,33','frizura4','pojam2','1249,88',2),
            ('zelene hlace','1577544,33','frizura9','pojam4','1266649,88',3);


UPDATE sestra set bojaociju='Osijek';

DELETE from zena where maraka !='14,81;'

select kuna from svekrva where carape like '%ana%';

select a.maraka,f.indiferentno, e.lipa
from neprijatelj a
inner join punac_neprijatelj b on a.sifra = b.neprijatelj 
inner join punac c on b.punac=c.sifra
inner join svekrva d on c.sifra=d.punac 
inner join mladic e on d.sifra=e.svekrva 
inner join zena f on e.sifra=f.mladic 
where d.carape like 'a%' and c.eura !='22'
order by e.lipa desc;

select eura,stilfrizura from punac where sifra not in (select punac from punac_neprijatelj);




