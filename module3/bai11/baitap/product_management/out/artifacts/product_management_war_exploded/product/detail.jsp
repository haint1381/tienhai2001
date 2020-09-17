<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/30/2020
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/product">Back to Product list</a>
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
