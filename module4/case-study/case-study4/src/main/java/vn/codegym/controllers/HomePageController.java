package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"","/homepage"})
public class HomePageController {
    @GetMapping
    public String homepage(){
        return "/common/home-page";
    }
}
