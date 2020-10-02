package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.FlowerProducts;
import vn.codegym.repository.ProductRepository;


import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<FlowerProducts> findAll() {
        return productRepository.findAll();
    }

    @Override
    public FlowerProducts findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(FlowerProducts product) {
        productRepository.save(product);
    }
}
