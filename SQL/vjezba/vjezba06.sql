-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba6.sql
drop database if exists vjezba6;
create database vjezba6;
use vjezba6;

create table prijatelj(
    sifra int not null PRIMARY KEY auto_increment,
    haljina varchar(33),
    prstena int not null,
    introvertno bit,
    stilfrizura varchar(36) not NULL
);

CREATE table prijatelj_ostavljena(
    sifra int not null PRIMARY KEY auto_increment,
    prijatelj int not null,
    ostavljena int not NULL
);

CREATE table ostavljena(
    sifra int not null PRIMARY KEY auto_increment,
    prviputa DATETIME not null,
    kratkamajica varchar(39) not NULL,
    drugiputa datetime,
    maraka decimal(14,10)
);

CREATE table brat(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    nausnica int not NULL,
    treciputa DATETIME not null,
    narukvica int not NULL,
    hlace VARCHAR(31),
    prijatelj int
);

CREATE table zena(
    sifra int not null PRIMARY KEY auto_increment,
    novcica decimal(14,8) not null,
    narukvica int not null,
    dukserica VARCHAR(40) not null,
    haljina varchar(30),
    hlace varchar(32),
    brat int not NULL
);

CREATE table decko(
    sifra int not null PRIMARY KEY auto_increment,
    prviputa datetime,
    modelnaocala VARCHAR(41),
    nausnica int,
    zena int not NULL
);

CREATE table svekrva(
    sifra int not null PRIMARY key auto_increment,
    hlace varchar(48) not null,
    suknja VARCHAR(42) not null,
    ogrlica int not null,
    treciputa datetime not null,
    dukserica varchar(32) not null,
    narukvica int not null,
    punac int
);

create table punac(
    sifra int not null PRIMARY KEY auto_increment,
    ekstroventno bit not null,
    suknja varchar(30) not null,
    majica varchar(44) not null,
    prviputa datetime not null
);

alter table brat add FOREIGN KEY(prijatelj) REFERENCES prijatelj(sifra);
ALTER table zena add FOREIGN KEY(brat) REFERENCES brat(sifra);
ALTER table decko add FOREIGN KEY(zena) REFERENCES zena(sifra);
ALTER table prijatelj_ostavljena add FOREIGN KEY(prijatelj) REFERENCES prijatelj(sifra);
ALTER table prijatelj_ostavljena add FOREIGN KEY(ostavljena) REFERENCES ostavljena(sifra);
ALTER TABLE svekrva add FOREIGN KEY(punac) REFERENCES punac(sifra);

INSERT into prijatelj(haljina,prstena,introvertno,stilfrizura) 
VALUES('neka marka','vjenčani','1','fade');
INSERT into prijatelj(haljina,prstena,introvertno,stilfrizura) 
VALUES('crna','zaručnički','1','kratki fade');
INSERT into prijatelj(haljina,prstena,introvertno,stilfrizura) 
VALUES('versace','kupljeni','0','duga kosa');

INSERT INTO brat(nausnica,treciputa,narukvica,hlace,prijatelj)
VALUES('nausnic123','2023-5-28','za ruku','kratke',1);
INSERT INTO brat(nausnica,treciputa,narukvica,hlace,prijatelj)
VALUES('srebro 125','2023-5-29','kubanski vez','duge',2);
INSERT INTO brat(nausnica,treciputa,narukvica,hlace,prijatelj)
VALUES('zlato','2023-9-28','zlato','nike',3);

insert into zena(novcica,narukvica,dukserica,haljina,hlace,brat) 
VALUEs('12,33','neka narukvica','nike','plava','plave',1);
insert into zena(novcica,narukvica,dukserica,haljina,hlace,brat) 
VALUEs('18262,33','srebro','adidas','na točkice','žute',2);
insert into zena(novcica,narukvica,dukserica,haljina,hlace,brat) 
VALUEs('129654,33','zlatna','vans','roza','ljubičaste',3);

INSERT into ostavljena(prviputa,kratkamajica,drugiputa,maraka)
values('2023-8-29','nike','2023-8-29','584981,88');
INSERT into ostavljena(prviputa,kratkamajica,drugiputa,maraka)
values('2023-10-29','aadidas','2023-12-29','5881,88');
INSERT into ostavljena(prviputa,kratkamajica,drugiputa,maraka)
values('2023-2-29','puma','2023-6-29','584981,18');

insert into prijatelj_ostavljena(prijatelj,ostavljena) values(1,1);
insert into prijatelj_ostavljena(prijatelj,ostavljena) values(2,2);
insert into prijatelj_ostavljena(prijatelj,ostavljena) values(3,3);

update svekrva set suknja='Osijek';

delete from decko WHERE modelnaocala >'AB';

select narukvica from brat where treciputa is null;

select a.drugiputa, f.zena, e.narukvica
from ostavljena a 
inner join prijatelj_ostavljena b on a.sifra=b.ostavljena 
inner join prijatelj c on b.prijatelj=c.sifra 
inner join brat d on c.sifra=d.prijatelj
inner join zena e on d.sifra=e.brat 
inner join decko f on e.sifra=f.zena 
where d.treciputa is not null and c.prstena =219
order by e.narukvica desc;


select prstena,introvertno from prijatelj where sifra not in(select prijatelj from prijatelj_ostavljena);

-- 56 min
