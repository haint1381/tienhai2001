package com.codegym.repository.Impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Repository
public class ProductRepositoryImpl implements ProductRepository {
  public static Map<String,Product> productMap=new TreeMap<>();
  static {
      productMap.put("001",new Product("001","iphoneX","201","apple"));
      productMap.put("002",new Product("002","note 5 pro","202","xiaomi"));
      productMap.put("003",new Product("003","samsung a51","203","samsung"));
      productMap.put("004",new Product("004","realme 6","204","realme"));
      productMap.put("005",new Product("005","nokia 1280","205","nokia"));
  }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>( productMap.values());
    }

    @Override
    public void create(Product product) {
      productMap.put(product.getId(),product);
    }

    @Override
    public void deleteProduct(String id){
      productMap.remove(id);
    }

    @Override
    public void updateProduct(Product product){
      productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(String id){
        return productMap.get(id);
    }

    @Override
    public List<Product> findByName(String name){
        return null;
    }
}
