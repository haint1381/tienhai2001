package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping
    public String pageCustomer( Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("customer1",new Customer());
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customerList", customerService.getAll(pageable));
        return "customer/list-customer";
    }
    @PostMapping("/addNewCus")
    public String addNewCustomer(@Validated @ModelAttribute("customer1") Customer customer1,BindingResult bindingResult,@PageableDefault(value = 5) Pageable pageable,Model model){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerList", customerService.getAll(pageable));
            model.addAttribute("customerTypeList",customerTypeService.findAll());
            return "customer/list-customer";
        }if(!customerService.checkId(customer1.getCustomerId())){
            model.addAttribute("customer_id","duplicate customer codes");
            model.addAttribute("customerList", customerService.getAll(pageable));
            model.addAttribute("customerTypeList",customerTypeService.findAll());
            return "customer/list-customer";
        } else {
            customerService.save(customer1);
            return "redirect:/customer";
        }
    }

    @GetMapping("/deleteAll")
    public String test(@RequestParam String[] select){
        for (int i=0;i<select.length;i++){
           customerService.delete(select[i]);
        }
        return "redirect:/customer";
    }
    @GetMapping("/edit/{id}")
    public String deleteCus(@PathVariable String id,Model model){
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customer",customerService.findById(id));
        return "customer/edit-customer";
    }

    @PostMapping("/editConfirm")
    public String editConfirm(Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/deleteConfirm/{id}")
    public String deleteConfirm(@PathVariable String id){
        customerService.delete(id);
        return "redirect:/customer";
    }
}
