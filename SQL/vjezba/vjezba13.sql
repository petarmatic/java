-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba13.sql
drop database if exists vjezba13;
CREATE database vjezba13;
use vjezba13;

CREATE table ostavljen(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    kratkamajica VARCHAR(34),
    drugiputa DATETIME,
    asocijalno bit not NULL,
    stilfrizura VARCHAR(40),
    svekrva int not NULL
);

CREATE table mladic(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    drugiputa DATETIME not null,
    carape VARCHAR(48) not null,
    ogrlica int,
    kratkamajica varchar(42) not NULL,
    introvertno bit not null,
    asocijalno bit not null,
    ostavljen int
);

CREATE table cura(
    sifra int not   NULL PRIMARY KEY auto_increment,
    ogrlica int,
    hlace VARCHAR(42),
    vesta VARCHAR(31) not null,
    majica varchar(50),
    mladic INT
);

CREATE table svekrva(
    sifra int not null PRIMARY KEY auto_increment,
    hlace varchar(35),
    ogrlica int,
    ekstroventno bit not null,
    narukvica int
);

CREATE table svekrva_svekar(
    sifra int not NULL PRIMARY KEY auto_increment,
    svekrva int NOT null,
    svekar int not null
);

CREATE table svekar(
    sifra int not null PRIMARY KEY auto_increment,
    suknja varchar(40),
    stilfrizura varchar(34) not null,
    gustoca DECIMAL(15,10) not null,
    carape varchar(35)not NULL
);

CREATE table neprijatelj(
    sifra int not   NULL PRIMARY KEY auto_increment,
    bojakose varchar(32),
    novcica decimal(12,6) not null,
    prviputa datetime,
    indiferentno bit not null,
    suknja varchar(44) not null,
    jmbag char(11),
    muskarac int not NULL
);

CREATE table muskarac(
    sifra int not null PRIMARY KEY auto_increment,
    dukserica varchar(34),
    gustoca DECIMAL(13,10),
    haljina varchar(42) not null,
    majica varchar(39),
    suknja VARCHAR(50) not null,
    kuna decimal(17,9) not null
);


alter table ostavljen add FOREIGN KEY(svekrva) REFERENCES svekrva(sifra);
ALTER table mladic add FOREIGN KEY(ostavljen) REFERENCES ostavljen(sifra);
ALTER table cura add FOREIGN KEY(mladic) REFERENCES mladic(sifra);
alter table svekrva_svekar add FOREIGN KEY(svekrva) REFERENCES svekrva(sifra);
ALTER table svekrva_svekar add FOREIGN KEY(svekar) REFERENCES svekar(sifra);
ALTER table neprijatelj add FOREIGN KEY(muskarac) REFERENCES muskarac(sifra);


insert into svekrva(hlace,ogrlica,ekstroventno,narukvica)
    values('plave hlače','plava ogrlica','1','plava narukvica'),
            ('zelene hlače','zelena ogrlica','0','zelena narukvica'),
            ('crvene hlače','crvena ogrlica','1','crvena narukvica');

INSERT into ostavljen(kratkamajica,drugiputa,asocijalno,stilfrizura,svekrva)
    VALUES('zelena majica','2023-4-16','1','plava frizura',1),
            ('žuta majica','2023-4-17','','žuta frizura',2),
            ('crvena majica','2023-5-16','0','crvena frizura',3);


insert into mladic(drugiputa,carape,ogrlica,kratkamajica,introvertno,asocijalno,ostavljen)
    VALUES  ('2023-4-7','plave čarape','plava ogrlica','plava majica','1','1',1),
            ('2023-7-15','žute čarape','žuta ogrlica','žuta majica','0','0',2),
            ('2023-4-19','zelene ćarape','zelena ogrlica','zelena majica','1','1',3);

insert into svekar(suknja, stilfrizura,gustoca,carape)
    VALUES ('plava suknja','plava frizura','24442,22','plave čarape'),
            ('žuta suknja','žuta firzura','55548,77','žute čarape'),
            ('crvena suknja','crvne frizura','484648,44','crvene čarape');

INSERT INTO svekrva_svekar(svekrva,svekar)
    VALUES (1,1),
            (2,2),
            (3,3);


update neprijatelj set novcica='13,77';

delete from cura where hlace !='AB';

select asocijalno from ostavljen where drugiputa is null;


select a.gustoca, f.majica,e.carape 
from svekar a
inner join svekrva_svekar b on a.sifra=b.svekar 
inner join svekrva c on c.sifra=b.svekrva 
inner join ostavljen d on c.sifra=d.svekrva 
inner join mladic e on d.sifra=e.ostavljen 
inner join cura f on e.sifra=f.mladic 
where d.drugiputa is not null and c.ogrlica ='193'
order by e.carape desc;

select ogrlica, ekstroventno from svekrva where sifra not in(select svekrva from svekrva_svekar);