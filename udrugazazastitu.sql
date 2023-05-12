drop database base if exists udruzazazastitu;
create database udruzazazastitu;
use udruzazazastitu;

create table osoba (
    sifra int not null auto_increment,
    ime varchar(20),
    prezime varchar(20),
    kontakt varchar(14)

);
