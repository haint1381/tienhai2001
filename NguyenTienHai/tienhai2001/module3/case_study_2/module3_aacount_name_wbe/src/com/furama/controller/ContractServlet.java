package com.furama.controller;

import com.furama.bo.contract_bo.ContractBO;
import com.furama.bo.contract_bo.IContractBO;
import com.furama.model.Contract;
import com.furama.model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet",urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private IContractBO contractBO =new ContractBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertContract(request, response);
                break;
        }
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {

        int contract_id=Integer.parseInt(request.getParameter("contract_id"));
        String contract_start_date=request.getParameter("contract_start_date");
        String contract_end_date=request.getParameter("contract_end_date");
        double contract_deposit=Double.parseDouble(request.getParameter("contract_deposit"));
        double contract_total_money=Double.parseDouble(request.getParameter("contract_total_money"));
        int employee_id=Integer.parseInt(request.getParameter("employee_id"));
        int customer_id=Integer.parseInt(request.getParameter("customer_id"));
        int service_id=Integer.parseInt(request.getParameter("service_id"));
        Contract contract=new  Contract(contract_id, contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id);
        contractBO.create(contract);
        request.setAttribute("message","successfully added!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_contract/create_contract.jsp");
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
                listContract(request, response);
                break;
        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractBO.findAll();
        request.setAttribute("contractList", contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_contract/home_contract.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_contract/create_contract.jsp");
        dispatcher.forward(request, response);
    }
}
