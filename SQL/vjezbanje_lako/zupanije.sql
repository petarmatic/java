drop database if exists zupanije;
create database zupanije;
use zupanije;

create table zupanija(
	sifra int not null primary key auto_increment,
	naziv varchar(50),
	zupan int
);

create  table zupan(
	sifra int not null primary key auto_increment,
	ime Varchar(50),
	prezime varchar(50)
);

create table opcina(
	sifra int not null primary key auto_increment,
	zupanija int,
	naziv varchar(50)
);

create table mjesto(
	sifra int not null primary key auto_increment,
	opcina int,
	naziv varchar(50)
);

alter table opcina add foreign key (zupanija) references zupanija(sifra);
alter table zupanija add foreign key (zupan) references zupan(sifra);
alter table mjesto add foreign key (opcina) references opcina(sifra);

#Osjecko-baranjska zupanija

insert into zupan(ime, prezime) values('Ivan', 'Anusic');

insert into zupanija(naziv, zupan) values('Osjecko-baranjska', 1);

insert into opcina (zupanija, naziv) values (1, 'Ceminac');
insert into mjesto(opcina, naziv) values (1, 'Grabovac');
insert into mjesto(opcina, naziv) values (1,  'Ceminac');

insert into opcina(zupanija, naziv) values (1, 'Darda');
insert into mjesto(opcina, naziv) values (2, 'Uglješ');
insert into mjesto(opcina, naziv) values (2, 'Darda');

insert into opcina(zupanija, naziv) values (1, 'Bilje');
insert into mjesto(opcina, naziv) values (3, 'Bilje');
insert into mjesto(opcina, naziv) values (3, 'Lug');

insert into opcina(zupanija, naziv) values (1, 'Knezevei Vinogradi');
insert into mjesto(opcina, naziv) values (4, 'Karanac');
insert into mjesto(opcina, naziv) values (4, 'Knezevi Vinogradi');

insert into opcina(zupanija, naziv) values (1, 'Draz');
insert into mjesto(opcina, naziv) values (5,'Suza');
insert into mjesto(opcina, naziv) values (5, 'Batina');

insert into opcina(zupanija, naziv) values (1, 'Petlovac');
insert into mjesto(opcina, naziv) values (6, 'Petlovac');
insert into mjesto(opcina, naziv) values (6, 'Baranjsko Petrovo Selo');

#Pozesko-slavonska

insert into zupan(ime, prezime) values('Igor', 'Androvic');

insert into zupanija(naziv, zupan) values('Viroviticko-podravska', 2);

insert into opcina (zupanija, naziv) values (2, 'Sugopolje');
insert into mjesto(opcina, naziv) values (1, 'Borova');
insert into mjesto(opcina, naziv) values (1,  'Bukova');

insert into opcina(zupanija, naziv) values (2, 'Zdenci');
insert into mjesto(opcina, naziv) values (2, 'Bankovci');
insert into mjesto(opcina, naziv) values (2, 'Kutovi');

insert into opcina(zupanija, naziv) values (2, 'Sopje');
insert into mjesto(opcina, naziv) values (3, 'Josipovo');
insert into mjesto(opcina, naziv) values (3, 'Kapinci');

insert into opcina(zupanija, naziv) values (2, 'Gradina');
insert into mjesto(opcina, naziv) values (4, 'Lipovac');
insert into mjesto(opcina, naziv) values (4, 'Brezovica');

insert into opcina(zupanija, naziv) values (2, 'Crnac');
insert into mjesto(opcina, naziv) values (5,'Milanovac');
insert into mjesto(opcina, naziv) values (5, 'Suha Mlaka');

insert into opcina(zupanija, naziv) values (2, 'Vocin');
insert into mjesto(opcina, naziv) values (6, 'Bokane');
insert into mjesto(opcina, naziv) values (6, 'Hum');

#Sisacko-moslavacka

insert into zupan(ime, prezime) values('Ivan', 'Celjak');

insert into zupanija(naziv, zupan) values('Sisacko-moslavacka', 3);

insert into opcina (zupanija, naziv) values (3, 'Dvor');
insert into mjesto(opcina, naziv) values (1, 'Gage');
insert into mjesto(opcina, naziv) values (1, 'Javnica');

insert into opcina(zupanija, naziv) values (3, 'Gvozd');
insert into mjesto(opcina, naziv) values (2, 'Dugo Selo');
insert into mjesto(opcina, naziv) values (2, 'Kirin');

insert into opcina(zupanija, naziv) values (3, 'Lekenik');
insert into mjesto(opcina, naziv) values (3, 'Stari Brod');
insert into mjesto(opcina, naziv) values (3, 'Donji Vukojevac');

insert into opcina(zupanija, naziv) values (3, 'Lipovljani');
insert into mjesto(opcina, naziv) values (4, 'Piljenice');
insert into mjesto(opcina, naziv) values (4, 'Krivaj');

insert into opcina(zupanija, naziv) values (3, 'Majur');
insert into mjesto(opcina, naziv) values (5,'Stubalj');
insert into mjesto(opcina, naziv) values (5, 'Gornji Hrastovac');

insert into opcina(zupanija, naziv) values (3, 'Sunja');
insert into mjesto(opcina, naziv) values (6, 'Bestrma');
insert into mjesto(opcina, naziv) values (6, 'Bobovac');

update mjesto set naziv = 'Novi Ceminac' where 'Grabovac';
update mjesto set naziv = 'Kozarac' where 'Ceminac';
update mjesto set naziv = 'Vardarac' where 'Bilje';
update mjesto set naziv = 'Lug' where 'Kopacevo';
update mjesto set naziv = 'Karanac' where 'Kamenac';


delete from opcina where 'Ceminac';
delete from opcina where 'Darda';














