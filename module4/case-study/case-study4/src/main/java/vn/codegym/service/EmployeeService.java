package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Employee;

public interface EmployeeService {
    Page<Employee> getAll(Pageable pageable);
    Iterable<Employee> findAll();
    Employee findById(String id);

    void save(Employee employee);
    boolean checkId(String id);
    void delete(String id);
}
