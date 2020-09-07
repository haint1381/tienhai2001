package com.furama.bo.customer_bo;

import com.furama.dao.customer_dao.ICustomerDAO;
import com.furama.dao.customer_dao.CustomerDAO;
import com.furama.model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerBO implements ICustomerBO {
    ICustomerDAO iUserDAO =new CustomerDAO();
    @Override
    public List<Customer> findAll() {
        return  iUserDAO.findAll();
    }

    @Override
    public void create(Customer customer) {
        iUserDAO.create(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return iUserDAO.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return iUserDAO.updateCustomer(customer);
    }

    @Override
    public Customer findById(int id) throws SQLException {
        return iUserDAO.findById(id);
    }

    @Override
    public List<Customer> selectByName(String name) {
        return iUserDAO.selectByName(name);
    }
}
