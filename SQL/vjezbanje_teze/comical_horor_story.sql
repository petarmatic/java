-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\comical_horor_story.sql

drop database if exists comical_horor_story;
CREATE database comical_horor_story;
use comical_horor_story;

create table informacije(
    novosti text,
    verzija_igre decimal(2,2),
    galerija int
);

CREATE table galerija(
    sifra int not null primary key auto_increment,
    naziv VARCHAR(55),
    slika varchar(255)
);

create table korisnik(
    registracija int,
    ime VARCHAR(50),
    prezime varchar(55)
);

CREATE table registracija(
    sifra int not null primary key auto_increment,
    email varchar(50),
    prijava int
);

CREATE table prijava(
    sifra int not null PRIMARY KEY auto_increment,
    korisnicko_ime VARCHAR(50),
    lozinka VARCHAR(50)
);

alter table informacije add foreign key  (galerija) REFERENCES galerija(sifra);
alter table korisnik add FOREIGN key (registracija) REFERENCES registracija(sifra);
ALTER table registracija add FOREIGN key (prijava) REFERENCES prijava(sifra);

INSERT into prijava(korisnicko_ime,lozinka) VALUEs('exox','exox2');
insert into registracija(email,prijava) values('matko@gmail.com',1);
insert into korisnik(registracija,ime,prezime) VALUES(1,'Matko','Matković');
INSERT INTO galerija(naziv,slika) VALUEs('walls','neka slika');
INSERT into informacije(novosti,verzija_igre,galerija) values('neki tekst','5.6',1);