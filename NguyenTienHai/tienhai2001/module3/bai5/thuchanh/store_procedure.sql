use classicmodels;

DELIMITER //
drop  PROCEDURE if exists  `findAllCustomers()`//
CREATE PROCEDURE findAllCustomers()
BEGIN
  SELECT * FROM customers;
END; //
DELIMITER ;
call findAllCustomers();