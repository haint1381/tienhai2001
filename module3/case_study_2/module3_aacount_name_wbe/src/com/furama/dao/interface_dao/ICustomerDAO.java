package com.furama.dao.interface_dao;

import com.furama.model.Contract;
import com.furama.model.Customer;
import com.furama.model.CustomerUsingService;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();
    void create(Customer customer);
    boolean deleteCustomer(String id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer findById(String id) throws SQLException;
    List<Customer> selectByName(String name);
    List<CustomerUsingService> customersUsingTheService();
}
