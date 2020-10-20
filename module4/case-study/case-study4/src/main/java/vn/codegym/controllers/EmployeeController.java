package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Customer;
import vn.codegym.model.Employee;
import vn.codegym.model.Service;

import vn.codegym.service.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    UserEmployeeService userEmployeeService;
    @GetMapping
    public String pageEmployee(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("employee1",new Employee());
        model.addAttribute("educationDegrees",educationDegreeService.findAll());
        model.addAttribute("positions",positionService.findAll());
        model.addAttribute("divisions",divisionService.findAll());
        model.addAttribute("userEmployees",userEmployeeService.findAll());
        model.addAttribute("employeeList", employeeService.getAll(pageable));
        return "employee/list-employee";
    }

    @PostMapping("/addNew")
    public String addNewEmployee(@Validated @ModelAttribute("employee1") Employee employee, BindingResult bindingResult, @PageableDefault(value = 5) Pageable pageable, Model model){
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisions",divisionService.findAll());
            model.addAttribute("userEmployees",userEmployeeService.findAll());
            model.addAttribute("educationDegrees",educationDegreeService.findAll());
            model.addAttribute("positions",positionService.findAll());
            model.addAttribute("employeeList", employeeService.getAll(pageable));
            return "employee/list-employee";
        }if(!employeeService.checkId(employee.getEmployeeId())){
            model.addAttribute("employee_id","duplicate employee codes");
            model.addAttribute("positions",positionService.findAll());
            model.addAttribute("employeeList", employeeService.getAll(pageable));
            model.addAttribute("divisions",divisionService.findAll());
            model.addAttribute("userEmployees",userEmployeeService.findAll());
            model.addAttribute("educationDegrees",educationDegreeService.findAll());
            return "employee/list-employee";
        } else {
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/deleteConfirm/{id}")
    public String deleteConfirm(@PathVariable String id){
        employeeService.delete(id);
        return "redirect:/employee";
    }
    @GetMapping("/edit/{id}")
    public String deleteEmployee(@PathVariable String id,Model model){
        model.addAttribute("educationDegrees",educationDegreeService.findAll());
        model.addAttribute("positions",positionService.findAll());
        model.addAttribute("divisions",divisionService.findAll());
        model.addAttribute("userEmployees",userEmployeeService.findAll());
        model.addAttribute("employee",employeeService.findById(id));
        return "employee/edit-employee";
    }

    @PostMapping("/editConfirm")
    public String editConfirm(Employee employee){
        employeeService.save(employee);
        return "redirect:/employee";
    }
}
