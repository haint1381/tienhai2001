<%--
  Created by IntelliJ IDEA.
  User: PC
  Date:9/11/2020
  Time: 9:32 PM
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
<%@ include file="/view/common/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-2">
            <form action="/product" method="get">
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Add" style="border: 1px solid #00ff13 ; border-radius: 5px">
            </form>
        </div>
        <div class="col-md-7">
            <p style="color: #06ff00"><c:out value="${massage}"/></p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-6">
            <div class="card">
                <h3 class="card-header text-center font-weight-bold text-uppercase py-4">List Product</h3>
                <div class="card-body">
                    <div id="table" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i
              class="fas fa-plus fa-2x" aria-hidden="true"></i></a></span>
                        <table class="table table-bordered table-responsive-md table-striped text-center">
                            <thead class="thead">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name Product</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Color</th>
                                <th scope="col">Description</th>
                                <th scope="col">Category</th>
                                <th scope="col">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="product" items="${productList}">
                                <tr>
                                    <td class="pt-3-half"  contenteditable="true" id="id"><c:out value="${product.id}"/></td>
                                    <td class="pt-3-half" contenteditable="true"  name="nameProduct"><c:out value="${product.nameProduct}"/></td>
                                    <td class="pt-3-half" contenteditable="true"  name="price"><c:out value="${product.price}"/></td>
                                    <td class="pt-3-half" contenteditable="true"  name="amount"><c:out value="${product.amount}"/></td>
                                    <td class="pt-3-half" contenteditable="true"  name="color"><c:out value="${product.color}"/></td>
                                    <td class="pt-3-half" contenteditable="true"  name="description"><c:out value="${product.description}"/></td>
                                    <td class="pt-3-half" contenteditable="true"  name="category">
                                        <select name="category" class="form-control">
                                        <c:forEach var="category" items="${categoryList}">
                                            <option ><c:out value="${category.name}"/></option>
                                        </c:forEach>
                                    </select></td>
                                    <td>
                                        <a href="/product?action=edit&id=${product.id}" role="button" class="btn" style="color: #0e11ff;border-radius: 5px;border: 1px solid #0e11ff">Edit</a>
                                        <!-- Button trigger modal -->
                                        <button type="button" class="btn" data-toggle="modal" data-target="#exampleModal" onclick="callModal1(this.id)" id="${product.id}" style="color: red;border-radius: 5px;border: 1px solid red">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Editable table -->


            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
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
<%@ include file="/view/common/footer.jsp" %>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script>
    function callModal1(id) {
        document.getElementById("modalDelete").href = "/product?action=delete&id=" + id;
    }
</script>
</html>
