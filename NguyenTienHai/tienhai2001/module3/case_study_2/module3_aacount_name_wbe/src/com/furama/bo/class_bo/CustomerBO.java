package com.furama.bo.class_bo;

import com.furama.bo.interface_bo.ICustomerBO;
import com.furama.dao.interface_dao.ICustomerDAO;
import com.furama.dao.class_dao.CustomerDAO;
import com.furama.model.Customer;
import com.furama.model.CustomerUsingService;

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
    public boolean deleteCustomer(String id) throws SQLException {
        return iUserDAO.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return iUserDAO.updateCustomer(customer);
    }

    @Override
    public Customer findById(String id) throws SQLException {
        return iUserDAO.findById(id);
    }

    @Override
    public List<Customer> selectByName(String name) {
        return iUserDAO.selectByName(name);
    }

    @Override
    public boolean checkId(String id) {
        boolean check=true;
        List<Customer> customerList =iUserDAO.findAll();
        for (int i=0;i<customerList.size();i++){
            if(id.equals(customerList.get(i).getId())){
                check=false;
                break;
            }
        }
        return check;
    }

    @Override
    public List<CustomerUsingService> customersUsingTheService() {
        return iUserDAO.customersUsingTheService();
    }
}
