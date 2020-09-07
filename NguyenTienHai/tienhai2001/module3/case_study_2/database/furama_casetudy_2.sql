drop database if exists module3_account_name_wbe;
create database module3_account_name_wbe;
use module3_account_name_wbe;
create table `position`(
	position_id int primary key,
	position_name varchar(45)
	);
create table education_degree(
	education_degree_id int primary key,
	education_degree_name varchar(45)
	);
create table division(
	division_id int primary key,
	division_name varchar(45)
	);
create table `user`(
	username varchar(255) primary key,
	`password` varchar(255)
	);
create table `role`(
	role_id int primary key,
	role_name varchar(255)
	);
create table user_role(
	role_id int,
	username varchar(255),
	foreign key (role_id)
	references `role`(role_id) ON DELETE CASCADE,
	foreign key (username)
	references `user`(username) ON DELETE CASCADE
	);
create table employee(
	employee_id int primary key,
	employee_name varchar(45),
	employee_birthday date,
	employee_id_card varchar(45),
	employee_salary double,
	employee_phone varchar(45),
	employee_email varchar(45),
	employee_address varchar(45),
	position_id int,
	education_degree_id int,
	division_id int,
	username varchar(255),
	foreign key (position_id) 
	references `position`(position_id) ON DELETE CASCADE,
	foreign key (education_degree_id) 
	references education_degree(education_degree_id) ON DELETE CASCADE,
	foreign key (division_id) 
	references division(division_id) ON DELETE CASCADE,
	foreign key (username) 
	references `user`(username) ON DELETE CASCADE
	);
create table customer_type(
	customer_type_id int primary key,
	customer_type_name varchar(45)
	);
create table customer(
	customer_id int primary key,
	customer_type_id int,
	customer_name varchar(45),
	customer_birthday date,
	customer_gender bit(1),
	customer_id_card varchar(45),
	customer_phone varchar(45),
	customer_email varchar(45),
	customer_address varchar(45)
	);
create table service_type(
	service_type_id int primary key,
	service_type_name varchar(45)
	);
create table rent_type(
	rent_type_id int primary key,
	rent_type_name varchar(45),
	rent_type_cost double
	);
create table service(
	service_id int primary key,
	service_name varchar(45),
	service_area int,
	service_cost double,
	service_max_people int,
	rent_type_id int,
	service_type_id int,
	standard_room varchar(45),
	description_orther_convenience varchar(45),
	pool_area double,
	numer_of_floors int,
	foreign key (rent_type_id)
	references rent_type(rent_type_id) ON DELETE CASCADE,
	foreign key (service_type_id)
	references service_type(service_type_id) ON DELETE CASCADE
	);

create table contract(
	contract_id int primary key,
	contract_start_date datetime,
	contract_end_date datetime,
	contract_deposit double,
	contract_total_money double,
	employee_id int,
	customer_id int,
	service_id int,
	foreign key (employee_id)
	references employee(employee_id) ON DELETE CASCADE,
	foreign key (customer_id)
	references customer(customer_id) ON DELETE CASCADE,
	foreign key (service_id)
	references service(service_id) ON DELETE CASCADE
	);

create table attach_service(
	attach_service_id int primary key,
	attach_service_name varchar(45),
	attach_service_cost double,
	attach_service_unit int,
	attach_service_status varchar(45)
	);
create table contract_detail(
	contract_detail_id int primary key,
	contract_id int,
	attach_service_id int,
	quantity int,
	foreign key (contract_id)
	references contract(contract_id) ON DELETE CASCADE ,
	foreign key (attach_service_id)
	references attach_service(attach_service_id) ON DELETE CASCADE
	);

insert into `position`(position_id,position_name )
values (1,"Lễ tân"),
	   (2,"Phục vụ"),
	   (3,"Chuyên viên"),
	   (4,"Giám sát"),
	   (5,"Quản lý"),
	   (6,"Giám đốc");

insert into education_degree(education_degree_id,education_degree_name)
values (1,"Trung cấp"),
       (2,"Cao đẳng"),
       (3,"Đại học"),
       (4,"sau đại học");

insert into division(division_id,division_name)
value (1,"Sale – Marketing"),
	  (2,"Hành Chính"),
	  (3,"Phục vụ"),
	  (4,"Quản lý");
      
      
      
      
      
insert into `user`(username,`password`)
value ("tienhai2001","130801"),
	  ("lenhat2000","120900"),
	  ("thanhhoang","040199"),
	  ("huuquang","121296");

insert into `role`(role_id,role_name)
value (1,"abc"),
	  (2,"bcd"),
	  (3,"def"),
	  (4,"xyz");
    
insert into user_role(role_id,username)
value (1,"tienhai2001"),
	  (2,"lenhat2000"),
	  (3,"thanhhoang"),
	  (4,"huuquang");

insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username)
value (1,"Hoàng","2002/01/01","123",200.0,"0466764237","hoangvogiacu@gmail.com","đà nẵng",1,1,2,"thanhhoang"),
      (2,"Hải","2002/01/01","234",200.0,"0566764237","tienhai@gmail.com","quảng trị",2,2,1,"tienhai2001"),
      (3,"Nhật","2002/01/01","345",200.0,"0468964237","lenhat@gmail.com","Hà tĩnh",3,1,3,"lenhat2000"),
      (4,"Quang","2002/01/01","456",200.0,"0366764237","huuquang@gmail.com","đà nẵng",4,4,1,"huuquang"),
      (5,"Khánh","2002/01/01","567",200.0,"0196764237","quockhanh@gmail.com","nghệ an",5,3,2,"thanhhoang"),
      (6,"Tùng","2002/01/01","678",200.0,"0166764237","sytung@gmail.com","quảng bình",6,1,4,"lenhat2000");

insert into customer_type(customer_type_id,customer_type_name)
value (1,"Diamond"),
	  (2,"Platinium"),
	  (3,"Gold"),
	  (4,"Silver"),
	  (5,"Member");
      
insert into customer (customer_id ,customer_type_id ,customer_name, customer_birthday,customer_gender,customer_id_card ,customer_phone ,customer_email ,customer_address) 
value (1,2,"hai",'2019-09-09',1,"433","0394772917","tienhai19631959@gmail.com","ha tinh");
	

insert into service_type(service_type_id,service_type_name)
value (1,"Villa"),
	  (2,"House"),
	  (3,"Room");
	

insert into rent_type(rent_type_id,rent_type_name,rent_type_cost)
value (1,"Thuê theo năm",30.0),
	  (2,"Thuê theo tháng",20.0),
	  (3,"Thuê theo ngày",10.0),
	  (4,"Thuê theo giờ",5.0);

insert into service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id ,service_type_id,standard_room ,description_orther_convenience,pool_area,numer_of_floors)
value (1,"Villa",40,50,3,1,1,"Vip","quá đẹp",30,4),
      (2,"House",20,60,4,2,2,"thường","quá đẹp",20,6),
	  (3,"Room",40,50,5,3,3,"Vip","quá đẹp",30,3);
	
insert into contract(contract_id,contract_start_date ,contract_end_date ,contract_deposit,contract_total_money,employee_id,customer_id,service_id )
value (1,"2020/09/04","2020/09/11",100.0,200.0,1,1,1);
 
insert into attach_service(attach_service_id,attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
value (1,"Villa",100.0,2,"có sẵn"),
	  (2,"House",50.0,4,"có sẵn"),
	  (3,"Room",10.0,4,"có sẵn");
      
insert into contract_detail(contract_detail_id,contract_id,attach_service_id,quantity)
value (1,1,1,1);

update customer set customer_type_id= 2, customer_name ="hoa",customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where id = ?;

delete from customer where customer_id = 1;