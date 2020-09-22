<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/21/2020
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="post" action="/updateSetting" modelAttribute="settings">
    <table>
        <tr>
            <td>languages:</td>
            <td><form:select path="languages" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td><form:select path="pageSize" items="${listPageSize}"/></td>
        </tr>
        <tr>
            <td>Spams Filter:</td>
            <td><form:checkbox path="spamsFilter" value="Enable"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/setting/updateForm" style="text-decoration: none">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
