package com.codegym.dao;

import com.codegym.model.Category;
import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> findAll();
    void create(Product product);
    boolean deleteProduct(int id) throws SQLException;
    boolean updateProduct(Product product) throws SQLException;
    Product findById(int id) throws SQLException;
    List<Product> findByName(String name) throws SQLException;
}
