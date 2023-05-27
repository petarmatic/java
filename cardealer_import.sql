-- c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < C:\Users\Petar\Desktop\java\cardealer_import.sql

drop database if EXISTS cardealer_import;
CREATE database cardealer_import;
use cardealer_import;

CREATE table customer(
    id int not null PRIMARY key auto_increment,
    budget decimal(7.2),
    first_name varchar(50),
   last_name varchar(50)
);

CREATE table selling_spot(
    id int not null primary key auto_increment,
   `name` varchar(50) not null,
    `address` varchar(50) not null,
    seller int 
);


CREATE table seller(
    id int not null primary key auto_increment,
    first_name VARCHAR(50) not null,
    last_name varchar(50) not null
);

CREATE table bill(
   customer int,
    vehicle INT,
    seller INT
);

CREATE table vehicle(
    id int not null PRIMARY key auto_increment,
    price decimal(7.2) not null,
    selling_spot int
);

alter table selling_spot add FOREIGN key(seller) REFERENCES seller(id);
alter table bill add FOREIGN key(customer) REFERENCES customer(id);
alter table bill add foreign key(vehicle) REFERENCES vehicle(id);
alter table bill add FOREIGN key(seller) REFERENCES seller(id);
alter table vehicle add FOREIGN key(selling_spot) REFERENCES selling_spot(id);

insert into customer(budget,first_name,last_name) values('10000','Marko','Horvat');
INSERT into seller(first_name,last_name) values('Stjepan','Martinov');
INSERT into selling_spot(`name`,`address`,seller) values('Autokuća Import','Industrijska zona 35 Osijek',1);
insert into vehicle(price,selling_spot) values('9800',1);
INSERT into bill(customer,vehicle,seller) values(1,1,1);