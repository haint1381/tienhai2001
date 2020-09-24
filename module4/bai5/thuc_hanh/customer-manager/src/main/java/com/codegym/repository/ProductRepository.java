package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();
    void create(Product product);
    void deleteProduct(Product product) ;
    void updateProduct(Product product);
    Product findById(int id);
}
