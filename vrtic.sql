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
    odgojna_skupina int,
    odgajateljica int,
    roditelj int
);

CREATE table odgojna_skupina(
    sifra int not null PRIMARY key auto_increment,
    odgajateljica int,
    dijete int
);

CREATE table djecji_vrtic(
    sifra int not null PRIMARY key auto_increment,
    odgajateljica int,
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
ALTER table odgojna_skupina ADD FOREIGN KEY (odgajateljica) REFERENCES dijete(sifra);
ALTER TABLE djecji_vrtic add FOREIGN KEY (odgajateljica) references odgajateljica(sifra);
ALTER TABLE djecji_vrtic ADD FOREIGN KEY (dijete) REFERENCES dijete(sifra);
ALTER table djecji_vrtic ADD FOREIGN KEY (odgojnaskupina) REFERENCES odgojna_skupina(sifra);
ALTER table dijete add FOREIGN KEY (roditelj) REFERENCES roditelj(sifra);

INSERT into osoba (ime, prezime, oib) VALUES (1,'Marija', 2,'Miric', 3,'515165151',);

INSERT into dijete (osoba) VALUES (1, 'Marija');
INSERT into dijete (odgojna_skupina) values (2,'misevi');
INSERT into dijete (odgajateljica) values (3, 'Mima');
INSERT into dijete (roditelj) values (4, 'Marta');

INSERT into odgajateljica (osoba) VALUES (1, 'Mima');
INSERT into odgajateljica (iban) VALUES (1, '4616565');
INSERT into odgajateljica (kontakt) VALUES (1, "09155151");
INSERT into odgojna_skupina (odgajateljica) VALUES (1, 'Mima');
INSERT into odgojna_skupina (dijete) VALUES (1, 'Marija');

INSERT INTO djecji_vrtic (odgajateljica) VALUES (1, 'Mima');
INSERT INTO djecji_vrtic (odgojnaskupina) VALUES (1, 'misevi');
INSERT INTO djecji_vrtic (dijete) VALUES (1, 'Marija');
INSERT INTO djecji_vrtic (adresa) VALUES (1, 'osijek');
INSERT INTO djecji_vrtic (radnovrijeme) VALUES (1, '2.2');
INSERT INTO djecji_vrtic (naziv) VALUES (1, 'sunce');
INSERT INTO djecji_vrtic (kapacitet) VALUES (1, '26');

INSERT INTO roditelj (osoba, kontakt, email) values (1, 'Marta', '311892', 'martamail');