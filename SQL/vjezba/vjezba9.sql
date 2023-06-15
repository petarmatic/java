-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba9.sql

drop database if exists vjezba9;
CREATE database vjezba9;
use vjezba9;

create table punac_prijateljica(
    sifra int not null PRIMARY KEY auto_increment,
    punac int NOT null,
    prijateljica int not NULL
);

create table prijateljica(
    sifra int not NULL PRIMARY KEY auto_increment,
    treciputa DATETIME,
    novcica DECIMAL(16,7),
    kuna decimal(16,7),
    drugiputa DATETIME,
    haljina varchar(45),
    kratkamajica varchar(49)
);

create table cura(
    sifra int not NULL PRIMARY KEY auto_increment,
    vesta varchar(49)not null,
    ekstroventno bit,
    carape VARCHAR(37),
    suknja varchar(37) not null,
    punac int not NULL
);

create table punac(
    sifra int not NULL PRIMARY KEY auto_increment,
    narukvica int not null,
    modelnaocala VARCHAR(30) not null,
    kuna decimal(12,8),
    bojaociju varchar(33),
    suknja varchar(45)
);

CREATE table zarucnik(
    sifra int not null PRIMARY key auto_increment,
    gustoca decimal(17,6),
    haljina varchar(40),
    kratkamajica varchar(48),
    nausnica INT NOT NULL,
    brat int NOt NULL
);

create table brat(
    sifra int not NULL PRIMARY KEY auto_increment,
    novcica DECIMAL(18,9) not NULL,
    ekstroventno bit,
    vesta varchar(32),
    cura INT
);

create table snasa(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    prstena int,
    drugiputa DATETIME not null,
    haljina varchar(38) not null,
    ostavljena int
);

create table ostavljena(
    sifra int not null PRIMARY KEY auto_increment,
    modelnaocala VARCHAR(34) not null,
    suknja varchar(32),
    eura DECIMAL(18,7) not null,
    lipa DECIMAL(15,7) not null,
    treciputa DATETIME not null,
    drugiputa datetime not null
);

alter table snasa add FOREIGN KEY(ostavljena) REFERENCES ostavljena(sifra);
ALTER table zarucnik add FOREIGN KEY(brat) REFERENCES brat(sifra);
ALTER TABLE brat add FOREIGN KEY(cura) REFERENCES cura(sifra);
ALTER TABLE cura add FOREIGN KEY(punac) REFERENCES punac(sifra);
alter table punac_prijateljica add FOREIGN KEY(punac) REFERENCES punac(sifra);
ALTER table punac_prijateljica add FOREIGN KEY(prijateljica) REFERENCES prijateljica(sifra);

insert into punac(narukvica,modelnaocala,kuna,bojaociju,suknja)
    VALUES('plava narukvica','plave naočale','222,3233','plave oči','plava suknja'),
            ('žuta narukvica','žute naočale','245454,22','žute oči','žuta suknja'),
            ('zelena narukvica','zelene naočale','2455667777,2','zelene oči','zelena suknja');

INSERT into cura(vesta,ekstroventno,carape,suknja,punac)
    VALUES('plava vesta','1','plave čarape','plava suknja',1),
            ('žuta vesta','0','žute čarape','žuta suknja',2),
            ('zelena vesta','0','zelene čarape','zelena suknja',3);

INSERT into brat(novcica,ekstroventno,vesta,cura)
    values ('825111,5555','1','vesta plava',1),
            ('988145,88','0','crvena vesta',2),
            ('824522,99','1','žuta vesta',3);

insert into prijateljica(treciputa,novcica,kuna,drugiputa,haljina,kratkamajica)
    values  ('2023-5-7','2144,44','525,99','2023-7-9','plava haljina','kratka plava'),
            ('2022-5-5','558506,95','888892,77','2022-4-7','žuta haljina','kratka žuta'),
            ('2019-7-31','55225,999','88696,77','2019-12-12','crvne haljina','kratka crvena');


insert into punac_prijateljica(punac,prijateljica)
    values (1,1),
            (2,2),
            (3,3);

UPDATE snasa set drugiputa='2020-4-24';

delete from zarucnik where haljina='AB';

SELECT carape from cura where ekstroventno is null;

select a.kuna,f.nausnica,e.ekstroventno 
from prijateljica a
inner join punac_prijateljica b on a.sifra=b.prijateljica 
inner join punac c on b.punac=c.sifra 
inner join cura d on c.sifra=d.punac 
inner join brat e on d.sifra=e.cura
inner join zarucnik f on e.sifra=f.brat 
where d.ekstroventno is not null and c.modelnaocala like '%ba%'
order by e.ekstroventno desc;

select modelnaocala, kuna from punac where sifra not in(select punac from punac_prijateljica);


-- 37 min



