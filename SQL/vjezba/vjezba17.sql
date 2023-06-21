-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba17.sql
drop database if exists vjezba17;
CREATE database vjezba17;
use vjezba17;
create table brat_becar(
    sifra int not  NULL PRIMARY KEY auto_increment,
    brat int NOT NULL,
    becar int NOt NULL
);

create table becar(
    sifra INT NOT NULL PRIMARY KEY auto_increment,
    narukvica int,
    asocijalno bit not NULL,
    vesta varchar(48),
    kuna decimal(13,10),
    kratkamajica varchar(30) not NULL
);

create table ostavljen(
    sifra int   NOt NULL PRIMARY KEY auto_increment,
    bojaociju varchar(45),
    bojakose VARCHAR(33),
    novcica decimal(16,7) not NULL,
    brat int not    NULL
);

create table brat(
    sifra int   not NULL PRIMARY KEY auto_increment,
    asocijalno bit not  NULL,
    dukserica varchar(35),
    novcica DECIMAL(15,6) not NULL,
    introvertno bit not     NULL
);

create table cura(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    ogrlica int ,
    kuna    DECIMAL(16,8),
    indiferentno bit,
    jmbag char(11),
    maraka decimal(12,7) not NULL,
    ostavljen int not NULL
);

create table prijateljica(
    sifra int not NULL PRIMARY  KEY auto_increment,
    lipa DECIMAL(12,9),
    haljina VARCHAR(37),
    maraka decimal(13,8) not NULL,
    modelnaocala VARCHAR(41) not NULL,
    cura int
);

CREATE table punica(
    sifra int not   NULL PRIMARY KEY auto_increment,
    indiferentno bit,
    narukvica int,
    gustoca decimal(18,10) not NULL,
    prijatelj int
);

create table prijatelj(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    maraka DECIMAL(13,6),
    narukvica int,
    nausnica int,
    lipa DECIMAL(15,10),
    carape varchar(33) not NULL,
    stilfrizura VARCHAR(35)
);

alter table punica add FOREIGN KEY(prijatelj) REFERENCES prijatelj(sifra);
alter table prijateljica add FOREIGN KEY(cura) REFERENCES cura(sifra);
ALTER table cura ADD FOREIGN KEY(ostavljen) REFERENCES ostavljen(sifra);
ALTER table ostavljen add FOREIGN KEY(brat) REFERENCES brat(sifra);
ALTER table brat_becar ADD FOREIGN KEY(brat) REFERENCES brat(sifra);
alter table brat_becar add FOREIGN KEY(becar) REFERENCES becar(sifra);


insert into becar(narukvica,asocijalno,vesta,kuna,kratkamajica)
     values     ('plava narukvica','0','plava vesta','2445667,88','plava majica'),
                ('žuta narukvica','1','žuta vesta','344484,22','žuta majica'),
                ('zelena narukvica','1','zelena vesta','256778,22','zelena majica');

INSERT into brat(asocijalno,dukserica,novcica,introvertno)
    values     ('1','plava duksa','242424,4444','1'),
                ('0','žuta duksa','356772,22','0'),
                ('1','zelena duksa','5566787,99','0');

insert into brat_becar(brat,becar)
    values (1,1),
            (2,2),
            (3,3);

insert into ostavljen(bojaociju,bojakose,novcica,brat)
    values  ('plave oči','plava kosa','2444,424242',1),
            ('zelene oči',' zelena kosa','2444,44',2),
            ('žute oči','žuta kosa','24444222,2',3);

insert into cura(ogrlica,kuna,indiferentno,jmbag,maraka,ostavljen)
    VALUES  ('plava ogrlica','2444,4','1','58412365421','24244,4',1),
            ('zelena ogrlica','245424,44','1','78941478521','343443,43',2),
            ('žuta ogrlica','4585645,11','0','85213697458','243434,4',3);

update punica set narukvica='11';
delete from prijateljica where haljina !='AB';

select novcica from ostavljen WHERE bojakose ='%ana%';

select a.vesta,f.modelnaocala,e.kuna
from becar a
inner join brat_becar b on a.sifra=b.becar
inner join brat c on c.sifra=b.brat 
inner join ostavljen d on c.sifra=d.brat 
inner join cura e on d.sifra=e.ostavljen 
inner join prijateljica f on e.sifra=f.cura 
where d.bojakose ='a%' and c.dukserica ='%ba%'
order by e.kuna desc;

select dukserica,novcica from brat where sifra not in (select brat from brat_becar);

-- 29 minuta