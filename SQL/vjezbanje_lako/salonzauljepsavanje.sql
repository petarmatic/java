-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\salonzauljepsavanje.sql

drop database if exists salonzauljepsavanje;
create database salonzauljepsavanje;
use salonzauljepsavanje;

create table salon(
	sifra int not null primary key auto_increment,
	naziv varchar(50),
	kontakt varchar(14)	
);

create table korisnik(
	osoba int not null primary key auto_increment,
	djelatnik int
);

create table osoba(
	sifra int not null primary key auto_increment,
	ime varchar(50),
	prezime varchar(50),
	godine year
);

create table djelatnik(
	sifra int not null primary key auto_increment,
	salon int,
	iban char(11),
	osoba int 
);

create table usluga(
	sifra int not null primary key auto_increment,
	cijena decimal(4.3),
	djelatnik int
);


alter table djelatnik add foreign key (salon) references salon(sifra);
alter table djelatnik add foreign key (osoba) references osoba(sifra);
alter table korisnik add foreign key (osoba) references osoba(sifra);
alter table korisnik add foreign key (djelatnik) references djelatnik(sifra);
alter table usluga add foreign key (djelatnik) references djelatnik(sifra);

insert into osoba(ime,prezime,godine) values('Marija','Miki','22');
insert into osoba(ime,prezime,godine) values('Mara','Mikic','23');
insert into osoba(ime,prezime,godine) values('Tarija','Mikić','24');
insert into osoba(ime,prezime,godine) values('Sarija','Mikić','24');
insert into osoba(ime,prezime,godine) values('Karija','Mikić','24');
insert into osoba(ime,prezime,godine) values('Larija','Mikić','24');

insert into salon(naziv,kontakt) values('Boja','65555');
insert into salon(naziv,kontakt) values('Loja','65511155');
insert into salon(naziv,kontakt) values('Koja','6555115');

insert into djelatnik(salon,iban,osoba) values(1,'HR55555555',1);
insert into djelatnik(salon,iban,osoba) values(2,'HR5555555',2);
insert into djelatnik(salon,iban,osoba) values(3,'HR555555',3);

insert into korisnik(osoba,djelatnik) values(1,1);
insert into korisnik(osoba,djelatnik) values(2,2);
insert into korisnik(osoba,djelatnik) values(3,3);

insert into usluga(cijena,djelatnik) values('33',1);
insert into usluga(cijena,djelatnik) values('34',2);
insert into usluga(cijena,djelatnik) values('53',3);








