<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/6/2020
  Time: 6:58 PM
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
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="/employee"><kbd>List Employee</kbd></a></li>
                    </ul>
                </nav>
            </h1>
        </div>
        <div class="col-md-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4">
            <form action="/employee" method="get">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Add Employee" style="background-color: chartreuse">
            </form>
        </div>
        <div class="col-md-4">

        </div>
        <div class="col-md-3">
            <form action="/employee">
                <input type="hidden" name="action" value="search">
                <input type="text" name="name">
                <input type="submit" value="Search" style="background-color: chartreuse">
            </form>
        </div>
    </div>
    <table class="table table-striped table-hover table-bordered">
        <thead class="thead">
        <tr class="table-dark">
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Id Card</th>
            <th scope="col">Salary</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Position Id</th>
            <th scope="col">Education Degree Id</th>
            <th scope="col">Division Id</th>
            <th scope="col">User Name</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td><c:out value="${employee.employee_id}"/></td>
            <td><c:out value="${employee.employee_name}"/></td>
            <td><c:out value="${employee.employee_birthday}"/></td>
            <td><c:out value="${employee.employee_id_card}"/></td>
            <td><c:out value="${employee.employee_salary}"/></td>
            <td><c:out value="${employee.employee_phone}"/></td>
            <td><c:out value="${employee.employee_email}"/></td>
            <td><c:out value="${employee.employee_address}"/></td>
            <td><c:out value="${employee.position_id}"/></td>
            <td><c:out value="${employee.education_degree_id}"/></td>
            <td><c:out value="${employee.division_id}"/></td>
            <td><c:out value="${employee.username}"/></td>
            <td>
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="/employee?action=edit&id=${employee.employee_id}">Edit</a></li>
                    </ul>
                </nav>
            </td>
            <td>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                    Delete
                </button>

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
                                <div style="margin-top: 4%">
                                    <nav aria-label="Page navigation example">
                                        <ul class="pagination">
                                            <li class="page-item "><a class="page-link" href="/employee?action=delete&id=${employee.employee_id}">Save changes</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
