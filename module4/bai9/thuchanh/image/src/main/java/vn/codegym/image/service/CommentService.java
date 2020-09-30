package vn.codegym.image.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.image.model.Comment;


public interface CommentService {
    Page<Comment> getAllComment(Pageable pageable);

    Comment findById(int id);

    void save(Comment comment);

    Comment findCommentByCommentFeedback(String feedback);
}