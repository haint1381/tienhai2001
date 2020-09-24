package com.codegym.repository.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import com.codegym.repository.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {


    @Override
    public void save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(comment);

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
    public List<Comment> getAll() {
        Session session = null;
        List<Comment> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Comment").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public Comment findById(int id) {

        Session session = null;
        Comment comment = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();

            comment = session.get(Comment.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return comment;
    }
    @Override
    public void updateComment(Comment comment){
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(comment);

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