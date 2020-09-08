package com.furama.controller;

import com.furama.bo.common.Validate;
import com.furama.bo.interface_bo.ICustomerBO;
import com.furama.bo.class_bo.CustomerBO;
import com.furama.model.Customer;
import com.furama.model.CustomerUsingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerBO customerBo =new CustomerBO();
    private Validate validate=new Validate();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "edit":
                try {
                    editCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id=request.getParameter("id");
        String type_id=request.getParameter("type_id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender =request.getParameter("gender");
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id,type_id,name,birthday,gender,id_card,phone, email, address);
        customerBo.updateCustomer(newCustomer);
        List<Customer> customerList = customerBo.findAll();
        request.setAttribute("customerList", customerList);
        request.setAttribute("massage", "successfully update!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/list.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            case "customersUsingTheService":
                showCustomersUsingTheService(request, response);
                break;
            default:
                customer_view(request, response);
                break;
        }
    }

    private void showCustomersUsingTheService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerUsingService> customerUsingServiceList = customerBo.customersUsingTheService();
        request.setAttribute("customerUsingServiceList", customerUsingServiceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/customers_using_the_service.jsp");
        dispatcher.forward(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
       List<Customer> customerList =customerBo.selectByName(name);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            customerBo.deleteCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Customer> customerList = customerBo.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Customer customer=null;
        try {
             customer =customerBo.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/edit.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void customer_view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerBo.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String type_id=request.getParameter("type_id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender =request.getParameter("gender");
        String id_card = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id,type_id,name,birthday,gender,id_card,phone, email, address);

        if (!id.matches(Validate.REGEX_ID)) {
            request.setAttribute("message1", "sai ôkể ôkê!!");
        } else if (customerBo.checkId(id)) {
            customerBo.create(newCustomer);
            request.setAttribute("message", "successfully added!!");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_customer/create.jsp");
        dispatcher.forward(request, response);
    }
}
