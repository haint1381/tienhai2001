package com.codegym.bo;

import com.codegym.dao.IProductDAO;
import com.codegym.dao.ProductDAO;
import com.codegym.model.Category;
import com.codegym.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBO implements IProductBO {
    IProductDAO iProductDAO = new ProductDAO();

    @Override
    public List<Product> findAll() {
        return iProductDAO.findAll();
    }

    @Override
    public void create(Product product) {
        iProductDAO.create(product);
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return iProductDAO.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return iProductDAO.updateProduct(product);
    }

    @Override
    public Product findById(int id) throws SQLException {
        return iProductDAO.findById(id);
    }

    @Override
    public List<Product> findByName(String name) throws SQLException {
        return iProductDAO.findByName(name);
    }

}
