<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/16/2020
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/dictionary" method="post">
        <table>
            <tr>
                <td>English</td>
                <td>
                    <input type="text" name="english" placeholder="english" value="">
                </td>
            </tr>
            <tr>
                <td>Vietnam</td>
                <td>
                    <input type="text" value="${vietnam}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="oke">
                    <form method="get">
                        <a href="/dictionary" role="button">reset</a>
                    </form>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
