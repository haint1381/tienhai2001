drop database if exists shop_system;
create database shop_system;
use shop_system;

create table offices(
office_code varchar(10) not null primary key,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postal_code varchar(15) not null,
country  varchar(50) not null
);

create table employees(
employee_number int not null primary key,
last_name varchar(50) not null,
first_name varchar(50) not null,
email varchar(100) not null,
job_title varchar(50) not null,
report_to int,
office_code varchar(10) not null,
foreign key(report_to)references employees(employee_number),
foreign key(office_node)references offices(office_node)
);

create table customers(
customer_number int primary key not null,
customer_name varchar(255) not null,
contact_last_name varchar(50) not null,
contact_first_name varchar(50) not null,
phone varchar(50) not null,
address_line1 varchar(50) not null,
address_line2 varchar(50),
city varchar(50) not null,
state varchar(50) not null,
postal_code varchar(15) not null,
country  varchar(50) not null,
credit_limit double,
sales_rep_employee_number int  not null,
foreign key(sales_rep_employee_number)references employees(employee_number)
);

create table products_line(
product_line varchar(50) not null primary key,
text_description varchar(255),
image varchar(255)
);

create table products(
product_code varchar(15) not null primary key,
product_name varchar(70) not null,
product_scale varchar(10) not null,
product_vendor varchar(50) not null,
product_description text not null,
quantity_inStock int not null,
buy_price double not null,
msrp double not null,
product_line varchar(50) not null,
foreign key(product_line)references products_line(product_line)
);

create table orders(
order_number int primary key not null,
order_date date not null,
required_date date not null,
shipped_date date,
`status` varchar(15) not null,
comments text,
quantity_ordered int not null,
price_each double not null,
customer_number int not null,
foreign key(customer_number) references customers(customer_number)
);

create table payments(
customer_number int  not null,
check_number varchar(50) not null,
payment_date date not null,
amount double not null,
foreign key(customer_number)references customers(customer_number)
);


create table order_details(
order_number int not null ,
product_code varchar(15) not null,
foreign key(product_code)references products(product_code),
foreign key(order_number)references orders(order_number)
);
