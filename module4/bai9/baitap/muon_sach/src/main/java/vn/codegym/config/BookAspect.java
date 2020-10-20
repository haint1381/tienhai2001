package vn.codegym.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import vn.codegym.controllers.BookController;

import java.time.LocalDateTime;


@Component
@Aspect
public class BookAspect {
    @Pointcut("execution(* vn.codegym.controllers.BookController.borrowBook())")
    public void borrowBookControllerMethod(){}

    @Pointcut("execution(* vn.codegym.controllers.BookController.*(..))")
    public void allBookControllerMethod(){}

    @Pointcut("execution(* vn.codegym.controllers.BookController.returnBook())")
    public void returnBookControllerMethod(){}

    @AfterReturning(value = "borrowBookControllerMethod()", returning = "exception")
    public void borrowBookCallMethod(JoinPoint joinPoint, Throwable  exception){
        System.err.println("End method name: "+joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
    }
    @AfterReturning(value = "returnBookControllerMethod()", returning = "exception")
    public void  returnBookCallMethod(JoinPoint joinPoint, Throwable  exception){
        System.err.println("End method name: "+joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now());
    }

    @After("allBookControllerMethod()")
    public void allCallMethod(JoinPoint joinPoint){
        System.err.println("End method name: "+joinPoint.getSignature().getName() + " Number of visitors: "+ BookController.count);
    }
}
