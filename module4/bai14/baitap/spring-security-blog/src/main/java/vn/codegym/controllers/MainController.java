package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Account;
import vn.codegym.service.AccountService;


@Controller
@RequestMapping("/login")
public class MainController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public String loginUser() {
        return "account/login";
    }
    @GetMapping("/error")
    public String error403() {
        return "common/error";
    }
    @GetMapping("/addNew")
    public String UserNew(Model model) {
        model.addAttribute("account",new Account());
        return "account/registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute   Account account) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(account.getPassword());
        accountService.save(new Account(account.getUserName(), password, "ROLE_USER", true));
        return "redirect:/login";
    }
}
