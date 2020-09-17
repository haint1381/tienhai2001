package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

@Controller
public class ConvertController {
    @GetMapping(value = {"","/convert"})
    public String getHelloPage(){
        return "hello";
    }
    @PostMapping({"/convert"})
    public ModelAndView showResult(HttpServletRequest request) throws IOException {
        double usd=Double.parseDouble(request.getParameter("usd"));
        double price=Double.parseDouble(request.getParameter("price"));
        double vnd=usd*price;
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("usd1", usd);
        modelAndView.addObject("price1", price);
        modelAndView.addObject("vnd", vnd);
        return modelAndView;
    }
}
