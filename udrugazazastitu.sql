drop database if exists udrugazazastitu;
create database udrugazazastitu;
use udrugazazastitu;

create table osoba(
    sifra int not null primary key,
    ime varchar(20),
    prezime varchar(20),
    kontakt varchar(14)
);

create table sticenik(
    sifra int not null primary key,
    vrsta int,
    visina decimal (3,2),
    masa decimal (3,2),
    briga int not null,
    cip varchar(20),
    dob varchar(2)
);

create table vrsta(
    sifra int not null primary key,
    pas varchar(10), 
    macka varchar(10),
    konj varchar(10)
);

create table prostor(
	sifra int not null primary key,
    sticenik int not null,
    adresa varchar(20)
);

create table udruga(
    sifra int not null primary key,
    osoba int not null,
    sticenik int,
    prostor int 
);

create table briga(
    sifra int not null primary key,
    lijecenje varchar(50),
    cetkanje varchar(20),
    kupanje varchar(10)
);

alter table udruga add foreign key (osoba) references osoba(sifra);
alter table prostor add foreign key (sticenik) references sticenik(sifra);
alter table udruga add foreign key (prostor) references prostor(sifra);
alter table udruga add foreign key (sticenik) references sticenik(sifra);
alter table sticenik add foreign key (vrsta) references vrsta(sifra);
alter table sticenik add foreign key (briga) references briga(sifra);