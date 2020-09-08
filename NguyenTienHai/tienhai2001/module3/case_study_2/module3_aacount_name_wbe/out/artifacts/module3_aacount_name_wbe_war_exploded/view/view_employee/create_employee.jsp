<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/6/2020
  Time: 6:58 PM
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
                                <input type="number" class="form-control" name="employee_id" placeholder="Employee Id" required >
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="employee_name" placeholder="Employee Name" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="date"  class="form-control" name="employee_birthday" placeholder="Employee Birthday" required pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31)">
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="employee_id_card" placeholder="Employee Id Card" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="employee_salary" placeholder="Employee Salary"  required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="tel" class="form-control" class="form-control" name="employee_phone" placeholder="Employee Phone" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="email" class="form-control" name="employee_email" placeholder="Employee Email" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="employee_address" placeholder="Employee Address" required>
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="position_id" placeholder="Position Id" required min="1" max="6">
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="education_degree_id" placeholder="Education Degree Id" required min="1" max="4">
                            </div><br>
                            <div class="form-label-group">
                                <input type="number" class="form-control" name="division_id" placeholder="Division Id" required min="1" max="4">
                            </div><br>
                            <div class="form-label-group">
                                <input type="text" class="form-control" name="username" placeholder="User Name" required>
                            </div><br>
                            <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Add Employee</button><br>
                            <div class="col-md-12">
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="/employee">Back</a></li>
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
