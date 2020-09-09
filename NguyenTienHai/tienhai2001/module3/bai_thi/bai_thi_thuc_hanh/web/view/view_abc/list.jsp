<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/9/2020
  Time: 9:55 PM
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
<%@ include file="/view/common/header.jsp"%>
<div class="container-fluid" >
    <div class="row" >
        <h1 style="margin-left: 40%">List</h1>
    </div>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-6"  >
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>
                        <a href="" role="button" class="btn" style="color: #0e11ff;border-radius: 5px;border: 1px solid #0e11ff">Edit</a>
                        <!-- Button trigger modal -->
                        <button type="button" class="btn"  onclick="callModal1(this.id)" id="" style="color: red;border-radius: 5px;border: 1px solid red">
                            Delete
                        </button>
                    </td>
                </tr>
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
<script>
    function callModal1(id) {
        document.getElementById("modalDelete").href="/customer?action=delete&id="+id;
    }
</script>
</html>
