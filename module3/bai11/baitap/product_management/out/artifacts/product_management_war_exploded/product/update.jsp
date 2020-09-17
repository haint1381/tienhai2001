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
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p style="color: blue">
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input type="text" name="code" value="${product.code}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name"  value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price"  value="${product.price}"></td>
            </tr>
            <tr>
                <td>Brand: </td>
                <td><input type="text" name="brand"  value="${product.brand}"></td>
            </tr>
            <tr>
                <td>${product.code}</td>
                <td><input type="submit" value="Update Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>