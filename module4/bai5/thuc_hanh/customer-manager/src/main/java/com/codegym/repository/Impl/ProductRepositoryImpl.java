package com.codegym.repository.Impl;

import com.codegym.repository.ConnectionUtil;
import com.codegym.repository.ProductRepository;
import com.codegym.model.Product;
import org.springframework.stereotype.Repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void deleteProduct(Product product){
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(product);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id){

        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();

            product = session.get(Product.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product){
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
