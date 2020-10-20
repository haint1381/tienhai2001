package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;


import java.util.List;

public interface CustomerService {
    Page<Customer> getAll(Pageable pageable);
    Iterable<Customer> findAll();
    Customer findById(String id);
    void save(Customer customer);
    void delete(String id);
    boolean checkId(String id);
}
