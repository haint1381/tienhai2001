drop database if exists class_1;
create database class_1;
use class_1;
create table student(
id int primary key,
full_name varchar(250),
address varchar (250)
);
create table point_student(
math_point int,
physical_point int,
full_name1 varchar(250),
student_id int unique,foreign key(student_id) references student(id)
);
insert into student values (1,'nhật','lào cai'),(3,'hoàng','vô gia cư'),(2,'hải','hà tĩnh');
insert into point_student values (2,2,'nhật',1),(10,10,'hải',2);

select *from student 
inner join point_student on student.id = point_student.student_id;

select *from student 
left join point_student on student.id = point_student.student_id;

select *from student 
right join point_student on student.id = point_student.student_id;

select *from student 
left join point_student on student.full_name = point_student.full_name1
union
select *from student 
right join point_student on student.full_name = point_student.full_name1;