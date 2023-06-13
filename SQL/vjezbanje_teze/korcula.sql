-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\korcula.sql
drop database if exists korcula;
CREATE database korcula;
use korcula;

CREATE table udruga(
    id int not null PRIMARY key auto_increment,
    naziv varchar(30),
    adresa varchar(50)
);

create table novost(
    id int not null PRIMARY KEY auto_increment,
    dogadaj varchar(30),
    datum datetime,
    sadrzaj text,
    udruga INT
);

CREATE table student(
    id int not null PRIMARY key auto_increment,
    udruga int,
    ime varchar(30),
    prezime varchar(30)
);

create table obrazac(
    sadrzaj text,
    student int
);

alter TABLE novost add FOREIGN KEY(udruga) REFERENCES udruga(id);
alter table student add FOREIGN key (udruga) REFERENCES udruga(id);
ALTER table obrazac add FOREIGN key(student) REFERENCES student(id);