<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/28/2020
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Result: <c:out value="${result}"/></h1>
<h1>Total: <%=request.getAttribute("result")%></h1>

<a href="index.jsp">Click to index</a>
</body>
</html>
