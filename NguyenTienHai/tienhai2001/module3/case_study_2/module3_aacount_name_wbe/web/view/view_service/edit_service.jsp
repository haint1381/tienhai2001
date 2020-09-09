<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/7/2020
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
    <style>
        .message{
            color:green;
        }
    </style>
    <link rel="stylesheet" href="../../bootstrap-4.5.2-dist/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../common/header.jsp"%>
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
                    <div class="card-body">
                        <h5 class="card-title text-center">Edit Service</h5>
                        <form class="form-signin">
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="service_id" value="${service.service_id}" placeholder="${service.service_id}" required  readonly="true">
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="service_name" placeholder="${service.service_name}" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message1}"/></p>
                                <input type="text" class="form-control" name="service_area" placeholder="${service.service_area}" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message2}"/></p>
                                <input class="form-control" type="text" name="service_cost" placeholder="${service.service_cost}" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message3}"/></p>
                                <input type="text" name="service_max_people" placeholder="${service.service_max_people}" class="form-control" >
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="rent_type_id" placeholder="${service.rent_type_id}" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="service_type_id" placeholder="${service.service_type_id}" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="standard_room" placeholder="${service.standard_room}" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="description_other_convenience" placeholder="${service.description_other_convenience}" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message4}"/></p>
                                <input type="text" class="form-control" name="pool_area" placeholder="${service.pool_area}" required>
                            </div><br>
                            <div class="form-label-group">
                                <p style="color: red"><c:out value="${message5}"/></p>
                                <input type="text" class="form-control" name="number_of_floors" placeholder="${service.number_of_floors}" required>
                            </div><br>

                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                Edit Customer
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
                                            confirm change ?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-primary" value="edit">Save changes</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
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
