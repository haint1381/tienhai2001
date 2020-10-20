package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;
import vn.codegym.model.Service;
import vn.codegym.service.*;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ServiceService serviceService;
    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ContractService contractService;
    @GetMapping
    public String pageService(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("services", serviceService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("contracts", contractService.getAll(pageable));
        return "contract/list-contract";
    }


    @PostMapping("/addNew")
    public String addNewContract(@Validated @ModelAttribute("contract")Contract contract, BindingResult bindingResult, @PageableDefault(value = 5) Pageable pageable, Model model){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("services", serviceService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("contracts", contractService.getAll(pageable));
            return "contract/list-contract";
        }if(!contractService.checkId(contract.getContractId())){
            model.addAttribute("contract_id","duplicate contract codes");
            model.addAttribute("services", serviceService.findAll());
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("contracts", contractService.getAll(pageable));
            return "contract/list-contract";
        } else {
            contractService.save(contract);
            return "redirect:/contract";
        }
    }

    @GetMapping("/deleteConfirm/{id}")
    public String deleteConfirm(@PathVariable String id) {
        contractService.delete(id);
        return "redirect:/contract";
    }
}