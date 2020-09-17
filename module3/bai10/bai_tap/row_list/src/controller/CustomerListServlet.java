package controller;

import models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controller.CustomerListServlet",urlPatterns = "/customer")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> rowList= new ArrayList<>();
        rowList.add (new Customer("Nguyễn Tiến Hải","13/08/2001","Hà Tĩnh","image/20-30-07-Surface_Home_Hero_20_mosaic_block1-image-2_V4_en-us.jpg"));
        rowList.add (new Customer("Nguyễn Tiến Hải","13/08/2001","Hà Tĩnh", "image/20-30-07-Surface_Home_Hero_20_mosaic_block1-image-2_V4_en-us.jpg"));
        rowList.add (new Customer("Nguyễn Tiến Hải","13/08/2001","Hà Tĩnh", "image/20-30-07-Surface_Home_Hero_20_mosaic_block1-image-2_V4_en-us.jpg"));
        rowList.add (new Customer("Nguyễn Tiến Hải","13/08/2001","Hà Tĩnh", "image/20-30-07-Surface_Home_Hero_20_mosaic_block1-image-2_V4_en-us.jpg"));
        rowList.add (new Customer("Nguyễn Tiến Hải","13/08/2001","Hà Tĩnh", "image/20-30-07-Surface_Home_Hero_20_mosaic_block1-image-2_V4_en-us.jpg"));

        String m1="<img src='image/20-30-07-Surface_Home_Hero_20_mosaic_block1-image-2_V4_en-us.jpg'>";
        request.setAttribute("ListServlet",rowList);

        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}