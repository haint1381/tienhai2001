package com.product.controller;

import com.product.bo.ProductBO;
import com.product.bo.ProductBOImpl;
import com.product.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private  ProductBO productList1 = new ProductBOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createNewProduct(request, response);
                break;
            case "update":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showViewFormDetails(request, response);
                break;
            case "search":
                findByName(request, response);
                break;
            default:
                listProduct(request, response);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productList1.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList =new ArrayList<>();
        String name = request.getParameter("name");
        Product product = null;
        for (int i=0;i<productList1.findAll().size();i++){
            if((name.toLowerCase()).equals(productList1.findAll().get(i).getName().toLowerCase())){
                product = productList1.findAll().get(i);
                productList.add(product);
                break;
            }
        }
        request.setAttribute("products", productList);
        RequestDispatcher dispatcher =request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewFormDetails(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productList1.findByName(id);
        RequestDispatcher dispatcher;
        request.setAttribute("product", product);
        dispatcher = request.getRequestDispatcher("product/detail.jsp");
        try {

            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productList1.findByName(id);
        RequestDispatcher dispatcher;
        request.setAttribute("product", product);
        dispatcher = request.getRequestDispatcher("product/remove.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
            this.productList1.remove(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String brand = request.getParameter("brand");
        Product product = this.productList1.findByName(id);

        RequestDispatcher dispatcher;
        product.setCode(id);
        product.setName(name);
        product.setPrice(price);
        product.setBrand(brand);
        this.productList1.update(id, product);
        request.setAttribute("product", product);
        request.setAttribute("message", "Product information was updated");
        dispatcher = request.getRequestDispatcher("product/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("code"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String brand = request.getParameter("brand");
        Product product = new Product(id, name, price, brand);
        productList1.create(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New Product was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
