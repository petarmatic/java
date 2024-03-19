create table rods (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
	price DECIMAL(10, 2),
	length decimal(2,2)
);

create table reels(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10, 2),
    line_capacity int
);

create table nylon(
	id int auto_increment primary key,
    name VARCHAR(100),
    nylon_thickness decimal(3,2),
     price DECIMAL(10, 2)
);

create table groundbaits(
	type VARCHAR(100),
    price DECIMAL(10, 2)
);

create table bags(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10, 2)
);

