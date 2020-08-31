<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/30/2020
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Product</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/product">Back to Product list</a>
</p>
<p style="color: blue">
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<table>
    <tr>
        <td>Code: </td>
        <td>${product.code}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>Brand: </td>
        <td>${product.brand}</td>
    </tr>
</table>
</body>
</html>
