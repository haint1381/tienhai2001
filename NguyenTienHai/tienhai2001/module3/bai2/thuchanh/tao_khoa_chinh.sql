drop database if exists ALOALO;
create database ALOALO;
use ALOALO;
CREATE TABLE users(
   user_id INT  AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255)
);
use ALOALO;
CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);
use ALOALO;
CREATE TABLE roles1(
   role1_id INT ,
   namefull varchar(30)
);
use ALOALO;
CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id),
   FOREIGN KEY(role_id) REFERENCES roles(role_id)
);
ALTER TABLE roles1
    ADD PRIMARY KEY(role1_id,namefull);
    