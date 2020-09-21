package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping({"","/sandwich"})
public class SandwichController {

    @GetMapping
    public String menu1(){
        return "display";
    }
    @PostMapping
    public ModelAndView menu(@RequestParam(required = false) String[] menu){
       ModelAndView modelAndView =new ModelAndView("display");
       if(menu==null){
           modelAndView.addObject("mess","There is no choice");
       }else {
           modelAndView.addObject("list",menu);
       }
        return modelAndView;
    }

}
