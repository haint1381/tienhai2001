package com.furama.controller;

import com.furama.bo.class_bo.ContractBO;
import com.furama.bo.interface_bo.IContractBO;
import com.furama.bo.class_bo.CustomerBO;
import com.furama.bo.interface_bo.ICustomerBO;
import com.furama.bo.class_bo.EmployeeBO;
import com.furama.bo.interface_bo.IEmployeeBO;
import com.furama.bo.interface_bo.IServiceBO;
import com.furama.bo.class_bo.ServiceBO;
import com.furama.model.Contract;
import com.furama.model.Customer;
import com.furama.model.Employee;
import com.furama.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = {"","/furama"})
public class FuramaServlet extends HttpServlet {
    private ICustomerBO customerBo =new CustomerBO();
    private IServiceBO serviceBO =new ServiceBO();
    private IEmployeeBO employeeBO=new EmployeeBO();
    private IContractBO contractBO=new ContractBO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "customer":{
                webCustomer(request, response);
            }
            break;
            case "service":{
                webService(request, response);
            }
            break;
            case "employee":{
                webEmployee(request, response);
            }
            break;
            case "contract":{
                webContract(request, response);
            }
            break;
            default:
                home(request, response);
                break;
        }
    }

    private void webContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractBO.findAll();
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_contract/home_contract.jsp");
        dispatcher.forward(request, response);
    }

    private void webEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeBO.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/home_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void webService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceBO.findAll();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/service_home.jsp");
        dispatcher.forward(request, response);
    }

    private void webCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Customer> customerList = customerBo.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/page_home.jsp");
        dispatcher.forward(request, response);
    }
}
