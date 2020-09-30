package com.codegym.controllers;

import com.codegym.model.Comment;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public ModelAndView showCreateComment() {
        ModelAndView modelAndView=new ModelAndView("comment-image");

        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.getAll());
        return modelAndView;
    }

    @PostMapping("/create-comment")
    public String saveComment(Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

//    @GetMapping("/view-comment")
//    public ModelAndView getListComment() {
//        return new ModelAndView("comment-image","comments",commentService.getAll());
//    }

    @GetMapping("/update-like/{id}/update")
    public String updateLike(@PathVariable("id") int id) {
        Comment comment = commentService.findById(id);
        comment.setTotalLike(comment.getTotalLike()+1);
        commentService.updateComment(comment);
        return "redirect:/";
    }

//    @GetMapping("/like-comment")
//    public ModelAndView likeComment() {
//        ModelAndView modelAndView=new ModelAndView("comment-image");
//        modelAndView.addObject("comments",commentService.getAll());
//        return modelAndView;
//    }

}
