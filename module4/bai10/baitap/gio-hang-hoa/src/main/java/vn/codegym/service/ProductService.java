package vn.codegym.service;

import vn.codegym.model.FlowerProducts;

import java.util.List;

public interface ProductService {
    List<FlowerProducts> findAll();

    FlowerProducts findById(Long id);

    void save(FlowerProducts product);

}
