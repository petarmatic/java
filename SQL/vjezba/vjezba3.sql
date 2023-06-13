-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezba\vjezba3.sql

drop database if exists vjezba3;
create database vjezba3;
use vjezba3;


CREATE table cura(
    sifra int not null PRIMARY key auto_increment,
    dukserica varchar(49),
    maraka decimal(13,7),
    drugiputa datetime,
    majica VARCHAR(49),
    novcica decimal(15,8),
    ogrlica int not null
);

create table svekar(
    sifra int not null PRIMARY KEY auto_increment,
    novcica decimal(16,8) not null,
    suknja varchar(44) not null,
    bojakose varchar(36),
    prstea int,
    narukvica int not null,
    cura int not null,
    FOREIGN key(cura) REFERENCES cura(sifra)
);

create table snasa(
    sifra int not null PRIMARY KEY auto_increment,
    introvertno bit,
    kuna decimal(15,6) not null,
    eura decimal(12,9) not null,
    treciputa datetime,
    ostavljena int not null
);

CREATE table punica(
    sifra int not null PRIMARY KEY auto_increment,
    asocijalno bit not null,
    kratkamajica varchar(44),
    kuna decimal(13,8) not null,
    vesta VARCHAR(32) not null,
    snasa int not NULL
);

CREATE table ostavljena(
    sifra int not null PRIMARY KEy auto_increment,
    kuna DECIMAL(17,5),
    lipa decimal(15,6),
    majica varchar(36),
    modelnaocala VARCHAR(31) not null,
    prijatelj int
);

CREATE table prijatelj(
    sifra int not null PRIMARY KEY auto_increment,
    kuna decimal(16,10),
    haljina varchar(37),
    lipa DECIMAL(13,10),
    dukserica varchar(31),
    indiferentno bit not null
);

CREATE table prijatelj_brat(
    sifra int not null PRIMARY KEY auto_increment,
    prijatelj int not null,
    brat int not null
);

CREATE table brat(
    sifra int not null PRIMARY KEY auto_increment,
    jmbag char(11),
    ogrlica int not null,
    ekstroventno bit not null
);

alter table snasa add FOREIGN KEY(ostavljena) REFERENCES ostavljena(sifra);
alter table ostavljena add FOREIGN key (prijatelj) REFERENCES prijatelj(sifra);
alter table punica ADD FOREIGN KEY(snasa) REFERENCES snasa(sifra);
alter table prijatelj_brat add FOREIGN KEY (prijatelj) REFERENCES prijatelj(sifra);
alter table prijatelj_brat add FOREIGN key (brat) REFERENCES brat(sifra);



INSERT into prijatelj(kuna,haljina,lipa,dukserica,indiferentno) values('1245656,444','crna','53566,77','crna','1');
INSERT into prijatelj(kuna,haljina,lipa,dukserica,indiferentno) values('1565886,444','crvena','5357766,77','aidas','0');
INSERT into prijatelj(kuna,haljina,lipa,dukserica,indiferentno) values('1248856,444','zuta','5359966,77','nike','1');

insert into ostavljena(kuna,lipa,majica,modelnaocala,prijatelj) values('12,3','2244,553','nike','police',1);
insert into ostavljena(kuna,lipa,majica,modelnaocala,prijatelj) values('8812,3','882244,553','adisad','crne',2);
insert into ostavljena(kuna,lipa,majica,modelnaocala,prijatelj) values('18952,3','24,553','adidas','polupane',3);

insert into snasa(introvertno,kuna,eura,treciputa,ostavljena) values('1','12,2','13,3','2023-05-08',1);
insert into snasa(introvertno,kuna,eura,treciputa,ostavljena) values('0','13,2','18,3','2023-05-18',2);
insert into snasa(introvertno,kuna,eura,treciputa,ostavljena) values('1','88,2','1693,3','2023-09-08',3);

insert into brat(jmbag,ogrlica,ekstroventno) values('985642357895','zlatna','1');
insert into brat(jmbag,ogrlica,ekstroventno) values('985642997895','srebran','0');
insert into brat(jmbag,ogrlica,ekstroventno) values('985642399895','fake','1');

INSERT into prijatelj_brat(prijatelj,brat) values(1,1);
INSERT into prijatelj_brat(prijatelj,brat) values(2,2);
INSERT into prijatelj_brat(prijatelj,brat) values(3,3);

update svekar set suknja='Osijek';

DELETE from punica where kratkamajica='AB';

SELECT majica from ostavljena where lipa not in (9,10,20,30,35);

select a.ekstroventno, f.vesta, e.kuna
from brat a
inner join prijatelj_brat b on a.sifra=b.brat 
inner join prijatelj c on b.brat=c.sifra 
inner join ostavljena d on c.sifra=d.prijatelj 
inner join snasa e on d.sifra=e.ostavljena 
inner join punica f on e.sifra=f.sifra
where d.lipa !=91 and c.haljina like '%ba%'
order by e.kuna desc;

select haljina, lipa from prijatelj where sifra not in(select prijatelj from prijatelj_brat);

-- 1:10 min

