drop database if exists my_student;
create database my_student;
use my_student;
create table student(
id int auto_increment primary key,
full_name varchar (250),
age int ,check (18<age<100),
course varchar(250),
money int(3)
);
insert into student values
(1,'viet',21,'cntt',400000),
(2,'hoàng',19,'dtvt',320000),
(3,'nhật',18,'ktdn',400000),
(4,'hải',19,'ck',450000),
(5,'hương',20,'tcnh',500000),
(6,'hương',20,'tcnh',200000);

select *from student where student.full_name='hương';

select sum(money) from student where student.full_name = 'hương';

select distinct student.full_name from student;