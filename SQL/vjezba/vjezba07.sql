drop schema if exists vjezba7 cascade;
create schema vjezba7;



ALTER TABLE ostavljen DROP CONSTRAINT IF EXISTS ostavljen_zarucnik;
ALTER TABLE sestra DROP CONSTRAINT IF EXISTS sestra_prijateljica;
ALTER TABLE prijateljica DROP CONSTRAINT IF EXISTS prijateljica_ostavljen;
ALTER TABLE punica DROP CONSTRAINT IF EXISTS punica_cura;

create table if not exists zarucnik(
	sifra serial primary key,
	vesta varchar(34),
	asocijalno bit not null,
	modelnaocala varchar(43),
	narukvica int not null,
	novcica decimal(15,5)
);

create table if not exists mladic(
	sifra serial primary key,
	prstena int,
	lipa decimal(14,5) not null,
	narukvica boolean not null,
	drugiputa timestamp not null
);

CREATE TABLE if not exists zarucnik_mladic (
    sifra SERIAL PRIMARY KEY,
    zarucnik INT NOT NULL,
    mladic INT NOT null,
    CONSTRAINT zarucnik_mladic_zarucnik FOREIGN KEY (zarucnik) REFERENCES zarucnik (sifra),
    CONSTRAINT zarucnik_mladic_mladic FOREIGN KEY (mladic) REFERENCES mladic (sifra)
);


create table if not exists ostavljen(
	sifra serial primary key,
	lipa decimal(14,6),
	introvertno bit not null,
	kratkamajica varchar(36) not null,
	prstena boolean not null,
	zarucnik int
);


create table if not exists sestra(
	sifra serial primary key,
	bojakose varchar(34) not null,
	hlace varchar(36) not null,
	lipa decimal(15,6),
	stilfrizura varchar(40) not null,
	maraka decimal(12,8) not null,
	prijateljica int
);

create  table if not exists prijateljica(
	sifra serial primary key,
	haljina varchar(45),
	gustoca decimal(14,5) not null,
	ogrlica int,
	novcica decimal(12,5),
	ostavljen int
);

create  table if not exists punica(
	sifra serial primary key,
	majica varchar(40),
	eura decimal(12,6) not null,
	prstena int,
	cura int not null
);

create  table if not exists cura(
	sifra serial primary key,
	lipa decimal(12,9) not null,
	introvertno boolean,
	modelnaocala varchar(40),
	narukvica boolean,
	treciputa timestamp,
	kuna decimal(14,9)
);


ALTER TABLE ostavljen
ADD CONSTRAINT ostavljen_zarucnik
FOREIGN KEY (zarucnik) REFERENCES zarucnik (sifra);

ALTER TABLE sestra
ADD CONSTRAINT sestra_prijateljica
FOREIGN KEY (prijateljica) REFERENCES prijateljica (sifra);

ALTER TABLE prijateljica
ADD CONSTRAINT prijateljica_ostavljen
FOREIGN KEY (ostavljen) REFERENCES ostavljen (sifra);

ALTER TABLE punica
ADD CONSTRAINT punica_cura
FOREIGN KEY (cura) REFERENCES cura (sifra);

INSERT INTO zarucnik (vesta, asocijalno, modelnaocala, narukvica, novcica)
VALUES 
    ('plava', '0', 'plave', '0', '2.2'),
    ('crna', '1', 'crna', '1', '22.2'),
    ('žuta', '1', 'žuta', '0', '23.2');
   
INSERT INTO ostavljen (lipa, introvertno, kratkamajica, prstena, zarucnik)
values 
	('12.345', B'1', 'Majica A', '1', 1),
    ('98.765', B'1', 'Majica B', '0', 2),
    ('65.43', B'0', 'Majica C', '1', 3);

INSERT INTO prijateljica (haljina, gustoca, ogrlica, novcica, ostavljen)
values ('Haljina A', 0.12345, 1, 10.5, 1),
    ('Haljina B', 0.98765, 2, 15.2, 2),
    ('Haljina C', 0.65432, 3, 20.8, 3);
   
INSERT INTO mladic (prstena, lipa, narukvica, drugiputa)
VALUES 
    (123, 45.678, true, '2023-06-15 10:30:00'),
    (456, 78.912, false, '2023-06-16 14:45:00'),
    (789, 10.111, true, '2023-06-17 09:15:00');


INSERT INTO zarucnik_mladic (zarucnik, mladic)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
   
   
   
update punica set eura='15.77';

delete from sestra  where hlace<'AB';  

select kratkamajica from ostavljen where introvertno is null;

select a.narukvica, f.stilfrizura, e.gustoca
from mladic a
inner join zarucnik_mladic b on b.mladic=a.sifra 
inner join zarucnik c on c.sifra=b.zarucnik
inner join ostavljen d on c.sifra=d.zarucnik 
inner join prijateljica e on d.sifra=e.ostavljen 
inner join sestra f on e.sifra=f.prijateljica 
where d.introvertno is not null and c.asocijalno is not null 
order by e.gustoca desc;

select asocijalno, modelnaocala from zarucnik
where sifra not in (select zarucnik from zarucnik_mladic);











