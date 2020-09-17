package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DictionaryController {
    @GetMapping(value = {"","/dictionary"})
    public String homePage(){
        return "hello";
    }
    @PostMapping(value = "/dictionary")
    public ModelAndView translate(HttpServletRequest request){
        String name=request.getParameter("english");
        String vietnam= Library.findAll().get(name);
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("vietnam", vietnam);
        return modelAndView;
    }
}
