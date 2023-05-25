-- @@ -1,77 +1,154 @@

# Ovo je komentar


# c:\xampp\mysql\bin\mysql -uroot < C:\Users\Petar\Desktop\java\edunovajp28.sql
 -- putanju  C:\Users\Katedra\D... prilagoditi svojoj datoteci na disku
# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\edunovajp28.sql
-- I ovo je komentar

drop database if exists edunovajp28;
create database edunovajp28;
use edunovajp28;
create table smjer(
	sifra int not null primary key auto_increment,
	naziv varchar(50) not null,
	cijena decimal(18,2),
	upisnina decimal(18,2),
	trajanje int not null,
	verificiran boolean
);


create table grupa(
	sifra int not null primary key auto_increment,
	naziv varchar(50) not null,
	smjer int not null,
	maxpolaznika int,
	predavac int,
	datumpocetka datetime
);

create table predavac(
	sifra int not null primary key auto_increment,
	iban varchar(50),
	osoba int not null
);

create table polaznik(
	sifra int not null primary key auto_increment,
	brojugovora varchar(20),
	osoba int not null
);

create table osoba(
	sifra int not null primary key auto_increment,
	ime varchar(50) not null,
	prezime varchar(50) not null,
	oib char(11),
	email varchar(100)
);

create table clan(
	grupa int not null,
	polaznik int not null
);

alter table grupa add foreign key (smjer)
references smjer(sifra);

alter table grupa add foreign key (predavac)
references predavac(sifra);

alter table predavac add foreign key (osoba)
references osoba(sifra);

alter table polaznik add foreign key (osoba)
references osoba(sifra);

alter table clan add foreign key (polaznik)
references polaznik(sifra);

alter table clan add foreign key (grupa)
references grupa(sifra);





-- najlošija verzija insert naredbe
-- 1
insert into smjer values
(null,'Java programiranje ŠČ',995.42,73,130,true);

-- malo bolji način unosa
-- 2
insert into smjer (naziv,trajanje) values
('Web programiranje',250);

-- primjer dobre prakse (best practice)
-- 3
insert into smjer (sifra,naziv,cijena,
upisnina,trajanje,verificiran) values
(null,'PHP programiranje',850,73,130,false);



insert into osoba (sifra,ime,prezime,oib,email)
values 
-- 1
(null,'Tomislav','Jakopec',null,'tjakopec@gmail.com'),
-- 2 do 26
(null,'Denis','Simov',null,'dsimov19@gmail.com'),
(null,'Ivan','Islentiev',null,'ivanislentiev@hotmail.com'),
(null,'Antonio','Majić',null,'antonio.majich@gmail.com'),
(null,'Kristi','Belić',null,'kristinovoselic@gmail.com'),
(null,'Josip','Belić',null,'josip.belic989@gmail.com'),
(null,'Ivan','Marošević',null,'ivanmarosevic4@gmail.com'),
(null,'Damir','Sučić',null,'dsucic7@gmail.com'),
(null,'Dino','Dješka',null,'dino.djeska@gmail.com'),
(null,'Goran','Kovačić',null,'kovacic.go@gmail.com'),
(null,'Luka','Lijić',null,'lukalijic8@gmail.com'),
(null,'Antonio','Miloloža',null,'milolozaantonio@yahoo.com'),
(null,'Marijan','Kešinović',null,'kesinovic957@gmail.com'),
(null,'Ivan','Kuna',null,'ivan.kuna@yahoo.com'),
(null,'Maksimilian','Bagarić',null,'maxbagaric@gmail.com'),
(null,'Martin','Tetković',null,'marcatet001@gmail.com'),
(null,'Vjeran','Šergo',null,'vjeran.sergo@gmail.com'),
(null,'Filip','Čatić',null,'fcatic031@gmail.com'),
(null,'Petar','Matić',null,'petarmatic00@gmail.com'),
(null,'Branimir','Fekete',null,'branimir.fekete@gmail.com'),
(null,'Lazar','Volarev',null,'lazarv79@gmail.com'),
(null,'Adriana','Plečaš',null,'adriana.plecas@gmail.com'),
(null,'Goran','Franjić',null,'goran@proces.hr'),
(null,'Marko','Ivanović',null,'markoivanovic19@gmail.com'),
(null,'Emina','Vejsilović',null,'emiomiemi@gmail.com'),
(null,'Ana','Jurić',null,'ana.juric19@gmail.com');

-- 1 
insert into predavac (osoba) values (1);

-- 1 do 25
insert into polaznik (osoba) values
(2),(3),(4),(5),(6),(7),(8),(9),(10),
(11),(12),(13),(14),(15),(16),(17),(18),(19),(20),
(21),(22),(23),(24),(25),(26);

-- 1
insert into grupa (naziv,smjer,maxpolaznika,predavac)
values ('JP28',1,25,1);

-- 2
insert into grupa (naziv,smjer,maxpolaznika,predavac)
values ('WP1',2,25,1);

insert into clan (grupa,polaznik) values
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),
(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),
(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),
(1,22),(1,23),(1,24),(1,25);

insert into smjer (naziv,cijena,upisnina,trajanje,verificiran) values ('serviser',1000,100,150,false);

insert into grupa (naziv,smjer,maxpolaznika,predavac) values ('S1',4,33,1);
insert into grupa (naziv,smjer,maxpolaznika,predavac) values ('S2',4,33,1);

insert into osoba (ime,prezime,oib,email) values ('Pero', 'Perić',null,'peric@gmail.com');
insert into osoba (ime,prezime,oib,email) values ('Marija','Jurić',null,'marija.juric19@gmail.com');
insert into osoba (ime,prezime,oib,email) values ('Ivan','Franjić',null,'ivan@proces.hr');

insert into polaznik (osoba) values (27),(28),(29);

update smjer set naziv='Java programiranje' where sifra=1;
update smjer set  cijena=1000, upisnina=50 where sifra=2;
update smjer set cijena=cijena*0.9;
update smjer set cijena=cijena+10;
UPDATE osoba set prezime='Novoselić' where sifra=5;

-- delete from predavac where osoba=1;
 -- delete from grupa where naziv='JP28';

 # do sada smo radili
select * from smjer;
# minimalna forma select naredbe
select 1;
# filtriranje kolona
select naziv, cijena from smjer;
select naziv, sifra, naziv from smjer;
select *, naziv from smjer;
# select lista
# 1. * sve kolone
# 2. naziv kolone
# 3. konstanta
select naziv, 'Osijek' from smjer;
# svakoj koloni se može dati zamjensko ime
select naziv as smjer, 'Osijek' as grad from smjer;
# 4. izraz
select naziv, now() as datum, 2 as velicina, 66.22 as cijena from smjer;
# ispišite imena i prezimena osoba
select ime, prezime from osoba;
# filtriranje redova
select * from osoba;
# koristim operatore
# 1. uperatori uspoređivanja:
# = < > <= >= !=
select * from osoba where sifra=1;
select * from osoba where sifra>=10;
# 2. logički operatori - bool-ovi operatori
select * from osoba where sifra>1 and sifra<3;
select * from osoba where sifra=2 or sifra=3;
select * from osoba where not (sifra>3 and sifra<9);
# Izlistajte mi imena i prezimena svih osoba
# koje se ne zovu Antonio
select ime, prezime from osoba where ime!='Antonio'; 
select ime, prezime from osoba where not ime='Antonio';
# 3. ostali operatori
# like
select * from osoba where ime like 'A%';
select * from osoba where ime like '%a';
-- google način pretraživanja
select * from osoba where ime not like '%a%';
# between - upogoni logički and s uključenim vrijednostima
select * from osoba where sifra>=3 and sifra<=5;
select * from osoba where sifra between 3 and 5;
# in - upogoni logički or
select * from osoba where sifra=2 or sifra=6 or sifra=9;
select * from osoba where sifra in (2,6,9);
# postavite sebi svoj OIB
update osoba set oib='61348493740'
where sifra=1;
# Izlistajte sve osobe koje imaju oib
# operatori is null i is not null
select * from osoba where oib is not null;
# Unesite osobu Shaquille O'Neal
# novije verzije baza dozvoljavaju "
insert into osoba (ime,prezime)
values ("Shaquille","O'Neal");
select * from osoba where ime like 'S%';
# sve verzije baza
insert into osoba (ime,prezime)
values ('Shaquille','O\'Neal');



