package com.codegym.repository;

import com.codegym.model.Comment;


import java.util.List;

public interface CommentRepository {
    void save(Comment comment);

    List<Comment> getAll();

    Comment findById(int id);
    void updateComment(Comment comment);
}
