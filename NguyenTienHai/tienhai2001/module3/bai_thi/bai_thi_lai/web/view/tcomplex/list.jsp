<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/12/2020
  Time: 3:54 PM
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
<%@ include file="/view/common/header.jsp"%>
<div class="container-fluid" >
    <div class="row" >
        <div class="col-md-3">
        </div>
        <div class="col-md-2">
            <form action="/rentalSpaceManagement" method="get">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Add" style="border: 1px solid #00ff13 ; border-radius: 5px">
            </form>

        </div>
        <div class="col-md-7">
            <h1>List </h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1">
        </div>
        <div class="col-md-7"  >
            <table class="table table-striped table-hover table-bordered">
                <thead class="thead">
                <tr>
                    <th scope="col">Id Rental Space Management</th>
                    <th scope="col">statusName</th>
                    <th scope="col">acreage</th>
                    <th scope="col">floors</th>
                    <th scope="col">typeOfPremises</th>
                    <th scope="col">price</th>
                    <th scope="col">startDay</th>
                    <th scope="col">endDate</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                 <c:forEach  var="element" items="${rentalSpaceManagementList}">
                    <tr>
                        <td><c:out value="${element.id}"/></td>
                        <td><c:out value="${element.statusName}"/></td>
                        <td><c:out value="${element.acreage}"/></td>
                        <td><c:out value="${element.floors}"/></td>
                        <td><c:out value="${element.typeOfPremises}"/></td>
                        <td><c:out value="${element.price}"/></td>
                        <td><c:out value="${element.startDay}"/></td>
                        <td><c:out value="${element.endDate}"/></td>
                        <td>
                            <button type="button"class="btn" data-toggle="modal" data-target="#exampleModal" onclick="callModal1(this.id)" id="${element.id}" style="color: red;border-radius: 5px;border: 1px solid red">
                                Delete
                            </button>
                        </td>
                    </tr>
                 </c:forEach>
                </tbody>
            </table>
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
    </div>
</div>

<%@ include file="/view/common/footer.jsp"%>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script>
    function callModal1(id) {
        document.getElementById("modalDelete").href="/rentalSpaceManagement?action=delete&id="+id;
    }
</script>
</html>
