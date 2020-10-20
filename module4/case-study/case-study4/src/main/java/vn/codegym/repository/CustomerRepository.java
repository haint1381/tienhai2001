package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
