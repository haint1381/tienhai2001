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
<form method="post">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="card-body">
                    <div>
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="/rentalSpaceManagement">Back</a></li>
                            </ul>
                        </nav>
                    </div>
                    <h5 class="card-title text-center">Add New </h5>
                    <form class="form-signin">
                        <div class="form-label-group">
                            <h4>id</h4><input type="text" class="form-control" name="id" placeholder="id" required>
                        </div>
                        <br>
                        <div class="form-label-group">
                            <h4>statusName</h4>
                            <select name="statusName" class="form-control">
                                <option >trống</option>
                                <option >hạ tầng</option>
                                <option >đầy đủ</option>
                            </select>
                        </div>
                        <br>
                        <div class="form-label-group">
                            <h4>acreage</h4><input type="text" class="form-control" name="acreage" placeholder="acreage" required>
                        </div>
                        <br>
                        <div class="form-label-group">
                            <h4>floors</h4>
                            <select name="floors" class="form-control">
                                <option >tầng 1</option>
                                <option >tầng 2</option>
                                <option >tầng 3</option>
                                <option >tầng 4</option>
                                <option >tầng 5</option>
                                <option >tầng 6</option>
                                <option >tầng 7</option>
                                <option >tầng 8</option>
                                <option >tầng 9</option>
                                <option >tầng 10</option>
                                <option >tầng 11</option>
                                <option >tầng 12</option>
                                <option >tầng 13</option>
                                <option >tầng 14</option>
                                <option >tầng 15</option>
                            </select>
                        </div>
                        <br>
                        <div class="form-label-group">
                            <h4>typeOfPremises</h4>
                            <select name="typeOfPremises" class="form-control">
                                <option >văn phòng</option>
                                <option >văn phòng chia sẻ</option>
                                <option >văn phòng trọn gói</option>
                            </select>
                        </div>
                        <br>
                        <div class="form-label-group">
                            <h4>price</h4><input type="number" class="form-control" name="price" placeholder="price" required min="1000000">
                        </div>
                        <br>
                        <div class="form-label-group">
                            <h4>startDay</h4><input type="date" class="form-control" name="startDay" placeholder="startDay" required
                                                    pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
                        </div>
                        <br>
                        <div class="form-label-group">
                            <h4>endDate</h4><input type="date" class="form-control" name="endDate" placeholder="endDate" required
                                                   pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))">
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
