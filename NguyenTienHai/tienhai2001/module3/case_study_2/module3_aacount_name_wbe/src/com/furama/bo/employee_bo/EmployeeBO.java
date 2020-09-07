package com.furama.bo.employee_bo;

import com.furama.dao.employee_dao.EmployeeDAO;
import com.furama.dao.employee_dao.IEmployeeDAO;
import com.furama.model.Customer;
import com.furama.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBO implements IEmployeeBO {
    IEmployeeDAO employeeDAO =new EmployeeDAO();
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void create(Employee employee) {
        employeeDAO.create(employee);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeDAO.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public Employee findById(int id) throws SQLException {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> selectByName(String name) {
        return employeeDAO.selectByName(name);
    }
}
