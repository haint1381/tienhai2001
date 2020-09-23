package com.codegym.repository;

import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void create(Product product);
    void deleteProduct(String id) ;
    void updateProduct(Product product);
    Product findById(String id);
    List<Product> findByName(String name) ;
}
