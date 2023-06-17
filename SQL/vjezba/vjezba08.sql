-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba8.sql
drop database if exists vjezba8;
create database vjezba8;
use vjezba8;

CREATE table prijateljica(
    sifra int not null PRIMARY KEY auto_increment,
    vesta varchar(50),
    nausnica int not null,
    introvertno bit not null
);

create table cura(
    sifra int not null PRIMARY KEY auto_increment,
    nausnica int not null,
    indiferentno bit,
    ogrlica int not null,
    gustoca decimal(12,6),
    drugiputa DATETIME,
    vesta varchar(33),
    prijateljica INT
);

create table neprijatelj(
    sifra int not NULL PRIMARY KEY auto_increment,
    kratkamajica varchar(44),
    introvertno bit,
    indiferentno bit, 
    ogrlica int not null,
    becar int not NULL
);

CREATE table brat(
    sifra int not null PRIMARY KEY auto_increment,
    introvertno bit,
    novcica decimal(14,7) not null,
    treciputa datetime,
    neprijatelj INT
);

CREATE table becar(
    sifra int not null PRIMARY KEY auto_increment,
    eura decimal(15,10) not null,
    treciputa datetime,
    prviputa datetime,
    muskarac int not NULL
);

create table muskarac(
    sifra int not null primary key auto_increment,
    haljina varchar(47),
    drugiputa datetime not null,
    treciputa datetime
);

CREATE table muskarac_decko(
    sifra int not null primary key auto_increment,
    muskarac int not NULL,
    decko int not null
);

CREATE table decko(
    sifra int not NULL PRIMARY key auto_increment,
    kuna decimal(12,10),
    lipa decimal(17,10),
    bojakose VARCHAR(44),
    treciputa datetime not null,
    ogrlica int not NULL,
    ekstroventno bit not NULL
);

alter table cura add FOREIGN KEY(prijateljica) REFERENCES prijateljica(sifra);
alter table neprijatelj add FOREIGN KEY(becar) REFERENCES becar(sifra);
alter table brat add FOREIGN KEY(neprijatelj) REFERENCES neprijatelj(sifra);
alter table becar add FOREIGN KEY(muskarac) REFERENCES muskarac(sifra);
alter table muskarac_decko add FOREIGN KEY(muskarac) REFERENCES muskarac(sifra);
alter table muskarac_decko add FOREIGN KEY(decko) REFERENCES decko(sifra);


insert into muskarac(haljina,drugiputa,treciputa)
            values ('plava haljina','2023-4-17','2022-4-15'),
                    ('zelena haljina','2022-4-12','2010-4-16'),
                    ('haljina XD','2022-6-30','2023-6-30');

insert into becar(eura,treciputa,prviputa,muskarac)
            VALUES ('122.33','2023-5-28','2022-8-26',1),
                    ('82582,88','2022-4-7','2028-7-28',3),
                    ('962559,77','2023-4-16','2023-4-16',2);

insert into neprijatelj(kratkamajica,introvertno,indiferentno,ogrlica,becar)
            values ('nike','1','1','neka ogrlica',1),
                    ('adidas','0','0','ogrlica123',2),
                    ('maja kratka','0','1','srebrooo',3);

insert into decko(kuna,lipa,bojakose,treciputa,ogrlica,ekstroventno)
            values('12222,22','233133,33','plava','2023-28-22','neka ogrlica','1'),
                    ('55824,77','22345,55','zelena','2023-4-28','ogrlica22','0'),
                    ('244442,22','555353,55','žuta','2023-4-17','srebro22','1');

insert into muskarac_decko(muskarac,decko)
            values (1,1),
                    (2,2),
                    (3,3);

update cura set indiferentno='0';

delete from brat where novcica !='12,75';

select prviputa from becar where treciputa is null;

SELECT a.bojakose, f.neprijatelj, e.introvertno
FROM decko a
INNER JOIN muskarac_decko b ON a.sifra = b.decko
INNER JOIN muskarac c ON c.sifra = b.muskarac
INNER JOIN becar d ON c.sifra = d.muskarac
INNER JOIN neprijatelj e ON d.sifra = e.becar
INNER JOIN brat f ON e.sifra = f.neprijatelj
WHERE d.treciputa IS NOT NULL AND c.drugiputa IS NOT NULL
ORDER BY e.introvertno DESC;

select drugiputa, treciputa from muskarac where sifra not in (select muskarac from muskarac_decko);


