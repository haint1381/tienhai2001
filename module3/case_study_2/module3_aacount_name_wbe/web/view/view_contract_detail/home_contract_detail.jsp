<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/7/2020
  Time: 4:12 PM
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
<%@ include file="../common/header.html"%>
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
                        <li class="page-item"><a class="page-link" href="/contractDetail"><kbd>List Contract Detail</kbd></a></li>
                    </ul>
                </nav>
            </h1>
        </div>
        <div class="col-md-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4">
            <form action="/contractDetail" method="get">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Add New Contract Detail" style="background-color: chartreuse">
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
            <th scope="col">Contract Detail Id</th>
            <th scope="col">Contract Id</th>
            <th scope="col">Attach Service Id</th>
            <th scope="col">Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contractDetail" items="${contractDetailList}">
        <tr>
            <td><c:out value="${contractDetail.contract_detail_id}"/></td>
            <td><c:out value="${contractDetail.contract_id}"/></td>
            <td><c:out value="${contractDetail.attach_service_id}"/></td>
            <td><c:out value="${contractDetail.quantity}"/></td>
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
