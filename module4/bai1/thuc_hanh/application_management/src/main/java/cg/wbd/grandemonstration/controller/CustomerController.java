package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CustomerController {
    private CustomerService customerService = CustomerServiceFactory.getInstance();
    @GetMapping({"","/customer"})
    public String showList() {
        return "customer/list.jsp";
    }
    @PostMapping({"","/customer"})
    public String showList1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setEmail(req.getParameter("email"));
        customer.setAddress(req.getParameter("address"));

        Long id = Long.valueOf(req.getParameter("id"));
        customer.setId(id);
        customerService.save(customer);
        try {
            req.getRequestDispatcher("/customer/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "customer/list.jsp";
    }
}
