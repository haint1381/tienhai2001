package com.furama.controller;

import com.furama.bo.contract_bo.ContractBO;
import com.furama.bo.contract_bo.IContractBO;
import com.furama.bo.contract_detail_bo.ContractDetailBO;
import com.furama.bo.contract_detail_bo.IContractDetailBO;
import com.furama.dao.contract_detail_dao.IContractDetailDAO;
import com.furama.model.Contract;
import com.furama.model.ContractDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet",urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    private IContractDetailBO contractDetailBO =new ContractDetailBO();

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

        int contract_detail_id=Integer.parseInt(request.getParameter("contract_detail_id"));
        int contract_id=Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id=Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));

        ContractDetail contractDetail=new ContractDetail(contract_detail_id,contract_id,attach_service_id,quantity);
        contractDetailBO.create(contractDetail);
        request.setAttribute("message","successfully added!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_contract_detail/create_contract_detail.jsp");
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
        List<ContractDetail> contractDetailList = contractDetailBO.findAll();
        request.setAttribute("contractDetailList", contractDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_contract_detail/home_contract_detail.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_contract_detail/create_contract_detail.jsp");
        dispatcher.forward(request, response);
    }
}
