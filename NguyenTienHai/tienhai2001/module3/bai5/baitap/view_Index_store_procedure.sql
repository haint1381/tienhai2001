drop database if exists demo;
create database demo;
use demo;
create table product(
	Id  int primary key,
	productCode varchar(50),
	productName  varchar(500),
	productPrice double,
	productAmount int,
	productDescription varchar(500),
	productStatus varchar(500)
);
insert into product 
values (1,'111a','điện thoại',30,3,'điện thoại xịn','tốt'),
		(2,'111b','điện thoại1',70,7,'điện thoại xịn','tốt'),
		(3,'111c','điện thoại2',50,4,'điện thoại xịn','hỏng');
/* tạo UNIQUE INDEX*/
CREATE UNIQUE INDEX index_product
ON product(productCode);

/*Tạo Composite Index*/
CREATE UNIQUE INDEX index_product1
ON product ( productName, productPrice );

/*Sử dụng câu lệnh EXPLAIN*/
EXPLAIN product;

/*So sánh câu truy vấn trước và sau khi tạo index*/
EXPLAIN select *
from product
where Id=2;

/*tạo view lấy về các thông tin:*/
create or replace view product_view
as 
   select  productCode, productName, productPrice, productStatus 
   from product;
select *from  product_view;

/*Tiến hành sửa đổi view*/
update product_view
set productStatus='hỏng'
where productCode='điện thoại';

/*Tiến hành xoá view*/
DROP VIEW product_view;

/*Tạo store procedure lấy tất cả thông tin*/
DELIMITER //
CREATE PROCEDURE find_all_product()
BEGIN
  SELECT * FROM product;
END; //
DELIMITER ;
call find_all_product();

/*Tạo store procedure thêm một sản phẩm mới*/
DELIMITER //
CREATE PROCEDURE add_product(in	Id  int,
	in productCode varchar(50),
	in productName  varchar(500),
	in productPrice double,
	in productAmount int,
	in productDescription varchar(500),
	in productStatus varchar(500))
BEGIN
  insert into product values (Id,productCode,productName,productPrice,productAmount,productDescription,productStatus);
END; //
DELIMITER ;
call add_product(4,'111d','điện thoại4',50,4,'điện thoại xịn','tốt');

/*Tạo store procedure sửa thông tin sản phẩm theo id*/
DELIMITER //
CREATE PROCEDURE update_product(in	Id1  int,
	in productCode1 varchar(50),
	in productName1  varchar(500),
	in productPrice1 double,
	in productAmount1 int,
	in productDescription1 varchar(500),
	in productStatus1 varchar(500))

BEGIN
      UPDATE product
      SET Id=Id1,
      productCode=productCode1,
      productName=productName1,
      productPrice=productPrice1,
      productAmount=productAmount1,
      productDescription=productDescription1,
      productStatus=productStatus1
      WHERE id=id1;
END; //
DELIMITER ;
call update_product(4,'111e','điện thoại7',44,4,'điện thoại tàu','hư rồi');

/*Tạo store procedure xoá sản phẩm theo id*/
DELIMITER //
CREATE PROCEDURE delete_product(in	Id1  int)
BEGIN
      delete from product
      WHERE id=id1;
END; //
DELIMITER ;
call delete_product(4);