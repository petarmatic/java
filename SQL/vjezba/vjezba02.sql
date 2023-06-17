-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezba\vjezba2.sql

drop database if EXISTS vjezba2;
CREATE database vjezba2;
use vjezba2;

create table decko(
    sifra int not null primary key auto_increment,
    indiferentno bit,
    vesta VARCHAR(34),
    asocijalno bit not NULL
);

CREATE table decko_zarucnica(
    sifra int not null primary key auto_increment,
    decko int not null,
    zarucnica int not NULL
);

create table zarucnica(
    sifra int not null primary key auto_increment,
    narukvica int,
    bojakose varchar(37) not null,
    novcica decimal(15,9),
    lipa decimal(15,8) not null,
    indiferentno bit not NULL
);

create table cura(
    sifra int not null primary key auto_increment,
    haljina varchar(33) not null,
    drugiputa datetime not NULL,
    suknja varchar(38),
    narukvica int,
    introvertno bit,
    majica varchar(40) not null,
    decko int
);

CREATE table neprijatelj(
    sifra int not null primary key auto_increment,
    majica varchar(32),
    haljina varchar(43) not null,
    lipa decimal(16,8),
    modelnaocala varchar(49) not null,
    kuna DECIMAL(12,6) not null,
    jmbag char(11),
    cura INT
);

CREATE table brat(
    sifra int not null PRIMARY key auto_increment,
    suknja varchar(47),
    ogrlica int not null,
    asocijalno bit not null,
    neprijatelj int not NULL
);

CREATE table prijatelj(
    sifra int not null primary key auto_increment,
    modelnaocala varchar(37),
    treciputa datetime not null,
    ekstroventno bit not null,
    prviputa datetime,
    svekar int not NULL
);

create table svekar(
    sifra int not null PRIMARY key auto_increment,
    stillfrizura VARCHAR(48),
    ogrlica int not null,
    asocijalno bit not null
);

alter table cura add FOREIGN key(decko) REFERENCES decko(sifra);
ALTER table decko_zarucnica add FOREIGN key(decko) REFERENCES decko(sifra);
alter table decko_zarucnica add FOREIGN key(zarucnica) REFERENCES zarucnica(sifra);
alter table neprijatelj add FOREIGN key(cura) REFERENCES cura(sifra);
alter table brat add FOREIGN key(neprijatelj) REFERENCES neprijatelj(sifra);
alter table prijatelj add FOREIGN key(svekar) REFERENCES svekar(sifra);


insert into decko(indiferentno,vesta,asocijalno) values('1','nike','1');
INSERT into decko(indiferentno,vesta,asocijalno) values('0','bakina','0');
INSERT into decko(indiferentno,vesta,asocijalno) VALUES('1','ukradena','0');

insert into cura(haljina,drugiputa,suknja,narukvica,introvertno,majica,decko) values('kratka','2023-5-8','roza','srebrna','1','nike',1);
insert into cura(haljina,drugiputa,suknja,narukvica,introvertno,majica,decko) values('duga','2022-5-8','bijela','zlatna','0','adidas',2);
insert into cura(haljina,drugiputa,suknja,narukvica,introvertno,majica,decko) values('nikakva','2024-5-8','siva','fake','0','vans',3);

insert into neprijatelj(majica,haljina,lipa,modelnaocala,kuna,jmbag,cura) values('plava','duga','12,2','crne','33,5','58463975187',1);
insert into neprijatelj(majica,haljina,lipa,modelnaocala,kuna,jmbag,cura) values('crna','kratka','18,2','plave','83,5','58493975187',2);
insert into neprijatelj(majica,haljina,lipa,modelnaocala,kuna,jmbag,cura) values('smeda','nikakva','82,2','smede','53,5','59463975187',3);

INSERT into zarucnica(narukvica,bojakose,novcica,lipa,indiferentno) values('srebra','plava','22,5','33.6','1');
INSERT into zarucnica(narukvica,bojakose,novcica,lipa,indiferentno) values('zlatna','crna','82,5','39.6','2');
INSERT into zarucnica(narukvica,bojakose,novcica,lipa,indiferentno) values('fake','črna','22,9','33.9','3');

insert into decko_zarucnica(decko,zarucnica) VALUES(1,1);
INSERT into decko_zarucnica(decko,zarucnica) VALUES(2,2);
INSERT into decko_zarucnica(decko,zarucnica) VALUES(3,3);

update prijatelj set treciputa='2020-04-30';

delete from brat where ogrlica!=4;

select suknja from cura where drugiputa is null;

select a.novcica, f.neprijatelj, e.haljina
from zarucnica a
inner join decko_zarucnica b  on a.sifra=b.zarucnica 
inner join decko c on c.sifra=b.decko 
inner join cura d on c.sifra=d.decko 
inner join neprijatelj e on d.sifra=e.cura
inner join brat f on e.sifra =f.neprijatelj 
where d.drugiputa is not null
and c.vesta like '%ba%'
group by e.haljina desc;

select vesta, asocijalno from decko where sifra not in (select decko from decko_zarucnica);

-- sve ukupno 56 minuta

