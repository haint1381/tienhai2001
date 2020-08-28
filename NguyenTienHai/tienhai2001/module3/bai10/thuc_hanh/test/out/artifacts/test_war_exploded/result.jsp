<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/28/2020
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result: <%=request.getParameter("username")%></h1>
<h1>Total: <%=request.getAttribute("totalAbc")%></h1>

<a href="index.jsp">Click to index</a>
</body>
</html>
