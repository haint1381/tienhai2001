<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/16/2020
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/convert" method="post">
    <table>
        <tr>
            <td>Usd</td>
            <td>
                <input type="number" name="usd" placeholder="usd" value="${usd1}">
            </td>
        </tr>
        <tr>
            <td>price</td>
            <td>
                <input type="number" name="price" placeholder="price" value="${price1}">
            </td>
        </tr>
        <tr>
            <td>Vnd</td>
            <td>
                <input type="text" value="${vnd}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="oke">
                <form method="get">
                    <a href="/convert" role="button">reset</a>
                </form>
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
