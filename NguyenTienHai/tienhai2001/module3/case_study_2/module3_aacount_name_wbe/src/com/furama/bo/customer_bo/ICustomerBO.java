package com.furama.bo.customer_bo;

import com.furama.model.Customer;
import com.furama.model.CustomerUsingService;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerBO {
    List<Customer> findAll();
    void create(Customer customer);
    boolean deleteCustomer(int id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer findById(int id) throws SQLException;
    List<Customer> selectByName(String name);
    boolean checkId(int id);
    List<CustomerUsingService> customersUsingTheService();
}
