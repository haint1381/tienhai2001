package com.codegym.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "XYZServlet",urlPatterns = {"","/hello"})
public class XYZServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insert(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) {

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
                showDeleteForm(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showList(request, response);
                break;
        }}

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_abc/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

    }
}
