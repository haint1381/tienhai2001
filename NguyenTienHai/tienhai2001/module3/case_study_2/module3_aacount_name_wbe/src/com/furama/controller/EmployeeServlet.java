package com.furama.controller;

import com.furama.bo.employee_bo.EmployeeBO;
import com.furama.bo.employee_bo.IEmployeeBO;
import com.furama.model.Customer;
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
        String employee_name=request.getParameter("employee_name");
        String employee_birthday=request.getParameter("employee_birthday");
        String employee_id_card=request.getParameter("employee_id_card");
        double employee_salary=Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone=request.getParameter("employee_phone");
        String employee_email=request.getParameter("employee_email");
        String employee_address=request.getParameter("employee_address");
        int position_id=Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id=Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id=Integer.parseInt(request.getParameter("division_id"));
        String username=request.getParameter("username");
        int employee_id1 =Integer.parseInt(request.getParameter("employee_id"));
        Employee employee= new Employee(employee_id1,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);
        employeeBO.updateEmployee(employee);
        List<Employee> employeeList = employeeBO.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_employee/home_employee.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employee_id =Integer.parseInt(request.getParameter("employee_id"));
        String employee_name=request.getParameter("employee_name");
        String employee_birthday=request.getParameter("employee_birthday");
        String employee_id_card=request.getParameter("employee_id_card");
        double employee_salary=Double.parseDouble(request.getParameter("employee_salary"));
        String employee_phone=request.getParameter("employee_phone");
        String employee_email=request.getParameter("employee_email");
        String employee_address=request.getParameter("employee_address");
        int position_id=Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id=Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id=Integer.parseInt(request.getParameter("division_id"));
        String username=request.getParameter("username");
        Employee employee= new Employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username);
        employeeBO.create(employee);
        request.setAttribute("message","successfully added!!");
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
        int id = Integer.parseInt(request.getParameter("id"));
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
        int id = Integer.parseInt(request.getParameter("id"));
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
