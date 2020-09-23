package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.ProductRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository customerRepository=new ProductRepositoryImpl();
    @Override
    public List<Product> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Product product) {
        customerRepository.create(product);
    }

    @Override
    public void deleteProduct(String id){
        customerRepository.deleteProduct(id);
    }

    @Override
    public void updateProduct(Product product){
        customerRepository.updateProduct(product);
    }

    @Override
    public Product findById(String id) {
        return customerRepository.findById(id);
    }
}
