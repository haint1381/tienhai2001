<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/21/2020
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="get" action="/updateForm" modelAttribute="settings">
    <h2>Updated</h2>
    <table>
        <tr>
            <td>Language :</td>
            <td>${settings.languages}</td>
        </tr>
        <tr>
            <td>Page Size :</td>
            <td>${settings.pageSize}</td>
        </tr>
        <tr>
            <td>Spams Filter :</td>
            <td>${settings.spamsFilter}</td>
        </tr>
        <tr>
            <td>Signature :</td>
            <td>${settings.signature}</td>
        </tr>
        <tr>
            <td style="collapse: 2">
                <input type="submit" value="update">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
