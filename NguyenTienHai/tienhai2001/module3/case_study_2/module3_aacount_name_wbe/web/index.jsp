<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/2/2020
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="bootstrap-4.5.2-dist/css/bootstrap.min.css">
    <style>
      body{
        font-family: sans-serif;
      }
      .header ul li{
        color: #1350a9;
        display: inline-table;
        width: 120px;
        height: 40px;
        line-height: 40px;
      }
      .header ul li a{
        color: #585858;
        text-decoration: none;
        display: block;
      }
      .header ul li a:hover {
        background: #45f453;
        color: white;
        text-decoration: none;
      }
      .menu ul{
        list-style-type: none;
        color: #1350a9;
        background-color: white;
        display: block;
      }

      .footer {
        background: #616e82;
        font-size: 20px;
        color: white;
        text-align: center;
        height: 100px;
      }
      * {
        box-sizing: border-box;
      }
    </style>
  </head>
  <body>
  <div class="container-fluid">
    <div class="row" style="background: #4752f4">
      <div class="col-md-8">
        <img src="image/logo.png" height=70 width=70 />
      </div>
      <div class="col-md-4">
        <h3 style="color: #ffffff;padding-left: 30%">Nguyễn Tiến Hải</h3>
      </div>
    </div>
    <div class="row" style="background-color: #b3d7ff">
      <div class="header col-md-8" style="text-align: center">
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#">Employee</a></li>
          <li><a href="#">Customer</a></li>
          <li><a href="#">Service</a></li>
          <li><a href="#">Contract</a></li>
        </ul>
      </div>
      <div class="col-md-4">
        <div class="row">
          <div class="col-md-6"> <input type="text" style="border-radius: 5px"></div>
          <div class="col-md-6"><input type="submit" value="search" style="background-color: chartreuse"></div>
        </div>
      </div>
    </div>
    <div class="row" style="height: 300px">
      <div class="col-md-3" style="background: #8aafff"></div>
      <div class="col-md-9" style="background: #dff7ff"></div>
    </div>
    <div class="footer row" >

    </div>
  </div>
  </body>
  <script src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>