package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/myLogin")
    public String loginUser() {
        return "common/my_login";
    }

    @GetMapping("/403")
    public String error403() {
        return "common/error";
    }
}
