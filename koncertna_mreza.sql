-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\koncertna_mreza.sql

drop database if exists koncertna_mreza;
CREATE database koncertna_mreza;
use koncertna_mreza;

create table koncert(
    sifra int not null primary key auto_increment,
    adresa varchar(50) not null,
    vrijeme datetime not null,
    cijena decimal(3.2) not null
);

create table korisnicki_racun(
    sifra int not null primary key auto_increment,
    ime VARCHAR(44) not null,
    prezime VARCHAR(44) not null,
    email VARCHAR(50) not null
);

CREATE table rezervacija(
    korisnicki_racun int,
    koncert int,
    broj_karata VARCHAR(10)
    );

CREATE table fotografija(
    koncert int,
    slika VARCHAR(255),
    tekst TEXT
);

create table interes(
    korisnicki_racun int,
    koncert int
);

alter table rezervacija add foreign key (korisnicki_racun) REFERENCES korisnicki_racun(sifra);
ALTER table rezervacija add FOREIGN key (koncert) REFERENCES koncert(sifra);
alter table fotografija add foreign key (koncert) REFERENCES koncert(sifra);
ALTER table interes add FOREIGN key(korisnicki_racun) REFERENCES korisnicki_racun(sifra);
ALTER table interes add FOREIGN KEY(koncert) REFERENCES koncert(sifra);

insert into koncert(adresa,vrijeme,cijena) values('Osijek','2023-5-27','20');
insert into korisnicki_racun(ime,prezime,email) values('Petar','Matić','petarmatic00@gmail.com');
insert into rezervacija(korisnicki_racun,koncert,broj_karata) values(1,1,'10');
insert into fotografija(koncert,slika,tekst) values (1,'Neka slika nešto','Koncertna mreža je projekt koji svojim korisnicima omogućuje i pruža najnovije informacije vezane za glazbena
 događanja i koncerte na državnoj, ali za one koje žele više, i na međunarodnoj razini. S jedne strane korisnici mogu saznati kada, gdje, kako i po kojoj cijeni mogu 
 otići na željeni koncert, te putem svog korisničkog računa  rezervirati svoje karte na vrijeme. Također, prednost je što mogu upoznati i druge ljude sličnih interesa 
 te se s njima dogovarati oko prijevoza i slično. Poslužitelj će s druge strane izvještavati o prošlim događanjima te postaviti fotografije kako bi onima koji nisu prisustvo');