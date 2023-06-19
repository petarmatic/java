-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba14.sql
drop database if exists vjezba14;
create database vjezba14;
use vjezba14;

create table neprijatelj(
    sifra INT NOT NULL PRIMARY KEY auto_increment,
    prstena int not NULL,
    gustoca decimal(17,7) not NULL,
    bojakose varchar(48) not NULL,
    ogrlica int not NULL,
    stilfrizura varchar(47) NOT NULL
);

create table neprijatelj_muskarac(
    sifra int not NULL PRIMARY  KEY auto_increment,
    neprijatelj int not NULL,
    muskarac int not NULL
);

create table muskarac(
    sifra int not NULL PRIMARY KEY auto_increment,
    carape VARCHAR(36),
    ogrlica int not null,
    vesta varchar(44) not NULL,
    ekstroventno bit
);

create table brat(
    sifra int not NULL PRIMARY key auto_increment,
    eura DECIMAL(15,10) not NULL,
    gustoca DECIMAL(14,5) not NULL,
    kuna DECIMAL(15,6),
    haljina varchar(38) not null,
    bojakose varchar(39),
    prstena int,
    neprijatelj int not NULL
);

CREATE table ostavljen(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    majica varchar(39),
    drugiputa datetime not NULL,
    asocijalno bit not NULL,
    brat int not NULL
);

create table ostavljena(
    sifra int not NULL PRIMARY KEY auto_increment,
    kuna decimal(17,7),
    hlace VARCHAR(45),
    suknja varchar(36),
    dukserica varchar(36),
    kratkamajica varchar(47),
    gustoca decimal(12,10) not NULL,
    ostavljen INT
);

CREATE table mladic(
    sifra int not null PRIMARY key auto_increment,
    drugiputa datetime  not null,
    narukvica int,
    bojaociju varchar(49) not NULL,
    modelnaocala varchar(41)
);

create table prijatelj(
    sifra int not NULL PRIMARY KEY auto_increment,
    stilfrizura varchar(39) not null,
    kratkamajica varchar(32),
    treciputa datetime,
    modelnaocala varchar(32) not null,
    prviputa DATETIME,
    mladic int not null   
);

alter table brat add FOREIGN KEY(neprijatelj) REFERENCES neprijatelj(sifra);
ALTER table neprijatelj_muskarac add FOREIGN KEY(neprijatelj) REFERENCES neprijatelj(sifra);
alter table neprijatelj_muskarac add FOREIGN KEY(muskarac) REFERENCES muskarac(sifra);
alter table ostavljen add FOREIGN key(brat) REFERENCES brat(sifra);
alter table ostavljena add FOREIGN KEY(ostavljen) REFERENCES ostavljen(sifra);
ALTER TABLE prijatelj add FOREIGN KEY(mladic) REFERENCES mladic(sifra);


insert into muskarac(carape,ogrlica,vesta,ekstroventno)
    values('plave čarape','plava ogrlica','plava vesta','1'),
            ('zelene čarape','zelena ogrlica','zelena vesta','0'),
            ('crvene čarape','crvena ogrlica','crvena vesta','0');

insert into neprijatelj(prstena,gustoca,bojakose,ogrlica,stilfrizura)
    values('prsten 2','22424,55','plava kosa','ogrlica neka','kratka frizura'),
            ('prsten neki','255552,22','zelena kosa','zelena ogrlica','duga frizra'),
            ('prsten za ruku','424242,22','ljubičasta kosa','ljubičsta ogrlica','ljubičasta frizura');

insert into neprijatelj_muskarac(neprijatelj,muskarac)
    values(1,1),
            (2,2),
            (3,3);

insert into brat(eura,gustoca,kuna,haljina,bojakose,prstena,neprijatelj)
    VALUES  ('22,555','62626,11','45454,44','plava haljina','plava kosa','plavi prsten',1),
            ('24424,44','4242,44','433446,66','zelena haljina','zelena kosa','zeleni prsten',2),
            ('24424,33','353553,33','353553,22','crvena haljina','crvena kosa','crveni prsten',3);


insert into ostavljen(majica,drugiputa,asocijalno,brat)
    VALUES  ('kratka majica','2023-5-4','1',1),
            ('duga majica','2023-4-6','0',2),
            ('nike majica','2023-4-5','0',3);

update prijatelj set kratkamajica='Osijek';

DELETE from ostavljena where hlace >'AB';

SELECT kuna from brat where gustoca not in(6,10,16,25,26);

select a.vesta,f.dukserica,e.drugiputa
from muskarac a
inner join neprijatelj_muskarac b on a.sifra=b.muskarac 
inner join neprijatelj c on b.neprijatelj=c.sifra 
inner join brat d on d.neprijatelj=c.sifra 
inner join ostavljen e on e.brat=d.sifra 
inner join ostavljena f on e.sifra=f.ostavljen 
where d.gustoca >100 and c.gustoca !='22'
order by e.drugiputa desc;

-- 33 min