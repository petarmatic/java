-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezba\vjezba4.sql

drop database if exists vjezba4;
create database vjezba4;
use vjezba4;

create table punac(
    sifra int not null PRIMARY KEY auto_increment,
    treciputa datetime,
    majica varchar(46),
    jmbag char(11) not null,
    novcica decimal(18,7) not null,
    maraka DECIMAL(12,6) not null,
    ostavljen INT
);

create TABLE ostavljen(
    sifra int not null primary key auto_increment,
    modelnaocala varchar(43),
    introvertno bit,
    kuna decimal(14,6)
);

create table zena(
    sifra int not null  PRIMARY KEY auto_increment,
    suknja varchar(39) NOt NULL,
    lipa DECIMAL(18,7),
    prstena int not NULL
);

CREATE table zena_mladic(
    sifra int not null primary key auto_increment,
    zena int not null,
    mladic int not null
);

CREATE table mladic(
    sifra int not null PRIMARY key auto_increment,
    kuna decimal(15,9),
    lipa DECIMAL(15,9),
    nausnica int,
    stilfrizura varchar(49),
    vesta VARCHAR(34) not null
);

CREATE table snasa(
    sifra int not null PRIMARY KEY auto_increment,
    introvertno bit,
    treciputa DATETIME,
    haljina varchar(44) not null,
    zena int not null
);

CREATE table becar(
    sifra int not null PRIMARY KEY auto_increment,
    novcica decimal(14,8),
    kratkamajica VARCHAR(48) not null,
    bojaociju varchar(36) not NULL,
    snasa int not null
);

CREATE table prijatelj(
    sifra int not null PRIMARY key auto_increment,
    eura decimal(16,9),
    prstena int not NULL,
    gustoca decimal(16,5),
    jmbag char(11) not null,
    suknja varchar(47) not null,
    becar int not null    
);

alter table punac add FOREIGN key(ostavljen) REFERENCES ostavljen(sifra);
alter table becar add FOREIGN key(snasa) REFERENCES snasa(sifra);
alter table prijatelj add FOREIGN KEY(becar) REFERENCES becar(sifra);
alter table snasa ADD FOREIGN KEY(zena)REFERENCES zena(sifra);
ALTER TABLE zena_mladic add FOREIGN KEY(zena) REFERENCES zena(sifra);
alter table zena_mladic ADD FOREIGN key(mladic) REFERENCES mladic(sifra);

insert into zena(suknja,lipa,prstena) VALUES('plava','25455,55','sta je ovo');
insert into zena(suknja,lipa,prstena) VALUES('plava duga','2588455,55','ako je ovo ovo');
insert into zena(suknja,lipa,prstena) VALUES('zelena','99,55','onda sta je ovo');

INSERT into snasa(introvertno,treciputa,haljina,zena) VALUES('1','2023-5-28','duga plava',1);
INSERT into snasa(introvertno,treciputa,haljina,zena) VALUES('0','2023-8-28','zeleno plava',2);
INSERT into snasa(introvertno,treciputa,haljina,zena) VALUES('1','2023-9-28','crvena',3);

insert into becar(novcica,kratkamajica,bojaociju,snasa) VALUES('25562,666','zelena','zelena',1);
insert into becar(novcica,kratkamajica,bojaociju,snasa) VALUES('2589562,666','smeđa','zelena nike',2);
insert into becar(novcica,kratkamajica,bojaociju,snasa) VALUES('2599633362,666','žuta','zelena adidas',3);

INSERT into mladic(kuna,lipa,nausnica,stilfrizura,vesta) VALUES('15555,550','55553,33','velika nausnica','celavo','plava');
INSERT into mladic(kuna,lipa,nausnica,stilfrizura,vesta) VALUES('88555,550','57753,33','mala nausnica','dugo','zelena');
INSERT into mladic(kuna,lipa,nausnica,stilfrizura,vesta) VALUES('15775,550','55999,33','nausnica','fade','crvena');

insert into zena_mladic(zena,mladic) VALUES(1,1);
insert into zena_mladic(zena,mladic) VALUES(2,2);
insert into zena_mladic(zena,mladic) VALUES(2,2);

update punac set majica='Osijek';

delete from prijatelj  WHERE prstena >17;

select haljina from snasa where treciputa is null;

select a.nausnica, f.jmbag, e.kratkamajica 
from mladic a
inner join zena_mladic b on a.sifra=b.mladic
inner join zena c on c.sifra=b.zena 
inner join snasa d on c.sifra=d.zena 
inner join becar e on d.sifra= e.snasa
inner join prijatelj f on e.sifra=f.becar
where d.treciputa is not null and c.lipa !=29 
order by e.kratkamajica desc;

select lipa, prstena from zena where sifra not in (select zena from zena_mladic);

-- 44 min
