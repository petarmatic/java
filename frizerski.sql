drop database if exists frizerski_salon
create table frizerski_salon(
	sifra int not null primary key auto_increment,
	radnovrijeme datetime,
	kontakt varchar(17),
	djelatnik varchar(50),
	naziv varchar(50) not null
);

create table korisnik(
	osoba int not null
);

create table usluga(
	sifra int not null primary key auto_increment,
	djelatnik int not null,
	cijena decimal(10,2)
);

create table osoba(
	sifra int not null primary key auto_increment,
	ime varchar(50),
	prezime varchar(50)
);

create table djelatnik(
	sifra int not null primary key auto_increment,
	frizerskisalon varchar(50),
	osoba int not null,
	iban char(11)
);


alter table korisnik add foreign key (osoba)
references frizerski_salon(sifra);

alter table korisnik add foreign key (osoba) 
references osoba(sifra);

alter table djelatnik add foreign key (osoba)
references osoba(sifra);

alter table korisnik add foreign key (osoba)
references usluga(sifra);

alter table frizerski_salon add foreign key (djelatnik)
references djelatnik(sifra);