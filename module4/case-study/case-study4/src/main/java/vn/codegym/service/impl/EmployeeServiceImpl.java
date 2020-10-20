package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;
import vn.codegym.model.Service;
import vn.codegym.repository.EmployeeRepository;
import vn.codegym.service.EmployeeService;

@org.springframework.stereotype.Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean checkId(String id) {
        boolean check = false;
        for (int i=0;i<employeeRepository.findAll().size();i++){
            if(id.equals(employeeRepository.findAll().get(i).getEmployeeId())){
                check=false;
                break;
            }
            check=true;
        }

        return check;
    }

    @Override
    public void delete(String id) {
        employeeRepository.deleteById(id);
    }
}
