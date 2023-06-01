--c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\rap.sql

drop database if exists rap;
create database rap;
use rap;

CREATE table autor(
    id int not null PRIMARY key auto_increment,
    album VARCHAR(44),
    umjetnicko_ime varchar(20) not null,
    koncert int,
    drustevene_mreze text,
    email VARCHAR(50)
);

CREATE table album(
    id int not null primary key auto_increment,
    naziv varchar(50)
);

create table pjesma(
    id int not null primary key auto_increment,
    naziv varchar(20),
    album int
);

CREATE table koncert(
    id int not null primary key auto_increment,
    vrijeme datetime,
    mjesto varchar(40)
);

CREATE table download(
    pjesma int,
    album int
);

CREATE table vijesti(
    autor int,
    album int,
    koncert int,
    tekst text,
    video_materijal text
);

alter table pjesma add FOREIGN key(album) REFERENCES album(id);
alter table download add FOREIGN key(pjesma) REFERENCES pjesma(id);
alter table download add FOREIGN key(album) REFERENCES album(id);
alter table vijesti add FOREIGN key(autor) REFERENCES autor(id);
alter table vijesti add FOREIGN key(album) REFERENCES album(id);
alter table vijesti add FOREIGN key(koncert) REFERENCES koncert(id);
