<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/9/2020
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3 ">
            <img src="../../image/logo.jpg" height="100%" width="40%"/>
        </div>
        <div class="col-md-5 ">
            <h1 style="padding-top: 10%">Tiến Hải</h1>
        </div>
        <div style="padding-top: 5%" class="col-md-1 ">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/product">Home</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-3" style="padding-top: 5%">
            <form action="/product">
                <input type="hidden" name="action" value="search">
                <input type="text" name="name" style="border-radius: 5px">
                <input type="submit" value="Search" style="border: 1px solid blue;border-radius: 5px;color: #001cff">
            </form>
        </div>
    </div>
    <hr>
</div>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
