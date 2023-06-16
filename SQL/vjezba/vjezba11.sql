-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba11.sql
drop DATABASE if EXISTS vjezba11;
CREATE DATABASE vjezba11;
use vjezba11;

CREATE table svekrva(
    sifra int not null PRIMARY KEY auto_increment,
    narukvica int not NULL,
    carape VARCHAR(39) not null,
    haljina VARCHAR(31),
    punac int not NULL
);

CREATE table punac(
    sifra int not NULL PRIMARY KEY auto_increment,
    jmbag CHAR(11),
    kuna DECIMAL(16,5) not null,
    vesta VARCHAR(45) not NULL
);

CREATE table punac_mladic(
    sifra int not null PRIMARY KEY auto_increment,
    punac int not null,
    mladic int not NULL
);

CREATE table mladic(
    sifra INT not NULL PRIMARY KEY auto_increment,
    ogrlica int not null,
    stilfrizura VARCHAR(35),
    drugiputa datetime not null,
    hlace VARCHAR(41) not NULL
);

CREATE table djevojka(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    kratkamajica VARCHAR(45) not null,
    prstena int,
    ekstroventno bit not NULL,
    majica VARCHAR(42) not null,
    introvertno bit not NULL,
    svekrva INT
);

CREATE table punica(
    sifra int not null PRIMARY KEY auto_increment,
    carape VARCHAR(33) not NULL,
    drugiputa DATETIME,
    majica VARCHAR(40) not NULL,
    haljina VARCHAR(30) not null,
    bojakose VARCHAR(37) not null,
    djevojka int not null
);

CREATE table muskarac(
    sifra int not NULL PRIMARY KEY auto_increment,
    maraka decimal(16,5),
    novcica decimal(13,10),
    nausnica int,
    narukvica int not null,
    gustoca DECIMAL(16,2),
    neprijatelj int not NULL
);

CREATE table neprijatelj(
    sifra int not null PRIMARY KEY auto_increment,
    narukvica int not null,
    novcica DECIMAL(12,8) not null,
    bojakose VARCHAR(39) not null,
    gustoca decimal(14,10),
    introvertno bit not null,
    asocijalno bit
);

alter table svekrva add FOREIGN KEY(punac) REFERENCES punac(sifra);
ALTER table punac_mladic add FOREIGN KEY (punac) REFERENCES punac(sifra);
ALTER TABLE punac_mladic add FOREIGN KEY(mladic) REFERENCES mladic(sifra);
alter table djevojka add FOREIGN KEY(svekrva) REFERENCES svekrva(sifra);
alter table punica add FOREIGN KEY(djevojka) REFERENCES djevojka (sifra);
ALTER TABLE muskarac add FOREIGN KEY(neprijatelj) REFERENCES neprijatelj(sifra);

insert into punac(jmbag,kuna,vesta)
    values  ('51369874521','1233323,3','vesta plava'),
            ('79314582145','252523,33','žuta vesta'),
            ('96218412144','542525,3','zelena vesta');

insert into mladic(ogrlica,stilfrizura,drugiputa,hlace)
    VALUES ('plava ogrlica','ćelava glava','2023-5-16','plave hlače'),
            ('žuta ogrlica','zarasla frizura','2023-4-4','žute hlače'),
            ('zelena ogrlica','duga frizura','2023-5-19','zelene hlače');

insert into punac_mladic(punac,mladic)
    VALUES  (1,1),
            (2,2),
            (3,3);

insert into svekrva(narukvica,carape,haljina,punac)
    VALUES  ('za ruku','poderane','plava haljina',1),
            ('za nogu','probušene','zelena haljina',2),
            ('za vrat','bušne','žuta haljina',3);

insert into djevojka(kratkamajica,prstena,ekstroventno,majica,introvertno,svekrva)
    VALUES  ('nike majica','prstena 22','1','majica adidas','0',1),
            ('adidas majica','prstena 33','0','majica nike','1',2),
            ('vans majica','prstena 11','1','vans patike','1',3);

UPDATE muskarac set novcica='15,70';

delete from punica WHERE drugiputa='2019-4-8';

select haljina from svekrva where carape like '%ana%';

select a.drugiputa,f.haljina,e.prstena 
from mladic a
inner join punac_mladic b on a.sifra=b.mladic 
inner join punac c on b.punac=c.sifra 
inner join svekrva d on c.sifra=d.punac 
inner join djevojka e on d.sifra=e.svekrva 
inner join punica f on e.sifra=f.djevojka 
where d.carape like 'a%' and c.kuna !='21'
order by e.prstena desc;

select kuna,vesta from punac where sifra not in (select punac from punac_mladic);


select a.kuna, a.vesta
from punac a
left join punac_mladic b on a.sifra=b.punac 
where b.punac is null;


-- 31 minuta
