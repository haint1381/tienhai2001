<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/4/2020
  Time: 9:56 AM
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
<%@ include file="../common/header.jsp"%>
<div CLASS="container-fluid"  style="background-color: #9fcdff">
    <div class="row">
        <div class="col-md-5">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="/furama">Home</a></li>
            </ul>
        </nav>
        </div>
        <div class="col-md-4">
            <h1>
                <a role="button" href="/customer" class="btn btn-danger">List Customer</a>
            </h1>
        </div>
        <div class="col-md-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4">
            <form action="/customer" method="get">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Add Customer" style="background-color: chartreuse">
            </form>
        </div>
        <div class="col-md-4">
            <a role="button" href="/customer?action=customersUsingTheService" class="btn btn-danger">Customers Using The Service</a>
        </div>
        <div class="col-md-3">
            <form action="/customer">
                <input type="hidden" name="action" value="search">
                <input type="text" name="name">
                <input type="submit" value="Search" style="background-color: chartreuse">
            </form>
        </div>
    </div>
    <table class="table table-striped table-hover table-bordered">
        <thead class="thead">
        <tr class="table-dark">
            <th scope="col">ID</th>
            <th scope="col">Customer Type ID</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Gender</th>
            <th scope="col">Id Card</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><c:out value="${customer.type_id}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.birthday}"/></td>
            <td><c:out value="${customer.gender}"/></td>
            <td><c:out value="${customer.id_card}"/></td>
            <td><c:out value="${customer.phone}"/></td>
            <td><c:out value="${customer.email}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td>
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="/customer?action=edit&id=${customer.id}">Edit</a></li>
                    </ul>
                </nav>
            </td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" onclick="callModal1(this.id)" id="${customer.id}" data-target="#exampleModal">
                    Delete
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
                    <a href="#" id="modalDelete" role="button" class="btn btn-danger">delete</a>
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
        document.getElementById("modalDelete").href="/customer?action=delete&id="+id;
    }
</script>
</html>

