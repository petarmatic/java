-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba15.sql
drop database if EXISTS vjezba15;
create database vjezba15;
use vjezba15;

create table zarucnica(
    sifra int not   NULL PRIMARY KEY auto_increment,
    prviputa datetime NOT NULL,
    bojaociju VARCHAR(31) not NULL,
    modelnaocala VARCHAR(40),
    zarucnik INT
);

create table zarucnik(
    sifra int not NULL PRIMARY KEY auto_increment,
    kratkamajica varchar(30) not NULL,
    jmbag char(11) not NULL,
    dukserica VARCHAR(45) not NULL,
    indiferentno bit,
    treciputa datetime not NULL
);

CREATE table zarucnik_ostavljena(
    sifra INT NOT NULL PRIMARY KEY auto_increment,
    zarucnik int NOT NULL,
    ostavljena int NOT NULL
);

CREATE table ostavljena(
    sifra int not null PRIMARY KEY auto_increment,
    gustoca DECIMAL(16,7),
    stilfrizura VARCHAR(37) not NULL,
    ogrlica int,
    maraka decimal(15,10)
);

create table prijatelj(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    majica VARCHAR(41) not NULL,
    vesta varchar(30),
    narukvica int not NULL,
    zarucnica INT
);

CREATE table decko(
    sifra int not NULL PRIMARY KEY auto_increment,
    vesta varchar(37) not null,
    bojakose varchar(45),
    gustoca decimal(18,7),
    prijatelj int not NULL
);

CREATE table brat(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    bojakose varchar(49) not NULL,
    majica varchar(36) not NULL,
    maraka decimal(17,9),
    vesta varchar(30) not null
);

CREATE table prijateljica(
    sifra int not null PRIMARY key auto_increment,
    kratkamajica varchar(30) not null,
    bojakose varchar(45),
    asocijalno bit not null,
    treciputa datetime not null,
    jmbag char(11) not null,
    vesta varchar(42) not null,
    brat INT
);


alter table zarucnica add FOREIGN KEY(zarucnik) REFERENCES zarucnik(sifra);
ALTER table zarucnik_ostavljena add FOREIGN KEY(ostavljena) REFERENCES ostavljena(sifra);
alter table zarucnik_ostavljena add FOREIGN KEY (zarucnik) REFERENCES zarucnik(sifra);
alter table prijatelj add FOREIGN KEY(zarucnica) REFERENCES zarucnica(sifra);
alter table decko add FOREIGN KEY(prijatelj) REFERENCES prijatelj(sifra);
alter table prijateljica  add FOREIGN KEY(brat) REFERENCES brat(sifra);


insert into zarucnik(kratkamajica,jmbag,dukserica,indiferentno,treciputa)
    values('plava majica','5189321484','plava dukserica','1','2023-1-4'),
            ('žuta majica','85236974152','žuta dukserica','0','2023-4-4'),
            ('zelena majica','58512697523','zelena dukserica','0','2022-4-16');

insert into ostavljena(gustoca,stilfrizura,ogrlica,maraka)
    values ('251515,1','plava frizura','plava ogrlica','4565665,55'),
            ('226225,44','žuta frizura','žuta ogrlica','454545.44'),
            ('65665,22','zelena frizura','zelena ogrlica','44545,447');

INSERT into zarucnik_ostavljena(zarucnik,ostavljena)
    values(1,1),
        (2,2),
        (3,3);    

insert into zarucnica(prviputa,bojaociju,modelnaocala,zarucnik)
    VALUES('2023-4-4','plave oči','plave naočale',1),
            ('2023-5-5','zelene oči','zelene naočale',2),
            ('2023-4-19','žute oči','žute naočale',3);

INSERT into prijatelj(majica,vesta,narukvica,zarucnica)
    VALUES  ('plava majica','plava vesta','plava narukvica',1),
            ('zelena majica','zelena vesta','zelena narukvica',2),
            ('žuta majica','žuta vesta','žuta narukvica',3);

update prijateljica set bojakose='Osijek';

DELETE from decko where bojakose='AB';

SELECT modelnaocala from zarucnica WHERE bojaociju ='%ana%';

select a.ogrlica,f.prijatelj,e.vesta
from ostavljena a
inner join zarucnik_ostavljena b on a.sifra=b.ostavljena
inner join zarucnik c on c.sifra=b.zarucnik 
inner join zarucnica d on c.sifra=d.zarucnik
inner join prijatelj e on d.sifra=e.zarucnica
inner join decko f on e.sifra=f.prijatelj 
where d.bojaociju ='a%' and c.jmbag is not null
order by e.vesta desc;

select jmbag,dukserica from zarucnik where sifra not in(select zarucnik from zarucnik_ostavljena);

-- 31 min