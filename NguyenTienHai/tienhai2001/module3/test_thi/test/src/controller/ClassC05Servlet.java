package controller;

import model.ClassC05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ClassC05Servlet",urlPatterns = "/classc05")
public class ClassC05Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertClassC05(request, response);
                break;
            case "edit":
                editClassC05(request, response);
                break;
        }
    }

    private void editClassC05(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insertClassC05(HttpServletRequest request, HttpServletResponse response) {

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
                delete(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
                ClassC05View(request, response);
                break;
        }}

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {

    }

    private void ClassC05View(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

    }
}
