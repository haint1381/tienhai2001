<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/4/2020
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Furama Resort</title>
    <script src="../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="common/header.jsp"%>
<nav class="navbar navbar-light" style="background-color: #046056">
    <ul class="nav ">
        <li class="nav-item my-2">
            <a class="nav-link active" href="#">Home</a>
        </li>
        <li class="nav-item my-2">
            <a class="nav-link" href="/furama?action=employee">Employee</a>
        </li>
        <li class="nav-item my-2">
            <a class="nav-link" href="/furama?action=customer">Customer</a>
        </li>
        <li class="nav-item my-2">
            <a class="nav-link" href="/furama?action=service">Service</a>
        </li>
        <li class="nav-item my-2">
            <a class="nav-link" href="#">Contract</a>
        </li>
    </ul>
    <div class="col-md-6">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" data-interval="1">
                    <img src="../image/anh_qc_3.jpg" height="153" class="d-block w-100" width="329" alt="..."/>
                </div>
                <div class="carousel-item">
                    <img src="../image/images.jpg" height="153" width="329" class="d-block w-100" alt="..."/>
                </div>
                <div class="carousel-item">
                    <img src="../image/images (1).jpg" height="153" class="d-block w-100" width="329" alt="..."/>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <form class="form-inline">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>
</body>
<script src="../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
