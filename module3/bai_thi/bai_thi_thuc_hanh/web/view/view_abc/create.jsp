<%--
  Created by IntelliJ IDEA.
  User: PC
  Date:9/11/2020
  Time: 9:37 PM
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
<form method="post">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="card-body">
                <div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="/product">Back</a></li>
                        </ul>
                    </nav>
                </div>
                <p style="color: #06ff00"><c:out value="${message}"/></p>
                <h5 class="card-title text-center">Add New Product</h5>
                <form class="form-signin">
                    <div class="form-label-group">
                        <h4>Id</h4><input type="number" class="form-control" name="id" placeholder="id" required autofocus>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Name Product</h4><input type="text" class="form-control" name="nameProduct" placeholder="nameProduct" >
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>price</h4><input type="number" class="form-control" name="price" placeholder="price" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Quantity</h4><input type="number" class="form-control" name="amount" placeholder="amount" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Color</h4><input type="text" class="form-control" name="color" placeholder="color" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Description</h4><input type="text" class="form-control" name="description" placeholder="description" required>
                    </div>
                    <br>
                    <div class="form-label-group">
                        <h4>Category</h4>
                        <select name="category" class="form-control">
                            <c:forEach var="category" items="${categoryList}">
                                <option ><c:out value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Add</button>
                    <br>
                </form>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</form>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
