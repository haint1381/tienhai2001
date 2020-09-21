package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ComputerService;

@Controller
@RequestMapping({"","/computer"})
public class ComputerController {
    @GetMapping
    public String getComputerPage(){
        return "display";
    }
    @PostMapping
    public ModelAndView ComputerResult(@RequestParam double number1,double number2,String action){
        ModelAndView modelAndView =new ModelAndView("display");
        double answer= ComputerService.calculate(action,number1,number2);
        modelAndView.addObject("number1",number1);
        modelAndView.addObject("number2",number2);
        modelAndView.addObject("answer",answer);
        return modelAndView;
    }
}
