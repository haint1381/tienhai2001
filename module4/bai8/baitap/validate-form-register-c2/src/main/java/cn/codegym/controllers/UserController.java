package cn.codegym.controllers;

import cn.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    @GetMapping("/")
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }
    @PostMapping("/test")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,Model model) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }else {
            return "registration-result";
        }
    }
}
