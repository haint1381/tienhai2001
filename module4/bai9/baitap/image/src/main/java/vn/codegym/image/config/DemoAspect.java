package vn.codegym.image.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import vn.codegym.image.controllers.ImageController;

import java.time.LocalDateTime;

@Component
@Aspect
public class DemoAspect {
    @Pointcut("execution(* vn.codegym.image.controllers.ImageController.*(..))")
    public void commentControllerMethod(){}

    @AfterThrowing(value = "commentControllerMethod()", throwing = "exception")
    public void beforeCallMethod(JoinPoint joinPoint, Throwable  exception){
        System.err.println("log : "+joinPoint.getSignature().getName() + "comment BadWords : "+ ImageController.commentBadWords.getCommentFeedback());
        System.err.println(exception);
    }

}
