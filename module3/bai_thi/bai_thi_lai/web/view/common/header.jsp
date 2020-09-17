<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/9/2020
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2 ">
            <img src="../../image/logo.jpg" height="100%" width="40%"/>
        </div>
        <div style="padding-top: 5%" class="col-md-1 ">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/rentalSpaceManagement">Home</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-3" style="padding-top: 5%">
            <form action="/rentalSpaceManagement">
                <input type="hidden" name="action" value="search1">
                <input type="text" name="floors" style="border-radius: 5px">
                <input type="submit" value="Search floors" style="border: 1px solid blue;border-radius: 5px;color: #001cff">
            </form>
        </div>
        <div class="col-md-3" style="padding-top: 5%">
            <form action="/rentalSpaceManagement">
                <input type="hidden" name="action" value="search2">
                <input type="text" name="typeOfPremises" style="border-radius: 5px">
                <input type="submit" value="Search typeOfPremises" style="border: 1px solid blue;border-radius: 5px;color: #001cff">
            </form>
        </div>
        <div class="col-md-3" style="padding-top: 5%">
            <form action="/rentalSpaceManagement">
                <input type="hidden" name="action" value="search3">
                <input type="text" name="price" style="border-radius: 5px">
                <input type="submit" value="Search price" style="border: 1px solid blue;border-radius: 5px;color: #001cff">
            </form>
        </div>
    </div>
    <hr>
</div>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
