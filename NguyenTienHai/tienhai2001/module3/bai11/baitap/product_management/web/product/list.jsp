<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/30/2020
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/product?action=create">Create new Product</a>
</p>
<table border="1">
    <tr>
        <form action="/product">
        <th>Search:</th>
        <td><input type="text"  name="name"></td>
        <td>
            <input name="action" type="submit" value="search" style="color: white;background-color: #0dbe2f;border: 0px;border-radius: 5px;height: 30px">
        </td>
        </form>
    </tr>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Brand</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.code}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.brand}</td>
            <td><a href="/product?action=update&id=${product.code}">Edit</a></td>
            <td><a href="/product?action=delete&id=${product.code}">Delete</a></td>
            <td><a href="/product?action=view&id=${product.code}">Detail</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
