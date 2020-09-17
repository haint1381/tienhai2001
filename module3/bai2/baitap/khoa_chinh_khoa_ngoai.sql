drop database if exists account_management;
create database account_management;
use account_management;
create table Customers(
 customer_number int unique auto_increment primary key,
 fullname varchar(250),
 address varchar(250),
 email varchar(250) unique,
 phone  varchar(12) unique
);
use account_management;
create table Accounts(
account_number varchar(12) primary key ,
account_type varchar(250),
date_account date,
balance double,
customer_number int not null unique ,foreign key  (customer_number)	references customers(customer_number)
);
use account_management;
create table Transactions (
tran_number int auto_increment primary key,
account_number varchar(12),
date_account date,
amounts double,
descriptions varchar(250),
customer_number	int,	FOREIGN	KEY	(customer_number)	REFERENCES customers(customer_number)
);
