package com.furama.controller;

import com.furama.bo.service_bo.IServiceBO;
import com.furama.bo.service_bo.ServiceBO;
import com.furama.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private IServiceBO serviceBO =new ServiceBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertService(request, response);
                break;
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        int service_id=Integer.parseInt(request.getParameter("service_id"));
        String service_name=request.getParameter("service_name");
        int service_area=Integer.parseInt(request.getParameter("service_area"));
        double service_cost=Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people=Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id=Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id=Integer.parseInt(request.getParameter("service_type_id"));
        String standard_room=request.getParameter("standard_room");
        String description_other_convenience=request.getParameter("description_other_convenience");
        double pool_area=Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors=Integer.parseInt(request.getParameter("number_of_floors"));
        Service service=new Service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
        serviceBO.create(service);
        request.setAttribute("message","successfully added!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/create_service.jsp");
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceBO.findAll();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/service_home.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/create_service.jsp");
        dispatcher.forward(request, response);
    }
}
