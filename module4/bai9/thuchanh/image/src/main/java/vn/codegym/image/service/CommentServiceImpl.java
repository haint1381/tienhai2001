package vn.codegym.image.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.image.model.Comment;
import vn.codegym.image.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public static List<String> badWords;
    static {
        badWords=new ArrayList<>();
        badWords.add("dm");
        badWords.add("cmm");
        badWords.add("clmm");
        badWords.add("dcm");
        badWords.add("sv");
    }

    @Override
    public Page<Comment> getAllComment(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Comment findById(int id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment findCommentByCommentFeedback(String feedback) {
        return commentRepository.findCommentByCommentFeedback(feedback);
    }


}