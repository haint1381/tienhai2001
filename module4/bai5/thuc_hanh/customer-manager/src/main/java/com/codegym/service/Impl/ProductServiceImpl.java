package com.codegym.service.Impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository customerRepository;
    @Override
    public List<Product> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Product product) {
        customerRepository.create(product);
    }

    @Override
    public void deleteProduct(Product product){
        customerRepository.deleteProduct(product);
    }

    @Override
    public void updateProduct(Product product){
        customerRepository.updateProduct(product);
    }

    @Override
    public Product findById(int id) {
        return customerRepository.findById(id);
    }
}
