package com.product.bo;

import com.product.dao.ProductDAO;
import com.product.dao.ProductDAOImpl;
import com.product.model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    private  ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public void update(int id, Product product) {
        productDAO.update(id,product);
    }

    @Override
    public void remove(int id) {
        productDAO.remove(id);
    }

    @Override
    public Product findByName(int id) {
        return productDAO.findByName(id);
    }

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

}
