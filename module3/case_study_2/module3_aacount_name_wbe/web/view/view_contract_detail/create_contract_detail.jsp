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
</head>
<body>
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
                    <p>
                        <c:if test='${requestScope["message"] != null}'>
                            <span class="message">${requestScope["message"]}</span>
                        </c:if>
                        <c:if test='${requestScope["message"] = null}'>
                            <span class="message">new addition was not successful!</span>
                        </c:if>
                    </p>
                </div>
                <div class="row">
                    <div class="card-body">
                        <h5 class="card-title text-center">Add New Employee</h5>
                        <form class="form-signin">
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="contract_detail_id" placeholder="Contract Detail Id" required >
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="contract_id" placeholder="Contract Id" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="attach_service_id" placeholder="Attach Service Id"  required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="quantity" placeholder="Quantity" required>
                            </div><br>
                            <div class="col-md-12">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="/contractDetail">Back</a></li>
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
