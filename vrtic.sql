DROP DATABASE if EXISTS vrtic;
CREATE DATABASE vrtic;
use vrtic;

CREATE TABLE osoba(
    sifra int not null PRIMARY KEY,
    ime VARCHAR(20),
    prezime VARCHAR(20),
    oib CHAR(20)
);

CREATE TABLE odgajateljica(
    sifra int not null PRIMARY KEY,
    osoba INT,
    iban char(15),
    kontakt char(15)
);

CREATE TABLE dijete(
    sifra INT NOT NULL PRIMARY KEY,
    osoba INT,
    odgojna_skupina int,
    odgajateljica int,
    roditelj int
);

CREATE table odgojna_skupina(
    sifra int not null PRIMARY key,
    odgajateljica not NULL,
    dijete int,
);

CREATE table djecji_vrtic(
    sifra int not null PRIMARY KEY,
    odgajateljica not NULL,
    odgojnaskupina varchar(44),
    dijete int not NULL,
    adresa VARCHAR(50),
    radnovrijeme datetime,
    naziv varchar(15),
    kapacitet char(100)
);

CREATE TABLE roditelj(
    sifra int not null primary key,
    osoba int not null,
    kontakt char(15),
    email varchar(20)
);

ALTER table odgajateljica add FOREIGN KEY (osoba) REFERENCES osoba(sifra);
ALTER table odgojnaskupina ADD FOREIGN KEY (odgajateljica) REFERENCES dijete(sifra);
ALTER TABLE djecji_vrtic add FOREIGN KEY (odgajateljica) references odgajateljica(sifra);
ALTER TABLE djecji_vrtic ADD FOREIGN KEY (dijete) REFERENCES dijete(sifra);
ALTER table djecji_vrtic ADD FOREIGN KEY (odgojnaskupina) REFERENCES odgojna_skupina(sifra);
ALTER table dijete add FOREIGN KEY (roditelj) REFERENCES roditelj(sifra);

INSERT into osoba (ime, prezime, oib) VALUES ('Mirna', 'Miric', '515165151');
INSERT into odgajateljica (osoba) VALUES ('Mima', 'Horvat', '4616565');
INSERT into odgajateljica (iban, kontakt) VALUES ("HR11114512", "09155151");
INSERT into dijete (osoba) VALUES ("Marija", "Horvat", "111515");
INSERT into dijete (odgojna_skupina, odgajateljica, roditelj) values ("misevi", "Mima", "Marta");
INSERT into odgojna_skupina (odgajateljica, dijete) VALUES ("Mima", "Marija");
INSERT INTO djecji_vrtic (odgajateljica, odgojnaskupina, dijete, adresa, radnovrijeme, naziv, kapacitet) VALUES ("Mima", "misevi", "Marija", "osijek", "2.2", "sunce", "26");
INSERT INTO roditelj (osoba, kontakt, email) values ("Marta", "311892", "martamail");