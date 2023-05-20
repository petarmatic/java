DROP DATABASE if EXISTS vrtic;
CREATE DATABASE vrtic;
use vrtic;

CREATE TABLE osoba(
    sifra int not null PRIMARY key auto_increment,
    ime VARCHAR(20),
    prezime VARCHAR(20),
    oib CHAR(20)
);

CREATE TABLE odgajateljica(
    sifra int not null PRIMARY key auto_increment,
    osoba INT,
    iban char(15),
    kontakt char(15)
);

CREATE TABLE dijete(
    sifra INT NOT NULL PRIMARY key auto_increment,
    osoba INT,
    odgojnaskupina int,
    roditelj int
);

CREATE table odgojna_skupina(
    sifra int not null PRIMARY key auto_increment,
    odgajateljica int,
    naziv varchar(50)
);

CREATE table djecji_vrtic(
    sifra int not null PRIMARY key auto_increment,
    odgojnaskupina int,
    dijete int not NULL,
    adresa VARCHAR(50),
    radnovrijeme datetime,
    naziv varchar(15),
    kapacitet char(100)
);

CREATE TABLE roditelj(
    sifra int not null primary key auto_increment,
    osoba int not null,
    kontakt char(15),
    email varchar(20)
);

ALTER table odgajateljica add FOREIGN KEY (osoba) REFERENCES osoba(sifra);
ALTER table dijete ADD FOREIGN KEY (odgojnaskupina) REFERENCES odgojna_skupina(sifra);
ALTER TABLE djecji_vrtic ADD FOREIGN KEY (dijete) REFERENCES dijete(sifra);
ALTER table djecji_vrtic ADD FOREIGN KEY (odgojnaskupina) REFERENCES odgojna_skupina(sifra);
ALTER table dijete add FOREIGN KEY (roditelj) REFERENCES roditelj(sifra);
alter table dijete add foreign key (odgojnaskupina) references odgojna_skupina(sifra);
alter table dijete add foreign key (osoba) references osoba(sifra);
alter table odgojna_skupina add foreign key (odgajateljica) references odgajateljica(sifra);
alter table roditelj add foreign key (osoba) references osoba(sifra);
-- dijete
INSERT into osoba (ime,prezime,oib) VALUES ('Marija','Miric',515165151);
-- teta
INSERT into osoba (ime,prezime,oib) VALUES ('Mirna','Mik',225883);
-- mama 
INSERT into osoba (ime,prezime,oib) VALUES ('Marina','Miric',512165151);

insert into odgajateljica (osoba,iban,kontakt) values (2,"HR33333",09199952);

insert into roditelj (osoba, kontakt, email) values (3,0911115,'mammirna@gmail.com');

insert into odgojna_skupina(odgajateljica,naziv) values(1,'p22');

insert into dijete(osoba, odgojnaskupina,roditelj) values (1,null,null);

update dijete set odgojnaskupina = 1 where null;
update dijete set roditelj = 1 where null;

INSERT INTO djecji_vrtic (odgojnaskupina,dijete,adresa,naziv,kapacitet) VALUES (1,1,'Osijek','sunce',27);



