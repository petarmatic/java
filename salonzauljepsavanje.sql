drop database if exists salonzauljepsavanje;
create database salonzauljepsavanje;
use salonzauljepsavanje;

create table salon(
	sifra int not null primary key,
	radno_vrijeme int,
	djelatnik int,
	naziv varchar(50),
	kontakt varchar(14)	
);

create table korisnik(
	osoba int not null
);

create table osoba(
	sifra int not null primary key,
	ime varchar(50),
	prezime varchar(50),
	godine datetime
);

create table djelatnik(
	sifra int not null primary key,
	salon int,
	iban char(11),
	osoba int not null
);

create table usluga(
	sifra int not null primary key,
	cijena int,
	djelatnik int not null
);

alter table salon add foreign key (radno_vrijeme) references djelatnik(sifra);
alter table djelatnik add foreign key (salon) references usluga(sifra);
alter table korisnik add foreign key (osoba) references osoba(sifra);
alter table usluga add foreign key (cijena) references korisnik(osoba);



