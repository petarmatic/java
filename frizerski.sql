drop database if exists frizerski;
create database frizerski;
use frizerski;
create table frizerski_salon(
	sifra int not null primary key auto_increment,
	radnovrijeme datetime,
	kontakt varchar(17),
	naziv varchar(50) not null
);

create table korisnik(
	osoba int
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
	osoba int,
	iban char(11)
);

alter table korisnik add foreign key (osoba)
references frizerski_salon(sifra);

ALTER TABLE korisnik ADD FOREIGN KEY (osoba) REFERENCES osoba(sifra);

alter table djelatnik add foreign key (osoba)
references osoba(sifra);

alter table korisnik add foreign key (osoba)
references osoba(sifra);


insert into osoba (ime,prezime) values ('Marko', 'Marić');
insert into osoba (ime,prezime) values ('Silvija', 'Golub');
insert into osoba (ime,prezime) values ('Lana', 'Mitić');
insert into osoba (ime,prezime) values ('Lara', 'Mitić');
insert into osoba (ime,prezime) values ('Lora', 'Mitić');
insert into osoba (ime,prezime) values ('Ana', 'Mitić');

insert into frizerski_salon(radnovrijeme,kontakt,naziv) values(2023-5-1,55525,'Šiške');
insert into frizerski_salon(radnovrijeme,kontakt,naziv) values(2023-7-1,555525,'Kosa');
insert into frizerski_salon(radnovrijeme,kontakt,naziv) values(2023-6-1,556525,'Škare');

insert into korisnik(osoba) values(1);
insert into korisnik(osoba) values(2);
insert into korisnik(osoba) values(3);

insert into djelatnik(frizerskisalon,osoba,iban) values(1,4,'HR4444');
insert into djelatnik(frizerskisalon,osoba,iban) values(1,5,'HR44454');
insert into djelatnik(frizerskisalon,osoba,iban) values(1,6,'HR44464');

insert into usluga(djelatnik,cijena) values(4,88);
insert into usluga(djelatnik,cijena) values(5,44);
insert into usluga(djelatnik,cijena) values(6,55);

update djelatnik set iban='HR555532332' where sifra=1;
update djelatnik set iban='HR5555332' where sifra=2;
update djelatnik set iban='HR553233' where sifra=3;

update osoba set ime='Mata',prezime='Milć' where sifra=1;
update osoba set ime='Anja',prezime='Milković' where sifra=2;
update osoba set ime='Tija',prezime='Modrić' where sifra=3;

delete from djelatnik  where iban='HR555532332';

