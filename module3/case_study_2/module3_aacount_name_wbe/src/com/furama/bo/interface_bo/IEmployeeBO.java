package com.furama.bo.interface_bo;

import com.furama.model.Customer;
import com.furama.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeBO  {
    List<Employee> findAll();
    void create(Employee employee);
    boolean deleteEmployee(String id) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    Employee findById(String id) throws SQLException;
    List<Employee> selectByName(String name);
    boolean checkId(String id);
    boolean checkUserName(String name);
}
