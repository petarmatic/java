--c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\e_l_k.sql

drop database if exists e_l_k;
create database e_l_k;
use e_l_k;

CREATE table registracija(
    sifra int not null primary key auto_increment,
    nadimak VARCHAR(30) not null,
    lozinka varchar(43) not NULL,
    email varchar(59) not NULL
);

create table informacija(
    sifra int not null primary key auto_increment,
    naslov varchar(44),
    autor varchar(44),
    mjesto varchar(44),
    izdavac varchar(56),
    link varchar(255)
);
CREATE table pretrazivanje(
    registracija int,
    informacija INT
);

alter table pretrazivanje add foreign KEY(registracija) REFERENCES registracija(sifra);
alter table pretrazivanje add FOREIGN key(informacija) REFERENCES informacija(sifra);
