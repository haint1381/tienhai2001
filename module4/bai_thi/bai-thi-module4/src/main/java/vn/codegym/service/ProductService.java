package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.Errors;
import vn.codegym.model.Product;

import java.util.List;

public interface ProductService  {
    Page<Product> getAll(Pageable pageable);
    Iterable<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void delete(Long id);
//    boolean checkId(Long id);
    Page<Product> findProductsByProductNameContains(String name,Pageable pageable);
    Page<Product> findProductsByPriceContains(String price, Pageable pageable);
    Page<Product> findProductsByColorContains(String color, Pageable pageable);
    Page<Product> findAllByStatusTrue(Pageable pageable);

    Page<Product> findAllByStatusTrueAndColorContainingOrProductNameContaining(String name,Pageable pageable);

    boolean checkBirthday(String birthday);
     void validate(Object target, Errors errors);
}
