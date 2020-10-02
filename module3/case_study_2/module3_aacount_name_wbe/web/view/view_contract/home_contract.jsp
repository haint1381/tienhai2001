<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/7/2020
  Time: 3:42 PM
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
                        <li class="page-item"><a class="page-link" href="/contract"><kbd>List Contract</kbd></a></li>
                    </ul>
                </nav>
            </h1>
        </div>
        <div class="col-md-3"></div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4">
            <form action="/contract" method="get">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Add New Contract" style="background-color: chartreuse">
            </form>
        </div>
        <div class="col-md-4">
            <a href="/contractDetail" role="button" class="btn btn-danger">Contract Detail</a>
        </div>
        <div class="col-md-4">
        </div>
    </div>
    <table class="table table-striped table-hover table-bordered" id="tableStudent">
        <thead class="thead">
        <tr class="table-dark">
            <th scope="col">ID</th>
            <th scope="col">Start Date</th>
            <th scope="col">End Date</th>
            <th scope="col">Deposit</th>
            <th scope="col">Total Money</th>
            <th scope="col">Employee Id</th>
            <th scope="col">Customer Id</th>
            <th scope="col">Service Id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contract" items="${contractList}">
        <tr>
            <td><c:out value="${contract.contract_id}"/></td>
            <td><c:out value="${contract.contract_start_date}"/></td>
            <td><c:out value="${contract.contract_end_date}"/></td>
            <td><c:out value="${contract.contract_deposit}"/></td>
            <td><c:out value="${contract.contract_total_money}"/></td>
            <td><c:out value="${contract.employee_id}"/></td>
            <td><c:out value="${contract.customer_id}"/></td>
            <td><c:out value="${contract.service_id}"/></td>
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
