create database ass;
use ass;
create table role (
id int primary key,
name varchar(255)
);

create table User(
id int primary key auto_increment, 
email varchar(255),
full_name varchar(255),
note varchar(255),
password varchar(255),
phone_number varchar(255), 
status varchar(255),
user_name varchar(255),
created varchar(255),
role_id int, 
foreign key(role_id) references role(id));

create table donation(
id int primary key auto_increment, 
code varchar(255),
created varchar(255),
description varchar(255),
end_date varchar(255),
money int, 
name varchar(255),
organization_name varchar(255),
phone_number varchar(255),
start_date varchar(255),
status int
);

 create table user_donation(
id int primary key auto_increment, 
created varchar(255),
money int, 
name varchar(255),
status varchar(255),
text varchar(255),
donation_id int,
user_id int, 
foreign key(user_id) references User(id),
foreign key(donation_id) references donation(id)
);
INSERT INTO role (id, name)
VALUES (1, "admin"), (2,"user");

INSERT INTO donation (code,
created , 
description,
end_date,
money ,
name,
organization_name,
phone_number,
start_date,
status)
VALUES ("code", "name","description","end_date",1,"name","orgnization_name","phone_number","start_date",1);

INSERT INTO user (email,
full_name , 
note,
password,
phone_number ,
status,
user_name,
created,
role_id
)
VALUES ("email", "full_name","note","password","phone_number","status","user_name","created",1);
INSERT INTO user_donation (created,
money , 
name,
status,
text ,
donation_id,
user_id
)
VALUES ("created", 1,"name","status","text",1,3);
