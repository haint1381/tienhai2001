package vn.codegym.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.image.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findCommentByCommentFeedback (String feedback);
}