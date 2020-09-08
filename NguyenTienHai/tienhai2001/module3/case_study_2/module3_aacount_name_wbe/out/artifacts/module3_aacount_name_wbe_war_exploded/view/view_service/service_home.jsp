<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/6/2020
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../bootstrap-4.5.2-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap4.min.css">
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
                        <li class="page-item"><a class="page-link" href="/service"><kbd>List Service</kbd></a></li>
                    </ul>
                </nav>
            </h1>
        </div>
        <div class="col-md-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4">
            <form action="/service" method="get">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Add New Service" style="background-color: chartreuse">
            </form>
        </div>
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
        </div>
    </div>
    <table class="table table-striped table-hover table-bordered" id="tableStudent">
        <thead class="thead">
        <tr class="table-dark">
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Area</th>
            <th scope="col">Cost</th>
            <th scope="col">Max PeoPle</th>
            <th scope="col">Rent Type Id</th>
            <th scope="col">service Type Id</th>
            <th scope="col">Standard Room</th>
            <th scope="col">Description Orther Convenience</th>
            <th scope="col">Pool Area</th>
            <th scope="col">Numer Of Floors</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${serviceList}">
        <tr>
        <td><c:out value="${service.service_id}"/></td>
        <td><c:out value="${service.service_name}"/></td>
        <td><c:out value="${service.service_area}"/></td>
        <td><c:out value="${service.service_cost}"/></td>
        <td><c:out value="${service.service_max_people}"/></td>
        <td><c:out value="${service.rent_type_id}"/></td>
        <td><c:out value="${service.service_type_id}"/></td>
        <td><c:out value="${service.standard_room}"/></td>
        <td><c:out value="${service.description_other_convenience}"/></td>
        <td><c:out value="${service.pool_area}"/></td>
        <td><c:out value="${service.number_of_floors}"/></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableStudent').DataTable({
            "dom":'lrtip',
            "lengthChange":false,
            "pageLength":5
        });
    } );
</script>
</html>
