-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\SQL\vjezba\vjezba12.sql
drop DATABASE if exists vjezba12;
create database vjezba12;
use vjezba12;

create table zena(
    sifra int not   NULL PRIMARY KEY auto_increment,
    eura DECIMAL(16,6) not null,
    indiferentno bit,
    novcica decimal(15,5)
);

create table decko(
    sifra int not null PRIMARY KEY auto_increment,
    hlace varchar(46),
    asocijalno bit,
    stilfrizura varchar(43) not null,
    indiferentno bit not NULL,
    ogrlica int,
    zena int not  NULL
);

CREATE table zarucnica(
    sifra int NOT NULL PRIMARY KEY auto_increment,
    hlace VARCHAR(48) not null,
    kratkamajica varchar(46) not NULL,
    jmbag char(11),
    nausnica int
);

create table zarucnica_sestra(
    sifra int not null PRIMARY KEY auto_increment,
    zarucnica int NOT NULL,
    sestra int not NULL
);

create table sestra(
    sifra int not NULL PRIMARY KEY auto_increment,
    lipa decimal(15,9),
    ogrlica int,
    kratkamajica VARCHAR(43) not NULL
);

CREATE TABLE svekrva(
    sifra int not   NULL PRIMARY KEY auto_increment,
    maraka DECIMAL(14,7),
    kuna decimal(15,8),
    vesta varchar(44),
    asocijalno bit not NULL,
    ekstroventno bit,
    zarucnica int
);

create table djevojka(
    sifra int not NULL PRIMARY KEY auto_increment,
    modelnaocala varchar(34) not null,
    vesta VARCHAR(40) not null,
    kratkamajica varchar(39) not null,
    suknja varchar(36) not null,
    bojaociju varchar(32) not null,
    prstena int not NULL,
    svekrva int NOT NULL
);

create table prijatelj(
    sifra int not null PRIMARY KEY auto_increment,
    lipa decimal(16,10),
    asocijalno bit, 
    stilfrizura varchar(37),
    kuna decimal(14,6),
    modelnaocala varchar(38),
    djevojka int
);

alter table decko add FOREIGN KEY(zena) REFERENCES zena(sifra);
alter table svekrva add FOREIGN KEY(zarucnica) REFERENCES zarucnica(sifra);
ALTER table zarucnica_sestra add FOREIGN KEY(zarucnica) REFERENCES zarucnica(sifra);
ALTER table zarucnica_sestra add FOREIGN KEY (sestra) REFERENCES sestra(sifra);
 ALTER table djevojka add FOREIGN KEY(svekrva) REFERENCES svekrva(sifra);
 ALTER table prijatelj add FOREIGN KEY(djevojka) REFERENCES djevojka(sifra);


INSERT into zarucnica(hlace,kratkamajica,jmbag,nausnica)
    VALUES ('plave hlače','plava majica','25931478523','plava naušnica'),
            ('zelene hlače','zelena majica','78621458742','zelene naušnice'),
            ('crvene hlače','crvena majica','95235741258','crvena našnica');

INSERT into sestra(lipa,ogrlica,kratkamajica)
        VALUES('242424,33','plava ogrlica','plava majica'),
                ('2555252,33','žuta ogrlica','žuta majica'),
                ('43345.434','zelen ogrlica','zelena majica');

insert into zarucnica_sestra(zarucnica,sestra)
    VALUES(1,1),
            (2,2),
            (3,3);

INSERT INTO svekrva(maraka,kuna,vesta,asocijalno,ekstroventno,zarucnica)
    VALUES    ('12554,33','55454,5','plava vesta','1','1',1),
             ('35353,4343','34435,767','žuta vesta','0','0',2),
             ('4554554,2332','4545,44','zelena vesta','1','0',3);

 insert into djevojka(modelnaocala,vesta,kratkamajica,suknja,bojaociju,prstena,svekrva)
    VALUES  ('plave cvike','plava vesta','plava majica','plava suknja','plave oči','plavi prsten',1),
            ('žute cvike','žuta vesta','žuta majica','žuta suknja','žute oči','žuti prsten',2),
            ('zelene cvike','zelena vesta','zelena majica','zelena suknja','zelene oči','zeleni prsten',3);


update decko set asocijalno='false';

DELETE FROM prijatelj where ascocijalno=false;

select vesta from svekrva where kuna not in (8,13,20,28,35);

select a.kratkamajica,f.kuna,e.vesta
from sestra a
inner join zarucnica_sestra b on a.sifra=b.sestra 
inner join zarucnica c on b.zarucnica=c.sifra 
inner join svekrva d on c.sifra=d.zarucnica 
inner join djevojka e on e.svekrva=d.sifra 
inner join prijatelj f on e.sifra=f.djevojka 
where d.kuna >'87' and c.kratkamajica like '%ba%'
order by e.vesta desc;

select kratkamajica,jmbag from zarucnica where sifra not in(select zarucnica from zarucnica_sestra);

select a.kratkamajica,a.jmbag 
from zarucnica a
left join zarucnica_sestra b on a.sifra=b.zarucnica
where b.zarucnica is null;

 
-- 35 min
