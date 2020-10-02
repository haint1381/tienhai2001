<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/7/2020
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <link rel="stylesheet" href="../../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../common/header.html"%>
<div CLASS="container-fluid"  style="background-color: #9fcdff">
    <div class="row">
        <div class="col-md-4">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/furama">Home</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-5">
            <h1>
                <a href="/customer?action=customersUsingTheService" role="button" class="btn btn-danger">Customer Using The Service</a>
            </h1>
        </div>
        <div class="col-md-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/customer">Back</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-md-4">
        </div>
        <div class="col-md-3">
            <form action="/customer">
                <input type="hidden" name="action" value="searchUsing">
                <input type="text" name="name">
                <input type="submit" value="Search" style="background-color: chartreuse">
            </form>
        </div>
    </div>
    <table class="table table-striped table-hover table-bordered">
        <thead class="thead">
        <tr class="table-dark">
            <th scope="col">ID Customer</th>
            <th scope="col">Customer Name</th>
            <th scope="col">Service ID</th>
            <th scope="col">Service Name</th>
            <th scope="col">Contract ID</th>
            <th scope="col">Attach Service ID</th>
            <th scope="col">Attach Service Name</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        <c:forEach var="customer" items="${customerUsingServiceList}">
        <tr>
            <td><c:out value="${customer.customer_id}"/></td>
            <td><c:out value="${customer.customer_name}"/></td>
            <td><c:out value="${customer.service_id}"/></td>
            <td><c:out value="${customer.service_name}"/></td>
            <td><c:out value="${customer.contract_id}"/></td>
            <td><c:out value="${customer.attach_service_id}"/></td>
            <td><c:out value="${customer.attach_service_name}"/></td>

            <td>
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="/service?action=edit&id=${customer.service_id}">Edit Service</a></li>
                    </ul>
                </nav>
            </td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" onclick="callModal1(this.id)" id="${customer.service_id}" data-target="#exampleModal">
                    Delete Service
                </button>
            </td>
        </tr>
        </c:forEach>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you really want to delete it or not ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <a href="#" id="modalDelete" role="button" class="btn btn-danger">Delete Service</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script>
    function callModal1(id) {
        document.getElementById("modalDelete").href="/service?action=delete&id="+id;
    }
</script>
</html>

