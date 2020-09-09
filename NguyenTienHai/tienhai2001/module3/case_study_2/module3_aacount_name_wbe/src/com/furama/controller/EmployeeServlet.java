package com.furama.controller;

import com.furama.bo.class_bo.EmployeeBO;
import com.furama.bo.common.Validate;
import com.furama.bo.interface_bo.IEmployeeBO;
import com.furama.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeBO employeeBO=new EmployeeBO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertEmployee(request, response);
                break;
            case "edit":
                try {
                    editEmployee(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String employee_id =request.getParameter("employee_id");
        String employee_name=request.getParameter("employee_name");
        String employee_birthday=request.getParameter("employee_birthday");
        String employee_id_card=request.getParameter("employee_id_card");
        String employee_salary=request.getParameter("employee_salary");
        String employee_phone=request.getParameter("employee_phone");
        String employee_email=request.getParameter("employee_email");
        String employee_address=request.getParameter("employee_address");
        String position_id=request.getParameter("position_id");
        String education_degree_id=request.getParameter("education_degree_id");
        String division_id=request.getParameter("division_id");
        String username=request.getParameter("username");
        Employee employee= new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);
        Employee employee1=employeeBO.findById(employee_id);
        if(!employee_id_card.matches(Validate.REGEX_ID_CARD)){
            request.setAttribute("message1", "Invalid id_card id!!");
            request.setAttribute("employee",employee1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/edit_employee.jsp");
            dispatcher.forward(request, response);
        } else if(!employee_salary.matches(Validate.REGEX_DOUBLE)){
            request.setAttribute("message2", "Invalid employee_salary id!!");
            request.setAttribute("employee",employee1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/edit_employee.jsp");
            dispatcher.forward(request, response);
        }else if(!employee_phone.matches(Validate.REGEX_PHONE_NUMBER)){
            request.setAttribute("message3", "Invalid phone id!!");
            request.setAttribute("employee",employee1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/edit_employee.jsp");
            dispatcher.forward(request, response);
        }else if(!employee_email.matches(Validate.REGEX_EMAIL)){
            request.setAttribute("message4", "Invalid email id!!");
            request.setAttribute("employee",employee1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/edit_employee.jsp");
            dispatcher.forward(request, response);
        }else if(!employeeBO.checkUserName(username)){
            request.setAttribute("message5","wrong account name!!");
            request.setAttribute("employee",employee1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/edit_employee.jsp");
            dispatcher.forward(request, response);
        } else {
            employeeBO.updateEmployee(employee);
            List<Employee> employeeList = employeeBO.findAll();
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/home_employee.jsp");
            dispatcher.forward(request, response);
        }


    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employee_id =request.getParameter("employee_id");
        String employee_name=request.getParameter("employee_name");
        String employee_birthday=request.getParameter("employee_birthday");
        String employee_id_card=request.getParameter("employee_id_card");
        String employee_salary=request.getParameter("employee_salary");
        String employee_phone=request.getParameter("employee_phone");
        String employee_email=request.getParameter("employee_email");
        String employee_address=request.getParameter("employee_address");
        String position_id=request.getParameter("position_id");
        String education_degree_id=request.getParameter("education_degree_id");
        String division_id=request.getParameter("division_id");
        String username=request.getParameter("username");
        Employee employee= new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);
        if(!employeeBO.checkId(employee_id)){
            request.setAttribute("message1","New addition failed due to duplicate ids!!");
        } else if(!employee_id_card.matches(Validate.REGEX_ID_CARD)){
            request.setAttribute("message2", "Invalid id_card id!!");
        } else if(!employee_salary.matches(Validate.REGEX_DOUBLE)){
            request.setAttribute("message3", "Invalid employee_salary id!!");
        }else if(!employee_phone.matches(Validate.REGEX_PHONE_NUMBER)){
            request.setAttribute("message4", "Invalid phone id!!");
        }else if(!employee_email.matches(Validate.REGEX_EMAIL)){
            request.setAttribute("message5", "Invalid email id!!");
        }else if(!employeeBO.checkUserName(username)){
            request.setAttribute("message6","wrong account name!!");
        }else {
            employeeBO.create(employee);
            request.setAttribute("message","successfully added!!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/create_employee.jsp");
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
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                employee_view(request, response);
                break;
        }
    }

    private void employee_view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeBO.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/home_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        List<Employee> employeeList =employeeBO.selectByName(name);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/home_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            employeeBO.deleteEmployee(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Employee> employeeList = employeeBO.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/home_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee=null;
        try {
            employee =employeeBO.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/edit_employee.jsp");
        request.setAttribute("employee", employee);
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/create_employee.jsp");
        dispatcher.forward(request, response);
    }
}
