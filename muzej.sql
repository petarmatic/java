drop database if exists muzej;
create database muzej;
use muzej;

create table muzej(
	sifra int not null primary key auto_increment,
	naziv varchar(50),
	adresa varchar(50)
);

create table osoba(
	sifra int not null primary key auto_increment,
	ime varchar(50),
	prezime varchar(50)
);

create table djela(
	sifra int not null primary key auto_increment,
 	naziv varchar(50),
 	autor int
);

create table izlozba(
	sifra int not null primary key auto_increment,
	muzej int,
	naziv_izlozbe varchar(49),
	djela int
);


create table kustos(
	izlozba int,
	osoba int
);

create table sponzor(
	izlozba int,
	ime_sponzora varchar(50)
);

alter table izlozba add foreign key (muzej) references muzej(sifra);
alter table izlozba add foreign key (djela) references djela(sifra);
alter table djela add foreign key (autor) references osoba(sifra);
alter table kustos add foreign key (izlozba) references izlozba(sifra);
alter table sponzor add foreign key (izlozba) references izlozba(sifra);
alter table kustos add foreign key (osoba) references osoba(sifra);

insert into muzej(naziv, adresa) values ('Stari Top', 'Ulica 33 Osijek');
-- kustos
insert into osoba(ime,prezime) values ('Marko', 'Maulić');
insert into osoba(ime,prezime) values ('Marko', 'Malić');
insert into osoba(ime,prezime) values ('Marko', 'Maić');
-- autor
insert into osoba(ime,prezime) values ('Marko', 'Mauić');
insert into osoba(ime,prezime) values ('Marko', 'Maul');
insert into osoba(ime,prezime) values ('Marko', 'Mau');

insert into djela(naziv,autor) values ('More',4);
insert into djela(naziv,autor) values ('Sunce',5);
insert into djela(naziv,autor) values ('Nebo',6);

insert into izlozba(muzej, naziv_izlozbe,djela) values (1, 'Brod', 1);
insert into izlozba(muzej, naziv_izlozbe,djela) values (1, 'Suncokret', 2);
insert into izlozba(muzej, naziv_izlozbe,djela) values (1, 'Avion', 3);

insert into kustos (izlozba,osoba) values (1,1);
insert into kustos (izlozba,osoba) values (2,2);
insert into kustos (izlozba,osoba) values (3,3);

insert into sponzor (izlozba,ime_sponzora) values (1,'Dukat.doo');
insert into sponzor (izlozba,ime_sponzora) values (2,'Belje.doo');
insert into sponzor (izlozba,ime_sponzora) values (3,'Osječko pivo.doo');