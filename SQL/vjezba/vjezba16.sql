--  c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba16.sql
drop database if EXISTS vjezba15;
drop database if exists vjezba16;
CREATE database vjezba16;
use vjezba16;

create table punac(
    sifra int not   NULL PRIMARY KEY auto_increment,
    kratkamajica varchar(45),
    bojakose VARCHAR(41),
    novcica decimal(15,6),
    treciputa DATETIME not NULL
);

create table brat(
    sifra int not NULL PRIMARY KEY auto_increment,
    vesta varchar(44) not null,
    dukserica varchar(34),
    prstena int,
    majica VARCHAR(46) not null,
    punac int not NULL
);

create table mladic(
    sifra int  NOT NULL PRIMARY KEY auto_increment,
    haljina VARCHAR(30),
    lipa decimal(12,8),
    kratkamajica varchar(33),
    kuna decimal(12,10),
    treciputa DATETIME not NULL,
    brat int not NULL
);

create table svekrva(
     sifra int NOt  NULL PRIMARY KEY auto_increment,
     jmbag char(11),
     ogrlica int,
     bojakose varchar(44) not null,
     drugiputa DATETIME not null,
     mladic int not NULL
);

CREATE table punac_zarucnik(
    sifra int not NULL PRIMARY key auto_increment,
    punac int not   NULL,
    zarucnik int not NULL
);

create table zarucnik(
    sifra int not NULL PRIMARY key auto_increment,
    novcica decimal(13,9) not null,
    bojakose varchar(41) NOT NULL,
    kuna decimal(16,8) not null,
    prstena int not null,
    kratkamajica VARCHAR(44) not NULL,
    nausnica int not null
);

CREATE table zena(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    gustoca DECIMAL(12,8),
    lipa decimal(16,8),
    ogrlica int,
    carape VARCHAR(32),
    nausnica int not null,
    modelnaocala varchar(46) not null,
    prijatelj int
);

create table prijatelj(
    sifra int not NULL PRIMARY KEY auto_increment,
    treciputa datetime,
    majica varchar(49),
    asocijalno bit not NULL,
    hlace varchar(42)
);

ALTER table zena add FOREIGN KEY(prijatelj) REFERENCES prijatelj(sifra);
ALTER table svekrva add FOREIGN KEY(mladic) REFERENCES mladic(sifra);
ALTER table mladic add FOREIGN KEY(brat) REFERENCES brat(sifra);
ALTER table brat add FOREIGN KEY(punac) REFERENCES punac(sifra);
alter table punac_zarucnik add FOREIGN KEY(punac) REFERENCES punac(sifra);
alter table punac_zarucnik add FOREIGN KEY(zarucnik) REFERENCES zarucnik(sifra);


INSERT into punac(kratkamajica,bojakose,novcica,treciputa)
    values ('plava majica','plava kosa','221818,44','2023-4-4'),
            ('žuta majica','žuta kosa','2423,2222','2023-5-8'),
            ('zelena majica','zelena kosa','242424,33','2023-7-7');

INSERT INTO zarucnik(novcica,bojakose,kuna,prstena,kratkamajica,nausnica)
    VALUES  ('252222,55','plava kosa','2333,3','plavi prsten','plava majica','plava naušnica'),
            ('2332323,3232','zelena kosa','3555,33','zeleni prsten','zelena majica','zelena naušnica'),
            ('242443,33','žuta kosa','353535,33','žuti prsten','žuta majica','žuta naušnica');

INSERT into punac_zarucnik(punac,zarucnik)
    VALUES(1,1),
            (2,2),
            (3,3);


insert into brat(vesta,dukserica,prstena,majica,punac)
    values('plava vesta','plava dukserica','plavi prsten','plava majica',1),
            ('žuta vesta','žuta dukserica','žuti prsten','žuta majica',2),
            ('zelena vesta','zelena dukserica','zeleni prsten','zelena majica',3);

insert into mladic(haljina,lipa,kratkamajica,kuna,treciputa,brat)
    VALUES('plava haljina','22323,33','plava majica','323234,44','2023-4-4',1),
            ('zelena haljina','2444,333','zelena majica','53535,33','2023-4-5',2),
            ('žuta haljina','2343232,33','žuta majica','54343,33','2023-5-7',3);

update zena set lipa='13,77';

delete from svekrva WHERE ogrlica !='18';

select prstena from brat where dukserica LIKE '%ana%';

select a.kuna,f.drugiputa,e.lipa
from zarucnik a
inner join punac_zarucnik b on a.sifra=b.zarucnik 
inner join punac c on c.sifra=b.punac 
inner join brat d on c.sifra=d.punac 
inner join mladic e on d.sifra=e.brat 
inner join svekrva f on e.sifra=f.mladic 
where 
d.dukserica ='a%' and c.bojakose ='%ba%'
order by e.lipa desc;


select bojakose,novcica from punac where sifra not in (select punac from punac_zarucnik);
-- 29 min