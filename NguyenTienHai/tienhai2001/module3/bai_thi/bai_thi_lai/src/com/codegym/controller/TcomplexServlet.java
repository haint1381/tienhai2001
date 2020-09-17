package com.codegym.controller;

import com.codegym.bo.IRentalSpaceManagementBO;
import com.codegym.bo.RentalSpaceManagementBO;
import com.codegym.model.Premises;
import com.codegym.model.RentalSpaceManagement;
import com.codegym.model.Status;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TcomplexServlet",urlPatterns = {"","/rentalSpaceManagement"})
public class TcomplexServlet extends HttpServlet {
    IRentalSpaceManagementBO iRentalSpaceManagementBO =new RentalSpaceManagementBO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insert(request, response);
                break;
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        String statusName = request.getParameter("statusName");
        String acreage = request.getParameter("acreage");
        String floors = request.getParameter("floors");
        String typeOfPremises = request.getParameter("typeOfPremises");
        String price = request.getParameter("price");
        String startDay = request.getParameter("startDay");
        String endDate = request.getParameter("endDate");
        RentalSpaceManagement rentalSpaceManagement = new RentalSpaceManagement(id,statusName,acreage,floors,typeOfPremises,price,startDay,endDate);
        iRentalSpaceManagementBO.create(rentalSpaceManagement);
        request.setAttribute("message", "successfully added!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/tcomplex/create.jsp");
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
            case "delete":
                delete(request, response);
                break;
            case "search1":
                try {
                    search1(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search2":
                try {
                    search2(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search3":
                try {
                    search3(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
               listView(request, response);
                break;
        }}


    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            iRentalSpaceManagementBO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<RentalSpaceManagement> rentalSpaceManagementList = iRentalSpaceManagementBO.findAll();
        request.setAttribute("rentalSpaceManagementList", rentalSpaceManagementList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/tcomplex/list.jsp");
        dispatcher.forward(request, response);
    }

    private void search1(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name =request.getParameter("floors");
        List<RentalSpaceManagement> rentalSpaceManagementList =iRentalSpaceManagementBO.findByFloors(name);
        request.setAttribute("rentalSpaceManagementList", rentalSpaceManagementList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/tcomplex/list.jsp");
        dispatcher.forward(request, response);
    }
    private void search2(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name =request.getParameter("typeOfPremises");
        List<RentalSpaceManagement> rentalSpaceManagementList =iRentalSpaceManagementBO.findByPremises(name);
        request.setAttribute("rentalSpaceManagementList", rentalSpaceManagementList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/tcomplex/list.jsp");
        dispatcher.forward(request, response);
    }
    private void search3(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name =request.getParameter("price");
        List<RentalSpaceManagement> rentalSpaceManagementList =iRentalSpaceManagementBO.findByPrice(name);
        request.setAttribute("rentalSpaceManagementList", rentalSpaceManagementList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/tcomplex/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalSpaceManagement> rentalSpaceManagementList = iRentalSpaceManagementBO.findAll();
        request.setAttribute("rentalSpaceManagementList", rentalSpaceManagementList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/tcomplex/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/tcomplex/create.jsp");
        dispatcher.forward(request, response);
    }
}