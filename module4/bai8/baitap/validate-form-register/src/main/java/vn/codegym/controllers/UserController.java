package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.User;


@Controller
public class UserController {
    @GetMapping("/")
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }
    @PostMapping("/")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "registration";
        }else {
            return "registration-result";
        }
    }
}
