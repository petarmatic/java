-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezba\vjezba5.sql

drop database if exists vjezba5;
create database vjezba5;
use vjezba5;

create table mladic(
    sifra int not NULL PRIMARY KEY auto_increment,
    kratkamajica VARCHAR(48) not null,
    haljina VARCHAR(30) not null,
    asocijalno bit,
    zarucnik INT
);

CREATE table zarucnik(
    sifra int not NULL PRIMARY KEY auto_increment,
    jmbag CHAR(11),
    lipa DECIMAL(12,8),
    indiferentno bit not null
);

CREATE table svekar(
    sifra int not null primary key auto_increment,
    bojakose varchar(33),
    majica VARCHAR(31),
    carape varchar(31) not null,
    haljina VARCHAR(43),
    narukvica int,
    eura decimal(14,5) not NULL
);

CREATE table punac(
    sifra int not NULL PRIMARY KEY auto_increment,
    dukserica VARCHAR(33),
    prviputa datetime not null,
    majica varchar(36),
    svekar INT
);

CREATE table svekar_cura(
    sifra int not null PRIMARY key auto_increment,
    svekar int not null,
    cura int not null
);

CREATE table cura(
    sifra int not null PRIMARY key auto_increment,
    carape varchar(41) not null,
    maraka DECIMAL(17,10) not null,
    asocijalno bit,
    vesta varchar(47) not NULL
);

CREATE table punica(
    sifra int not null primary KEY auto_increment,
    hlace varchar(43) not NULL,
    nausnica int not null,
    ogrlica int,
    vesta varchar(49) not null,
    modelnaocala varchar(31) not null,
    treciputa datetime not null,
    punac int not null
);

CREATE table ostavljena(
    sifra int not null primary key auto_increment,
    majica varchar(31),
    ogrlica int not null,
    carape varchar(44),
    stilfrizura varchar(42),
    punica int
);


alter table mladic add FOREIGN key(zarucnik) REFERENCES zarucnik(sifra);
alter table punac add FOREIGN KEY(svekar) REFERENCES svekar(sifra);
ALTER TABLE svekar_cura add FOREIGN key(svekar) REFERENCES svekar(sifra);
alter table svekar_cura add FOREIGN key(cura) REFERENCES cura(sifra);
alter table punica ADD FOREIGN KEY(punac) REFERENCES punac(sifra);
ALTER table ostavljena add FOREIGN key(punica) REFERENCES punica(sifra);

insert into svekar(bojakose,majica,carape,haljina,narukvica,eura) values('sjeda','nike kratka','stopalice','plava','skupa narukvica','22555,55');
insert into svekar(bojakose,majica,carape,haljina,narukvica,eura) values('plava','nike duga','stopalice nike','crvena','jeftina narukvica','22885,55');
insert into svekar(bojakose,majica,carape,haljina,narukvica,eura) values('kosa where','adidas kratka','stopalice crvenožute','žuta','fake narukvica','555,55');


insert into punac(dukserica,prviputa,majica,svekar) values('plava','2023-5-21','nike',1);
insert into punac(dukserica,prviputa,majica,svekar) values('zelena','2022-8-29','adidas',2);
insert into punac(dukserica,prviputa,majica,svekar) values('crvena','2023-7-29','new yorker',3);

insert into punica(hlace,nausnica,ogrlica,vesta,modelnaocala,treciputa,punac) VALUES('traper plave','srebrne','kubanski vez','bakina vesta','police','2023-5-18',1);
insert into punica(hlace,nausnica,ogrlica,vesta,modelnaocala,treciputa,punac) values('traper zelene','zlatne','fake','mamina vesta','nove naocale','2023-8-29',2);
insert into punica(hlace,nausnica,ogrlica,vesta,modelnaocala,treciputa,punac) values('traper crvene','polupane','srebro neko','ukradena vesta','bez stakla','2022-5-29',3);

INSERT into cura(carape,maraka,asocijalno,vesta) values('probušene','865,44','1','štrikana');
INSERT into cura(carape,maraka,asocijalno,vesta) values('zimske','893325,44','0','plava zimska');
INSERT into cura(carape,maraka,asocijalno,vesta) values('ljetne','87765,44','1','štrikana zimska');

insert into svekar_cura(svekar,cura) values(1,1);
insert into svekar_cura(svekar,cura) values(2,2);
insert into svekar_cura(svekar,cura) values(3,3);

update mladic set haljina='Osijek';

delete from ostavljena where ogrlica=17;

select majica from punac where prviputa is null;

select a.asocijalno, f.stilfrizura, d.prviputa
from cura a
inner join svekar_cura b on a.sifra=b.cura
inner join svekar c on b.svekar=c.sifra 
inner join punac d on c.sifra=d.svekar
inner join punica e on d.sifra=e.punac 
inner join ostavljena f on e.sifra=f.punica
where d.prviputa is not null and
c.majica like '%ba%'
order by e.nausnica desc;

select majica,carape from svekar where sifra not in (select sifra from svekar_cura);

-- select a.majica, a.carape
-- from svekar a
-- left join svekar_cura b on a.sifra = b.svekar
-- where b.svekar is null;

-- 46 minuta

