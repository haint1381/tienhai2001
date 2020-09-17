package com.product.dao;

import com.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductDAOImpl implements ProductDAO{
    private static Map<Integer ,Product> productList;
    static {
        productList = new TreeMap<>();
        productList.put(1001,new Product(1001, "Iphone X", 2000000, "Apple"));
        productList.put(1002, new Product(1002, "note 5 pro", 5000000, "xiaomi"));
        productList.put(1003, new Product(1003, "nokia 1280", 8000000, "nokia"));
        productList.put(1004,new Product(1004, "realme 5", 3000000, "oppo"));
        productList.put(1005,new Product(1005, "samsung a71", 7000000, "samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void create(Product product) {
        productList.put(product.getCode(),product);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product findByName(int id) {
        return productList.get(id);
    }

}
