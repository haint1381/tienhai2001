drop database if exists manage_library;
create database manage_library;
use manage_library;

create table borrow_order(
	form_code varchar(50) primary key,
	borrowing_day date,
	book_code varchar(50),
	student_number varchar(15),
	pay_day date
);
create table student(
	student_number varchar(15) primary key,
	student_name varchar(50),
	address varchar(500),
	email varchar(50),
	image varchar(500),
    form_code varchar(50),
    foreign key(form_code) references borrow_order(form_code)
);
create table category(
     book_category varchar(250) primary key
);
create table book(
	book_code varchar(50) primary key,
	book_name varchar(500),
	publish  varchar(500),
	author  varchar(500),
	publishing_year year,
	number_of_publications int,
	price double,
	image varchar(500),
	book_category varchar(500),
    form_code1 varchar(50),
	foreign key(book_category) references category(book_category)
);
create table borrow_details(
	student_number1 varchar(15),
	book_code1 varchar(50),
	foreign key(student_number1) references student(student_number),
	foreign key(book_code1) references book(book_code)
);
insert into borrow_order values 
	('1a','2020-01-01','1d','1b','2020-02-01'),
	('2a','2020-02-01','2d','2b','2020-03-01'),
	('3a','2020-03-01','3d','3b','2020-04-01'),
	('4a','2020-04-01','4d','4b','2020-05-01'),
	('5a','2020-05-01','5d','5b','2020-06-01');
insert into student values
	('1b','Tiến Hải','Hà Tĩnh','tienhai@gmail.com','abcxyz','1a'),
	('2b','Tiến Hải1','Hà Tĩnh1','tienhai1@gmail.com','abcxyz1','2a'),
	('3b','Tiến Hải2','Hà Tĩnh2','tienhai2@gmail.com','abcxyz2','3a'), 
	('4b','Tiến Hải3','Hà Tĩnh3','tienhai3@gmail.com','abcxyz3','4a'), 
	('5b','Tiến Hải4','Hà Tĩnh4','tienhai4@gmail.com','abcxyz4','5a');
insert into category values
('văn học'),
('tin học'),
('toán học'),
('sinh học'),
('truyện');
insert into book values
('1d','toán lớp 1','abc1','vô danh','2001',5,20.0,'abcxyz','văn học','1a'),
('2d','toán lớp 1','abc1','vô danh1','2003',4,24.0,'abcxyz','tin học','2a'),
('3d','toán lớp 1','abc1','vô danh2','2002',3,23.0,'abcxyz','toán học','3a'),
('4d','toán lớp 1','abc1','vô danh3','2004',2,22.0,'abcxyz','toán học','4a'),
('5d','toán lớp 1','abc1','vô danh4','2005',1,21.0,'abcxyz','truyện','5a');

select *from borrow_order;
select *from student;
select *from category;
select *from book;