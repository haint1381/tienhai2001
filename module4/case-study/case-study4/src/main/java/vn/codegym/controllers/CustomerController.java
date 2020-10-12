package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping
    public String pageCustomer(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        model.addAttribute("customerList", customerService.getAll(pageable));
        return "customer/list-customer";
    }
    @PostMapping("/addNew")
    public String addNewCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }
//    @GetMapping("/delete/{id}")
//    public String test(@PathVariable String id,Model model){
//        model.addAttribute("customer",customerService.findById(id));
//        return "customer/create-customer";
//    }
    @GetMapping("/deleteConfirm/{id}")
    public String deleteConfirm(@PathVariable String id){
        customerService.delete(id);
        return "redirect:/customer";
    }
}
