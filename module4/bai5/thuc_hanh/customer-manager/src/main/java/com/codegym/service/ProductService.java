package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create(Product product);
    void deleteProduct(Product product);
    void updateProduct(Product product);
    Product findById(int id);

}
