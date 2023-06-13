-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezba\obitelj.sql
drop database if exists obitelj;
CREATE database obitelj;
use obitelj;

CREATE table sestra(
    sifra int not null primary key auto_increment,
    introvertno bit,
    haljina varchar(31) not null,
    maraka decimal(16.6),
    hlace VARCHAR(46) not null,
    narukvica int not null
);

CREATE table muskarac(
    sifra int not null PRIMARY KEY auto_increment,
    bojaociju varchar(50) not null,
    hlace varchar(30),
    modelnaocala varchar(43),
    maraka decimal(14,5) not null,
    zena int
);

CREATE table zena(
    sifra int not null PRIMARY key auto_increment,
    treciputa datetime,
    hlace varchar(46),
    kratkamajica VARCHAR(31) not null,
    jmbag char(11) not null,
    bojaociju varchar(39) not null,
    haljina varchar(44),
    sestra int not NULL 
);


create table mladic(
    sifra int not NULL PRIMARY key auto_increment,
    suknja VARCHAR(50) not null,
    kuna decimal(16,8) not null,
    drugiputa datetime,
    asocijalno BIT,
    ekstroventno bit not null,
    dukserica varchar(48) not null,
    muskarac int
);

create table sestra_svekar(
    sifra int not null primary key auto_increment,
    sestra int not null,
    svekar int not null
);  

CREATE table svekar(
    sifra int not null PRIMARY key auto_increment,
    bojaociju varchar(40) not null,
    prstena int,
    dukserica varchar(41),
    lipa decimal(13,8),
    eura DECIMAL(12,7),
    majica VARCHAR(35)
);

CREATE table punac(
    sifra int not null PRIMARY KEY auto_increment,
    ogrlica int,
    gustoca decimal(14,9),
    hlace VARCHAR(41) not null
);

create table cura (
    sifra int not null PRIMARY key auto_increment,
    novcica decimal(16,5) not null,
    gustoca DECIMAL(18,6) not null,
    lipa decimal(13,10),
    ogrlica int not null,
    bojakose varchar(38),
    suknja varchar(36),
    punac int
);

alter table sestra_svekar add FOREIGN key(sestra) REFERENCES sestra(sifra);
alter table zena add FOREIGN key(sestra) REFERENCES sestra(sifra);
alter table muskarac add FOREIGN key(zena) REFERENCES zena(sifra);
alter table sestra_svekar add FOREIGN key(svekar) REFERENCES svekar(sifra);
alter table mladic add FOREIGN key(muskarac) REFERENCES muskarac(sifra);
alter table cura add FOREIGN key(punac) REFERENCES punac(sifra);

insert into sestra(introvertno, haljina,maraka,hlace,narukvica) values('1','plava','12,2','plave','kubanski vez');
insert into sestra(introvertno, haljina,maraka,hlace,narukvica) values('1','zelena','14,2','zelene','hrvatski vez');
insert into sestra(introvertno, haljina,maraka,hlace,narukvica) values('0','smeđa','18,2','smeđe','talijanski vez');

INSERT into zena(treciputa,hlace,kratkamajica,jmbag,bojaociju,haljina,sestra) VALUES('2023-2-2', 'dugana','plava','85514789315','crne','moderna',1);
INSERT into zena(treciputa,hlace,kratkamajica,jmbag,bojaociju,haljina,sestra) VALUES('2023-4-2', 'kratke','zelena','85599789315','ljubičaste','stara',2);
INSERT into zena(treciputa,hlace,kratkamajica,jmbag,bojaociju,haljina,sestra) VALUES('2023-8-2', 'poderane','crvena','85514742315','žute','na točkice',3);

INSERT INTO muskarac (bojaociju, hlace, modelnaocala, maraka, zena) VALUES ('zelene', 'kratke', 'policajke', '20', 1);
INSERT INTO muskarac (bojaociju, hlace, modelnaocala, maraka, zena) VALUES ('crne', 'duge', 'pepeljarke', '200', 2);
INSERT INTO muskarac (bojaociju, hlace, modelnaocala, maraka, zena) VALUES ('smede', 'trenirka', 'nove', '210', 3);

insert into svekar(bojaociju,prstena,dukserica,lipa,eura,majica) VALUES ('plava','okrugli','nike','12,2','12,3','nike');
insert into svekar(bojaociju,prstena,dukserica,lipa,eura,majica) VALUES ('zelena','srebrni','adidas','14,2','15,3','adidas');
insert into svekar(bojaociju,prstena,dukserica,lipa,eura,majica) VALUES ('žuta','zlatni','vans','18,2','18,3','vans');

INSErt into sestra_svekar(sestra,svekar) values(1,1);
INSErt into sestra_svekar(sestra,svekar) values(2,2);
INSErt into sestra_svekar(sestra,svekar) values(3,3);

update cura set gustoca='15,77';

DELETE FROM mladic WHERE kuna > 15.78;

select kratkamajica from zena where hlace like '%ana%';

select f.dukserica, a.asocijalno, b.hlace
from mladic a
inner join muskarac b 		on b.sifra=a.muskarac 
inner join zena c 			on c.sifra=b.zena
inner join sestra d 		on d.sifra=c.sestra 
inner join sestra_svekar e 	on d.sifra=e.sestra
inner join svekar f 		on f.sifra=e.svekar 
where c.hlace like 'a%' and d.haljina like '%ba%'
order by b.hlace desc;

select a.haljina, a.maraka
from sestra a
left join sestra_svekar b on a.sifra=b.sestra
where b.sestra is null;

