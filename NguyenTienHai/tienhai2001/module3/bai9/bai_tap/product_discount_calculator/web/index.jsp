<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/26/2020
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form action="display-discount" method="post">
  <label>Product Description: </label><br/>
  <input type="text" name="description" placeholder="DESCRIPTION"/><br/>
  <label>List Price: </label><br/>
  <input type="text" name="price" placeholder="PRICE" value="0"/><br/>
  <label>Discount Percent: </label><br/>
  <input type="text" name="percent" placeholder="PERCENT" value="0"/><br/>
  <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>