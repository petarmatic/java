-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\baby.sql

drop database if exists baby;
CREATE database baby;
use baby;

create table beba(
    sifra int not null primary key auto_increment
);

CREATE table dnevna_aktivnost(
    beba int,
    jelo datetime,
    pice DATETIME,
    spavanje_od datetime,
    spavanje_do DATETIME
);

CREATE table vazni_dogadaj(
    beba int,
    glava_uspravno datetime,
    samostalno_sjedenje datetime,
    hodanje datetime,
    ostalo text
);

CREATE table zdravstveni_kutak(
    beba int,
    pojava_zubica datetime,
    cijeplje datetime,
    doktor DATETIME
);

alter table dnevna_aktivnost add FOREIGN KEY(beba) REFERENCES beba(sifra);
ALTER table vazni_dogadaj add FOREIGN key(beba) REFERENCES beba(sifra);
alter table zdravstveni_kutak add FOREIGN key(beba) REFERENCES beba(sifra);
