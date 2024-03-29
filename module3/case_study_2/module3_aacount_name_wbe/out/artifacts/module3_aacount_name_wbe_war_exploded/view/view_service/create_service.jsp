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
</head>
<body>
<%@ include file="../common/header.html"%>
<form method="post">
    <div class="container-fluid">
        <div class="row" style="background-color:#8aafff ">
            <div class="col-md-4">
                <div class="row">
                    <img src="../image/06-2.jpg" height=70% width=100% />
                </div>
                <div class="row">
                    <h3> KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI FURAMA ĐÀ NẴNG, TỰ HÀO LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM</h3>
                    Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ đến với 3 di sản văn hoá thế giới:
                    Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt thự từ hai đến bốn phòng ngủ
                    có hồ bơi riêng đều được trang trí trang nhã, theo phong cách thiết kế truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp,
                    biến Furama thành khu nghỉ dưỡng danh giá nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách,
                    ngôi sao điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.
                </div>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="alert alert-success col-md-12" role="alert" >
                        <p><c:out value="${message}"/></p>
                    </div>
                </div>
                <div class="row">
                    <div class="card-body">
                        <h5 class="card-title text-center">Add New Service</h5>
                        <form class="form-signin">
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message1}"/></p>
                                <input type="text" class="form-control" name="service_id" placeholder="Service Id" required autofocus>
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="service_name" placeholder="Service Name" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message2}"/></p>
                                <input type="text" class="form-control" name="service_area" placeholder="Service Area" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message3}"/></p>
                                <input type="text" class="form-control" name="service_cost" placeholder="Service Cost" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message4}"/></p>
                                <input type="text" class="form-control" name="service_max_people" placeholder="Service Max People" min="1" max="20" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" class="form-control" name="rent_type_id" placeholder="Rent Type Id" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="service_type_id" placeholder="Service Type Id" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="standard_room" placeholder="Standard Room" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="description_other_convenience" placeholder="Description Other Convenience" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message5}"/></p>
                                <input type="text" class="form-control" name="pool_area" placeholder="Pool Area" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message6}"/></p>
                                <input type="text" class="form-control" name="number_of_floors" placeholder="Number Of Floors" required>
                            </div><br>
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Add Service</button><br>
                            <div class="col-md-12">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="/service">Back</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
<script src="../../bootstrap-4.5.2-dist/jquery-3.5.1.min.js"></script>
<script src="../../bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</html>
