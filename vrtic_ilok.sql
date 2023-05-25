-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\vrtic_ilok.sql

drop database if exists vrtic_ilok;
create database vrtic_ilok;
use vrtic_ilok;

CREATE table vrtic(
    sifra int not null PRIMARY key auto_increment,
    naziv varchar(44),
    adresa varchar(44)
);

CREATE table prijava(
	sifra int not null primary key auto_increment,
    ime_djeteta VARCHAR(44) not null,
    prezime_djeteta varchar(44) not null,
    oib VARCHAR(44),
    ime_roditelja varchar(44) not null,
    prezime_roditelja varchar(33) not null,
    kontakt varchar(55) not null,
    dob varchar(33),
    vrtic int
);

CREATE table dogadaj(
    sifra int not NULL PRIMARY key auto_increment,
    datum datetime,
    galerija NVARCHAR(1000),
    sadrzaj TEXT,
    vrtic int
);

CREATE table odgojna_skupina(
    naziv VARCHAR(44),
    vrtic int
);

ALTER table prijava add FOREIGN key(vrtic) REFERENCES vrtic(sifra);
ALTER table dogadaj add FOREIGN key(vrtic) REFERENCES vrtic(sifra);
alter table odgojna_skupina add FOREIGN key(vrtic) REFERENCES vrtic(sifra);

insert into vrtic(naziv,adresa) values('Marica','Osijek');
insert into prijava(ime_djeteta,prezime_djeteta,oib,ime_roditelja,prezime_roditelja,kontakt,dob,vrtic) 
VALUES('Marko','Marić','225883','Zdenka','Marić','09152648','2',1);
insert into prijava(ime_djeteta,prezime_djeteta,oib,ime_roditelja,prezime_roditelja,kontakt,dob,vrtic) 
VALUES('Ivanko','Mari','221883','Marija','Mari','09152648','2',1);
insert into prijava(ime_djeteta,prezime_djeteta,oib,ime_roditelja,prezime_roditelja,kontakt,dob,vrtic) 
VALUES('Jan','Jumić','225883','Mihael','Jumić','09152648','2',1);
insert into prijava(ime_djeteta,prezime_djeteta,oib,ime_roditelja,prezime_roditelja,kontakt,dob,vrtic) 
VALUES('Matej','Hanžek','225883','Matej','Hanžek','09152648','2',1);
insert into prijava(ime_djeteta,prezime_djeteta,oib,ime_roditelja,prezime_roditelja,kontakt,dob,vrtic) 
VALUES('Fran','Mucak','225883','Ivona','Mucak','09152648','2',1);
INSERT into dogadaj(datum,galerija,sadrzaj,vrtic) values('2023-22-5','slika','Dječji vrtić "Crvenkapica" jedini vrtić u najistočnijem gradu u Hrvatskoj, u Iloku, 
otvoren je davne 1889. godine i kroz njega su prošle brojne generacije djece',1);
INSERT into odgojna_skupina(naziv,vrtic) VALUES('Mali',1);

update prijava set ime_roditelja='Zdravko' where sifra=1;

-- delete from prijava where prezime_roditelja='Marić';

select ime_djeteta,prezime_djeteta from prijava;
select ime_djeteta,prezime_djeteta,ime_djeteta from prijava;
select *, ime_djeteta from prijava; -- sve kolone

select ime_djeteta, 'Sara' from prijava;
select ime_djeteta as prezime_djeteta, 'Netko' as osoba from prijava;

select ime_djeteta, now() as ime_roditelja, 3 as potomak, 'Novi' as prezime_roditelja from prijava;

select ime_djeteta, prezime_djeteta from prijava;

select ime_roditelja,prezime_roditelja from prijava where ime_roditelja!='Jan';

select * from prijava where ime_djeteta like 'A%';

select * from prijava where ime_djeteta like '%n';

select * from prijava where sifra<=2 and sifra<=4;

select * from prijava where sifra=1 or sifra=4;
select * from prijava where sifra in (1,3);


select * from prijava where oib is not null;







