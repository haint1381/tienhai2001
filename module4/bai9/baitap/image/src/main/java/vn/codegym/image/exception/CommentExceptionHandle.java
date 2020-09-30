package vn.codegym.image.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.image.controllers.ImageController;
import vn.codegym.image.service.DuplicateCommentException;

@ControllerAdvice
public class CommentExceptionHandle {
    @ExceptionHandler(DuplicateCommentException.class)
    public ModelAndView showErrorPage(){
        return  new ModelAndView("views/error");
    }
}