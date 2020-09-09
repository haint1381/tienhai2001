package com.furama.controller;

import com.furama.bo.common.Validate;
import com.furama.bo.interface_bo.IServiceBO;
import com.furama.bo.class_bo.ServiceBO;
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
            case "edit":
                try {
                    editService(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editService(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String service_id = request.getParameter("service_id");
        String service_name = request.getParameter("service_name");
        String service_area = request.getParameter("service_area");
        String service_cost = request.getParameter("service_cost");
        String service_max_people = request.getParameter("service_max_people");
        String rent_type_id = request.getParameter("rent_type_id");
        String service_type_id = request.getParameter("service_type_id");
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        String pool_area = request.getParameter("pool_area");
        String number_of_floors = request.getParameter("number_of_floors");
        Service service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
        Service service1=serviceBO.findById(service_id);
        if (!service_area.matches(Validate.REGEX_DOUBLE)) {
            request.setAttribute("message1", "Invalid service_area !!");
            request.setAttribute("service",service1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/edit_service.jsp");
            dispatcher.forward(request, response);
        } else if (!service_cost.matches(Validate.REGEX_DOUBLE)) {
            request.setAttribute("message2", "Invalid service_cost !!");
            request.setAttribute("service",service1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/edit_service.jsp");
            dispatcher.forward(request, response);
        } else if (!service_max_people.matches(Validate.REGEX_INTEGER)) {
            request.setAttribute("message3", "Invalid service_max_people !!");
            request.setAttribute("service",service1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/edit_service.jsp");
            dispatcher.forward(request, response);
        } else if (!pool_area.matches(Validate.REGEX_DOUBLE)) {
            request.setAttribute("message4", "Invalid pool_area !!");
            request.setAttribute("service",service1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/edit_service.jsp");
            dispatcher.forward(request, response);
        } else if (!number_of_floors.matches(Validate.REGEX_INTEGER)) {
            request.setAttribute("message5", "Invalid number_of_floors !!");
            request.setAttribute("service",service1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/edit_service.jsp");
            dispatcher.forward(request, response);
        } else {
            serviceBO.updateService(service);
            List<Service> serviceList = serviceBO.findAll();
            request.setAttribute("serviceList", serviceList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/service_home.jsp");
            dispatcher.forward(request, response);
        }
    }
    private void insertService(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {
        String service_id=request.getParameter("service_id");
        String service_name=request.getParameter("service_name");
        String service_area=request.getParameter("service_area");
        String service_cost=request.getParameter("service_cost");
        String service_max_people=request.getParameter("service_max_people");
        String rent_type_id=request.getParameter("rent_type_id");
        String service_type_id=request.getParameter("service_type_id");
        String standard_room=request.getParameter("standard_room");
        String description_other_convenience=request.getParameter("description_other_convenience");
        String pool_area=request.getParameter("pool_area");
        String number_of_floors=request.getParameter("number_of_floors");
        Service service=new Service(service_id,service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floors);
        if (!service_id.matches(Validate.REGEX_ID_DV)) {
            request.setAttribute("message1", "Invalid service id!!");
        }else if (!service_area.matches(Validate.REGEX_DOUBLE)) {
            request.setAttribute("message2", "Invalid service_area !!");
        }else if (!service_cost.matches(Validate.REGEX_DOUBLE)) {
            request.setAttribute("message3", "Invalid service_cost !!");
        }else if (!service_max_people.matches(Validate.REGEX_INTEGER)) {
            request.setAttribute("message4", "Invalid service_max_people !!");
        }else if (!pool_area.matches(Validate.REGEX_DOUBLE)) {
            request.setAttribute("message5", "Invalid pool_area !!");
        }else if (!number_of_floors.matches(Validate.REGEX_INTEGER)) {
            request.setAttribute("message6", "Invalid number_of_floors !!");
        } else if (serviceBO.checkId(service_id)) {
            serviceBO.create(service);
            request.setAttribute("message", "successfully added!!");
        }
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
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteService(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void showDeleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            serviceBO.deleteService(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Service> serviceList = serviceBO.findAll();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/service_home.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Service service=null;
        try {
            service =serviceBO.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_service/edit_service.jsp");
        request.setAttribute("service", service);
        dispatcher.forward(request, response);
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
