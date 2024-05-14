drop database if exists webshop;
create database webshop;

use webshop;

CREATE table jackets(
    id int not null PRIMARY key auto_increment,
    name VARCHAR(255),
    price DOUBLE
    
);

CREATE table pants(
    id int not null PRIMARY key auto_increment,
    name VARCHAR(255),
    price DOUBLE
    
);
CREATE table shirts(
    id int not null PRIMARY key auto_increment,
    name VARCHAR(255),
    price DOUBLE
    
);