-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vjezbanje_teze\kuhanje.sql

drop database if exists kuhanje;
CREATE database kuhanje;
use kuhanje;

CREATE table namirnica(
    id int not null primary key auto_increment,
    naziv varchar(30),
    kalorije DECIMAL(3,2)
);

create table recept(
    id int not null PRIMARY key auto_increment,
    uputa text,
    naziv varchar(30),
    vrijeme TIME
);

CREATE table recept_namirnica(
    namirnica int,
    recept int,
    FOREIGN KEY (namirnica) REFERENCES namirnica(id),
    FOREIGN key (recept) REFERENCES recept(id)
);
