<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/20/2020
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/computer" method="post">
    <table>
        <tr>
            <td>number 1</td>
            <td>
                <input type="number" name="number1" placeholder="number1" value="${number1}">
            </td>
        </tr>
        <tr>
            <td>number 2</td>
            <td>
                <input type="number" name="number2" placeholder="number2" value="${number2}">
            </td>
        </tr>
        <tr>
            <td>answer</td>
            <td>
                <input type="number" value="${answer}">
            </td>
        </tr>
        <tr>
            <td>
                <form method="get">
                    <a href="${pageContext.request.contextPath}/computer" role="button">reset</a>
                </form>
            </td>
            <td>
                <input type="submit" name="action" value="+">
                <input type="submit" name="action" value="-">
                <input type="submit" name="action" value="*">
                <input type="submit" name="action" value="/">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
