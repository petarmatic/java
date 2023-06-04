c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\lostinvynls.sql
drop database if exists lostinvynls;
CREATE database lostinvynls;
use lostinvynls;

create table korisnicki_racun(
    id int not null PRIMARY key auto_increment,
    ime VARCHAR(50),
    prezime VARCHAR(50),
    email varchar(50)
);

CREATE TABLE ploca(
    id int not null primary key auto_increment,
    naziv varchar(50),
    izvodac varchar(50),
    godina_izdavanja varchar(50),
);

CREATE table prodaja(
    cijena decimal(10,2),
    ploca_id int,
    korisnicki_racunid int,
    FOREIGN key(ploca_id) REFERENCES ploca(id),
    FOREIGN key(korisnicki_racunid) REFERENCES korisnicki_racun(id)
);

CREATE table nabavka(
    ploca_id int,
    korisnicki_racunid int,
    cijena decimal(10,2),
    FOREIGN key(ploca_id) REFERENCES ploca(id),
    FOREIGN key(korisnicki_racunid) REFERENCES korisnicki_racun(id)
);