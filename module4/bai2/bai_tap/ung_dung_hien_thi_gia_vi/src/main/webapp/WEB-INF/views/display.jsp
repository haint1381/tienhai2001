<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/20/2020
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post">
        <h1>Sandwich Condiments</h1>
        <input type="checkbox" id="lettuce" name="menu" value="Lettuce">
        <label for="lettuce">Lettuce</label>
        <input type="checkbox" id="tomato" name="menu" value="Tomato">
        <label for="tomato">Tomato</label>
        <input type="checkbox" id="mustard" name="menu" value="Mustard">
        <label for="mustard">Mustard</label>
        <input type="checkbox" id="sprouts" name="menu" value="Sprouts">
        <label for="sprouts">Sprouts</label><hr>
        <input type="submit" value="Save">
    </form>
    <c:forEach var="element" items="${list}">
        <h1>${element}</h1>
    </c:forEach>
    <h1>${mess}</h1>
</div>
</body>
</html>
