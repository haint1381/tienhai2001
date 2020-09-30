package vn.codegym.image.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.image.model.Comment;
import vn.codegym.image.service.CommentService;
import vn.codegym.image.service.CommentServiceImpl;
import vn.codegym.image.service.DuplicateCommentException;

@Controller
public class ImageController {
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public String showHomePage(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("commentList", commentService.getAllComment(pageable));
        return "views/display";
    }

    @PostMapping("/comment")
    public String comment(Comment comment) throws DuplicateCommentException {
        Comment checkExists = commentService.findCommentByCommentFeedback(comment.getCommentFeedback());
        if (checkExists != null) {
            throw new DuplicateCommentException();
        }
        for (int i=0;i< CommentServiceImpl.badWords.size();i++){
            if(comment.getCommentFeedback().contains(CommentServiceImpl.badWords.get(i))){
                throw new DuplicateCommentException();
            }
        }
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("{id}/{likes}/edit")
    public String edit(@PathVariable("id") int id, @PathVariable("likes") int likes ) {
        Comment comment = commentService.findById(id);
        comment.setCommentLike(likes);
        commentService.save(comment);
        return "redirect:/";
    }


}