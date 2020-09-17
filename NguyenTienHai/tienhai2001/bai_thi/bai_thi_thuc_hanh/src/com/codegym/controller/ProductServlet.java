package com.codegym.controller;

import com.codegym.bo.CategoryBO;
import com.codegym.bo.ICategoryBO;
import com.codegym.bo.IProductBO;
import com.codegym.bo.ProductBO;
import com.codegym.model.Category;
import com.codegym.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "productServlet", urlPatterns = {"", "/product"})
public class ProductServlet extends HttpServlet {
    IProductBO productBO = new ProductBO();
    ICategoryBO categoryBO = new CategoryBO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
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
        int id = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("nameProduct");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        Product product = new Product(id, nameProduct, price, amount, color, description, category);
        productBO.create(product);
        request.setAttribute("message", "successfully added!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_abc/create.jsp");
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
                try {
                    edit(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "search":
                try {
                    search(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("nameProduct");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        Product product = new Product(id, nameProduct, price, amount, color, description, category);

        productBO.updateProduct(product);
        List<Product> productList = productBO.findAll();
        request.setAttribute("productList", productList);
        request.setAttribute("massage", "successfully update!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_abc/list.jsp");
        dispatcher.forward(request, response);
    }




    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productBO.deleteProduct(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Product> productList = productBO.findAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_abc/list.jsp");
        dispatcher.forward(request, response);
    }

    //tìm kiếm
    private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> productList = productBO.findByName(name);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_abc/list.jsp");
        dispatcher.forward(request, response);
    }

    // trả về home
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);
        List<Product> productList = productBO.findAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_abc/list.jsp");
        dispatcher.forward(request, response);
    }

    //trang tạo mới
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = categoryBO.findAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/view_abc/create.jsp");
        dispatcher.forward(request, response);
    }
}
