package com.furama.dao.customer_dao;

import com.furama.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();
    void create(Customer customer);
    boolean deleteCustomer(int id) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    Customer findById(int id) throws SQLException;
    List<Customer> selectByName(String name);
}
