drop database if exists demo;
CREATE DATABASE demo;
USE demo;

/* tạo table*/
create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

/*chèn dữ liệu*/
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam'),('Kante','kante@che.uk','Kenia'),('Minh','minh@codegym.vn','Viet rNam');

/*thủ tục tìm kiếm theo id*/
DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.name, users.email, users.country
    FROM users
    where users.id = user_id;
    END$
DELIMITER ;

/*thủ tục chèn dữ liệu*/
DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

/*thủ tục lấy ra toàn bộ danh sách*/
DELIMITER $$
CREATE PROCEDURE select_all_users()
BEGIN
    SELECT users.id, users.name, users.email, users.country
    FROM users;
    END$$
DELIMITER ;
call select_all_users();

/* tạo thủ tục update thông tin*/
DELIMITER $$
CREATE PROCEDURE update_users(in id int,
							  in `name` varchar(50),
                              in email varchar(50),
                              in country varchar(50))
BEGIN
    update users
    set name = `name`,
    email= email,
    country =country
    where id = id;
    END$$
DELIMITER ;

/* tạo thủ tục xóa thông tin*/

DELIMITER $$
CREATE PROCEDURE delete_users(in id1 int)
BEGIN
   delete from users 
   where id = id1;
    END$$
DELIMITER ;

call delete_users(2);

