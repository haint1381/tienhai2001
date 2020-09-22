package com.codegym.controllers;


import com.codegym.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.codegym.service.ISettingsService;

import java.util.List;

@Controller
@RequestMapping({"","/setting"})
public class SettingsController {
    @Autowired
    ISettingsService iSettingsService;
    @GetMapping
    public ModelAndView showForm(@ModelAttribute("settings")Settings settings){
        return new ModelAndView("home","settings",new Settings("1","1","1","1"));
    }
    @GetMapping("/updateForm")
    public String updateForm(@ModelAttribute("settings")Settings settings,Model model){
        List<String> listLanguage = iSettingsService.getLanguage();
        List<String> listPageSize = iSettingsService.getPageSize();
        model.addAttribute("listLanguage",listLanguage);
        model.addAttribute("listPageSize",listPageSize);
        return "update";
    }
    @PostMapping("/updateSetting")
    public ModelAndView updateSetting(@ModelAttribute("settings")Settings settings){
        return new ModelAndView("home","settings",settings);
    }
}